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

import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_workbench;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.select_the_default_button;
import static org.search.niem.uml.ui.acceptance_tests.WorkspaceUtils.get_the_project;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;
import org.search.niem.uml.examples.Activator;

public class CreatesAnExampleProject extends CreatesAProject {
    @Override
    protected String getTheProjectName() {
        return Activator.EXAMPLE_PROJECT_NAME;
    }

    @Override
    protected IProject createTheProject() throws Exception {
        final IWorkbench theWorkbench = get_the_workbench();
        final IWizardRegistry theNewWizardRegistry = theWorkbench.getNewWizardRegistry();
        final IWizardDescriptor wizardDescriptor = theNewWizardRegistry.findWizard(Activator.EXAMPLE_WIZARD_ID);

        final IWorkbenchWizard theWizard = wizardDescriptor.createWizard();
        theWizard.init(theWorkbench, StructuredSelection.EMPTY);

        final WizardDialog theDialog = new WizardDialog(null, theWizard);
        theDialog.setBlockOnOpen(false);
        theDialog.open();

        select_the_default_button(theDialog);

        return get_the_project(getTheProjectName());
    }
}
