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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>POC Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.POCType#getPOCName <em>POC Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.POCType#getPOCEmail <em>POC Email</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.POCType#getPOCTelephone <em>POC Telephone</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getPOCType()
 * @model extendedMetaData="name='POCType' kind='elementOnly'"
 * @generated
 */
public interface POCType extends EObject {
    /**
     * Returns the value of the '<em><b>POC Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Name</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Name</em>' attribute.
     * @see #setPOCName(String)
     * @see org.search.niem.mpd.cat.CatPackage#getPOCType_POCName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='POCName' namespace='##targetNamespace'"
     * @generated
     */
    String getPOCName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.POCType#getPOCName <em>POC Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>POC Name</em>' attribute.
     * @see #getPOCName()
     * @generated
     */
    void setPOCName(String value);

    /**
     * Returns the value of the '<em><b>POC Email</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Email</em>' attribute list isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Email</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getPOCType_POCEmail()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='POCEmail' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getPOCEmail();

    /**
     * Returns the value of the '<em><b>POC Telephone</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>POC Telephone</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>POC Telephone</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getPOCType_POCTelephone()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='POCTelephone' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getPOCTelephone();

} // POCType
