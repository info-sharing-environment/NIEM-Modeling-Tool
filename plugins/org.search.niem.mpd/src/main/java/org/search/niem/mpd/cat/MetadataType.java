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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Metadata Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText <em>Security Marking Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getLastRevisionDate <em>Last Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getNextRevisionDate <em>Next Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getStatusText <em>Status Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getRelationship <em>Relationship</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getKeywordText <em>Keyword Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getDomainText <em>Domain Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getPurposeText <em>Purpose Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getExchangePatternText <em>Exchange Pattern Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getExchangePartnerName <em>Exchange Partner Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.MetadataType#getAuthoritativeSource <em>Authoritative Source</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getMetadataType()
 * @model extendedMetaData="name='MetadataType' kind='elementOnly'"
 * @generated
 */
public interface MetadataType extends EObject {
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
     * @see #isSetSecurityMarkingText()
     * @see #unsetSecurityMarkingText()
     * @see #setSecurityMarkingText(String)
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_SecurityMarkingText()
     * @model default="unclassified" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='SecurityMarkingText' namespace='##targetNamespace'"
     * @generated
     */
    String getSecurityMarkingText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText
     * <em>Security Marking Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Security Marking Text</em>' attribute.
     * @see #isSetSecurityMarkingText()
     * @see #unsetSecurityMarkingText()
     * @see #getSecurityMarkingText()
     * @generated
     */
    void setSecurityMarkingText(String value);

    /**
     * Unsets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText
     * <em>Security Marking Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetSecurityMarkingText()
     * @see #getSecurityMarkingText()
     * @see #setSecurityMarkingText(String)
     * @generated
     */
    void unsetSecurityMarkingText();

    /**
     * Returns whether the value of the '{@link org.search.niem.mpd.cat.MetadataType#getSecurityMarkingText
     * <em>Security Marking Text</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Security Marking Text</em>' attribute is set.
     * @see #unsetSecurityMarkingText()
     * @see #getSecurityMarkingText()
     * @see #setSecurityMarkingText(String)
     * @generated
     */
    boolean isSetSecurityMarkingText();

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
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_CreationDate()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Date" required="true"
     *        extendedMetaData="kind='element' name='CreationDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getCreationDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(XMLGregorianCalendar value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_LastRevisionDate()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
     *        extendedMetaData="kind='element' name='LastRevisionDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getLastRevisionDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getLastRevisionDate <em>Last Revision Date</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Last Revision Date</em>' attribute.
     * @see #getLastRevisionDate()
     * @generated
     */
    void setLastRevisionDate(XMLGregorianCalendar value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_NextRevisionDate()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Date"
     *        extendedMetaData="kind='element' name='NextRevisionDate' namespace='##targetNamespace'"
     * @generated
     */
    XMLGregorianCalendar getNextRevisionDate();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getNextRevisionDate <em>Next Revision Date</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Next Revision Date</em>' attribute.
     * @see #getNextRevisionDate()
     * @generated
     */
    void setNextRevisionDate(XMLGregorianCalendar value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_StatusText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='StatusText' namespace='##targetNamespace'"
     * @generated
     */
    String getStatusText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getStatusText <em>Status Text</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Status Text</em>' attribute.
     * @see #getStatusText()
     * @generated
     */
    void setStatusText(String value);

    /**
     * Returns the value of the '<em><b>Relationship</b></em>' containment reference list. The list contents are of type
     * {@link org.search.niem.mpd.cat.RelationshipType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Relationship</em>' containment reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Relationship</em>' containment reference list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_Relationship()
     * @model containment="true" extendedMetaData="kind='element' name='Relationship' namespace='##targetNamespace'"
     * @generated
     */
    EList<RelationshipType> getRelationship();

    /**
     * Returns the value of the '<em><b>Keyword Text</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Keyword Text</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Keyword Text</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_KeywordText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='KeywordText' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getKeywordText();

    /**
     * Returns the value of the '<em><b>Domain Text</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domain Text</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Domain Text</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_DomainText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='DomainText' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getDomainText();

    /**
     * Returns the value of the '<em><b>Purpose Text</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Purpose Text</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Purpose Text</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_PurposeText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='PurposeText' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getPurposeText();

    /**
     * Returns the value of the '<em><b>Exchange Pattern Text</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Pattern Text</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Exchange Pattern Text</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_ExchangePatternText()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='ExchangePatternText' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getExchangePatternText();

    /**
     * Returns the value of the '<em><b>Exchange Partner Name</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exchange Partner Name</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Exchange Partner Name</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_ExchangePartnerName()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='ExchangePartnerName' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getExchangePartnerName();

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
     * @see org.search.niem.mpd.cat.CatPackage#getMetadataType_AuthoritativeSource()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='AuthoritativeSource' namespace='##targetNamespace'"
     * @generated
     */
    AuthoritativeSourceType getAuthoritativeSource();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.MetadataType#getAuthoritativeSource
     * <em>Authoritative Source</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Authoritative Source</em>' containment reference.
     * @see #getAuthoritativeSource()
     * @generated
     */
    void setAuthoritativeSource(AuthoritativeSourceType value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model dateStringDataType="org.eclipse.emf.ecore.xml.type.String" dateStringUnique="false" dateStringRequired="true"
     *        dateStringOrdered="false"
     * @generated
     */
    void setCreationDate(String dateString);

} // MetadataType
