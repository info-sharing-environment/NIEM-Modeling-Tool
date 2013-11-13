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

import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceAddress;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceName;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceWebsiteURL;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDBaseURI;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDCreationDate;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDDescription;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDDomains;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDKeywords;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPointsOfContact;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPurpose;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDSecurityMarking;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDVersionID;
import static org.search.niem.uml.util.NIEMUmlExt.setTargetNamespace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;

public class SetModelValuesCommand extends RecordingCommand {

    private final Model root;
    private final BasicValues modelValues;
    private final MPDValues modelMultiValues;
    private final List<PointOfContact> pointsOfContact;

    public SetModelValuesCommand(final ModelSet modelSet, final BasicValues modelValues, final MPDValues modelMultiValues,
            final List<PointOfContact> pointsOfContact) {
        super(modelSet.getTransactionalEditingDomain());
        this.modelValues = modelValues;
        this.modelMultiValues = modelMultiValues;
        this.pointsOfContact = pointsOfContact;
        root = (Model) UmlUtils.getUmlResource(modelSet).getContents().get(0);
    }

    @Override
    protected void doExecute() {
        final PackageableElement thePIM = root.getPackagedElements().get(0);
        setTargetNamespace(thePIM.getOwnedElements().get(1), modelValues.extensionModelTargetNamespace);
        setTargetNamespace(thePIM.getOwnedElements().get(2), modelValues.exchangeModelTargetNamespace);
        final Element theMPD = root.getPackagedElements().get(1).getOwnedElements().get(0);
        setMPDBaseURI(theMPD, modelValues.mpdBaseURI);
        setMPDVersionID(theMPD, modelValues.mpdVersionID);
        setMPDDescription(theMPD, modelValues.description);
        setMPDPurpose(theMPD, modelValues.purpose);
        setMPDSecurityMarking(theMPD, modelValues.securityMarking);
        setMPDDomains(theMPD, modelMultiValues.domains);
        setMPDKeywords(theMPD, modelMultiValues.keywords);
        setMPDAuthoritativeSourceName(theMPD, modelMultiValues.authoritativeSourceName);
        setMPDAuthoritativeSourceAddress(theMPD, modelMultiValues.authoritativeSourceAddress);
        setMPDAuthoritativeSourceWebsiteURL(theMPD, modelMultiValues.authoritativeSourceWebsiteURL);
        setMPDPointsOfContact(theMPD, toEObjects(pointsOfContact, theMPD));
        setMPDCreationDate(theMPD, new Date());
    }

    private List<EObject> toEObjects(final List<PointOfContact> pointsOfContact, final Element theMPD) {
        final List<EObject> eObjects = new ArrayList<>();
        for (final PointOfContact poc : pointsOfContact) {
            eObjects.add(poc.toEObject(theMPD));
        }
        return eObjects;
    }
}
