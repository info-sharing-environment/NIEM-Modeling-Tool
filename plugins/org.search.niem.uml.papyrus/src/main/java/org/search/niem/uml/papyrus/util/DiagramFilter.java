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
package org.search.niem.uml.papyrus.util;

import static org.search.niem.uml.papyrus.util.DiagramExt.getTheCorrespondingUmlFile;

import org.eclipse.core.resources.IFile;
import org.search.niem.uml.ui.views.FileFilter;

public final class DiagramFilter extends FileFilter {

    private boolean hasACorrespondingUmlFile(final IFile file) {
        return getTheCorrespondingUmlFile(file) != null;
    }

    @Override
    protected boolean select(final IFile file) {
        return "di".equals(file.getFileExtension()) && hasACorrespondingUmlFile(file);
    }
}