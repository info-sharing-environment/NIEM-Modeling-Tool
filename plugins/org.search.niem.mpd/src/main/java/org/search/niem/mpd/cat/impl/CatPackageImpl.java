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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
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
import org.search.niem.mpd.cat.util.CatValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CatPackageImpl extends EPackageImpl implements CatPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass authoritativeSourceTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass catalogTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fileSetTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass fileTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass folderTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass metadataTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass pocTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass relationshipTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum mpdClassCodeSimpleTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum relationshipCodeSimpleTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType mpdClassCodeSimpleTypeObjectEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType mpdVersionIDSimpleTypeEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType relationshipCodeSimpleTypeObjectEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType safeCurieSimpleTypeEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType uriSimpleTypeEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.search.niem.mpd.cat.CatPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CatPackageImpl() {
        super(eNS_URI, CatFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link CatPackage#eINSTANCE} when that field is accessed. Clients should not invoke
     * it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CatPackage init() {
        if (isInited) {
            return (CatPackage) EPackage.Registry.INSTANCE.getEPackage(CatPackage.eNS_URI);
        }

        // Obtain or create and register package
        final CatPackageImpl theCatPackage = (CatPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CatPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new CatPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theCatPackage.createPackageContents();

        // Initialize created meta-data
        theCatPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put(theCatPackage, new EValidator.Descriptor() {
            @Override
            public EValidator getEValidator() {
                return CatValidator.INSTANCE;
            }
        });

        // Mark meta-data to indicate it can't be changed
        theCatPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CatPackage.eNS_URI, theCatPackage);
        return theCatPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAuthoritativeSourceType() {
        return authoritativeSourceTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthoritativeSourceType_ASName() {
        return (EAttribute) authoritativeSourceTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthoritativeSourceType_ASAddressText() {
        return (EAttribute) authoritativeSourceTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthoritativeSourceType_ASWebSiteURL() {
        return (EAttribute) authoritativeSourceTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAuthoritativeSourceType_POC() {
        return (EReference) authoritativeSourceTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCatalogType() {
        return catalogTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_ArtifactGroup() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCatalogType_Artifact() {
        return (EReference) catalogTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCatalogType_Metadata() {
        return (EReference) catalogTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_DescriptionText() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_MpdClassCode() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_MpdName() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_MpdURI() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCatalogType_MpdVersionID() {
        return (EAttribute) catalogTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getCatalogType__SetMpdClassCode__String() {
        return catalogTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_Artifact() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ASAddressText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ASName() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ASWebSiteURL() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_AuthoritativeSource() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_Catalog() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_CreationDate() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_DomainText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ExchangePartnerName() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ExchangePatternText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_File() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_FileSet() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_Folder() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_KeywordText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_LastRevisionDate() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_Metadata() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_NextRevisionDate() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_POC() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_POCEmail() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_POCName() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_POCTelephone() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_PurposeText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDocumentRoot_Relationship() {
        return (EReference) documentRootEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_SecurityMarkingText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_StatusText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_DescriptionText() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ExternalURI() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_Files() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_Id() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_MpdClassCode() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(32);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_MpdName() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(33);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_MpdURI() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(34);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_MpdVersionID() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(35);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_NatureURI() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(36);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_PurposeURI() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(37);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_RelationshipCode() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(38);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_RelativePathName() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(39);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentRoot_ResourceURI() {
        return (EAttribute) documentRootEClass.getEStructuralFeatures().get(40);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFileSetType() {
        return fileSetTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFileSetType_File() {
        return (EReference) fileSetTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_DescriptionText() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_ExternalURI() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_Files() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_Id() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_NatureURI() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileSetType_PurposeURI() {
        return (EAttribute) fileSetTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFileType() {
        return fileTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_DescriptionText() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_ExternalURI() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_Id() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_NatureURI() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_PurposeURI() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFileType_RelativePathName() {
        return (EAttribute) fileTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFolderType() {
        return folderTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFolderType_DescriptionText() {
        return (EAttribute) folderTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFolderType_Id() {
        return (EAttribute) folderTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFolderType_RelativePathName() {
        return (EAttribute) folderTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMetadataType() {
        return metadataTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_SecurityMarkingText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_CreationDate() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_LastRevisionDate() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_NextRevisionDate() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_StatusText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMetadataType_Relationship() {
        return (EReference) metadataTypeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_KeywordText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_DomainText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_PurposeText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_ExchangePatternText() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMetadataType_ExchangePartnerName() {
        return (EAttribute) metadataTypeEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMetadataType_AuthoritativeSource() {
        return (EReference) metadataTypeEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getMetadataType__SetCreationDate__String() {
        return metadataTypeEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPOCType() {
        return pocTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPOCType_POCName() {
        return (EAttribute) pocTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPOCType_POCEmail() {
        return (EAttribute) pocTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPOCType_POCTelephone() {
        return (EAttribute) pocTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRelationshipType() {
        return relationshipTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRelationshipType_DescriptionText() {
        return (EAttribute) relationshipTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRelationshipType_RelationshipCode() {
        return (EAttribute) relationshipTypeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRelationshipType_ResourceURI() {
        return (EAttribute) relationshipTypeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getMPDClassCodeSimpleType() {
        return mpdClassCodeSimpleTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getRelationshipCodeSimpleType() {
        return relationshipCodeSimpleTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getMPDClassCodeSimpleTypeObject() {
        return mpdClassCodeSimpleTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getMPDVersionIDSimpleType() {
        return mpdVersionIDSimpleTypeEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getRelationshipCodeSimpleTypeObject() {
        return relationshipCodeSimpleTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getSafeCurieSimpleType() {
        return safeCurieSimpleTypeEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getURISimpleType() {
        return uriSimpleTypeEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CatFactory getCatFactory() {
        return (CatFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its
     * first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        authoritativeSourceTypeEClass = createEClass(AUTHORITATIVE_SOURCE_TYPE);
        createEAttribute(authoritativeSourceTypeEClass, AUTHORITATIVE_SOURCE_TYPE__AS_NAME);
        createEAttribute(authoritativeSourceTypeEClass, AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT);
        createEAttribute(authoritativeSourceTypeEClass, AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL);
        createEReference(authoritativeSourceTypeEClass, AUTHORITATIVE_SOURCE_TYPE__POC);

        catalogTypeEClass = createEClass(CATALOG_TYPE);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__ARTIFACT_GROUP);
        createEReference(catalogTypeEClass, CATALOG_TYPE__ARTIFACT);
        createEReference(catalogTypeEClass, CATALOG_TYPE__METADATA);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__DESCRIPTION_TEXT);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__MPD_CLASS_CODE);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__MPD_NAME);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__MPD_URI);
        createEAttribute(catalogTypeEClass, CATALOG_TYPE__MPD_VERSION_ID);
        createEOperation(catalogTypeEClass, CATALOG_TYPE___SET_MPD_CLASS_CODE__STRING);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ARTIFACT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__AS_ADDRESS_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__AS_NAME);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__AS_WEB_SITE_URL);
        createEReference(documentRootEClass, DOCUMENT_ROOT__AUTHORITATIVE_SOURCE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CATALOG);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__CREATION_DATE);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__DOMAIN_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FILE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FILE_SET);
        createEReference(documentRootEClass, DOCUMENT_ROOT__FOLDER);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__KEYWORD_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__LAST_REVISION_DATE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__METADATA);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__NEXT_REVISION_DATE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__POC);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__POC_EMAIL);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__POC_NAME);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__POC_TELEPHONE);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__PURPOSE_TEXT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__RELATIONSHIP);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__SECURITY_MARKING_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__STATUS_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__DESCRIPTION_TEXT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__EXTERNAL_URI);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__FILES);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__ID);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MPD_CLASS_CODE);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MPD_NAME);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MPD_URI);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MPD_VERSION_ID);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__NATURE_URI);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__PURPOSE_URI);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__RELATIONSHIP_CODE);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__RELATIVE_PATH_NAME);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__RESOURCE_URI);

        fileSetTypeEClass = createEClass(FILE_SET_TYPE);
        createEReference(fileSetTypeEClass, FILE_SET_TYPE__FILE);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__DESCRIPTION_TEXT);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__EXTERNAL_URI);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__FILES);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__ID);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__NATURE_URI);
        createEAttribute(fileSetTypeEClass, FILE_SET_TYPE__PURPOSE_URI);

        fileTypeEClass = createEClass(FILE_TYPE);
        createEAttribute(fileTypeEClass, FILE_TYPE__DESCRIPTION_TEXT);
        createEAttribute(fileTypeEClass, FILE_TYPE__EXTERNAL_URI);
        createEAttribute(fileTypeEClass, FILE_TYPE__ID);
        createEAttribute(fileTypeEClass, FILE_TYPE__NATURE_URI);
        createEAttribute(fileTypeEClass, FILE_TYPE__PURPOSE_URI);
        createEAttribute(fileTypeEClass, FILE_TYPE__RELATIVE_PATH_NAME);

        folderTypeEClass = createEClass(FOLDER_TYPE);
        createEAttribute(folderTypeEClass, FOLDER_TYPE__DESCRIPTION_TEXT);
        createEAttribute(folderTypeEClass, FOLDER_TYPE__ID);
        createEAttribute(folderTypeEClass, FOLDER_TYPE__RELATIVE_PATH_NAME);

        metadataTypeEClass = createEClass(METADATA_TYPE);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__SECURITY_MARKING_TEXT);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__CREATION_DATE);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__LAST_REVISION_DATE);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__NEXT_REVISION_DATE);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__STATUS_TEXT);
        createEReference(metadataTypeEClass, METADATA_TYPE__RELATIONSHIP);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__KEYWORD_TEXT);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__DOMAIN_TEXT);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__PURPOSE_TEXT);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__EXCHANGE_PATTERN_TEXT);
        createEAttribute(metadataTypeEClass, METADATA_TYPE__EXCHANGE_PARTNER_NAME);
        createEReference(metadataTypeEClass, METADATA_TYPE__AUTHORITATIVE_SOURCE);
        createEOperation(metadataTypeEClass, METADATA_TYPE___SET_CREATION_DATE__STRING);

        pocTypeEClass = createEClass(POC_TYPE);
        createEAttribute(pocTypeEClass, POC_TYPE__POC_NAME);
        createEAttribute(pocTypeEClass, POC_TYPE__POC_EMAIL);
        createEAttribute(pocTypeEClass, POC_TYPE__POC_TELEPHONE);

        relationshipTypeEClass = createEClass(RELATIONSHIP_TYPE);
        createEAttribute(relationshipTypeEClass, RELATIONSHIP_TYPE__DESCRIPTION_TEXT);
        createEAttribute(relationshipTypeEClass, RELATIONSHIP_TYPE__RELATIONSHIP_CODE);
        createEAttribute(relationshipTypeEClass, RELATIONSHIP_TYPE__RESOURCE_URI);

        // Create enums
        mpdClassCodeSimpleTypeEEnum = createEEnum(MPD_CLASS_CODE_SIMPLE_TYPE);
        relationshipCodeSimpleTypeEEnum = createEEnum(RELATIONSHIP_CODE_SIMPLE_TYPE);

        // Create data types
        mpdClassCodeSimpleTypeObjectEDataType = createEDataType(MPD_CLASS_CODE_SIMPLE_TYPE_OBJECT);
        mpdVersionIDSimpleTypeEDataType = createEDataType(MPD_VERSION_ID_SIMPLE_TYPE);
        relationshipCodeSimpleTypeObjectEDataType = createEDataType(RELATIONSHIP_CODE_SIMPLE_TYPE_OBJECT);
        safeCurieSimpleTypeEDataType = createEDataType(SAFE_CURIE_SIMPLE_TYPE);
        uriSimpleTypeEDataType = createEDataType(URI_SIMPLE_TYPE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        final XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
                .getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass(authoritativeSourceTypeEClass, AuthoritativeSourceType.class, "AuthoritativeSourceType", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAuthoritativeSourceType_ASName(), theXMLTypePackage.getString(), "aSName", null, 1, 1,
                AuthoritativeSourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAuthoritativeSourceType_ASAddressText(), theXMLTypePackage.getString(), "aSAddressText", null, 0,
                1, AuthoritativeSourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAuthoritativeSourceType_ASWebSiteURL(), theXMLTypePackage.getAnyURI(), "aSWebSiteURL", null, 0, 1,
                AuthoritativeSourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAuthoritativeSourceType_POC(), getPOCType(), null, "pOC", null, 1, -1,
                AuthoritativeSourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(catalogTypeEClass, CatalogType.class, "CatalogType", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCatalogType_ArtifactGroup(), ecorePackage.getEFeatureMapEntry(), "artifactGroup", null, 1, -1,
                CatalogType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getCatalogType_Artifact(), ecorePackage.getEObject(), null, "artifact", null, 1, -1,
                CatalogType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getCatalogType_Metadata(), getMetadataType(), null, "metadata", null, 1, 1, CatalogType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCatalogType_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                CatalogType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCatalogType_MpdClassCode(), getMPDClassCodeSimpleType(), "mpdClassCode", null, 1, 1,
                CatalogType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCatalogType_MpdName(), theXMLTypePackage.getString(), "mpdName", null, 1, 1, CatalogType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCatalogType_MpdURI(), getURISimpleType(), "mpdURI", null, 1, 1, CatalogType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCatalogType_MpdVersionID(), getMPDVersionIDSimpleType(), "mpdVersionID", null, 1, 1,
                CatalogType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        EOperation op = initEOperation(getCatalogType__SetMpdClassCode__String(), null, "setMpdClassCode", 1, 1, !IS_UNIQUE,
                !IS_ORDERED);
        addEParameter(op, theXMLTypePackage.getString(), "mpdClassCode", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap",
                null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null,
                "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Artifact(), ecorePackage.getEObject(), null, "artifact", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ASAddressText(), theXMLTypePackage.getString(), "aSAddressText", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ASName(), theXMLTypePackage.getString(), "aSName", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ASWebSiteURL(), theXMLTypePackage.getAnyURI(), "aSWebSiteURL", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_AuthoritativeSource(), getAuthoritativeSourceType(), null, "authoritativeSource",
                null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Catalog(), getCatalogType(), null, "catalog", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getDocumentRoot_CreationDate(), theXMLTypePackage.getDate(), "creationDate", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_DomainText(), theXMLTypePackage.getString(), "domainText", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ExchangePartnerName(), theXMLTypePackage.getString(), "exchangePartnerName", null, 0,
                -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getDocumentRoot_ExchangePatternText(), theXMLTypePackage.getString(), "exchangePatternText", null, 0,
                -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEReference(getDocumentRoot_File(), getFileType(), null, "file", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_FileSet(), getFileSetType(), null, "fileSet", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEReference(getDocumentRoot_Folder(), getFolderType(), null, "folder", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getDocumentRoot_KeywordText(), theXMLTypePackage.getString(), "keywordText", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_LastRevisionDate(), theXMLTypePackage.getDate(), "lastRevisionDate", null, 0, -2,
                null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Metadata(), getMetadataType(), null, "metadata", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getDocumentRoot_NextRevisionDate(), theXMLTypePackage.getDate(), "nextRevisionDate", null, 0, -2,
                null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_POC(), getPOCType(), null, "pOC", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_POCEmail(), theXMLTypePackage.getString(), "pOCEmail", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_POCName(), theXMLTypePackage.getString(), "pOCName", null, 0, -2, null, IS_TRANSIENT,
                IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_POCTelephone(), theXMLTypePackage.getString(), "pOCTelephone", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_PurposeText(), theXMLTypePackage.getString(), "purposeText", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Relationship(), getRelationshipType(), null, "relationship", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_SecurityMarkingText(), theXMLTypePackage.getString(), "securityMarkingText",
                "unclassified", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_StatusText(), theXMLTypePackage.getString(), "statusText", null, 0, -2, null,
                IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ExternalURI(), getURISimpleType(), "externalURI", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_Files(), theXMLTypePackage.getIDREFS(), "files", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_MpdClassCode(), getMPDClassCodeSimpleType(), "mpdClassCode", null, 0, 1, null,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_MpdName(), theXMLTypePackage.getString(), "mpdName", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_MpdURI(), getURISimpleType(), "mpdURI", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_MpdVersionID(), getMPDVersionIDSimpleType(), "mpdVersionID", null, 0, 1, null,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_NatureURI(), getURISimpleType(), "natureURI", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_PurposeURI(), getURISimpleType(), "purposeURI", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_RelationshipCode(), getRelationshipCodeSimpleType(), "relationshipCode", null, 0, 1,
                null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_RelativePathName(), theXMLTypePackage.getString(), "relativePathName", null, 0, 1,
                null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentRoot_ResourceURI(), getURISimpleType(), "resourceURI", null, 0, 1, null, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fileSetTypeEClass, FileSetType.class, "FileSetType", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFileSetType_File(), getFileType(), null, "file", null, 0, -1, FileSetType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getFileSetType_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                FileSetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileSetType_ExternalURI(), getURISimpleType(), "externalURI", null, 0, 1, FileSetType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileSetType_Files(), theXMLTypePackage.getIDREFS(), "files", null, 0, 1, FileSetType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileSetType_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, FileSetType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileSetType_NatureURI(), getURISimpleType(), "natureURI", null, 1, 1, FileSetType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileSetType_PurposeURI(), getURISimpleType(), "purposeURI", null, 1, 1, FileSetType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fileTypeEClass, FileType.class, "FileType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFileType_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                FileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getFileType_ExternalURI(), getURISimpleType(), "externalURI", null, 0, 1, FileType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileType_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, FileType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileType_NatureURI(), getURISimpleType(), "natureURI", null, 1, 1, FileType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileType_PurposeURI(), getURISimpleType(), "purposeURI", null, 1, 1, FileType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileType_RelativePathName(), theXMLTypePackage.getString(), "relativePathName", null, 1, 1,
                FileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(folderTypeEClass, FolderType.class, "FolderType", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFolderType_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                FolderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFolderType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, FolderType.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFolderType_RelativePathName(), theXMLTypePackage.getString(), "relativePathName", null, 1, 1,
                FolderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(metadataTypeEClass, MetadataType.class, "MetadataType", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMetadataType_SecurityMarkingText(), theXMLTypePackage.getString(), "securityMarkingText",
                "unclassified", 1, 1, MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_CreationDate(), theXMLTypePackage.getDate(), "creationDate", null, 1, 1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_LastRevisionDate(), theXMLTypePackage.getDate(), "lastRevisionDate", null, 0, 1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_NextRevisionDate(), theXMLTypePackage.getDate(), "nextRevisionDate", null, 0, 1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_StatusText(), theXMLTypePackage.getString(), "statusText", null, 0, 1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getMetadataType_Relationship(), getRelationshipType(), null, "relationship", null, 0, -1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_KeywordText(), theXMLTypePackage.getString(), "keywordText", null, 1, -1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_DomainText(), theXMLTypePackage.getString(), "domainText", null, 1, -1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_PurposeText(), theXMLTypePackage.getString(), "purposeText", null, 0, -1,
                MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_ExchangePatternText(), theXMLTypePackage.getString(), "exchangePatternText", null, 0,
                -1, MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMetadataType_ExchangePartnerName(), theXMLTypePackage.getString(), "exchangePartnerName", null, 0,
                -1, MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getMetadataType_AuthoritativeSource(), getAuthoritativeSourceType(), null, "authoritativeSource",
                null, 1, 1, MetadataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getMetadataType__SetCreationDate__String(), null, "setCreationDate", 1, 1, !IS_UNIQUE,
                !IS_ORDERED);
        addEParameter(op, theXMLTypePackage.getString(), "dateString", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(pocTypeEClass, POCType.class, "POCType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPOCType_POCName(), theXMLTypePackage.getString(), "pOCName", null, 1, 1, POCType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPOCType_POCEmail(), theXMLTypePackage.getString(), "pOCEmail", null, 1, -1, POCType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPOCType_POCTelephone(), theXMLTypePackage.getString(), "pOCTelephone", null, 1, -1, POCType.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(relationshipTypeEClass, RelationshipType.class, "RelationshipType", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRelationshipType_DescriptionText(), theXMLTypePackage.getString(), "descriptionText", null, 0, 1,
                RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRelationshipType_RelationshipCode(), getRelationshipCodeSimpleType(), "relationshipCode", null, 1,
                1, RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRelationshipType_ResourceURI(), getURISimpleType(), "resourceURI", null, 1, 1,
                RelationshipType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.class, "MPDClassCodeSimpleType");
        addEEnumLiteral(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.RELEASE);
        addEEnumLiteral(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.CORE_UPDATE);
        addEEnumLiteral(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.DOMAIN_UPDATE);
        addEEnumLiteral(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.IEPD);
        addEEnumLiteral(mpdClassCodeSimpleTypeEEnum, MPDClassCodeSimpleType.EIEM);

        initEEnum(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.class, "RelationshipCodeSimpleType");
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.VERSION_OF);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.SPECIALIZES);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.GENERALIZES);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.SUPERSEDES);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.DEPRECATES);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.ADAPTS);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.UPDATES);
        addEEnumLiteral(relationshipCodeSimpleTypeEEnum, RelationshipCodeSimpleType.CONFORMS_TO);

        // Initialize data types
        initEDataType(mpdClassCodeSimpleTypeObjectEDataType, MPDClassCodeSimpleType.class, "MPDClassCodeSimpleTypeObject",
                IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(mpdVersionIDSimpleTypeEDataType, String.class, "MPDVersionIDSimpleType", IS_SERIALIZABLE,
                !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(relationshipCodeSimpleTypeObjectEDataType, RelationshipCodeSimpleType.class,
                "RelationshipCodeSimpleTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(safeCurieSimpleTypeEDataType, String.class, "SafeCurieSimpleType", IS_SERIALIZABLE,
                !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(uriSimpleTypeEDataType, String.class, "URISimpleType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExtendedMetaDataAnnotations() {
        final String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
        addAnnotation(authoritativeSourceTypeEClass, source, new String[] { "name", "AuthoritativeSourceType", "kind",
                "elementOnly" });
        addAnnotation(getAuthoritativeSourceType_ASName(), source, new String[] { "kind", "element", "name", "ASName",
                "namespace", "##targetNamespace" });
        addAnnotation(getAuthoritativeSourceType_ASAddressText(), source, new String[] { "kind", "element", "name",
                "ASAddressText", "namespace", "##targetNamespace" });
        addAnnotation(getAuthoritativeSourceType_ASWebSiteURL(), source, new String[] { "kind", "element", "name",
                "ASWebSiteURL", "namespace", "##targetNamespace" });
        addAnnotation(getAuthoritativeSourceType_POC(), source, new String[] { "kind", "element", "name", "POC",
                "namespace", "##targetNamespace" });
        addAnnotation(catalogTypeEClass, source, new String[] { "name", "CatalogType", "kind", "elementOnly" });
        addAnnotation(getCatalogType_ArtifactGroup(), source, new String[] { "kind", "group", "name", "Artifact:group",
                "namespace", "##targetNamespace" });
        addAnnotation(getCatalogType_Artifact(), source, new String[] { "kind", "element", "name", "Artifact", "namespace",
                "##targetNamespace", "group", "Artifact:group" });
        addAnnotation(getCatalogType_Metadata(), source, new String[] { "kind", "element", "name", "Metadata", "namespace",
                "##targetNamespace" });
        addAnnotation(getCatalogType_DescriptionText(), source, new String[] { "kind", "attribute", "name",
                "descriptionText", "namespace", "##targetNamespace" });
        addAnnotation(getCatalogType_MpdClassCode(), source, new String[] { "kind", "attribute", "name", "mpdClassCode",
                "namespace", "##targetNamespace" });
        addAnnotation(getCatalogType_MpdName(), source, new String[] { "kind", "attribute", "name", "mpdName", "namespace",
                "##targetNamespace" });
        addAnnotation(getCatalogType_MpdURI(), source, new String[] { "kind", "attribute", "name", "mpdURI", "namespace",
                "##targetNamespace" });
        addAnnotation(getCatalogType_MpdVersionID(), source, new String[] { "kind", "attribute", "name", "mpdVersionID",
                "namespace", "##targetNamespace" });
        addAnnotation(documentRootEClass, source, new String[] { "name", "", "kind", "mixed" });
        addAnnotation(getDocumentRoot_Mixed(), source, new String[] { "kind", "elementWildcard", "name", ":mixed" });
        addAnnotation(getDocumentRoot_XMLNSPrefixMap(), source, new String[] { "kind", "attribute", "name", "xmlns:prefix" });
        addAnnotation(getDocumentRoot_XSISchemaLocation(), source, new String[] { "kind", "attribute", "name",
                "xsi:schemaLocation" });
        addAnnotation(getDocumentRoot_Artifact(), source, new String[] { "kind", "element", "name", "Artifact", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_ASAddressText(), source, new String[] { "kind", "element", "name", "ASAddressText",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_ASName(), source, new String[] { "kind", "element", "name", "ASName", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_ASWebSiteURL(), source, new String[] { "kind", "element", "name", "ASWebSiteURL",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_AuthoritativeSource(), source, new String[] { "kind", "element", "name",
                "AuthoritativeSource", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_Catalog(), source, new String[] { "kind", "element", "name", "Catalog", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_CreationDate(), source, new String[] { "kind", "element", "name", "CreationDate",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_DomainText(), source, new String[] { "kind", "element", "name", "DomainText",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_ExchangePartnerName(), source, new String[] { "kind", "element", "name",
                "ExchangePartnerName", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_ExchangePatternText(), source, new String[] { "kind", "element", "name",
                "ExchangePatternText", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_File(), source, new String[] { "kind", "element", "name", "File", "namespace",
                "##targetNamespace", "affiliation", "Artifact" });
        addAnnotation(getDocumentRoot_FileSet(), source, new String[] { "kind", "element", "name", "FileSet", "namespace",
                "##targetNamespace", "affiliation", "Artifact" });
        addAnnotation(getDocumentRoot_Folder(), source, new String[] { "kind", "element", "name", "Folder", "namespace",
                "##targetNamespace", "affiliation", "Artifact" });
        addAnnotation(getDocumentRoot_KeywordText(), source, new String[] { "kind", "element", "name", "KeywordText",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_LastRevisionDate(), source, new String[] { "kind", "element", "name",
                "LastRevisionDate", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_Metadata(), source, new String[] { "kind", "element", "name", "Metadata", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_NextRevisionDate(), source, new String[] { "kind", "element", "name",
                "NextRevisionDate", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_POC(), source, new String[] { "kind", "element", "name", "POC", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_POCEmail(), source, new String[] { "kind", "element", "name", "POCEmail", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_POCName(), source, new String[] { "kind", "element", "name", "POCName", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_POCTelephone(), source, new String[] { "kind", "element", "name", "POCTelephone",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_PurposeText(), source, new String[] { "kind", "element", "name", "PurposeText",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_Relationship(), source, new String[] { "kind", "element", "name", "Relationship",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_SecurityMarkingText(), source, new String[] { "kind", "element", "name",
                "SecurityMarkingText", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_StatusText(), source, new String[] { "kind", "element", "name", "StatusText",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_DescriptionText(), source, new String[] { "kind", "attribute", "name",
                "descriptionText", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_ExternalURI(), source, new String[] { "kind", "attribute", "name", "externalURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_Files(), source, new String[] { "kind", "attribute", "name", "files", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_Id(), source, new String[] { "kind", "attribute", "name", "id", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_MpdClassCode(), source, new String[] { "kind", "attribute", "name", "mpdClassCode",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_MpdName(), source, new String[] { "kind", "attribute", "name", "mpdName", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_MpdURI(), source, new String[] { "kind", "attribute", "name", "mpdURI", "namespace",
                "##targetNamespace" });
        addAnnotation(getDocumentRoot_MpdVersionID(), source, new String[] { "kind", "attribute", "name", "mpdVersionID",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_NatureURI(), source, new String[] { "kind", "attribute", "name", "natureURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_PurposeURI(), source, new String[] { "kind", "attribute", "name", "purposeURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_RelationshipCode(), source, new String[] { "kind", "attribute", "name",
                "relationshipCode", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_RelativePathName(), source, new String[] { "kind", "attribute", "name",
                "relativePathName", "namespace", "##targetNamespace" });
        addAnnotation(getDocumentRoot_ResourceURI(), source, new String[] { "kind", "attribute", "name", "resourceURI",
                "namespace", "##targetNamespace" });
        addAnnotation(fileSetTypeEClass, source, new String[] { "name", "FileSetType", "kind", "elementOnly" });
        addAnnotation(getFileSetType_File(), source, new String[] { "kind", "element", "name", "File", "namespace",
                "##targetNamespace" });
        addAnnotation(getFileSetType_DescriptionText(), source, new String[] { "kind", "attribute", "name",
                "descriptionText", "namespace", "##targetNamespace" });
        addAnnotation(getFileSetType_ExternalURI(), source, new String[] { "kind", "attribute", "name", "externalURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getFileSetType_Files(), source, new String[] { "kind", "attribute", "name", "files", "namespace",
                "##targetNamespace" });
        addAnnotation(getFileSetType_Id(), source, new String[] { "kind", "attribute", "name", "id", "namespace",
                "##targetNamespace" });
        addAnnotation(getFileSetType_NatureURI(), source, new String[] { "kind", "attribute", "name", "natureURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getFileSetType_PurposeURI(), source, new String[] { "kind", "attribute", "name", "purposeURI",
                "namespace", "##targetNamespace" });
        addAnnotation(fileTypeEClass, source, new String[] { "name", "FileType", "kind", "empty" });
        addAnnotation(getFileType_DescriptionText(), source, new String[] { "kind", "attribute", "name", "descriptionText",
                "namespace", "##targetNamespace" });
        addAnnotation(getFileType_ExternalURI(), source, new String[] { "kind", "attribute", "name", "externalURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getFileType_Id(), source, new String[] { "kind", "attribute", "name", "id", "namespace",
                "##targetNamespace" });
        addAnnotation(getFileType_NatureURI(), source, new String[] { "kind", "attribute", "name", "natureURI", "namespace",
                "##targetNamespace" });
        addAnnotation(getFileType_PurposeURI(), source, new String[] { "kind", "attribute", "name", "purposeURI",
                "namespace", "##targetNamespace" });
        addAnnotation(getFileType_RelativePathName(), source, new String[] { "kind", "attribute", "name",
                "relativePathName", "namespace", "##targetNamespace" });
        addAnnotation(folderTypeEClass, source, new String[] { "name", "FolderType", "kind", "empty" });
        addAnnotation(getFolderType_DescriptionText(), source, new String[] { "kind", "attribute", "name",
                "descriptionText", "namespace", "##targetNamespace" });
        addAnnotation(getFolderType_Id(), source, new String[] { "kind", "attribute", "name", "id", "namespace",
                "##targetNamespace" });
        addAnnotation(getFolderType_RelativePathName(), source, new String[] { "kind", "attribute", "name",
                "relativePathName", "namespace", "##targetNamespace" });
        addAnnotation(metadataTypeEClass, source, new String[] { "name", "MetadataType", "kind", "elementOnly" });
        addAnnotation(getMetadataType_SecurityMarkingText(), source, new String[] { "kind", "element", "name",
                "SecurityMarkingText", "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_CreationDate(), source, new String[] { "kind", "element", "name", "CreationDate",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_LastRevisionDate(), source, new String[] { "kind", "element", "name",
                "LastRevisionDate", "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_NextRevisionDate(), source, new String[] { "kind", "element", "name",
                "NextRevisionDate", "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_StatusText(), source, new String[] { "kind", "element", "name", "StatusText",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_Relationship(), source, new String[] { "kind", "element", "name", "Relationship",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_KeywordText(), source, new String[] { "kind", "element", "name", "KeywordText",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_DomainText(), source, new String[] { "kind", "element", "name", "DomainText",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_PurposeText(), source, new String[] { "kind", "element", "name", "PurposeText",
                "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_ExchangePatternText(), source, new String[] { "kind", "element", "name",
                "ExchangePatternText", "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_ExchangePartnerName(), source, new String[] { "kind", "element", "name",
                "ExchangePartnerName", "namespace", "##targetNamespace" });
        addAnnotation(getMetadataType_AuthoritativeSource(), source, new String[] { "kind", "element", "name",
                "AuthoritativeSource", "namespace", "##targetNamespace" });
        addAnnotation(mpdClassCodeSimpleTypeEEnum, source, new String[] { "name", "MPDClassCodeSimpleType" });
        addAnnotation(mpdClassCodeSimpleTypeObjectEDataType, source, new String[] { "name", "MPDClassCodeSimpleType:Object",
                "baseType", "MPDClassCodeSimpleType" });
        addAnnotation(mpdVersionIDSimpleTypeEDataType, source, new String[] { "name", "MPDVersionIDSimpleType", "baseType",
                "http://www.eclipse.org/emf/2003/XMLType#token", "minLength", "1", "pattern",
                "[0-9]+(\\.[0-9]+)*((alpha|beta|rc|rev)[0-9]+)?" });
        addAnnotation(pocTypeEClass, source, new String[] { "name", "POCType", "kind", "elementOnly" });
        addAnnotation(getPOCType_POCName(), source, new String[] { "kind", "element", "name", "POCName", "namespace",
                "##targetNamespace" });
        addAnnotation(getPOCType_POCEmail(), source, new String[] { "kind", "element", "name", "POCEmail", "namespace",
                "##targetNamespace" });
        addAnnotation(getPOCType_POCTelephone(), source, new String[] { "kind", "element", "name", "POCTelephone",
                "namespace", "##targetNamespace" });
        addAnnotation(relationshipCodeSimpleTypeEEnum, source, new String[] { "name", "RelationshipCodeSimpleType" });
        addAnnotation(relationshipCodeSimpleTypeObjectEDataType, source, new String[] { "name",
                "RelationshipCodeSimpleType:Object", "baseType", "RelationshipCodeSimpleType" });
        addAnnotation(relationshipTypeEClass, source, new String[] { "name", "RelationshipType", "kind", "empty" });
        addAnnotation(getRelationshipType_DescriptionText(), source, new String[] { "kind", "attribute", "name",
                "descriptionText", "namespace", "##targetNamespace" });
        addAnnotation(getRelationshipType_RelationshipCode(), source, new String[] { "kind", "attribute", "name",
                "relationshipCode", "namespace", "##targetNamespace" });
        addAnnotation(getRelationshipType_ResourceURI(), source, new String[] { "kind", "attribute", "name", "resourceURI",
                "namespace", "##targetNamespace" });
        addAnnotation(safeCurieSimpleTypeEDataType, source, new String[] { "name", "SafeCurieSimpleType", "baseType",
                "http://www.eclipse.org/emf/2003/XMLType#string", "minLength", "3", "pattern",
                "\\[(([\\i-[:]][\\c-[:]]*)?:)?.+\\]" });
        addAnnotation(uriSimpleTypeEDataType, source, new String[] { "name", "URISimpleType", "memberTypes",
                "http://www.eclipse.org/emf/2003/XMLType#anyURI SafeCurieSimpleType" });
    }

} // CatPackageImpl
