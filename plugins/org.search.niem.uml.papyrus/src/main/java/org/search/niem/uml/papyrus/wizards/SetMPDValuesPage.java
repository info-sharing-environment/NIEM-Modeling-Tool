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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang.StringUtils.defaultIfEmpty;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_ADDRESS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_NAME;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_AUTHORITATIVE_SOURCE_WEBSITE;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_DOMAINS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_KEYWORDS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.SEPARATOR;

import java.util.List;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.ui.help.NiemUmlHelpContextIds;
import org.search.niem.uml.util.NiemValidator;

public class SetMPDValuesPage extends ModelValuesPage {

    private static final String PAGE_NAME = Activator.INSTANCE.getString("_UI_SetMPDValuesPage_name");

    private final NiemValidator niemValidator = new NiemValidator();

    private TextBoxesGroup domains;
    private TextBoxesGroup keywords;
    private LabeledTextBox authoritativeSourceName;
    private LabeledTextBox authoritativeSourceAddress;
    private LabeledTextBox authoritativeSourceWebsiteUrl;

    protected SetMPDValuesPage() {
        super(PAGE_NAME, Activator.INSTANCE.getString("_UI_SetMPDValuesPage_title"), Activator.INSTANCE
                .getString("_UI_SetMPDValuesPage_description"), NiemUmlHelpContextIds.SET_MPD_VALUES_WIZARD_PAGE);
    }

    @Override
    protected void createContent(final Composite pageContainer) {
        (domains = new TextBoxesGroup()).createGroup(pageContainer,
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_domains_group_name"),
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_domain"));

        (keywords = new TextBoxesGroup()).createGroup(pageContainer,
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_keywords_group_name"),
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_keyword"));

        createAuthoritativeSourceGroup(pageContainer);

        getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                final IPreferenceStore store = Activator.getPlugin().getPreferenceStore();
                setDomains(asList(store.getString(P_DOMAINS).split(SEPARATOR)));
                setKeywords(asList(store.getString(P_KEYWORDS).split(SEPARATOR)));
                setAuthoritativeSourceName(store.getString(P_AUTHORITATIVE_SOURCE_NAME));
                setAuthoritativeSourceAddress(store.getString(P_AUTHORITATIVE_SOURCE_ADDRESS));
                setAuthoritativeSourceWebsite(store.getString(P_AUTHORITATIVE_SOURCE_WEBSITE));
            }
        });
    }

    private Composite createAuthoritativeSourceGroup(final Composite theParent) {
        final Group theAuthoritativeSourceGroup = new Group(theParent, SWT.NONE);
        theAuthoritativeSourceGroup.setText(Activator.INSTANCE
                .getString("_UI_SetMPDValuesPage_authoritative_source_group_name"));

        authoritativeSourceName = createLabeledTextBox(theAuthoritativeSourceGroup, true,
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_authoritative_source_name"), null);

        authoritativeSourceAddress = createLabeledTextBox(theAuthoritativeSourceGroup, false,
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_authoritative_source_address"), null);

        authoritativeSourceWebsiteUrl = createLabeledTextBox(theAuthoritativeSourceGroup, true,
                Activator.INSTANCE.getString("_UI_SetMPDValuesPage_authoritative_source_website_url"), null);

        GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(theAuthoritativeSourceGroup);
        return theAuthoritativeSourceGroup;
    }

    @Override
    protected void validatePage() {
        if (!niemValidator.areValidStrings(domains.getValues())) {
            setValidationError(Activator.INSTANCE.getString("_UI_SetMPDValuesPage_invalid_domains"));
            return;
        }
        if (!niemValidator.areValidStrings(keywords.getValues())) {
            setValidationError(Activator.INSTANCE.getString("_UI_SetMPDValuesPage_invalid_keywords"));
            return;
        }
        if (!niemValidator.areValidStrings(singletonList(authoritativeSourceName.getValue()))) {
            setValidationError(Activator.INSTANCE.getString("_UI_SetMPDValuesPage_invalid_authoritative_source_name"));
            return;
        }
        thePageIsComplete();
    }

    MPDValues getMPDValues() {
        return new MPDValues(domains.getValues(), keywords.getValues(), authoritativeSourceName.getValue(), defaultIfEmpty(
                authoritativeSourceAddress.getValue(), null), defaultIfEmpty(authoritativeSourceWebsiteUrl.getValue(), null));
    }

    public void setDomains(final List<String> values) {
        domains.setValues(values);
    }

    public void setKeywords(final List<String> values) {
        keywords.setValues(values);
    }

    public void setAuthoritativeSourceName(final String name) {
        authoritativeSourceName.setValue(name);
    }

    public void setAuthoritativeSourceAddress(final String address) {
        authoritativeSourceAddress.setValue(address);
    }

    public void setAuthoritativeSourceWebsite(final String website) {
        authoritativeSourceWebsiteUrl.setValue(website);
    }
}
