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

public interface MatchType {
    int NONE = 0;
    int FULL_NAMES_ONLY = 1;
    int DEFINITIONS = 1 << 1;
    int EXTERNALS = 1 << 2;
}