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
import static java.util.Collections.singletonList;
import static org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog.openFileSelection;
import static org.search.niem.uml.papyrus.util.DiagramExt.getTheCorrespondingUmlFile;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.search.niem.uml.papyrus.util.DiagramFilter;
import org.search.niem.uml.qvt.ui.Activator;

public abstract class DiagramTransform extends Transform {
    @Override
    protected final boolean theSelectionIsValid(final IFile theSelection) {
        return UMLResource.FILE_EXTENSION.equals(theSelection.getFileExtension());
    }

    @Override
    protected final IResource askForResource(final Shell theShell) {
        final ViewerFilter diagramFilter = new DiagramFilter();
        final IFile[] selectedFiles = openFileSelection(theShell,
                Activator.INSTANCE.getString("_UI_UMLTransform_prompt_select_model_title"),
                Activator.INSTANCE.getString("_UI_UMLTransform_prompt_select_model_message"), false, null,
                singletonList(diagramFilter));
        return selectedFiles.length == 1 ? getTheCorrespondingUmlFile(selectedFiles[0]) : null;
    }

    @Override
    protected Collection<IPath> getAssociatedPaths(final IResource theSelection) {
        final IPath theUMLPath = theSelection.getFullPath();
        final IPath theBasePath = theUMLPath.removeFileExtension();
        final IPath theDiagramPath = theBasePath.addFileExtension("di");
        final IPath theNotationPath = theBasePath.addFileExtension("notation");
        return asList(theUMLPath, theDiagramPath, theNotationPath);
    }
}
