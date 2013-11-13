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

public class BasicValues {

    public final String exchangeModelTargetNamespace;
    public final String extensionModelTargetNamespace;
    public final String mpdBaseURI;
    public final String mpdVersionID;
    public final String description;
    public final String purpose;
    public final String securityMarking;

    BasicValues(final String exchangeModelTargetNamespace, final String extensionModelTargetNamespace,
            final String mpdBaseURI, final String mpdVersionID, final String description, final String purpose,
            final String securityMarking) {
        this.exchangeModelTargetNamespace = exchangeModelTargetNamespace;
        this.extensionModelTargetNamespace = extensionModelTargetNamespace;
        this.mpdBaseURI = mpdBaseURI;
        this.mpdVersionID = mpdVersionID;
        this.description = description;
        this.purpose = purpose;
        this.securityMarking = securityMarking;
    }
}
