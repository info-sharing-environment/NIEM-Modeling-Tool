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

import static org.search.niem.uml.util.NIEMUmlExt.getTargetNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.isNiemNamespace;

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
import org.eclipse.uml2.uml.UMLPackage;

class PackageIndexAccess extends ElementIndexAccess {

    private static final long INDEX_VERSION = 2;
    private static final String INDEX_LOCATION = "Package_" + INDEX_VERSION;

    private static final String FIELD_TARGET_NAMESPACE = "TARGET_NAMESPACE";

    PackageIndexAccess(final ResourceSet resourceSet) {
        super(resourceSet, INDEX_LOCATION);
    }

    @Override
    protected Document toDocument(final Element e) {
        final Document d = super.toDocument(e);
        d.add(new Field(FIELD_TARGET_NAMESPACE, getTargetNamespace(e), Store.YES, Index.NOT_ANALYZED));
        return d;
    }

    @Override
    protected boolean shouldIndex(final EObject e) {
        return UMLPackage.Literals.PACKAGE.isInstance(e) && isNiemNamespace(e);
    }

    @Override
    protected Query parse(final Criteria c) {
        return new TermQuery(new Term(FIELD_TARGET_NAMESPACE, c.searchTerm));
    }
}
