package org.search.niem.uml.papyrus.editors.handlers;

import static org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider.getSetQualifiedNameDepthCommand;
import static org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked;
import static org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getTheEditingDomain;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart;

public abstract class ShowName extends AbstractHandler {

    @Override
    public final Object execute(final ExecutionEvent event) throws ExecutionException {
        final UMLNodeEditPart theCurrentSelection = (UMLNodeEditPart) ((StructuredSelection) getCurrentSelectionChecked(event))
                .getFirstElement();
        final ServicesRegistry theServicesRegistry = (ServicesRegistry) getActiveEditorChecked(event).getAdapter(
                ServicesRegistry.class);
        final TransactionalEditingDomain theEditingDomain = getTheEditingDomain(theServicesRegistry);

        final Command theCommand = getSetQualifiedNameDepthCommand(theEditingDomain, theCurrentSelection.getNotationView(),
                getDepth());

        theEditingDomain.getCommandStack().execute(theCommand);

        return null;
    }

    protected abstract int getDepth();
}