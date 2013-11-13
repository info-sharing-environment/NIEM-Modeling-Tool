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
package org.search.niem.uml.ui.acceptance_tests;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.search.niem.uml.util.UMLExt;

public class PapyrusUtils {

    public static EditPart getActiveEditPart(final IMultiDiagramEditor theActiveEditor) {
        return ((IDiagramWorkbenchPart) theActiveEditor.getActiveEditor()).getDiagramEditPart();
    }

    public static EditPart findByName(final EditPart theParent, final String theName) {
        for (final Object o : theParent.getChildren()) {
            final EditPart editPart = (EditPart) o;
            if (ObjectUtils.equals(theName, UMLExt.getName(((Shape) editPart.getModel()).getElement()))) {
                return editPart;
            }
        }
        return null;
    }

    public static EditPart findByElement(final EditPart theParent, final EObject theElement) {
        for (final Object o : theParent.getChildren()) {
            final EditPart editPart = (EditPart) o;
            if (ObjectUtils.equals(theElement, ((Shape) editPart.getModel()).getElement())) {
                return editPart;
            }
        }
        return null;
    }

    public static void doubleClick(final EditPart theEditPart) {
        final SelectionRequest request = new SelectionRequest();
        request.setType(RequestConstants.REQ_OPEN);
        theEditPart.performRequest(request);
    }

    @SuppressWarnings("unchecked")
    private static <T extends PaletteEntry> T findByLabel(final PaletteContainer thePaletteContainer, final String theLabel) {
        final String[] path = theLabel.split("/");
        PaletteEntry nextEntry = thePaletteContainer;
        NEXT_SEGMENT: for (final String segment : path) {
            if (nextEntry instanceof PaletteContainer) {
                for (final Object o : ((PaletteContainer) nextEntry).getChildren()) {
                    final PaletteEntry paletteEntry = (PaletteEntry) o;
                    if (ObjectUtils.equals(segment, paletteEntry.getLabel())) {
                        nextEntry = paletteEntry;
                        continue NEXT_SEGMENT;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (T) nextEntry;
    }

    public static void doubleClick(final Tool theTool, final EditPartViewer theEditPartViewer) {
        theTool.mouseDoubleClick(newLeftClick(theEditPartViewer), theEditPartViewer);
    }

    public static void leftClick(final Tool theTool, final EditPartViewer theViewer) {
        theTool.mouseDown(newLeftClick(theViewer), theViewer);
        // theTool.mouseDrag(newLeftClick(theViewer), theViewer);
        // theTool.mouseUp(newLeftClick(theViewer), theViewer);

        theViewer.getEditDomain().setActiveTool(theTool);
    }

    public static void leftClick(final Tool theTool, final GraphicalEditPart theEditPart) {
        final EditPartViewer theViewer = theEditPart.getViewer();
        final Event e = new Event();
        final Control theControl = theViewer.getControl();
        final Point theLocation = theControl.toDisplay(0, 0);
        e.x = theLocation.x;
        e.y = theLocation.y;
        e.widget = theControl;
        e.button = 1;
        theControl.notifyListeners(SWT.MouseEnter, e);
        theControl.notifyListeners(SWT.MouseDown, e);
        theControl.notifyListeners(SWT.MouseUp, e);
        // final IFigure aFigure = theEditPart.getFigure();
        // final DomainEventDispatcher dispatcher = (DomainEventDispatcher) aFigure.internalGetEventDispatcher();
        // MouseEvent me = newLeftClick(theViewer);
        // final Node theNode = (Node) theEditPart.getAdapter(Node.class);
        // final Bounds b = (Bounds) theNode.getLayoutConstraint();
        // me.x = b.getX();
        // me.y = b.getY();
        // dispatcher.dispatchMouseMoved(me);
        // dispatcher.dispatchMouseEntered(me);
        // me = newLeftClick(theViewer);
        // me.x = b.getX();
        // me.y = b.getY();
        // dispatcher.dispatchMousePressed(me);
        // me = newLeftClick(theViewer);
        // me.x = b.getX();
        // me.y = b.getY();
        // dispatcher.dispatchMouseReleased(me);
        // aFigure.internalGetEventDispatcher().dispatchMouseReleased(newMouseEvent(theEditPartViewer));
        // aFigure.handleMousePressed(newMouseEvent(aFigure, theEditPartViewer));
        // aFigure.handleMouseReleased(newMouseEvent(aFigure, theEditPartViewer));
    }

    private static org.eclipse.draw2d.MouseEvent newMouseEvent(final IFigure aFigure, final EditPartViewer anEditPartViewer) {
        return new org.eclipse.draw2d.MouseEvent(aFigure.internalGetEventDispatcher(), aFigure,
                newLeftClick(anEditPartViewer));
    }

    private static MouseEvent newLeftClick(final EditPartViewer anEditPartViewer) {
        final Event theEvent = new Event();
        theEvent.widget = anEditPartViewer.getControl();
        final MouseEvent mouseEvent = new MouseEvent(theEvent);
        mouseEvent.button = 1;
        return mouseEvent;
    }

    public static Tool findThePaletteTool(final EditPart theEditPart, final String toolPath) {
        final EditPartViewer theEditPartViewer = theEditPart.getViewer();
        final PaletteViewer thePaletteViewer = theEditPartViewer.getEditDomain().getPaletteViewer();
        final ToolEntry toolEntry = findByLabel(thePaletteViewer.getPaletteRoot(), toolPath);
        thePaletteViewer.setActiveTool(toolEntry);

        final Tool theTool = toolEntry.createTool();
        theTool.setViewer(theEditPartViewer);
        theTool.setEditDomain(theEditPartViewer.getEditDomain());

        return theTool;
    }
}
