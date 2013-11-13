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
package org.search.niem.mpd.cat;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * Model Package Description (MPD) Catalog; XML document element = Catalog; This schema defines the catalog.xml artifact for
 * Model Package Descriptions (MPD) in NIEM. MPDs include: NIEM releases, core updates, domain updates, NIEM Information
 * Exchange Package Documentation (IEPD), and NIEM Enterprise Information Exchange Models (EIEM).
 * 
 * NOTE: The purpose of this schema is to define/declare metadata for NIEM MPDs to search, discover, and process MPDs
 * efficiently. Instances of this schema are NOT NIEM data exchanges. For this reason this schema is NOT NIEM conforming,
 * even though type definitions and element/attribute declarations generally conform to NIEM NDR naming rules.
 * 
 * <!-- end-model-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatFactory
 * @model kind="package"
 * @generated
 */
public interface CatPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "cat";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://reference.niem.gov/niem/resource/mpd/catalog/1.0/";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "cat";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    CatPackage eINSTANCE = org.search.niem.mpd.cat.impl.CatPackageImpl.init();

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl
     * <em>Authoritative Source Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getAuthoritativeSourceType()
     * @generated
     */
    int AUTHORITATIVE_SOURCE_TYPE = 0;

    /**
     * The feature id for the '<em><b>AS Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE__AS_NAME = 0;

    /**
     * The feature id for the '<em><b>AS Address Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT = 1;

    /**
     * The feature id for the '<em><b>AS Web Site URL</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL = 2;

    /**
     * The feature id for the '<em><b>POC</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE__POC = 3;

    /**
     * The number of structural features of the '<em>Authoritative Source Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Authoritative Source Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int AUTHORITATIVE_SOURCE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl <em>Catalog Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.CatalogTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getCatalogType()
     * @generated
     */
    int CATALOG_TYPE = 1;

    /**
     * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__ARTIFACT_GROUP = 0;

    /**
     * The feature id for the '<em><b>Artifact</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__ARTIFACT = 1;

    /**
     * The feature id for the '<em><b>Metadata</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__METADATA = 2;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__DESCRIPTION_TEXT = 3;

    /**
     * The feature id for the '<em><b>Mpd Class Code</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__MPD_CLASS_CODE = 4;

    /**
     * The feature id for the '<em><b>Mpd Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__MPD_NAME = 5;

    /**
     * The feature id for the '<em><b>Mpd URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__MPD_URI = 6;

    /**
     * The feature id for the '<em><b>Mpd Version ID</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE__MPD_VERSION_ID = 7;

    /**
     * The number of structural features of the '<em>Catalog Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE_FEATURE_COUNT = 8;

    /**
     * The operation id for the '<em>Set Mpd Class Code</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE___SET_MPD_CLASS_CODE__STRING = 0;

    /**
     * The number of operations of the '<em>Catalog Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATALOG_TYPE_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.DocumentRootImpl <em>Document Root</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.DocumentRootImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 2;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Artifact</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__ARTIFACT = 3;

    /**
     * The feature id for the '<em><b>AS Address Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__AS_ADDRESS_TEXT = 4;

    /**
     * The feature id for the '<em><b>AS Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__AS_NAME = 5;

    /**
     * The feature id for the '<em><b>AS Web Site URL</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__AS_WEB_SITE_URL = 6;

    /**
     * The feature id for the '<em><b>Authoritative Source</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__AUTHORITATIVE_SOURCE = 7;

    /**
     * The feature id for the '<em><b>Catalog</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CATALOG = 8;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CREATION_DATE = 9;

    /**
     * The feature id for the '<em><b>Domain Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__DOMAIN_TEXT = 10;

    /**
     * The feature id for the '<em><b>Exchange Partner Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME = 11;

    /**
     * The feature id for the '<em><b>Exchange Pattern Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT = 12;

    /**
     * The feature id for the '<em><b>File</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__FILE = 13;

    /**
     * The feature id for the '<em><b>File Set</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__FILE_SET = 14;

    /**
     * The feature id for the '<em><b>Folder</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__FOLDER = 15;

    /**
     * The feature id for the '<em><b>Keyword Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__KEYWORD_TEXT = 16;

    /**
     * The feature id for the '<em><b>Last Revision Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__LAST_REVISION_DATE = 17;

    /**
     * The feature id for the '<em><b>Metadata</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__METADATA = 18;

    /**
     * The feature id for the '<em><b>Next Revision Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__NEXT_REVISION_DATE = 19;

    /**
     * The feature id for the '<em><b>POC</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__POC = 20;

    /**
     * The feature id for the '<em><b>POC Email</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__POC_EMAIL = 21;

    /**
     * The feature id for the '<em><b>POC Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__POC_NAME = 22;

    /**
     * The feature id for the '<em><b>POC Telephone</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__POC_TELEPHONE = 23;

    /**
     * The feature id for the '<em><b>Purpose Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__PURPOSE_TEXT = 24;

    /**
     * The feature id for the '<em><b>Relationship</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__RELATIONSHIP = 25;

    /**
     * The feature id for the '<em><b>Security Marking Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__SECURITY_MARKING_TEXT = 26;

    /**
     * The feature id for the '<em><b>Status Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__STATUS_TEXT = 27;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__DESCRIPTION_TEXT = 28;

    /**
     * The feature id for the '<em><b>External URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__EXTERNAL_URI = 29;

    /**
     * The feature id for the '<em><b>Files</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__FILES = 30;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__ID = 31;

    /**
     * The feature id for the '<em><b>Mpd Class Code</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MPD_CLASS_CODE = 32;

    /**
     * The feature id for the '<em><b>Mpd Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MPD_NAME = 33;

    /**
     * The feature id for the '<em><b>Mpd URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MPD_URI = 34;

    /**
     * The feature id for the '<em><b>Mpd Version ID</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MPD_VERSION_ID = 35;

    /**
     * The feature id for the '<em><b>Nature URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__NATURE_URI = 36;

    /**
     * The feature id for the '<em><b>Purpose URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__PURPOSE_URI = 37;

    /**
     * The feature id for the '<em><b>Relationship Code</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__RELATIONSHIP_CODE = 38;

    /**
     * The feature id for the '<em><b>Relative Path Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__RELATIVE_PATH_NAME = 39;

    /**
     * The feature id for the '<em><b>Resource URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__RESOURCE_URI = 40;

    /**
     * The number of structural features of the '<em>Document Root</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 41;

    /**
     * The number of operations of the '<em>Document Root</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.FileSetTypeImpl <em>File Set Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.FileSetTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFileSetType()
     * @generated
     */
    int FILE_SET_TYPE = 3;

    /**
     * The feature id for the '<em><b>File</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__FILE = 0;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__DESCRIPTION_TEXT = 1;

    /**
     * The feature id for the '<em><b>External URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__EXTERNAL_URI = 2;

    /**
     * The feature id for the '<em><b>Files</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__FILES = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__ID = 4;

    /**
     * The feature id for the '<em><b>Nature URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__NATURE_URI = 5;

    /**
     * The feature id for the '<em><b>Purpose URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE__PURPOSE_URI = 6;

    /**
     * The number of structural features of the '<em>File Set Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>File Set Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_SET_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.FileTypeImpl <em>File Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.FileTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFileType()
     * @generated
     */
    int FILE_TYPE = 4;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__DESCRIPTION_TEXT = 0;

    /**
     * The feature id for the '<em><b>External URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__EXTERNAL_URI = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__ID = 2;

    /**
     * The feature id for the '<em><b>Nature URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__NATURE_URI = 3;

    /**
     * The feature id for the '<em><b>Purpose URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__PURPOSE_URI = 4;

    /**
     * The feature id for the '<em><b>Relative Path Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE__RELATIVE_PATH_NAME = 5;

    /**
     * The number of structural features of the '<em>File Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>File Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FILE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.FolderTypeImpl <em>Folder Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.FolderTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFolderType()
     * @generated
     */
    int FOLDER_TYPE = 5;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLDER_TYPE__DESCRIPTION_TEXT = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLDER_TYPE__ID = 1;

    /**
     * The feature id for the '<em><b>Relative Path Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLDER_TYPE__RELATIVE_PATH_NAME = 2;

    /**
     * The number of structural features of the '<em>Folder Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLDER_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Folder Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FOLDER_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl <em>Metadata Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.MetadataTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMetadataType()
     * @generated
     */
    int METADATA_TYPE = 6;

    /**
     * The feature id for the '<em><b>Security Marking Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__SECURITY_MARKING_TEXT = 0;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__CREATION_DATE = 1;

    /**
     * The feature id for the '<em><b>Last Revision Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__LAST_REVISION_DATE = 2;

    /**
     * The feature id for the '<em><b>Next Revision Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__NEXT_REVISION_DATE = 3;

    /**
     * The feature id for the '<em><b>Status Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__STATUS_TEXT = 4;

    /**
     * The feature id for the '<em><b>Relationship</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__RELATIONSHIP = 5;

    /**
     * The feature id for the '<em><b>Keyword Text</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__KEYWORD_TEXT = 6;

    /**
     * The feature id for the '<em><b>Domain Text</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__DOMAIN_TEXT = 7;

    /**
     * The feature id for the '<em><b>Purpose Text</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__PURPOSE_TEXT = 8;

    /**
     * The feature id for the '<em><b>Exchange Pattern Text</b></em>' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__EXCHANGE_PATTERN_TEXT = 9;

    /**
     * The feature id for the '<em><b>Exchange Partner Name</b></em>' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__EXCHANGE_PARTNER_NAME = 10;

    /**
     * The feature id for the '<em><b>Authoritative Source</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE__AUTHORITATIVE_SOURCE = 11;

    /**
     * The number of structural features of the '<em>Metadata Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE_FEATURE_COUNT = 12;

    /**
     * The operation id for the '<em>Set Creation Date</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE___SET_CREATION_DATE__STRING = 0;

    /**
     * The number of operations of the '<em>Metadata Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int METADATA_TYPE_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.POCTypeImpl <em>POC Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.POCTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getPOCType()
     * @generated
     */
    int POC_TYPE = 7;

    /**
     * The feature id for the '<em><b>POC Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int POC_TYPE__POC_NAME = 0;

    /**
     * The feature id for the '<em><b>POC Email</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int POC_TYPE__POC_EMAIL = 1;

    /**
     * The feature id for the '<em><b>POC Telephone</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int POC_TYPE__POC_TELEPHONE = 2;

    /**
     * The number of structural features of the '<em>POC Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int POC_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>POC Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int POC_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.impl.RelationshipTypeImpl <em>Relationship Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.impl.RelationshipTypeImpl
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipType()
     * @generated
     */
    int RELATIONSHIP_TYPE = 8;

    /**
     * The feature id for the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RELATIONSHIP_TYPE__DESCRIPTION_TEXT = 0;

    /**
     * The feature id for the '<em><b>Relationship Code</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RELATIONSHIP_TYPE__RELATIONSHIP_CODE = 1;

    /**
     * The feature id for the '<em><b>Resource URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RELATIONSHIP_TYPE__RESOURCE_URI = 2;

    /**
     * The number of structural features of the '<em>Relationship Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int RELATIONSHIP_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Relationship Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RELATIONSHIP_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.MPDClassCodeSimpleType <em>MPD Class Code Simple Type</em>}
     * ' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDClassCodeSimpleType()
     * @generated
     */
    int MPD_CLASS_CODE_SIMPLE_TYPE = 9;

    /**
     * The meta object id for the '{@link org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * <em>Relationship Code Simple Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipCodeSimpleType()
     * @generated
     */
    int RELATIONSHIP_CODE_SIMPLE_TYPE = 10;

    /**
     * The meta object id for the '<em>MPD Class Code Simple Type Object</em>' data type. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDClassCodeSimpleTypeObject()
     * @generated
     */
    int MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT = 11;

    /**
     * The meta object id for the '<em>MPD Version ID Simple Type</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see java.lang.String
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDVersionIDSimpleType()
     * @generated
     */
    int MPD_VERSION_ID_SIMPLE_TYPE = 12;

    /**
     * The meta object id for the '<em>Relationship Code Simple Type Object</em>' data type. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipCodeSimpleTypeObject()
     * @generated
     */
    int RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT = 13;

    /**
     * The meta object id for the '<em>Safe Curie Simple Type</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see java.lang.String
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getSafeCurieSimpleType()
     * @generated
     */
    int SAFE_CURIE_SIMPLE_TYPE = 14;

    /**
     * The meta object id for the '<em>URI Simple Type</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see java.lang.String
     * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getURISimpleType()
     * @generated
     */
    int URI_SIMPLE_TYPE = 15;

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.AuthoritativeSourceType
     * <em>Authoritative Source Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Authoritative Source Type</em>'.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType
     * @generated
     */
    EClass getAuthoritativeSourceType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASName
     * <em>AS Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Name</em>'.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType#getASName()
     * @see #getAuthoritativeSourceType()
     * @generated
     */
    EAttribute getAuthoritativeSourceType_ASName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASAddressText
     * <em>AS Address Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Address Text</em>'.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType#getASAddressText()
     * @see #getAuthoritativeSourceType()
     * @generated
     */
    EAttribute getAuthoritativeSourceType_ASAddressText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASWebSiteURL
     * <em>AS Web Site URL</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Web Site URL</em>'.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType#getASWebSiteURL()
     * @see #getAuthoritativeSourceType()
     * @generated
     */
    EAttribute getAuthoritativeSourceType_ASWebSiteURL();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.search.niem.mpd.cat.AuthoritativeSourceType#getPOC <em>POC</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>POC</em>'.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType#getPOC()
     * @see #getAuthoritativeSourceType()
     * @generated
     */
    EReference getAuthoritativeSourceType_POC();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.CatalogType <em>Catalog Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Catalog Type</em>'.
     * @see org.search.niem.mpd.cat.CatalogType
     * @generated
     */
    EClass getCatalogType();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.CatalogType#getArtifactGroup
     * <em>Artifact Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Artifact Group</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getArtifactGroup()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_ArtifactGroup();

    /**
     * Returns the meta object for the containment reference list '{@link org.search.niem.mpd.cat.CatalogType#getArtifact
     * <em>Artifact</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Artifact</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getArtifact()
     * @see #getCatalogType()
     * @generated
     */
    EReference getCatalogType_Artifact();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.CatalogType#getMetadata
     * <em>Metadata</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Metadata</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getMetadata()
     * @see #getCatalogType()
     * @generated
     */
    EReference getCatalogType_Metadata();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.CatalogType#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getDescriptionText()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.CatalogType#getMpdClassCode
     * <em>Mpd Class Code</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Class Code</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getMpdClassCode()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_MpdClassCode();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.CatalogType#getMpdName <em>Mpd Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Name</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getMpdName()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_MpdName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.CatalogType#getMpdURI <em>Mpd URI</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd URI</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getMpdURI()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_MpdURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.CatalogType#getMpdVersionID
     * <em>Mpd Version ID</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Version ID</em>'.
     * @see org.search.niem.mpd.cat.CatalogType#getMpdVersionID()
     * @see #getCatalogType()
     * @generated
     */
    EAttribute getCatalogType_MpdVersionID();

    /**
     * Returns the meta object for the '{@link org.search.niem.mpd.cat.CatalogType#setMpdClassCode(java.lang.String)
     * <em>Set Mpd Class Code</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the '<em>Set Mpd Class Code</em>' operation.
     * @see org.search.niem.mpd.cat.CatalogType#setMpdClassCode(java.lang.String)
     * @generated
     */
    EOperation getCatalogType__SetMpdClassCode__String();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.DocumentRoot <em>Document Root</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed();

    /**
     * Returns the meta object for the map '{@link org.search.niem.mpd.cat.DocumentRoot#getXMLNSPrefixMap
     * <em>XMLNS Prefix Map</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
     * Returns the meta object for the map '{@link org.search.niem.mpd.cat.DocumentRoot#getXSISchemaLocation
     * <em>XSI Schema Location</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getArtifact
     * <em>Artifact</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Artifact</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getArtifact()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Artifact();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getASAddressText
     * <em>AS Address Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Address Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getASAddressText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ASAddressText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getASName <em>AS Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Name</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getASName()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ASName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getASWebSiteURL
     * <em>AS Web Site URL</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>AS Web Site URL</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getASWebSiteURL()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ASWebSiteURL();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.search.niem.mpd.cat.DocumentRoot#getAuthoritativeSource <em>Authoritative Source</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Authoritative Source</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getAuthoritativeSource()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_AuthoritativeSource();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getCatalog
     * <em>Catalog</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Catalog</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getCatalog()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Catalog();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getCreationDate
     * <em>Creation Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Creation Date</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getCreationDate()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_CreationDate();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getDomainText
     * <em>Domain Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Domain Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getDomainText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_DomainText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePartnerName
     * <em>Exchange Partner Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Exchange Partner Name</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getExchangePartnerName()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ExchangePartnerName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePatternText
     * <em>Exchange Pattern Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Exchange Pattern Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getExchangePatternText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ExchangePatternText();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getFile
     * <em>File</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>File</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getFile()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_File();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getFileSet
     * <em>File Set</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>File Set</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getFileSet()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_FileSet();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getFolder
     * <em>Folder</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Folder</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getFolder()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Folder();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getKeywordText
     * <em>Keyword Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Keyword Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getKeywordText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_KeywordText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getLastRevisionDate
     * <em>Last Revision Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Last Revision Date</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getLastRevisionDate()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_LastRevisionDate();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getMetadata
     * <em>Metadata</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Metadata</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMetadata()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Metadata();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getNextRevisionDate
     * <em>Next Revision Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Next Revision Date</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getNextRevisionDate()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_NextRevisionDate();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getPOC
     * <em>POC</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>POC</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPOC()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_POC();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCEmail <em>POC Email</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>POC Email</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPOCEmail()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_POCEmail();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCName <em>POC Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>POC Name</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPOCName()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_POCName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCTelephone
     * <em>POC Telephone</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>POC Telephone</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPOCTelephone()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_POCTelephone();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeText
     * <em>Purpose Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Purpose Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPurposeText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_PurposeText();

    /**
     * Returns the meta object for the containment reference '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationship
     * <em>Relationship</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Relationship</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getRelationship()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Relationship();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getSecurityMarkingText
     * <em>Security Marking Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Security Marking Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getSecurityMarkingText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_SecurityMarkingText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getStatusText
     * <em>Status Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Status Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getStatusText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_StatusText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getDescriptionText()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getExternalURI
     * <em>External URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>External URI</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getExternalURI()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ExternalURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getFiles <em>Files</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Files</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getFiles()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Files();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getId()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Id();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode
     * <em>Mpd Class Code</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Class Code</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_MpdClassCode();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdName <em>Mpd Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Name</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMpdName()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_MpdName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdURI <em>Mpd URI</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd URI</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMpdURI()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_MpdURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdVersionID
     * <em>Mpd Version ID</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mpd Version ID</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getMpdVersionID()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_MpdVersionID();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getNatureURI
     * <em>Nature URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Nature URI</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getNatureURI()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_NatureURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeURI
     * <em>Purpose URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Purpose URI</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getPurposeURI()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_PurposeURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode
     * <em>Relationship Code</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relationship Code</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_RelationshipCode();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getRelativePathName
     * <em>Relative Path Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relative Path Name</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getRelativePathName()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_RelativePathName();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.DocumentRoot#getResourceURI
     * <em>Resource URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Resource URI</em>'.
     * @see org.search.niem.mpd.cat.DocumentRoot#getResourceURI()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_ResourceURI();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.FileSetType <em>File Set Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>File Set Type</em>'.
     * @see org.search.niem.mpd.cat.FileSetType
     * @generated
     */
    EClass getFileSetType();

    /**
     * Returns the meta object for the containment reference list '{@link org.search.niem.mpd.cat.FileSetType#getFile
     * <em>File</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>File</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getFile()
     * @see #getFileSetType()
     * @generated
     */
    EReference getFileSetType_File();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getDescriptionText()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getExternalURI
     * <em>External URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>External URI</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getExternalURI()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_ExternalURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getFiles <em>Files</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Files</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getFiles()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_Files();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getId()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_Id();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getNatureURI
     * <em>Nature URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Nature URI</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getNatureURI()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_NatureURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileSetType#getPurposeURI
     * <em>Purpose URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Purpose URI</em>'.
     * @see org.search.niem.mpd.cat.FileSetType#getPurposeURI()
     * @see #getFileSetType()
     * @generated
     */
    EAttribute getFileSetType_PurposeURI();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.FileType <em>File Type</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>File Type</em>'.
     * @see org.search.niem.mpd.cat.FileType
     * @generated
     */
    EClass getFileType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.FileType#getDescriptionText()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getExternalURI
     * <em>External URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>External URI</em>'.
     * @see org.search.niem.mpd.cat.FileType#getExternalURI()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_ExternalURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.search.niem.mpd.cat.FileType#getId()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_Id();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getNatureURI <em>Nature URI</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Nature URI</em>'.
     * @see org.search.niem.mpd.cat.FileType#getNatureURI()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_NatureURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getPurposeURI <em>Purpose URI</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Purpose URI</em>'.
     * @see org.search.niem.mpd.cat.FileType#getPurposeURI()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_PurposeURI();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FileType#getRelativePathName
     * <em>Relative Path Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relative Path Name</em>'.
     * @see org.search.niem.mpd.cat.FileType#getRelativePathName()
     * @see #getFileType()
     * @generated
     */
    EAttribute getFileType_RelativePathName();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.FolderType <em>Folder Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Folder Type</em>'.
     * @see org.search.niem.mpd.cat.FolderType
     * @generated
     */
    EClass getFolderType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FolderType#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.FolderType#getDescriptionText()
     * @see #getFolderType()
     * @generated
     */
    EAttribute getFolderType_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FolderType#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.search.niem.mpd.cat.FolderType#getId()
     * @see #getFolderType()
     * @generated
     */
    EAttribute getFolderType_Id();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.FolderType#getRelativePathName
     * <em>Relative Path Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relative Path Name</em>'.
     * @see org.search.niem.mpd.cat.FolderType#getRelativePathName()
     * @see #getFolderType()
     * @generated
     */
    EAttribute getFolderType_RelativePathName();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.MetadataType <em>Metadata Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Metadata Type</em>'.
     * @see org.search.niem.mpd.cat.MetadataType
     * @generated
     */
    EClass getMetadataType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText
     * <em>Security Marking Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Security Marking Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_SecurityMarkingText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.MetadataType#getCreationDate
     * <em>Creation Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Creation Date</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getCreationDate()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_CreationDate();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.MetadataType#getLastRevisionDate
     * <em>Last Revision Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Last Revision Date</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getLastRevisionDate()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_LastRevisionDate();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.MetadataType#getNextRevisionDate
     * <em>Next Revision Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Next Revision Date</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getNextRevisionDate()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_NextRevisionDate();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.MetadataType#getStatusText
     * <em>Status Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Status Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getStatusText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_StatusText();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.search.niem.mpd.cat.MetadataType#getRelationship <em>Relationship</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Relationship</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getRelationship()
     * @see #getMetadataType()
     * @generated
     */
    EReference getMetadataType_Relationship();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.MetadataType#getKeywordText
     * <em>Keyword Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Keyword Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getKeywordText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_KeywordText();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.MetadataType#getDomainText
     * <em>Domain Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Domain Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getDomainText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_DomainText();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.MetadataType#getPurposeText
     * <em>Purpose Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Purpose Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getPurposeText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_PurposeText();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.MetadataType#getExchangePatternText
     * <em>Exchange Pattern Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Exchange Pattern Text</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getExchangePatternText()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_ExchangePatternText();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.MetadataType#getExchangePartnerName
     * <em>Exchange Partner Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Exchange Partner Name</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getExchangePartnerName()
     * @see #getMetadataType()
     * @generated
     */
    EAttribute getMetadataType_ExchangePartnerName();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.search.niem.mpd.cat.MetadataType#getAuthoritativeSource <em>Authoritative Source</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Authoritative Source</em>'.
     * @see org.search.niem.mpd.cat.MetadataType#getAuthoritativeSource()
     * @see #getMetadataType()
     * @generated
     */
    EReference getMetadataType_AuthoritativeSource();

    /**
     * Returns the meta object for the '{@link org.search.niem.mpd.cat.MetadataType#setCreationDate(java.lang.String)
     * <em>Set Creation Date</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the '<em>Set Creation Date</em>' operation.
     * @see org.search.niem.mpd.cat.MetadataType#setCreationDate(java.lang.String)
     * @generated
     */
    EOperation getMetadataType__SetCreationDate__String();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.POCType <em>POC Type</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>POC Type</em>'.
     * @see org.search.niem.mpd.cat.POCType
     * @generated
     */
    EClass getPOCType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.POCType#getPOCName <em>POC Name</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>POC Name</em>'.
     * @see org.search.niem.mpd.cat.POCType#getPOCName()
     * @see #getPOCType()
     * @generated
     */
    EAttribute getPOCType_POCName();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.POCType#getPOCEmail <em>POC Email</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>POC Email</em>'.
     * @see org.search.niem.mpd.cat.POCType#getPOCEmail()
     * @see #getPOCType()
     * @generated
     */
    EAttribute getPOCType_POCEmail();

    /**
     * Returns the meta object for the attribute list '{@link org.search.niem.mpd.cat.POCType#getPOCTelephone
     * <em>POC Telephone</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>POC Telephone</em>'.
     * @see org.search.niem.mpd.cat.POCType#getPOCTelephone()
     * @see #getPOCType()
     * @generated
     */
    EAttribute getPOCType_POCTelephone();

    /**
     * Returns the meta object for class '{@link org.search.niem.mpd.cat.RelationshipType <em>Relationship Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Relationship Type</em>'.
     * @see org.search.niem.mpd.cat.RelationshipType
     * @generated
     */
    EClass getRelationshipType();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.RelationshipType#getDescriptionText
     * <em>Description Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description Text</em>'.
     * @see org.search.niem.mpd.cat.RelationshipType#getDescriptionText()
     * @see #getRelationshipType()
     * @generated
     */
    EAttribute getRelationshipType_DescriptionText();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.RelationshipType#getRelationshipCode
     * <em>Relationship Code</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Relationship Code</em>'.
     * @see org.search.niem.mpd.cat.RelationshipType#getRelationshipCode()
     * @see #getRelationshipType()
     * @generated
     */
    EAttribute getRelationshipType_RelationshipCode();

    /**
     * Returns the meta object for the attribute '{@link org.search.niem.mpd.cat.RelationshipType#getResourceURI
     * <em>Resource URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Resource URI</em>'.
     * @see org.search.niem.mpd.cat.RelationshipType#getResourceURI()
     * @see #getRelationshipType()
     * @generated
     */
    EAttribute getRelationshipType_ResourceURI();

    /**
     * Returns the meta object for enum '{@link org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * <em>MPD Class Code Simple Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>MPD Class Code Simple Type</em>'.
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @generated
     */
    EEnum getMPDClassCodeSimpleType();

    /**
     * Returns the meta object for enum '{@link org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * <em>Relationship Code Simple Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Relationship Code Simple Type</em>'.
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @generated
     */
    EEnum getRelationshipCodeSimpleType();

    /**
     * Returns the meta object for data type '{@link org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * <em>MPD Class Code Simple Type Object</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>MPD Class Code Simple Type Object</em>'.
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @model instanceClass="org.search.niem.mpd.cat.MPDClassCodeSimpleType"
     *        extendedMetaData="name='MPDClassCodeSimpleType:Object' baseType='MPDClassCodeSimpleType'"
     * @generated
     */
    EDataType getMPDClassCodeSimpleTypeObject();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>MPD Version ID Simple Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>MPD Version ID Simple Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String" extendedMetaData=
     *        "name='MPDVersionIDSimpleType' baseType='http://www.eclipse.org/emf/2003/XMLType#token' minLength='1' pattern='[0-9]+(\\.[0-9]+)*((alpha|beta|rc|rev)[0-9]+)?'"
     * @generated
     */
    EDataType getMPDVersionIDSimpleType();

    /**
     * Returns the meta object for data type '{@link org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * <em>Relationship Code Simple Type Object</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Relationship Code Simple Type Object</em>'.
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @model instanceClass="org.search.niem.mpd.cat.RelationshipCodeSimpleType"
     *        extendedMetaData="name='RelationshipCodeSimpleType:Object' baseType='RelationshipCodeSimpleType'"
     * @generated
     */
    EDataType getRelationshipCodeSimpleTypeObject();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Safe Curie Simple Type</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Safe Curie Simple Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String" extendedMetaData=
     *        "name='SafeCurieSimpleType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' minLength='3' pattern='\\[(([\\i-[:]][\\c-[:]]*)?:)?.+\\]'"
     * @generated
     */
    EDataType getSafeCurieSimpleType();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>URI Simple Type</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>URI Simple Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String" extendedMetaData=
     *        "name='URISimpleType' memberTypes='http://www.eclipse.org/emf/2003/XMLType#anyURI SafeCurieSimpleType'"
     * @generated
     */
    EDataType getURISimpleType();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CatFactory getCatFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl
         * <em>Authoritative Source Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getAuthoritativeSourceType()
         * @generated
         */
        EClass AUTHORITATIVE_SOURCE_TYPE = eINSTANCE.getAuthoritativeSourceType();

        /**
         * The meta object literal for the '<em><b>AS Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute AUTHORITATIVE_SOURCE_TYPE__AS_NAME = eINSTANCE.getAuthoritativeSourceType_ASName();

        /**
         * The meta object literal for the '<em><b>AS Address Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT = eINSTANCE.getAuthoritativeSourceType_ASAddressText();

        /**
         * The meta object literal for the '<em><b>AS Web Site URL</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL = eINSTANCE.getAuthoritativeSourceType_ASWebSiteURL();

        /**
         * The meta object literal for the '<em><b>POC</b></em>' containment reference list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference AUTHORITATIVE_SOURCE_TYPE__POC = eINSTANCE.getAuthoritativeSourceType_POC();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl <em>Catalog Type</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.CatalogTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getCatalogType()
         * @generated
         */
        EClass CATALOG_TYPE = eINSTANCE.getCatalogType();

        /**
         * The meta object literal for the '<em><b>Artifact Group</b></em>' attribute list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__ARTIFACT_GROUP = eINSTANCE.getCatalogType_ArtifactGroup();

        /**
         * The meta object literal for the '<em><b>Artifact</b></em>' containment reference list feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CATALOG_TYPE__ARTIFACT = eINSTANCE.getCatalogType_Artifact();

        /**
         * The meta object literal for the '<em><b>Metadata</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CATALOG_TYPE__METADATA = eINSTANCE.getCatalogType_Metadata();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__DESCRIPTION_TEXT = eINSTANCE.getCatalogType_DescriptionText();

        /**
         * The meta object literal for the '<em><b>Mpd Class Code</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__MPD_CLASS_CODE = eINSTANCE.getCatalogType_MpdClassCode();

        /**
         * The meta object literal for the '<em><b>Mpd Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__MPD_NAME = eINSTANCE.getCatalogType_MpdName();

        /**
         * The meta object literal for the '<em><b>Mpd URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__MPD_URI = eINSTANCE.getCatalogType_MpdURI();

        /**
         * The meta object literal for the '<em><b>Mpd Version ID</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATALOG_TYPE__MPD_VERSION_ID = eINSTANCE.getCatalogType_MpdVersionID();

        /**
         * The meta object literal for the '<em><b>Set Mpd Class Code</b></em>' operation. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EOperation CATALOG_TYPE___SET_MPD_CLASS_CODE__STRING = eINSTANCE.getCatalogType__SetMpdClassCode__String();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.DocumentRootImpl <em>Document Root</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.DocumentRootImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

        /**
         * The meta object literal for the '<em><b>Artifact</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__ARTIFACT = eINSTANCE.getDocumentRoot_Artifact();

        /**
         * The meta object literal for the '<em><b>AS Address Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__AS_ADDRESS_TEXT = eINSTANCE.getDocumentRoot_ASAddressText();

        /**
         * The meta object literal for the '<em><b>AS Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__AS_NAME = eINSTANCE.getDocumentRoot_ASName();

        /**
         * The meta object literal for the '<em><b>AS Web Site URL</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__AS_WEB_SITE_URL = eINSTANCE.getDocumentRoot_ASWebSiteURL();

        /**
         * The meta object literal for the '<em><b>Authoritative Source</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__AUTHORITATIVE_SOURCE = eINSTANCE.getDocumentRoot_AuthoritativeSource();

        /**
         * The meta object literal for the '<em><b>Catalog</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__CATALOG = eINSTANCE.getDocumentRoot_Catalog();

        /**
         * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__CREATION_DATE = eINSTANCE.getDocumentRoot_CreationDate();

        /**
         * The meta object literal for the '<em><b>Domain Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__DOMAIN_TEXT = eINSTANCE.getDocumentRoot_DomainText();

        /**
         * The meta object literal for the '<em><b>Exchange Partner Name</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME = eINSTANCE.getDocumentRoot_ExchangePartnerName();

        /**
         * The meta object literal for the '<em><b>Exchange Pattern Text</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT = eINSTANCE.getDocumentRoot_ExchangePatternText();

        /**
         * The meta object literal for the '<em><b>File</b></em>' containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__FILE = eINSTANCE.getDocumentRoot_File();

        /**
         * The meta object literal for the '<em><b>File Set</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__FILE_SET = eINSTANCE.getDocumentRoot_FileSet();

        /**
         * The meta object literal for the '<em><b>Folder</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__FOLDER = eINSTANCE.getDocumentRoot_Folder();

        /**
         * The meta object literal for the '<em><b>Keyword Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__KEYWORD_TEXT = eINSTANCE.getDocumentRoot_KeywordText();

        /**
         * The meta object literal for the '<em><b>Last Revision Date</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__LAST_REVISION_DATE = eINSTANCE.getDocumentRoot_LastRevisionDate();

        /**
         * The meta object literal for the '<em><b>Metadata</b></em>' containment reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__METADATA = eINSTANCE.getDocumentRoot_Metadata();

        /**
         * The meta object literal for the '<em><b>Next Revision Date</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__NEXT_REVISION_DATE = eINSTANCE.getDocumentRoot_NextRevisionDate();

        /**
         * The meta object literal for the '<em><b>POC</b></em>' containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__POC = eINSTANCE.getDocumentRoot_POC();

        /**
         * The meta object literal for the '<em><b>POC Email</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__POC_EMAIL = eINSTANCE.getDocumentRoot_POCEmail();

        /**
         * The meta object literal for the '<em><b>POC Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__POC_NAME = eINSTANCE.getDocumentRoot_POCName();

        /**
         * The meta object literal for the '<em><b>POC Telephone</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__POC_TELEPHONE = eINSTANCE.getDocumentRoot_POCTelephone();

        /**
         * The meta object literal for the '<em><b>Purpose Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__PURPOSE_TEXT = eINSTANCE.getDocumentRoot_PurposeText();

        /**
         * The meta object literal for the '<em><b>Relationship</b></em>' containment reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DOCUMENT_ROOT__RELATIONSHIP = eINSTANCE.getDocumentRoot_Relationship();

        /**
         * The meta object literal for the '<em><b>Security Marking Text</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__SECURITY_MARKING_TEXT = eINSTANCE.getDocumentRoot_SecurityMarkingText();

        /**
         * The meta object literal for the '<em><b>Status Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__STATUS_TEXT = eINSTANCE.getDocumentRoot_StatusText();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__DESCRIPTION_TEXT = eINSTANCE.getDocumentRoot_DescriptionText();

        /**
         * The meta object literal for the '<em><b>External URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__EXTERNAL_URI = eINSTANCE.getDocumentRoot_ExternalURI();

        /**
         * The meta object literal for the '<em><b>Files</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__FILES = eINSTANCE.getDocumentRoot_Files();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__ID = eINSTANCE.getDocumentRoot_Id();

        /**
         * The meta object literal for the '<em><b>Mpd Class Code</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MPD_CLASS_CODE = eINSTANCE.getDocumentRoot_MpdClassCode();

        /**
         * The meta object literal for the '<em><b>Mpd Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MPD_NAME = eINSTANCE.getDocumentRoot_MpdName();

        /**
         * The meta object literal for the '<em><b>Mpd URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MPD_URI = eINSTANCE.getDocumentRoot_MpdURI();

        /**
         * The meta object literal for the '<em><b>Mpd Version ID</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MPD_VERSION_ID = eINSTANCE.getDocumentRoot_MpdVersionID();

        /**
         * The meta object literal for the '<em><b>Nature URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__NATURE_URI = eINSTANCE.getDocumentRoot_NatureURI();

        /**
         * The meta object literal for the '<em><b>Purpose URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__PURPOSE_URI = eINSTANCE.getDocumentRoot_PurposeURI();

        /**
         * The meta object literal for the '<em><b>Relationship Code</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__RELATIONSHIP_CODE = eINSTANCE.getDocumentRoot_RelationshipCode();

        /**
         * The meta object literal for the '<em><b>Relative Path Name</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__RELATIVE_PATH_NAME = eINSTANCE.getDocumentRoot_RelativePathName();

        /**
         * The meta object literal for the '<em><b>Resource URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENT_ROOT__RESOURCE_URI = eINSTANCE.getDocumentRoot_ResourceURI();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.FileSetTypeImpl <em>File Set Type</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.FileSetTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFileSetType()
         * @generated
         */
        EClass FILE_SET_TYPE = eINSTANCE.getFileSetType();

        /**
         * The meta object literal for the '<em><b>File</b></em>' containment reference list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference FILE_SET_TYPE__FILE = eINSTANCE.getFileSetType_File();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__DESCRIPTION_TEXT = eINSTANCE.getFileSetType_DescriptionText();

        /**
         * The meta object literal for the '<em><b>External URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__EXTERNAL_URI = eINSTANCE.getFileSetType_ExternalURI();

        /**
         * The meta object literal for the '<em><b>Files</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__FILES = eINSTANCE.getFileSetType_Files();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__ID = eINSTANCE.getFileSetType_Id();

        /**
         * The meta object literal for the '<em><b>Nature URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__NATURE_URI = eINSTANCE.getFileSetType_NatureURI();

        /**
         * The meta object literal for the '<em><b>Purpose URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_SET_TYPE__PURPOSE_URI = eINSTANCE.getFileSetType_PurposeURI();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.FileTypeImpl <em>File Type</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.FileTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFileType()
         * @generated
         */
        EClass FILE_TYPE = eINSTANCE.getFileType();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__DESCRIPTION_TEXT = eINSTANCE.getFileType_DescriptionText();

        /**
         * The meta object literal for the '<em><b>External URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__EXTERNAL_URI = eINSTANCE.getFileType_ExternalURI();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__ID = eINSTANCE.getFileType_Id();

        /**
         * The meta object literal for the '<em><b>Nature URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__NATURE_URI = eINSTANCE.getFileType_NatureURI();

        /**
         * The meta object literal for the '<em><b>Purpose URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__PURPOSE_URI = eINSTANCE.getFileType_PurposeURI();

        /**
         * The meta object literal for the '<em><b>Relative Path Name</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute FILE_TYPE__RELATIVE_PATH_NAME = eINSTANCE.getFileType_RelativePathName();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.FolderTypeImpl <em>Folder Type</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.FolderTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getFolderType()
         * @generated
         */
        EClass FOLDER_TYPE = eINSTANCE.getFolderType();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute FOLDER_TYPE__DESCRIPTION_TEXT = eINSTANCE.getFolderType_DescriptionText();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @generated
         */
        EAttribute FOLDER_TYPE__ID = eINSTANCE.getFolderType_Id();

        /**
         * The meta object literal for the '<em><b>Relative Path Name</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute FOLDER_TYPE__RELATIVE_PATH_NAME = eINSTANCE.getFolderType_RelativePathName();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl <em>Metadata Type</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.MetadataTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMetadataType()
         * @generated
         */
        EClass METADATA_TYPE = eINSTANCE.getMetadataType();

        /**
         * The meta object literal for the '<em><b>Security Marking Text</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__SECURITY_MARKING_TEXT = eINSTANCE.getMetadataType_SecurityMarkingText();

        /**
         * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__CREATION_DATE = eINSTANCE.getMetadataType_CreationDate();

        /**
         * The meta object literal for the '<em><b>Last Revision Date</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__LAST_REVISION_DATE = eINSTANCE.getMetadataType_LastRevisionDate();

        /**
         * The meta object literal for the '<em><b>Next Revision Date</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__NEXT_REVISION_DATE = eINSTANCE.getMetadataType_NextRevisionDate();

        /**
         * The meta object literal for the '<em><b>Status Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__STATUS_TEXT = eINSTANCE.getMetadataType_StatusText();

        /**
         * The meta object literal for the '<em><b>Relationship</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference METADATA_TYPE__RELATIONSHIP = eINSTANCE.getMetadataType_Relationship();

        /**
         * The meta object literal for the '<em><b>Keyword Text</b></em>' attribute list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__KEYWORD_TEXT = eINSTANCE.getMetadataType_KeywordText();

        /**
         * The meta object literal for the '<em><b>Domain Text</b></em>' attribute list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__DOMAIN_TEXT = eINSTANCE.getMetadataType_DomainText();

        /**
         * The meta object literal for the '<em><b>Purpose Text</b></em>' attribute list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__PURPOSE_TEXT = eINSTANCE.getMetadataType_PurposeText();

        /**
         * The meta object literal for the '<em><b>Exchange Pattern Text</b></em>' attribute list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__EXCHANGE_PATTERN_TEXT = eINSTANCE.getMetadataType_ExchangePatternText();

        /**
         * The meta object literal for the '<em><b>Exchange Partner Name</b></em>' attribute list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute METADATA_TYPE__EXCHANGE_PARTNER_NAME = eINSTANCE.getMetadataType_ExchangePartnerName();

        /**
         * The meta object literal for the '<em><b>Authoritative Source</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference METADATA_TYPE__AUTHORITATIVE_SOURCE = eINSTANCE.getMetadataType_AuthoritativeSource();

        /**
         * The meta object literal for the '<em><b>Set Creation Date</b></em>' operation. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EOperation METADATA_TYPE___SET_CREATION_DATE__STRING = eINSTANCE.getMetadataType__SetCreationDate__String();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.POCTypeImpl <em>POC Type</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.POCTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getPOCType()
         * @generated
         */
        EClass POC_TYPE = eINSTANCE.getPOCType();

        /**
         * The meta object literal for the '<em><b>POC Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute POC_TYPE__POC_NAME = eINSTANCE.getPOCType_POCName();

        /**
         * The meta object literal for the '<em><b>POC Email</b></em>' attribute list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute POC_TYPE__POC_EMAIL = eINSTANCE.getPOCType_POCEmail();

        /**
         * The meta object literal for the '<em><b>POC Telephone</b></em>' attribute list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute POC_TYPE__POC_TELEPHONE = eINSTANCE.getPOCType_POCTelephone();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.impl.RelationshipTypeImpl
         * <em>Relationship Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.impl.RelationshipTypeImpl
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipType()
         * @generated
         */
        EClass RELATIONSHIP_TYPE = eINSTANCE.getRelationshipType();

        /**
         * The meta object literal for the '<em><b>Description Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute RELATIONSHIP_TYPE__DESCRIPTION_TEXT = eINSTANCE.getRelationshipType_DescriptionText();

        /**
         * The meta object literal for the '<em><b>Relationship Code</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute RELATIONSHIP_TYPE__RELATIONSHIP_CODE = eINSTANCE.getRelationshipType_RelationshipCode();

        /**
         * The meta object literal for the '<em><b>Resource URI</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute RELATIONSHIP_TYPE__RESOURCE_URI = eINSTANCE.getRelationshipType_ResourceURI();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.MPDClassCodeSimpleType
         * <em>MPD Class Code Simple Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDClassCodeSimpleType()
         * @generated
         */
        EEnum MPD_CLASS_CODE_SIMPLE_TYPE = eINSTANCE.getMPDClassCodeSimpleType();

        /**
         * The meta object literal for the '{@link org.search.niem.mpd.cat.RelationshipCodeSimpleType
         * <em>Relationship Code Simple Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipCodeSimpleType()
         * @generated
         */
        EEnum RELATIONSHIP_CODE_SIMPLE_TYPE = eINSTANCE.getRelationshipCodeSimpleType();

        /**
         * The meta object literal for the '<em>MPD Class Code Simple Type Object</em>' data type. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDClassCodeSimpleTypeObject()
         * @generated
         */
        EDataType MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT = eINSTANCE.getMPDClassCodeSimpleTypeObject();

        /**
         * The meta object literal for the '<em>MPD Version ID Simple Type</em>' data type. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see java.lang.String
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getMPDVersionIDSimpleType()
         * @generated
         */
        EDataType MPD_VERSION_ID_SIMPLE_TYPE = eINSTANCE.getMPDVersionIDSimpleType();

        /**
         * The meta object literal for the '<em>Relationship Code Simple Type Object</em>' data type. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getRelationshipCodeSimpleTypeObject()
         * @generated
         */
        EDataType RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT = eINSTANCE.getRelationshipCodeSimpleTypeObject();

        /**
         * The meta object literal for the '<em>Safe Curie Simple Type</em>' data type. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see java.lang.String
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getSafeCurieSimpleType()
         * @generated
         */
        EDataType SAFE_CURIE_SIMPLE_TYPE = eINSTANCE.getSafeCurieSimpleType();

        /**
         * The meta object literal for the '<em>URI Simple Type</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see java.lang.String
         * @see org.search.niem.mpd.cat.impl.CatPackageImpl#getURISimpleType()
         * @generated
         */
        EDataType URI_SIMPLE_TYPE = eINSTANCE.getURISimpleType();

    }

} // CatPackage
