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
package org.search.niem.uml.evl.validation;

import org.search.niem.uml.evl.Activator;
import org.search.niem.uml.util.NiemValidator;

public class NiemValidationTool extends NiemValidator {
    public String getMessage(final String key, final Object substitution) {
        return Activator.INSTANCE.getString(key, new Object[] { substitution });
    }

    public String getMessage(final String key) {
        return Activator.INSTANCE.getString(key);
    }
}
