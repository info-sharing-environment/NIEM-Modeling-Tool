package org.search.niem.uml.papyrus.editors.handlers;

import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DISPLAY_MESSAGE_FOR_HIDE_ACTION;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.search.niem.uml.papyrus.editors.Activator;

public class DeleteFromDiagramCommandHandler extends
        org.eclipse.papyrus.uml.diagram.common.handlers.DeleteFromModelCommandHandler {

    @Override
    protected Command getCommand() {
        final TransactionalEditingDomain editingDomain = getEditingDomain();
        if (editingDomain == null) {
            return UnexecutableCommand.INSTANCE;
        }
        final List<IGraphicalEditPart> editParts = getSelectedElements();
        if (editParts.isEmpty()) {
            return UnexecutableCommand.INSTANCE;
        }

        final CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Delete From Model");

        final Iterator<IGraphicalEditPart> it = editParts.iterator();
        while (it.hasNext()) {
            final IGraphicalEditPart editPart = it.next();

            if (!(editPart instanceof DiagramEditPart)) {
                final Command c = editPart.getCommand(new GroupRequest(RequestConstants.REQ_DELETE));

                if (c != null) {
                    command.compose(new CommandProxy(c));
                }
            }
        }

        if (command.isEmpty()) {
            return UnexecutableCommand.INSTANCE;
        }

        return new ICommandProxy(command);
    }

    // TODO: Remove for Luna
    // This is overridden in order to correct a misspelling and in order to allow the preference value to be persisted
    @Override
    protected boolean canDoAction() {
        final IPreferenceStore store = org.search.niem.uml.papyrus.Activator.getPlugin().getPreferenceStore();
        if (store.getBoolean(P_DISPLAY_MESSAGE_FOR_HIDE_ACTION)) {
            final MessageDialogWithToggle toggle = MessageDialogWithToggle.openYesNoQuestion(Display.getDefault()
                    .getActiveShell(), Activator.INSTANCE.getString("_UI_HideCommandHandler_title"), Activator.INSTANCE
                    .getString("_UI_HideCommandHandler_message"), Activator.INSTANCE
                    .getString("_UI_HideCommandHandler_toggleMessage"), false, null, null);
            store.setValue(P_DISPLAY_MESSAGE_FOR_HIDE_ACTION, !toggle.getToggleState());
            return toggle.getReturnCode() == IDialogConstants.YES_ID;
        }
        return true;
    }
}
