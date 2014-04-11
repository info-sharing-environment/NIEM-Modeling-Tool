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
package org.search.niem.uml.evl.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.action.ValidateAction.EclipseResourcesUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.uml.Element;
import org.search.niem.uml.evl.Activator;

public class ModelValidator {

    private static final class NiemDiagnostician extends Diagnostician {
        private final AdapterFactory adapterFactory;
        private final IProgressMonitor monitor;

        private NiemDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor monitor) {
            this.adapterFactory = adapterFactory;
            this.monitor = monitor;
        }

        @Override
        public String getObjectLabel(final EObject eObject) {
            if (adapterFactory != null && !eObject.eIsProxy()) {
                final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject,
                        IItemLabelProvider.class);

                if (itemLabelProvider != null) {
                    return itemLabelProvider.getText(eObject);
                }
            }
            return super.getObjectLabel(eObject);
        }

        protected boolean doValidateStereotypeApplications(final EObject eObject, final DiagnosticChain diagnostics,
                final Map<Object, Object> context) {
            final List<EObject> stereotypeApplications = eObject instanceof Element ? ((Element) eObject)
                    .getStereotypeApplications() : Collections.<EObject> emptyList();

            if (!stereotypeApplications.isEmpty()) {
                final Iterator<EObject> i = stereotypeApplications.iterator();
                boolean result = validate(i.next(), diagnostics, context);

                while (i.hasNext() && (result || diagnostics != null)) {
                    result &= validate(i.next(), diagnostics, context);
                }

                return result;
            } else {
                return true;
            }
        }

        @Override
        protected boolean doValidateContents(final EObject eObject, final DiagnosticChain diagnostics,
                final Map<Object, Object> context) {
            checkCanceled(monitor);
            boolean result = doValidateStereotypeApplications(eObject, diagnostics, context);

            if (result || diagnostics != null) {
                result &= super.doValidateContents(eObject, diagnostics, context);
            }

            return result;
        }

        @Override
        public boolean validate(final EClass eClass, final EObject eObject, final DiagnosticChain diagnostics,
                final Map<Object, Object> context) {
            checkCanceled(monitor);
            return super.validate(eClass, eObject, diagnostics, context);
        }
    }

    private final Resource resource;

    public ModelValidator(final Resource resource) {
        this.resource = resource;
    }

    private Diagnostic validate(final EObject eObject, final IProgressMonitor monitor) {
        final AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
                .getEditingDomainFor(eObject);
        if (domain == null) { // the resource editor is closed
            return new BasicDiagnostic();
        }
        final AdapterFactory adapterFactory = domain.getAdapterFactory();

        final Diagnostician diagnostician = new NiemDiagnostician(adapterFactory, monitor);

        return diagnostician.validate(eObject);
    }

    private static void checkCanceled(final IProgressMonitor monitor) {
        if (monitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    public void run() {
        final List<EObject> theResourceContents = resource.getContents();
        if (theResourceContents.isEmpty()) {
            return;
        }
        final String validationJobFamily = Activator.INSTANCE.getString("_UI_ModelValidator_job_name",
                new Object[] { resource.getURI() });
        final Job[] jobs = Job.getJobManager().find(validationJobFamily);
        Job.getJobManager().cancel(validationJobFamily);
        final EObject theRootModel = theResourceContents.get(0);
        final Job validationJob = new Job(validationJobFamily) {
            @Override
            protected IStatus run(final IProgressMonitor monitor) {
                waitFor(jobs);
                final Diagnostic diagnostic;
                try {
                    diagnostic = validate(theRootModel, monitor);
                } catch (final OperationCanceledException e) {
                    return Status.CANCEL_STATUS; // this is expected
                } catch (final Exception e) {
                    Activator.INSTANCE.log(e);
                    return Status.CANCEL_STATUS; // treat any other error that happens in here as cancellation
                }
                checkCanceled(monitor);
                final Job job = new UIJob(Activator.INSTANCE.getString("_UI_ModelValidator_marker_job_name",
                        new Object[] { resource.getURI() })) {
                    @Override
                    public IStatus runInUIThread(final IProgressMonitor monitor) {
                        handleDiagnostic(diagnostic);
                        return Status.OK_STATUS;
                    }

                    @Override
                    public boolean belongsTo(final Object family) {
                        return validationJobFamily.equals(family);
                    }
                };
                job.setPriority(Job.DECORATE);
                job.schedule();
                return Status.OK_STATUS;
            }

            @Override
            public boolean belongsTo(final Object family) {
                return validationJobFamily.equals(family);
            }

            private void waitFor(final Job[] jobs) {
                for (final Job j : jobs) {
                    try {
                        j.join();
                    } catch (final InterruptedException e) {
                        throw new OperationCanceledException();
                    }
                }
            }
        };
        validationJob.setPriority(Job.BUILD);
        validationJob.schedule();
    }

    private void handleDiagnostic(final Diagnostic diagnostic) {
        final EclipseResourcesUtil markerHelper = new EclipseResourcesUtil();
        final IRunnableWithProgress operation = markerHelper.getWorkspaceModifyOperation(new IRunnableWithProgress() {

            @Override
            public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                if (resource.getResourceSet() == null) { // the resource editor is closed
                    return;
                }
                markerHelper.deleteMarkers(resource);

                for (final Diagnostic childDiagnostic : diagnostic.getChildren()) {
                    markerHelper.createMarkers(resource, childDiagnostic);
                }
            }
        });
        Display.getDefault().asyncExec(new Runnable() {

            @Override
            public void run() {
                try {
                    operation.run(new NullProgressMonitor());
                } catch (final InvocationTargetException e) {
                    Activator.INSTANCE.log(e);
                } catch (final InterruptedException e) {
                    // no-op
                }
            }
        });
    }
}
