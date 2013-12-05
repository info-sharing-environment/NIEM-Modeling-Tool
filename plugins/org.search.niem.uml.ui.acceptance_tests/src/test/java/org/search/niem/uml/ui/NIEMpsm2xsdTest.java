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

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.search.niem.uml.qvt.ui.Activator.NIEM_PIM_2_PSM_ID;
import static org.search.niem.uml.qvt.ui.Activator.NIEM_PSM_2_XSD_ID;
import static org.search.niem.uml.ui.acceptance_tests.CommandUtils.run_the_command;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.exists;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.navigator.CommonNavigator;
import org.junit.Rule;
import org.junit.Test;
import org.search.niem.uml.ui.acceptance_tests.UIUtils;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesAnExampleProject;

public class NIEMpsm2xsdTest {

    @Rule
    public final CreatesAnExampleProject projectProvider = new CreatesAnExampleProject();

    private static final Collection<String> EXPECTED_ARTIFACTS = asList(
            "PetAdoption/PetAdoption/XMLschemas/exchange/PetAdoptionExchange.xsd",
            "PetAdoption/PetAdoption/XMLschemas/extension/PetAdoptionExtension.xsd",
            "PetAdoption/PetAdoption/XMLschemas/subset/niem/niem-core/2.0/PetAdoptionNIEMCoreSubset.xsd",
            "PetAdoption/PetAdoption/XMLschemas/subset/2.0/fips_10-4.xsd",
            "PetAdoption/PetAdoption/XMLschemas/subset/2.0/iso_3166.xsd",
            "PetAdoption/PetAdoption/XMLschemas/appinfo/2.0/appinfo.xsd",
            "PetAdoption/PetAdoption/XMLschemas/appinfo/2.1/appinfo.xsd",
            "PetAdoption/PetAdoption/XMLschemas/proxy/xsd/2.0/xsd.xsd",
            "PetAdoption/PetAdoption/XMLschemas/structures/2.0/structures.xsd");

    @Test
    public void can_generate_artifacts_from_a_model() throws CoreException {
        final IProject theProject = projectProvider.get();
        UIUtils.<CommonNavigator> activate_the_view(IPageLayout.ID_PROJECT_EXPLORER).selectReveal(
                new StructuredSelection(theProject.getFile("PetAdoption/PetAdoption.uml")));

        for (final String transform : transforms()) {
            run_the_command(transform);
        }

        for (final String file : expectedArtifacts()) {
            assertThat(theProject.getFile(file), exists());
        }
    }

    protected Iterable<String> transforms() {
        return asList(NIEM_PIM_2_PSM_ID, NIEM_PSM_2_XSD_ID);
    }

    protected Collection<String> expectedArtifacts() {
        return EXPECTED_ARTIFACTS;
    }
}
