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

import static org.search.niem.uml.ui.acceptance_tests.WorkspaceUtils.create_a_project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

public class CreatesATemporaryProject extends CreatesAProject {

    private static final String THE_PROJECT_NAME = "TestProject";

    @Override
    protected String getTheProjectName() {
        return THE_PROJECT_NAME;
    }

    @Override
    protected IProject createTheProject() throws CoreException {
        return create_a_project(THE_PROJECT_NAME);
    }
}
