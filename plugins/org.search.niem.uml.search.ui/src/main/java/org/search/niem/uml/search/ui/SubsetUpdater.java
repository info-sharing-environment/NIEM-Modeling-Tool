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
package org.search.niem.uml.search.ui;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils.getNotationResource;
import static org.eclipse.papyrus.uml.tools.model.UmlUtils.getUmlModel;
import static org.search.niem.uml.merge.NamespaceMergeUtil.mapEquivalents;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_SYNC_CLASS_DIAGRAMS_WITH_UML;
import static org.search.niem.uml.papyrus.util.PapyrusExt.delete;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getTheEditingDomain;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getThePageManager;
import static org.search.niem.uml.util.CollectionExt.minus;
import static org.search.niem.uml.util.NIEMUmlExt.getReferenceLibrarySubsets;
import static org.search.niem.uml.util.NIEMUmlExt.isPIM;
import static org.search.niem.uml.util.UMLExt.collectOwnedElementsAndRelationships;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.merge.DiagramSynchronizer;
import org.search.niem.uml.merge.NamespaceMerger;
import org.search.niem.uml.merge.ReferenceCollector;

public final class SubsetUpdater {

    private static Iterable<EClass> supportedTypes = unmodifiableSet(new HashSet<>(asList(UMLPackage.Literals.CLASS,
            UMLPackage.Literals.DATA_TYPE, UMLPackage.Literals.PROPERTY)));

    private final Shell theShell;
    private final FontsAndColors theFontsAndColors;
    private final ServicesRegistry theServicesRegistry;
    private final Object theReferenceLibraryElement;

    public SubsetUpdater(final Shell theShell, final FontsAndColors theFontsAndColors,
            final ServicesRegistry theServicesRegistry, final Object theReferenceLibraryElement) {
        this.theShell = theShell;
        this.theFontsAndColors = theFontsAndColors;
        this.theServicesRegistry = theServicesRegistry;
        this.theReferenceLibraryElement = theReferenceLibraryElement;
    }

    public void updateTheSubset() {
        final Package thePIM = getThePIM(theServicesRegistry);
        final Resource theNotationResource = getNotationResource(theServicesRegistry);

        if (!theTypeIsSupported(theReferenceLibraryElement) || theServicesRegistry == null || thePIM == null
                || theNotationResource == null) {
            return;
        }

        final NiemReferencesSelectionDialog theDialog = new NiemReferencesSelectionDialog(theShell, theFontsAndColors,
                thePIM, theReferenceLibraryElement);
        theDialog.open();
        if (theDialog.getReturnCode() != Window.OK) {
            return;
        }
        final IPageManager thePageManager = getThePageManager(theServicesRegistry);

        final Collection<EObject> checkedElements = new HashSet<>(EcoreUtil.<EObject> getObjectsByType(
                asList(theDialog.getResult()), EcorePackage.Literals.EOBJECT));
        final Collection<EObject> uncheckedElements = EcoreUtil.<EObject> getObjectsByType(theDialog.getUnchecked(),
                EcorePackage.Literals.EOBJECT);

        try {
            new ProgressMonitorDialog(theShell).run(false, true, new IRunnableWithProgress() {
                @Override
                public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    monitor.beginTask(Activator.INSTANCE.getString("_UI_SubsetUpdater_progress"), 17);
                    try {

                        final Collection<EObject> referenceLibraryElements2Add = minus(checkedElements, uncheckedElements);

                        final ReferenceCollector referenceCollector = new ReferenceCollector(EcoreUtil
                                .<Element> getObjectsByType(referenceLibraryElements2Add, UMLPackage.Literals.NAMED_ELEMENT));
                        final Collection<EObject> referenceLibraryElements2AddPlusReferences = referenceCollector
                                .collect(new SubProgressMonitor(monitor, 2));

                        final Collection<EObject> referenceLibraryElements2Delete = minus(uncheckedElements,
                                referenceLibraryElements2AddPlusReferences);

                        final Collection<Element> pimElements2DeletePlusReferences = new HashSet<>(mapEquivalents(
                                referenceLibraryElements2Delete, thePIM));
                        pimElements2DeletePlusReferences
                                .addAll(collectOwnedElementsAndRelationships(pimElements2DeletePlusReferences));

                        final NamespaceMerger merger = new NamespaceMerger(thePIM,
                                referenceLibraryElements2AddPlusReferences);

                        final TransactionalEditingDomain theEditingDomain = getTheEditingDomain(theServicesRegistry);
                        final RecordingCommand theMergeCommand = new RecordingCommand(theEditingDomain, Activator.INSTANCE
                                .getString("_UI_SubsetUpdater_command_label"), Activator.INSTANCE
                                .getString("_UI_SubsetUpdater_command_description")) {

                            private void doDelete() {
                                subTask("_UI_SubsetUpdater_command_progress_removingElements");
                                delete(pimElements2DeletePlusReferences, theNotationResource);
                                monitor.worked(1);
                            }

                            private void doAdd() {
                                merger.copyAll(new SubProgressMonitor(monitor, 10));
                                subTask("_UI_SubsetUpdater_command_progress_resolvingReferences");
                                merger.copyReferences();
                                monitor.worked(1);
                                subTask("_UI_SubsetUpdater_command_progress_addingNewSubsets");
                                final Collection<PackageableElement> newNamespaces = merger.getNewNamespaces();
                                thePIM.getPackagedElements().addAll(newNamespaces);
                                monitor.worked(1);

                                if (org.search.niem.uml.papyrus.Activator.getPlugin().getPreferenceStore()
                                        .getBoolean(P_SYNC_CLASS_DIAGRAMS_WITH_UML)) {
                                    subTask("_UI_SubsetUpdater_command_progress_synchingClassDiagrams");
                                    final Collection<PackageableElement> theNIEMReferenceSubsets = new LinkedHashSet<>(
                                            newNamespaces);
                                    theNIEMReferenceSubsets.addAll(getReferenceLibrarySubsets(thePIM));
                                    new DiagramSynchronizer(theNotationResource, thePageManager)
                                            .merge(theNIEMReferenceSubsets);
                                }
                                monitor.worked(1);

                                subTask("_UI_SubsetUpdater_command_progress_applyingStereotypes");
                                thePIM.eResource().getContents().addAll(merger.getNewStereotypeApplications());
                                monitor.worked(1);
                            }

                            @Override
                            protected void doExecute() {
                                doDelete();
                                doAdd();
                            }

                            private void subTask(final String key) {
                                monitor.subTask(Activator.INSTANCE.getString(key));
                            }
                        };
                        theEditingDomain.getCommandStack().execute(theMergeCommand);
                    } finally {
                        monitor.done();
                    }
                }
            });
        } catch (final InvocationTargetException e) {
            Activator.INSTANCE.log(e);
        } catch (final InterruptedException e) {
            // no-op
        }
    }

    private boolean theTypeIsSupported(final Object theType) {
        for (final EClass aSupportedType : supportedTypes) {
            if (aSupportedType.isInstance(theType)) {
                return true;
            }
        }
        return false;
    }

    private Package getThePIM(final ServicesRegistry servicesRegistry) {
        if (servicesRegistry == null) {
            return null;
        }
        final UmlModel theActiveModel = getUmlModel(servicesRegistry);
        if (theActiveModel == null) {
            return null;
        }
        final List<EObject> theModelContents = theActiveModel.getResource().getContents();
        if (theModelContents.isEmpty()) {
            return null;
        }
        for (final Package p : ((Model) theModelContents.get(0)).getNestedPackages()) {
            if (isPIM(p)) {
                return p;
            }
        }
        return null;
    }
}