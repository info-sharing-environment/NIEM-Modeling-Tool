package org.search.niem.uml.papyrus.diagram.clazz.providers;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.search.niem.uml.papyrus.editors.Activator;

public class ElementInitializers extends org.eclipse.papyrus.uml.diagram.clazz.providers.ElementInitializers {
    public ElementInitializers() {
    }

    @Override
    public void init_Property_3012(final Property instance) {
        super.init_Property_3012(instance);
        try {
            instance.setAggregation(AggregationKind.COMPOSITE_LITERAL);
        } catch (final RuntimeException e) {
            Activator.INSTANCE.log(e);
        }
    }
}
