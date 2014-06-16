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
package org.search.niem.uml.papyrus.editors.handlers;

import static org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked;
import static org.eclipse.ui.handlers.HandlerUtil.getActiveShellChecked;
import static org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked;
import static org.search.niem.uml.search.ui.ReferenceLibrarySearchUtil.findTheReferenceLibraryEquivalentOf;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.search.niem.uml.search.ui.FontsAndColors;
import org.search.niem.uml.search.ui.SubsetUpdater;

public class UpdateSubset extends AbstractHandler {

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IGraphicalEditPart theCurrentSelection = (IGraphicalEditPart) ((StructuredSelection) getCurrentSelectionChecked(event))
                .getFirstElement();
        final IFigure theFigure = theCurrentSelection.getFigure();
        final EObject theReferenceLibraryElement = findTheReferenceLibraryEquivalentOf(theCurrentSelection
                .resolveSemanticElement());
        new SubsetUpdater(getActiveShellChecked(event), new FontsAndColors(theFigure.getFont(),
                theFigure.getForegroundColor(), theFigure.getBackgroundColor()), (ServicesRegistry) getActiveEditorChecked(
                        event).getAdapter(ServicesRegistry.class), theReferenceLibraryElement).updateTheSubset();
        return null;
    }
}
