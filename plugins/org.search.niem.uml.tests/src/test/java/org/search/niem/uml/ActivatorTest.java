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
package org.search.niem.uml;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ActivatorTest {

    @Test
    public void should_activate_the_plugin() {
        assertNotNull(Activator.INSTANCE);
    }
}
