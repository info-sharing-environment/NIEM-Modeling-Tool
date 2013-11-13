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

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Document Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getArtifact <em>Artifact</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getASAddressText <em>AS Address Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getASName <em>AS Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getASWebSiteURL <em>AS Web Site URL</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getAuthoritativeSource <em>Authoritative Source</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getCatalog <em>Catalog</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getDomainText <em>Domain Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getExchangePartnerName <em>Exchange Partner Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getExchangePatternText <em>Exchange Pattern Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getFile <em>File</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getFileSet <em>File Set</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getFolder <em>Folder</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getKeywordText <em>Keyword Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getLastRevisionDate <em>Last Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMetadata <em>Metadata</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getNextRevisionDate <em>Next Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPOC <em>POC</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPOCEmail <em>POC Email</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPOCName <em>POC Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPOCTelephone <em>POC Telephone</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPurposeText <em>Purpose Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getRelationship <em>Relationship</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getSecurityMarkingText <em>Security Marking Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getStatusText <em>Status Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getExternalURI <em>External URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getFiles <em>Files</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getId <em>Id</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMpdClassCode <em>Mpd Class Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMpdName <em>Mpd Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMpdURI <em>Mpd URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getMpdVersionID <em>Mpd Version ID</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getNatureURI <em>Nature URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getPurposeURI <em>Purpose URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getRelationshipCode <em>Relationship Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getRelativePathName <em>Relative Path Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.DocumentRootImpl#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getXMLNSPrefixMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xMLNSPrefixMap;

    /**
     * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getXSISchemaLocation()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xSISchemaLocation;

    /**
     * The default value of the '{@link #getASAddressText() <em>AS Address Text</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getASAddressText()
     * @generated
     * @ordered
     */
    protected static final String AS_ADDRESS_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getASName() <em>AS Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getASName()
     * @generated
     * @ordered
     */
    protected static final String AS_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getASWebSiteURL() <em>AS Web Site URL</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getASWebSiteURL()
     * @generated
     * @ordered
     */
    protected static final String AS_WEB_SITE_URL_EDEFAULT = null;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar CREATION_DATE_EDEFAULT = null;

    /**
     * The default value of the '{@link #getDomainText() <em>Domain Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDomainText()
     * @generated
     * @ordered
     */
    protected static final String DOMAIN_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getExchangePartnerName() <em>Exchange Partner Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExchangePartnerName()
     * @generated
     * @ordered
     */
    protected static final String EXCHANGE_PARTNER_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getExchangePatternText() <em>Exchange Pattern Text</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExchangePatternText()
     * @generated
     * @ordered
     */
    protected static final String EXCHANGE_PATTERN_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getKeywordText() <em>Keyword Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getKeywordText()
     * @generated
     * @ordered
     */
    protected static final String KEYWORD_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getLastRevisionDate() <em>Last Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getLastRevisionDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar LAST_REVISION_DATE_EDEFAULT = null;

    /**
     * The default value of the '{@link #getNextRevisionDate() <em>Next Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getNextRevisionDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar NEXT_REVISION_DATE_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPOCEmail() <em>POC Email</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOCEmail()
     * @generated
     * @ordered
     */
    protected static final String POC_EMAIL_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPOCName() <em>POC Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOCName()
     * @generated
     * @ordered
     */
    protected static final String POC_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPOCTelephone() <em>POC Telephone</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOCTelephone()
     * @generated
     * @ordered
     */
    protected static final String POC_TELEPHONE_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPurposeText() <em>Purpose Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPurposeText()
     * @generated
     * @ordered
     */
    protected static final String PURPOSE_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getSecurityMarkingText() <em>Security Marking Text</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSecurityMarkingText()
     * @generated
     * @ordered
     */
    protected static final String SECURITY_MARKING_TEXT_EDEFAULT = "unclassified";

    /**
     * The default value of the '{@link #getStatusText() <em>Status Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStatusText()
     * @generated
     * @ordered
     */
    protected static final String STATUS_TEXT_EDEFAULT = null;

    /**
     * The default value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescriptionText()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescriptionText()
     * @generated
     * @ordered
     */
    protected String descriptionText = DESCRIPTION_TEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getExternalURI() <em>External URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getExternalURI()
     * @generated
     * @ordered
     */
    protected static final String EXTERNAL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExternalURI() <em>External URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getExternalURI()
     * @generated
     * @ordered
     */
    protected String externalURI = EXTERNAL_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getFiles() <em>Files</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFiles()
     * @generated
     * @ordered
     */
    protected static final List<String> FILES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFiles() <em>Files</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFiles()
     * @generated
     * @ordered
     */
    protected List<String> files = FILES_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getMpdClassCode() <em>Mpd Class Code</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdClassCode()
     * @generated
     * @ordered
     */
    protected static final MPDClassCodeSimpleType MPD_CLASS_CODE_EDEFAULT = MPDClassCodeSimpleType.RELEASE;

    /**
     * The cached value of the '{@link #getMpdClassCode() <em>Mpd Class Code</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdClassCode()
     * @generated
     * @ordered
     */
    protected MPDClassCodeSimpleType mpdClassCode = MPD_CLASS_CODE_EDEFAULT;

    /**
     * This is true if the Mpd Class Code attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean mpdClassCodeESet;

    /**
     * The default value of the '{@link #getMpdName() <em>Mpd Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdName()
     * @generated
     * @ordered
     */
    protected static final String MPD_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdName() <em>Mpd Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdName()
     * @generated
     * @ordered
     */
    protected String mpdName = MPD_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getMpdURI() <em>Mpd URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdURI()
     * @generated
     * @ordered
     */
    protected static final String MPD_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdURI() <em>Mpd URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdURI()
     * @generated
     * @ordered
     */
    protected String mpdURI = MPD_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getMpdVersionID() <em>Mpd Version ID</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdVersionID()
     * @generated
     * @ordered
     */
    protected static final String MPD_VERSION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdVersionID() <em>Mpd Version ID</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdVersionID()
     * @generated
     * @ordered
     */
    protected String mpdVersionID = MPD_VERSION_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getNatureURI() <em>Nature URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getNatureURI()
     * @generated
     * @ordered
     */
    protected static final String NATURE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNatureURI() <em>Nature URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getNatureURI()
     * @generated
     * @ordered
     */
    protected String natureURI = NATURE_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getPurposeURI() <em>Purpose URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPurposeURI()
     * @generated
     * @ordered
     */
    protected static final String PURPOSE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPurposeURI() <em>Purpose URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPurposeURI()
     * @generated
     * @ordered
     */
    protected String purposeURI = PURPOSE_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getRelationshipCode() <em>Relationship Code</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getRelationshipCode()
     * @generated
     * @ordered
     */
    protected static final RelationshipCodeSimpleType RELATIONSHIP_CODE_EDEFAULT = RelationshipCodeSimpleType.VERSION_OF;

    /**
     * The cached value of the '{@link #getRelationshipCode() <em>Relationship Code</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRelationshipCode()
     * @generated
     * @ordered
     */
    protected RelationshipCodeSimpleType relationshipCode = RELATIONSHIP_CODE_EDEFAULT;

    /**
     * This is true if the Relationship Code attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean relationshipCodeESet;

    /**
     * The default value of the '{@link #getRelativePathName() <em>Relative Path Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getRelativePathName()
     * @generated
     * @ordered
     */
    protected static final String RELATIVE_PATH_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRelativePathName() <em>Relative Path Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getRelativePathName()
     * @generated
     * @ordered
     */
    protected String relativePathName = RELATIVE_PATH_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResourceURI()
     * @generated
     * @ordered
     */
    protected static final String RESOURCE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResourceURI()
     * @generated
     * @ordered
     */
    protected String resourceURI = RESOURCE_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DocumentRootImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, CatPackage.DOCUMENT_ROOT__MIXED);
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EMap<String, String> getXMLNSPrefixMap() {
        if (xMLNSPrefixMap == null) {
            xMLNSPrefixMap = new EcoreEMap<String, String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
                    EStringToStringMapEntryImpl.class, this, CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        }
        return xMLNSPrefixMap;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EMap<String, String> getXSISchemaLocation() {
        if (xSISchemaLocation == null) {
            xSISchemaLocation = new EcoreEMap<String, String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
                    EStringToStringMapEntryImpl.class, this, CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject getArtifact() {
        return (EObject) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__ARTIFACT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetArtifact(final EObject newArtifact, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__ARTIFACT, newArtifact, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASAddressText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__AS_ADDRESS_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASAddressText(final String newASAddressText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__AS_ADDRESS_TEXT, newASAddressText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASName() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__AS_NAME, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASName(final String newASName) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__AS_NAME, newASName);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASWebSiteURL() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__AS_WEB_SITE_URL, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASWebSiteURL(final String newASWebSiteURL) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__AS_WEB_SITE_URL, newASWebSiteURL);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AuthoritativeSourceType getAuthoritativeSource() {
        return (AuthoritativeSourceType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetAuthoritativeSource(final AuthoritativeSourceType newAuthoritativeSource,
            final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE,
                newAuthoritativeSource, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAuthoritativeSource(final AuthoritativeSourceType newAuthoritativeSource) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE,
                newAuthoritativeSource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CatalogType getCatalog() {
        return (CatalogType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__CATALOG, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCatalog(final CatalogType newCatalog, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__CATALOG, newCatalog, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCatalog(final CatalogType newCatalog) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__CATALOG, newCatalog);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getCreationDate() {
        return (XMLGregorianCalendar) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__CREATION_DATE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCreationDate(final XMLGregorianCalendar newCreationDate) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__CREATION_DATE, newCreationDate);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDomainText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__DOMAIN_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDomainText(final String newDomainText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__DOMAIN_TEXT, newDomainText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getExchangePartnerName() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setExchangePartnerName(final String newExchangePartnerName) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME,
                newExchangePartnerName);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getExchangePatternText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setExchangePatternText(final String newExchangePatternText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT,
                newExchangePatternText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileType getFile() {
        return (FileType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__FILE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFile(final FileType newFile, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__FILE, newFile, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFile(final FileType newFile) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__FILE, newFile);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileSetType getFileSet() {
        return (FileSetType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFileSet(final FileSetType newFileSet, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, newFileSet, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFileSet(final FileSetType newFileSet) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, newFileSet);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FolderType getFolder() {
        return (FolderType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__FOLDER, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFolder(final FolderType newFolder, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__FOLDER, newFolder, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFolder(final FolderType newFolder) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__FOLDER, newFolder);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getKeywordText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__KEYWORD_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setKeywordText(final String newKeywordText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__KEYWORD_TEXT, newKeywordText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getLastRevisionDate() {
        return (XMLGregorianCalendar) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__LAST_REVISION_DATE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLastRevisionDate(final XMLGregorianCalendar newLastRevisionDate) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__LAST_REVISION_DATE, newLastRevisionDate);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MetadataType getMetadata() {
        return (MetadataType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__METADATA, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMetadata(final MetadataType newMetadata, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__METADATA, newMetadata, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMetadata(final MetadataType newMetadata) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__METADATA, newMetadata);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getNextRevisionDate() {
        return (XMLGregorianCalendar) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__NEXT_REVISION_DATE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNextRevisionDate(final XMLGregorianCalendar newNextRevisionDate) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__NEXT_REVISION_DATE, newNextRevisionDate);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public POCType getPOC() {
        return (POCType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__POC, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPOC(final POCType newPOC, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__POC, newPOC, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPOC(final POCType newPOC) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__POC, newPOC);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPOCEmail() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__POC_EMAIL, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPOCEmail(final String newPOCEmail) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__POC_EMAIL, newPOCEmail);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPOCName() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__POC_NAME, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPOCName(final String newPOCName) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__POC_NAME, newPOCName);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPOCTelephone() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__POC_TELEPHONE, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPOCTelephone(final String newPOCTelephone) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__POC_TELEPHONE, newPOCTelephone);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPurposeText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__PURPOSE_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPurposeText(final String newPurposeText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__PURPOSE_TEXT, newPurposeText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RelationshipType getRelationship() {
        return (RelationshipType) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__RELATIONSHIP, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRelationship(final RelationshipType newRelationship, final NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed()).basicAdd(CatPackage.Literals.DOCUMENT_ROOT__RELATIONSHIP, newRelationship,
                msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRelationship(final RelationshipType newRelationship) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__RELATIONSHIP, newRelationship);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSecurityMarkingText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__SECURITY_MARKING_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSecurityMarkingText(final String newSecurityMarkingText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__SECURITY_MARKING_TEXT,
                newSecurityMarkingText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getStatusText() {
        return (String) getMixed().get(CatPackage.Literals.DOCUMENT_ROOT__STATUS_TEXT, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStatusText(final String newStatusText) {
        ((FeatureMap.Internal) getMixed()).set(CatPackage.Literals.DOCUMENT_ROOT__STATUS_TEXT, newStatusText);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescriptionText() {
        return descriptionText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescriptionText(final String newDescriptionText) {
        final String oldDescriptionText = descriptionText;
        descriptionText = newDescriptionText;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__DESCRIPTION_TEXT,
                    oldDescriptionText, descriptionText));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getExternalURI() {
        return externalURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setExternalURI(final String newExternalURI) {
        final String oldExternalURI = externalURI;
        externalURI = newExternalURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__EXTERNAL_URI, oldExternalURI,
                    externalURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<String> getFiles() {
        return files;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFiles(final List<String> newFiles) {
        final List<String> oldFiles = files;
        files = newFiles;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__FILES, oldFiles, files));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setId(final String newId) {
        final String oldId = id;
        id = newId;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__ID, oldId, id));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MPDClassCodeSimpleType getMpdClassCode() {
        return mpdClassCode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdClassCode(final MPDClassCodeSimpleType newMpdClassCode) {
        final MPDClassCodeSimpleType oldMpdClassCode = mpdClassCode;
        mpdClassCode = newMpdClassCode == null ? MPD_CLASS_CODE_EDEFAULT : newMpdClassCode;
        final boolean oldMpdClassCodeESet = mpdClassCodeESet;
        mpdClassCodeESet = true;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE, oldMpdClassCode,
                    mpdClassCode, !oldMpdClassCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void unsetMpdClassCode() {
        final MPDClassCodeSimpleType oldMpdClassCode = mpdClassCode;
        final boolean oldMpdClassCodeESet = mpdClassCodeESet;
        mpdClassCode = MPD_CLASS_CODE_EDEFAULT;
        mpdClassCodeESet = false;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.UNSET, CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE,
                    oldMpdClassCode, MPD_CLASS_CODE_EDEFAULT, oldMpdClassCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSetMpdClassCode() {
        return mpdClassCodeESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdName() {
        return mpdName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdName(final String newMpdName) {
        final String oldMpdName = mpdName;
        mpdName = newMpdName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__MPD_NAME, oldMpdName, mpdName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdURI() {
        return mpdURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdURI(final String newMpdURI) {
        final String oldMpdURI = mpdURI;
        mpdURI = newMpdURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__MPD_URI, oldMpdURI, mpdURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdVersionID() {
        return mpdVersionID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdVersionID(final String newMpdVersionID) {
        final String oldMpdVersionID = mpdVersionID;
        mpdVersionID = newMpdVersionID;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__MPD_VERSION_ID, oldMpdVersionID,
                    mpdVersionID));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getNatureURI() {
        return natureURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNatureURI(final String newNatureURI) {
        final String oldNatureURI = natureURI;
        natureURI = newNatureURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__NATURE_URI, oldNatureURI,
                    natureURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPurposeURI() {
        return purposeURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPurposeURI(final String newPurposeURI) {
        final String oldPurposeURI = purposeURI;
        purposeURI = newPurposeURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__PURPOSE_URI, oldPurposeURI,
                    purposeURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RelationshipCodeSimpleType getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRelationshipCode(final RelationshipCodeSimpleType newRelationshipCode) {
        final RelationshipCodeSimpleType oldRelationshipCode = relationshipCode;
        relationshipCode = newRelationshipCode == null ? RELATIONSHIP_CODE_EDEFAULT : newRelationshipCode;
        final boolean oldRelationshipCodeESet = relationshipCodeESet;
        relationshipCodeESet = true;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE,
                    oldRelationshipCode, relationshipCode, !oldRelationshipCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void unsetRelationshipCode() {
        final RelationshipCodeSimpleType oldRelationshipCode = relationshipCode;
        final boolean oldRelationshipCodeESet = relationshipCodeESet;
        relationshipCode = RELATIONSHIP_CODE_EDEFAULT;
        relationshipCodeESet = false;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.UNSET, CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE,
                    oldRelationshipCode, RELATIONSHIP_CODE_EDEFAULT, oldRelationshipCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSetRelationshipCode() {
        return relationshipCodeESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getRelativePathName() {
        return relativePathName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRelativePathName(final String newRelativePathName) {
        final String oldRelativePathName = relativePathName;
        relativePathName = newRelativePathName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__RELATIVE_PATH_NAME,
                    oldRelativePathName, relativePathName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceURI(final String newResourceURI) {
        final String oldResourceURI = resourceURI;
        resourceURI = newResourceURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.DOCUMENT_ROOT__RESOURCE_URI, oldResourceURI,
                    resourceURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case CatPackage.DOCUMENT_ROOT__MIXED:
            return ((InternalEList<?>) getMixed()).basicRemove(otherEnd, msgs);
        case CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            return ((InternalEList<?>) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
        case CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            return ((InternalEList<?>) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
        case CatPackage.DOCUMENT_ROOT__ARTIFACT:
            return basicSetArtifact(null, msgs);
        case CatPackage.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE:
            return basicSetAuthoritativeSource(null, msgs);
        case CatPackage.DOCUMENT_ROOT__CATALOG:
            return basicSetCatalog(null, msgs);
        case CatPackage.DOCUMENT_ROOT__FILE:
            return basicSetFile(null, msgs);
        case CatPackage.DOCUMENT_ROOT__FILE_SET:
            return basicSetFileSet(null, msgs);
        case CatPackage.DOCUMENT_ROOT__FOLDER:
            return basicSetFolder(null, msgs);
        case CatPackage.DOCUMENT_ROOT__METADATA:
            return basicSetMetadata(null, msgs);
        case CatPackage.DOCUMENT_ROOT__POC:
            return basicSetPOC(null, msgs);
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP:
            return basicSetRelationship(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CatPackage.DOCUMENT_ROOT__MIXED:
            if (coreType) {
                return getMixed();
            }
            return ((FeatureMap.Internal) getMixed()).getWrapper();
        case CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            if (coreType) {
                return getXMLNSPrefixMap();
            } else {
                return getXMLNSPrefixMap().map();
            }
        case CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            if (coreType) {
                return getXSISchemaLocation();
            } else {
                return getXSISchemaLocation().map();
            }
        case CatPackage.DOCUMENT_ROOT__ARTIFACT:
            return getArtifact();
        case CatPackage.DOCUMENT_ROOT__AS_ADDRESS_TEXT:
            return getASAddressText();
        case CatPackage.DOCUMENT_ROOT__AS_NAME:
            return getASName();
        case CatPackage.DOCUMENT_ROOT__AS_WEB_SITE_URL:
            return getASWebSiteURL();
        case CatPackage.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE:
            return getAuthoritativeSource();
        case CatPackage.DOCUMENT_ROOT__CATALOG:
            return getCatalog();
        case CatPackage.DOCUMENT_ROOT__CREATION_DATE:
            return getCreationDate();
        case CatPackage.DOCUMENT_ROOT__DOMAIN_TEXT:
            return getDomainText();
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME:
            return getExchangePartnerName();
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT:
            return getExchangePatternText();
        case CatPackage.DOCUMENT_ROOT__FILE:
            return getFile();
        case CatPackage.DOCUMENT_ROOT__FILE_SET:
            return getFileSet();
        case CatPackage.DOCUMENT_ROOT__FOLDER:
            return getFolder();
        case CatPackage.DOCUMENT_ROOT__KEYWORD_TEXT:
            return getKeywordText();
        case CatPackage.DOCUMENT_ROOT__LAST_REVISION_DATE:
            return getLastRevisionDate();
        case CatPackage.DOCUMENT_ROOT__METADATA:
            return getMetadata();
        case CatPackage.DOCUMENT_ROOT__NEXT_REVISION_DATE:
            return getNextRevisionDate();
        case CatPackage.DOCUMENT_ROOT__POC:
            return getPOC();
        case CatPackage.DOCUMENT_ROOT__POC_EMAIL:
            return getPOCEmail();
        case CatPackage.DOCUMENT_ROOT__POC_NAME:
            return getPOCName();
        case CatPackage.DOCUMENT_ROOT__POC_TELEPHONE:
            return getPOCTelephone();
        case CatPackage.DOCUMENT_ROOT__PURPOSE_TEXT:
            return getPurposeText();
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP:
            return getRelationship();
        case CatPackage.DOCUMENT_ROOT__SECURITY_MARKING_TEXT:
            return getSecurityMarkingText();
        case CatPackage.DOCUMENT_ROOT__STATUS_TEXT:
            return getStatusText();
        case CatPackage.DOCUMENT_ROOT__DESCRIPTION_TEXT:
            return getDescriptionText();
        case CatPackage.DOCUMENT_ROOT__EXTERNAL_URI:
            return getExternalURI();
        case CatPackage.DOCUMENT_ROOT__FILES:
            return getFiles();
        case CatPackage.DOCUMENT_ROOT__ID:
            return getId();
        case CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE:
            return getMpdClassCode();
        case CatPackage.DOCUMENT_ROOT__MPD_NAME:
            return getMpdName();
        case CatPackage.DOCUMENT_ROOT__MPD_URI:
            return getMpdURI();
        case CatPackage.DOCUMENT_ROOT__MPD_VERSION_ID:
            return getMpdVersionID();
        case CatPackage.DOCUMENT_ROOT__NATURE_URI:
            return getNatureURI();
        case CatPackage.DOCUMENT_ROOT__PURPOSE_URI:
            return getPurposeURI();
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE:
            return getRelationshipCode();
        case CatPackage.DOCUMENT_ROOT__RELATIVE_PATH_NAME:
            return getRelativePathName();
        case CatPackage.DOCUMENT_ROOT__RESOURCE_URI:
            return getResourceURI();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CatPackage.DOCUMENT_ROOT__MIXED:
            ((FeatureMap.Internal) getMixed()).set(newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            ((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            ((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__AS_ADDRESS_TEXT:
            setASAddressText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__AS_NAME:
            setASName((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__AS_WEB_SITE_URL:
            setASWebSiteURL((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE:
            setAuthoritativeSource((AuthoritativeSourceType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__CATALOG:
            setCatalog((CatalogType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__CREATION_DATE:
            setCreationDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__DOMAIN_TEXT:
            setDomainText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME:
            setExchangePartnerName((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT:
            setExchangePatternText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__FILE:
            setFile((FileType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__FILE_SET:
            setFileSet((FileSetType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__FOLDER:
            setFolder((FolderType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__KEYWORD_TEXT:
            setKeywordText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__LAST_REVISION_DATE:
            setLastRevisionDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__METADATA:
            setMetadata((MetadataType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__NEXT_REVISION_DATE:
            setNextRevisionDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__POC:
            setPOC((POCType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_EMAIL:
            setPOCEmail((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_NAME:
            setPOCName((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_TELEPHONE:
            setPOCTelephone((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__PURPOSE_TEXT:
            setPurposeText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP:
            setRelationship((RelationshipType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__SECURITY_MARKING_TEXT:
            setSecurityMarkingText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__STATUS_TEXT:
            setStatusText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__DESCRIPTION_TEXT:
            setDescriptionText((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__EXTERNAL_URI:
            setExternalURI((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__FILES:
            setFiles((List<String>) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__ID:
            setId((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE:
            setMpdClassCode((MPDClassCodeSimpleType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_NAME:
            setMpdName((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_URI:
            setMpdURI((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_VERSION_ID:
            setMpdVersionID((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__NATURE_URI:
            setNatureURI((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__PURPOSE_URI:
            setPurposeURI((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE:
            setRelationshipCode((RelationshipCodeSimpleType) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIVE_PATH_NAME:
            setRelativePathName((String) newValue);
            return;
        case CatPackage.DOCUMENT_ROOT__RESOURCE_URI:
            setResourceURI((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case CatPackage.DOCUMENT_ROOT__MIXED:
            getMixed().clear();
            return;
        case CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            getXMLNSPrefixMap().clear();
            return;
        case CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            getXSISchemaLocation().clear();
            return;
        case CatPackage.DOCUMENT_ROOT__AS_ADDRESS_TEXT:
            setASAddressText(AS_ADDRESS_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__AS_NAME:
            setASName(AS_NAME_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__AS_WEB_SITE_URL:
            setASWebSiteURL(AS_WEB_SITE_URL_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE:
            setAuthoritativeSource((AuthoritativeSourceType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__CATALOG:
            setCatalog((CatalogType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__CREATION_DATE:
            setCreationDate(CREATION_DATE_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__DOMAIN_TEXT:
            setDomainText(DOMAIN_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME:
            setExchangePartnerName(EXCHANGE_PARTNER_NAME_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT:
            setExchangePatternText(EXCHANGE_PATTERN_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__FILE:
            setFile((FileType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__FILE_SET:
            setFileSet((FileSetType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__FOLDER:
            setFolder((FolderType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__KEYWORD_TEXT:
            setKeywordText(KEYWORD_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__LAST_REVISION_DATE:
            setLastRevisionDate(LAST_REVISION_DATE_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__METADATA:
            setMetadata((MetadataType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__NEXT_REVISION_DATE:
            setNextRevisionDate(NEXT_REVISION_DATE_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__POC:
            setPOC((POCType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_EMAIL:
            setPOCEmail(POC_EMAIL_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_NAME:
            setPOCName(POC_NAME_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__POC_TELEPHONE:
            setPOCTelephone(POC_TELEPHONE_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__PURPOSE_TEXT:
            setPurposeText(PURPOSE_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP:
            setRelationship((RelationshipType) null);
            return;
        case CatPackage.DOCUMENT_ROOT__SECURITY_MARKING_TEXT:
            setSecurityMarkingText(SECURITY_MARKING_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__STATUS_TEXT:
            setStatusText(STATUS_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__DESCRIPTION_TEXT:
            setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__EXTERNAL_URI:
            setExternalURI(EXTERNAL_URI_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__FILES:
            setFiles(FILES_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__ID:
            setId(ID_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE:
            unsetMpdClassCode();
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_NAME:
            setMpdName(MPD_NAME_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_URI:
            setMpdURI(MPD_URI_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__MPD_VERSION_ID:
            setMpdVersionID(MPD_VERSION_ID_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__NATURE_URI:
            setNatureURI(NATURE_URI_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__PURPOSE_URI:
            setPurposeURI(PURPOSE_URI_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE:
            unsetRelationshipCode();
            return;
        case CatPackage.DOCUMENT_ROOT__RELATIVE_PATH_NAME:
            setRelativePathName(RELATIVE_PATH_NAME_EDEFAULT);
            return;
        case CatPackage.DOCUMENT_ROOT__RESOURCE_URI:
            setResourceURI(RESOURCE_URI_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case CatPackage.DOCUMENT_ROOT__MIXED:
            return mixed != null && !mixed.isEmpty();
        case CatPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
        case CatPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
        case CatPackage.DOCUMENT_ROOT__ARTIFACT:
            return getArtifact() != null;
        case CatPackage.DOCUMENT_ROOT__AS_ADDRESS_TEXT:
            return AS_ADDRESS_TEXT_EDEFAULT == null ? getASAddressText() != null : !AS_ADDRESS_TEXT_EDEFAULT
                    .equals(getASAddressText());
        case CatPackage.DOCUMENT_ROOT__AS_NAME:
            return AS_NAME_EDEFAULT == null ? getASName() != null : !AS_NAME_EDEFAULT.equals(getASName());
        case CatPackage.DOCUMENT_ROOT__AS_WEB_SITE_URL:
            return AS_WEB_SITE_URL_EDEFAULT == null ? getASWebSiteURL() != null : !AS_WEB_SITE_URL_EDEFAULT
                    .equals(getASWebSiteURL());
        case CatPackage.DOCUMENT_ROOT__AUTHORITATIVE_SOURCE:
            return getAuthoritativeSource() != null;
        case CatPackage.DOCUMENT_ROOT__CATALOG:
            return getCatalog() != null;
        case CatPackage.DOCUMENT_ROOT__CREATION_DATE:
            return CREATION_DATE_EDEFAULT == null ? getCreationDate() != null : !CREATION_DATE_EDEFAULT
                    .equals(getCreationDate());
        case CatPackage.DOCUMENT_ROOT__DOMAIN_TEXT:
            return DOMAIN_TEXT_EDEFAULT == null ? getDomainText() != null : !DOMAIN_TEXT_EDEFAULT.equals(getDomainText());
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PARTNER_NAME:
            return EXCHANGE_PARTNER_NAME_EDEFAULT == null ? getExchangePartnerName() != null
                    : !EXCHANGE_PARTNER_NAME_EDEFAULT.equals(getExchangePartnerName());
        case CatPackage.DOCUMENT_ROOT__EXCHANGE_PATTERN_TEXT:
            return EXCHANGE_PATTERN_TEXT_EDEFAULT == null ? getExchangePatternText() != null
                    : !EXCHANGE_PATTERN_TEXT_EDEFAULT.equals(getExchangePatternText());
        case CatPackage.DOCUMENT_ROOT__FILE:
            return getFile() != null;
        case CatPackage.DOCUMENT_ROOT__FILE_SET:
            return getFileSet() != null;
        case CatPackage.DOCUMENT_ROOT__FOLDER:
            return getFolder() != null;
        case CatPackage.DOCUMENT_ROOT__KEYWORD_TEXT:
            return KEYWORD_TEXT_EDEFAULT == null ? getKeywordText() != null : !KEYWORD_TEXT_EDEFAULT
                    .equals(getKeywordText());
        case CatPackage.DOCUMENT_ROOT__LAST_REVISION_DATE:
            return LAST_REVISION_DATE_EDEFAULT == null ? getLastRevisionDate() != null : !LAST_REVISION_DATE_EDEFAULT
                    .equals(getLastRevisionDate());
        case CatPackage.DOCUMENT_ROOT__METADATA:
            return getMetadata() != null;
        case CatPackage.DOCUMENT_ROOT__NEXT_REVISION_DATE:
            return NEXT_REVISION_DATE_EDEFAULT == null ? getNextRevisionDate() != null : !NEXT_REVISION_DATE_EDEFAULT
                    .equals(getNextRevisionDate());
        case CatPackage.DOCUMENT_ROOT__POC:
            return getPOC() != null;
        case CatPackage.DOCUMENT_ROOT__POC_EMAIL:
            return POC_EMAIL_EDEFAULT == null ? getPOCEmail() != null : !POC_EMAIL_EDEFAULT.equals(getPOCEmail());
        case CatPackage.DOCUMENT_ROOT__POC_NAME:
            return POC_NAME_EDEFAULT == null ? getPOCName() != null : !POC_NAME_EDEFAULT.equals(getPOCName());
        case CatPackage.DOCUMENT_ROOT__POC_TELEPHONE:
            return POC_TELEPHONE_EDEFAULT == null ? getPOCTelephone() != null : !POC_TELEPHONE_EDEFAULT
                    .equals(getPOCTelephone());
        case CatPackage.DOCUMENT_ROOT__PURPOSE_TEXT:
            return PURPOSE_TEXT_EDEFAULT == null ? getPurposeText() != null : !PURPOSE_TEXT_EDEFAULT
                    .equals(getPurposeText());
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP:
            return getRelationship() != null;
        case CatPackage.DOCUMENT_ROOT__SECURITY_MARKING_TEXT:
            return SECURITY_MARKING_TEXT_EDEFAULT == null ? getSecurityMarkingText() != null
                    : !SECURITY_MARKING_TEXT_EDEFAULT.equals(getSecurityMarkingText());
        case CatPackage.DOCUMENT_ROOT__STATUS_TEXT:
            return STATUS_TEXT_EDEFAULT == null ? getStatusText() != null : !STATUS_TEXT_EDEFAULT.equals(getStatusText());
        case CatPackage.DOCUMENT_ROOT__DESCRIPTION_TEXT:
            return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT
                    .equals(descriptionText);
        case CatPackage.DOCUMENT_ROOT__EXTERNAL_URI:
            return EXTERNAL_URI_EDEFAULT == null ? externalURI != null : !EXTERNAL_URI_EDEFAULT.equals(externalURI);
        case CatPackage.DOCUMENT_ROOT__FILES:
            return FILES_EDEFAULT == null ? files != null : !FILES_EDEFAULT.equals(files);
        case CatPackage.DOCUMENT_ROOT__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
        case CatPackage.DOCUMENT_ROOT__MPD_CLASS_CODE:
            return isSetMpdClassCode();
        case CatPackage.DOCUMENT_ROOT__MPD_NAME:
            return MPD_NAME_EDEFAULT == null ? mpdName != null : !MPD_NAME_EDEFAULT.equals(mpdName);
        case CatPackage.DOCUMENT_ROOT__MPD_URI:
            return MPD_URI_EDEFAULT == null ? mpdURI != null : !MPD_URI_EDEFAULT.equals(mpdURI);
        case CatPackage.DOCUMENT_ROOT__MPD_VERSION_ID:
            return MPD_VERSION_ID_EDEFAULT == null ? mpdVersionID != null : !MPD_VERSION_ID_EDEFAULT.equals(mpdVersionID);
        case CatPackage.DOCUMENT_ROOT__NATURE_URI:
            return NATURE_URI_EDEFAULT == null ? natureURI != null : !NATURE_URI_EDEFAULT.equals(natureURI);
        case CatPackage.DOCUMENT_ROOT__PURPOSE_URI:
            return PURPOSE_URI_EDEFAULT == null ? purposeURI != null : !PURPOSE_URI_EDEFAULT.equals(purposeURI);
        case CatPackage.DOCUMENT_ROOT__RELATIONSHIP_CODE:
            return isSetRelationshipCode();
        case CatPackage.DOCUMENT_ROOT__RELATIVE_PATH_NAME:
            return RELATIVE_PATH_NAME_EDEFAULT == null ? relativePathName != null : !RELATIVE_PATH_NAME_EDEFAULT
                    .equals(relativePathName);
        case CatPackage.DOCUMENT_ROOT__RESOURCE_URI:
            return RESOURCE_URI_EDEFAULT == null ? resourceURI != null : !RESOURCE_URI_EDEFAULT.equals(resourceURI);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (mixed: ");
        result.append(mixed);
        result.append(", descriptionText: ");
        result.append(descriptionText);
        result.append(", externalURI: ");
        result.append(externalURI);
        result.append(", files: ");
        result.append(files);
        result.append(", id: ");
        result.append(id);
        result.append(", mpdClassCode: ");
        if (mpdClassCodeESet) {
            result.append(mpdClassCode);
        } else {
            result.append("<unset>");
        }
        result.append(", mpdName: ");
        result.append(mpdName);
        result.append(", mpdURI: ");
        result.append(mpdURI);
        result.append(", mpdVersionID: ");
        result.append(mpdVersionID);
        result.append(", natureURI: ");
        result.append(natureURI);
        result.append(", purposeURI: ");
        result.append(purposeURI);
        result.append(", relationshipCode: ");
        if (relationshipCodeESet) {
            result.append(relationshipCode);
        } else {
            result.append("<unset>");
        }
        result.append(", relativePathName: ");
        result.append(relativePathName);
        result.append(", resourceURI: ");
        result.append(resourceURI);
        result.append(')');
        return result.toString();
    }

} // DocumentRootImpl
