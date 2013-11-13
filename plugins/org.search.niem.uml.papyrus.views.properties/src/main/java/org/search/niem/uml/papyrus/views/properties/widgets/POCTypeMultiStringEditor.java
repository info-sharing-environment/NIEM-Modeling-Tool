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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.MultipleStringEditor;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class POCTypeMultiStringEditor extends AbstractPropertyEditor {

    private final MultipleStringEditor editor;

    public POCTypeMultiStringEditor(final Composite parent, final int style) {
        editor = new EmbeddedMultipleStringEditor(parent, style);
        super.setEditor(editor);
    }

    @Override
    protected void doBinding() {
        editor.setOrdered(input.isOrdered(propertyPath));
        editor.setUnique(input.isUnique(propertyPath));
        editor.setDirectCreation(input.getDirectCreation(propertyPath));
        final ReferenceValueFactory factory = input.getValueFactory(propertyPath);
        if (factory != null) {
            editor.setFactory(input.getValueFactory(propertyPath));
        }

        if (getInputObservableList() instanceof ICommitListener) {
            editor.addCommitListener((ICommitListener) getInputObservableList());
        }

        super.doBinding();
    }

    private static final class EmbeddedMultipleStringEditor extends MultipleStringEditor {

        private IObservableList observed;
        private WritableList scratchpad;

        public EmbeddedMultipleStringEditor(final Composite parent, final int style) {
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
                    if (scratchpad != null) {
                        observed.clear();
                        observed.addAll(scratchpad);
                    }
                }

                @Override
                public void widgetDefaultSelected(final SelectionEvent e) {
                }
            });
            for (final Listener l : selectionListeners) {
                theOkButton.addListener(SWT.Selection, l);
            }
        }

        @Override
        public void setModelObservable(final IObservableList modelProperty) {
            scratchpad = new WritableList();
            scratchpad.addAll(modelProperty);
            super.setModelObservable(scratchpad);
            observed = modelProperty;
        }

        @Override
        protected void setCommitOnFocusLost(final Control control) {
            // no-op
        }
    }
}
