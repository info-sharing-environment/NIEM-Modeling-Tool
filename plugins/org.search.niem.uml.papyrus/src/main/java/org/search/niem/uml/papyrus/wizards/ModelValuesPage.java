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
package org.search.niem.uml.papyrus.wizards;

import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.apache.commons.lang.StringUtils.defaultIfEmpty;
import static org.search.niem.uml.ui.util.UIExt.select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.search.niem.uml.papyrus.Activator;

public abstract class ModelValuesPage extends WizardPage {

    private final ValidationListener validationListener = new ValidationListener();

    private final String helpContextID;

    protected ModelValuesPage(final String pageName, final String title, final String description, final String helpContextID) {
        super(pageName);
        this.helpContextID = helpContextID;
        setTitle(title);
        setDescription(description);
    }

    protected abstract void createContent(final Composite pageContainer);

    @Override
    public final void createControl(final Composite parent) {
        initializeDialogUnits(parent);

        final ScrolledComposite theScrollBox = new ScrolledComposite(parent, SWT.V_SCROLL);
        final Composite pageContainer = new Composite(theScrollBox, SWT.NONE);
        createContent(pageContainer);

        Dialog.applyDialogFont(theScrollBox);

        theScrollBox.setContent(pageContainer);
        theScrollBox.setExpandHorizontal(true);
        theScrollBox.setExpandVertical(true);

        GridLayoutFactory.fillDefaults().spacing(10, 10).generateLayout(pageContainer);
        GridLayoutFactory.fillDefaults().generateLayout(theScrollBox);

        setErrorMessage(null);
        setMessage(null);
        setPageComplete(false); // force the user to enter the page one time
        setControl(theScrollBox);
        resetScrollBars();

        PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), helpContextID);
    }

    private void resetScrollBars() {
        final ScrolledComposite theScrollBox = (ScrolledComposite) getControl();
        final Point thePreferredSize = theScrollBox.getContent().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        theScrollBox.setMinHeight(thePreferredSize.y);
    }

    @Override
    public final void setVisible(final boolean visible) {
        super.setVisible(visible);
        if (visible) {
            validatePage();
        }
    }

    protected abstract void validatePage();

    protected final void thePageIsComplete() {
        setErrorMessage(null);
        setMessage(null);
        setPageComplete(true);
    }

    protected final void setValidationError(final String message) {
        setErrorMessage(message);
        setPageComplete(false);
    }

    protected final LabeledTextBox createLabeledTextBox(final Composite theParent, final boolean single,
            final String theLabelText, final String theInitialText) {
        final Label theLabel = new Label(theParent, SWT.NONE);
        theLabel.setText(theLabelText);

        final Text theTextBox = new Text(theParent, SWT.BORDER | (single ? SWT.SINGLE : SWT.MULTI));
        GridDataFactory.fillDefaults().grab(true, !single).applyTo(theTextBox);

        setText(theTextBox, theInitialText);

        theTextBox.addModifyListener(validationListener);
        return new LabeledTextBox(theTextBox, theLabel);
    }

    private static void setText(final Text t, final String s) {
        t.setText(defaultIfEmpty(s, ""));
    }

    private class ValidationListener implements ModifyListener {
        @Override
        public void modifyText(final ModifyEvent e) {
            validatePage();
        }
    }

    protected static final class LabeledTextBox implements Section<String> {
        final Text text;
        final Label label;

        LabeledTextBox(final Text text, final Label label) {
            this.text = text;
            this.label = label;
        }

        @Override
        public String getValue() {
            return defaultIfBlank(text.getText(), null);
        }

        @Override
        public void setValue(final String s) {
            setText(text, s);
        }

        @Override
        public void dispose() {
            text.dispose();
            label.dispose();
        }
    }

    protected final class TextBoxesGroup extends ValuesGroup<LabeledTextBox, String> {
        @Override
        protected LabeledTextBox doCreateSection(final Composite theSectionBody, final String theSectionLabel) {
            final LabeledTextBox labeledTextBox = createLabeledTextBox(theSectionBody, true, theSectionLabel, null);
            GridLayoutFactory.fillDefaults().numColumns(3).generateLayout(theSectionBody);
            return labeledTextBox;
        }
    }

    protected abstract class ValuesGroup<SECTION extends Section<VALUE>, VALUE> {

        final List<SECTION> theSections = new LinkedList<>();
        private final List<Button> theRemoveButtons = new LinkedList<>();
        private Button theAddButton;
        private final Image theDisabledRemoveIcon;
        private final Image theEnabledRemoveIcon;
        private final Image theEnabledAddIcon;
        private Group theGroup;

        protected ValuesGroup() {
            theEnabledRemoveIcon = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE);
            theDisabledRemoveIcon = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE);
            theEnabledAddIcon = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
        }

        final void setValues(final List<VALUE> values) {
            final int theDifferenceInSizes = values.size() - theSections.size();
            if (theDifferenceInSizes > 0) {
                for (int i = 0; i < theDifferenceInSizes; i++) {
                    select(theAddButton);
                }
            } else if (theDifferenceInSizes < 0) {
                for (int i = 0; i > theDifferenceInSizes; i--) {
                    final Button theRemoveButton = theRemoveButtons.get(theRemoveButtons.size() - 1);
                    if (theRemoveButton.isEnabled()) {
                        select(theRemoveButton);
                    } else {
                        theSections.get(theSections.size() - 1).setValue(null);
                    }
                }
            }
            for (int i = 0; i < values.size(); i++) {
                theSections.get(i).setValue(values.get(i));
            }
        }

        final List<VALUE> getValues() {
            final List<VALUE> values = new ArrayList<>();
            for (final SECTION s : theSections) {
                final VALUE v = s.getValue();
                if (v != null) {
                    values.add(v);
                }
            }
            return values;
        }

        protected abstract SECTION doCreateSection(final Composite theSectionBody, final String theSectionLabel);

        final Composite createGroup(final Composite theParent, final String theGroupLabel, final String theSectionLabel) {
            theGroup = new Group(theParent, SWT.NONE);
            theGroup.setText(theGroupLabel);

            final Composite theSectionBody = new Composite(theGroup, SWT.NONE);
            createSection(theSectionBody, theSectionLabel);

            theAddButton = createAddButton(theGroup, theSectionBody, theSectionLabel);

            refreshRemoveButtons();

            GridLayoutFactory.swtDefaults().generateLayout(theGroup);

            return theGroup;
        }

        void dispose() {
            theGroup.dispose();
        }

        protected final Button createButton(final Composite theParent, final Image theIcon, final String theTooltip) {
            final Button button = new Button(theParent, SWT.PUSH);
            button.setImage(theIcon);
            button.setToolTipText(theTooltip);
            GridDataFactory.fillDefaults().hint(theIcon.getImageData().width + 10, theIcon.getImageData().height + 10)
                    .align(SWT.END, SWT.CENTER).applyTo(button);
            return button;
        }

        private Button createAddButton(final Composite theParent, final Composite theSectionBody, final String theLabel) {
            final Button theAddButton = createButton(theParent, theEnabledAddIcon, Activator.INSTANCE.getString(
                    "_UI_ModelValuesPage_ValuesGroup_add_button_tooltip", new Object[] { theLabel }));
            theAddButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(final SelectionEvent e) {
                    createSection(theSectionBody, theLabel);
                    refreshRemoveButtons();
                    theParent.getShell().layout(new Control[] { theSectionBody });
                    resetScrollBars();
                    validatePage();
                }
            });
            return theAddButton;
        }

        private Button createRemoveButton(final Composite theSectionBody, final SECTION theSection, final String theLabel) {
            final Button theRemoveButton = createButton(theSectionBody, theEnabledRemoveIcon, Activator.INSTANCE.getString(
                    "_UI_ModelValuesPage_ValuesGroup_remove_button_tooltip", new Object[] { theLabel }));
            theRemoveButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(final SelectionEvent event) {
                    remove(theSection);
                    remove(theRemoveButton);
                    refreshRemoveButtons();
                    theSectionBody.getShell().layout(new Control[] { theSectionBody });
                    resetScrollBars();
                    validatePage();
                }
            });
            return theRemoveButton;
        }

        private void remove(final SECTION s) {
            theSections.remove(s);
            s.dispose();
        }

        private void remove(final Button b) {
            theRemoveButtons.remove(b);
            b.dispose();
        }

        private void enableRemoveButton(final Button b) {
            b.setImage(theEnabledRemoveIcon);
            b.setEnabled(true);
        }

        private void disableRemoveButton(final Button b) {
            b.setImage(theDisabledRemoveIcon);
            b.setEnabled(false);
        }

        private void refreshRemoveButtons() {
            if (theRemoveButtons.size() == 1) {
                disableRemoveButton(theRemoveButtons.get(0));
            }
            if (theRemoveButtons.size() == 2) {
                enableRemoveButton(theRemoveButtons.get(0));
            }
        }

        private SECTION createSection(final Composite theSectionBody, final String theLabel) {
            final SECTION theSection = doCreateSection(theSectionBody, theLabel);
            theRemoveButtons.add(createRemoveButton(theSectionBody, theSection, theLabel));
            theSections.add(theSection);
            return theSection;
        }
    }

    protected static interface Section<V> {
        V getValue();

        void setValue(V v);

        void dispose();
    }
}
