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
import org.search.niem.uml.qvt.ui.Activator;

public class NIEMpim2mpd extends DiagramTransform {

    @Override
    protected Transformer createDelegate(final URI selection) {
        return new NIEMpim2mpdDelegate(selection);
    }

    @Override
    protected int totalWork() {
        return 2;
    }

    private static final class NIEMpim2mpdDelegate extends ComposedTransformer {
        NIEMpim2mpdDelegate(final URI selection) {
            super(Activator.INSTANCE.getString("_UI_NIEMpim2mpd_Command_name"), new NIEMpim2psmDelegate(selection),
                    new NIEMmpdmodel2artifactDelegate(selection));
        }
    }
}
