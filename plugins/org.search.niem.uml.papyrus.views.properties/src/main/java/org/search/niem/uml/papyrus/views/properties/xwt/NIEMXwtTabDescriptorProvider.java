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
package org.search.niem.uml.papyrus.views.properties.xwt;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableCollection;
import static org.search.niem.uml.papyrus.views.properties.util.JavaExt.call;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.common.ui.util.PartListenerAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.modelelement.DataSource;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.views.properties.xwt.XWTTabDescriptorProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

public class NIEMXwtTabDescriptorProvider extends XWTTabDescriptorProvider {

    private ITabDescriptor[] cachedResult;

    private ISelection previousSelection;

    private IWorkbenchPart previousPart;

    private final Map<IWorkbenchPart, DisplayEngine> displays = new HashMap<IWorkbenchPart, DisplayEngine>();

    private static final class NIEMDisplayEngine extends DefaultDisplayEngine {
        private static final String PAPYRUS_TAB_ID = "uml";
        private static final String PAPYRUS_TAB_CATEGORY = "org.eclipse.papyrus";
        private static final Collection<String> NIEM_SUBSET_SECTIONS;
        static {
            // @formatter:off
            NIEM_SUBSET_SECTIONS = unmodifiableCollection(new HashSet<>(asList(
                    "SingleAssociation", 
                    "SingleAssociationClass",
                    "SingleClass", 
                    "SingleComponent", 
                    "SingleDataType", 
                    "SingleEnumeration", 
                    "SingleEnumerationLiteral",
                    "SingleGeneralization", 
                    "SingleModel", 
                    "SinglePackage", 
                    "SinglePrimitiveType", 
                    "SingleProperty", 
                    "SingleRealization"
                    )));
            // @formatter:on
        }

        @Override
        public Control createSection(final Composite parent, final Section section, final DataSource source) {
            return NIEM_SUBSET_SECTIONS.contains(section.getName())
                    && PAPYRUS_TAB_CATEGORY.equals(section.getTab().getCategory())
                    && PAPYRUS_TAB_ID.equals(section.getTab().getId()) ? null : super.createSection(parent, section, source);
        }
    }

    private DisplayEngine getDisplay(final IWorkbenchPart part) {
        if (!displays.containsKey(part)) {
            displays.put(part, new NIEMDisplayEngine());
            part.getSite().getPage().addPartListener(new PartListenerAdapter() {
                @Override
                public void partClosed(final IWorkbenchPart part) {
                    part.getSite().getPage().removePartListener(this);
                    final DisplayEngine display = displays.get(part);
                    if (display != null) {
                        display.dispose();
                        displays.remove(part);
                    }
                    previousPart = null;
                    previousSelection = null;
                }
            });
        }

        return displays.get(part);
    }

    @Override
    public ITabDescriptor[] getTabDescriptors(final IWorkbenchPart part, final ISelection selection) {
        if (selection != previousSelection || part != previousPart) {
            previousSelection = selection;
            previousPart = part;

            final List<ITabDescriptor> descriptors = new LinkedList<ITabDescriptor>();
            final Set<View> views = ConfigurationManager.instance.constraintEngine.getViews(selection);
            if (!views.isEmpty()) {
                descriptors.addAll(getDisplay(part).getTabDescriptors(views));
            }

            final ITabbedPropertySheetPageContributor contributor = part instanceof ITabbedPropertySheetPageContributor ? (ITabbedPropertySheetPageContributor) part
                    : (ITabbedPropertySheetPageContributor) part.getAdapter(ITabbedPropertySheetPageContributor.class);

            @SuppressWarnings("restriction")
            final org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory tabbedPropertyRegistryFactory = org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory
                    .getInstance();
            if (contributor != null) {
                @SuppressWarnings("restriction")
                final org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry registry = tabbedPropertyRegistryFactory
                        .createRegistry(contributor);

                final ITabDescriptor[] registeredTabDesriptors = call("getAllTabDescriptors", registry);

                if (registeredTabDesriptors != null) {
                    for (final ITabDescriptor descriptor : registeredTabDesriptors) {
                        if (descriptor.getSectionDescriptors().size() > 0) {
                            descriptors.add(descriptor);
                        }
                    }
                }
            }

            orderTabDescriptors(descriptors);

            cachedResult = descriptors.toArray(new ITabDescriptor[descriptors.size()]);

            dispose(tabbedPropertyRegistryFactory, contributor);
        }

        return cachedResult;
    }

    @SuppressWarnings("restriction")
    private void dispose(
            final org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory tabbedPropertyRegistryFactory,
            final ITabbedPropertySheetPageContributor part) {
        tabbedPropertyRegistryFactory.disposeRegistry(part);
    }

}
