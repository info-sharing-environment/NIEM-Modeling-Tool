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
package org.search.niem.uml.papyrus.util;

import static org.search.niem.uml.util.UMLExt.getOwnedAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateViewCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.util.UMLExt;

public class DiagramExt {

    public static void destroy(final EObject aView) {
        if (aView instanceof View) {
            ViewUtil.destroy((View) aView);
        } else {
            EcoreUtil.remove(aView);
        }
    }

    public static Collection<EObject> collectViews(final Iterable<? extends EObject> data, final Resource theNotationResource) {
        final Collection<EObject> views = new ArrayList<>();
        if (theNotationResource != null) {
            for (final EObject e : data) {
                final Collection<Setting> theNotationReferences = EcoreUtil.UsageCrossReferencer
                        .find(e, theNotationResource);
                for (final Setting setting : theNotationReferences) {
                    views.add(setting.getEObject());
                }
            }
        }
        return views;
    }

    public static Diagram createAPackageDiagram(final EObject theElement, final Resource theDiagramResource,
            final IPageManager thePageManager) {
        return createADiagram(getThePackageDiagramKind(), getThePackageDiagramPreferencesHint(), theElement,
                theDiagramResource, thePageManager);
    }

    public static Diagram createAComponentDiagram(final EObject theElement, final Resource theDiagramResource,
            final IPageManager thePageManager) {
        return createADiagram(getTheComponentDiagramKind(), getTheComponentDiagramPreferencesHint(), theElement,
                theDiagramResource, thePageManager);
    }

    public static Diagram createAClassDiagram(final EObject theElement, final Resource theDiagramResource,
            final IPageManager thePageManager) {
        return createADiagram(getTheClassDiagramKind(), getTheClassDiagramPreferencesHint(), theElement, theDiagramResource,
                thePageManager);
    }

    private static Diagram createADiagram(final String kind, final PreferencesHint thePreferencesHint,
            final EObject theElement, final Resource theDiagramResource, final IPageManager thePageManager) {
        final Diagram theDiagram = ViewService.createDiagram(theElement, kind, thePreferencesHint);
        if (theDiagram != null) {
            theDiagram.setName(UMLExt.getName(theElement));
            theDiagram.setElement(theElement);
            theDiagramResource.getContents().add(theDiagram);
            thePageManager.addPage(theDiagram);
        }
        return theDiagram;
    }

    public static void createAnHyperLink(final EModelElement theSource, final EObject theTarget) {
        final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
        eAnnotation.setSource(HyperLinkConstants.PAPYRUS_HYPERLINK_PAGE);
        eAnnotation.getReferences().add(theTarget);
        final String theName = UMLExt.getName(theTarget);
        updateAnHyperLink(eAnnotation, theName, theName);
        eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, Boolean.toString(true));
        theSource.getEAnnotations().add(eAnnotation);
    }

    public static void updateAnHyperLink(final EModelElement theSource, final String theName, final String theTooltip) {
        final EAnnotation theHyperLinkAnnotation = theSource.getEAnnotation(HyperLinkConstants.PAPYRUS_HYPERLINK_PAGE);
        if (theHyperLinkAnnotation != null) {
            updateAnHyperLink(theHyperLinkAnnotation, theName, theTooltip);
        }
    }

    private static void updateAnHyperLink(final EAnnotation eAnnotation, final String name, final String tooltip) {
        eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, tooltip);
        eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_PAGE_NAME, name);
    }

    public static String getThePackageDiagramKind() {
        return ElementTypes.DIAGRAM_ID;
    }

    public static PreferencesHint getThePackageDiagramPreferencesHint() {
        return org.eclipse.papyrus.uml.diagram.pkg.Activator.DIAGRAM_PREFERENCES_HINT;
    }

    public static String getTheComponentDiagramKind() {
        return ComponentDiagramEditPart.MODEL_ID;
    }

    public static PreferencesHint getTheComponentDiagramPreferencesHint() {
        return org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
    }

    public static String getTheClassDiagramKind() {
        return ModelEditPart.MODEL_ID;
    }

    public static PreferencesHint getTheClassDiagramPreferencesHint() {
        return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
    }

    public static IFile getTheCorrespondingUmlFile(final IFile diagram) {
        final IPath theDiagramPath = diagram.getFullPath();
        final IContainer theParent = diagram.getParent();
        final IFile theUMLFile = theParent.getFile(theDiagramPath.removeFirstSegments(theDiagramPath.segmentCount() - 1)
                .removeFileExtension().addFileExtension(UMLResource.FILE_EXTENSION));
        return theUMLFile.exists() ? theUMLFile : null;
    }

    public static View getTheAttributeCompartment(final View aClassifierView) {
        final List<?> compartments = aClassifierView.getChildren();
        return compartments.size() > 1 ? (View) compartments.get(1) : null;
    }

    private static Command moveTheView(final TransactionalEditingDomain anEditingDomain, final IAdaptable aViewAdapter,
            final Point aLocation) {
        return new ICommandProxy(new SetBoundsCommand(anEditingDomain,
                Activator.INSTANCE.getString("_UI_MoveClassifierWithAttributes_command_label"), aViewAdapter, aLocation));
    }

    public static Command dropClassifierWithAttributesInDiagram(final IGraphicalEditPart graphicalTarget,
            final EObject aClassifier, final Point location, final TransactionalEditingDomain theEditingDomain) {
        final EditPart anExistingEditPart = graphicalTarget.findEditPart(graphicalTarget, aClassifier);
        if (anExistingEditPart != null) {
            return moveTheView(theEditingDomain, anExistingEditPart, location);
        }

        final CompoundCommand theCommand = new CompoundCommand(
                Activator.INSTANCE.getString("_UI_DropClassifierWithAttributes_command_label"));

        final View thePackageDiagram = (View) graphicalTarget.getModel();
        final IHintedType theClassifierViewType = (IHintedType) UMLElementTypes.getElementType(UMLVisualIDRegistry
                .getNodeVisualID(thePackageDiagram, aClassifier));

        final ViewDescriptor theClassifierViewDescriptor = new ViewDescriptor(new EObjectAdapter(aClassifier), Node.class,
                theClassifierViewType.getSemanticHint(), ViewUtil.APPEND, false, graphicalTarget.getDiagramPreferencesHint());
        final CreateViewCommand createTheClassifierView = new CreateViewCommand(theEditingDomain,
                theClassifierViewDescriptor, thePackageDiagram);
        final IAdaptable theClassifierViewAdapter = (IAdaptable) createTheClassifierView.getCommandResult().getReturnValue();
        final Command setTheClassifierViewLocation = moveTheView(theEditingDomain, theClassifierViewAdapter, location);

        theCommand.add(new ICommandProxy(createTheClassifierView));
        theCommand.add(setTheClassifierViewLocation);

        final Collection<Property> ownedAttributes = getOwnedAttributes(aClassifier);
        for (final Property anAttribute : ownedAttributes) {
            theCommand.add(new DelegatingCreateAttributeViewCommand(theEditingDomain, anAttribute, theClassifierViewAdapter,
                    getTheClassDiagramPreferencesHint()));
        }
        return theCommand;
    }

    private static final class DelegatingCreateAttributeViewCommand extends Command {
        private final TransactionalEditingDomain theEditingDomain;
        private final EObject theSemanticElement;
        private final IAdaptable aViewAdapter;
        private final PreferencesHint thePreferencesHint;

        DelegatingCreateAttributeViewCommand(final TransactionalEditingDomain theEditingDomain,
                final EObject theSemanticElement, final IAdaptable aClassViewAdapter,
                final PreferencesHint thePreferencesHint) {
            super(Activator.INSTANCE.getString("_UI_CreateAttributeView_command_label"));
            this.theEditingDomain = theEditingDomain;
            this.theSemanticElement = theSemanticElement;
            aViewAdapter = aClassViewAdapter;
            this.thePreferencesHint = thePreferencesHint;
        }

        private CreateViewCommand createTheView;

        @Override
        public void execute() {
            final View theView = (View) aViewAdapter.getAdapter(View.class);
            if (theView == null) {
                return;
            }
            final View theAttributeCompartment = getTheAttributeCompartment(theView);
            if (theAttributeCompartment == null) {
                return;
            }
            final IHintedType theViewType = (IHintedType) UMLElementTypes.getElementType(UMLVisualIDRegistry
                    .getNodeVisualID(theAttributeCompartment, theSemanticElement));
            final ViewDescriptor theViewDescriptor = new ViewDescriptor(new EObjectAdapter(theSemanticElement), Node.class,
                    theViewType.getSemanticHint(), ViewUtil.APPEND, false, thePreferencesHint);
            createTheView = new CreateViewCommand(theEditingDomain, theViewDescriptor, theAttributeCompartment);
            try {
                createTheView.execute(null, null);
            } catch (final ExecutionException e) {
                Activator.INSTANCE.log(e);
            }
        }

        @Override
        public boolean canUndo() {
            return createTheView != null && createTheView.canUndo();
        }

        @Override
        public void undo() {
            try {
                createTheView.undo(null, null);
            } catch (final ExecutionException e) {
                Activator.INSTANCE.log(e);
            }
        }

        @Override
        public void redo() {
            try {
                createTheView.redo(null, null);
            } catch (final ExecutionException e) {
                Activator.INSTANCE.log(e);
            }
        }

        @Override
        public void dispose() {
            try {
                if (createTheView != null) {
                    createTheView.dispose();
                }
            } finally {
                super.dispose();
            }
        }
    }
}
