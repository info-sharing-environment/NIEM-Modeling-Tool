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

import static org.search.niem.uml.util.NIEMUmlExt.createPOC;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

public final class PointOfContact {
    final String name;
    final List<String> emailAddresses;
    final List<String> phoneNumbers;

    public PointOfContact(final String name, final List<String> emailAddresses, final List<String> phoneNumbers) {
        this.name = name;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
    }

    EObject toEObject(final Element theMPD) {
        return createPOC(theMPD, name, emailAddresses, phoneNumbers);
    }
}