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

import static org.eclipse.jface.preference.PreferenceConverter.getColor;
import static org.eclipse.jface.preference.PreferenceConverter.getFontData;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_ILLEGAL_FONT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_LEGAL_COLOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_LEGAL_FONT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_RESTRICT_NIEM_SUBSET_CONTENT;
import static org.search.niem.uml.util.NIEMUmlExt.findTargetNamespace;
import static org.search.niem.uml.util.UMLExt.getAppliedStereotypes;
import static org.search.niem.uml.util.UMLExt.getNearestPackage;
import static org.search.niem.uml.util.UMLExt.getOwner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;
import org.search.niem.uml.search.Indexer;
import org.search.niem.uml.util.EcoreExt;

final class ReferenceLibraryClassifierNameDialog extends InlineTextInputDialog {

    private final EObject referenceLibraryElement;
    private final EClass type;

    private SourceViewer viewer;
    private Document document;
    private ReferenceLibraryClassifierNamesSourceViewerConfiguration sourceViewerConfiguration;
    private Color legalReferenceElementNameColor;
    private Font legalReferenceElementNameFont;
    private Color illegalReferenceElementNameColor;
    private Font illegalReferenceElementNameFont;

    ReferenceLibraryClassifierNameDialog(final IGraphicalEditPart graphicalEditPart, final EClass type) {
        super(graphicalEditPart, "");
        referenceLibraryElement = graphicalEditPart.resolveSemanticElement();
        this.type = type;
    }

    @Override
    protected final Control createTextControl(final Composite parent) {
        final Composite viewerGroup = new Composite(parent, SWT.NONE);
        viewerGroup.setLayout(new FillLayout());
        final GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
                | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
        viewerGroup.setLayoutData(data);
        viewer = new SourceViewer(viewerGroup, null, SWT.BORDER);

        document = new Document();

        viewer.appendVerifyKeyListener(new VerifyKeyListener() {
            @Override
            public void verifyKey(final VerifyEvent event) {
                switch (event.character) {
                case ' ':
                    if (event.stateMask == SWT.CTRL) {
                        if (viewer.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS)) {
                            viewer.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
                        }
                        event.doit = false;
                    }
                    break;
                case SWT.CR:
                    event.doit = false;
                    if (theInputIsValid()) {
                        okPressed();
                    }
                    break;
                }
            }
        });
        document.addDocumentListener(new IDocumentListener() {

            @Override
            public void documentAboutToBeChanged(final DocumentEvent event) {
            }

            @Override
            public void documentChanged(final DocumentEvent event) {
                final StyledText theTextWidget = viewer.getTextWidget();
                if (!theInputIsValid()) {
                    theTextWidget.setForeground(illegalReferenceElementNameColor);
                    theTextWidget.setFont(illegalReferenceElementNameFont);
                } else {
                    theTextWidget.setForeground(legalReferenceElementNameColor);
                    theTextWidget.setFont(legalReferenceElementNameFont);
                }
            }
        });
        sourceViewerConfiguration = createReferenceLibraryClassifierNamesSourceViewerConfiguration();
        viewer.configure(sourceViewerConfiguration);
        viewer.setDocument(document);
        final IPreferenceStore thePreferenceStore = getPapyrusPreferences();
        final Display theDisplay = viewer.getControl().getDisplay();
        legalReferenceElementNameColor = new Color(theDisplay, getColor(thePreferenceStore,
                P_NIEM_REFERENCE_ELEMENT_LEGAL_COLOR));
        legalReferenceElementNameFont = new Font(theDisplay, getFontData(thePreferenceStore,
                P_NIEM_REFERENCE_ELEMENT_LEGAL_FONT));
        illegalReferenceElementNameColor = new Color(theDisplay, getColor(thePreferenceStore,
                P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR));
        illegalReferenceElementNameFont = new Font(theDisplay, getFontData(thePreferenceStore,
                P_NIEM_REFERENCE_ELEMENT_ILLEGAL_FONT));
        return viewerGroup;
    }

    private IPreferenceStore getPapyrusPreferences() {
        return org.search.niem.uml.papyrus.Activator.getPlugin().getPreferenceStore();
    }

    private void dispose(final Resource... resources) {
        for (final Resource r : resources) {
            if (r != null) {
                r.dispose();
            }
        }
    }

    @Override
    public boolean close() {
        final boolean b;
        try {
            dispose(legalReferenceElementNameColor, legalReferenceElementNameFont, illegalReferenceElementNameColor,
                    illegalReferenceElementNameFont);
        } finally {
            b = super.close();
        }
        return b;
    }

    private ReferenceLibraryClassifierNamesSourceViewerConfiguration createReferenceLibraryClassifierNamesSourceViewerConfiguration() {
        return new ReferenceLibraryClassifierNamesSourceViewerConfiguration(referenceLibraryElement, type);
    }

    private boolean theInputIsValid() {
        return !getPapyrusPreferences().getBoolean(P_RESTRICT_NIEM_SUBSET_CONTENT)
                || sourceViewerConfiguration.getValidNames().contains(getTextValue());
    }

    @Override
    protected final String getTextValue() {
        return viewer.getDocument().get();
    }

    private static final class ReferenceLibraryClassifierNamesSourceViewerConfiguration extends SourceViewerConfiguration {

        private final EObject referenceLibraryElement;
        private final AtomicReference<Collection<String>> validNames = new AtomicReference<>();
        private final EClass type;

        protected ReferenceLibraryClassifierNamesSourceViewerConfiguration(final EObject referenceLibraryElement,
                final EClass type) {
            this.referenceLibraryElement = referenceLibraryElement;
            this.type = type;
        }

        final Collection<String> getValidNames() {
            final Collection<String> existingValidNames = validNames.get();
            if (existingValidNames != null) {
                return existingValidNames;
            }
            final Collection<String> newValidNames = computeValidNames();
            if (validNames.compareAndSet(null, newValidNames)) {
                return newValidNames;
            }
            return validNames.get();
        }

        @Override
        public final IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
            final ContentAssistant contentAssistant = new ContentAssistant();
            contentAssistant.enableAutoInsert(true);
            contentAssistant.enableAutoActivation(true);
            contentAssistant.enablePrefixCompletion(true);
            contentAssistant.setContentAssistProcessor(new ContentAssistProcessor(getValidNames(), type),
                    "__dftl_partition_content_type");
            return contentAssistant;
        }

        private void createIndexIfNecessary(final Indexer indexer) {
            if (!indexer.needsIndexing()) {
                return;
            }
            try {
                new ProgressMonitorDialog(null).run(false, false, new IRunnableWithProgress() {

                    @Override
                    public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                        try {
                            indexer.index(monitor);
                        } catch (final IOException e) {
                            throw new InvocationTargetException(e);
                        }
                    }
                });
            } catch (final InvocationTargetException e) {
                Activator.INSTANCE.log(e);
            } catch (final InterruptedException e) {
                // no-op
            }
        }

        private Collection<String> computeValidNames() {
            final Indexer indexer = Indexer.create();
            createIndexIfNecessary(indexer); // move this into the indexer
            final Package theNamespacePackage = indexer
                    .findByTargetNamespace(findTargetNamespace(getNearestPackage(referenceLibraryElement)));

            if (theNamespacePackage == null) {
                return Collections.emptyList();
            }

            final Collection<String> validNames = new ArrayList<>();
            for (final Type t : filterByEquivalentTypesInTheSubset(filterByAppliedStereotypes(EcoreExt
                    .<Type> getObjectsByStrictType(theNamespacePackage.getOwnedTypes(), type)))) {
                validNames.add(t.getName());
            }
            return validNames;
        }

        private Collection<Type> filterByAppliedStereotypes(final Collection<Type> types) {
            final Collection<Stereotype> appliedStereotypes = getAppliedStereotypes(referenceLibraryElement);
            if (appliedStereotypes.isEmpty()) {
                return types;
            }
            final Collection<Type> filtered = new ArrayList<>();
            for (final Type t : types) {
                if (hasAllStereotypes(t, appliedStereotypes)) {
                    filtered.add(t);
                }
            }
            return filtered;
        }

        private boolean hasAllStereotypes(final Type t, final Collection<Stereotype> requiredStereotypes) {
            final Collection<Stereotype> appliedStereotypes = t.getAppliedStereotypes();
            if (appliedStereotypes.size() != requiredStereotypes.size()) {
                return false;
            }
            for (final Stereotype s : requiredStereotypes) {
                if (t.getAppliedStereotype(s.getQualifiedName()) == null) {
                    return false;
                }
            }
            return true;
        }

        private Collection<Type> filterByEquivalentTypesInTheSubset(final Collection<Type> types) {
            final Package parent = getOwner(referenceLibraryElement);
            final Collection<Type> filtered = new ArrayList<>();
            for (final Type t : types) {
                if (parent.getPackagedElement(t.getName(), false, type, false) == null) {
                    filtered.add(t);
                }
            }
            return filtered;
        }
    }

    private static final class ContentAssistProcessor implements IContentAssistProcessor {

        private static final char[] WORD_CHARACTERS;
        static {
            WORD_CHARACTERS = new char[26 + 26 + 1];
            int i = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                WORD_CHARACTERS[i++] = c;
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                WORD_CHARACTERS[i++] = c;
            }
            WORD_CHARACTERS[i] = '_';
        }

        private final Collection<String> validNames;
        private final EClass type;

        ContentAssistProcessor(final Collection<String> validNames, final EClass type) {
            this.type = type;
            this.validNames = sort(validNames);
        }

        private Collection<String> sort(final Collection<String> strings) {
            final ArrayList<String> sorted = new ArrayList<>(strings);
            Collections.sort(sorted);
            return sorted;
        }

        @Override
        public String getErrorMessage() {
            return null;
        }

        @Override
        public IContextInformationValidator getContextInformationValidator() {
            return null;
        }

        @Override
        public char[] getContextInformationAutoActivationCharacters() {
            return null;
        }

        @Override
        public char[] getCompletionProposalAutoActivationCharacters() {
            return WORD_CHARACTERS;
        }

        @Override
        public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
            return null;
        }

        @Override
        public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
            final String fullText = viewer.getTextWidget().getText();
            final String prefix = fullText.substring(0, offset);
            final Collection<ICompletionProposal> proposals = new ArrayList<>();
            for (final String name : validNames) {
                if (name.startsWith(prefix)) {
                    proposals.add(new CompletionProposal(name, 0, fullText.length(), name.length(),
                            ExtendedImageRegistry.INSTANCE.getImage(UMLEditPlugin.INSTANCE.getImage("full/obj16/"
                                    + type.getName())), null, null, null));
                }
            }
            return proposals.toArray(new ICompletionProposal[proposals.size()]);
        }
    }
}