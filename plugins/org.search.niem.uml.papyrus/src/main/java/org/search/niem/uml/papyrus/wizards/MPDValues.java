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

import java.util.List;

public class MPDValues {

    public final List<String> domains;
    public final List<String> keywords;
    public final String authoritativeSourceName;
    public final String authoritativeSourceAddress;
    public final String authoritativeSourceWebsiteURL;

    MPDValues(final List<String> domains, final List<String> keywords, final String authoritativeSourceName,
            final String authoritativeSourceAddress, final String authoritativeSourceWebsiteURL) {
        this.domains = domains;
        this.keywords = keywords;
        this.authoritativeSourceName = authoritativeSourceName;
        this.authoritativeSourceAddress = authoritativeSourceAddress;
        this.authoritativeSourceWebsiteURL = authoritativeSourceWebsiteURL;
    }
}
