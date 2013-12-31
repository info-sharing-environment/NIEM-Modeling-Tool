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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.uml.AggregationKind;

public class NIEMPreferenceConverter {

    public static void setDefault(final IPreferenceStore store, final String name, final AggregationKind value) {
        store.setDefault(name, value.getName());
    }

    public static void setValue(final IPreferenceStore store, final String name, final AggregationKind value) {
        final AggregationKind oldValue = getAggregationKind(store, name);
        if (oldValue == null || !oldValue.equals(value)) {
            store.putValue(name, asString(value));
            store.firePropertyChangeEvent(name, oldValue, value);
        }
    }

    public static AggregationKind getAggregationKind(final IPreferenceStore store, final String name) {
        return AggregationKind.getByName(store.getString(name));
    }

    private static String asString(final AggregationKind value) {
        return value == null ? null : value.getName();
    }
}
