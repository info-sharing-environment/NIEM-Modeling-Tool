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
package org.search.niem.uml.qvt.ui.propertyTesters;

import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SHOW_GENERATE_MPD;

import org.eclipse.core.expressions.PropertyTester;
import org.search.niem.uml.qvt.ui.Activator;

public class ShouldShowGenerateMPD extends PropertyTester {

    @Override
    public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
        return Activator.getPlugin().getPreferenceStore().getBoolean(P_SHOW_GENERATE_MPD);
    }
}
