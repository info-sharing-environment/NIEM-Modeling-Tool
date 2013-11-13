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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_workbench;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.select_the_default_button;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.junit.rules.ExternalResource;
import org.search.niem.uml.papyrus.wizards.NewNiemModelWizard;
import org.search.niem.uml.papyrus.wizards.PointOfContact;
import org.search.niem.uml.papyrus.wizards.SetMPDValuesPage;
import org.search.niem.uml.papyrus.wizards.SetPOCValuesPage;

public class CreatesATemporaryNiemUmlModel extends ExternalResource implements ModelProvider {

    public static final String THE_MODEL_NAME = "TestInformation";

    private final ProjectProvider projectProvider;

    public CreatesATemporaryNiemUmlModel(final ProjectProvider projectProvider) {
        this.projectProvider = projectProvider;
    }

    @Override
    protected void before() throws Throwable {
        create_a_niem_model(THE_MODEL_NAME);
    }

    @Override
    public IFile getTheNiemUmlModel() {
        return projectProvider.get().getFile(THE_MODEL_NAME + ".uml");
    }

    @Override
    public IFile getTheDiagramModel() {
        return projectProvider.get().getFile(THE_MODEL_NAME + ".di");
    }

    @Override
    public IFile getTheNotationModel() {
        return projectProvider.get().getFile(THE_MODEL_NAME + ".notation");
    }

    public void create_a_niem_model(final String theModelName) throws CoreException {
        final IWorkbench theWorkbench = get_the_workbench();
        final IWorkbenchWizard theWizard = theWorkbench.getNewWizardRegistry().findWizard(NewNiemModelWizard.ID)
                .createWizard();
        theWizard.init(theWorkbench, new StructuredSelection(projectProvider.get()));

        final WizardDialog theDialog = new WizardDialog(null, theWizard);
        theDialog.setBlockOnOpen(false);
        theDialog.open();

        final WizardNewFileCreationPage theNewModelFilePage = (WizardNewFileCreationPage) theWizard.getPages()[0];
        theNewModelFilePage.setFileName(theModelName + ".di");

        select_the_default_button(theDialog);
        select_the_default_button(theDialog);

        final SetMPDValuesPage theSecondMpdValuesPage = (SetMPDValuesPage) theWizard.getPages()[2];
        theSecondMpdValuesPage.setDomains(asList("Test Domain"));
        theSecondMpdValuesPage.setKeywords(asList("Test Keyword"));
        theSecondMpdValuesPage.setAuthoritativeSourceName("Test Name");
        select_the_default_button(theDialog);

        final SetPOCValuesPage thePOCValuesPage = (SetPOCValuesPage) theWizard.getPages()[3];
        thePOCValuesPage.setPointsOfContact(singletonList(new PointOfContact("Test POC Name",
                singletonList("test@email.com"), singletonList("555-5555"))));
        select_the_default_button(theDialog);
    }
}
