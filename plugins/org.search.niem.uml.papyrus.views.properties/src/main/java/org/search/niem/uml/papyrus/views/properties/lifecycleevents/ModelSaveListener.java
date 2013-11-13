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
package org.search.niem.uml.papyrus.views.properties.lifecycleevents;

import static org.search.niem.uml.papyrus.views.properties.util.JavaExt.get;
import static org.search.niem.uml.papyrus.views.properties.util.JavaExt.isInnerType;
import static org.search.niem.uml.util.NIEMUmlExt.findMPD;
import static org.search.niem.uml.util.NIEMUmlExt.getAppliedMpdStereotype;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDLastRevisionDate;

import java.util.Date;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.properties.databinding.StereotypeApplicationObservableList;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.papyrus.uml.properties.widgets.StereotypeApplication;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.search.niem.uml.papyrus.lifecycleevents.NIEMUmlLifecycleAdapter;
import org.search.niem.uml.papyrus.views.properties.Activator;

public class ModelSaveListener extends NIEMUmlLifecycleAdapter {
    @Override
    public void aboutToSave(final ModelSet theModelSet) {
        final Resource theUmlResource = getTheUmlResource(theModelSet);
        if (theUmlResource == null) {
            return;
        }
        final Element theMPD = findMPD(theUmlResource);
        if (theMPD != null) {
            final TransactionalEditingDomain theDomain = theModelSet.getTransactionalEditingDomain();
            theDomain.getCommandStack().execute(
                    new RecordingCommand(theDomain, Activator.INSTANCE.getString("_UI_ModelSaveListener_command_name"),
                            Activator.INSTANCE.getString("_UI_ModelSaveListener_command_description")) {
                        @Override
                        protected void doExecute() {
                            setMPDLastRevisionDate(theMPD, new Date());
                        }
                    });
            refreshThePropertyView(theMPD.getStereotypeApplication(getAppliedMpdStereotype(theMPD)));
        }
    }

    // This is necessary for a bug in how databinding is done in the Papyrus properties viewer in order to refresh the
    // stereotype application tree viewer.
    private void refreshThePropertyView(final EObject theStereotypeApplication) {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                for (final Adapter adapter : theStereotypeApplication.eAdapters()) {
                    if (isInnerType(adapter, StereotypeApplicationObservableList.class)) {
                        final ListenerList[] listenerLists = get(ListenerList[].class,
                                get(StereotypeApplicationObservableList.class, adapter));
                        if (listenerLists != null) {
                            for (final ListenerList listenerList : listenerLists) {
                                for (final Object listener : listenerList.getListeners()) {
                                    if (isInnerType(listener, StereotypeApplication.class)) {
                                        final AppliedStereotypeCompositeWithView composite = get(
                                                AppliedStereotypeCompositeWithView.class,
                                                get(StereotypeApplication.class, listener));
                                        if (composite != null) {
                                            composite.refreshTreeViewer();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
