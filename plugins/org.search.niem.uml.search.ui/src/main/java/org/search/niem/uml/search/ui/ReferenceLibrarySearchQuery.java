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
package org.search.niem.uml.search.ui;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.search.niem.uml.search.Aggregator;
import org.search.niem.uml.search.Criteria;
import org.search.niem.uml.search.Indexer;

public class ReferenceLibrarySearchQuery implements ISearchQuery {

    private final AtomicReference<ReferenceLibrarySearchResult> searchResult = new AtomicReference<>();
    final Criteria criteria;
    private final ResourceSet resourceSet;

    ReferenceLibrarySearchQuery(final Criteria criteria, final ResourceSet resourceSet) {
        this.criteria = criteria;
        this.resourceSet = resourceSet;
    }

    @Override
    public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
        final Indexer indexer = Indexer.create(resourceSet);
        final int libraryCount = org.search.niem.uml.library.Activator.LIBRARY_COUNT;
        final boolean needsIndexing = indexer.needsIndexing();
        monitor.beginTask(
                Activator.INSTANCE.getString("_UI_NIEM_SearchQuery_progress_task", new Object[] { criteria.searchTerm }),
                needsIndexing ? libraryCount * 2 : libraryCount);
        try {
            if (needsIndexing) {
                indexer.index(new SubProgressMonitor(monitor, libraryCount));
            }
            indexer.collectNamedElements(new SearchResultAggregator(getSearchResult(), new SubProgressMonitor(monitor,
                    libraryCount)), criteria);
        } catch (final IOException e) {
            Activator.INSTANCE.log(e);
        } finally {
            monitor.done();
        }
        return Status.OK_STATUS;
    }

    @Override
    public String getLabel() {
        return Activator.INSTANCE.getString("_UI_NIEM_SearchQuery_label", new Object[] { criteria.searchTerm });
    }

    @Override
    public boolean canRerun() {
        return true;
    }

    @Override
    public boolean canRunInBackground() {
        return true;
    }

    @Override
    public AbstractTextSearchResult getSearchResult() {
        final ReferenceLibrarySearchResult existingSearchResult = searchResult.get();
        if (existingSearchResult == null) {
            final ReferenceLibrarySearchResult newSearchResult = new ReferenceLibrarySearchResult(this);
            return searchResult.compareAndSet(null, newSearchResult) ? newSearchResult : searchResult.get();
        }
        return existingSearchResult;
    }

    private static final class SearchResultAggregator implements Aggregator<Object> {

        private final IProgressMonitor monitor;
        private final AbstractTextSearchResult searchResult;
        private int matches;

        SearchResultAggregator(final AbstractTextSearchResult searchResult, final IProgressMonitor monitor) {
            this.searchResult = searchResult;
            this.monitor = monitor;
        }

        @Override
        public void started(final int matches) {
            this.matches = matches;
            monitor.beginTask(Activator.INSTANCE.getString("_UI_NIEM_IndexMatcher_progress_task"), matches);
        }

        @Override
        public void finished() {
            monitor.done();
        }

        @Override
        public void addAll(final Iterator<EObject> i) {
            while (i.hasNext()) {
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                final EObject e = i.next();
                final URI uri = getURI(e);
                monitor.subTask(Activator.INSTANCE.getString("_UI_NIEM_IndexMatcher_progress_next_resource", new Object[] {
                        uri.fragment(), uri.trimFileExtension().lastSegment() }));
                searchResult.addMatch(new ReferenceLibraryMatch(e));
                monitor.worked(1);
            }
        }

        @Override
        public Collection<Object> get() {
            return asList(searchResult.getElements());
        }

        private static final class ReferenceLibraryMatch extends Match {

            public ReferenceLibraryMatch(final Object element) {
                super(element, 0, 0);
            }

            @Override
            public int hashCode() {
                return reflectionHashCode(this);
            }

            @Override
            public boolean equals(final Object obj) {
                return reflectionEquals(this, obj);
            }
        }

        @Override
        public int count() {
            return matches;
        }
    }
}
