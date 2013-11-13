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
package org.search.niem.uml.qvt.ui.handlers;

import static java.util.Arrays.asList;
import static org.eclipse.emf.common.util.URI.createPlatformResourceURI;
import static org.eclipse.jface.dialogs.MessageDialogWithToggle.openOkCancelConfirm;
import static org.eclipse.ui.handlers.HandlerUtil.getCurrentSelection;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_QVT_SAVE_EDITOR_DO_NOT_ASK;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.search.niem.uml.qvt.ui.Activator;

public abstract class Transform extends AbstractHandler {

    protected abstract Transformer createDelegate(final URI selection);

    protected int totalWork() {
        return IProgressMonitor.UNKNOWN;
    }

    protected abstract boolean theSelectionIsValid(final IFile theSelection);

    protected abstract IResource askForResource(final Shell theShell);

    protected abstract Collection<IPath> getAssociatedPaths(final IResource theSelection);

    private IResource findResourceToTransform(final Shell theShell, final ISelection currentSelection) {
        if (currentSelection != null && !currentSelection.isEmpty() && currentSelection instanceof IStructuredSelection) {
            final Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
            if (firstElement instanceof IAdaptable) {
                final IResource resource = (IResource) ((IAdaptable) firstElement).getAdapter(IResource.class);
                if (resource != null && resource.getType() == IResource.FILE && theSelectionIsValid((IFile) resource)) {
                    return resource;
                }
            }
        }
        return askForResource(theShell);
    }

    private Collection<URI> toURIs(final Collection<IPath> paths) {
        final Collection<URI> uris = new ArrayList<>(paths.size());
        for (final IPath path : paths) {
            uris.add(createPlatformResourceURI(path.toOSString(), true));
        }
        return uris;
    }

    private IEditorPart findTheDirtyEditorFor(final IResource theModel) {
        final IEditorPart[] dirtyEditors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getDirtyEditors();
        final Collection<IPath> associatedPaths = getAssociatedPaths(theModel);
        for (final IEditorPart dirtyEditor : dirtyEditors) {
            final IEditorInput theEditorInput = dirtyEditor.getEditorInput();
            if (theEditorInput instanceof URIEditorInput) {
                final URIEditorInput uriEditorInput = (URIEditorInput) theEditorInput;
                final URI theEditorURI = uriEditorInput.getURI();
                final Collection<URI> associatedURIs = toURIs(associatedPaths);
                if (asList(associatedURIs).contains(theEditorURI)) {
                    return dirtyEditor;
                }
            } else if (theEditorInput instanceof FileEditorInput) {
                final FileEditorInput fileEditorInput = (FileEditorInput) theEditorInput;
                if (associatedPaths.contains(fileEditorInput.getFile().getFullPath())) {
                    return dirtyEditor;
                }
            }
        }
        return null;
    }

    private MessageDialogWithToggle askWhetherTheEditorShouldBeSaved(final IEditorPart theDirtyEditor) {
        return openOkCancelConfirm(theDirtyEditor.getSite().getShell(),
                Activator.INSTANCE.getString("_UI_Transform_save_title"), Activator.INSTANCE.getString(
                        "_UI_Transform_save_question", new Object[] { theDirtyEditor.getEditorInput().getName() }),
                Activator.INSTANCE.getString("_UI_Transform_save_preference"), false, getThePreferenceStore(),
                P_QVT_SAVE_EDITOR_DO_NOT_ASK);
    }

    private IPreferenceStore getThePreferenceStore() {
        return org.search.niem.uml.ui.Activator.getPlugin().getPreferenceStore();
    }

    @Override
    public final Object execute(final ExecutionEvent event) throws ExecutionException {
        final Shell theShell = HandlerUtil.getActiveShellChecked(event);
        final IResource selection = findResourceToTransform(theShell, getCurrentSelection(event));
        if (selection == null) {
            return null;
        }
        final IEditorPart theDirtyEditor = findTheDirtyEditorFor(selection);
        if (theDirtyEditor != null) {
            final IPreferenceStore thePreferenceStore = getThePreferenceStore();
            if (!thePreferenceStore.getBoolean(P_QVT_SAVE_EDITOR_DO_NOT_ASK)) {
                final MessageDialogWithToggle theQuestion = askWhetherTheEditorShouldBeSaved(theDirtyEditor);
                if (theQuestion.getReturnCode() != Window.OK) {
                    return null;
                }
                thePreferenceStore.setValue(P_QVT_SAVE_EDITOR_DO_NOT_ASK, theQuestion.getToggleState());
            }
            theDirtyEditor.doSave(new NullProgressMonitor());
        }
        try {
            new ProgressMonitorDialog(theShell).run(true, true, new IRunnableWithProgress() {
                @Override
                public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    try (final Transformer delegate = createDelegate(createPlatformResourceURI(selection.getFullPath()
                            .toOSString(), true))) {
                        monitor.beginTask(
                                Activator.INSTANCE.getString("_UI_Transform_progress", new Object[] { delegate.name() }),
                                totalWork());
                        delegate.runTransform(theShell, monitor);
                    } catch (final Exception e) {
                        Activator.INSTANCE.log(e);
                    } finally {
                        monitor.done();
                    }
                }
            });
        } catch (final InvocationTargetException e) {
            throw new ExecutionException(e.getMessage(), e);
        } catch (final InterruptedException e) {
            // no-op
        }
        return null;
    }
}
