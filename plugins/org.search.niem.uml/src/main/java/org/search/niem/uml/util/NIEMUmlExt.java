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
package org.search.niem.uml.util;

import static java.util.Collections.singletonList;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.eclipse.uml2.uml.util.UMLUtil.setTaggedValue;
import static org.search.niem.uml.util.EcoreExt.get;
import static org.search.niem.uml.util.NIEMTypes.InformationModel;
import static org.search.niem.uml.util.NIEMTypes.ModelPackageDescription;
import static org.search.niem.uml.util.NIEMTypes.Model_Package_Description_Profile;
import static org.search.niem.uml.util.NIEMTypes.NIEM_PIM_Profile;
import static org.search.niem.uml.util.NIEMTypes.ReferenceName;
import static org.search.niem.uml.util.NIEMTypes.References;
import static org.search.niem.uml.util.UMLExt.getNearestPackage;
import static org.search.niem.uml.util.UMLExt.getNestedPackages;
import static org.search.niem.uml.util.UMLExt.getStereotypeValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.library.Activator;

public class NIEMUmlExt {

    private static final String XSD_DATE_FORMAT = "yyyy-MM-ddZ";

    public static String findTargetNamespace(final Package p) {
        final EObject namespace = findNearestNiemNamespace(p);
        return namespace == null ? null : getTargetNamespace(getBaseElement(namespace));
    }

    public static boolean isPIM(final Package p) {
        return p.getAppliedProfile(NIEM_PIM_Profile) != null;
    }

    public static boolean isMPD(final Package p) {
        return p.getAppliedProfile(Model_Package_Description_Profile) != null;
    }

    public static Package findNearestNiemNamespacePackage(final Package p) {
        if (p == null) {
            return null;
        }
        return isNiemNamespace(p) ? p : findNearestNiemNamespacePackage(p.getNestingPackage());
    }

    public static EObject findNearestNiemNamespace(final Package p) {
        final Package _p = findNearestNiemNamespacePackage(p);
        return _p == null ? null : _p.getStereotypeApplication(getAppliedNiemNamespaceStereotype(_p));
    }

    public static boolean isInReferenceLibrarySubset(final EObject e) {
        final EObject namespace = findNearestNiemNamespace(getNearestPackage(e));
        return namespace == null ? false : isReferenceLibrarySubset(getBaseElement(namespace));
    }

    public static String getReferenceLibraryNamespace(final EObject e) {
        final EObject namespace = findNearestNiemNamespace(getNearestPackage(e));
        return namespace == null ? null : getTargetNamespace(getBaseElement(namespace));
    }

    public static boolean isReferenceLibrarySubset(final EObject e) {
        return isNiemNamespace(e) && Activator.INSTANCE.isReferenceLibraryNamespace(getTargetNamespace((Element) e));
    }

    public static Collection<Package> getReferenceLibrarySubsets(final EObject e) {
        final Collection<Package> theReferenceLibrarySubsets = new LinkedHashSet<>();
        for (final Package p : getNestedPackages(e)) {
            if (isReferenceLibrarySubset(p)) {
                theReferenceLibrarySubsets.add(p);
            }
        }
        return theReferenceLibrarySubsets;
    }

    public static boolean isNiemNamespace(final EObject e) {
        return getAppliedNiemNamespaceStereotype(e) != null;
    }

    public static boolean isReference(final EObject e) {
        return getAppliedReferencesStereotype(e) != null;
    }

    public static boolean hasNiemName(final EObject e) {
        return getAppliedReferenceNameStereotype(e) != null;
    }

    private static Stereotype getAppliedNiemNamespaceStereotype(final EObject e) {
        return UMLPackage.Literals.ELEMENT.isInstance(e) ? ((Element) e).getAppliedStereotype(InformationModel) : null;
    }

    public static EObject getReferenceNameStereotypeApplication(final Element e) {
        return e.getStereotypeApplication(getAppliedReferenceNameStereotype(e));
    }

    private static Stereotype getAppliedReferenceNameStereotype(final EObject e) {
        return UMLPackage.Literals.ELEMENT.isInstance(e) ? ((Element) e).getAppliedStereotype(ReferenceName) : null;
    }

    private static EObject getMpdStereotypeApplication(final Element e) {
        return e.getStereotypeApplication(getAppliedMpdStereotype(e));
    }

    public static Stereotype getAppliedMpdStereotype(final EObject e) {
        return UMLPackage.Literals.ELEMENT.isInstance(e) ? ((Element) e).getAppliedStereotype(ModelPackageDescription)
                : null;
    }

    public static Stereotype getAppliedReferencesStereotype(final EObject e) {
        return UMLPackage.Literals.ELEMENT.isInstance(e) ? ((Element) e).getAppliedStereotype(References) : null;
    }

    private static Element findMPD(final Package theParent) {
        if (theParent == null) {
            return null;
        }
        for (final Package p : theParent.getNestedPackages()) {
            if (isMPD(p)) {
                for (final PackageableElement e : p.getPackagedElements()) {
                    if (getAppliedMpdStereotype(e) != null) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    private static Package getTheRoot(final Resource theUmlResource) {
        final List<EObject> contents = theUmlResource.getContents();
        if (contents.isEmpty()) {
            return null;
        }
        final EObject theRoot = contents.get(0);
        return UMLPackage.Literals.PACKAGE.isInstance(theRoot) ? (Package) theRoot : null;
    }

    public static Element findPsmMpd(final Resource theUmlResource) {
        final Package theRoot = getTheRoot(theUmlResource);
        return theRoot == null ? null : findMPD(theRoot.getNestedPackage("PSM"));
    }

    public static Element findMPD(final Resource theUmlResource) {
        return findMPD(getTheRoot(theUmlResource));
    }

    public static String getReferenceNiemName(final Element e) {
        return (String) e.getValue(getAppliedReferenceNameStereotype(e), "NIEMName");
    }

    public static String getTargetNamespace(final Element e) {
        return (String) e.getValue(getAppliedNiemNamespaceStereotype(e), "targetNamespace");
    }

    public static void setTargetNamespace(final Element e, final String targetNamespace) {
        setTaggedValue(e, getAppliedNiemNamespaceStereotype(e), "targetNamespace", targetNamespace);
    }

    public static String getMPDBaseURI(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "mpdBaseURI");
    }

    public static void setMPDBaseURI(final Element e, final String mpdBaseURI) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "mpdBaseURI", mpdBaseURI);
    }

    public static String getMPDVersionID(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "mpdVersionID");
    }

    public static void setMPDVersionID(final Element e, final String mpdVersionID) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "mpdVersionID", mpdVersionID);
    }

    public static EnumerationLiteral getMPDClassCode(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "mpdClassCode");
    }

    public static void setMPDDescription(final Element e, final String mpdDescription) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "descriptionText", mpdDescription);
    }

    public static void setMPDPurpose(final Element e, final List<String> mpdPurpose) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "PurposeText", mpdPurpose);
    }

    public static void setMPDPurpose(final Element e, final String mpdPurpose) {
        setMPDPurpose(e, mpdPurpose == null ? Collections.<String> emptyList() : singletonList(mpdPurpose));
    }

    public static String getMPDSecurityMarking(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "SecurityMarkingText");
    }

    public static void setMPDSecurityMarking(final Element e, final String mpdSecurityMarking) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "SecurityMarkingText", mpdSecurityMarking);
    }

    public static List<String> getMPDDomains(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "DomainText");
    }

    public static void setMPDDomains(final Element e, final List<String> domains) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "DomainText", domains);
    }

    public static List<String> getMPDKeywords(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "KeywordText");
    }

    public static void setMPDKeywords(final Element e, final List<String> keywords) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "KeywordText", keywords);
    }

    public static String getMPDAuthoritativeSourceName(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "ASName");
    }

    public static void setMPDAuthoritativeSourceName(final Element e, final String authoritativeSourceName) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "ASName", authoritativeSourceName);
    }

    public static void setMPDAuthoritativeSourceAddress(final Element e, final String authoritativeSourceAddress) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "ASAddressText", authoritativeSourceAddress);
    }

    public static void setMPDAuthoritativeSourceWebsiteURL(final Element e, final String setMPDAuthoritativeSourceWebsiteURL) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "ASWebSiteURL", setMPDAuthoritativeSourceWebsiteURL);
    }

    public static List<EObject> getMPDPointsOfContact(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "POC");
    }

    public static void setMPDPointsOfContact(final Element e, final List<EObject> pointsOfContact) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "POC", pointsOfContact);
    }

    public static String getMPDPointOfContactName(final EObject poc) {
        return get(poc.eClass().getEStructuralFeature("POCName"), poc);
    }

    public static void setMPDPointOfContactName(final EObject poc, final String name) {
        poc.eSet(poc.eClass().getEStructuralFeature("POCName"), name);
    }

    public static List<String> getMPDPointOfContactEmailAddresses(final EObject poc) {
        return get(poc.eClass().getEStructuralFeature("POCEmail"), poc);
    }

    public static void setMPDPointOfContactEmailAddresses(final EObject poc, final List<String> emails) {
        poc.eSet(poc.eClass().getEStructuralFeature("POCEmail"), emails);
    }

    public static List<String> getMPDPointOfContactPhoneNumbers(final EObject poc) {
        return get(poc.eClass().getEStructuralFeature("POCTelephone"), poc);
    }

    public static void setMPDPointOfContactPhoneNumbers(final EObject poc, final List<String> phoneNumbers) {
        poc.eSet(poc.eClass().getEStructuralFeature("POCTelephone"), phoneNumbers);
    }

    public static String getMPDCreationDate(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "CreationDate");
    }

    public static void setMPDCreationDate(final Element e, final String creationDate) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "CreationDate", creationDate);
    }

    public static void setMPDCreationDate(final Element e, final Date creationDate) {
        setMPDCreationDate(e, formatXSDDate(creationDate));
    }

    public static String getMPDLastRevisionDate(final Element e) {
        return getStereotypeValue(getMpdStereotypeApplication(e), "LastRevsionDate");
    }

    public static void setMPDLastRevisionDate(final Element e, final Date lastRevisionDate) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "LastRevsionDate", formatXSDDate(lastRevisionDate));
    }

    public static void setMPDStatusText(final Element e, final String statusText) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "StatusText", statusText);
    }

    public static void setMPDExchangePatternText(final Element e, final List<String> exchangePatternText) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "ExchangePatternText", exchangePatternText);
    }

    public static void setMPDExchangePartnerName(final Element e, final List<String> exchangePartnerName) {
        setTaggedValue(e, getAppliedMpdStereotype(e), "ExchangePartnerName", exchangePartnerName);
    }

    public static void setMPDPackageCode(final Element e, final String packageCode) {
        final Profile theMPDProfile = e.getNearestPackage().getAppliedProfile(Model_Package_Description_Profile);
        final Enumeration classCode = (Enumeration) theMPDProfile.getOwnedType("ModelPackageDescriptionClassCode");
        setTaggedValue(e, getAppliedMpdStereotype(e), "mpdClassCode", classCode.getOwnedLiteral(packageCode));
    }

    private static String formatXSDDate(final Date d) {
        return new StringBuilder(new SimpleDateFormat(XSD_DATE_FORMAT).format(d)).insert(13, ':').toString();
    }

    public static String getSubstitutionGroupName(final Property p) {
        return getXSDElementQualifiedName(p);
    }

    private static String getXSDElementQualifiedName(final Property p) {
        return new StringBuilder()
                .append(org.search.niem.uml.library.Activator.INSTANCE.toPrefix(findTargetNamespace(p.getNearestPackage())))
                .append(':').append(UMLExt.getName(p)).toString();
    }

    public static boolean isXmlPrimitiveType(final EObject e) {
        return e != null && e.eResource().getURI().lastSegment().startsWith("XmlPrimitiveTypes");
    }

    private static EClass getThePOCType(final Element theMPD) {
        return (EClass) theMPD.getStereotypeApplication(getAppliedMpdStereotype(theMPD)).eClass()
                .getEStructuralFeature("POC").getEType();
    }

    public static EObject createPOC(final Element theMPD) {
        final EClass thePOCType = getThePOCType(theMPD);
        final EFactory theFactory = thePOCType.getEPackage().getEFactoryInstance();
        final EObject thePOCTypeInstance = theFactory.create(thePOCType);
        return thePOCTypeInstance;
    }

    public static EObject createPOC(final Element theMPD, final String name, final List<String> emails,
            final List<String> phoneNumbers) {
        final EObject thePOCTypeInstance = createPOC(theMPD);
        setMPDPointOfContactName(thePOCTypeInstance, name);
        setMPDPointOfContactEmailAddresses(thePOCTypeInstance, emails);
        setMPDPointOfContactPhoneNumbers(thePOCTypeInstance, phoneNumbers);
        return thePOCTypeInstance;
    }

    public static boolean namesMatch(final EObject aReferenceLibraryElement, final EObject aPIMElement) {
        return niemNameMatches(aPIMElement, aReferenceLibraryElement)
                || namesMatch(UMLExt.getName(aPIMElement), UMLExt.getName(aReferenceLibraryElement));
    }

    private static boolean niemNameMatches(final EObject pimElement, final EObject referenceLibraryElement) {
        if (hasNiemName(pimElement)) {
            final String niemName = getReferenceNiemName((Element) pimElement);
            if (!isBlank(niemName)) {
                return namesMatch(niemName, UMLExt.getName(referenceLibraryElement));
            }
        }
        return false;
    }

    private static boolean namesMatch(final String pimElementName, final String referenceLibraryElementName) {
        return areEqual(referenceLibraryElementName, pimElementName) || referenceLibraryElementName.endsWith("Type")
                && areEqual(referenceLibraryElementName, pimElementName + "Type");
    }

    private static boolean areEqual(final Object left, final Object right) {
        return ObjectUtils.equals(left, right);
    }

}
