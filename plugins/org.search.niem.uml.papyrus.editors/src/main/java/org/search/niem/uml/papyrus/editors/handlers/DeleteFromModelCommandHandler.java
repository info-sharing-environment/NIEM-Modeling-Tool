package org.search.niem.uml.papyrus.editors.handlers;

import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DISPLAY_MESSAGE_FOR_DELETE_ACTION;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.search.niem.uml.papyrus.editors.Activator;

public class DeleteFromModelCommandHandler extends
        org.eclipse.papyrus.uml.diagram.common.handlers.DeleteFromModelCommandHandler {

    // TODO: Remove for Luna
    // This is overridden in order to correct a misspelling and in order to allow the preference value to be persisted
    @Override
    protected boolean canDoAction() {
        final IPreferenceStore store = org.search.niem.uml.papyrus.Activator.getPlugin().getPreferenceStore();
        if (store.getBoolean(P_DISPLAY_MESSAGE_FOR_DELETE_ACTION)) {
            final MessageDialogWithToggle toggle = MessageDialogWithToggle.openYesNoQuestion(Display.getDefault()
                    .getActiveShell(), Activator.INSTANCE.getString("_UI_DeleteFromModelCommandHandler_title"),
                    Activator.INSTANCE.getString("_UI_DeleteFromModelCommandHandler_message"), Activator.INSTANCE
                            .getString("_UI_DeleteFromModelCommandHandler_toggleMessage"), false, null, null);
            store.setValue(P_DISPLAY_MESSAGE_FOR_DELETE_ACTION, !toggle.getToggleState());
            return toggle.getReturnCode() == IDialogConstants.YES_ID;
        }
        return true;
    }
}
