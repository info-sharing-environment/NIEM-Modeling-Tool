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
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.exists;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.has_applied_profile;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.is_not_open_to_the_niem_uml_perspective;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.is_open_in_papyrus;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.is_open_to_the_niem_uml_perspective;
import static org.search.niem.uml.ui.acceptance_tests.UMLUtils.get_the_root_model;
import static org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryNiemUmlModel.THE_MODEL_NAME;
import static org.search.niem.uml.util.NIEMTypes.Model_Package_Description_Profile;
import static org.search.niem.uml.util.NIEMTypes.NIEM_Common_Profile;
import static org.search.niem.uml.util.NIEMTypes.NIEM_PIM_Profile;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryNiemUmlModel;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryProject;
import org.search.niem.uml.ui.acceptance_tests.rules.DisablesProjectPerspectiveSwitching;
import org.search.niem.uml.ui.acceptance_tests.rules.OpensEditors;
import org.search.niem.uml.ui.acceptance_tests.rules.SwitchesPerspectives;

public class NiemUmlModelTest {

    private final DisablesProjectPerspectiveSwitching preferencesRule;
    private final CreatesATemporaryProject theProjectProvider;
    private final CreatesATemporaryNiemUmlModel theModelProvider;

    // @formatter:off
    @Rule
    public final TestRule ruleChain = RuleChain
        .outerRule(preferencesRule = new DisablesProjectPerspectiveSwitching())
        .around(new SwitchesPerspectives())
        .around(theProjectProvider = new CreatesATemporaryProject())
        .around(theModelProvider = new CreatesATemporaryNiemUmlModel(theProjectProvider))
        .around(new OpensEditors());
    // @formatter:on

    @Test
    public void can_create_a_niem_uml_model() throws CoreException {
        assertThat(theModelProvider.getTheDiagramModel(), exists());
        assertThat(theModelProvider.getTheNiemUmlModel(), exists());
        assertThat(theModelProvider.getTheNotationModel(), exists());
    }

    @Test
    public void should_apply_niem_profiles_to_the_new_model() throws CoreException {
        final Model theRootModel = get_the_root_model(theModelProvider.getTheNiemUmlModel());
        final Package thePim = theRootModel.getNestedPackage(THE_MODEL_NAME + "PIM");
        final Package theIEPD = theRootModel.getNestedPackage(THE_MODEL_NAME + "IEPD");

        assertThat(thePim, has_applied_profile(NIEM_Common_Profile));
        assertThat(thePim, has_applied_profile(NIEM_PIM_Profile));
        assertThat(theIEPD, has_applied_profile(Model_Package_Description_Profile));
    }

    @Test
    public void should_open_the_papyrus_diagram_editor_for_the_model() throws CoreException {
        assertThat(theModelProvider.getTheDiagramModel(), is_open_in_papyrus());
    }

    @Test
    public void should_switch_to_the_niem_uml_perspective() throws CoreException {
        preferencesRule.setPerspectiveSwitching(IWorkbenchPreferenceConstants.OPEN_PERSPECTIVE_REPLACE,
                MessageDialogWithToggle.ALWAYS);

        final IWorkbench theWorkbench = PlatformUI.getWorkbench();
        assertThat(theWorkbench, is_not_open_to_the_niem_uml_perspective());

        theModelProvider.create_a_niem_model(THE_MODEL_NAME + 2);

        assertThat(theWorkbench, is_open_to_the_niem_uml_perspective());
    }
}
