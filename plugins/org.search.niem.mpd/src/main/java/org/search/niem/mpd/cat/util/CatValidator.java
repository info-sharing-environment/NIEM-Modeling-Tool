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
package org.search.niem.mpd.cat.util;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;
import org.search.niem.mpd.cat.AuthoritativeSourceType;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.DocumentRoot;
import org.search.niem.mpd.cat.FileSetType;
import org.search.niem.mpd.cat.FileType;
import org.search.niem.mpd.cat.FolderType;
import org.search.niem.mpd.cat.MPDClassCodeSimpleType;
import org.search.niem.mpd.cat.MetadataType;
import org.search.niem.mpd.cat.POCType;
import org.search.niem.mpd.cat.RelationshipCodeSimpleType;
import org.search.niem.mpd.cat.RelationshipType;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage
 * @generated
 */
public class CatValidator extends EObjectValidator {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final CatValidator INSTANCE = new CatValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic
     * {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.search.niem.mpd.cat";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * The cached base package validator. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected XMLTypeValidator xmlTypeValidator;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CatValidator() {
        super();
        xmlTypeValidator = XMLTypeValidator.INSTANCE;
    }

    /**
     * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return CatPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean validate(final int classifierID, final Object value, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        switch (classifierID) {
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE:
            return validateAuthoritativeSourceType((AuthoritativeSourceType) value, diagnostics, context);
        case CatPackage.CATALOG_TYPE:
            return validateCatalogType((CatalogType) value, diagnostics, context);
        case CatPackage.DOCUMENT_ROOT:
            return validateDocumentRoot((DocumentRoot) value, diagnostics, context);
        case CatPackage.FILE_SET_TYPE:
            return validateFileSetType((FileSetType) value, diagnostics, context);
        case CatPackage.FILE_TYPE:
            return validateFileType((FileType) value, diagnostics, context);
        case CatPackage.FOLDER_TYPE:
            return validateFolderType((FolderType) value, diagnostics, context);
        case CatPackage.METADATA_TYPE:
            return validateMetadataType((MetadataType) value, diagnostics, context);
        case CatPackage.POC_TYPE:
            return validatePOCType((POCType) value, diagnostics, context);
        case CatPackage.RELATIONSHIP_TYPE:
            return validateRelationshipType((RelationshipType) value, diagnostics, context);
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE:
            return validateMPDClassCodeSimpleType((MPDClassCodeSimpleType) value, diagnostics, context);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE:
            return validateRelationshipCodeSimpleType((RelationshipCodeSimpleType) value, diagnostics, context);
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT:
            return validateMPDClassCodeSimpleTypeObject((MPDClassCodeSimpleType) value, diagnostics, context);
        case CatPackage.MPD_VERSION_ID_SIMPLE_TYPE:
            return validateMPDVersionIDSimpleType((String) value, diagnostics, context);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT:
            return validateRelationshipCodeSimpleTypeObject((RelationshipCodeSimpleType) value, diagnostics, context);
        case CatPackage.SAFE_CURIE_SIMPLE_TYPE:
            return validateSafeCurieSimpleType((String) value, diagnostics, context);
        case CatPackage.URI_SIMPLE_TYPE:
            return validateURISimpleType((String) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateAuthoritativeSourceType(final AuthoritativeSourceType authoritativeSourceType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(authoritativeSourceType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateCatalogType(final CatalogType catalogType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(catalogType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateDocumentRoot(final DocumentRoot documentRoot, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateFileSetType(final FileSetType fileSetType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(fileSetType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateFileType(final FileType fileType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(fileType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateFolderType(final FolderType folderType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(folderType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateMetadataType(final MetadataType metadataType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(metadataType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validatePOCType(final POCType pocType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(pocType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRelationshipType(final RelationshipType relationshipType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(relationshipType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateMPDClassCodeSimpleType(final MPDClassCodeSimpleType mpdClassCodeSimpleType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRelationshipCodeSimpleType(final RelationshipCodeSimpleType relationshipCodeSimpleType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateMPDClassCodeSimpleTypeObject(final MPDClassCodeSimpleType mpdClassCodeSimpleTypeObject,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateMPDVersionIDSimpleType(final String mpdVersionIDSimpleType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = validateMPDVersionIDSimpleType_Pattern(mpdVersionIDSimpleType, diagnostics, context);
        if (result || diagnostics != null) {
            result &= validateMPDVersionIDSimpleType_MinLength(mpdVersionIDSimpleType, diagnostics, context);
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @see #validateMPDVersionIDSimpleType_Pattern
     */
    public static final PatternMatcher[][] MPD_VERSION_ID_SIMPLE_TYPE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
            .createPatternMatcher("[0-9]+(\\.[0-9]+)*((alpha|beta|rc|rev)[0-9]+)?") } };

    /**
     * Validates the Pattern constraint of '<em>MPD Version ID Simple Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public boolean validateMPDVersionIDSimpleType_Pattern(final String mpdVersionIDSimpleType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return validatePattern(CatPackage.Literals.MPD_VERSION_ID_SIMPLE_TYPE, mpdVersionIDSimpleType,
                MPD_VERSION_ID_SIMPLE_TYPE__PATTERN__VALUES, diagnostics, context);
    }

    /**
     * Validates the MinLength constraint of '<em>MPD Version ID Simple Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public boolean validateMPDVersionIDSimpleType_MinLength(final String mpdVersionIDSimpleType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        final int length = mpdVersionIDSimpleType.length();
        final boolean result = length >= 1;
        if (!result && diagnostics != null) {
            reportMinLengthViolation(CatPackage.Literals.MPD_VERSION_ID_SIMPLE_TYPE, mpdVersionIDSimpleType, length, 1,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateRelationshipCodeSimpleTypeObject(
            final RelationshipCodeSimpleType relationshipCodeSimpleTypeObject, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateSafeCurieSimpleType(final String safeCurieSimpleType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        boolean result = validateSafeCurieSimpleType_Pattern(safeCurieSimpleType, diagnostics, context);
        if (result || diagnostics != null) {
            result &= validateSafeCurieSimpleType_MinLength(safeCurieSimpleType, diagnostics, context);
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @see #validateSafeCurieSimpleType_Pattern
     */
    public static final PatternMatcher[][] SAFE_CURIE_SIMPLE_TYPE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
            .createPatternMatcher("\\[(([\\i-[:]][\\c-[:]]*)?:)?.+\\]") } };

    /**
     * Validates the Pattern constraint of '<em>Safe Curie Simple Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateSafeCurieSimpleType_Pattern(final String safeCurieSimpleType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return validatePattern(CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE, safeCurieSimpleType,
                SAFE_CURIE_SIMPLE_TYPE__PATTERN__VALUES, diagnostics, context);
    }

    /**
     * Validates the MinLength constraint of '<em>Safe Curie Simple Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateSafeCurieSimpleType_MinLength(final String safeCurieSimpleType,
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        final int length = safeCurieSimpleType.length();
        final boolean result = length >= 3;
        if (!result && diagnostics != null) {
            reportMinLengthViolation(CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE, safeCurieSimpleType, length, 3,
                    diagnostics, context);
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateURISimpleType(final String uriSimpleType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        final boolean result = validateURISimpleType_MemberTypes(uriSimpleType, diagnostics, context);
        return result;
    }

    /**
     * Validates the MemberTypes constraint of '<em>URI Simple Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateURISimpleType_MemberTypes(final String uriSimpleType, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (diagnostics != null) {
            final BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
            if (XMLTypePackage.Literals.ANY_URI.isInstance(uriSimpleType)) {
                if (xmlTypeValidator.validateAnyURI(uriSimpleType, tempDiagnostics, context)) {
                    return true;
                }
            }
            if (CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE.isInstance(uriSimpleType)) {
                if (validateSafeCurieSimpleType(uriSimpleType, tempDiagnostics, context)) {
                    return true;
                }
            }
            for (final Diagnostic diagnostic : tempDiagnostics.getChildren()) {
                diagnostics.add(diagnostic);
            }
        } else {
            if (XMLTypePackage.Literals.ANY_URI.isInstance(uriSimpleType)) {
                if (xmlTypeValidator.validateAnyURI(uriSimpleType, null, context)) {
                    return true;
                }
            }
            if (CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE.isInstance(uriSimpleType)) {
                if (validateSafeCurieSimpleType(uriSimpleType, null, context)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} // CatValidator
