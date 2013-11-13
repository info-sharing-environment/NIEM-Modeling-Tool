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

import static org.eclipse.papyrus.infra.emf.utils.EMFHelper.resolveEditingDomain;
import static org.eclipse.papyrus.uml.tools.utils.UMLUtil.resolveUMLElement;

import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElementFactory;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

public class NIEMUmlModelElementFactory extends UMLModelElementFactory {
    @Override
    public ModelElement createFromSource(final Object source, final DataContextElement context) {
        final Element umlSource = resolveUMLElement(source);
        return UMLPackage.Literals.CLASSIFIER.isInstance(umlSource) || UMLPackage.Literals.PROPERTY.isInstance(umlSource) ? new NIEMUmlModelElement(
                umlSource, resolveEditingDomain(umlSource)) : super.createFromSource(umlSource, context);
    }
}
