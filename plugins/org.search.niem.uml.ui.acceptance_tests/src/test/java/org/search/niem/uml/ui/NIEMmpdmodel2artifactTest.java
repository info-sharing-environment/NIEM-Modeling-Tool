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
import static org.search.niem.uml.qvt.ui.Activator.NIEM_MPD_2_CAT_ID;
import static org.search.niem.uml.qvt.ui.Activator.NIEM_PIM_2_PSM_ID;

import java.util.ArrayList;
import java.util.Collection;

public class NIEMmpdmodel2artifactTest extends NIEMpsm2xsdTest {
    @Override
    protected Iterable<String> transforms() {
        return asList(NIEM_PIM_2_PSM_ID, NIEM_MPD_2_CAT_ID);
    }

    @Override
    protected Collection<String> expectedArtifacts() {
        final Collection<String> expectedArtifacts = new ArrayList<>(super.expectedArtifacts());
        expectedArtifacts.addAll(asList("PetAdoption/PetAdoption/MPD_Catalog.xml",
                "PetAdoption/PetAdoption/XMLsamples/PetAdoptionExchange_Sample.xml"));
        return expectedArtifacts;
    }
}
