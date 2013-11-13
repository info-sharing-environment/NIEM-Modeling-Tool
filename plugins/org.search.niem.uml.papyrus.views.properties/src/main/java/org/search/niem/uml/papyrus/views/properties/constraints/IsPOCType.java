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
package org.search.niem.uml.papyrus.views.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;

public class IsPOCType extends AbstractConstraint {

    @Override
    protected boolean equivalent(final Constraint constraint) {
        return false;
    }

    @Override
    protected boolean match(final Object selection) {
        if (selection instanceof DynamicEObjectImpl) {
            final EObject element = (EObject) selection;
            if ("POCType".equals(element.eClass().getName())) {
                return true;
            }
        }
        return false;
    }
}
