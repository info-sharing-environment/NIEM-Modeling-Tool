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
package org.search.niem.uml.ui.acceptance_tests;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

@SuppressWarnings("restriction")
public class AcceptanceTestRunner extends BlockJUnit4ClassRunner {

    public AcceptanceTestRunner(final Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        return ContextInjectionFactory.make(getTestClass().getJavaClass(), E4Workbench.getServiceContext().getActiveLeaf());
    }
}
