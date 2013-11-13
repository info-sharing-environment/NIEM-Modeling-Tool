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

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static org.apache.commons.lang.StringUtils.defaultString;
import static org.apache.commons.lang.StringUtils.join;
import static org.apache.commons.lang.StringUtils.split;
import static org.search.niem.uml.util.UMLExt.getName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

class NamedElementIndexAccess extends ElementIndexAccess {

    private static final long INDEX_VERSION = 1;
    private static final String INDEX_LOCATION = "NamedElement_" + INDEX_VERSION;

    private static final String FIELD_NAME = "NAME";
    private static final String FIELD_COMMENTS = "COMMENTS";

    private static final Collection<EClass> INDEXABLE_TYPES = unmodifiableSet(new HashSet<>(asList(
            // @formatter:off
            UMLPackage.Literals.CLASS, 
            UMLPackage.Literals.DATA_TYPE, 
            UMLPackage.Literals.ENUMERATION,
            UMLPackage.Literals.PRIMITIVE_TYPE,
            UMLPackage.Literals.PROPERTY
            // @formatter:on
            )));

    NamedElementIndexAccess(final ResourceSet resourceSet) {
        super(resourceSet, INDEX_LOCATION);
    }

    @Override
    protected Document toDocument(final Element e) {
        final Document d = super.toDocument(e);
        d.add(new Field(FIELD_NAME, compact(defaultString(getName(e), StringUtils.EMPTY)), Store.YES, Index.ANALYZED));
        d.add(new Field(FIELD_COMMENTS, getComments(e), Store.YES, Index.ANALYZED));
        return d;
    }

    @Override
    protected boolean shouldIndex(final EObject e) {
        return INDEXABLE_TYPES.contains(e.eClass());
    }

    @Override
    protected Query parse(final Criteria criteria) {
        final String searchTerm = criteria.searchTerm.toLowerCase();
        final BooleanQuery query = new BooleanQuery();
        final String[] terms = split(searchTerm);
        if ((criteria.matchType & MatchType.FULL_NAMES_ONLY | criteria.matchType & MatchType.DEFINITIONS) == 0) {
            query.add(new BooleanClause(newWildcardQuery(FIELD_NAME, searchTerm), Occur.SHOULD));
            query.add(new BooleanClause(newCommentQuery(terms), Occur.SHOULD));
        } else {
            if ((criteria.matchType & MatchType.FULL_NAMES_ONLY) > 0) {
                query.add(new BooleanClause(newPhraseQuery(FIELD_NAME, terms), Occur.SHOULD));
            }
            if ((criteria.matchType & MatchType.DEFINITIONS) > 0) {
                query.add(new BooleanClause(newCommentQuery(terms), Occur.SHOULD));
            }
        }
        if ((criteria.matchType & MatchType.EXTERNALS) == 0) {
            query.add(new BooleanClause(new WildcardQuery(new Term(FIELD_RESOURCE, "NIEM-Reference-external-*")),
                    Occur.MUST_NOT));
        }
        return query;
    }

    private Query newPhraseQuery(final String field, final String[] terms) {
        final PhraseQuery q = new PhraseQuery();
        for (final String term : terms) {
            q.add(new Term(field, term));
        }
        return q;
    }

    private Query newWildcardQuery(final String field, final String term) {
        final StringBuilder b = new StringBuilder(term);
        if (!term.startsWith("*")) {
            b.insert(0, '*');
        }
        if (!term.endsWith("*")) {
            b.append('*');
        }
        return new WildcardQuery(new Term(field, b.toString()));
    }

    private Query newCommentQuery(final String[] terms) {
        return terms.length == 1 ? newWildcardQuery(FIELD_COMMENTS, terms[0]) : newPhraseQuery(FIELD_COMMENTS, terms);
    }

    private String getComments(final Element e) {
        final Collection<String> comments = new ArrayList<>();
        for (final Comment comment : e.getOwnedComments()) {
            if (comment.isSetBody()) {
                comments.add(compact(comment.getBody()));
            }
        }
        return join(comments, '\n');
    }

    private static String compact(final String s) {
        return s.trim().replaceAll("\\s+", " ");
    }
}
