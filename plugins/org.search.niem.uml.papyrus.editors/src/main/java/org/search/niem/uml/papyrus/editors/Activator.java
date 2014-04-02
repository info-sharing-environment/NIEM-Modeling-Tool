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
package org.search.niem.uml.papyrus.editors;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.osgi.framework.BundleContext;
import org.search.niem.uml.papyrus.diagram.clazz.providers.ElementInitializers;

public class Activator extends EMFPlugin {

    public static final String PLUGIN_ID = "org.search.niem.uml.papyrus.editors"; //$NON-NLS-1$
    public static final String NIEM_UML_PAPYRUS_EDITORS_CONTEXT = PLUGIN_ID + ".context"; //$NON-NLS-1$

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

    public static class Implementation extends EclipsePlugin {

        public Implementation() {
            super();

            plugin = this;
        }

        @Override
        public void start(final BundleContext context) throws Exception {
            super.start(context);

            UMLDiagramEditorPlugin.getInstance().setElementInitializers(new ElementInitializers());

            // TODO: remove this in Luna
            final IContextService contextService = (IContextService) PlatformUI.getWorkbench().getService(
                    IContextService.class);
            contextService.activateContext(NIEM_UML_PAPYRUS_EDITORS_CONTEXT);
        }
    }
}
