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
import static org.apache.commons.lang.StringUtils.defaultString;
import static org.apache.commons.lang.StringUtils.join;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.SEPARATOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointOfContact {

    static final String POINTS_OF_CONTACT_SEPARATOR = "\n";
    static final String ATTRIBUTE_SEPARATOR = ">>";

    public final String name;
    public final List<String> emailAddresses;
    public final List<String> phoneNumbers;

    PointOfContact(final String name, final List<String> emailAddresses, final List<String> phoneNumbers) {
        this.name = name;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
    }

    String toPreference() {
        final StringBuilder sb = new StringBuilder();
        sb.append(defaultString(name, ""));
        sb.append(ATTRIBUTE_SEPARATOR);
        sb.append(join(emailAddresses, SEPARATOR));
        sb.append(ATTRIBUTE_SEPARATOR);
        sb.append(join(phoneNumbers, SEPARATOR));
        return sb.toString();
    }

    private static PointOfContact fromPreferenceItem(final String s) {
        final String[] attributes = s.split(ATTRIBUTE_SEPARATOR);
        final String name = attributes.length > 0 ? attributes[0] : null;
        final List<String> emailAddresses = attributes.length > 1 ? asList(attributes[1].split(SEPARATOR)) : Collections
                .<String> emptyList();
        final List<String> phoneNumbers = attributes.length > 2 ? asList(attributes[2].split(SEPARATOR)) : Collections
                .<String> emptyList();
        return new PointOfContact(name, emailAddresses, phoneNumbers);
    }

    public static List<PointOfContact> fromPreference(final String s) {
        final String[] preferenceItems = s.split(POINTS_OF_CONTACT_SEPARATOR);
        final List<PointOfContact> pointsOfContact = new ArrayList<>(preferenceItems.length);
        for (final String preferenceItem : preferenceItems) {
            pointsOfContact.add(fromPreferenceItem(preferenceItem));
        }
        return pointsOfContact;
    }
}
