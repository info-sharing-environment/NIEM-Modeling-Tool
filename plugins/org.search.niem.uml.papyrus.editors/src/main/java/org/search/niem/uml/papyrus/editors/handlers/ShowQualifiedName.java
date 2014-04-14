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
package org.search.niem.uml.papyrus.editors.handlers;

public class ShowQualifiedName extends ShowName {

    static final int QUALIFIED_NAME_DEPTH = 0;

    @Override
    protected int getDepth() {
        return QUALIFIED_NAME_DEPTH;
    }
}
