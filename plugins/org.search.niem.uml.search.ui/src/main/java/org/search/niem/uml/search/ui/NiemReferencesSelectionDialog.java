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
import static org.search.niem.uml.merge.NamespaceMergeUtil.findEquivalent;
import static org.search.niem.uml.util.EcoreExt.getEClass;
import static org.search.niem.uml.util.NIEMUmlExt.getSubstitutionGroupName;
import static org.search.niem.uml.util.NIEMUmlExt.isReference;
import static org.search.niem.uml.util.UMLExt.getName;
import static org.search.niem.uml.util.UMLExt.getOwner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.search.Indexer;
import org.search.niem.uml.search.ui.dialog.NiemCheckedTreeSelectionDialog;
import org.search.niem.uml.search.ui.dialog.NiemCheckedTreeSelectionListener;
import org.search.niem.uml.search.ui.dialog.NiemContainerCheckedTreeViewer;

final class NiemReferencesSelectionDialog extends NiemCheckedTreeSelectionDialog implements UncheckedElementsProvider {

    private static final int BUTTON_WIDTH = 70;

    private final Package thePIM;
    private final Collection<Object> unchecked = new HashSet<>();
    private final FontsAndColors fontsAndColors;

    NiemReferencesSelectionDialog(final Shell shell, final FontsAndColors fontsAndColors, final Package thePIM,
            final Object root) {
        super(shell, createContentProvider(root), TreeViewerContentProvider.NULL_ROOT, new Object[] { root });
        this.fontsAndColors = fontsAndColors;
        this.thePIM = thePIM;
    }

    @Override
    public void create() {
        super.create();

        final NiemContainerCheckedTreeViewer theTreeViewer = getTreeViewer();
        ColumnViewerToolTipSupport.enableFor(theTreeViewer);

        final Collection<TreeItem> visibleTreeItems = new ArrayList<>();
        final TreeItem theRootItem = theTreeViewer.getTree().getItem(0);
        visibleTreeItems.add(theRootItem);
        visibleTreeItems.addAll(asList(theRootItem.getItems()));
        updateExpanded(visibleTreeItems, theTreeViewer);
    }

    private void updateExpanded(final Iterable<TreeItem> expanded, final NiemContainerCheckedTreeViewer theTreeViewer) {
        final AtomicReference<Collection<TreeItem>> cachedReference = new AtomicReference<>();
        for (final TreeItem treeItem : expanded) {
            // if a similar tree item is already expanded then use its check state
            // otherwise, if the tree item data exists in the PIM and its parent has not been unchecked, then gray it
            final TreeItem theParent = treeItem.getParentItem();
            final TreeItem similar = theTreeViewer.findFirstMatch(treeItem);
            if (similar != null) {
                treeItem.setChecked(similar.getChecked());
                treeItem.setGrayed(similar.getGrayed());
            } else if (theParent != null && theParent.getChecked() && !theParent.getGrayed()) {
                treeItem.setChecked(true);
            } else if (getExistingItems(cachedReference, expanded).contains(treeItem)) {
                treeItem.setChecked(true);
                treeItem.setGrayed(true);
            }
        }
    }

    private Collection<TreeItem> getExistingItems(final AtomicReference<Collection<TreeItem>> cachedReference,
            final Iterable<TreeItem> expanded) {
        final Collection<TreeItem> existingItems = cachedReference.get();
        if (existingItems != null) {
            return existingItems;
        }
        final Collection<TreeItem> collected = collectExistingItems(expanded);
        cachedReference.set(collected);
        return collected;
    }

    private Collection<TreeItem> collectExistingItems(final Iterable<TreeItem> items) {
        final Collection<TreeItem> existingItems = new ArrayList<>();
        Namespace theCurrentOwner = null;
        Namespace theEquivalentOwnerInThePIM = null;
        for (final TreeItem item : items) {
            final Object o = item.getData();
            final Element visibleElement = (Element) o;
            final Namespace theOwner = getOwner(visibleElement);
            if (theOwner != theCurrentOwner) {
                theCurrentOwner = theOwner;
                theEquivalentOwnerInThePIM = findEquivalent(theOwner, thePIM);
            }
            if (theEquivalentOwnerInThePIM == null) {
                continue;
            }
            if (theEquivalentOwnerInThePIM.getMember(getName(visibleElement), false, getEClass(visibleElement)) != null) {
                existingItems.add(item);
            }
        }
        return existingItems;
    }

    @Override
    public boolean isUnchecked(final Object element) {
        return unchecked.contains(element);
    }

    @Override
    public Collection<Object> getUnchecked() {
        return unchecked;
    }

    @Override
    protected NiemContainerCheckedTreeViewer createTreeViewer(final Composite parent) {
        final NiemContainerCheckedTreeViewer theTreeViewer = super.createTreeViewer(parent);
        theTreeViewer.getTree().addTreeListener(new TreeListener() {

            @Override
            public void treeExpanded(final TreeEvent e) {
                final TreeItem widget = (TreeItem) e.item;
                if (widget == theTreeViewer.getTree().getItem(0)) {
                    updateExpanded(asList(widget), theTreeViewer);
                    getShell().getDisplay().asyncExec(new Runnable() {
                        @Override
                        public void run() {
                            if (widget.isDisposed()) {
                                return;
                            }
                            updateExpanded(asList(widget.getItems()), theTreeViewer);
                        }
                    });
                } else {
                    updateExpanded(asList(widget.getItems()), theTreeViewer);
                }
            }

            @Override
            public void treeCollapsed(final TreeEvent e) {
                // no-op
            }
        });
        theTreeViewer.addNiemCheckedTreeSelectionListener(new NiemCheckedTreeSelectionListener() {

            private Collection<Object> extractData(final Collection<? extends Widget> ws) {
                final Collection<Object> data = new ArrayList<>();
                for (final Widget w : ws) {
                    data.add(w.getData());
                }
                return data;
            }

            private void update(final Collection<? extends Object> data) {
                theTreeViewer.update(data.toArray(), null);
            }

            @Override
            public void unchecked(final Collection<TreeItem> treeItems) {
                final Collection<TreeItem> existing = collectExistingItems(treeItems);
                final Collection<Object> data = extractData(existing);
                unchecked.addAll(data);
                update(data);
            }

            @Override
            public void greyed(final Collection<TreeItem> treeItems) {
                final Collection<TreeItem> existing = collectExistingItems(treeItems);
                final Collection<Object> data = extractData(existing);
                unchecked.removeAll(data);
                update(data);
            }

            @Override
            public void checked(final Collection<TreeItem> treeItems) {
                final Collection<TreeItem> existing = collectExistingItems(treeItems);
                final Collection<Object> data = extractData(existing);
                unchecked.removeAll(data);
                update(data);
            }
        });
        return theTreeViewer;
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        super.createButtonsForButtonBar(parent);
        getOkButton().setText(Activator.INSTANCE.getString("_UI_NIEMReferencesSelectionDialog_ok_button"));
    }

    @Override
    protected void setButtonLayoutData(final Button button) {
        final GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        final int widthHint = convertHorizontalDLUsToPixels(BUTTON_WIDTH);
        final Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
        data.widthHint = Math.max(widthHint, minSize.x);
        button.setLayoutData(data);
    }

    @Override
    protected final ILabelProvider createLabelProvider() {
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        adapterFactory.addAdapterFactory(new TreeViewerItemProviderAdapterFactory(this));
        return new NiemReferencesLabelProvider(new AdapterFactoryLabelProvider.FontAndColorProvider(adapterFactory,
                fontsAndColors.font, fontsAndColors.foreground, fontsAndColors.background));
    }

    private static ITreeContentProvider createContentProvider(final Object root) {
        return new TreeViewerContentProvider(root);
    }

    private static final class TreeViewerContentProvider implements ITreeContentProvider {

        static final Object NULL_ROOT = new Object();

        final Object theRoot;

        public TreeViewerContentProvider(final Object root) {
            theRoot = root;
        }

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        }

        @Override
        public Object[] getElements(final Object inputElement) {
            if (inputElement == NULL_ROOT) {
                return new Object[] { theRoot };
            }
            return getChildren(inputElement);
        }

        @Override
        public Object[] getChildren(final Object parentElement) {
            if (UMLPackage.Literals.CLASSIFIER.isInstance(parentElement)) {
                return getChildren((Classifier) parentElement).toArray();
            }
            if (UMLPackage.Literals.PROPERTY.isInstance(parentElement)) {
                return getChildren((Property) parentElement);
            }
            return new Object[] {};
        }

        private Collection<? extends NamedElement> getChildren(final Classifier parentElement) {
            if (UMLPackage.Literals.CLASS.isInstance(parentElement)) {
                return getChildren((Class) parentElement);
            }
            if (UMLPackage.Literals.ENUMERATION.isInstance(parentElement)) {
                return getChildren((Enumeration) parentElement);
            }
            if (UMLPackage.Literals.DATA_TYPE.isInstance(parentElement)) {
                return getChildren((DataType) parentElement);
            }
            return Collections.emptyList();
        }

        private Collection<Property> getChildren(final Class c) {
            return c.getAllAttributes();
        }

        private Collection<NamedElement> getChildren(final Enumeration e) {
            final Collection<NamedElement/* Property|EnumerationLiteral */> allMyChildren = new ArrayList<>();
            allMyChildren.addAll(e.getAllAttributes());
            allMyChildren.addAll(EcoreUtil.<EnumerationLiteral> getObjectsByType(e.getInheritedMembers(),
                    UMLPackage.Literals.ENUMERATION_LITERAL));
            allMyChildren.addAll(e.getOwnedLiterals());
            return allMyChildren;
        }

        private Collection<Property> getChildren(final DataType d) {
            return d.getAllAttributes();
        }

        private Object[] getChildren(final Property p) {
            if (isAbstract(p)) {
                return findSubstitutions(p);
            }
            return getChildren(p.getType());
        }

        private boolean isAbstract(final Property p) {
            return p.getType() == null;
        }

        private boolean hasSubstitutions(final Property p) {
            return Indexer.create(p.eResource().getResourceSet()).countSubstitutions(toSubstitutionGroupName(p)) > 0;
        }

        private Object[] findSubstitutions(final Property p) {
            return Indexer.create(p.eResource().getResourceSet()).findSubstitutions(toSubstitutionGroupName(p)).toArray();
        }

        private String toSubstitutionGroupName(final Property p) {
            final Property substitutionGroupReference = getSubstitutionGroupReference(p);
            final Property substitutionGroupAffiliation = substitutionGroupReference == null ? p
                    : substitutionGroupReference;
            return getSubstitutionGroupName(substitutionGroupAffiliation);
        }

        private Property getSubstitutionGroupReference(final Property p) {
            final List<DirectedRelationship> sourceDirectedRelationships = p
                    .getSourceDirectedRelationships(UMLPackage.Literals.REALIZATION);
            if (!sourceDirectedRelationships.isEmpty()) {
                final Realization r = (Realization) sourceDirectedRelationships.get(0);
                if (isReference(r)) {
                    final List<NamedElement> suppliers = r.getSuppliers();
                    if (!suppliers.isEmpty()) {
                        return (Property) suppliers.get(0);
                    }
                }
            }
            return null;
        }

        @Override
        public Object getParent(final Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(final Object element) {
            if (UMLPackage.Literals.PROPERTY.isInstance(element)) {
                final Property p = (Property) element;
                if (isAbstract(p)) {
                    return hasSubstitutions(p);
                }
            }
            return getChildren(element).length > 0;
        }
    }

    private static final class TreeViewerItemProviderAdapterFactory extends NamespaceDecoratingItemProviderAdapterFactory
            implements IAdaptable {

        final UncheckedElementsProvider delegate;

        TreeViewerItemProviderAdapterFactory(final UncheckedElementsProvider delegate) {
            this.delegate = delegate;
        }

        @Override
        public Adapter createClassAdapter() {
            if (classItemProvider == null) {
                classItemProvider = new TreeViewerClassItemProvider(this);
            }
            return classItemProvider;
        }

        @Override
        public Adapter createDataTypeAdapter() {
            if (dataTypeItemProvider == null) {
                dataTypeItemProvider = new TreeViewerDataTypeItemProvider(this);
            }
            return dataTypeItemProvider;
        }

        @Override
        public Adapter createEnumerationAdapter() {
            if (enumerationItemProvider == null) {
                enumerationItemProvider = new TreeViewerEnumerationItemProvider(this);
            }
            return enumerationItemProvider;
        }

        @Override
        public Adapter createPrimitiveTypeAdapter() {
            if (primitiveTypeItemProvider == null) {
                primitiveTypeItemProvider = new TreeViewerPrimitiveTypeItemProvider(this);
            }
            return primitiveTypeItemProvider;
        }

        @Override
        public Adapter createPropertyAdapter() {
            if (propertyItemProvider == null) {
                propertyItemProvider = new TreeViewerPropertyItemProvider(this);
            }
            return propertyItemProvider;
        }

        @Override
        public Adapter createEnumerationLiteralAdapter() {
            if (enumerationLiteralItemProvider == null) {
                enumerationLiteralItemProvider = new TreeViewerEnumerationLiteralItemProvider(this);
            }
            return enumerationLiteralItemProvider;
        }

        @Override
        public Object getAdapter(@SuppressWarnings("rawtypes") final java.lang.Class adapter) {
            return UncheckedElementsProvider.class == adapter ? delegate : null;
        }

        private static final class TreeViewerClassItemProvider extends NamespaceDecoratingClassItemProvider {

            public TreeViewerClassItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static final class TreeViewerDataTypeItemProvider extends NamespaceDecoratingDataTypeItemProvider {

            public TreeViewerDataTypeItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static final class TreeViewerEnumerationItemProvider extends NamespaceDecoratingEnumerationItemProvider {

            public TreeViewerEnumerationItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static final class TreeViewerPrimitiveTypeItemProvider extends NamespaceDecoratingPrimitiveTypeItemProvider {

            public TreeViewerPrimitiveTypeItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static final class TreeViewerPropertyItemProvider extends NamespaceDecoratingPropertyItemProvider {

            public TreeViewerPropertyItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static final class TreeViewerEnumerationLiteralItemProvider extends
                SearchResultsEnumerationLiteralItemProvider {

            public TreeViewerEnumerationLiteralItemProvider(final TreeViewerItemProviderAdapterFactory adapterFactory) {
                super(adapterFactory);
            }

            @Override
            public Object getImage(final Object object) {
                final Object base = super.getImage(object);
                return isUnchecked((IAdaptable) getAdapterFactory(), object) ? overlay(base, getUncheckedOverlay()) : base;
            }
        }

        private static Object overlay(final Object base, final Object... overlayed) {
            final ComposedImage composed = base instanceof ComposedImage ? (ComposedImage) base : new ComposedImage(
                    asList(base));
            composed.getImages().addAll(asList(overlayed));
            return composed;
        }

        private static boolean isUnchecked(final IAdaptable adapter, final Object object) {
            final UncheckedElementsProvider uncheckedElementsProvider = (UncheckedElementsProvider) adapter
                    .getAdapter(UncheckedElementsProvider.class);
            return uncheckedElementsProvider != null && uncheckedElementsProvider.isUnchecked(object);
        }

        private static Object getUncheckedOverlay() {
            return Activator.getPlugin().getImage("full/ovr16/unchecked");
        }
    }
}