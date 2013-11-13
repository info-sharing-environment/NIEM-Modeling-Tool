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
package org.search.niem.uml.merge;

import static java.util.Collections.unmodifiableMap;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.eclipse.emf.common.util.ECollections.asEList;
import static org.eclipse.emf.common.util.ECollections.indexOf;
import static org.eclipse.emf.ecore.util.EcoreUtil.getObjectsByType;
import static org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getDimensionFromPref;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMNS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMN_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_ELEMENT_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_VERTICAL_PADDING;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAClassDiagram;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAComponentDiagram;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAPackageDiagram;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAnHyperLink;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheAttributeCompartment;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheClassDiagramKind;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheClassDiagramPreferencesHint;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheComponentDiagramKind;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheComponentDiagramPreferencesHint;
import static org.search.niem.uml.papyrus.util.DiagramExt.getThePackageDiagramKind;
import static org.search.niem.uml.papyrus.util.DiagramExt.getThePackageDiagramPreferencesHint;
import static org.search.niem.uml.util.UMLExt.getGeneral;
import static org.search.niem.uml.util.UMLExt.getGeneralizations;
import static org.search.niem.uml.util.UMLExt.getNestedPackages;
import static org.search.niem.uml.util.UMLExt.getOwnedAttributes;
import static org.search.niem.uml.util.UMLExt.getPackagedElements;
import static org.search.niem.uml.util.UMLExt.getSpecific;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyforDataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyforPrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

public class DiagramSynchronizer {

    private static final Point DEFAULT_ORIGIN = new Point(24, 24);

    private final Resource theDiagramResource;
    private final IPageManager thePageManager;

    private final Map<View, Collection<Node>> diagrams2Nodes;
    private final Map<EObject, View> elements2Views;
    private final Map<Package, Diagram> packages2Diagrams;

    private final Map<ViewDiscriminant, ViewFactory> types2ViewFactories;
    {
        final Map<ViewDiscriminant, ViewFactory> m = new HashMap<>();
        m.put(new ViewDiscriminant(UMLPackage.Literals.MODEL, getThePackageDiagramKind()), new PackageDiagramNodeFactory(
                ModelEditPartTN.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.MODEL, getTheComponentDiagramKind()),
                new ComponentDiagramNodeFactory(ModelEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.MODEL, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                ModelEditPartTN.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PACKAGE, getThePackageDiagramKind()), new PackageDiagramNodeFactory(
                PackageEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PACKAGE, getTheComponentDiagramKind()),
                new ComponentDiagramNodeFactory(
                        org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PACKAGE, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                PackageEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.ASSOCIATION_CLASS, getTheClassDiagramKind()),
                new ClassDiagramNodeFactory(AssociationClassEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.CLASS, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                ClassEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.COMPONENT, getTheComponentDiagramKind()),
                new ComponentDiagramNodeFactory(
                        org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.COMPONENT, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                ComponentEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PRIMITIVE_TYPE, getTheClassDiagramKind()),
                new ClassDiagramNodeFactory(PrimitiveTypeEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.DATA_TYPE, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                DataTypeEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.ENUMERATION, getTheClassDiagramKind()), new ClassDiagramNodeFactory(
                EnumerationEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PROPERTY, UMLVisualIDRegistry
                .getType(ClassAttributeCompartmentEditPart.VISUAL_ID)), new AttributeNodeFactory(
                PropertyForClassEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PROPERTY, UMLVisualIDRegistry
                .getType(AssociationClassAttributeCompartmentEditPart.VISUAL_ID)), new AttributeNodeFactory(
                PropertyForClassEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PROPERTY, UMLVisualIDRegistry
                .getType(ComponentAttributeCompartmentEditPart.VISUAL_ID)), new AttributeNodeFactory(
                PropertyForComponentEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PROPERTY, UMLVisualIDRegistry
                .getType(PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID)), new AttributeNodeFactory(
                PropertyforPrimitiveTypeEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.PROPERTY, UMLVisualIDRegistry
                .getType(DataTypeAttributeCompartmentEditPart.VISUAL_ID)), new AttributeNodeFactory(
                PropertyforDataTypeEditPart.VISUAL_ID));
        m.put(new ViewDiscriminant(UMLPackage.Literals.GENERALIZATION, getTheClassDiagramKind()),
                new GeneralizationEdgeFactory(GeneralizationEditPart.VISUAL_ID));

        types2ViewFactories = unmodifiableMap(m);
    }

    public DiagramSynchronizer(final Resource theDiagramResource, final IPageManager thePageManager) {
        this.theDiagramResource = theDiagramResource;
        this.thePageManager = thePageManager;
        packages2Diagrams = new HashMap<>();
        elements2Views = new HashMap<>();
        diagrams2Nodes = new HashMap<>();
    }

    public void merge(final Collection<? extends PackageableElement> theElements) {
        for (final PackageableElement element : theElements) {
            populate(getOrCreateTheDiagram(element.getNearestPackage()));
        }
    }

    private Dimension getPreferredDimension(final Node n) {
        return getDimensionFromPref(n, (IPreferenceStore) getTheClassDiagramPreferencesHint().getPreferenceStore(),
                n.getType());
    }

    private void populate(final Diagram theDiagram) {
        final EObject theElement = theDiagram.getElement();
        final EList<EObject> contents = theElement.eContents();
        for (final Package p : getNestedPackages(theElement)) {
            populate(getOrCreateTheDiagram(p));
        }
        for (final EObject element : contents) {
            getOrCreateTheView(element, theDiagram);
        }
    }

    private void createContentsIfNecessary(final View theElementView) {
        final EObject theElement = theElementView.getElement();
        final EList<Property> ownedAttributes = asEList(getOwnedAttributes(theElement));
        if (!ownedAttributes.isEmpty()) {
            final View theOwnedAttributeCompartment = getTheAttributeCompartment(theElementView);
            for (final Property p : ownedAttributes) {
                getOrCreateTheView(p, theOwnedAttributeCompartment);
            }
            @SuppressWarnings("unchecked")
            final EList<View> attributeViews = theOwnedAttributeCompartment.getPersistedChildren();
            ECollections.sort(attributeViews, new Comparator<View>() {
                @Override
                public int compare(final View left, final View right) {
                    return Integer.compare(indexOf(ownedAttributes, left.getElement(), 0),
                            indexOf(ownedAttributes, right.getElement(), 0));
                }
            });
        }
        for (final Generalization g : getGeneralizations(theElement)) {
            getOrCreateTheView(g, theElementView.getDiagram());
        }
    }

    private View getOrCreateTheView(final EObject theElement, final View theContainer) {
        return getOrCreateTheView(theElement, theContainer, true);
    }

    private View getOrCreateTheView(final EObject theElement, final View theContainer, final boolean shouldCreateContents) {
        if (elements2Views.containsKey(theElement) && theContainer == elements2Views.get(theElement).eContainer()) {
            return elements2Views.get(theElement);
        }
        for (final View theExistingView : EcoreUtil.<View> getObjectsByType(theContainer.eContents(),
                NotationPackage.Literals.VIEW)) {
            final EObject e = theExistingView.getElement();
            if (theElement == e) {
                elements2Views.put(theElement, theExistingView);
                if (shouldCreateContents) {
                    createContentsIfNecessary(theExistingView);
                }
                return theExistingView;
            }
        }
        final ViewFactory theViewFactory = types2ViewFactories.get(new ViewDiscriminant(theElement.eClass(), theContainer
                .getType()));
        if (theViewFactory == null) {
            Activator.INSTANCE.log("Unable to find view factory for type " + theElement.eClass() + " in container type "
                    + theContainer.getType());
            return null;
        }
        final View theNewView = theViewFactory.createView(theElement, theContainer);
        elements2Views.put(theElement, theNewView);
        if (shouldCreateContents) {
            createContentsIfNecessary(theNewView);
        }
        return theNewView;
    }

    private Collection<Component> getComponents(final EObject theElement) {
        return getObjectsByType(getPackagedElements(theElement), UMLPackage.Literals.COMPONENT);
    }

    private Diagram getOrCreateTheDiagram(final Package p) {
        final Collection<PackageableElement> thePackagedElements = p.getPackagedElements();
        final Collection<Package> theNestedPackages = p.getNestedPackages();
        if (!thePackagedElements.isEmpty() && theNestedPackages.size() == thePackagedElements.size()) {
            return packageDiagramFactory.getOrCreateTheDiagram(p);
        }
        if (!thePackagedElements.isEmpty()
                && getComponents(p).size() + theNestedPackages.size() == thePackagedElements.size()) {
            return componentDiagramFactory.getOrCreateTheDiagram(p);
        }
        return classDiagramFactory.getOrCreateTheDiagram(p);
    }

    private abstract class DiagramFactory {
        Diagram getOrCreateTheDiagram(final Package thePackage) {
            if (packages2Diagrams.containsKey(thePackage)) {
                return packages2Diagrams.get(thePackage);
            }
            for (final Diagram aDiagram : EcoreUtil.<Diagram> getObjectsByType(theDiagramResource.getContents(),
                    NotationPackage.Literals.DIAGRAM)) {
                if (thePackage == aDiagram.getElement()) {
                    packages2Diagrams.put(thePackage, aDiagram);
                    return aDiagram;
                }
            }
            final Diagram theNewDiagram = createTheDiagram(thePackage);
            link(theNewDiagram);
            packages2Diagrams.put(thePackage, theNewDiagram);
            return theNewDiagram;
        }

        private void link(final Diagram theDiagram) {
            final Package theElement = (Package) theDiagram.getElement();
            final Package theParent = theElement.getNestingPackage();
            if (theParent == null) {
                return;
            }
            final Diagram theParentDiagram = DiagramSynchronizer.this.getOrCreateTheDiagram(theParent);
            final View theView = DiagramSynchronizer.this.getOrCreateTheView(theElement, theParentDiagram, false);
            createAnHyperLink(theView, theDiagram);
        }

        protected abstract Diagram createTheDiagram(final Package thePackage);
    }

    private final DiagramFactory classDiagramFactory = new DiagramFactory() {
        @Override
        protected Diagram createTheDiagram(final Package thePackage) {
            return createAClassDiagram(thePackage, theDiagramResource, thePageManager);
        }
    };

    private final DiagramFactory componentDiagramFactory = new DiagramFactory() {
        @Override
        protected Diagram createTheDiagram(final Package thePackage) {
            return createAComponentDiagram(thePackage, theDiagramResource, thePageManager);
        }
    };

    private final DiagramFactory packageDiagramFactory = new DiagramFactory() {
        @Override
        protected Diagram createTheDiagram(final Package thePackage) {
            return createAPackageDiagram(thePackage, theDiagramResource, thePageManager);
        }
    };

    private static abstract class ViewFactory {
        protected final Integer visualID;

        ViewFactory(final Integer visualID) {
            this.visualID = visualID;
        }

        protected abstract View createView(final EObject theElement, final View theContainer);
    }

    private static abstract class EdgeFactory extends ViewFactory {

        EdgeFactory(final Integer visualID) {
            super(visualID);
        }

        protected final Edge createEdge(final View theSource, final View theTarget, final EObject theElement,
                final View theContainer) {
            final IAdaptable viewModel = theElement != null ? getSemanticAdapter(theElement) : null;
            final Edge edge = (Edge) ViewService.getInstance().createEdge(viewModel, theContainer,
                    UMLVisualIDRegistry.getType(visualID), ViewUtil.APPEND, getTheClassDiagramPreferencesHint());
            if (edge != null) {
                edge.setSource(theSource);
                edge.setTarget(theTarget);
            }
            return edge;
        }

        protected abstract IAdaptable getSemanticAdapter(final EObject element);
    }

    private final class GeneralizationEdgeFactory extends EdgeFactory {

        GeneralizationEdgeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected View createView(final EObject theElement, final View theContainer) {
            final View theSource = getOrCreateTheView(getSpecific(theElement), theContainer);
            final View theTarget = getOrCreateTheView(getGeneral(theElement), theContainer);
            return super.createEdge(theSource, theTarget, theElement, theContainer);
        }

        @Override
        protected IAdaptable getSemanticAdapter(final EObject element) {
            return new EObjectAdapter(element) {
                @Override
                public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
                    return adapter == IElementType.class ? UMLElementTypes.Generalization_4002 : super.getAdapter(adapter);
                }
            };
        }
    }

    private static abstract class NodeFactory extends ViewFactory {
        NodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected Node createView(final EObject theElement, final View theContainer) {
            final Node theNode = ViewService.createNode(theContainer, theElement, UMLVisualIDRegistry.getType(visualID),
                    getThePreferencesHint());
            return theNode;
        }

        protected abstract PreferencesHint getThePreferencesHint();
    }

    private static final class AttributeNodeFactory extends NodeFactory {

        AttributeNodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected PreferencesHint getThePreferencesHint() {
            return getTheClassDiagramPreferencesHint();
        }

    }

    private abstract class DiagramNodeFactory extends NodeFactory {
        DiagramNodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected final Node createView(final EObject theElement, final View theContainer) {
            final Point theNextCoordinate = getTheNextCoordinate(theContainer);

            final Node theNode = super.createView(theElement, theContainer);

            final Bounds b = (Bounds) theNode.getLayoutConstraint();
            b.setX(theNextCoordinate.x);
            b.setY(theNextCoordinate.y);
            b.setWidth(getPreference(P_CLASS_DIAGRAM_ELEMENT_WIDTH));

            if (!diagrams2Nodes.containsKey(theContainer)) {
                diagrams2Nodes.put(theContainer, new ArrayList<Node>());
            }
            diagrams2Nodes.get(theContainer).add(theNode);
            return theNode;
        }

        private int getPreference(final String name) {
            return org.search.niem.uml.papyrus.Activator.INSTANCE.getIntPreference(name);
        }

        private Point getTheNextCoordinate(final View inTheContainer) {
            final int verticalPadding = getPreference(P_CLASS_DIAGRAM_VERTICAL_PADDING);
            final int column = diagrams2Nodes.containsKey(inTheContainer) ? diagrams2Nodes.get(inTheContainer).size()
                    % getPreference(P_CLASS_DIAGRAM_COLUMNS) : 0;
            int theLowestBound = Math.max(DEFAULT_ORIGIN.y, DEFAULT_ORIGIN.y - verticalPadding);
            int theLeftMargin = DEFAULT_ORIGIN.x;
            for (final Node n : EcoreUtil.<Node> getObjectsByType(inTheContainer.getVisibleChildren(),
                    NotationPackage.Literals.NODE)) {
                final LayoutConstraint l = n.getLayoutConstraint();
                if (NotationPackage.Literals.BOUNDS.isInstance(l)) {
                    final Bounds b = (Bounds) l;
                    final int aLowerBound;
                    if (column == 0) {
                        aLowerBound = b.getY() + verticalPadding
                                + (b.getHeight() < 0 ? getPreferredDimension(n).height : b.getHeight());
                    } else {
                        aLowerBound = b.getY();
                    }
                    theLowestBound = Math.max(theLowestBound, aLowerBound);
                    theLeftMargin = Math.min(theLeftMargin, b.getX());
                }
            }
            return new Point(column * getPreference(P_CLASS_DIAGRAM_COLUMN_WIDTH) + theLeftMargin, theLowestBound);
        }
    }

    private final class PackageDiagramNodeFactory extends DiagramNodeFactory {

        PackageDiagramNodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected PreferencesHint getThePreferencesHint() {
            return getThePackageDiagramPreferencesHint();
        }
    }

    private final class ComponentDiagramNodeFactory extends DiagramNodeFactory {

        ComponentDiagramNodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected PreferencesHint getThePreferencesHint() {
            return getTheComponentDiagramPreferencesHint();
        }
    }

    private final class ClassDiagramNodeFactory extends DiagramNodeFactory {

        ClassDiagramNodeFactory(final Integer visualID) {
            super(visualID);
        }

        @Override
        protected PreferencesHint getThePreferencesHint() {
            return getTheClassDiagramPreferencesHint();
        }
    }

    static final class ViewDiscriminant {
        final EClass theElementType;
        final String theContainerType;

        ViewDiscriminant(final EClass theElementType, final String theContainerType) {
            this.theElementType = theElementType;
            this.theContainerType = theContainerType;
        }

        @Override
        public boolean equals(final Object that) {
            return reflectionEquals(this, that);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }
    }
}
