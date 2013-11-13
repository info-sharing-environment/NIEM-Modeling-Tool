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

import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_CHANGELOG_FILE_NAME;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_MPD_CATALOG_FILE_NAME;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SAMPLE_XML_SUFFIX;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SAMPLES_FOLDER;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SCHEMAS_FOLDER;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.search.niem.uml.qvt.ui.Activator;

public class MPDOutputPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public MPDOutputPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getPlugin().getPreferenceStore());
        setDescription(Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_description"));
    }

    @Override
    public void createFieldEditors() {
        addField(new StringFieldEditor(P_MPD_CATALOG_FILE_NAME,
                Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_mpdCatalogFileName"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_XML_SCHEMAS_FOLDER,
                Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_xmlSchemasFolder"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_XML_SAMPLES_FOLDER,
                Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_xmlSamplesFolder"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_SAMPLE_XML_SUFFIX,
                Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_sampleXmlSuffix"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_CHANGELOG_FILE_NAME,
                Activator.INSTANCE.getString("_UI_MPDOutputPreferencePage_changelogFileName"), getFieldEditorParent()));
    }

    @Override
    public void init(final IWorkbench workbench) {
    }
}