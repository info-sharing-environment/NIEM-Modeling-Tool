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


public class ShowLocalName extends ShowName {

    static final int LOCAL_NAME_DEPTH = 1000;

    @Override
    protected int getDepth() {
        return LOCAL_NAME_DEPTH;
    }
}
