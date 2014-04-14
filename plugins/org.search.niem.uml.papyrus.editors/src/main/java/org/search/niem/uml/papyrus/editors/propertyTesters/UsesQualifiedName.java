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
package org.search.niem.uml.papyrus.editors.propertyTesters;

import static org.apache.commons.lang.StringUtils.countMatches;
import static org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper.getQualifiedNameDepth;
import static org.eclipse.uml2.uml.NamedElement.SEPARATOR;
import static org.search.niem.uml.util.UMLExt.getQualifiedName;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart;

public class UsesQualifiedName extends PropertyTester {
    @Override
    public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
        if (receiver instanceof UMLNodeEditPart) {
            final UMLNodeEditPart theEditPart = (UMLNodeEditPart) receiver;
            return getQualifiedNameDepth(theEditPart.getNotationView()) < countMatches(
                    getQualifiedName(theEditPart.getUMLElement()), SEPARATOR);
        }
        return false;
    }
}
