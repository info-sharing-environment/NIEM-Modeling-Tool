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
package org.search.niem.uml.evl.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.search.niem.uml.papyrus.lifecycleevents.NIEMUmlLifecycleAdapter;

public class ModelValidationListener extends NIEMUmlLifecycleAdapter {

    @Override
    protected void opened(final Resource theUmlResource) {
        runValidation(theUmlResource);
    }

    @Override
    protected void saved(final Resource theUmlResource) {
        runValidation(theUmlResource);
    }

    @Override
    protected void closed(final Resource theUmlResource) {
        removeMarkers(theUmlResource);
    }

    private void runValidation(final Resource theUmlResource) {
        new ModelValidator(theUmlResource).run();
    }

    private void removeMarkers(final Resource theUmlResource) {
        new ValidateAction.EclipseResourcesUtil().deleteMarkers(theUmlResource);
    }
}
