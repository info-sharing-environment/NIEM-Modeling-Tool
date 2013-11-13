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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.widgets.Shell;
import org.search.niem.uml.qvt.ui.Activator;

class ComposedTransformer implements Transformer {

    private final String name;
    private final Transformer[] delegates;

    ComposedTransformer(final String name, final Transformer... delegates) {
        this.name = name;
        this.delegates = delegates;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void runTransform(final Shell theShell, final IProgressMonitor monitor) throws InvocationTargetException {
        for (final Transformer delegate : delegates) {
            monitor.subTask(Activator.INSTANCE.getString("_UI_Transform_progress", new Object[] { delegate.name() }));
            delegate.runTransform(theShell, monitor);
            monitor.worked(1);
        }
    }

    @Override
    public void close() throws Exception {
        final Exception e = new Exception("Errors closing transformer delegates.");
        for (final Transformer delegate : delegates) {
            SafeRunnable.run(new ISafeRunnable() {
                @Override
                public void run() throws Exception {
                    delegate.close();
                }

                @Override
                public void handleException(final Throwable t) {
                    e.addSuppressed(t);
                }
            });
        }
        if (e.getSuppressed().length > 0) {
            throw e;
        }
    }
}
