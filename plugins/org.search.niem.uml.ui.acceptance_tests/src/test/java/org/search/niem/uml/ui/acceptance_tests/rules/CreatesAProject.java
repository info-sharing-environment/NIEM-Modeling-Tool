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

import static org.search.niem.uml.ui.acceptance_tests.WorkspaceUtils.delete_the_project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.junit.rules.ExternalResource;

public abstract class CreatesAProject extends ExternalResource implements ProjectProvider {

    protected abstract String getTheProjectName();

    protected abstract IProject createTheProject() throws Exception;

    private IProject theProject;

    @Override
    protected final void before() throws Throwable {
        theProject = createTheProject();
    }

    @Override
    protected final void after() {
        final String theProjectName = getTheProjectName();
        try {
            delete_the_project(theProjectName);
        } catch (final CoreException e) {
            throw new IllegalStateException("Problem deleting the project " + theProjectName, e);
        }
    }

    @Override
    public final IProject get() {
        return theProject;
    }
}
