package org.search.niem.uml.papyrus.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class NIEMPartAdapter implements IStartup, IPartListener2 {

    @Override
    public void partActivated(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partBroughtToTop(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partClosed(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partDeactivated(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partOpened(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partHidden(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partVisible(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partInputChanged(final IWorkbenchPartReference partRef) {
        // no-op
    }

    private void initializeOpenEditors(final IWorkbenchWindow theWorkbenchWindow) {
        for (final IWorkbenchPage page : theWorkbenchWindow.getPages()) {
            for (final IEditorReference editor : page.getEditorReferences()) {
                partOpened(editor);
            }
        }
    }

    @Override
    public void earlyStartup() {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                initializeOpenEditors(workbenchWindow);
                workbenchWindow.getPartService().addPartListener(NIEMPartAdapter.this);
            }
        });
    }

    protected final boolean itIsThePapyrusEditor(final IWorkbenchPartReference part) {
        return PapyrusMultiDiagramEditor.EDITOR_ID.equals(part.getId());
    }

    protected final ServicesRegistry getServiceRegistry(final IWorkbenchPartReference part) {
        return getServicesRegistry(part.getPart(true));
    }

    private ServicesRegistry getServicesRegistry(final IAdaptable servicesRegistryAdapter) {
        return (ServicesRegistry) servicesRegistryAdapter.getAdapter(ServicesRegistry.class);
    }
}