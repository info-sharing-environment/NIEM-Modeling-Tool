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
package org.search.niem.uml.search;

import static org.search.niem.uml.util.NIEMUmlExt.getSubstitutionGroupName;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

class PropertyIndexAccess extends ElementIndexAccess {

    private static final long INDEX_VERSION = 1;
    private static final String INDEX_LOCATION = "Property_" + INDEX_VERSION;

    private static final String FIELD_SUBSTITUTION_GROUP = "SUBSTITUTION_GROUP";

    PropertyIndexAccess(final ResourceSet resourceSet) {
        super(resourceSet, INDEX_LOCATION);
    }

    @Override
    protected Document toDocument(final Element e) {
        final Document d = super.toDocument(e);
        d.add(new Field(FIELD_SUBSTITUTION_GROUP, getSubsettedProperties((Property) e), Store.YES, Index.NOT_ANALYZED));
        return d;
    }

    @Override
    protected boolean shouldIndex(final EObject e) {
        return UMLPackage.Literals.PROPERTY.isInstance(e) && e.eIsSet(UMLPackage.Literals.PROPERTY__SUBSETTED_PROPERTY);
    }

    @Override
    protected Query parse(final Criteria c) {
        return new TermQuery(new Term(FIELD_SUBSTITUTION_GROUP, c.searchTerm));
    }

    private String getSubsettedProperties(final Property p) {
        return getSubstitutionGroupName(p.getSubsettedProperties().get(0));
    }
}
