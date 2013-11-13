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
package org.search.niem.uml.papyrus.wizards;

import static org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard.updatePerspective;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DEFAULT_MODEL_NAME;
import static org.search.niem.uml.papyrus.util.PapyrusExt.createServicesRegistry;
import static org.search.niem.uml.papyrus.util.PapyrusExt.disposeServicesRegistry;
import static org.search.niem.uml.papyrus.util.PapyrusExt.initServicesRegistry;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.papyrus.wizards.templates.InitFromTemplateCommand;

public final class NewNiemModelWizard extends Wizard implements INewWizard, IExecutableExtension {

    public static final String ID = Activator.PLUGIN_ID + ".wizards.NewNiemModelWizard";

    private static final int TOTAL_WORK = 10;
    private static final String NEW_MODEL_FILE_PAGE_ID = Activator.PLUGIN_ID + ".newModelFilePage";
    private static final String MODEL_KIND_NAME = "NIEM UML";

    private NewModelFilePage newModelFilePage;
    private SetBasicValuesPage setBasicValuesPage;
    private SetMPDValuesPage setMPDValuesPage;
    private SetPOCValuesPage setPOCValuesPage;

    private IWorkbench workbench;
    private IConfigurationElement config;

    public NewNiemModelWizard() {
        setWindowTitle(Activator.INSTANCE.getString("_UI_NewNiemModelWizard_title"));
        setNeedsProgressMonitor(true);
    }

    @Override
    public void addPages() {
        addPage(newModelFilePage);
        addPage(setBasicValuesPage);
        addPage(setMPDValuesPage);
        addPage(setPOCValuesPage);
    }

    @Override
    public void init(final IWorkbench workbench, final IStructuredSelection selection) {
        this.workbench = workbench;

        newModelFilePage = createNewModelFilePage(selection);
        setBasicValuesPage = createSetBasicValuesPage();
        setMPDValuesPage = createSetMPDValuesPage();
        setPOCValuesPage = createSetPOCValuesPage();
    }

    @Override
    public boolean canFinish() {
        final IWizardPage[] allPages = getPages();
        for (final IWizardPage p : allPages) {
            if (!p.isPageComplete()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean performFinish() {
        final URI newURI = createNewModelURI();
        final BasicValues basicValues = setBasicValuesPage.getModelValues();
        final MPDValues modelMultiValues = setMPDValuesPage.getMPDValues();
        final List<PointOfContact> pointsOfContact = setPOCValuesPage.getPointsOfContact();
        try {
            getContainer().run(false, true, new IRunnableWithProgress() {
                @Override
                public void run(final IProgressMonitor pm) throws InvocationTargetException, InterruptedException {
                    pm.beginTask(Activator.INSTANCE.getString("_UI_NewNiemModelWizard_progress_task"), TOTAL_WORK);
                    try {
                        createAndOpenPapyrusModel(newURI, basicValues, modelMultiValues, pointsOfContact, pm);
                    } catch (ServiceException | IOException e) {
                        throw new InvocationTargetException(e);
                    } finally {
                        pm.done();
                    }
                }
            });
        } catch (final InvocationTargetException e) {
            Activator.INSTANCE.log(e);
            ((TitleAreaDialog) getContainer()).setErrorMessage(Activator.INSTANCE.getString("_UI_NewNiemModelWizard_error"));
            return false;
        } catch (final InterruptedException e) {
            return false;
        }
        updatePerspective(config);
        return true;
    }

    private URI createNewModelURI() {
        final IFile newFile = newModelFilePage.createNewFile();
        return newFile == null ? null : URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
    }

    private void createAndOpenPapyrusModel(final URI newURI, final BasicValues modelValues,
            final MPDValues modelMultiValues, final List<PointOfContact> pointsOfContact, final IProgressMonitor pm)
            throws ServiceException, IOException {
        final ServicesRegistry registry = createServicesRegistry();
        pm.worked(1);

        try {
            final ModelSet modelSet = registry.getService(ModelSet.class);

            createPapyrusModels(modelSet, newURI);
            pm.worked(1);

            initServicesRegistry(registry);
            pm.worked(1);

            initDomainModel(modelSet);
            pm.worked(1);

            setModelValues(modelSet, modelValues, modelMultiValues, pointsOfContact);
            pm.worked(1);

            initDiagramModel(modelSet, pm);
            pm.worked(1);

            openDiagram(newURI);
            pm.worked(1);
        } finally {
            disposeServicesRegistry(registry);
        }
    }

    private void execute(final ModelSet modelSet, final Command c) {
        modelSet.getTransactionalEditingDomain().getCommandStack().execute(c);
    }

    private void setModelValues(final ModelSet modelSet, final BasicValues modelValues, final MPDValues modelMultiValues,
            final List<PointOfContact> pointsOfContact) {
        execute(modelSet, new SetModelValuesCommand(modelSet, modelValues, modelMultiValues, pointsOfContact));
    }

    private void initDomainModel(final ModelSet modelSet) {
        execute(modelSet, new InitFromTemplateCommand(modelSet));
    }

    private void createPapyrusModels(final ModelSet modelSet, final URI newURI) {
        execute(modelSet, new NewPapyrusModelCommand(modelSet, newURI));
    }

    private void openDiagram(final URI newURI) {
        final IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
        if (page != null) {
            try {
                final IFileEditorInput editorInput = createEditorInput(newURI);
                IDE.openEditor(page, editorInput, getEditorID(editorInput), true);
            } catch (final PartInitException e) {
                Activator.INSTANCE.log(e);
            }
        }
    }

    private IFileEditorInput createEditorInput(final URI uri) {
        return new FileEditorInput(ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true))));
    }

    private String getEditorID(final IFileEditorInput input) throws PartInitException {
        final IEditorDescriptor descriptor = IDE.getEditorDescriptor(input.getFile());

        return descriptor == null ? "org.eclipse.papyrus.infra.core.papyrusEditor" : descriptor.getId();
    }

    private void initDiagramModel(final ModelSet modelSet, final IProgressMonitor pm) throws IOException {
        TransactionalDiSashModelMngr.createIPageMngr(DiModelUtils.getDiResource(modelSet),
                modelSet.getTransactionalEditingDomain());
        modelSet.save(new SubProgressMonitor(pm, 3));
    }

    private NewModelFilePage createNewModelFilePage(final IStructuredSelection selection) {
        final NewModelFilePage newPage = new NewModelFilePage(NEW_MODEL_FILE_PAGE_ID, selection, MODEL_KIND_NAME);
        newPage.setWizard(this);
        newPage.setFileName(Activator.getPlugin().getPreferenceStore().getString(P_DEFAULT_MODEL_NAME));
        return newPage;
    }

    private SetBasicValuesPage createSetBasicValuesPage() {
        final SetBasicValuesPage setBasicValuesPage = new SetBasicValuesPage();
        setBasicValuesPage.setWizard(this);
        return setBasicValuesPage;
    }

    private SetMPDValuesPage createSetMPDValuesPage() {
        final SetMPDValuesPage setMPDValuesPage = new SetMPDValuesPage();
        setMPDValuesPage.setWizard(this);
        return setMPDValuesPage;
    }

    private SetPOCValuesPage createSetPOCValuesPage() {
        final SetPOCValuesPage setPOCValuesPage = new SetPOCValuesPage();
        setPOCValuesPage.setWizard(this);
        return setPOCValuesPage;
    }

    @Override
    public void setInitializationData(final IConfigurationElement config, final String propertyName, final Object data)
            throws CoreException {
        this.config = config;
    }
}