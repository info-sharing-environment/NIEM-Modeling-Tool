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
package org.search.niem.uml.qvt.ui.handlers;

import org.eclipse.emf.common.util.URI;

public class NIEMmpdmodel2artifact extends DiagramTransform {

    @Override
    protected TransformDelegate createDelegate(final URI selection) {
        return new NIEMmpdmodel2artifactDelegate(selection);
    }
}
