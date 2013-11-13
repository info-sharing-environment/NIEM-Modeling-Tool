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

import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog.openFileSelection;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.search.niem.uml.qvt.ui.Activator;
import org.search.niem.uml.ui.views.FileFilter;

public class NIEMmpdartifact2model extends Transform {

    @Override
    protected final TransformDelegate createDelegate(final URI selection) {
        return new NIEMmpdartifact2modelDelegate(selection);
    }

    @Override
    protected final boolean theSelectionIsValid(final IFile theSelection) {
        try {
            final IContentDescription contentDescription = theSelection.getContentDescription();
            return contentDescription != null && contentDescription.getContentType() != null
                    && org.search.niem.mpd.Activator.CONTENT_TYPE.equals(contentDescription.getContentType().getId())
                    && theSelection.getParent() != theSelection.getProject();
        } catch (final CoreException e) {
            // no-op
        }
        return false;
    }

    @Override
    protected final IResource askForResource(final Shell theShell) {
        final ViewerFilter catalogFilter = new CatalogFilter();
        final IFile[] selectedFiles = openFileSelection(theShell,
                Activator.INSTANCE.getString("_UI_NIEMmpdartifact2model_prompt_select_catalog_title"),
                Activator.INSTANCE.getString("_UI_NIEMmpdartifact2model_prompt_select_catalog_message"), false, null,
                singletonList(catalogFilter));
        return selectedFiles.length == 1 ? selectedFiles[0] : null;
    }

    @Override
    protected final Collection<IPath> getAssociatedPaths(final IResource theSelection) {
        return singleton(theSelection.getFullPath());
    }

    private final class CatalogFilter extends FileFilter {
        @Override
        protected boolean select(final IFile file) {
            return theSelectionIsValid(file);
        }
    }

}
