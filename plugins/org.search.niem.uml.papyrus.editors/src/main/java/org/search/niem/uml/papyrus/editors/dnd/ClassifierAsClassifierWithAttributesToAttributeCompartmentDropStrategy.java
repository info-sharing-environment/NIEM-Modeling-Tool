package org.search.niem.uml.papyrus.editors.dnd;

import static org.search.niem.uml.papyrus.util.DiagramExt.dropClassifierWithAttributesInDiagram;
import static org.search.niem.uml.util.UMLExt.getOwnedAttributes;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Package;
import org.search.niem.uml.papyrus.editors.Activator;

public class ClassifierAsClassifierWithAttributesToAttributeCompartmentDropStrategy extends TransactionalDropStrategy {

    @Override
    public String getLabel() {
        return Activator.INSTANCE
                .getString("_UI_ClassifierAsClassifierWithAttributesToAttributeCompartmentDropStrategy_label");
    }

    @Override
    public String getDescription() {
        return Activator.INSTANCE
                .getString("_UI_ClassifierAsClassifierWithAttributesToAttributeCompartmentDropStrategy_description");
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public String getID() {
        return getClass().getName();
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected Command doGetCommand(final Request request, final EditPart targetEditPart) {
        if (!(request instanceof DropObjectsRequest)) {
            return null;
        }
        final DropObjectsRequest dropRequest = (DropObjectsRequest) request;
        final EObject targetSemanticElement = getTargetSemanticElement(targetEditPart);

        if (targetSemanticElement instanceof Package && dropRequest.getLocation() != null
                && targetEditPart instanceof IGraphicalEditPart) {
            final IGraphicalEditPart graphicalTargetEditPart = (IGraphicalEditPart) targetEditPart;

            final Point location = dropRequest.getLocation().getCopy();
            graphicalTargetEditPart.getContentPane().translateToRelative(location);
            graphicalTargetEditPart.getContentPane().translateFromParent(location);
            location.translate(graphicalTargetEditPart.getContentPane().getClientArea().getLocation().getNegated());

            final List<EObject> sourceEObjects = getSourceEObjects(request);
            if (sourceEObjects.size() == 1) {
                final EObject sourceEObject = sourceEObjects.get(0);
                if (itHasOwnedAttributes(sourceEObject)) {
                    final TransactionalEditingDomain theEditingDomain = getTransactionalEditingDomain(targetEditPart);
                    final Command c = dropClassifierWithAttributesInDiagram(graphicalTargetEditPart, sourceEObject,
                            location, theEditingDomain);
                    return c.canExecute() ? c : null;
                }
            }
        }
        return null;
    }

    private boolean itHasOwnedAttributes(final EObject anElement) {
        return !getOwnedAttributes(anElement).isEmpty();
    }
}
