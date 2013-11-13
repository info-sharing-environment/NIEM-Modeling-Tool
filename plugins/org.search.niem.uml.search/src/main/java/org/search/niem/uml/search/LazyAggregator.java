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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

class LazyAggregator implements Aggregator<EObject> {

    private Iterator<EObject> iterator;
    private int matches;

    @Override
    public void started(final int matches) {
        this.matches = matches;
    }

    @Override
    public void finished() {
    }

    @Override
    public void addAll(final Iterator<EObject> i) {
        iterator = i;
    }

    @Override
    public Collection<EObject> get() {
        final Collection<EObject> myMatches = new ArrayList<>(matches);
        while (iterator.hasNext()) {
            myMatches.add(iterator.next());
        }
        return myMatches;
    }

    @Override
    public int count() {
        return matches;
    }
}
