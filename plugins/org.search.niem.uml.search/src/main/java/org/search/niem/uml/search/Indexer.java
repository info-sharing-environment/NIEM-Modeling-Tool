/*
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SEARCH Group, Incorporated - initial API and implementation
 *
 */
package org.search.niem.uml.search;

import static java.util.Arrays.asList;
import static org.eclipse.emf.ecore.util.EcoreUtil.getAllProperContents;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

public class Indexer {

    private final ResourceSet resourceSet;
    private final IndexAccess[] indexAccesses;
    private final NamedElementIndexAccess namedElementIndexAccess;
    private final PropertyIndexAccess propertyIndexAccess;
    private final PackageIndexAccess packageIndexAccess;

    private Indexer(final ResourceSet resourceSet, final NamedElementIndexAccess namedElementIndexAccess,
            final PropertyIndexAccess propertyIndexAccess, final PackageIndexAccess packageIndexAccess) {
        this.resourceSet = resourceSet;
        this.namedElementIndexAccess = namedElementIndexAccess;
        this.propertyIndexAccess = propertyIndexAccess;
        this.packageIndexAccess = packageIndexAccess;
        indexAccesses = new IndexAccess[] { namedElementIndexAccess, propertyIndexAccess, packageIndexAccess };
    }

    public static Indexer create() {
        return create(UMLUtil.init(new ResourceSetImpl()));
    }

    public static Indexer create(final ResourceSet resourceSet) {
        final Indexer indexer = new Indexer(resourceSet, new NamedElementIndexAccess(resourceSet), new PropertyIndexAccess(
                resourceSet), new PackageIndexAccess(resourceSet));
        return indexer;
    }

    public boolean needsIndexing() {
        for (final IndexAccess indexAccess : indexAccesses) {
            if (indexAccess.needsIndexing()) {
                return true;
            }
        }
        return false;
    }

    public void index(final IProgressMonitor monitor) throws IOException {
        monitor.beginTask(Activator.INSTANCE.getString("_UI_NIEM_Indexer_progress_task"),
                org.search.niem.uml.library.Activator.LIBRARY_COUNT);

        try (Closeables<IndexAccess> closeables = new Closeables<>(asList(indexAccesses))) {
            for (final URI uri : org.search.niem.uml.library.Activator.INSTANCE.getReferenceLibraries()) {
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                monitor.subTask(Activator.INSTANCE.getString("_UI_NIEM_Indexer_progress_next_resource", new Object[] { uri
                        .trimFileExtension().lastSegment() }));
                final Iterator<Object> contents = getAllProperContents(resourceSet.getResource(uri, true), true);
                while (contents.hasNext()) {
                    final Object next = contents.next();
                    if (UMLPackage.Literals.ELEMENT.isInstance(next)) {
                        final Element e = (Element) next;
                        for (final IndexAccess indexAccess : indexAccesses) {
                            indexAccess.add(e);
                        }
                    }
                }
                monitor.worked(1);
            }
        } finally {
            monitor.done();
        }
    }

    public Package findByTargetNamespace(final String targetNamespace) {
        final Collection<org.apache.lucene.document.Document> found = packageIndexAccess.search(new Criteria(
                targetNamespace, MatchType.NONE), 1);
        if (found.isEmpty()) {
            return null;
        }

        return (Package) packageIndexAccess.fromDocument(found.iterator().next());
    }

    // TODO: hide the Criteria object and use explicit arguments
    public void collectNamedElements(final Aggregator<?> aggregator, final Criteria criteria) {
        final IndexMatcher indexMatcher = new IndexMatcher(namedElementIndexAccess, aggregator);
        indexMatcher.match(criteria);
    }

    public int countSubstitutions(final String substitutionGroupName) {
        final LazyAggregator aggregator = new LazyAggregator();
        new IndexMatcher(propertyIndexAccess, aggregator).match(new Criteria(substitutionGroupName, MatchType.NONE));
        return aggregator.count();
    }

    public Collection<EObject> findSubstitutions(final String substitutionGroupName) {
        final LazyAggregator aggregator = new LazyAggregator();
        new IndexMatcher(propertyIndexAccess, aggregator).match(new Criteria(substitutionGroupName, MatchType.NONE));
        return aggregator.get();
    }

    private static class Closeables<T extends Closeable> implements Iterable<T>, Closeable {

        private final Iterable<T> delegate;

        Closeables(final Iterable<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public Iterator<T> iterator() {
            return delegate.iterator();
        }

        @Override
        public void close() {
            for (final T a : delegate) {
                try {
                    a.close();
                } catch (final Exception e) {
                    Activator.INSTANCE.log(e);
                }
            }
        }
    }
}
