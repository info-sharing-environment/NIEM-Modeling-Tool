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
package org.search.niem.uml.ui.views;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.search.niem.uml.ui.Activator;

public abstract class FileFilter extends ViewerFilter {

    protected abstract boolean select(IFile file);

    private boolean theElementIsValid(final Object element) {
        return element instanceof IFile && select((IFile) element);
    }

    private boolean itContainsAValidFile(final Object element) {
        if (element instanceof IContainer) {
            final IContainer container = (IContainer) element;
            final AtomicBoolean itContainsAValidFile = new AtomicBoolean();
            try {
                container.accept(new IResourceVisitor() {
                    @Override
                    public boolean visit(final IResource resource) throws CoreException {
                        if (theElementIsValid(resource)) {
                            itContainsAValidFile.set(true);
                            return false;
                        }
                        return !itContainsAValidFile.get();
                    }
                });
            } catch (final CoreException e) {
                Activator.INSTANCE.log(e);
                return false;
            }
            return itContainsAValidFile.get();
        }
        return false;
    }

    @Override
    public final boolean select(final Viewer viewer, final Object parentElement, final Object element) {
        return theElementIsValid(element) || itContainsAValidFile(element);
    }
}
