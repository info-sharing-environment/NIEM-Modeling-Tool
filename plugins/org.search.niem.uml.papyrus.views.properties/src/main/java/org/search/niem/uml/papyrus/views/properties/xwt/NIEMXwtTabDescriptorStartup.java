package org.search.niem.uml.papyrus.views.properties.xwt;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IStartup;
import org.search.niem.uml.papyrus.views.properties.Activator;
import org.search.niem.uml.papyrus.views.properties.util.JavaExt;

public class NIEMXwtTabDescriptorStartup implements IStartup {

    private static final String MASTER_TOKEN = "masterToken";
    private static final String TREE_OUTLINE_PAGE = "TreeOutlinePage";
    private static final String CONTRIBUTOR_ID = "contributorId";

    @Override
    public void earlyStartup() {
        final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
        for (final IConfigurationElement propertyContributorExtension : getPropertyContributorExtensionPoint()
                .getConfigurationElements()) {
            final String contributorId = propertyContributorExtension.getAttribute(CONTRIBUTOR_ID);
            if (TREE_OUTLINE_PAGE.equals(contributorId)) {
                if (!Activator.PLUGIN_ID.equals(propertyContributorExtension.getContributor().getName())) {
                    final Object masterToken = JavaExt.get(MASTER_TOKEN, extensionRegistry);
                    extensionRegistry.removeExtension(propertyContributorExtension.getDeclaringExtension(), masterToken);
                }
            }
        }
    }

    @SuppressWarnings("restriction")
    private IExtensionPoint getPropertyContributorExtensionPoint() {
        return Platform.getExtensionRegistry().getExtensionPoint(
                org.eclipse.ui.internal.views.properties.tabbed.TabbedPropertyViewPlugin.getPlugin().getBundle()
                        .getSymbolicName(), "propertyContributor");
    }
}
