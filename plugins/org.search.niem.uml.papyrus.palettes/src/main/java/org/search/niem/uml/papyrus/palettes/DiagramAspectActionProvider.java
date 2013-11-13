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
package org.search.niem.uml.papyrus.palettes;

import static org.apache.commons.lang.ObjectUtils.notEqual;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAClassDiagram;
import static org.search.niem.uml.papyrus.util.DiagramExt.createAnHyperLink;
import static org.search.niem.uml.papyrus.util.DiagramExt.updateAnHyperLink;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getTheEditingDomain;
import static org.search.niem.uml.papyrus.util.PapyrusExt.getThePageManager;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AbstractAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.papyrus.uml.diagram.common.service.palette.ModelPostAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

public class DiagramAspectActionProvider extends AbstractAspectActionProvider {

    @Override
    public IAspectAction createAction(final org.w3c.dom.Node configurationNode) {
        final DiagramPostAction action = new DiagramPostAction();
        action.init(configurationNode, this);
        return action;
    }

    @Override
    public boolean isEnable(final IPaletteEntryProxy entryProxy) {
        return true;
    }

    private static final class DiagramPostAction extends ModelPostAction {

        @Override
        public ICommand getPostCommand(final IAdaptable viewAdapter) {
            final AbstractTransactionalCommand c = new AbstractTransactionalCommand(getTheEditingDomain(),
                    Activator.INSTANCE.getString("_UI_DiagramPostAction_command_name"), null) {
                @Override
                protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
                        throws ExecutionException {
                    final View theNamespaceNode = (View) viewAdapter.getAdapter(View.class);
                    final EObject theNamespace = theNamespaceNode.getElement();
                    final Diagram theNamespaceDiagram = createAClassDiagram(theNamespace, theNamespaceNode.eResource(),
                            getThePageManager());
                    createAnHyperLink(theNamespaceNode, theNamespaceDiagram);
                    theNamespace.eAdapters().add(new AdapterImpl() {
                        @Override
                        public void notifyChanged(final Notification msg) {
                            final String theNewName = msg.getNewStringValue();
                            if (UMLPackage.Literals.NAMED_ELEMENT__NAME.equals(msg.getFeature())
                                    && notEqual(msg.getOldValue(), theNewName)
                                    && notEqual(theNewName, theNamespaceDiagram.getName())) {
                                theNamespaceDiagram.setName(theNewName);
                                updateAnHyperLink(theNamespaceNode, theNewName, theNewName);
                            }
                        }
                    });
                    return CommandResult.newOKCommandResult();
                }
            };
            return c;
        }

        @Override
        public Control createConfigurationComposite(final Composite parent, final IPaletteEntryProxy entryProxy,
                final List<Profile> appliedProfiles) {
            return null;
        }

        @Override
        public void save(final org.w3c.dom.Node parentNode) {
            // no-op
        }
    }
}
