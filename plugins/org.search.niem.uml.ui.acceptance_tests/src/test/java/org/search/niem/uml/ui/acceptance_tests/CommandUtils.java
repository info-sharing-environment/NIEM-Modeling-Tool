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

import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_workbench;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.ui.handlers.IHandlerService;

public class CommandUtils {

    public static void run_the_command(final String id) {
        try {
            ((IHandlerService) get_the_workbench().getService(IHandlerService.class)).executeCommand(id, null);
        } catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
            throw new IllegalStateException("Unable to run the command " + id, e);
        }
    }
}
