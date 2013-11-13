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
package org.search.niem.uml.qvt.ui;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

public class Activator extends EMFPlugin {

    public static final String PLUGIN_ID = "org.search.niem.uml.qvt.ui"; //$NON-NLS-1$

    public static final String NIEM_PIM_2_PSM_ID = PLUGIN_ID + ".commands.NIEMpim2psm";
    public static final String NIEM_PSM_2_XSD_ID = PLUGIN_ID + ".commands.NIEMpsm2xsd";
    public static final String NIEM_MPD_2_CAT_ID = PLUGIN_ID + ".commands.NIEMmpdmodel2artifact";

    public static final Activator INSTANCE = new Activator();

    private static Implementation plugin;

    public Activator() {
        super(new ResourceLocator[] {});
    }

    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    public static Implementation getPlugin() {
        return plugin;
    }

    public static class Implementation extends EclipseUIPlugin {
        public Implementation() {
            super();

            plugin = this;
        }
    }
}
