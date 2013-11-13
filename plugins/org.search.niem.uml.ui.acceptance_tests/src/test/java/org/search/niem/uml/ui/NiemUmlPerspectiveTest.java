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
package org.search.niem.uml.ui;

import static org.junit.Assert.assertThat;
import static org.search.niem.uml.ui.PerspectiveFactory.THE_NIEM_UML_PERSPECTIVE_ID;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.is_open_to_the_niem_uml_perspective;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_active_workbench_window;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_workbench;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.WorkbenchException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.search.niem.uml.ui.acceptance_tests.rules.SwitchesPerspectives;

public class NiemUmlPerspectiveTest {

    @Rule
    public final TestRule perspectiveSwitchingRule = new SwitchesPerspectives();

    @Test
    public void can_switch_to_the_niem_uml_perspective() throws WorkbenchException {
        final IWorkbench theWorkbench = get_the_workbench();
        theWorkbench.showPerspective(THE_NIEM_UML_PERSPECTIVE_ID, get_the_active_workbench_window());

        assertThat(theWorkbench, is_open_to_the_niem_uml_perspective());
    }
}
