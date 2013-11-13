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
package org.search.niem.uml.ui.acceptance_tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class WorkspaceUtils {

    public static void delete_the_project(final String name) throws CoreException {
        final IProject theProject = get_the_project(name);
        if (theProject.exists()) {
            run(new IWorkspaceRunnable() {
                @Override
                public void run(final IProgressMonitor monitor) throws CoreException {
                    theProject.delete(true, true, monitor);
                }
            });
        }
    }

    public static IProject create_a_project(final String name) throws CoreException {
        final IProject project = get_the_project(name);
        run(new IWorkspaceRunnable() {
            @Override
            public void run(final IProgressMonitor monitor) throws CoreException {
                project.create(monitor);
                project.open(monitor);
            }
        });
        return project;
    }

    public static IProject get_the_project(final String name) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(name);
    }

    private static void run(final IWorkspaceRunnable theRunnable) throws CoreException {
        ResourcesPlugin.getWorkspace().run(theRunnable, new NullProgressMonitor());
    }
}
