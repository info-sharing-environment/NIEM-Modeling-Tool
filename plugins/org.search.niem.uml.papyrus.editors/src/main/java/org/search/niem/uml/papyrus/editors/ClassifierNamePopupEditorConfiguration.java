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

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.emf.ecore.util.EcoreUtil.getObjectsByType;
import static org.eclipse.jface.dialogs.MessageDialog.openConfirm;
import static org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils.getNotationResource;
import static org.search.niem.uml.papyrus.util.PapyrusExt.delete;
import static org.search.niem.uml.util.NIEMUmlExt.getReferenceNiemName;
import static org.search.niem.uml.util.NIEMUmlExt.hasNiemName;
import static org.search.niem.uml.util.NIEMUmlExt.isInReferenceLibrarySubset;
import static org.search.niem.uml.util.UMLExt.collectOwnedElementsAndRelationships;
import static org.search.niem.uml.util.UMLExt.getName;
import static org.search.niem.uml.util.UMLExt.setName;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.util.UMLExt;

public abstract class ClassifierNamePopupEditorConfiguration extends DefaultDirectEditorConfiguration implements
IPopupEditorConfiguration {

    private final EClass type;

    protected ClassifierNamePopupEditorConfiguration(final EClass type) {
        this.type = type;
    }

    private ClassifierNamePopupHelper createPopupEditorHelper(final IGraphicalEditPart editPart) {
        return new ClassifierNamePopupHelper(editPart, type);
    }

    @Override
    public final IPopupEditorHelper createPopupEditorHelper(final Object editPart) {
        return createPopupEditorHelper((IGraphicalEditPart) editPart);
    }

    private static final class ClassifierNamePopupHelper implements IPopupEditorHelper {
        private final IGraphicalEditPart graphicalEditPart;
        private final EClass type;

        protected ClassifierNamePopupHelper(final IGraphicalEditPart graphicalEditPart, final EClass type) {
            this.graphicalEditPart = graphicalEditPart;
            this.type = type;
        }

        private ReferenceLibraryClassifierNameDialog createReferenceLibraryClassifierNameDialog(
                final IGraphicalEditPart graphicalEditPart) {
            return new ReferenceLibraryClassifierNameDialog(graphicalEditPart, type);
        }

        private void handleRename(final String theNewName, final EObject theSemanticElement,
                final TransactionalEditingDomain theDomain, final CommandStack theCommandStack) {
            final SetName setName = theCommandStack instanceof IWorkspaceCommandStack
                    && theLastOperationCreatedTheElement(theSemanticElement, (IWorkspaceCommandStack) theCommandStack) ? new SetNameTheFirstTime(
                            theDomain, theNewName, theSemanticElement, (IWorkspaceCommandStack) theCommandStack) : new Rename(
                                    theDomain, theNewName, theSemanticElement, graphicalEditPart.getViewer().getControl().getShell());
                            if (setName.confirm()) {
                                theCommandStack.execute(setName);
                                setName.after();
                            }
        }

        private void handleCancelation(final EObject theSemanticElement, final TransactionalEditingDomain theDomain,
                final CommandStack theCommandStack) {
            final IWorkspaceCommandStack theWorkspaceCommandStack = (IWorkspaceCommandStack) theCommandStack;
            if (theLastOperationCreatedTheElement(theSemanticElement, theWorkspaceCommandStack)) {
                theCommandStack.undo();
                final IOperationHistory theOperationHistory = theWorkspaceCommandStack.getOperationHistory();
                theOperationHistory.dispose(theWorkspaceCommandStack.getDefaultUndoContext(), false, true, false);
            }
        }

        @Override
        public final void showEditor() {
            final EObject theSemanticElement = graphicalEditPart.resolveSemanticElement();
            final InlineTextInputDialog dialog = createDialog(graphicalEditPart, theSemanticElement);

            final TransactionalEditingDomain theDomain = graphicalEditPart.getEditingDomain();
            final CommandStack theCommandStack = theDomain.getCommandStack();
            if (Window.OK == dialog.open()) {
                handleRename(dialog.getValue(), theSemanticElement, theDomain, theCommandStack);
            } else if (theCommandStack instanceof IWorkspaceCommandStack) {
                handleCancelation(theSemanticElement, theDomain, theCommandStack);
            }
        }

        private boolean theLastOperationCreatedTheElement(final EObject theSemanticElement,
                final IWorkspaceCommandStack theWorkspaceCommandStack) {
            final IOperationHistory operationHistory = theWorkspaceCommandStack.getOperationHistory();
            final IUndoableOperation[] undoHistory = operationHistory.getUndoHistory(theWorkspaceCommandStack
                    .getDefaultUndoContext());
            return undoHistory.length > 0
                    && theSemanticElement == getCreatedElement(undoHistory[undoHistory.length - 1],
                            theSemanticElement.getClass());
        }

        private EObject getCreatedElement(final IUndoableOperation operation, final Class<?> type) {
            if (getCreateElementLabel().equals(operation.getLabel()) && operation instanceof ICommand) {
                final ICommand createElementCommand = (ICommand) operation;
                final CommandResult result = createElementCommand.getCommandResult();
                final Object returnValue = result.getReturnValue();
                if (returnValue instanceof Collection) {
                    final Collection<?> c = (Collection<?>) returnValue;
                    if (!c.isEmpty()) {
                        final Object next = c.iterator().next();
                        if (next instanceof IAdaptable) {
                            final IAdaptable adapter = (IAdaptable) next;
                            return (EObject) adapter.getAdapter(type);
                        }
                    }
                }
            }
            return null;
        }

        private static String getCreateElementLabel() {
            return "Create Element";
        }

        private InlineTextInputDialog createDialog(final IGraphicalEditPart graphicalEditPart, final EObject objectToEdit) {
            if (isInReferenceLibrarySubset(objectToEdit)) {
                return createReferenceLibraryClassifierNameDialog(graphicalEditPart);
            }
            return new SimpleInlineTextInputDialog(graphicalEditPart, getName(objectToEdit));
        }

        private static abstract class SetName extends RecordingCommand {
            protected final String theNewName;
            protected final EObject theSemanticElement;

            public SetName(final TransactionalEditingDomain domain, final String label, final String theNewName,
                    final EObject theSemanticElement) {
                super(domain, label);
                this.theNewName = theNewName;
                this.theSemanticElement = theSemanticElement;
            }

            protected boolean confirm() {
                return true;
            }

            @Override
            protected void doExecute() {
                setName(theSemanticElement, theNewName);
            }

            protected void after() { // no-op
            }
        }

        private static final class SetNameTheFirstTime extends SetName {
            private final IWorkspaceCommandStack theWorkspaceCommandStack;

            public SetNameTheFirstTime(final TransactionalEditingDomain domain, final String theNewName,
                    final EObject theSemanticElement, final IWorkspaceCommandStack theWorkspaceCommandStack) {
                super(domain, getCreateElementLabel(), theNewName, theSemanticElement);
                this.theWorkspaceCommandStack = theWorkspaceCommandStack;
            }

            @Override
            protected final void after() {
                final IOperationHistory theOperationHistory = theWorkspaceCommandStack.getOperationHistory();
                final IUndoContext theDefaultUndoContext = theWorkspaceCommandStack.getDefaultUndoContext();
                final IUndoableOperation[] theUndoHistory = theOperationHistory.getUndoHistory(theDefaultUndoContext);
                final IUndoableOperation theEditLabelOperation = theUndoHistory[theUndoHistory.length - 1];
                final IUndoableOperation theCreateElementOperation = theUndoHistory[theUndoHistory.length - 2];
                final IOperationHistoryListener theOperationHistoryListener = new AtomicElementLabelingSupport(
                        theWorkspaceCommandStack, theEditLabelOperation, theCreateElementOperation);
                theOperationHistory.addOperationHistoryListener(theOperationHistoryListener);
            }
        }

        private static final class Rename extends SetName {
            private Collection<Element> ownedElementsAndRelationships;
            private final Shell shell;

            public Rename(final TransactionalEditingDomain domain, final String theNewName,
                    final EObject theSemanticElement, final Shell shell) {
                super(domain, "Edit Label", theNewName, theSemanticElement);
                this.shell = shell;
            }

            private boolean theNameIsTheSame() {
                if (hasNiemName(theSemanticElement) && !isBlank(getReferenceNiemName((Element) theSemanticElement))) {
                    return true;
                }
                final String theOldName = UMLExt.getName(theSemanticElement);
                if (ObjectUtils.equals(theOldName + "Type", theNewName)
                        || ObjectUtils.equals(theOldName, theNewName + "Type")) {
                    return true;
                }
                return false;
            }

            @Override
            protected final boolean confirm() {
                if (theNameIsTheSame()) {
                    ownedElementsAndRelationships = Collections.emptySet();
                    return true;
                }
                ownedElementsAndRelationships = collectOwnedElementsAndRelationships(theSemanticElement);
                if (ownedElementsAndRelationships.isEmpty()) {
                    return true;
                }
                final Collection<Comment> comments = getObjectsByType(ownedElementsAndRelationships,
                        UMLPackage.Literals.COMMENT);
                if (ownedElementsAndRelationships.size() != comments.size()) {
                    return openConfirm(shell,
                            Activator.INSTANCE.getString("_UI_RenameAndRemoveReferences_confirmation_dialog_title"),
                            Activator.INSTANCE.getString("_UI_RenameAndRemoveReferences_confirmation_dialog_message"));
                }
                return true;
            }

            @Override
            protected void doExecute() {
                super.doExecute();
                delete(ownedElementsAndRelationships, getTheNotationResource(theSemanticElement.eResource()));
            }

            private Resource getTheNotationResource(final Resource fromTheUmlResource) {
                return fromTheUmlResource != null && fromTheUmlResource.getResourceSet() instanceof ModelSet ? getNotationResource((ModelSet) fromTheUmlResource
                        .getResourceSet()) : null;
            }
        }
    }

    private static final class AtomicElementLabelingSupport implements IOperationHistoryListener {
        private final IWorkspaceCommandStack theCommandStack;
        private final IUndoableOperation theEditLabelOperation;
        private final IUndoableOperation theCreateElementOperation;

        private AtomicElementLabelingSupport(final IWorkspaceCommandStack theCommandStack,
                final IUndoableOperation theEditLabelOperation, final IUndoableOperation theCreateElementOperation) {
            this.theCommandStack = theCommandStack;
            this.theEditLabelOperation = theEditLabelOperation;
            this.theCreateElementOperation = theCreateElementOperation;
        }

        private void stopListening() {
            theCommandStack.getOperationHistory().removeOperationHistoryListener(this);
        }

        private void async(final Runnable r) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(r);
        }

        @Override
        public void historyNotification(final OperationHistoryEvent event) {
            if (event.getOperation() == theEditLabelOperation) {
                if (event.getEventType() == OperationHistoryEvent.UNDONE) {
                    async(new Runnable() {
                        @Override
                        public void run() {
                            final IUndoableOperation[] theUndoHistory = theCommandStack.getOperationHistory()
                                    .getUndoHistory(theCommandStack.getDefaultUndoContext());
                            if (theUndoHistory.length > 0
                                    && theUndoHistory[theUndoHistory.length - 1] == theCreateElementOperation) {
                                theCommandStack.undo();
                            } else {
                                Activator.INSTANCE
                                .log("Unable to cascade the undo after the element label change was undone. The Reference Library Subset may be in an illegal state.");
                                stopListening();
                            }
                        }
                    });
                } else if (event.getEventType() == OperationHistoryEvent.OPERATION_REMOVED) {
                    stopListening();
                }
            }
            if (event.getOperation() == theCreateElementOperation) {
                if (event.getEventType() == OperationHistoryEvent.REDONE) {
                    async(new Runnable() {
                        @Override
                        public void run() {
                            final IUndoableOperation[] theRedoHistory = theCommandStack.getOperationHistory()
                                    .getRedoHistory(theCommandStack.getDefaultUndoContext());
                            if (theRedoHistory.length > 0
                                    && theRedoHistory[theRedoHistory.length - 1] == theEditLabelOperation) {
                                theCommandStack.redo();
                            } else {
                                Activator.INSTANCE
                                .log("Unable to cascade the redo after the create element change was redone. The Reference Library Subset may be in an illegal state.");
                                stopListening();
                            }
                        }
                    });
                } else if (event.getEventType() == OperationHistoryEvent.OPERATION_REMOVED) {
                    stopListening();
                }
            }
        }
    }
}
