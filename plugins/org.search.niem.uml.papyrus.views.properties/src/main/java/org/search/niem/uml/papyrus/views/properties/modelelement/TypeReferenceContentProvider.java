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
package org.search.niem.uml.papyrus.views.properties.modelelement;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.papyrus.infra.emf.utils.HistoryUtil.getHistoryID;
import static org.eclipse.papyrus.uml.tools.util.UMLProviderHelper.getStrategyProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.search.niem.uml.papyrus.views.properties.Activator;

public class TypeReferenceContentProvider extends UMLContentProvider {
    public TypeReferenceContentProvider(final EObject source, final EStructuralFeature feature) {
        super(source, feature);

        final IStructuredContentProvider semanticProvider = getSemanticProvider(source, feature, stereotype);
        encapsulated = encapsulateProvider(semanticProvider, eObject, feature, root);
    }

    private static EMFGraphicalContentProvider encapsulateProvider(final IStructuredContentProvider provider,
            final EObject editedEObject, final EStructuralFeature feature, final ResourceSet root) {
        final String historyId = editedEObject != null && feature != null ? getHistoryID(editedEObject, feature)
                : "DefaultHistory";
        final IStructuredContentProvider contentProvider = provider instanceof ITreeContentProvider ? getStrategyProvider((ITreeContentProvider) provider)
                : provider;
        return new PropertyGraphicalContentProvider(contentProvider, root, historyId);
    }

    private static final class PropertyGraphicalContentProvider extends EMFGraphicalContentProvider {

        private static final int MAX_SEARCH_DEPTH = 10;
        private static final int MIN_SEARCH_LENGTH = 3;

        public PropertyGraphicalContentProvider(final IStructuredContentProvider semanticProvider,
                final ResourceSet resourceSet, final String historyId) {
            super(semanticProvider, resourceSet, historyId);
        }

        @Override
        protected void createPatternFilter(final Composite parent) {
            final StringEditor editor = new StringEditor(parent, SWT.NONE);
            editor.setLabel(Activator.INSTANCE.getString("_UI_PropertyGraphicalContentProvider_filter_label"));
            editor.setToolTipText(Activator.INSTANCE.getString("_UI_PropertyGraphicalContentProvider_tooltip"));
            editor.setValidateOnDelay(true);
            patternFilter = new PatternViewerFilter();
            final AtomicReference<String> currentFilterPattern = new AtomicReference<>(""); //$NON-NLS-1$
            ((PatternViewerFilter) patternFilter).setPattern(currentFilterPattern.get());
            editor.addCommitListener(new ICommitListener() {
                @Override
                public void commit(final AbstractEditor editor) {
                    final String filterPattern = (String) ((StringEditor) editor).getValue();
                    ((PatternViewerFilter) patternFilter).setPattern(filterPattern);
                    viewer.refresh();
                    if (!(isBlank(filterPattern) || currentFilterPattern.get().equals(filterPattern) || filterPattern
                            .length() < MIN_SEARCH_LENGTH)) {
                        revealSemanticElement(collectMatches());
                        currentFilterPattern.set(filterPattern);
                    }
                }
            });

            final List<ViewerFilter> filters = new LinkedList<ViewerFilter>(asList(viewer.getFilters()));
            filters.add(patternFilter);
            viewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
        }

        private List<Object> collectMatches() {
            final List<Object> matchingElements = new ArrayList<>();
            for (final Object parent : getElements(viewer.getInput())) {
                collectMatches(parent, matchingElements, 1);
            }
            return matchingElements;
        }

        private void collectMatches(final Object element, final List<Object> matches, final int depth) {
            if (depth > MAX_SEARCH_DEPTH) {
                return;
            }
            if (isFiltered(element)) {
                return;
            }
            if (isValidValue(element)) {
                matches.add(element);
            }
            for (final Object childElement : getChildren(element)) {
                collectMatches(childElement, matches, depth + 1);
            }
        }

        private boolean isFiltered(final Object element) {
            for (final ViewerFilter filter : viewer.getFilters()) {
                if (!filter.select(viewer, getParent(element), element)) {
                    return true;
                }
            }
            return false;
        }
    }
}
