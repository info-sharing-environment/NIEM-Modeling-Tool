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
package org.search.niem.uml.papyrus.util;

import static org.search.niem.uml.papyrus.util.DiagramExt.collectViews;
import static org.search.niem.uml.papyrus.util.DiagramExt.destroy;
import static org.search.niem.uml.util.UMLExt.remove;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;

public class PapyrusExt {

    public static void delete(final Iterable<Element> elements, final Resource theNotationResource) {
        for (final EObject aView : collectViews(elements, theNotationResource)) {
            destroy(aView);
        }
        for (final Element anElement : elements) {
            remove(anElement);
        }
    }

    public static TransactionalEditingDomain getTheEditingDomain() {
        return getTheEditingDomain(getTheServicesRegistry());
    }

    public static TransactionalEditingDomain getTheEditingDomain(final ServicesRegistry servicesRegistry) {
        try {
            return servicesRegistry.getService(TransactionalEditingDomain.class);
        } catch (final ServiceException e) {
            throw new IllegalStateException(e);
        }
    }

    public static IPageManager getThePageManager() {
        return getThePageManager(getTheServicesRegistry());
    }

    public static IPageManager getThePageManager(final ServicesRegistry servicesRegistry) {
        try {
            return servicesRegistry.getService(IPageManager.class);
        } catch (final ServiceException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ServicesRegistry getTheServicesRegistry() {
        final IEditorPart activeEditor = getActivePage().getActiveEditor();
        return (ServicesRegistry) (activeEditor == null ? null : activeEditor.getAdapter(ServicesRegistry.class));
    }

    private static IWorkbenchPage getActivePage() {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    }

    public static ServicesRegistry createServicesRegistry() throws ServiceException {
        final ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);

        exec(new Lambda() {
            @Override
            public void _() throws ServiceException {
                registry.startServicesByClassKeys(ModelSet.class);
            }
        });

        return registry;
    }

    public static void initServicesRegistry(final ServicesRegistry registry) throws ServiceException {
        exec(new Lambda() {
            @Override
            public void _() throws ServiceException {
                registry.startRegistry();
            }
        });
        registry.getService(IPageManager.class);
    }

    public static void disposeServicesRegistry(final ServicesRegistry registry) throws ServiceException {
        exec(new Lambda() {
            @Override
            public void _() throws ServiceException {
                registry.disposeRegistry();
            }
        });
    }

    private static void exec(final Lambda lambda) {
        try {
            lambda._();
        } catch (final ServiceException e) {
            // Ignore this exception: some services may not have been loaded,
            // which is probably normal at this point
        }
    }

    private static interface Lambda {
        void _() throws ServiceException;
    }
}
