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

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Document Root</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMixed <em>Mixed</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getArtifact <em>Artifact</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getASAddressText <em>AS Address Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getASName <em>AS Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getASWebSiteURL <em>AS Web Site URL</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getAuthoritativeSource <em>Authoritative Source</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getCatalog <em>Catalog</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getDomainText <em>Domain Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePartnerName <em>Exchange Partner Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePatternText <em>Exchange Pattern Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getFile <em>File</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getFileSet <em>File Set</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getFolder <em>Folder</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getKeywordText <em>Keyword Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getLastRevisionDate <em>Last Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMetadata <em>Metadata</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getNextRevisionDate <em>Next Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPOC <em>POC</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPOCEmail <em>POC Email</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPOCName <em>POC Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPOCTelephone <em>POC Telephone</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeText <em>Purpose Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getRelationship <em>Relationship</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getSecurityMarkingText <em>Security Marking Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getStatusText <em>Status Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getExternalURI <em>External URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getFiles <em>Files</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getId <em>Id</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode <em>Mpd Class Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMpdName <em>Mpd Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMpdURI <em>Mpd URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getMpdVersionID <em>Mpd Version ID</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getNatureURI <em>Nature URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeURI <em>Purpose URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode <em>Relationship Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getRelativePathName <em>Relative Path Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.DocumentRoot#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
    /**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute list. The list contents are of type
     * {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mixed</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='elementWildcard' name=':mixed'"
     * @generated
     */
    FeatureMap getMixed();

    /**
     * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type {@link java.lang.String}, and the
     * value is of type {@link java.lang.String}, <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>XMLNS Prefix Map</em>' map.
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_XMLNSPrefixMap()
     * @model 
     *        mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     *        transient="true" extendedMetaData="kind='attribute' name='xmlns:prefix'"
     * @generated
     */
    EMap<String, String> getXMLNSPrefixMap();

    /**
     * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type {@link java.lang.String}, and
     * the value is of type {@link java.lang.String}, <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>XSI Schema Location</em>' map.
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_XSISchemaLocation()
     * @model 
     *        mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     *        transient="true" extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
     * @generated
     */
    EMap<String, String> getXSISchemaLocation();

    /**
     * Returns the value of the '<em><b>Artifact</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Artifact</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Artifact</em>' containment reference.
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Artifact()
     * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Artifact' namespace='##targetNamespace'"
     * @generated
     */
    EObject getArtifact();

    /**
     * Returns the value of the '<em><b>AS Address Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>AS Address Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>AS Address Text</em>' attribute.
     * @see #setASAddressText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ASAddressText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='ASAddressText' namespace='##targetNamespace'"
     * @generated
     */
    String getASAddressText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getASAddressText <em>AS Address Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Address Text</em>' attribute.
     * @see #getASAddressText()
     * @generated
     */
    void setASAddressText(String value);

    /**
     * Returns the value of the '<em><b>AS Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>AS Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>AS Name</em>' attribute.
     * @see #setASName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ASName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='ASName' namespace='##targetNamespace'"
     * @generated
     */
    String getASName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getASName <em>AS Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Name</em>' attribute.
     * @see #getASName()
     * @generated
     */
    void setASName(String value);

    /**
     * Returns the value of the '<em><b>AS Web Site URL</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>AS Web Site URL</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>AS Web Site URL</em>' attribute.
     * @see #setASWebSiteURL(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ASWebSiteURL()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='ASWebSiteURL' namespace='##targetNamespace'"
     * @generated
     */
    String getASWebSiteURL();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getASWebSiteURL <em>AS Web Site URL</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Web Site URL</em>' attribute.
     * @see #getASWebSiteURL()
     * @generated
     */
    void setASWebSiteURL(String value);

    /**
     * Returns the value of the '<em><b>Authoritative Source</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authoritative Source</em>' containment reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Authoritative Source</em>' containment reference.
     * @see #setAuthoritativeSource(AuthoritativeSourceType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_AuthoritativeSource()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='AuthoritativeSource' namespace='##targetNamespace'"
     * @generated
     */
    AuthoritativeSourceType getAuthoritativeSource();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getAuthoritativeSource
     * <em>Authoritative Source</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Authoritative Source</em>' containment reference.
     * @see #getAuthoritativeSource()
     * @generated
     */
    void setAuthoritativeSource(AuthoritativeSourceType value);

    /**
     * Returns the value of the '<em><b>Catalog</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Catalog</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Catalog</em>' containment reference.
     * @see #setCatalog(CatalogType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Catalog()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Catalog' namespace='##targetNamespace'"
     * @generated
     */
    CatalogType getCatalog();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getCatalog <em>Catalog</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Catalog</em>' containment reference.
     * @see #getCatalog()
     * @generated
     */
    void setCatalog(CatalogType value);

    /**
     * Returns the value of the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Creation Date</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Creation Date</em>' attribute.
     * @see #setCreationDate(XMLGregorianCalendar)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_CreationDate()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='CreationDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getCreationDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(XMLGregorianCalendar value);

    /**
     * Returns the value of the '<em><b>Domain Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domain Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Domain Text</em>' attribute.
     * @see #setDomainText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_DomainText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='DomainText' namespace='##targetNamespace'"
     * @generated
     */
    String getDomainText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getDomainText <em>Domain Text</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Domain Text</em>' attribute.
     * @see #getDomainText()
     * @generated
     */
    void setDomainText(String value);

    /**
     * Returns the value of the '<em><b>Exchange Partner Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Partner Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Exchange Partner Name</em>' attribute.
     * @see #setExchangePartnerName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ExchangePartnerName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='ExchangePartnerName' namespace='##targetNamespace'"
     * @generated
     */
    String getExchangePartnerName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePartnerName
     * <em>Exchange Partner Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Exchange Partner Name</em>' attribute.
     * @see #getExchangePartnerName()
     * @generated
     */
    void setExchangePartnerName(String value);

    /**
     * Returns the value of the '<em><b>Exchange Pattern Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Pattern Text</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Exchange Pattern Text</em>' attribute.
     * @see #setExchangePatternText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ExchangePatternText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='ExchangePatternText' namespace='##targetNamespace'"
     * @generated
     */
    String getExchangePatternText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getExchangePatternText
     * <em>Exchange Pattern Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Exchange Pattern Text</em>' attribute.
     * @see #getExchangePatternText()
     * @generated
     */
    void setExchangePatternText(String value);

    /**
     * Returns the value of the '<em><b>File</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File</em>' containment reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>File</em>' containment reference.
     * @see #setFile(FileType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_File()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='File' namespace='##targetNamespace' affiliation='Artifact'"
     * @generated
     */
    FileType getFile();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getFile <em>File</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>File</em>' containment reference.
     * @see #getFile()
     * @generated
     */
    void setFile(FileType value);

    /**
     * Returns the value of the '<em><b>File Set</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Set</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>File Set</em>' containment reference.
     * @see #setFileSet(FileSetType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_FileSet()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='FileSet' namespace='##targetNamespace' affiliation='Artifact'"
     * @generated
     */
    FileSetType getFileSet();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getFileSet <em>File Set</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>File Set</em>' containment reference.
     * @see #getFileSet()
     * @generated
     */
    void setFileSet(FileSetType value);

    /**
     * Returns the value of the '<em><b>Folder</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Folder</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Folder</em>' containment reference.
     * @see #setFolder(FolderType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Folder()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Folder' namespace='##targetNamespace' affiliation='Artifact'"
     * @generated
     */
    FolderType getFolder();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getFolder <em>Folder</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Folder</em>' containment reference.
     * @see #getFolder()
     * @generated
     */
    void setFolder(FolderType value);

    /**
     * Returns the value of the '<em><b>Keyword Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Keyword Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Keyword Text</em>' attribute.
     * @see #setKeywordText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_KeywordText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='KeywordText' namespace='##targetNamespace'"
     * @generated
     */
    String getKeywordText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getKeywordText <em>Keyword Text</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Keyword Text</em>' attribute.
     * @see #getKeywordText()
     * @generated
     */
    void setKeywordText(String value);

    /**
     * Returns the value of the '<em><b>Last Revision Date</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Revision Date</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Last Revision Date</em>' attribute.
     * @see #setLastRevisionDate(XMLGregorianCalendar)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_LastRevisionDate()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='LastRevisionDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getLastRevisionDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getLastRevisionDate <em>Last Revision Date</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Last Revision Date</em>' attribute.
     * @see #getLastRevisionDate()
     * @generated
     */
    void setLastRevisionDate(XMLGregorianCalendar value);

    /**
     * Returns the value of the '<em><b>Metadata</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Metadata</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Metadata</em>' containment reference.
     * @see #setMetadata(MetadataType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Metadata()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Metadata' namespace='##targetNamespace'"
     * @generated
     */
    MetadataType getMetadata();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMetadata <em>Metadata</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Metadata</em>' containment reference.
     * @see #getMetadata()
     * @generated
     */
    void setMetadata(MetadataType value);

    /**
     * Returns the value of the '<em><b>Next Revision Date</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Next Revision Date</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Next Revision Date</em>' attribute.
     * @see #setNextRevisionDate(XMLGregorianCalendar)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_NextRevisionDate()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='NextRevisionDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getNextRevisionDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getNextRevisionDate <em>Next Revision Date</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Next Revision Date</em>' attribute.
     * @see #getNextRevisionDate()
     * @generated
     */
    void setNextRevisionDate(XMLGregorianCalendar value);

    /**
     * Returns the value of the '<em><b>POC</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC</em>' containment reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC</em>' containment reference.
     * @see #setPOC(POCType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_POC()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='POC' namespace='##targetNamespace'"
     * @generated
     */
    POCType getPOC();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPOC <em>POC</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>POC</em>' containment reference.
     * @see #getPOC()
     * @generated
     */
    void setPOC(POCType value);

    /**
     * Returns the value of the '<em><b>POC Email</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Email</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Email</em>' attribute.
     * @see #setPOCEmail(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_POCEmail()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='POCEmail' namespace='##targetNamespace'"
     * @generated
     */
    String getPOCEmail();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCEmail <em>POC Email</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>POC Email</em>' attribute.
     * @see #getPOCEmail()
     * @generated
     */
    void setPOCEmail(String value);

    /**
     * Returns the value of the '<em><b>POC Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Name</em>' attribute.
     * @see #setPOCName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_POCName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='POCName' namespace='##targetNamespace'"
     * @generated
     */
    String getPOCName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCName <em>POC Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>POC Name</em>' attribute.
     * @see #getPOCName()
     * @generated
     */
    void setPOCName(String value);

    /**
     * Returns the value of the '<em><b>POC Telephone</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Telephone</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Telephone</em>' attribute.
     * @see #setPOCTelephone(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_POCTelephone()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='POCTelephone' namespace='##targetNamespace'"
     * @generated
     */
    String getPOCTelephone();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPOCTelephone <em>POC Telephone</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>POC Telephone</em>' attribute.
     * @see #getPOCTelephone()
     * @generated
     */
    void setPOCTelephone(String value);

    /**
     * Returns the value of the '<em><b>Purpose Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Purpose Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Purpose Text</em>' attribute.
     * @see #setPurposeText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_PurposeText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='PurposeText' namespace='##targetNamespace'"
     * @generated
     */
    String getPurposeText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeText <em>Purpose Text</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Purpose Text</em>' attribute.
     * @see #getPurposeText()
     * @generated
     */
    void setPurposeText(String value);

    /**
     * Returns the value of the '<em><b>Relationship</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relationship</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Relationship</em>' containment reference.
     * @see #setRelationship(RelationshipType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Relationship()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Relationship' namespace='##targetNamespace'"
     * @generated
     */
    RelationshipType getRelationship();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationship <em>Relationship</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Relationship</em>' containment reference.
     * @see #getRelationship()
     * @generated
     */
    void setRelationship(RelationshipType value);

    /**
     * Returns the value of the '<em><b>Security Marking Text</b></em>' attribute. The default value is
     * <code>"unclassified"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Security Marking Text</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Security Marking Text</em>' attribute.
     * @see #setSecurityMarkingText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_SecurityMarkingText()
     * @model default="unclassified" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2"
     *        transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='SecurityMarkingText' namespace='##targetNamespace'"
     * @generated
     */
    String getSecurityMarkingText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getSecurityMarkingText
     * <em>Security Marking Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Security Marking Text</em>' attribute.
     * @see #getSecurityMarkingText()
     * @generated
     */
    void setSecurityMarkingText(String value);

    /**
     * Returns the value of the '<em><b>Status Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Status Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Status Text</em>' attribute.
     * @see #setStatusText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_StatusText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='StatusText' namespace='##targetNamespace'"
     * @generated
     */
    String getStatusText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getStatusText <em>Status Text</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Status Text</em>' attribute.
     * @see #getStatusText()
     * @generated
     */
    void setStatusText(String value);

    /**
     * Returns the value of the '<em><b>Description Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description Text</em>' attribute.
     * @see #setDescriptionText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_DescriptionText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='descriptionText' namespace='##targetNamespace'"
     * @generated
     */
    String getDescriptionText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getDescriptionText <em>Description Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description Text</em>' attribute.
     * @see #getDescriptionText()
     * @generated
     */
    void setDescriptionText(String value);

    /**
     * Returns the value of the '<em><b>External URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>External URI</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>External URI</em>' attribute.
     * @see #setExternalURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ExternalURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='externalURI' namespace='##targetNamespace'"
     * @generated
     */
    String getExternalURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getExternalURI <em>External URI</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>External URI</em>' attribute.
     * @see #getExternalURI()
     * @generated
     */
    void setExternalURI(String value);

    /**
     * Returns the value of the '<em><b>Files</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Files</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Files</em>' attribute.
     * @see #setFiles(List)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Files()
     * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
     *        extendedMetaData="kind='attribute' name='files' namespace='##targetNamespace'"
     * @generated
     */
    List<String> getFiles();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getFiles <em>Files</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Files</em>' attribute.
     * @see #getFiles()
     * @generated
     */
    void setFiles(List<String> value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
     *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getId <em>Id</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Mpd Class Code</b></em>' attribute. The literals are from the enumeration
     * {@link org.search.niem.mpd.cat.MPDClassCodeSimpleType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mpd Class Code</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mpd Class Code</em>' attribute.
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @see #isSetMpdClassCode()
     * @see #unsetMpdClassCode()
     * @see #setMpdClassCode(MPDClassCodeSimpleType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_MpdClassCode()
     * @model unsettable="true" extendedMetaData="kind='attribute' name='mpdClassCode' namespace='##targetNamespace'"
     * @generated
     */
    MPDClassCodeSimpleType getMpdClassCode();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode <em>Mpd Class Code</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mpd Class Code</em>' attribute.
     * @see org.search.niem.mpd.cat.MPDClassCodeSimpleType
     * @see #isSetMpdClassCode()
     * @see #unsetMpdClassCode()
     * @see #getMpdClassCode()
     * @generated
     */
    void setMpdClassCode(MPDClassCodeSimpleType value);

    /**
     * Unsets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode <em>Mpd Class Code</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMpdClassCode()
     * @see #getMpdClassCode()
     * @see #setMpdClassCode(MPDClassCodeSimpleType)
     * @generated
     */
    void unsetMpdClassCode();

    /**
     * Returns whether the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdClassCode <em>Mpd Class Code</em>}
     * ' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Mpd Class Code</em>' attribute is set.
     * @see #unsetMpdClassCode()
     * @see #getMpdClassCode()
     * @see #setMpdClassCode(MPDClassCodeSimpleType)
     * @generated
     */
    boolean isSetMpdClassCode();

    /**
     * Returns the value of the '<em><b>Mpd Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mpd Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mpd Name</em>' attribute.
     * @see #setMpdName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_MpdName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='mpdName' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdName <em>Mpd Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mpd Name</em>' attribute.
     * @see #getMpdName()
     * @generated
     */
    void setMpdName(String value);

    /**
     * Returns the value of the '<em><b>Mpd URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mpd URI</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mpd URI</em>' attribute.
     * @see #setMpdURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_MpdURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='mpdURI' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdURI <em>Mpd URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mpd URI</em>' attribute.
     * @see #getMpdURI()
     * @generated
     */
    void setMpdURI(String value);

    /**
     * Returns the value of the '<em><b>Mpd Version ID</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mpd Version ID</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mpd Version ID</em>' attribute.
     * @see #setMpdVersionID(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_MpdVersionID()
     * @model dataType="org.search.niem.mpd.cat.MPDVersionIDSimpleType"
     *        extendedMetaData="kind='attribute' name='mpdVersionID' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdVersionID();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getMpdVersionID <em>Mpd Version ID</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mpd Version ID</em>' attribute.
     * @see #getMpdVersionID()
     * @generated
     */
    void setMpdVersionID(String value);

    /**
     * Returns the value of the '<em><b>Nature URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nature URI</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Nature URI</em>' attribute.
     * @see #setNatureURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_NatureURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='natureURI' namespace='##targetNamespace'"
     * @generated
     */
    String getNatureURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getNatureURI <em>Nature URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Nature URI</em>' attribute.
     * @see #getNatureURI()
     * @generated
     */
    void setNatureURI(String value);

    /**
     * Returns the value of the '<em><b>Purpose URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Purpose URI</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Purpose URI</em>' attribute.
     * @see #setPurposeURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_PurposeURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='purposeURI' namespace='##targetNamespace'"
     * @generated
     */
    String getPurposeURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getPurposeURI <em>Purpose URI</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Purpose URI</em>' attribute.
     * @see #getPurposeURI()
     * @generated
     */
    void setPurposeURI(String value);

    /**
     * Returns the value of the '<em><b>Relationship Code</b></em>' attribute. The literals are from the enumeration
     * {@link org.search.niem.mpd.cat.RelationshipCodeSimpleType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relationship Code</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Relationship Code</em>' attribute.
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @see #isSetRelationshipCode()
     * @see #unsetRelationshipCode()
     * @see #setRelationshipCode(RelationshipCodeSimpleType)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_RelationshipCode()
     * @model unsettable="true" extendedMetaData="kind='attribute' name='relationshipCode' namespace='##targetNamespace'"
     * @generated
     */
    RelationshipCodeSimpleType getRelationshipCode();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode <em>Relationship Code</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Relationship Code</em>' attribute.
     * @see org.search.niem.mpd.cat.RelationshipCodeSimpleType
     * @see #isSetRelationshipCode()
     * @see #unsetRelationshipCode()
     * @see #getRelationshipCode()
     * @generated
     */
    void setRelationshipCode(RelationshipCodeSimpleType value);

    /**
     * Unsets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode <em>Relationship Code</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetRelationshipCode()
     * @see #getRelationshipCode()
     * @see #setRelationshipCode(RelationshipCodeSimpleType)
     * @generated
     */
    void unsetRelationshipCode();

    /**
     * Returns whether the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getRelationshipCode
     * <em>Relationship Code</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Relationship Code</em>' attribute is set.
     * @see #unsetRelationshipCode()
     * @see #getRelationshipCode()
     * @see #setRelationshipCode(RelationshipCodeSimpleType)
     * @generated
     */
    boolean isSetRelationshipCode();

    /**
     * Returns the value of the '<em><b>Relative Path Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relative Path Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Relative Path Name</em>' attribute.
     * @see #setRelativePathName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_RelativePathName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='relativePathName' namespace='##targetNamespace'"
     * @generated
     */
    String getRelativePathName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getRelativePathName <em>Relative Path Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Relative Path Name</em>' attribute.
     * @see #getRelativePathName()
     * @generated
     */
    void setRelativePathName(String value);

    /**
     * Returns the value of the '<em><b>Resource URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource URI</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource URI</em>' attribute.
     * @see #setResourceURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getDocumentRoot_ResourceURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='resourceURI' namespace='##targetNamespace'"
     * @generated
     */
    String getResourceURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.DocumentRoot#getResourceURI <em>Resource URI</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource URI</em>' attribute.
     * @see #getResourceURI()
     * @generated
     */
    void setResourceURI(String value);

} // DocumentRoot
