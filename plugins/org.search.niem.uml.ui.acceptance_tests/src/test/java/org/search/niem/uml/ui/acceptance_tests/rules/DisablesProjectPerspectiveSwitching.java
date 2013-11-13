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
package org.search.niem.uml.ui.acceptance_tests.rules;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.ide.IDE;
import org.junit.rules.ExternalResource;

public class DisablesProjectPerspectiveSwitching extends ExternalResource {

    @SuppressWarnings("restriction")
    private static final String PREFERENCE_SWITCH_PERSPECTIVE_MODE = org.eclipse.ui.internal.ide.IDEInternalPreferences.PROJECT_SWITCH_PERSP_MODE;
    private static final String PREFERENCE_OPEN_NEW_PERSPECTIVE = IDE.Preferences.PROJECT_OPEN_NEW_PERSPECTIVE;

    private IPreferenceStore apiPreferences;
    private IPreferenceStore workbenchPreferences;

    private String openNewPerspective;
    private String switchPerspectiveMode;

    @Override
    @SuppressWarnings("restriction")
    protected void before() throws Throwable {
        apiPreferences = org.eclipse.ui.internal.util.PrefUtil.getAPIPreferenceStore();
        workbenchPreferences = org.eclipse.ui.internal.ide.IDEWorkbenchPlugin.getDefault().getPreferenceStore();

        openNewPerspective = apiPreferences.getString(PREFERENCE_OPEN_NEW_PERSPECTIVE);
        switchPerspectiveMode = workbenchPreferences.getString(PREFERENCE_SWITCH_PERSPECTIVE_MODE);

        setPerspectiveSwitching(IWorkbenchPreferenceConstants.NO_NEW_PERSPECTIVE, MessageDialogWithToggle.NEVER);
    }

    @Override
    protected void after() {
        setPerspectiveSwitching(openNewPerspective, switchPerspectiveMode);
    }

    public void setPerspectiveSwitching(final String openNewPerspective, final String switchPerspectiveMode) {
        apiPreferences.setValue(PREFERENCE_OPEN_NEW_PERSPECTIVE, openNewPerspective);
        workbenchPreferences.setValue(PREFERENCE_SWITCH_PERSPECTIVE_MODE, switchPerspectiveMode);
    }
}
