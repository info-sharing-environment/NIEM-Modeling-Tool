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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Authoritative Source Type</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASName <em>AS Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASAddressText <em>AS Address Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASWebSiteURL <em>AS Web Site URL</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getPOC <em>POC</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getAuthoritativeSourceType()
 * @model extendedMetaData="name='AuthoritativeSourceType' kind='elementOnly'"
 * @generated
 */
public interface AuthoritativeSourceType extends EObject {
    /**
     * Returns the value of the '<em><b>AS Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>AS Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>AS Name</em>' attribute.
     * @see #setASName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getAuthoritativeSourceType_ASName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='ASName' namespace='##targetNamespace'"
     * @generated
     */
    String getASName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASName <em>AS Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Name</em>' attribute.
     * @see #getASName()
     * @generated
     */
    void setASName(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getAuthoritativeSourceType_ASAddressText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='ASAddressText' namespace='##targetNamespace'"
     * @generated
     */
    String getASAddressText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASAddressText
     * <em>AS Address Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Address Text</em>' attribute.
     * @see #getASAddressText()
     * @generated
     */
    void setASAddressText(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getAuthoritativeSourceType_ASWebSiteURL()
     * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
     *        extendedMetaData="kind='element' name='ASWebSiteURL' namespace='##targetNamespace'"
     * @generated
     */
    String getASWebSiteURL();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.AuthoritativeSourceType#getASWebSiteURL
     * <em>AS Web Site URL</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>AS Web Site URL</em>' attribute.
     * @see #getASWebSiteURL()
     * @generated
     */
    void setASWebSiteURL(String value);

    /**
     * Returns the value of the '<em><b>POC</b></em>' containment reference list. The list contents are of type
     * {@link org.search.niem.mpd.cat.POCType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC</em>' containment reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC</em>' containment reference list.
     * @see org.search.niem.mpd.cat.CatPackage#getAuthoritativeSourceType_POC()
     * @model containment="true" required="true" extendedMetaData="kind='element' name='POC' namespace='##targetNamespace'"
     * @generated
     */
    EList<POCType> getPOC();

} // AuthoritativeSourceType
