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

import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.uml.util.NIEMUmlExt.findNearestNiemNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.findTargetNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.namesMatch;
import static org.search.niem.uml.util.UMLExt.getNearestPackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.search.niem.uml.search.Indexer;

public class ReferenceLibrarySearchUtil {

    public static EObject findTheReferenceLibraryEquivalentOf(final EObject theSubsetElement) {
        final Package theSubsetNamespace = (Package) getBaseElement(findNearestNiemNamespace(getNearestPackage(theSubsetElement)));
        final Indexer theIndexer = Indexer.create();
        createIndexIfNecessary(theIndexer);
        final Package theReferenceLibraryNamespace = theIndexer
                .findByTargetNamespace(findTargetNamespace(theSubsetNamespace));
        if (theReferenceLibraryNamespace == null) {
            return null;
        }
        final LinkedList<Element> pathToSubsetElement = new LinkedList<>();
        NamedElement next = (NamedElement) theSubsetElement;
        while (next != theSubsetNamespace) {
            pathToSubsetElement.addFirst(next);
            next = next.getNamespace();
        }
        return findNamedElement(theReferenceLibraryNamespace, pathToSubsetElement);
    }

    // TODO: move this into the indexer
    private static void createIndexIfNecessary(final Indexer indexer) {
        if (!indexer.needsIndexing()) {
            return;
        }
        try {
            new ProgressMonitorDialog(null).run(false, false, new IRunnableWithProgress() {

                @Override
                public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try {
                        indexer.index(monitor);
                    } catch (final IOException e) {
                        throw new InvocationTargetException(e);
                    }
                }
            });
        } catch (final InvocationTargetException e) {
            Activator.INSTANCE.log(e);
        } catch (final InterruptedException e) {
            // no-op
        }
    }

    private static Element findNamedElement(final Package inTheNamespace, final Iterable<Element> withThePath) {
        // foreach path element, look for an element in the namespace with either a matching NIEMName, a matching name or, if
        // the path element ends with 'Type', the name without the 'Type' suffix
        Element nextNamespaceElement = inTheNamespace;
        for (final Element nextPathElement : withThePath) {
            final Element match = findMatching(nextPathElement, nextNamespaceElement);
            if (match == null) {
                return null;
            }
            nextNamespaceElement = match;
        }
        return nextNamespaceElement;
    }

    private static Element findMatching(final Element pimElement, final Element inTheReferenceLibrary) {
        for (final Element member : EcoreUtil.<Element> getObjectsByType(inTheReferenceLibrary.getOwnedElements(),
                pimElement.eClass())) {
            if (namesMatch(member, pimElement)) {
                return member;
            }
        }
        return null;
    }
}
