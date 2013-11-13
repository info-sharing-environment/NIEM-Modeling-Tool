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

import static org.search.niem.uml.util.NIEMUmlExt.isInReferenceLibrarySubset;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.papyrus.preferences.PreferenceConstants;

public class NIEMUmlModelElement extends UMLModelElement {
    public NIEMUmlModelElement(final EObject source, final EditingDomain domain) {
        super(source, domain);
    }

    @Override
    public IStaticContentProvider getContentProvider(final String propertyPath) {
        final EStructuralFeature feature = getFeature(propertyPath);
        return UMLPackage.Literals.TYPED_ELEMENT__TYPE == feature ? new TypeReferenceContentProvider(source, feature)
                : super.getContentProvider(propertyPath);
    }

    @Override
    public boolean isEditable(final String propertyPath) {
        return Activator.getPlugin().getPreferenceStore().getBoolean(PreferenceConstants.P_RESTRICT_NIEM_SUBSET_CONTENT)
                && isInReferenceLibrarySubset(getSource()) ? false : super.isEditable(propertyPath);
    }
}
