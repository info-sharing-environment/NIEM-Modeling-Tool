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

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.lucene.document.Document;
import org.eclipse.emf.ecore.EObject;

class IndexMatcher {

    private static final int MAX_RESULTS = 5000;

    private final IndexAccess indexAccess;

    private final Aggregator<?> searchResultAggregator;

    IndexMatcher(final IndexAccess indexAccess, final Aggregator<?> searchResultAggregator) {
        this.indexAccess = indexAccess;
        this.searchResultAggregator = searchResultAggregator;
    }

    void match(final Criteria criteria) {
        try (Closeable c = indexAccess) {
            final Collection<Document> matches = indexAccess.search(criteria, MAX_RESULTS);
            searchResultAggregator.started(matches.size());
            searchResultAggregator.addAll(new DocumentsIterator(indexAccess, matches));
        } catch (final IOException e) {
            Activator.INSTANCE.log(e);
        } finally {
            searchResultAggregator.finished();
        }
    }

    private static final class DocumentsIterator implements Iterator<EObject> {

        private final IndexAccess indexAccess;
        private final Iterator<Document> matches;

        DocumentsIterator(final IndexAccess indexAccess, final Collection<Document> matches) {
            this.indexAccess = indexAccess;
            this.matches = matches.iterator();
        }

        @Override
        public boolean hasNext() {
            return matches.hasNext();
        }

        @Override
        public EObject next() {
            return indexAccess.fromDocument(matches.next());
        }

        @Override
        public void remove() {
            matches.remove();
        }
    }

    public boolean hasMatches(final Criteria criteria) {
        try (Closeable c = indexAccess) {
            return !indexAccess.search(criteria, MAX_RESULTS).isEmpty();
        } catch (final IOException e) {
            Activator.INSTANCE.log(e);
            return false;
        }
    }
}
