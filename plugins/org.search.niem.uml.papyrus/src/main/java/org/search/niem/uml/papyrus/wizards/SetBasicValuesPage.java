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

import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXCHANGE_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_EXTENSION_MODEL_TARGET_NAMESPACE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_BASE_URI;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_DESCRIPTION;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_PURPOSE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_SECURITY_MARKING;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_MPD_VERSION_NUMBER;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.ui.help.NiemUmlHelpContextIds;
import org.search.niem.uml.util.NiemValidator;

public class SetBasicValuesPage extends ModelValuesPage {

    private static final String PAGE_NAME = Activator.INSTANCE.getString("_UI_SetBasicValuesPage_name");

    private final NiemValidator niemValidator = new NiemValidator();

    private LabeledTextBox exchangeModelTargetNamespace;
    private LabeledTextBox extensionModelTargetNamespace;
    private LabeledTextBox mpdBaseURI;
    private LabeledTextBox mpdVersionNumber;
    private LabeledTextBox mpdDescription;
    private LabeledTextBox mpdPurpose;
    private LabeledTextBox mpdSecurityMarking;

    protected SetBasicValuesPage() {
        super(PAGE_NAME, Activator.INSTANCE.getString("_UI_SetBasicValuesPage_title"), Activator.INSTANCE
                .getString("_UI_SetBasicValuesPage_description"), NiemUmlHelpContextIds.SET_MODEL_VALUES_WIZARD_PAGE);
    }

    private Group createGroup(final Composite parent, final String text) {
        final Group g = new Group(parent, SWT.NONE);
        g.setText(text);
        return g;
    }

    @Override
    protected void createContent(final Composite pageContainer) {

        final Group modelValuesGroup = createGroup(pageContainer,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_model_values_group_name"));

        final IPreferenceStore store = Activator.getPlugin().getPreferenceStore();

        exchangeModelTargetNamespace = createLabeledTextBox(modelValuesGroup, true,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_exchange_model_target_namespace"),
                store.getString(P_EXCHANGE_MODEL_TARGET_NAMESPACE));

        extensionModelTargetNamespace = createLabeledTextBox(modelValuesGroup, true,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_extension_model_target_namespace"),
                store.getString(P_EXTENSION_MODEL_TARGET_NAMESPACE));

        mpdBaseURI = createLabeledTextBox(modelValuesGroup, true,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_mpd_base_uri"), store.getString(P_MPD_BASE_URI));

        mpdVersionNumber = createLabeledTextBox(modelValuesGroup, true,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_mpd_version_number"),
                store.getString(P_MPD_VERSION_NUMBER));

        mpdDescription = createLabeledTextBox(modelValuesGroup, false,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_mpd_description"), store.getString(P_MPD_DESCRIPTION));

        mpdPurpose = createLabeledTextBox(modelValuesGroup, false,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_mpd_purpose"), store.getString(P_MPD_PURPOSE));

        mpdSecurityMarking = createLabeledTextBox(modelValuesGroup, false,
                Activator.INSTANCE.getString("_UI_SetBasicValuesPage_mpd_security_marking"),
                store.getString(P_MPD_SECURITY_MARKING));

        GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(modelValuesGroup);
    }

    @Override
    protected void validatePage() {
        if (!niemValidator.isValidURI(exchangeModelTargetNamespace.getValue())) {
            setValidationError(invalidURI("_UI_SetBasicValuesPage_exchange_model_target_namespace"));
            return;
        }
        if (!niemValidator.isValidURI(extensionModelTargetNamespace.getValue())) {
            setValidationError(invalidURI("_UI_SetBasicValuesPage_extension_model_target_namespace"));
            return;
        }
        if (!niemValidator.isValidURI(mpdBaseURI.getValue())) {
            setValidationError(invalidURI("_UI_SetBasicValuesPage_mpd_base_uri"));
            return;
        }
        if (!niemValidator.isValidMPDVersionID(mpdVersionNumber.getValue())) {
            setValidationError(Activator.INSTANCE.getString("_UI_SetBasicValuesPage_invalid_mpd_version_number"));
            return;
        }
        if (!niemValidator.isValidMPDSecurityMarking(mpdSecurityMarking.getValue())) {
            setValidationError(Activator.INSTANCE.getString("_UI_SetBasicValuesPage_invalid_mpd_security_marking"));
            return;
        }
        thePageIsComplete();
    }

    private String invalidURI(final String type) {
        return Activator.INSTANCE.getString("_UI_SetBasicValuesPage_invalid_uri",
                new Object[] { Activator.INSTANCE.getString(type) });
    }

    BasicValues getModelValues() {
        return new BasicValues(exchangeModelTargetNamespace.getValue(), extensionModelTargetNamespace.getValue(),
                mpdBaseURI.getValue(), mpdVersionNumber.getValue(), mpdDescription.getValue(), mpdPurpose.getValue(),
                mpdSecurityMarking.getValue());
    }
}
