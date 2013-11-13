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
package org.search.niem.uml.qvt;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.mpd.Constants.BASE_MPD_NAMESPACE;
import static org.search.niem.mpd.Constants.NATURE_TYPE;
import static org.search.niem.mpd.Constants.PURPOSE_TYPE;
import static org.search.niem.mpd.cat.util.CatExt.getCatalogFileExtensions;
import static org.search.niem.mpd.cat.util.CatExt.isACatalog;
import static org.search.niem.uml.qvt.util.NIEMXsdUtil.addAppinfo;
import static org.search.niem.uml.qvt.util.NIEMXsdUtil.findElementByTag;
import static org.search.niem.uml.qvt.util.NIEMXsdUtil.setAppinfoAttributes;
import static org.search.niem.uml.resources.Activator.getNiemUmlProfile;
import static org.search.niem.uml.resources.Activator.getXmlPrimitiveTypes;
import static org.search.niem.uml.util.NIEMTypes.NIEM_PIM_Profile;
import static org.search.niem.uml.util.NIEMUmlExt.createPOC;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDPointsOfContact;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceAddress;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceName;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDAuthoritativeSourceWebsiteURL;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDBaseURI;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDCreationDate;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDDescription;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDDomains;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDExchangePartnerName;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDExchangePatternText;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDKeywords;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPackageCode;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPointOfContactEmailAddresses;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPointOfContactName;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPointOfContactPhoneNumbers;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDPurpose;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDSecurityMarking;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDStatusText;
import static org.search.niem.uml.util.NIEMUmlExt.setMPDVersionID;
import static org.search.niem.uml.util.UMLExt.copyAttributes;
import static org.search.niem.uml.util.UMLExt.getStereotypeValue;
import static org.search.niem.uml.util.UMLExt.remove;
import static org.search.niem.uml.util.UMLExt.setStereotypeValue;
import static org.search.niem.uml.util.URIExt.appendPath;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDSchema;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.FileSetType;
import org.search.niem.mpd.cat.FileType;
import org.search.niem.mpd.cat.FolderType;
import org.search.niem.mpd.cat.util.CatExt;
import org.search.niem.uml.util.UMLExt;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NiemQvtLibrary {

    // TODO: true if the context Element can be modified (i.e., not a library or shared resource)
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static boolean isEditable(final Element self) {
        return true;
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static boolean IsStereotypeApplied(final Element self, final Stereotype stereotype) {
        return self.isStereotypeApplied(stereotype);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void removeElement(final Element self) {
        remove(self);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static EObject ApplyStereotype(final Element self, final Stereotype stereotype) {
        if (!self.isStereotypeApplicable(stereotype)) {
            Activator.INSTANCE.log("The stereotype " + stereotype.getName() + " is not applicable to "
                    + self.eClass().getName() + "!");
            return null;
        }
        if (self instanceof NamedElement && "PetAdoptionIEPD".equalsIgnoreCase(((NamedElement) self).getName())) {
            Activator.INSTANCE.log("Applying the stereotype " + stereotype.getName() + " to PetAdoptionIEPD");
        }
        return self.applyStereotype(stereotype);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setLower(final MultiplicityElement self, final Integer lower) {
        self.setLower(lower);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setUpper(final MultiplicityElement self, final Integer upper) {
        self.setUpper(upper);
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static EObject GetStereotypeApplication(final Element self, final Stereotype stereotype) {
        return self.getStereotypeApplication(stereotype);
    }

    /*
     * Stereotype instance tag value setters. Context is an applied stereotype instance. Argument is value of tag to be set.
     * In the case of Enumerations, argument is the String value of the EnumerationLiteral name
     * 
     * These are abstract to reflect variations of Stereotype instance implementations, which typically are either A UML
     * InstanceSpecification A dynamic CMOF meta-model implementation
     */
    // set <<InformationModel>> defaultPurpose
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setInformationModelDefaultPurpose(final EObject self, final String defaultPurpose) {
        final Package informationModel = (Package) getBaseElement(self);
        final Profile theAppliedProfile = informationModel.getAppliedProfile(NIEM_PIM_Profile, true);
        final Enumeration defaultPurposeCode = (Enumeration) theAppliedProfile.getOwnedType("DefaultPurposeCode");
        setStereotypeValue(self, "defaultPurpose", defaultPurposeCode.getOwnedLiteral(defaultPurpose));
    }

    // set <<Namespace>> isConformant
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setSchemaAppinfoConformantIndicator(final EObject self, final Boolean isConformant) {
        setStereotypeValue(self, "isConformant", isConformant);
    }

    // set <<Namespace>> version
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setSchemaVersion(final EObject self, final String version) {
        setStereotypeValue(self, "version", version);
    }

    // set <<Namespace>> targetNamespace
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setSchemaNamespace(final EObject self, final String targetNamespace) {
        setStereotypeValue(self, "targetNamespace", targetNamespace);
    }

    // set <<ModelPackageDescriptionFile>> externalURI
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileTypeExternalURI(final EObject self, final String externalURI) {
        setStereotypeValue(self, "externalURI", externalURI);
    }

    // set <<ModelPackageDescriptionFile>> natureCode (argument is full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileTypeNatureCode(final EObject self, final String natureCode) {
        setStereotypeValue(self, "natureCode", fromURI(self, "natureCode", natureCode));
    }

    // set <<ModelPackageDescriptionFile>> purposeCode (argument is full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileTypePurposeCode(final EObject self, final String purposeCode) {
        setStereotypeValue(self, "purposeCode", fromURI(self, "purposeCode", purposeCode));
    }

    // set <<ModelPackageDescriptionFile>> relativePathName
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileTypeRelativePathName(final EObject self, final String relativePathName) {
        setStereotypeValue(self, "relativePathName", relativePathName);
    }

    // set <<ModelPackageDescriptionFile>> descriptionText
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileTypeDescriptionText(final EObject self, final String descriptionText) {
        setStereotypeValue(self, "descriptionText", descriptionText);
    }

    // set <<ModelPackageDescriptionFileSet>> natureCode (argument is full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileSetTypeNatureURI(final EObject self, final String natureCode) {
        setStereotypeValue(self, "natureCode", fromURI(self, "natureCode", natureCode));
    }

    // set <<ModelPackageDescriptionFileSet>> purposeCode (argument is full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileSetTypePurposeURI(final EObject self, final String purposeCode) {
        setStereotypeValue(self, "purposeCode", fromURI(self, "purposeCode", purposeCode));
    }

    // set <<XSDProperty>> kind
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMPropertyKind(final EObject self, final String kind) {
        setStereotypeValue(self, "kind", kind);
    }

    // set <<XSDProperty>> nillable
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMPropertyNillable(final EObject self, final Boolean nillable) {
        setStereotypeValue(self, "nillable", nillable);
    }

    // set <<ValueRestriction>> fractionDigits
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeFractionDigits(final EObject self, final Integer fractionDigits) {
        setStereotypeValue(self, "fractionDigits", fractionDigits);
    }

    // set <<ValueRestriction>> length
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeLength(final EObject self, final Integer length) {
        setStereotypeValue(self, "length", length);
    }

    // set <<ValueRestriction>> maxLength
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMaxLength(final EObject self, final Integer maxLength) {
        setStereotypeValue(self, "maxLength", maxLength);
    }

    // set <<ValueRestriction>> minLength
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMinLength(final EObject self, final Integer minLength) {
        setStereotypeValue(self, "minLength", minLength);
    }

    // set <<ValueRestriction>> maxExclusive
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMaxExclusive(final EObject self, final String maxExclusive) {
        setStereotypeValue(self, "maxExclusive", maxExclusive);
    }

    // set <<ValueRestriction>> maxInclusive
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMaxInclusive(final EObject self, final String maxInclusive) {
        setStereotypeValue(self, "maxInclusive", maxInclusive);
    }

    // set <<ValueRestriction>> minExclusive
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMinExclusive(final EObject self, final String minExclusive) {
        setStereotypeValue(self, "minExclusive", minExclusive);
    }

    // set <<ValueRestriction>> minInclusive
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeMinInclusive(final EObject self, final String minInclusive) {
        setStereotypeValue(self, "minInclusive", minInclusive);
    }

    // set <<ValueRestriction>> totalDigits
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeTotalDigits(final EObject self, final Integer totalDigits) {
        setStereotypeValue(self, "totalDigits", totalDigits);
    }

    // set <<XSDRepresentationRestriction>> whiteSpace
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypeWhiteSpace(final EObject self, final String whiteSpace) {
        setStereotypeValue(self, "whiteSpace", whiteSpace);
    }

    // set <<ValueRestriction>> pattern
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMSimpleTypePattern(final EObject self, final List<String> pattern) {
        setStereotypeValue(self, "pattern", pattern == null ? Collections.emptyList() : pattern);
    }

    // set <<XSDAnyProperty>> processContents
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMAnyPropertyProcessContents(final EObject self, final String processContents) {
        setStereotypeValue(self, "processContents", fromName(self, "processContents", processContents)); // TODO: What is
                                                                                                         // going on here?
    }

    // set <<XSDAnyProperty>> valueNamespace
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setNIEMAnyPropertyValueNamespace(final EObject self, final String valueNamespace) {
        setStereotypeValue(self, "valueNamespace", valueNamespace);
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Boolean isCatalogFolderType(final Object self) {
        return CatPackage.Literals.FOLDER_TYPE.isInstance(self);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void addCatalogFileSet(final CatalogType self, final FileSetType folder) {
        CatExt.addCatalogFileSet(self, folder);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void addCatalogFolder(final CatalogType self, final FolderType folderIn) {
        CatExt.addCatalogFolder(self, folderIn);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void addCatalogFile(final CatalogType self, final FileType fileIn) {
        CatExt.addCatalogFile(self, fileIn);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void addFileSetFiles(final FileSetType self, final String value) {
        if (self.getFiles() == null) {
            self.setFiles(new ArrayList<>(asList(value)));
        } else {
            self.getFiles().add(value);
        }
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileTypePurposeURI(final EObject self) {
        return uriFromEnumerationLiteral(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "purposeCode"), PURPOSE_TYPE);
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileTypeNatureURI(final EObject self) {
        return uriFromEnumerationLiteral(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "natureCode"), NATURE_TYPE);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void splitSchemas(final EObject self, final EObject referenceTarget) {
        // TODO: WTF is this doing?
        // throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * Stereotype instance tag value getters. Context is an applied stereotype instance. The value of tag on the Stereotype
     * instance is returned. In the case of Enumerations, return value is the String value of the EnumerationLiteral name
     * 
     * These are abstract to reflect variations of Stereotype instance implementations, which typically are either A UML
     * InstanceSpecification A dynamic CMOF meta-model implementation
     */

    // get <<InformationModel>> defaultPurpose
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getInformationModelDefaultPurpose(final EObject self) {
        return UMLExt.getName(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "defaultPurpose"));
    }

    // get <<Namespace>> targetNamespace
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getSchemaTargetNamespace(final EObject self) {
        return getStereotypeValue(self, "targetNamespace");
    }

    // get <<Namespace>> isConformant
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Boolean getPimSchemaConformantIndicator(final EObject self) {
        return getStereotypeValue(self, "isConformant");
    }

    // get <<Namespace>> version
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getPimSchemaVersion(final EObject self) {
        return getStereotypeValue(self, "version");
    }

    // get <<ValueRestriction>> fractionDigits
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Integer getNIEMSimpleTypeFractionDigits(final EObject self) {
        return getStereotypeValue(self, "fractionDigits", true);
    }

    // get <<ValueRestriction>> length
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Integer getNIEMSimpleTypeLength(final EObject self) {
        return getStereotypeValue(self, "length", true);
    }

    // get <<ValueRestriction>> maxLength
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Integer getNIEMSimpleTypeMaxLength(final EObject self) {
        return getStereotypeValue(self, "maxLength", true);
    }

    // get <<ValueRestriction>> minLength
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Integer getNIEMSimpleTypeMinLength(final EObject self) {
        return getStereotypeValue(self, "minLength", true);
    }

    // get <<ValueRestriction>> totalDigits
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Integer getNIEMSimpleTypeTotalDigits(final EObject self) {
        return getStereotypeValue(self, "totalDigits", true);
    }

    // get <<ValueRestriction>> pattern
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getNIEMSimpleTypePattern(final EObject self) {
        return getStereotypeValue(self, "pattern", true);
    }

    // get <<ValueRestriction>> maxExclusive
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getNIEMSimpleTypeMaxExclusive(final EObject self) {
        return getStereotypeValue(self, "maxExclusive", true);
    }

    // get <<ValueRestriction>> maxInclusive
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getNIEMSimpleTypeMaxInclusive(final EObject self) {
        return getStereotypeValue(self, "maxInclusive", true);
    }

    // get <<ValueRestriction>> minExclusive
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getNIEMSimpleTypeMinExclusive(final EObject self) {
        return getStereotypeValue(self, "minExclusive", true);
    }

    // get <<ValueRestriction>> minInclusive
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getNIEMSimpleTypeMinInclusive(final EObject self) {
        return getStereotypeValue(self, "minInclusive", true);
    }

    // get <<XSDRepresentationRestriction>> whiteSpace
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getXSDRepresentationRestrictionWhiteSpace(final EObject self) {
        return getStereotypeValue(self, "whiteSpace");
    }

    // get <<XSDProperty>> kind
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getNIEMPropertyKind(final EObject self) {
        return UMLExt.getName(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "kind"));
    }

    // get <<XSDAnyProperty>> valueNamespace
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getAnyPropertyNamespace(final EObject self) {
        return getStereotypeValue(self, "valueNamespace", true);
    }

    // get <<XSDAnyProperty>> processContents
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getAnyPropertyProcessContents(final EObject self) {
        return UMLExt.getName(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "processContents"));
    }

    // get <<XSDProperty>> nillable
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Boolean getNIEMElementNillable(final EObject self) {
        return getStereotypeValue(self, "nillable");
    }

    // get <<XSDProperty>> fixed
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getXSDPropertyFixed(final EObject self) {
        return getStereotypeValue(self, "fixed");
    }

    // get <<ModelPackageDescription>> descriptionText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdDescriptionText(final EObject self) {
        return getStereotypeValue(self, "descriptionText");
    }

    // get <<ModelPackageDescription>> mpdBaseURI
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdBaseURI(final EObject self) {
        return getStereotypeValue(self, "mpdBaseURI");
    }

    // get <<ModelPackageDescription>> mpdVersionID
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdVersionID(final EObject self) {
        return getStereotypeValue(self, "mpdVersionID");
    }

    // get <<ModelPackageDescription>> SecurityMarkingText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdSecurityMarkingText(final EObject self) {
        return getStereotypeValue(self, "SecurityMarkingText");
    }

    // get <<ModelPackageDescription>> StatusText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdStatusText(final EObject self) {
        return getStereotypeValue(self, "StatusText");
    }

    // get <<ModelPackageDescription>> KeywordText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getMpdKeywordText(final EObject self) {
        return getStereotypeValue(self, "KeywordText");
    }

    // get <<ModelPackageDescription>> POC
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<EObject> getMpdPOCAsStdlib(final EObject self) {
        return getStereotypeValue(self, "POC");
    }

    // get <<ModelPackageDescription>> DomainText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getMpdDomainText(final EObject self) {
        return getStereotypeValue(self, "DomainText");
    }

    // get <<ModelPackageDescription>> PurposeText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getMpdPurposeText(final EObject self) {
        return getStereotypeValue(self, "PurposeText");
    }

    // get <<ModelPackageDescription>> ExchangePatternText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getMpdExchangePatternText(final EObject self) {
        return getStereotypeValue(self, "ExchangePatternText");
    }

    // get <<ModelPackageDescription>> ExchangePartnerName
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getMpdExchangePartnerName(final EObject self) {
        return getStereotypeValue(self, "ExchangePartnerName");
    }

    // get <<ModelPackageDescription>> ASName
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdASName(final EObject self) {
        return getStereotypeValue(self, "ASName");
    }

    // get <<ModelPackageDescription>> ASAddressText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdASAddressText(final EObject self) {
        return getStereotypeValue(self, "ASAddressText");
    }

    // get <<ModelPackageDescription>> ASWebSiteURL
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdASWebSiteURL(final EObject self) {
        return getStereotypeValue(self, "ASWebSiteURL");
    }

    // get <<ModelPackageDescription>> CreationDate
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdCreationDate(final EObject self) {
        return getStereotypeValue(self, "CreationDate");
    }

    // get <<ModelPackageDescription>> mpdClassCode
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getMpdPackageCode(final EObject self) {
        return UMLExt.<EnumerationLiteral> getStereotypeValue(self, "mpdClassCode").getName();
    }

    // get POCType POCName
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getPOCName(final EObject self) {
        return getStereotypeValue(self, "POCName");
    }

    // get POCType POCEmail
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getPOCEmail(final EObject self) {
        return getStereotypeValue(self, "POCEmail");
    }

    // get POCType POCTelephone
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<String> getPOCTelephone(final EObject self) {
        return getStereotypeValue(self, "POCTelephone");
    }

    // get <<ModelPackageDescriptionFileSet>> purposeCode (as full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileSetTypePurposeCode(final EObject self) {
        return uriFromEnumerationLiteral(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "purposeCode"), PURPOSE_TYPE);
    }

    // get <<ModelPackageDescriptionFileSet>> externalURI
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileSetExternalURI(final EObject self) {
        return getStereotypeValue(self, "externalURI");
    }

    // get <<ModelPackageDescriptionFileSet>> descriptionText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileSetDescriptionText(final EObject self) {
        return getStereotypeValue(self, "descriptionText");
    }

    // get <<ModelPackageDescriptionFile>> purposeCode (as full URI, not the abbreviated code in the Enumeration)
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileTypePurposeCode(final EObject self) {
        return uriFromEnumerationLiteral(UMLExt.<EnumerationLiteral> getStereotypeValue(self, "purposeCode"), PURPOSE_TYPE);
    }

    // get <<ModelPackageDescriptionFile>> externalURI
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileTypeExternalURI(final EObject self) {
        return getStereotypeValue(self, "externalURI");
    }

    // get <<ModelPackageDescriptionFile>> descriptionText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getFileDescriptionText(final EObject self) {
        return getStereotypeValue(self, "descriptionText");
    }

    // get <<ModelPackageDescriptionRelationship>> descriptionText
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getRelationshipDescriptionText(final EObject self) {
        return getStereotypeValue(self, "descriptionText");
    }

    // get <<ModelPackageDescriptionRelationship>> relationshipCode
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getRelationshipCode(final EObject self) {
        return getStereotypeValue(self, "relationshipCode");
    }

    /*
     * apply the stereotype to the target, copy the values of the stereotype instance context to the new stereotype instance,
     * return the new stereotype instance
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static EObject deepCloneStereotypeApplication(final EObject self, final Stereotype stereotype,
            final Element target) {
        final EObject theCopy = EcoreUtil.copy(self);
        for (final EStructuralFeature feature : theCopy.eClass().getEAllStructuralFeatures()) {
            if (feature.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
                theCopy.eSet(feature, target);
                target.eResource().getContents().add(theCopy);
                return theCopy;
            }
        }
        Activator.INSTANCE.log("Unable to find the base_ property for the copied stereotype application.");
        return null;
    }

    /*
     * apply the <<Namespace>> stereotype to the target, copy the values of the <<InformationModel>> stereotype instance
     * context to the new <<Namespace>> stereotype instance
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void cloneInformationModelToNamespace(final EObject self, final EObject target) {
        copyAttributes(self, target);
    }

    /*
     * For the context CMOF extent, For the URI of the extent, return the last segment of the URI after truncating the file
     * extension.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static String contextURI(final EObject self) {
        return self.eResource().getURI().trimFileExtension().lastSegment();
    }

    /*
     * Return a representation for the CMOF extent of the XSDSchema context
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static EObject eXtent(final XSDSchema self) {
        return self;
    }

    /*
     * Sets the QName prefix used to reference the schema for schema namespace.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setSchemaForSchema(final XSDSchema self, final String prefix, final String namespace) {
        self.setSchemaForSchemaQNamePrefix(prefix);
        setQNamePrefixToNamespace(self, prefix, namespace);
    }

    /*
     * Sets the QName prefix used to reference the given namespace.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setQNamePrefixToNamespace(final XSDSchema self, final String prefix, final String namespace) {
        final Map<String, String> namespaces = self.getQNamePrefixToNamespaceMap();
        namespaces.put(prefix, namespace);
    }

    /*
     * Return the location of the XSDSchema, relative to the root directory of the target ModelPackageDescription
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String relativeMdpLocation(final XSDSchema self) {
        final URI theSchemaURI = self.eResource().getURI();
        final File theSchemaFile;
        if (theSchemaURI.isPlatformResource()) {
            final String platformRelativePath = theSchemaURI.toPlatformString(true);
            theSchemaFile = ResourcesPlugin.getWorkspace().getRoot()
                    .findMember(Path.fromPortableString(platformRelativePath)).getLocation().toFile();
        } else {
            theSchemaFile = new File(theSchemaURI.toFileString());
        }
        File theParentDirectory = theSchemaFile.getParentFile();
        while (theParentDirectory != null) {
            if (containsACatalog(theParentDirectory)) {
                break;
            }
            theParentDirectory = theParentDirectory.getParentFile();
        }
        final String theRelativePath = theParentDirectory.toPath().relativize(theSchemaFile.toPath()).toString();
        return theRelativePath;
    }

    private static boolean containsACatalog(final File theParentDirectory) {
        final String[] catalogFileExtensions = getCatalogFileExtensions();
        for (int i = 0; i < catalogFileExtensions.length; i++) {
            catalogFileExtensions[i] = "." + catalogFileExtensions[i].toLowerCase();
        }
        final File[] files = theParentDirectory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String name) {
                final String lowerCaseName = name.toLowerCase();
                for (final String extension : catalogFileExtensions) {
                    if (lowerCaseName.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });
        for (final File f : files) {
            if (isACatalog(f)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Resolve and load the schema referenced by the XSDImport context.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void importSchema(final XSDImport self) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * Returns the value of the 'Application Information' attribute list for the XSDAnnotation context. The list contents are
     * of type org.w3c.dom.Element. This represents the application information infoset property, i.e., a list of appinfo
     * elements.
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static LinkedHashSet<Object> getXSDAnnotationApplicationInformation(final XSDAnnotation self) {
        return new LinkedHashSet<Object>(self.getApplicationInformation());
    }

    /*
     * In the context of an XSDAnnotation, creates and returns a new documentation org.w3c.dom.element using the containing
     * schema's document as the factory.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static Object createUserInformation(final XSDAnnotation self, final String sourceURI) {
        final org.w3c.dom.Element userInfo = self.createUserInformation(defaultIfBlank(sourceURI, null));
        self.getElement().appendChild(userInfo);
        return userInfo;
    }

    /*
     * In the context of an org.w3c.dom.Element, return all child org.w3c.dom.Elements
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static LinkedHashSet<Object> getElementElements(final Object self) {
        final org.w3c.dom.Element element = (org.w3c.dom.Element) self;
        final NodeList childNodes = element.getChildNodes();
        final LinkedHashSet<Object> childElements = new LinkedHashSet<>();
        for (int i = 0; i < childNodes.getLength(); i++) {
            final Node childNode = childNodes.item(i);
            if (childNode instanceof org.w3c.dom.Element) {
                childElements.add(childNode);
            }
        }
        return childElements;
    }

    /*
     * In the context of an org.w3c.dom.Element, return the text content.
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getXSDElementValue(final Object self) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * In the context of an org.w3c.dom.Element, return the name.
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getElementName(final Object self) {
        final org.w3c.dom.Element element = (org.w3c.dom.Element) self;
        final String theNodeName = element.getNodeName();
        return theNodeName;
    }

    /*
     * In the context of an org.w3c.dom.Element, return the namespace.
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getElementNamespace(final Object self) {
        final org.w3c.dom.Element element = (org.w3c.dom.Element) self;
        final String namespaceURI = element.getNamespaceURI();
        return namespaceURI;
    }

    /*
     * In the context of an org.w3c.dom.Element, set the textContent to provided value.
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setTextContent(final Object self, final String value) {
        final org.w3c.dom.Element userInfo = (org.w3c.dom.Element) self;
        userInfo.appendChild(userInfo.getOwnerDocument().createTextNode(value));
    }

    /*
     * in the context of an org.w3c.dom.Element, commit any changes to Element or its components (if necessary)
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void commitInformation(final Object self) {
        // no-op
    }

    /*
     * in the context of an XSDAnnotation, create or update an applicationInformation element, for the given name within the
     * NIEM appinfo2 namespace, setting its textual content to the provided value
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setAppinfo2Element(final XSDAnnotation self, final String value, final XSDSchema owningSchema,
            final String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * in the context of an XSDAnnotation, create or update an applicationInformation element, for the given name within the
     * NIEM appinfo namespace, setting its textual content to the provided value
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setAppinfoElementValue(final XSDAnnotation self, final String value, final String name) {
        final org.w3c.dom.Element element = findElementByTag(self, name);
        if (element == null) {
            addAppinfo(self, name, value);
        } else {
            element.setTextContent(value);
        }
    }

    /*
     * in the context of an XSDAnnotation, create or update an applicationInformation element, for the given elementName
     * within the NIEM appinfo namespace, set the appinfo:name attribute to the provided name and set the appinfo:namespace
     * to the provided namespace in the case of elementName='AppliesTo', always add an element; in all other cases, replace
     * content of any existing element matching elementName (or add new element if no match)
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setAppinfoElement(final XSDAnnotation self, final String elementName, final String name,
            final String namespace) {
        if ("i:AppliesTo".equals(elementName)) {
            addAppinfo(self, elementName, name, namespace);
            return;
        }
        final org.w3c.dom.Element element = findElementByTag(self, elementName);
        if (element == null) {
            addAppinfo(self, elementName, name, namespace);
        } else {
            setAppinfoAttributes(element, name, namespace);
        }
    }

    /*
     * in the context of an org.w3c.dom.Element return the value of the appinfo:name attribute
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getAppInfoName(final Object self) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * in the context of an org.w3c.dom.Element return the value of the appinfo:namespace attribute
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static String getAppInfoNamespace(final Object self) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * in the context of an org.w3c.dom.Element, return whether or not there is an appinfo:namespace attribute
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Boolean hasAppinfoNamespaceAttribute(final Object self, final String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * in the context of an org.w3c.dom.Element, return whether or not there is an appinfo:name attribute
     */
    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Boolean hasAppinfoNameAttribute(final Object self, final String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
     * in the context of an XSDAnnotation, map the textual content of UserInformation to the body of a new Comment and append
     * the new Comment to the ownedComments of the owner
     */
    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static Boolean mapXSDAnnotation(final XSDAnnotation self, final Element owner) {
        final Iterator<org.w3c.dom.Element> elements = self.getUserInformation().iterator();
        if (elements.hasNext()) {
            final Comment theComment = UMLFactory.eINSTANCE.createComment();
            final StringBuilder b = new StringBuilder();
            b.append(elements.next().getTextContent());
            while (elements.hasNext()) {
                b.append('\n');
                b.append(elements.next().getTextContent());
            }
            theComment.setBody(b.toString());
            owner.getOwnedComments().add(theComment);
            return true;
        }
        return false;
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static EObject getSchemaAtRelativeUri(final EObject self, final String relativeURI) {
        final Resource theMPDResource = self.eResource();
        return theMPDResource.getResourceSet()
                .getResource(appendPath(theMPDResource.getURI().trimSegments(1), relativeURI), true).getContents().get(0);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileSetTypeDescriptionText(final EObject self, final String descriptionText) {
        setStereotypeValue(self, "descriptionText", descriptionText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setFileSetTypeExternalURI(final EObject self, final String externalURI) {
        setStereotypeValue(self, "externalURI", externalURI);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdVersionID(final EObject self, final String mpdVersionID) {
        setMPDVersionID(getBaseElement(self), mpdVersionID);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdBaseURI(final EObject self, final String mpdBaseURI) {
        setMPDBaseURI(getBaseElement(self), mpdBaseURI);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdDescriptionText(final EObject self, final String descriptionText) {
        setMPDDescription(getBaseElement(self), descriptionText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdSecurityMarkingText(final EObject self, final String securityMarkingText) {
        setMPDSecurityMarking(getBaseElement(self), securityMarkingText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdCreationDate(final EObject self, final String creationDate) {
        setMPDCreationDate(getBaseElement(self), creationDate);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdStatusText(final EObject self, final String statusText) {
        setMPDStatusText(getBaseElement(self), statusText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdKeywordText(final EObject self, final List<String> keywordText) {
        setMPDKeywords(getBaseElement(self), keywordText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdDomainText(final EObject self, final List<String> domainText) {
        setMPDDomains(getBaseElement(self), domainText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdPurposeText(final EObject self, final List<String> PurposeText) {
        setMPDPurpose(getBaseElement(self), PurposeText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdExchangePatternText(final EObject self, final List<String> ExchangePatternText) {
        setMPDExchangePatternText(getBaseElement(self), ExchangePatternText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdExchangePartnerName(final EObject self, final List<String> exchangePartnerName) {
        setMPDExchangePartnerName(getBaseElement(self), exchangePartnerName);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdASName(final EObject self, final String asName) {
        setMPDAuthoritativeSourceName(getBaseElement(self), asName);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdASAddressText(final EObject self, final String asAddressText) {
        setMPDAuthoritativeSourceAddress(getBaseElement(self), asAddressText);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdASWebSiteURL(final EObject self, final String asWebSiteURL) {
        setMPDAuthoritativeSourceWebsiteURL(getBaseElement(self), asWebSiteURL);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setPOCPOCName(final EObject self, final String pocName) {
        setMPDPointOfContactName(self, pocName);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setPOCPOCEmail(final EObject self, final List<String> pocEmail) {
        setMPDPointOfContactEmailAddresses(self, pocEmail);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setPOCPOCTelephone(final EObject self, final List<String> pocTelephone) {
        setMPDPointOfContactPhoneNumbers(self, pocTelephone);
    }

    @Operation(contextual = true, kind = Operation.Kind.HELPER)
    public static void setMpdPackageCode(final EObject self, final String packageCode) {
        setMPDPackageCode(getBaseElement(self), packageCode);
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static EObject getMpdPocList(final EObject self) { // misnomer - this really returns the mpd stereotype
                                                              // application itself
        return self;
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static EObject createPocInstance(final EObject self) {
        final List<EObject> pointsOfContact = getMPDPointsOfContact(getBaseElement(self));
        final EObject thePOC = createPOC(getBaseElement(self));
        pointsOfContact.add(thePOC);
        return thePOC;
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static List<Profile> getNIEMProfiles(final Model self) {
        return new ArrayList<>(EcoreUtil.<Profile> getObjectsByType(
                ((Package) getNiemUmlProfile(self.eResource().getResourceSet()).getContents().get(0)).getNestedPackages(),
                UMLPackage.Literals.PROFILE));
    }

    @Operation(contextual = true, kind = Operation.Kind.QUERY)
    public static Model getNIEMXmlLibrary(final Model self) {
        return (Model) getXmlPrimitiveTypes(self.eResource().getResourceSet()).getContents().get(0);
    }

    /*
     * 
     * 
     * self.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, folder); }
     * 
     * @Operation(contextual = true, kind = Operation.Kind.HELPER) public static void addCatalogFolder(final CatalogType
     * self, final FolderType folderIn) { self.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FOLDER, folderIn); }
     * 
     * @Operation(contextual = true, kind = Operation.Kind.HELPER) public static void addCatalogFile(final CatalogType self,
     * final FileType fileIn) { self.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FILE, fileIn);
     */

    private static String uriFromEnumerationLiteral(final EnumerationLiteral stereotypeValue, final String type) {
        return stereotypeValue == null ? null : BASE_MPD_NAMESPACE + type + "#"
                + stereotypeValue.getName().replaceAll("_", "-");
    }

    private static EEnumLiteral fromURI(final EObject stereotypeApplication, final String structuralFeatureName,
            final String uri) {
        if (uri == null) {
            return null;
        }
        final int index = uri.indexOf('#');
        return index < 0 || index == uri.length() - 1 ? null : fromName(stereotypeApplication, structuralFeatureName,
                uri.substring(index + 1));
    }

    private static EEnumLiteral fromName(final EObject stereotypeApplication, final String structuralFeatureName,
            final String name) {
        return ((EEnum) stereotypeApplication.eClass().getEStructuralFeature(structuralFeatureName).getEType())
                .getEEnumLiteral(name.replaceAll("-", "_"));
    }
}
