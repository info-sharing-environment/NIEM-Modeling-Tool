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
package org.search.niem.xsd.library;

import static java.util.Arrays.asList;
import static org.eclipse.emf.common.util.URI.createPlatformPluginURI;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;

public class Activator extends EMFPlugin {

    public static final String PLUGIN_ID = "org.search.niem.xsd.library"; //$NON-NLS-1$

    public static final String SCHEMA_FOLDER = PLUGIN_ID + "/xsd/niem-2.1/";

    private static final Iterable<URI> infrastructureSchemaLocations;

    static {
        // the order here matters to NIEMpsm2xsd!
        /* @formatter:off */
        infrastructureSchemaLocations = asList(
                createPlatformPluginURI(SCHEMA_FOLDER + "proxy/xsd/2.0/xsd.xsd", true),
                createPlatformPluginURI(SCHEMA_FOLDER + "structures/2.0/structures.xsd", true),
                createPlatformPluginURI(SCHEMA_FOLDER + "appinfo/2.1/appinfo.xsd", true),
                createPlatformPluginURI(SCHEMA_FOLDER + "appinfo/2.0/appinfo.xsd", true)
        );
        /* @formatter:on */
    }

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

    public Iterable<URI> getInfrastructureSchemaLocations() {
        return infrastructureSchemaLocations;
    }

    public static class Implementation extends EclipsePlugin {

        public Implementation() {
            super();

            plugin = this;
        }
    }
}
