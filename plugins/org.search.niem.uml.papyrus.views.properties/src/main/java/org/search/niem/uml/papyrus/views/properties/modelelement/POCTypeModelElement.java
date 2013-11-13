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

import java.util.Collection;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableList;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.creation.StringEditionFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;
import org.search.niem.uml.util.EcoreExt;

public class POCTypeModelElement extends AbstractModelElement {

    private final EObject source;
    private final EditingDomain domain;

    public POCTypeModelElement(final EObject source, final EditingDomain domain) {
        this.source = source;
        this.domain = domain;
    }

    @Override
    public IObservable doGetObservable(final String propertyPath) {
        final EStructuralFeature feature = source.eClass().getEStructuralFeature(propertyPath);
        return feature.isMany() ? new EditingDomainEObjectObservableList(domain, source, feature)
                : new EditingDomainEObjectObservableValue(domain, source, feature);
    }

    @Override
    public IStaticContentProvider getContentProvider(final String propertyPath) {
        final EStructuralFeature feature = source.eClass().getEStructuralFeature(propertyPath);
        if (feature.isMany()) {
            return new StaticContentProvider(EcoreExt.<Collection<?>> get(feature, source).toArray());
        }
        if (source.eIsSet(feature)) {
            return new StaticContentProvider(new Object[] { EcoreExt.get(feature, source) });
        }
        return super.getContentProvider(propertyPath);
    }

    @Override
    public boolean isMandatory(final String propertyPath) {
        return true;
    }

    @Override
    public ReferenceValueFactory getValueFactory(final String propertyPath) {
        return new StringEditionFactory();
    }
}
