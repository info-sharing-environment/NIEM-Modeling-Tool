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
package org.search.niem.uml.resources;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class Activator extends EMFPlugin {

    public static final String PLUGIN_ID = "org.search.niem.uml.resources"; //$NON-NLS-1$

    public static final Activator INSTANCE = new Activator();

    private static Implementation plugin;

    public Activator() {
        super(new ResourceLocator[] {});
    }

    public static Resource getNiemUmlProfile(final ResourceSet resourceSet) {
        return resourceSet.getResource(URI.createURI("pathmap://NIEM_UML/NIEM-UML-Profile.xmi"), true);
    }

    public static Resource getXmlPrimitiveTypes(final ResourceSet resourceSet) {
        return resourceSet.getResource(URI.createURI("http://www.omg.org/spec/NIEM-UML/20120501/XmlPrimitiveTypes.xmi"),
                true);
    }

    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    public static Implementation getPlugin() {
        return plugin;
    }

    public static class Implementation extends EclipsePlugin {

        public Implementation() {
            super();

            plugin = this;
        }
    }
}
