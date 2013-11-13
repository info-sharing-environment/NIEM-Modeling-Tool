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
package org.search.niem.uml.search.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

public class FontsAndColors {

    public final Font font;
    public final Color foreground;
    public final Color background;

    public FontsAndColors(final Font font, final Color foreground, final Color background) {
        this.font = font;
        this.foreground = foreground;
        this.background = background;
    }
}
