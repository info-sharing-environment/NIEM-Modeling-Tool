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

import static org.search.niem.uml.ui.util.UIExt.select;

import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class UIUtils {

    public static IWorkbench get_the_workbench() {
        return PlatformUI.getWorkbench();
    }

    public static IWorkbenchWindow get_the_active_workbench_window() {
        return get_the_workbench().getActiveWorkbenchWindow();
    }

    public static IWorkbenchPage get_the_active_workbench_page() {
        return get_the_active_workbench_window().getActivePage();
    }

    public static IEditorPart get_the_active_editor() {
        return get_the_active_workbench_page().getActiveEditor();
    }

    @SuppressWarnings("unchecked")
    private static <V extends IViewPart> V find_the_view(final String id) {
        for (final IWorkbenchPage p : get_the_active_workbench_window().getPages()) {
            final IViewPart view = p.findView(id);
            if (view != null) {
                return (V) view;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <V extends IViewPart> V activate_the_view(final String id) throws PartInitException {
        final IViewPart theView = find_the_view(id);
        if (theView == null) {
            return (V) get_the_active_workbench_page().showView(id);
        }
        theView.setFocus();
        return (V) theView;
    }

    public static void close_all_open_editors() {
        for (final IWorkbenchWindow w : get_the_workbench().getWorkbenchWindows()) {
            for (final IWorkbenchPage p : w.getPages()) {
                p.closeAllEditors(false);
            }
        }
    }

    public static void select_the_default_button(final IShellProvider provider) {
        select(provider.getShell().getDefaultButton());
    }
}
