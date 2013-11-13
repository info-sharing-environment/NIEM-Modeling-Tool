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
package org.search.niem.uml.ui.acceptance_tests.rules;

import static org.search.niem.uml.ui.acceptance_tests.UIUtils.close_all_open_editors;

import org.junit.rules.ExternalResource;

public class OpensEditors extends ExternalResource {
    @Override
    protected void after() {
        close_all_open_editors();
    }
}
