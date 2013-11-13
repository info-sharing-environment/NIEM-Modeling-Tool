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
package org.search.niem.uml.qvt.ui.preferences;

import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_QVT_SAVE_EDITOR_DO_NOT_ASK;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SHOW_GENERATE_MPD;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SHOW_INDIVIDUAL_TRANSFORMS;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.search.niem.uml.qvt.ui.Activator;

public class TransformsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public TransformsPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getPlugin().getPreferenceStore());
        setDescription(Activator.INSTANCE.getString("_UI_TransformsPreferencePage_description"));
    }

    @Override
    public void createFieldEditors() {
        addField(new BooleanFieldEditor(P_SHOW_INDIVIDUAL_TRANSFORMS,
                Activator.INSTANCE.getString("_UI_TransformsPreferencePage_showIndividualTransformsPreference"),
                getFieldEditorParent()));
        addField(new BooleanFieldEditor(P_SHOW_GENERATE_MPD,
                Activator.INSTANCE.getString("_UI_TransformsPreferencePage_showGenerateMPDPreference"),
                getFieldEditorParent()));
        addField(new BooleanFieldEditor(P_QVT_SAVE_EDITOR_DO_NOT_ASK,
                Activator.INSTANCE.getString("_UI_TransformsPreferencePage_doNotAskToSaveEditorBeforeRunningQVTO"),
                getFieldEditorParent()));
    }

    @Override
    public void init(final IWorkbench workbench) {
    }
}