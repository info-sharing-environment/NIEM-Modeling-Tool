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
package org.search.niem.uml.papyrus.views.properties.widgets;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class POCTypeStringEditor extends AbstractPropertyEditor {

    private final EmbeddedStringEditor theEditor;

    public POCTypeStringEditor(final Composite parent, final int style) {
        setEditor(theEditor = new EmbeddedStringEditor(parent, style));
    }

    @Override
    protected void doBinding() {
        final IStaticContentProvider provider = input.getContentProvider(propertyPath);
        if (provider != null) {
            final Object[] elements = provider.getElements();
            theEditor.setValue(elements == null || elements.length == 0 ? "" : elements[0]);
        }
        super.doBinding();
    }

    private static final class EmbeddedStringEditor extends StringEditor {

        private Object newValue;
        private IObservableValue observed;

        public EmbeddedStringEditor(final Composite parent, final int style) {
            super(parent, style);
            final Shell theShell = parent.getShell();
            final Button theOkButton = theShell.getDefaultButton();
            final Listener[] selectionListeners = theOkButton.getListeners(SWT.Selection);
            for (final Listener l : selectionListeners) {
                theOkButton.removeListener(SWT.Selection, l);
            }
            theOkButton.addSelectionListener(new SelectionListener() {
                @Override
                public void widgetSelected(final SelectionEvent e) {
                    if (newValue != null) {
                        observed.setValue(newValue);
                    }
                }

                @Override
                public void widgetDefaultSelected(final SelectionEvent e) {
                }
            });
            for (final Listener l : selectionListeners) {
                theOkButton.addListener(SWT.Selection, l);
            }
            text.addModifyListener(new ModifyListener() {
                @Override
                public void modifyText(final ModifyEvent e) {
                    newValue = text.getText();
                }
            });

        }

        @Override
        public void setModelObservable(final IObservableValue observable) {
            observed = observable;
        }

        @Override
        protected void setCommitOnFocusLost(final Control control) {
            // no-op
        }
    }
}
