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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.EvaluationMonitor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.search.niem.uml.qvt.ui.Activator;

abstract class TransformDelegate implements Transformer {

    private final URI transformationURI;
    protected final URI selection;
    protected Resource theSelectedResource;
    protected ResourceSet resourceSet;
    private final String name;

    protected TransformDelegate(final URI selection, final URI transformationURI, final String name) {
        this.selection = selection;
        this.transformationURI = transformationURI;
        this.name = name;
    }

    protected abstract ModelExtent[] arguments();

    protected abstract void persist() throws IOException;

    protected IStatus validate() {
        return Status.OK_STATUS;
    }

    protected String getValidationMessage(final IStatus status) {
        return Activator.INSTANCE.getString("_UI_NIEM_TransformDelegate_validation_dialog_message");
    }

    private boolean shouldContinue(final Shell shell, final IStatus status) {
        final ErrorDialog dialog = new ErrorDialog(shell,
                Activator.INSTANCE.getString("_UI_NIEM_TransformDelegate_validation_dialog_title"),
                getValidationMessage(status), status, IStatus.ERROR | IStatus.WARNING | IStatus.INFO) {

            @Override
            protected Control createContents(final Composite parent) {
                final Control contents = super.createContents(parent);
                shell.getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        buttonPressed(IDialogConstants.DETAILS_ID);
                    }
                });
                return contents;
            }

            @Override
            protected void createButtonsForButtonBar(final Composite parent) {
                createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, false);
                createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, true);
                createDetailsButton(parent);
            }

            @Override
            protected void buttonPressed(final int id) {
                if (id == IDialogConstants.YES_ID) {
                    super.buttonPressed(IDialogConstants.OK_ID);
                } else if (id == IDialogConstants.NO_ID) {
                    super.buttonPressed(IDialogConstants.CANCEL_ID);
                }
                super.buttonPressed(id);
            }

            @Override
            protected int getShellStyle() {
                return super.getShellStyle() | SWT.SHEET;
            }
        };
        final AtomicBoolean result = new AtomicBoolean();
        shell.getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
                result.set(dialog.open() == IDialogConstants.OK_ID);
            }
        });
        return result.get();
    }

    protected ResourceSet createResourceSet() {
        return UMLResourcesUtil.init(new ResourceSetImpl());
    }

    @Override
    public String name() {
        return name;
    }

    protected Map<String, Object> getConfigProperties() {
        return new LinkedHashMap<String, Object>();
    }

    @Override
    public final void runTransform(final Shell shell, final IProgressMonitor monitor) throws InvocationTargetException {
        final TransformationExecutor executor = new TransformationExecutor(transformationURI);

        final ExecutionContextImpl context = new ExecutionContextImpl();
        context.setLog(new ContextLog());
        context.setMonitor(new EvaluationMonitor() {

            @Override
            public boolean isCanceled() {
                return monitor.isCanceled();
            }

            @Override
            public void cancel() {
                monitor.setCanceled(true);
            }
        });

        for (final Entry<String, Object> configProperties : getConfigProperties().entrySet()) {
            context.setConfigProperty(configProperties.getKey(), configProperties.getValue());
        }

        resourceSet = createResourceSet();
        theSelectedResource = resourceSet.getResource(selection, true);

        final IStatus status = validate();
        if (!status.isOK() && !shouldContinue(shell, status)) {
            return;
        }

        final ModelExtent[] arguments = arguments();

        final Diagnostic diagnostic = executor.execute(context, arguments);

        if (diagnostic.getSeverity() == Diagnostic.ERROR) {
            throw diagnostic.getException() == null ? new InvocationTargetException(new RuntimeException(
                    diagnostic.getMessage()), diagnostic.getMessage()) : new InvocationTargetException(
                    diagnostic.getException(), diagnostic.getMessage());
        }
        postExecute();
        try {
            persist();
        } catch (final IOException e) {
            throw new InvocationTargetException(e, "Unable to persist the model.");
        }
    }

    @Override
    public void close() throws Exception {
        // no-op by default
    }

    protected void postExecute() {
        // no-op by default
    }

    private static final class ContextLog implements Log {
        @Override
        public void log(final int level, final String message) {
            Activator.INSTANCE.log(new Status(level, Activator.PLUGIN_ID, message));
        }

        @Override
        public void log(final int level, final String message, final Object param) {
            log(level, message);
        }

        @Override
        public void log(final String message) {
            log(IStatus.INFO, message);
        }

        @Override
        public void log(final String message, final Object param) {
            log(message);
        }
    }
}