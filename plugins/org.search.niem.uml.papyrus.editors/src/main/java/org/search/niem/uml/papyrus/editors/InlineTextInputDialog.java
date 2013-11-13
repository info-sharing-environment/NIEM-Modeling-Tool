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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

abstract class InlineTextInputDialog extends Dialog implements ILabelEditorDialog {
    private String value;
    private final Rectangle labelBounds;

    public InlineTextInputDialog(final IGraphicalEditPart graphicalEditPart, final String value) {
        super(graphicalEditPart.getViewer().getControl().getShell());
        final IFigure theFigure = graphicalEditPart.getFigure();

        final org.eclipse.draw2d.geometry.Rectangle r = theFigure.getBounds().getCopy();
        theFigure.translateToAbsolute(r);

        final Control theCanvas = graphicalEditPart.getViewer().getControl();
        labelBounds = theCanvas.getDisplay().map(theCanvas, null, new Rectangle(r.x, r.y, r.width, r.height));

        this.value = value;
        setShellStyle(SWT.NO_TRIM | SWT.APPLICATION_MODAL);
    }

    private Layout noLayout() {
        final GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.verticalSpacing = 0;
        layout.horizontalSpacing = 0;
        return layout;
    }

    @Override
    protected final Control createContents(final Composite parent) {
        parent.setLayout(noLayout());
        final Composite composite = (Composite) super.createContents(parent);
        composite.setLayout(noLayout());
        return composite;
    }

    protected abstract Control createTextControl(Composite parent);

    protected abstract String getTextValue();

    @Override
    protected final Control createDialogArea(final Composite parent) {
        final Composite composite = (Composite) super.createDialogArea(parent);
        composite.setLayout(noLayout());

        final Control textControl = createTextControl(parent);

        final GridData layoutData = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
        layoutData.widthHint = labelBounds.width;
        layoutData.heightHint = labelBounds.height;
        textControl.setLayoutData(layoutData);

        applyDialogFont(composite);

        return composite;
    }

    @Override
    protected final Point getInitialLocation(final Point initialSize) {
        return new Point(labelBounds.x, labelBounds.y);
    }

    @Override
    protected final Control createButtonBar(final Composite parent) {
        return null;
    }

    @Override
    protected final void okPressed() {
        value = getTextValue();
        super.okPressed();
    }

    @Override
    public final String getValue() {
        return value;
    }
}