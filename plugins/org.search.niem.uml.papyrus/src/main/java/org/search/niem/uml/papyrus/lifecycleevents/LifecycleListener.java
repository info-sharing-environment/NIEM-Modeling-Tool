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
package org.search.niem.uml.papyrus.lifecycleevents;

import org.eclipse.papyrus.infra.core.resource.ModelSet;

public interface LifecycleListener {

    void opened(final ModelSet theModelSet);

    void changed(final ModelSet theModelSet);

    void aboutToSave(final ModelSet theModelSet);

    void saving(final ModelSet theModelSet);

    void saved(final ModelSet theModelSet);

    void closed(final ModelSet theModelSet);
}
