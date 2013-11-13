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
package org.search.niem.uml.papyrus.lifecycleevents;

import static org.eclipse.papyrus.uml.tools.model.UmlUtils.getUmlModel;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;

public class NIEMUmlLifecycleAdapter implements LifecycleListener {

    protected void opened(final Resource theUmlResource) {
    }

    protected void changed(final Resource theUmlResource) {
    }

    protected void aboutToSave(final Resource theUmlResource) {
    }

    protected void saving(final Resource theUmlResource) {
    }

    protected void saved(final Resource theUmlResource) {
    }

    protected void closed(final Resource theUmlResource) {
    }

    protected final Resource getTheUmlResource(final ModelSet theModelSet) {
        final UmlModel theUmlModel = getUmlModel(theModelSet);
        return theUmlModel == null ? null : theUmlModel.getResource();
    }

    @Override
    public void opened(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            opened(theUmlResource);
        }
    }

    @Override
    public void changed(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            changed(theUmlResource);
        }
    }

    @Override
    public void aboutToSave(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            aboutToSave(theUmlResource);
        }
    }

    @Override
    public void saving(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            saving(theUmlResource);
        }
    }

    @Override
    public void saved(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            saved(theUmlResource);
        }
    }

    @Override
    public void closed(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource != null) {
            closed(theUmlResource);
        }
    }
}
