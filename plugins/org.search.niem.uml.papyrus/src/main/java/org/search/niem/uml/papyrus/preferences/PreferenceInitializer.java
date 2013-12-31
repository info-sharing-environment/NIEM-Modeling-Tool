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
package org.search.niem.uml.papyrus.preferences;

import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_ADDRESS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_NAME;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_WEBSITE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMNS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMN_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_ELEMENT_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_VERTICAL_PADDING;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DEFAULT_MODEL_NAME;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DOMAINS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXCHANGE_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXTENSION_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_KEYWORDS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_BASE_URI;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_DESCRIPTION;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_PURPOSE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_SECURITY_MARKING;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_VERSION_NUMBER;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_RESTRICT_NIEM_SUBSET_CONTENT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_SYNC_CLASS_DIAGRAMS_WITH_UML;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.uml.AggregationKind;
import org.search.niem.uml.papyrus.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
        final IPreferenceStore store = Activator.getPlugin().getPreferenceStore();
        store.setDefault(P_DEFAULT_MODEL_NAME, NewModelFilePage.DEFAULT_NAME);
        store.setDefault(P_EXCHANGE_MODEL_TARGET_NAMESPACE, "http://example/Exchange");
        store.setDefault(P_EXTENSION_MODEL_TARGET_NAMESPACE, "http://example/Extension");
        store.setDefault(P_MPD_BASE_URI, "http://example/MPD");
        store.setDefault(P_MPD_VERSION_NUMBER, "1.0");
        store.setDefault(P_MPD_DESCRIPTION, "");
        store.setDefault(P_MPD_PURPOSE, "");
        store.setDefault(P_MPD_SECURITY_MARKING, "Unclassified");
        store.setDefault(P_DOMAINS, "");
        store.setDefault(P_KEYWORDS, "");
        store.setDefault(P_AUTHORITATIVE_SOURCE_NAME, "");
        store.setDefault(P_AUTHORITATIVE_SOURCE_ADDRESS, "");
        store.setDefault(P_AUTHORITATIVE_SOURCE_WEBSITE, "");

        store.setDefault(P_SYNC_CLASS_DIAGRAMS_WITH_UML, true);
        store.setDefault(P_RESTRICT_NIEM_SUBSET_CONTENT, true);
        NIEMPreferenceConverter.setDefault(store, PreferenceConstants.P_INITIAL_PROPERTY_AGGREGATION,
                AggregationKind.COMPOSITE_LITERAL);
        PreferenceConverter.setDefault(store, P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR, new RGB(0xFF, 0, 0));
        store.setDefault(P_CLASS_DIAGRAM_COLUMNS, 3);
        store.setDefault(P_CLASS_DIAGRAM_COLUMN_WIDTH, 264);
        store.setDefault(P_CLASS_DIAGRAM_ELEMENT_WIDTH, 225);
        store.setDefault(P_CLASS_DIAGRAM_VERTICAL_PADDING, 30);
    }
}
