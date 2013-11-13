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
import static java.util.Collections.newSetFromMap;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.uml.util.NIEMUmlExt.findNearestNiemNamespace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

public class ReferenceLibrarySearchResultPage extends AbstractTextSearchViewPage {

    private ViewState viewState;

    public ReferenceLibrarySearchResultPage() {
        super(FLAG_LAYOUT_FLAT | FLAG_LAYOUT_TREE);
    }

    @Override
    public void setInput(final ISearchResult newSearch, final Object state) {
        super.setInput(newSearch, state);
        clear();
        if (newSearch != null) {
            elementsChanged(((AbstractTextSearchResult) newSearch).getElements());
        }
    }

    @Override
    protected void elementsChanged(final Object[] objects) {
        if (objects.length == 0) {
            return;
        }
        viewState.update(objects);
    }

    @Override
    protected void clear() {
        viewState.dispose();
        viewState.configure();
        viewState.refresh();
    }

    private IWorkbenchPage getPage() {
        return getSite().getPage();
    }

    @Override
    protected void configureTreeViewer(final TreeViewer viewer) {
        viewState = new ViewingTree(viewer, getPage());
        viewState.configure();
    }

    @Override
    protected void configureTableViewer(final TableViewer viewer) {
        viewState = new ViewingTable(viewer, getPage());
        viewState.configure();
    }

    @Override
    public void setLayout(final int layout) {
        if (layout == getLayout()) {
            return;
        }
        try {
            viewState.dispose();
        } finally {
            super.setLayout(layout);
        }
        setInput(getInput(), getUIState());
    }

    @Override
    public void dispose() {
        try {
            viewState.dispose();
        } finally {
            super.dispose();
        }
    }

    private static class TreeViewerContentProvider implements ITreeContentProvider, IUpdatable {

        private final ConcurrentHashMap<Package, Collection<Classifier>> packages2elements = new ConcurrentHashMap<>();
        private final ConcurrentHashMap<Classifier, Collection<Property>> classifiers2attributes = new ConcurrentHashMap<>();

        @Override
        public Object[] getElements(final Object inputElement) {
            return packages2elements.keySet().toArray();
        }

        @Override
        public Object[] getChildren(final Object parentElement) {
            if (UMLPackage.Literals.PACKAGE.isInstance(parentElement)) {
                return packages2elements.get(parentElement).toArray();
            } else if (UMLPackage.Literals.CLASSIFIER.isInstance(parentElement)) {
                return getChildren((Classifier) parentElement).toArray();
            } else if (UMLPackage.Literals.PROPERTY.isInstance(parentElement)) {
                return ((Element) parentElement).getOwnedComments().toArray();
            }
            return new Object[] {};
        }

        private Collection<Element> getChildren(final Classifier parent) {
            final Collection<Element> children = new ArrayList<>();
            children.addAll(parent.getOwnedComments());
            if (classifiers2attributes.containsKey(parent)) {
                children.addAll(classifiers2attributes.get(parent));
            }
            return children;
        }

        @Override
        public Object getParent(final Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(final Object element) {
            if (UMLPackage.Literals.PACKAGE.isInstance(element)) {
                return packages2elements.containsKey(element) && !packages2elements.get(element).isEmpty();
            } else if (UMLPackage.Literals.CLASSIFIER.isInstance(element)) {
                return classifiers2attributes.containsKey(element) && !classifiers2attributes.get(element).isEmpty()
                        || hasComments((Element) element);
            } else if (UMLPackage.Literals.PROPERTY.isInstance(element)) {
                return hasComments((Element) element);
            }
            return false;
        }

        private boolean hasComments(final Element element) {
            return !element.getOwnedComments().isEmpty();
        }

        private boolean add(final Classifier c) {
            final EObject nearestNamespace = findNearestNiemNamespace(c.getNearestPackage());
            final Package namespace = (Package) getBaseElement(nearestNamespace);
            packages2elements.putIfAbsent(namespace, newSetFromMap(new ConcurrentHashMap<Classifier, Boolean>()));
            return packages2elements.get(namespace).add(c);
        }

        private void update(final Classifier c) {
            if (!add(c)) {
                final EObject nearestNamespace = findNearestNiemNamespace(c.getNearestPackage());
                final Package namespace = (Package) getBaseElement(nearestNamespace);
                packages2elements.get(namespace).remove(c);
            }
        }

        private void update(final Property p) {
            final Classifier c = (Classifier) p.getOwner();
            classifiers2attributes.putIfAbsent(c, newSetFromMap(new ConcurrentHashMap<Property, Boolean>()));
            if (classifiers2attributes.get(c).add(p)) {
                add(c);
            } else {
                classifiers2attributes.remove(p);
            }
        }

        @Override
        public void update(final Collection<Object> elements) {
            for (final Object o : elements) {
                if (UMLPackage.Literals.CLASSIFIER.isInstance(o)) {
                    update((Classifier) o);
                } else if (UMLPackage.Literals.PROPERTY.isInstance(o)) {
                    update((Property) o);
                }
            }
        }

        void clear() {
            packages2elements.clear();
            classifiers2attributes.clear();
        }

        @Override
        public void dispose() {
            clear();
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // no-op
        }
    }

    private static interface IUpdatable {
        void update(final Collection<Object> elements);
    }

    private static class TableViewerContentProvider implements IStructuredContentProvider, IUpdatable {

        private final Collection<Object> matches = newSetFromMap(new ConcurrentHashMap<Object, Boolean>());

        @Override
        public Object[] getElements(final Object inputElement) {
            return matches.toArray();
        }

        @Override
        public void update(final Collection<Object> elements) {
            for (final Object object : elements) {
                if (!matches.add(object)) {
                    matches.remove(object);
                }
            }
        }

        void clear() {
            matches.clear();
        }

        @Override
        public void dispose() {
            clear();
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // no-op
        }

    }

    private static abstract class ViewState {

        private final IDoubleClickListener listener;
        protected final ColumnViewer viewer;
        protected ComposedAdapterFactory adapterFactory;

        protected ViewState(final ColumnViewer viewer, final IWorkbenchPage page) {
            this.viewer = viewer;
            listener = new SearchDoubleClickListener(viewer.getControl(), page);
        }

        final void refresh() {
            viewer.refresh();
        }

        final void dispose() {
            viewer.removeDoubleClickListener(listener);
            if (adapterFactory != null) {
                adapterFactory.dispose();
            }
            if (viewer.getContentProvider() != null) {
                viewer.getContentProvider().dispose();
            }
            if (viewer.getLabelProvider() != null) {
                viewer.getLabelProvider().dispose();
            }
        }

        final void configure() {
            adapterFactory = createAdapterFactory();
            viewer.addDoubleClickListener(listener);
            viewer.setSorter(new ViewerSorter());
            ColumnViewerToolTipSupport.enableFor(viewer);
            doConfigure();
        }

        final void update(final Object[] matches) {
            ((IUpdatable) viewer.getContentProvider()).update(asList(matches));
            refresh();
        }

        final ILabelProvider createLabelProvider() {
            return new NiemReferencesLabelProvider(new AdapterFactoryLabelProvider.FontAndColorProvider(adapterFactory,
                    viewer));
        }

        final ComposedAdapterFactory createAdapterFactory() {
            final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
                    ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
            adapterFactory.addAdapterFactory(new NamespaceDecoratingItemProviderAdapterFactory());
            return adapterFactory;
        }

        protected abstract void doConfigure();
    }

    private static final class ViewingTable extends ViewState {

        protected ViewingTable(final ColumnViewer viewer, final IWorkbenchPage page) {
            super(viewer, page);
        }

        @Override
        protected void doConfigure() {
            viewer.setContentProvider(new TableViewerContentProvider());
            viewer.setLabelProvider(createLabelProvider());
        }
    }

    private static final class ViewingTree extends ViewState {

        protected ViewingTree(final ColumnViewer viewer, final IWorkbenchPage page) {
            super(viewer, page);
        }

        @Override
        protected void doConfigure() {
            final ITreeContentProvider contentProvider = new TreeViewerContentProvider();
            viewer.setContentProvider(contentProvider);
            viewer.setLabelProvider(createLabelProvider());
            if (viewer.getInput() == null) {
                viewer.setUseHashlookup(true);
            }
            viewer.addFilter(new ViewerFilter() {
                @Override
                public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
                    return canView((ITreeContentProvider) ((ContentViewer) viewer).getContentProvider(), element);
                }
            });
        }

        private boolean canView(final ITreeContentProvider contentProvider, final Object element) {
            return !UMLPackage.Literals.PACKAGE.isInstance(element) || contentProvider.hasChildren(element);
        }
    }
}
