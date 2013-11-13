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

import static java.util.Collections.singletonList;
import static org.search.niem.uml.papyrus.preferences.PointOfContact.fromPreference;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_POINTS_OF_CONTACT;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.ui.help.NiemUmlHelpContextIds;
import org.search.niem.uml.util.NiemValidator;

public class SetPOCValuesPage extends ModelValuesPage {

    private static final String PAGE_NAME = Activator.INSTANCE.getString("_UI_SetPOCValuesPage_name");

    private final NiemValidator niemValidator = new NiemValidator();

    private PointsOfContactGroup pointsOfContact;

    protected SetPOCValuesPage() {
        super(PAGE_NAME, Activator.INSTANCE.getString("_UI_SetPOCValuesPage_title"), Activator.INSTANCE
                .getString("_UI_SetPOCValuesPage_description"), NiemUmlHelpContextIds.SET_POC_VALUES_WIZARD_PAGE);
    }

    @Override
    protected void createContent(final Composite pageContainer) {
        (pointsOfContact = new PointsOfContactGroup()).createGroup(pageContainer,
                Activator.INSTANCE.getString("_UI_SetPOCValuesPage_points_of_contact_group_name"),
                Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_group_name"));

        final List<org.search.niem.uml.papyrus.preferences.PointOfContact> pointsOfContactPreference = fromPreference(Activator
                .getPlugin().getPreferenceStore().getString(P_POINTS_OF_CONTACT));
        if (!pointsOfContactPreference.isEmpty()) {
            getShell().getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                    final List<PointOfContact> pointsOfContact = new ArrayList<>();
                    for (final org.search.niem.uml.papyrus.preferences.PointOfContact preference : pointsOfContactPreference) {
                        pointsOfContact.add(new PointOfContact(preference.name, preference.emailAddresses,
                                preference.phoneNumbers));
                    }
                    setPointsOfContact(pointsOfContact);
                }
            });
        }
    }

    @Override
    protected void validatePage() {
        final List<PointOfContact> pocs = pointsOfContact.getValues();
        for (final PointOfContact poc : pocs) {
            if (!niemValidator.areValidStrings(singletonList(poc.name))) {
                setValidationError(Activator.INSTANCE.getString("_UI_SetPOCValuesPage_invalid_name"));
                return;
            }
            if (!niemValidator.areValidStrings(poc.emailAddresses)) {
                setValidationError(Activator.INSTANCE.getString("_UI_SetMPDValuesPage_invalid_emails"));
                return;
            }
            if (!niemValidator.areValidStrings(poc.phoneNumbers)) {
                setValidationError(Activator.INSTANCE.getString("_UI_SetMPDValuesPage_invalid_phone_numbers"));
                return;
            }
        }
        thePageIsComplete();
    }

    List<PointOfContact> getPointsOfContact() {
        return pointsOfContact.getValues();
    }

    public void setPointsOfContact(final List<PointOfContact> pointsOfContact) {
        this.pointsOfContact.setValues(pointsOfContact);
    }

    private final class PointOfContactGroup implements Section<PointOfContact> {
        private final Composite theContainer;
        final LabeledTextBox theName;
        final TextBoxesGroup theEmailAddresses;
        final TextBoxesGroup thePhoneNumbers;

        PointOfContactGroup(final Composite theContainer, final LabeledTextBox theName,
                final TextBoxesGroup theEmailAddresses, final TextBoxesGroup thePhoneNumbers) {
            this.theContainer = theContainer;
            this.theName = theName;
            this.theEmailAddresses = theEmailAddresses;
            this.thePhoneNumbers = thePhoneNumbers;
        }

        @Override
        public PointOfContact getValue() {
            return new PointOfContact(theName.getValue(), theEmailAddresses.getValues(), thePhoneNumbers.getValues());
        }

        @Override
        public void setValue(final PointOfContact theValue) {
            theName.setValue(theValue.name);
            theEmailAddresses.setValues(theValue.emailAddresses);
            thePhoneNumbers.setValues(theValue.phoneNumbers);
        }

        @Override
        public void dispose() {
            theContainer.dispose();
        }
    }

    private final class PointsOfContactGroup extends ValuesGroup<PointOfContactGroup, PointOfContact> {
        @Override
        protected PointOfContactGroup doCreateSection(final Composite theSectionBody, final String theSectionLabel) {
            final Group theContainer = new Group(theSectionBody, SWT.NONE);
            theContainer.setText(theSectionLabel);

            final LabeledTextBox name = createLabeledTextBox(theContainer, true,
                    Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_name"), null);

            final TextBoxesGroup emails = new TextBoxesGroup();
            final Composite theEmailsGroup = emails.createGroup(theContainer,
                    Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_group_emails"),
                    Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_email"));

            final TextBoxesGroup phoneNumbers = new TextBoxesGroup();
            final Composite thePhoneNumbersGroup = phoneNumbers.createGroup(theContainer,
                    Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_group_telephone_numbers"),
                    Activator.INSTANCE.getString("_UI_SetPOCValuesPage_point_of_contact_telephone_number"));

            GridDataFactory.fillDefaults().span(2, 1).applyTo(theEmailsGroup);
            GridDataFactory.fillDefaults().span(2, 1).applyTo(thePhoneNumbersGroup);
            GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(theContainer);
            GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(theSectionBody);
            return new PointOfContactGroup(theContainer, name, emails, phoneNumbers);
        }
    }
}
