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
package org.search.niem.uml.search.ui.dialog;

import java.util.Collection;

import org.eclipse.swt.widgets.TreeItem;

public interface NiemCheckedTreeSelectionListener {
    void greyed(final Collection<TreeItem> treeItems);

    void checked(final Collection<TreeItem> treeItems);

    void unchecked(final Collection<TreeItem> treeItems);
}
