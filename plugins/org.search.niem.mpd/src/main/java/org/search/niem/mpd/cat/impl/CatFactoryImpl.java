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
package org.search.niem.mpd.cat.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.search.niem.mpd.cat.AuthoritativeSourceType;
import org.search.niem.mpd.cat.CatFactory;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CatFactoryImpl extends EFactoryImpl implements CatFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static CatFactory init() {
        try {
            final CatFactory theCatFactory = (CatFactory) EPackage.Registry.INSTANCE.getEFactory(CatPackage.eNS_URI);
            if (theCatFactory != null) {
                return theCatFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CatFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CatFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE:
            return createAuthoritativeSourceType();
        case CatPackage.CATALOG_TYPE:
            return createCatalogType();
        case CatPackage.DOCUMENT_ROOT:
            return createDocumentRoot();
        case CatPackage.FILE_SET_TYPE:
            return createFileSetType();
        case CatPackage.FILE_TYPE:
            return createFileType();
        case CatPackage.FOLDER_TYPE:
            return createFolderType();
        case CatPackage.METADATA_TYPE:
            return createMetadataType();
        case CatPackage.POC_TYPE:
            return createPOCType();
        case CatPackage.RELATIONSHIP_TYPE:
            return createRelationshipType();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(final EDataType eDataType, final String initialValue) {
        switch (eDataType.getClassifierID()) {
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE:
            return createMPDClassCodeSimpleTypeFromString(eDataType, initialValue);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE:
            return createRelationshipCodeSimpleTypeFromString(eDataType, initialValue);
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT:
            return createMPDClassCodeSimpleTypeObjectFromString(eDataType, initialValue);
        case CatPackage.MPD_VERSION_ID_SIMPLE_TYPE:
            return createMPDVersionIDSimpleTypeFromString(eDataType, initialValue);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT:
            return createRelationshipCodeSimpleTypeObjectFromString(eDataType, initialValue);
        case CatPackage.SAFE_CURIE_SIMPLE_TYPE:
            return createSafeCurieSimpleTypeFromString(eDataType, initialValue);
        case CatPackage.URI_SIMPLE_TYPE:
            return createURISimpleTypeFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(final EDataType eDataType, final Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE:
            return convertMPDClassCodeSimpleTypeToString(eDataType, instanceValue);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE:
            return convertRelationshipCodeSimpleTypeToString(eDataType, instanceValue);
        case CatPackage.MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT:
            return convertMPDClassCodeSimpleTypeObjectToString(eDataType, instanceValue);
        case CatPackage.MPD_VERSION_ID_SIMPLE_TYPE:
            return convertMPDVersionIDSimpleTypeToString(eDataType, instanceValue);
        case CatPackage.RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT:
            return convertRelationshipCodeSimpleTypeObjectToString(eDataType, instanceValue);
        case CatPackage.SAFE_CURIE_SIMPLE_TYPE:
            return convertSafeCurieSimpleTypeToString(eDataType, instanceValue);
        case CatPackage.URI_SIMPLE_TYPE:
            return convertURISimpleTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AuthoritativeSourceType createAuthoritativeSourceType() {
        final AuthoritativeSourceTypeImpl authoritativeSourceType = new AuthoritativeSourceTypeImpl();
        return authoritativeSourceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CatalogType createCatalogType() {
        final CatalogTypeImpl catalogType = new CatalogTypeImpl();
        return catalogType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DocumentRoot createDocumentRoot() {
        final DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileSetType createFileSetType() {
        final FileSetTypeImpl fileSetType = new FileSetTypeImpl();
        return fileSetType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileType createFileType() {
        final FileTypeImpl fileType = new FileTypeImpl();
        return fileType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FolderType createFolderType() {
        final FolderTypeImpl folderType = new FolderTypeImpl();
        return folderType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MetadataType createMetadataType() {
        final MetadataTypeImpl metadataType = new MetadataTypeImpl();
        return metadataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public POCType createPOCType() {
        final POCTypeImpl pocType = new POCTypeImpl();
        return pocType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RelationshipType createRelationshipType() {
        final RelationshipTypeImpl relationshipType = new RelationshipTypeImpl();
        return relationshipType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MPDClassCodeSimpleType createMPDClassCodeSimpleTypeFromString(final EDataType eDataType, final String initialValue) {
        final MPDClassCodeSimpleType result = MPDClassCodeSimpleType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertMPDClassCodeSimpleTypeToString(final EDataType eDataType, final Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RelationshipCodeSimpleType createRelationshipCodeSimpleTypeFromString(final EDataType eDataType,
            final String initialValue) {
        final RelationshipCodeSimpleType result = RelationshipCodeSimpleType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertRelationshipCodeSimpleTypeToString(final EDataType eDataType, final Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MPDClassCodeSimpleType createMPDClassCodeSimpleTypeObjectFromString(final EDataType eDataType,
            final String initialValue) {
        return createMPDClassCodeSimpleTypeFromString(CatPackage.Literals.MPD_CLASS_CODE_SIMPLE_TYPE, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertMPDClassCodeSimpleTypeObjectToString(final EDataType eDataType, final Object instanceValue) {
        return convertMPDClassCodeSimpleTypeToString(CatPackage.Literals.MPD_CLASS_CODE_SIMPLE_TYPE, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String createMPDVersionIDSimpleTypeFromString(final EDataType eDataType, final String initialValue) {
        return (String) XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.TOKEN, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertMPDVersionIDSimpleTypeToString(final EDataType eDataType, final Object instanceValue) {
        return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.TOKEN, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RelationshipCodeSimpleType createRelationshipCodeSimpleTypeObjectFromString(final EDataType eDataType,
            final String initialValue) {
        return createRelationshipCodeSimpleTypeFromString(CatPackage.Literals.RELATIONSHIP_CODE_SIMPLE_TYPE, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertRelationshipCodeSimpleTypeObjectToString(final EDataType eDataType, final Object instanceValue) {
        return convertRelationshipCodeSimpleTypeToString(CatPackage.Literals.RELATIONSHIP_CODE_SIMPLE_TYPE, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String createSafeCurieSimpleTypeFromString(final EDataType eDataType, final String initialValue) {
        return (String) XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertSafeCurieSimpleTypeToString(final EDataType eDataType, final Object instanceValue) {
        return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String createURISimpleTypeFromString(final EDataType eDataType, final String initialValue) {
        if (initialValue == null) {
            return null;
        }
        String result = null;
        RuntimeException exception = null;
        try {
            result = (String) XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.ANY_URI, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        } catch (final RuntimeException e) {
            exception = e;
        }
        try {
            result = createSafeCurieSimpleTypeFromString(CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        } catch (final RuntimeException e) {
            exception = e;
        }
        if (result != null || exception == null) {
            return result;
        }

        throw exception;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertURISimpleTypeToString(final EDataType eDataType, final Object instanceValue) {
        if (instanceValue == null) {
            return null;
        }
        if (XMLTypePackage.Literals.ANY_URI.isInstance(instanceValue)) {
            try {
                final String value = XMLTypeFactory.eINSTANCE
                        .convertToString(XMLTypePackage.Literals.ANY_URI, instanceValue);
                if (value != null) {
                    return value;
                }
            } catch (final Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        if (CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE.isInstance(instanceValue)) {
            try {
                final String value = convertSafeCurieSimpleTypeToString(CatPackage.Literals.SAFE_CURIE_SIMPLE_TYPE,
                        instanceValue);
                if (value != null) {
                    return value;
                }
            } catch (final Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        throw new IllegalArgumentException("Invalid value: '" + instanceValue + "' for datatype :" + eDataType.getName());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CatPackage getCatPackage() {
        return (CatPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CatPackage getPackage() {
        return CatPackage.eINSTANCE;
    }

} // CatFactoryImpl
