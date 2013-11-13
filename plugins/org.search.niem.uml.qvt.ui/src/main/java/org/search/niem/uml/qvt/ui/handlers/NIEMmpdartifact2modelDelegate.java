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
package org.search.niem.uml.qvt.ui.handlers;

import static org.eclipse.emf.ecore.util.EcoreUtil.copyAll;
import static org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils.getDiResource;
import static org.eclipse.papyrus.infra.gmfdiag.common.DiagramsUtil.getAssociatedDiagramsFromNotationResource;
import static org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils.getNotationResource;
import static org.eclipse.papyrus.uml.tools.model.UmlUtils.getUmlResource;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.mpd.cat.util.CatExt.getTheMPDName;
import static org.search.niem.uml.papyrus.util.PapyrusExt.createServicesRegistry;
import static org.search.niem.uml.papyrus.util.PapyrusExt.disposeServicesRegistry;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getThePageManager;
import static org.search.niem.uml.papyrus.util.PapyrusExt.initServicesRegistry;
import static org.search.niem.uml.util.UMLExt.isStereotypeApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.search.niem.mpd.cat.util.CatResourceFactoryImpl;
import org.search.niem.uml.merge.DiagramSynchronizer;
import org.search.niem.uml.qvt.ui.Activator;

public class NIEMmpdartifact2modelDelegate extends TransformDelegate {

    private Resource thePIM;
    private BasicModelExtent thePIMExtent;
    private ModelSet theModelSet;
    private ServicesRegistry theServicesRegistry;

    protected NIEMmpdartifact2modelDelegate(final URI selection) {
        super(selection, org.search.niem.uml.qvt.Activator.INSTANCE.getNIEMmpdartifact2modelLocation(), Activator.INSTANCE
                .getString("_UI_NIEMmpdartifact2model_Command_name"));
    }

    @Override
    protected ResourceSet createResourceSet() {
        final ResourceSet theResourceSet = super.createResourceSet();
        theResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new CatResourceFactoryImpl());
        return theResourceSet;
    }

    protected URI getThePimUri() {

        return theSelectedResource.getURI().trimSegments(2)
                .appendSegment(getTheMPDName(resourceSet.getResource(theSelectedResource.getURI(), true)))
                .appendFileExtension(UMLResource.FILE_EXTENSION);
    }

    @Override
    protected final ModelExtent[] arguments() {
        final List<EObject> theCatalogContents = resourceSet.getResource(theSelectedResource.getURI(), true).getContents();
        thePIM = resourceSet.createResource(getThePimUri());
        final Model theRoot = UMLFactory.eINSTANCE.createModel();
        theRoot.setName("Data");
        final List<EObject> thePIMContents = thePIM.getContents();
        thePIMContents.add(theRoot);
        thePIMExtent = new BasicModelExtent(thePIMContents);
        return new ModelExtent[] { new BasicModelExtent(theCatalogContents), thePIMExtent };
    }

    private void execute(final Command c) {
        final TransactionalEditingDomain theEditingDomain = theModelSet.getTransactionalEditingDomain();
        theEditingDomain.getCommandStack().execute(c);
    }

    @Override
    protected void postExecute() {
        try {
            theServicesRegistry = createServicesRegistry();
            theModelSet = theServicesRegistry.getService(ModelSet.class);

            execute(new NewPapyrusModelCommand(theModelSet, thePIM.getURI().trimFileExtension().appendFileExtension("di")));

            initServicesRegistry(theServicesRegistry);

            final List<EObject> thePimContents = thePIM.getContents();
            thePimContents.addAll(stereotypes(thePIMExtent.getContents()));

            final TransactionalEditingDomain theEditingDomain = theModelSet.getTransactionalEditingDomain();
            final Resource theUMLResource = getUmlResource(theModelSet);
            final Resource theDiagramResource = getDiResource(theModelSet);
            final Resource theNotationResource = getNotationResource(theModelSet);
            Display.getDefault().syncExec(new Runnable() {
                @Override
                public void run() {
                    execute(new RecordingCommand(theEditingDomain) {
                        @Override
                        protected void doExecute() {
                            final EList<EObject> theUMLContents = theUMLResource.getContents();
                            theUMLContents.addAll(copyAll(thePimContents));

                            final Collection<Model> theRootModels = EcoreUtil.<Model> getObjectsByType(theUMLContents,
                                    UMLPackage.Literals.MODEL);
                            if (theRootModels.isEmpty()) {
                                return;
                            }
                            final DiagramSynchronizer theDiagramSynchronizer = new DiagramSynchronizer(theNotationResource,
                                    getThePageManager(theServicesRegistry));
                            theDiagramSynchronizer.merge(theRootModels);

                            final Model theRootModel = theRootModels.iterator().next();
                            final EObject theRootDiagramModel = theRootModel.getPackagedElements().isEmpty() ? theRootModel
                                    : theRootModel.getPackagedElements().get(0);
                            ((SashWindowsMngr) theDiagramResource.getContents().get(0))
                                    .getSashModel()
                                    .getCurrentSelection()
                                    .addPage(
                                            0,
                                            getAssociatedDiagramsFromNotationResource(theRootDiagramModel,
                                                    theNotationResource).get(0));
                        }
                    });
                }
            });

            TransactionalDiSashModelMngr.createIPageMngr(theDiagramResource, theEditingDomain);

        } catch (final ServiceException e) {
            throw new IllegalStateException("Unable to create the diagram.", e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            if (theServicesRegistry != null) {
                disposeServicesRegistry(theServicesRegistry);
            }
        } finally {
            super.close();
        }
    }

    @Override
    protected final void persist() throws IOException {
        theModelSet.save(new NullProgressMonitor());
    }

    private static Collection<EObject> stereotypes(final Collection<EObject> toFilter) {
        final Collection<EObject> filtered = new ArrayList<>();
        for (final EObject e : toFilter) {
            if (isStereotypeApplication(e) && getBaseElement(e) != null) {
                filtered.add(e);
            }
        }
        return filtered;
    }
}