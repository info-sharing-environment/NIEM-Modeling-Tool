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
package org.search.niem.uml.papyrus.preferences;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.join;
import static org.search.niem.uml.papyrus.preferences.PointOfContact.POINTS_OF_CONTACT_SEPARATOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_ADDRESS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_NAME;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_WEBSITE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DEFAULT_MODEL_NAME;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DOMAINS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXCHANGE_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXTENSION_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_KEYWORDS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_BASE_URI;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_DESCRIPTION;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_PURPOSE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_SECURITY_MARKING;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_VERSION_NUMBER;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_POINTS_OF_CONTACT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.SEPARATOR;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.search.niem.uml.papyrus.Activator;

public class ModelPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public ModelPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getPlugin().getPreferenceStore());
        setDescription(Activator.INSTANCE.getString("_UI_ModelPreferencePage_description"));
    }

    @Override
    public void createFieldEditors() {
        addField(new StringFieldEditor(P_DEFAULT_MODEL_NAME,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_defaultModelNamePreference"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_EXCHANGE_MODEL_TARGET_NAMESPACE,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_exchangeModelTargetNamespace"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_EXTENSION_MODEL_TARGET_NAMESPACE,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_extensionModelTargetNamespace"),
                getFieldEditorParent()));
        addField(new StringFieldEditor(P_MPD_BASE_URI, Activator.INSTANCE.getString("_UI_ModelPreferencePage_mpdBaseURI"),
                getFieldEditorParent()));
        addField(new StringFieldEditor(P_MPD_VERSION_NUMBER,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_mpdVersionNumber"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_MPD_DESCRIPTION,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_mpdDescription"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_MPD_PURPOSE, Activator.INSTANCE.getString("_UI_ModelPreferencePage_mpdPurpose"),
                getFieldEditorParent()));
        addField(new StringFieldEditor(P_MPD_SECURITY_MARKING,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_mpdSecurityMarking"), getFieldEditorParent()));
        addField(new MultiStringEditor(P_DOMAINS, Activator.INSTANCE.getString("_UI_ModelPreferencePage_domain"),
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_domains"), getFieldEditorParent()));
        addField(new MultiStringEditor(P_KEYWORDS, Activator.INSTANCE.getString("_UI_ModelPreferencePage_keyword"),
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_keywords"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_AUTHORITATIVE_SOURCE_NAME,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_authoritativeSourceName"), getFieldEditorParent()));
        addField(new MultiLineStringFieldEditor(P_AUTHORITATIVE_SOURCE_ADDRESS,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_authoritativeSourceAddress"), getFieldEditorParent()));
        addField(new StringFieldEditor(P_AUTHORITATIVE_SOURCE_WEBSITE,
                Activator.INSTANCE.getString("_UI_ModelPreferencePage_authoritativeSourceWebsite"), getFieldEditorParent()));
        addField(new PointsOfContactEditor(getFieldEditorParent()));
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

    private static final class MultiLineStringFieldEditor extends StringFieldEditor {
        private Text textField;
        private int validateStrategy = VALIDATE_ON_KEY_STROKE;
        private int textLimit;

        public MultiLineStringFieldEditor(final String name, final String labelText, final Composite parent) {
            super(name, labelText, parent);
        }

        @Override
        public void setTextLimit(final int limit) {
            super.setTextLimit(limit);
            textLimit = limit;
        }

        @Override
        public void setValidateStrategy(final int value) {
            super.setValidateStrategy(value);
            validateStrategy = value;
        }

        /**
         * Copied directly from {@link StringFieldEditor#getTextControl(Composite)}, except the style is MULTI instead of
         * SINGLE
         */
        @Override
        public Text getTextControl(final Composite parent) {
            if (textField == null) {
                textField = new Text(parent, SWT.MULTI | SWT.BORDER);
                textField.setFont(parent.getFont());
                switch (validateStrategy) {
                case VALIDATE_ON_KEY_STROKE:
                    textField.addKeyListener(new KeyAdapter() {

                        @Override
                        public void keyReleased(final KeyEvent e) {
                            valueChanged();
                        }
                    });
                    textField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(final FocusEvent e) {
                            valueChanged();
                        }
                    });

                    break;
                case VALIDATE_ON_FOCUS_LOST:
                    textField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(final KeyEvent e) {
                            clearErrorMessage();
                        }
                    });
                    textField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusGained(final FocusEvent e) {
                            refreshValidState();
                        }

                        @Override
                        public void focusLost(final FocusEvent e) {
                            valueChanged();
                            clearErrorMessage();
                        }
                    });
                    break;
                default:
                    Assert.isTrue(false, "Unknown validate strategy");//$NON-NLS-1$
                }
                textField.addDisposeListener(new DisposeListener() {
                    @Override
                    public void widgetDisposed(final DisposeEvent event) {
                        textField = null;
                    }
                });
                if (textLimit > 0) {
                    textField.setTextLimit(textLimit);
                }
            } else {
                checkParent(textField, parent);
            }
            return textField;
        }
    }

    private static final class MultiStringEditor extends ListEditor {

        private final String preferenceName;
        Composite container;

        public MultiStringEditor(final String preferenceCategory, final String preferenceName, final String labelText,
                final Composite parent) {
            this.preferenceName = preferenceName;
            setPreferenceName(preferenceCategory);
            setLabelText(labelText);
            createControl(parent);
        }

        @Override
        protected void createControl(final Composite parent) {
            container = new Composite(parent, SWT.NONE);
            super.createControl(container);
            GridDataFactory.fillDefaults().span(2, SWT.DEFAULT).grab(true, false).applyTo(container);
            GridLayoutFactory.fillDefaults().numColumns(4).applyTo(container);
        }

        @Override
        protected String createList(final String[] items) {
            return join(items, SEPARATOR);
        }

        @Override
        protected String getNewInputObject() {
            final InputDialog userInput = new InputDialog(getShell(), Activator.INSTANCE.getString(
                    "_UI_MultiStringEditor_label", new Object[] { preferenceName }), preferenceName, "", null);
            return userInput.open() == Window.OK ? userInput.getValue() : null;
        }

        @Override
        protected String[] parseString(final String stringList) {
            return stringList.split(SEPARATOR);
        }

    }

    private static final class PointsOfContactEditor extends ListEditor {

        public PointsOfContactEditor(final Composite parent) {
            setPreferenceName(P_POINTS_OF_CONTACT);
            setLabelText(Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointsOfContact"));
            createControl(parent);
        }

        @Override
        protected void createControl(final Composite parent) {
            final Composite container = new Composite(parent, SWT.NONE);
            super.createControl(container);
            GridDataFactory.fillDefaults().span(2, SWT.DEFAULT).grab(true, false).applyTo(container);
            GridLayoutFactory.fillDefaults().numColumns(4).applyTo(container);
        }

        @Override
        protected String createList(final String[] items) {
            return join(items, POINTS_OF_CONTACT_SEPARATOR);
        }

        @Override
        protected String getNewInputObject() {
            final InputDialog userInput = new PointOfContactInputDialog(getShell());
            return userInput.open() == Window.OK ? userInput.getValue() : null;
        }

        @Override
        protected String[] parseString(final String stringList) {
            return stringList.split(POINTS_OF_CONTACT_SEPARATOR);
        }

        private static final class PointOfContactInputDialog extends InputDialog {
            private MultiStringEditor emails;
            private MultiStringEditor phoneNumbers;
            private String value;

            public PointOfContactInputDialog(final Shell parentShell) {
                super(parentShell, Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContact"),
                        Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContactName"), "", null);
            }

            @Override
            protected Control createDialogArea(final Composite parent) {
                final Composite theDialogArea = (Composite) super.createDialogArea(parent);
                emails = new MultiStringEditor("FAKE CATEGORY",
                        Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContactEmailAddress"),
                        Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContactEmailAddresses"), theDialogArea);
                phoneNumbers = new MultiStringEditor("FAKE CATEGORY",
                        Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContactPhoneNumber"),
                        Activator.INSTANCE.getString("_UI_ModelPreferencePage_pointOfContactPhoneNumbers"), theDialogArea);
                return theDialogArea;
            }

            @Override
            protected void okPressed() {
                try {
                    value = new PointOfContact(super.getValue(), asList(emails.getListControl(emails.container).getItems()),
                            asList(phoneNumbers.getListControl(phoneNumbers.container).getItems())).toPreference();

                } finally {
                    super.okPressed();
                }
            }

            @Override
            public String getValue() {
                return value;
            }
        }
    }
}