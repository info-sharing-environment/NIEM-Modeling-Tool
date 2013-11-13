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
package org.search.niem.uml.search.ui;

import static java.util.Collections.singletonList;
import static org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog.openFileSelection;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getTheServicesRegistry;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.search.niem.uml.papyrus.util.DiagramFilter;

final class SearchDoubleClickListener implements IDoubleClickListener {

    private final IWorkbenchPage page;
    private final Shell theShell;
    private final FontsAndColors theFontsAndColors;

    SearchDoubleClickListener(final Control control, final IWorkbenchPage page) {
        this.page = page;
        theShell = control.getShell();
        theFontsAndColors = new FontsAndColors(control.getFont(), control.getForeground(), control.getBackground());
    }

    @Override
    public void doubleClick(final DoubleClickEvent event) {
        new SubsetUpdater(theShell, theFontsAndColors, findTheServicesRegistry(),
                ((IStructuredSelection) event.getSelection()).getFirstElement()).updateTheSubset();
    }

    private ServicesRegistry findTheServicesRegistry() {
        final ServicesRegistry theServicesRegistry = getTheServicesRegistry();
        return theServicesRegistry == null ? askForServicesRegistry() : theServicesRegistry;
    }

    private ServicesRegistry askForServicesRegistry() {
        final ViewerFilter diagramFilter = new DiagramFilter();
        final IFile[] selectedFiles = openFileSelection(theShell,
                Activator.INSTANCE.getString("_UI_NIEM_SearchDoubleClickListener_prompt_select_model_title"),
                Activator.INSTANCE.getString("_UI_NIEM_SearchDoubleClickListener_prompt_select_model_message"), false, null,
                singletonList(diagramFilter));
        if (selectedFiles.length == 1) {
            try {
                final IEditorPart theEditor = page.openEditor(new FileEditorInput(selectedFiles[0]),
                        PapyrusMultiDiagramEditor.EDITOR_ID, true, IWorkbenchPage.MATCH_INPUT | IWorkbenchPage.MATCH_ID);
                return (ServicesRegistry) theEditor.getAdapter(ServicesRegistry.class);
            } catch (final PartInitException e) {
                Activator.INSTANCE.log(e);
            }
        }
        return null;
    }
}