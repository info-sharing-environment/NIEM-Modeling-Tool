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
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class AggregatorAdapter<T> implements Aggregator<T> {
    private List<T> matches;

    @Override
    public void started(final int matches) {
        this.matches = new ArrayList<>(matches);
    }

    @Override
    public Collection<T> get() {
        return matches;
    }

    @Override
    public void finished() {
        // no-op
    }

    @Override
    public void addAll(final Iterator<EObject> i) {
        while (i.hasNext()) {
            matches.add(adapt(i.next()));
        }
    }

    protected abstract T adapt(EObject e);
}