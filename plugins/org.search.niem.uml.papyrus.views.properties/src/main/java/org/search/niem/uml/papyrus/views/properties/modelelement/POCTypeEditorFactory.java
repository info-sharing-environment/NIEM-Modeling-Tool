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
package org.search.niem.uml.papyrus.views.properties.modelelement;

import static org.eclipse.papyrus.infra.emf.utils.EMFHelper.getEObject;
import static org.eclipse.papyrus.infra.emf.utils.EMFHelper.resolveEditingDomain;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.search.niem.uml.papyrus.views.properties.Activator;

public class POCTypeEditorFactory implements ModelElementFactory {

    @Override
    public ModelElement createFromSource(final Object sourceElement, final DataContextElement context) {
        final EObject source = getEObject(sourceElement);
        if (source == null) {
            Activator.INSTANCE.log("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
            return null;
        }

        return new POCTypeModelElement(source, resolveEditingDomain(source));
    }
}
