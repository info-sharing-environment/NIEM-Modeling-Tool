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
package org.search.niem.uml.util;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CollectionExt {

    public static boolean allAreNull(final Object... objects) {
        for (final Object o : objects) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyIsNull(final Object... objects) {
        for (final Object o : objects) {
            if (o == null) {
                return true;
            }
        }
        return false;
    }

    public static <T> Collection<T> minus(final Collection<T> minuend, final Collection<T> subtrahend) {
        final LinkedHashSet<T> difference = new LinkedHashSet<T>(minuend);
        difference.removeAll(subtrahend);
        return difference;
    }
}
