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
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_QVT_SAVE_EDITOR_DO_NOT_ASK;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SAMPLE_XML_SUFFIX;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SHOW_GENERATE_MPD;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SHOW_INDIVIDUAL_TRANSFORMS;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SAMPLES_FOLDER;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SCHEMAS_FOLDER;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.search.niem.uml.qvt.ui.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
        final IPreferenceStore store = Activator.getPlugin().getPreferenceStore();
        store.setDefault(P_SHOW_GENERATE_MPD, true);
        store.setDefault(P_SHOW_INDIVIDUAL_TRANSFORMS, false);
        store.setDefault(P_QVT_SAVE_EDITOR_DO_NOT_ASK, false);
        store.setDefault(P_MPD_CATALOG_FILE_NAME, "MPD_Catalog.xml");
        store.setDefault(P_XML_SCHEMAS_FOLDER, "XMLschemas");
        store.setDefault(P_XML_SAMPLES_FOLDER, "XMLsamples");
        store.setDefault(P_SAMPLE_XML_SUFFIX, "_Sample");
        store.setDefault(P_CHANGELOG_FILE_NAME, "changelog.txt");
    }
}
