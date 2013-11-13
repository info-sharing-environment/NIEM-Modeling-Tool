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
package org.search.niem.uml.papyrus.editors;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

final class SimpleInlineTextInputDialog extends InlineTextInputDialog {
    private Text text;

    public SimpleInlineTextInputDialog(final IGraphicalEditPart graphicalEditPart, final String value) {
        super(graphicalEditPart, value);
    }

    @Override
    protected Control createTextControl(final Composite parent) {
        text = new Text(parent, SWT.SINGLE | SWT.BORDER);
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                switch (e.keyCode) {
                case SWT.CR:
                    okPressed();
                    break;
                }
            }
        });
        text.setFocus();
        if (getValue() != null) {
            text.setText(getValue());
            text.selectAll();
        }
        return text;
    }

    @Override
    protected String getTextValue() {
        return text.getText();
    }
}