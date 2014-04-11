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
import static java.util.Collections.newSetFromMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
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
    private final Object filterJobFamily = new Object();

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
                final Object[] initialSelections = getInitialElementSelections().toArray();
                if (initialSelections.length > 0) {
                    theViewer.setCheckedElements(initialSelections);
                }
                autoExpand();
                updateOKStatus();
            }
        });
    }

    private void autoExpand() {
        if (theExpandedElements != null) {
            theViewer.setExpandedElements(theExpandedElements);
        }
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final Composite composite = (Composite) super.createDialogArea(parent);
        final Label messageLabel = createMessageArea(composite);

        final Text pattern = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
        GridDataFactory.fillDefaults().applyTo(pattern);

        final CheckboxTreeViewer treeViewer = createTreeViewer(composite);

        pattern.addModifyListener(new PatternModifyListener(pattern));

        pattern.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.keyCode == SWT.ARROW_DOWN) {
                    final Tree theTree = treeViewer.getTree();
                    if (theTree.getItemCount() > 0) {
                        theTree.setFocus();
                    }
                }
            }
        });

        pattern.setFocus();

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

    private void cancelFilterJobs() {
        Job.getJobManager().cancel(filterJobFamily);
    }

    @Override
    public boolean close() {
        final boolean close;
        try {
            cancelFilterJobs();
        } finally {
            close = super.close();
        }
        return close;
    }

    private final class PatternModifyListener implements ModifyListener {

        private static final int MIN_SEARCH_PATTERN_LENGTH = 2;

        private final Text pattern;

        private PatternModifyListener(final Text pattern) {
            this.pattern = pattern;
        }

        @Override
        public void modifyText(final ModifyEvent e) {
            final Job[] currentFilterJobs = Job.getJobManager().find(filterJobFamily);
            cancelFilterJobs();
            final NiemContainerCheckedTreeViewer theTreeViewer = getTreeViewer();
            final String searchPattern = pattern.getText().toUpperCase();
            if (searchPattern.length() <= MIN_SEARCH_PATTERN_LENGTH) {
                final ViewerFilter[] existingFilters = theTreeViewer.getFilters();
                if (existingFilters == null || existingFilters.length == 0) {
                    return;
                }
                theTreeViewer.setFilters(new ViewerFilter[] { NeverFilter.INSTANCE });
                return;
            }
            final Filter filter = new Filter();
            theTreeViewer.setFilters(new ViewerFilter[] { filter });

            final BlockingQueue<TreePath> matches = new LinkedBlockingQueue<>();

            final Job producer = new FindMatchingElements(currentFilterJobs, searchPattern, matches);
            final Job consumer = new UpdateMatchingElements(filter, producer, theTreeViewer, matches);

            producer.setPriority(Job.LONG);
            producer.schedule(250);

            consumer.setPriority(Job.LONG);
            consumer.schedule(250);
        }
    }

    private static final class NeverFilter extends ViewerFilter {

        static final ViewerFilter INSTANCE = new NeverFilter();

        NeverFilter() {
        }

        @Override
        public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
            return true;
        }
    }

    private static final class Filter extends ViewerFilter {
        final Collection<Object> visibleElements = newSetFromMap(new ConcurrentHashMap<Object, Boolean>());

        @Override
        public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
            return visibleElements.contains(element);
        }
    }

    private abstract class FilterJob extends Job {
        public FilterJob(final String name) {
            super(name);
        }

        @Override
        public final boolean belongsTo(final Object family) {
            return family == filterJobFamily;
        }

        protected void checkCanceled(final IProgressMonitor monitor) {
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
        }
    }

    private final class FindMatchingElements extends FilterJob {

        private static final int MAX_BREADTH_FIRST_TRAVERSAL_DEPTH = 3;
        private static final int MAX_TRAVERSAL_DEPTH = 8;

        private final Job[] currentFilterJobs;
        private final String searchPattern;
        private final Collection<TreePath> matches;

        private FindMatchingElements(final Job[] currentFilterJobs, final String searchPattern,
                final Collection<TreePath> matches) {
            super("Finding matching elements");
            this.currentFilterJobs = currentFilterJobs;
            this.searchPattern = searchPattern;
            this.matches = matches;
        }

        private boolean itIsAMatch(final Object o) {
            return UMLPackage.Literals.NAMED_ELEMENT.isInstance(o)
                    && ((NamedElement) o).getName().toUpperCase().contains(searchPattern);
        }

        private void traverseBreadthFirst(final TreePath root, final IProgressMonitor monitor) {
            final Queue<TreePath> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                final TreePath treePath = q.remove();
                if (treePath.getSegmentCount() > MAX_BREADTH_FIRST_TRAVERSAL_DEPTH) {
                    traverseDepthFirst(treePath, monitor);
                    while (!q.isEmpty()) {
                        traverseDepthFirst(q.remove(), monitor);
                    }
                } else {
                    final Object o = treePath.getLastSegment();
                    if (itIsAMatch(o)) {
                        reveal(treePath);
                    }
                    final Object[] children = getChildren(o);
                    checkCanceled(monitor);
                    for (final Object child : children) {
                        q.add(treePath.createChildPath(child));
                    }
                }
            }
        }

        private void traverseDepthFirst(final TreePath treePath, final IProgressMonitor monitor) {
            checkCanceled(monitor);
            final Object o = treePath.getLastSegment();
            if (itIsAMatch(o)) {
                reveal(treePath);
            }
            if (treePath.getSegmentCount() <= MAX_TRAVERSAL_DEPTH) {
                final Object[] children = getChildren(o);
                checkCanceled(monitor);
                for (final Object child : children) {
                    traverseDepthFirst(treePath.createChildPath(child), monitor);
                }
            }
        }

        private void reveal(final TreePath treePath) {
            matches.add(treePath);
        }

        private Object[] getChildren(final Object o) {
            return theContentProvider.getElements(o);
        }

        @Override
        protected final IStatus run(final IProgressMonitor monitor) {
            waitFor(currentFilterJobs);
            traverseBreadthFirst(new TreePath(getChildren(theInput)), monitor);
            return Status.OK_STATUS;
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
    }

    private final class UpdateMatchingElements extends FilterJob {

        private static final int BATCH_SIZE = 10;
        private static final int MAX_TIME_BETWEEN_FLUSHES = 2000;

        private final Filter filter;
        private final Job producer;
        private final StructuredViewer theViewer;
        private final BlockingQueue<TreePath> matches;

        private UpdateMatchingElements(final Filter filter, final Job producer, final StructuredViewer theViewer,
                final BlockingQueue<TreePath> matches) {
            super("Update matching elements");
            this.filter = filter;
            this.producer = producer;
            this.theViewer = theViewer;
            this.matches = matches;
        }

        @Override
        protected IStatus run(final IProgressMonitor monitor) {
            final Collection<TreePath> batch = new ArrayList<>(BATCH_SIZE);
            long lastFlushTime = System.currentTimeMillis();
            boolean theProducerIsFinished = false;
            while (!monitor.isCanceled() && !theProducerIsFinished) {
                theProducerIsFinished = producer.getResult() != null;
                final int countToDrain = theProducerIsFinished ? Integer.MAX_VALUE : BATCH_SIZE - batch.size();
                matches.drainTo(batch, countToDrain);
                if (batch.size() >= BATCH_SIZE || batch.size() > 0
                        && System.currentTimeMillis() > lastFlushTime + MAX_TIME_BETWEEN_FLUSHES) {
                    flush(batch, monitor);
                    lastFlushTime = System.currentTimeMillis();
                }
            }
            return Status.OK_STATUS;
        }

        private void flush(final Collection<TreePath> batch, final IProgressMonitor monitor) {
            for (final TreePath t : batch) {
                for (int i = 0; i < t.getSegmentCount(); i++) {
                    filter.visibleElements.add(t.getSegment(i));
                }
            }
            final Object[] toFlush = batch.toArray();
            batch.clear();
            checkCanceled(monitor);
            getShell().getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                    if (monitor.isCanceled() || theViewer.getControl().isDisposed()) {
                        return;
                    }
                    final Exception revelations = new Exception();
                    for (final Object o : toFlush) {
                        try {
                            theViewer.reveal(o);
                        } catch (final Exception e) {
                            revelations.addSuppressed(e);
                        }
                        if (monitor.isCanceled()) {
                            break;
                        }
                    }
                    if (revelations.getSuppressed().length > 0) {
                        Activator.INSTANCE.log(revelations);
                    }
                }
            });
        }
    }
}
