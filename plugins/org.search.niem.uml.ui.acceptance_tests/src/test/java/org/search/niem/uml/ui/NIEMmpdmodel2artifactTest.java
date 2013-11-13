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
import static org.search.niem.uml.qvt.ui.Activator.NIEM_MPD_2_CAT_ID;
import static org.search.niem.uml.qvt.ui.Activator.NIEM_PIM_2_PSM_ID;
import static org.search.niem.uml.ui.acceptance_tests.CommandUtils.run_the_command;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.exists;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.navigator.CommonNavigator;
import org.junit.Rule;
import org.junit.Test;
import org.search.niem.uml.ui.acceptance_tests.UIUtils;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesAnExampleProject;

public class NIEMmpdmodel2artifactTest {

    @Rule
    public final CreatesAnExampleProject projectProvider = new CreatesAnExampleProject();

    @Test
    public void can_generate_a_catalog_from_an_mpd_model() throws CoreException {
        final IProject theProject = projectProvider.get();
        UIUtils.<CommonNavigator> activate_the_view(IPageLayout.ID_PROJECT_EXPLORER).selectReveal(
                new StructuredSelection(theProject.getFile("PetAdoption/PetAdoption.uml")));

        run_the_command(NIEM_PIM_2_PSM_ID);
        run_the_command(NIEM_MPD_2_CAT_ID);

        assertThat(theProject.getFile("PetAdoption/PetAdoption/MPD_Catalog.xml"), exists());
    }
}
