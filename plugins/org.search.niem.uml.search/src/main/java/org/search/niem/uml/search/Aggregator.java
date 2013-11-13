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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

public interface Aggregator<T> {

    void started(int matches);

    void finished();

    void addAll(Iterator<EObject> i);

    Collection<T> get();

    int count();
}
