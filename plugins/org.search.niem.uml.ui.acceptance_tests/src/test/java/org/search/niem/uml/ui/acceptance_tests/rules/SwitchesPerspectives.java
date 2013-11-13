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

import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_active_workbench_page;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_active_workbench_window;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_workbench;

import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.WorkbenchException;
import org.junit.rules.ExternalResource;

public class SwitchesPerspectives extends ExternalResource {

    private IPerspectiveDescriptor theCurrentPerspective;

    @Override
    protected void before() throws Throwable {
        theCurrentPerspective = get_the_active_workbench_page().getPerspective();
    }

    @Override
    protected void after() {
        try {
            get_the_workbench().showPerspective(theCurrentPerspective.getId(), get_the_active_workbench_window());
        } catch (final WorkbenchException e) {
            throw new IllegalStateException("Problem resetting the perspective.", e);
        }
    };
}
