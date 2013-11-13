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
package org.search.niem.uml.papyrus.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.infra.core.lifecycleevents.SaveAndDirtyService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.osgi.framework.Bundle;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.papyrus.lifecycleevents.LifecycleListener;

public class NIEMModelLifecycleRegistry implements LifecycleListener, IStartup, IPartListener2 {

    private static final String LIFECYCLE_LISTENER_EXTENSION_ID = Activator.PLUGIN_ID
            + ".lifecycleevents.lifecycleListeners";

    private static final String CLASS_ATTRIBUTE = "class";

    private final AtomicReference<Collection<LifecycleListener>> listeners = new AtomicReference<>();

    private final ConcurrentMap<IWorkbenchPartReference, IEditorInputChangedListener> changeListeners = new ConcurrentHashMap<>();
    private final ConcurrentMap<IWorkbenchPartReference, ISaveEventListener> aboutToSaveListeners = new ConcurrentHashMap<>();
    private final ConcurrentMap<IWorkbenchPartReference, ISaveEventListener> saveListeners = new ConcurrentHashMap<>();
    private final ConcurrentMap<IWorkbenchPartReference, ISaveEventListener> savedListeners = new ConcurrentHashMap<>();

    private Collection<LifecycleListener> listeners() {
        final Collection<LifecycleListener> existingListeners = listeners.get();
        if (existingListeners != null) {
            return existingListeners;
        }
        final Collection<LifecycleListener> newLifecycleListeners = new ArrayList<>();
        for (final IConfigurationElement lifecycleListenerElement : Platform.getExtensionRegistry()
                .getConfigurationElementsFor(LIFECYCLE_LISTENER_EXTENSION_ID)) {
            final Bundle extensionBundle = Platform.getBundle(lifecycleListenerElement.getDeclaringExtension()
                    .getNamespaceIdentifier());
            try {
                newLifecycleListeners.add((LifecycleListener) extensionBundle.loadClass(
                        lifecycleListenerElement.getAttribute(CLASS_ATTRIBUTE)).newInstance());
            } catch (ClassNotFoundException | InvalidRegistryObjectException | InstantiationException
                    | IllegalAccessException e) {
                Activator.INSTANCE.log(e);
            }
        }
        if (listeners.compareAndSet(null, newLifecycleListeners)) {
            return newLifecycleListeners;
        }
        return listeners.get();
    }

    @Override
    public void earlyStartup() {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                initializeOpenEditors(workbenchWindow);
                workbenchWindow.getPartService().addPartListener(NIEMModelLifecycleRegistry.this);
            }
        });
    }

    @Override
    public void opened(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.opened(theModelSet);
                }
            });
        }
    }

    @Override
    public void changed(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.changed(theModelSet);
                }
            });
        }
    }

    @Override
    public void aboutToSave(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.aboutToSave(theModelSet);
                }
            });
        }
    }

    @Override
    public void saving(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.saving(theModelSet);
                }
            });
        }
    }

    @Override
    public void saved(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.saved(theModelSet);
                }
            });
        }
    }

    @Override
    public void closed(final ModelSet theModelSet) {
        for (final LifecycleListener listener : listeners()) {
            run(new SafeRunnable() {
                @Override
                public void run() throws Exception {
                    listener.closed(theModelSet);
                }
            });
        }
    }

    private void run(final ISafeRunnable r) {
        SafeRunner.run(r);
    }

    private void initializeOpenEditors(final IWorkbenchWindow theWorkbenchWindow) {
        for (final IWorkbenchPage page : theWorkbenchWindow.getPages()) {
            for (final IEditorReference editor : page.getEditorReferences()) {
                partOpened(editor);
            }
        }
    }

    @Override
    public void partOpened(final IWorkbenchPartReference part) {
        if (canListenToLifecycle(part)) {
            final ServicesRegistry servicesRegistry = getServicesRegistry(part.getPart(true));
            opened(getModelSet(servicesRegistry));
            listen(part, servicesRegistry);
        }
    }

    private void listen(final IWorkbenchPartReference part, final ServicesRegistry servicesRegistry) {
        final SaveAndDirtyService saveAndDirtyService = getSaveAndDirtyService(servicesRegistry);
        final ModelSet theModelSet = getModelSet(servicesRegistry);
        final IEditorInputChangedListener changeListener = new ChangeListener(theModelSet);
        final ISaveEventListener aboutToSaveListener = new AboutToSaveListener(theModelSet);
        final ISaveEventListener saveListener = new SavingListener(theModelSet);
        final ISaveEventListener savedListener = new SavedListener(theModelSet);
        changeListeners.put(part, changeListener);
        aboutToSaveListeners.put(part, aboutToSaveListener);
        saveListeners.put(part, saveListener);
        savedListeners.put(part, savedListener);
        saveAndDirtyService.addInputChangedListener(changeListener);
        saveAndDirtyService.addAboutToDoSaveListener(aboutToSaveListener);
        saveAndDirtyService.addDoSaveListener(saveListener);
        saveAndDirtyService.addPostDoSaveListener(savedListener);
    }

    private void unlisten(final IWorkbenchPartReference part, final ServicesRegistry servicesRegistry) {
        final SaveAndDirtyService saveAndDirtyService = getSaveAndDirtyService(servicesRegistry);
        saveAndDirtyService.removeInputChangedListener(changeListeners.remove(part));
        saveAndDirtyService.removeAboutToDoSaveListener(aboutToSaveListeners.remove(part));
        saveAndDirtyService.removeDoSaveListener(saveListeners.remove(part));
        saveAndDirtyService.removePostDoSaveListener(savedListeners.remove(part));
    }

    @Override
    public void partClosed(final IWorkbenchPartReference part) {
        if (canListenToLifecycle(part)) {
            final ServicesRegistry servicesRegistry = getServicesRegistry(part.getPart(true));
            closed(getModelSet(servicesRegistry));
            unlisten(part, servicesRegistry);
        }
    }

    private boolean canListenToLifecycle(final IWorkbenchPartReference part) {
        return PapyrusMultiDiagramEditor.EDITOR_ID.equals(part.getId())
                && getModelSet(getServicesRegistry(part.getPart(true))).getURIWithoutExtension().isPlatformResource();
    }

    private ServicesRegistry getServicesRegistry(final IAdaptable servicesRegistryAdapter) {
        return (ServicesRegistry) servicesRegistryAdapter.getAdapter(ServicesRegistry.class);
    }

    private SaveAndDirtyService getSaveAndDirtyService(final ServicesRegistry servicesRegistry) {
        try {
            return (SaveAndDirtyService) servicesRegistry.getService(ISaveAndDirtyService.class);
        } catch (final ServiceException e) {
            throw new IllegalStateException("Unable to get the SaveAndDirtyService from the ServicesRegistry", e);
        }
    }

    private ModelSet getModelSet(final ServicesRegistry servicesRegistry) {
        try {
            return servicesRegistry.getService(ModelSet.class);
        } catch (final ServiceException e) {
            throw new IllegalStateException("Unable to get the ModelSet from the ServiceRegistry.");
        }
    }

    @Override
    public void partActivated(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partBroughtToTop(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partDeactivated(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partHidden(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partVisible(final IWorkbenchPartReference partRef) {
        // no-op
    }

    @Override
    public void partInputChanged(final IWorkbenchPartReference partRef) {
        // no-op
    }

    private final class ChangeListener implements IEditorInputChangedListener {
        private final ModelSet theModelSet;

        private ChangeListener(final ModelSet theModelSet) {
            this.theModelSet = theModelSet;
        }

        @Override
        public void editorInputChanged(final FileEditorInput fileEditorInput) {
            // no-op
        }

        @Override
        public void isDirtyChanged() {
            changed(theModelSet);
        }
    }

    private final class SavedListener implements ISaveEventListener {
        private final ModelSet theModelSet;

        private SavedListener(final ModelSet theModelSet) {
            this.theModelSet = theModelSet;
        }

        @Override
        public void doSaveAs(final DoSaveEvent event) {
            saved(theModelSet);
        }

        @Override
        public void doSave(final DoSaveEvent event) {
            saved(theModelSet);
        }
    }

    private final class SavingListener implements ISaveEventListener {
        private final ModelSet theModelSet;

        private SavingListener(final ModelSet theModelSet) {
            this.theModelSet = theModelSet;
        }

        @Override
        public void doSaveAs(final DoSaveEvent event) {
            saving(theModelSet);
        }

        @Override
        public void doSave(final DoSaveEvent event) {
            saving(theModelSet);
        }
    }

    private final class AboutToSaveListener implements ISaveEventListener {
        private final ModelSet theModelSet;

        private AboutToSaveListener(final ModelSet theModelSet) {
            this.theModelSet = theModelSet;
        }

        @Override
        public void doSaveAs(final DoSaveEvent event) {
            aboutToSave(theModelSet);
        }

        @Override
        public void doSave(final DoSaveEvent event) {
            aboutToSave(theModelSet);
        }
    }

    private abstract static class SafeRunnable implements ISafeRunnable {
        @Override
        public final void handleException(final Throwable exception) {
            Activator.INSTANCE.log(exception);
        }
    }
}
