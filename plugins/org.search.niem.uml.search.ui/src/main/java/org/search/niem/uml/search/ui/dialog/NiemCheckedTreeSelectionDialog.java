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
package org.search.niem.uml.search.ui.dialog;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.search.niem.uml.search.ui.Activator;

public abstract class NiemCheckedTreeSelectionDialog extends SelectionStatusDialog {

    private static final int VIEWER_WIDTH_IN_CHARS = 60;
    private static final int VIEWER_HEIGHT_IN_CHARS = 18;

    private NiemContainerCheckedTreeViewer theViewer;
    private IStatus theCurrentStatus = Status.OK_STATUS;

    private final ITreeContentProvider theContentProvider;
    private final AtomicReference<Boolean> isEmpty = new AtomicReference<>();
    private final Object theInput;
    private final Object[] theExpandedElements;

    public NiemCheckedTreeSelectionDialog(final Shell parent, final ITreeContentProvider theContentProvider,
            final Object theInput, final Object[] theExpandedElements) {
        super(parent);
        this.theContentProvider = theContentProvider;
        this.theInput = theInput;
        this.theExpandedElements = theExpandedElements;
        setResult(emptyList());
        setStatusLineAboveButtons(true);
    }

    private void updateOKStatus() {
        if (isEmpty()) {
            theCurrentStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK,
                    Activator.INSTANCE.getString("_UI_NIEM_CheckedTreeSelectionDialog_nothing_available"), null);
        } else if (!theCurrentStatus.isOK()) {
            theCurrentStatus = Status.OK_STATUS;
        }
        updateStatus(theCurrentStatus);
    }

    @Override
    public int open() {
        super.open();
        return getReturnCode();
    }

    @Override
    protected void cancelPressed() {
        setResult(null);
        super.cancelPressed();
    }

    @Override
    protected void computeResult() {
        setResult(asList(getCheckedElements(getTreeViewer().getControl())));
    }

    private Object[] getCheckedElements(final Control tree) {
        final Collection<Object> v = new LinkedHashSet<>();
        final TreeItem[] treeItems = getExpandedTreeItems(tree);
        for (final TreeItem treeItem : treeItems) {
            if (treeItem.getChecked()) {
                final Object data = treeItem.getData();
                if (data != null) {
                    v.add(data);
                }
            }
        }
        return v.toArray();
    }

    private TreeItem[] getExpandedTreeItems(final Control tree) {
        final Collection<TreeItem> v = new LinkedHashSet<>();
        collectExpandedTreeItems(v, tree);
        return v.toArray(new TreeItem[v.size()]);
    }

    private void collectExpandedTreeItems(final Collection<TreeItem> acc, final Widget widget) {
        final TreeItem[] items = getChildren(widget);
        acc.addAll(asList(items));
        for (final TreeItem treeItem : items) {
            collectExpandedTreeItems(acc, treeItem);
        }
    }

    private TreeItem[] getChildren(final Widget o) {
        if (o instanceof TreeItem) {
            return ((TreeItem) o).getItems();
        }
        if (o instanceof Tree) {
            return ((Tree) o).getItems();
        }
        return null;
    }

    private void access$superCreate() {
        super.create();
    }

    @Override
    public void create() {
        BusyIndicator.showWhile(null, new Runnable() {
            @Override
            public void run() {
                access$superCreate();
                theViewer.setCheckedElements(getInitialElementSelections().toArray());
                if (theExpandedElements != null) {
                    theViewer.setExpandedElements(theExpandedElements);
                }
                updateOKStatus();
            }
        });
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final Composite composite = (Composite) super.createDialogArea(parent);
        final Label messageLabel = createMessageArea(composite);
        final CheckboxTreeViewer treeViewer = createTreeViewer(composite);
        final Control buttonComposite = createSelectionButtons(composite);
        final Tree treeWidget = treeViewer.getTree();
        GridDataFactory
                .fillDefaults()
                .hint(convertWidthInCharsToPixels(VIEWER_WIDTH_IN_CHARS),
                        convertHeightInCharsToPixels(VIEWER_HEIGHT_IN_CHARS)).applyTo(treeWidget);
        treeWidget.setFont(parent.getFont());
        if (isEmpty()) {
            messageLabel.setEnabled(false);
            treeWidget.setEnabled(false);
            buttonComposite.setEnabled(false);
        }
        return composite;
    }

    protected abstract ILabelProvider createLabelProvider();

    protected NiemContainerCheckedTreeViewer createTreeViewer(final Composite parent) {
        theViewer = new NiemContainerCheckedTreeViewer(parent, SWT.BORDER);
        theViewer.setContentProvider(theContentProvider);
        theViewer.setLabelProvider(createLabelProvider());
        theViewer.addCheckStateListener(new ICheckStateListener() {
            @Override
            public void checkStateChanged(final CheckStateChangedEvent event) {
                updateOKStatus();
            }
        });
        theViewer.setInput(theInput);
        return theViewer;
    }

    protected NiemContainerCheckedTreeViewer getTreeViewer() {
        return theViewer;
    }

    private Composite createSelectionButtons(final Composite composite) {
        final Composite buttonComposite = new Composite(composite, SWT.RIGHT);
        final GridLayout layout = new GridLayout();
        layout.numColumns = 0;
        layout.marginWidth = 0;
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        buttonComposite.setLayout(layout);
        buttonComposite.setFont(composite.getFont());
        final GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END | GridData.GRAB_HORIZONTAL);
        data.grabExcessHorizontalSpace = true;
        buttonComposite.setLayoutData(data);
        final Button selectButton = createButton(buttonComposite, IDialogConstants.SELECT_ALL_ID,
                Activator.INSTANCE.getString("_UI_NIEM_CheckedTreeSelectionDialog_select_all"), false);
        SelectionListener listener = new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                final TreeItem[] visibleExpandedElements = getExpandedTreeItems(theViewer.getTree());
                for (final TreeItem treeItem : visibleExpandedElements) {
                    treeItem.setChecked(true);
                    treeItem.setGrayed(true);
                }
                updateOKStatus();
            }
        };
        selectButton.addSelectionListener(listener);
        final Button deselectButton = createButton(buttonComposite, IDialogConstants.DESELECT_ALL_ID,
                Activator.INSTANCE.getString("_UI_NIEM_CheckedTreeSelectionDialog_deselect_all"), false);
        listener = new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                theViewer.setCheckedElements(new Object[0]);
                updateOKStatus();
            }
        };
        deselectButton.addSelectionListener(listener);
        return buttonComposite;
    }

    private boolean isEmpty() {
        final Boolean existingFlag = isEmpty.get();
        if (existingFlag != null) {
            return existingFlag;
        }
        final Boolean newFlag = theContentProvider.getElements(theInput).length == 0;
        if (isEmpty.compareAndSet(null, newFlag)) {
            return newFlag;
        }
        return isEmpty.get();
    }
}
