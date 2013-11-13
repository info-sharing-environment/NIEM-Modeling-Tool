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
import static org.search.niem.uml.qvt.ui.Activator.NIEM_PIM_2_PSM_ID;
import static org.search.niem.uml.ui.acceptance_tests.CommandUtils.run_the_command;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.has_applied_profile;
import static org.search.niem.uml.ui.acceptance_tests.UMLUtils.get_the_root_model;
import static org.search.niem.uml.util.NIEMTypes.Model_Package_Description_Profile;
import static org.search.niem.uml.util.NIEMTypes.NIEM_Common_Profile;
import static org.search.niem.uml.util.NIEMTypes.NIEM_PSM_Profile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.uml2.uml.Package;
import org.junit.Rule;
import org.junit.Test;
import org.search.niem.uml.ui.acceptance_tests.UIUtils;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesAnExampleProject;

public class NIEMpim2psmTest {

    @Rule
    public final CreatesAnExampleProject projectProvider = new CreatesAnExampleProject();

    @Test
    public void can_generate_a_psm_from_a_pim() throws CoreException {
        final IFile theFile = projectProvider.get().getFile("PetAdoption/PetAdoption.uml");
        UIUtils.<CommonNavigator> activate_the_view(IPageLayout.ID_PROJECT_EXPLORER).selectReveal(
                new StructuredSelection(theFile));

        run_the_command(NIEM_PIM_2_PSM_ID);

        final Package thePSM = get_the_root_model(theFile).getNestedPackage("PSM").getNestedPackage("PetAdoptionIEPD");

        assertThat(thePSM, has_applied_profile(NIEM_Common_Profile));
        assertThat(thePSM, has_applied_profile(NIEM_PSM_Profile));
        assertThat(thePSM, has_applied_profile(Model_Package_Description_Profile));
    }
}
