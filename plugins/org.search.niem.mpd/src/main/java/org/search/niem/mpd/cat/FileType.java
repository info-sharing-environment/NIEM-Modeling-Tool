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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>File Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.FileType#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileType#getExternalURI <em>External URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileType#getId <em>Id</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileType#getNatureURI <em>Nature URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileType#getPurposeURI <em>Purpose URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileType#getRelativePathName <em>Relative Path Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getFileType()
 * @model extendedMetaData="name='FileType' kind='empty'"
 * @generated
 */
public interface FileType extends EObject {
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_DescriptionText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='descriptionText' namespace='##targetNamespace'"
     * @generated
     */
    String getDescriptionText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getDescriptionText <em>Description Text</em>}'
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_ExternalURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='externalURI' namespace='##targetNamespace'"
     * @generated
     */
    String getExternalURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getExternalURI <em>External URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>External URI</em>' attribute.
     * @see #getExternalURI()
     * @generated
     */
    void setExternalURI(String value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
     *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getId <em>Id</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_NatureURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='natureURI' namespace='##targetNamespace'"
     * @generated
     */
    String getNatureURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getNatureURI <em>Nature URI</em>}' attribute. <!--
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_PurposeURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='purposeURI' namespace='##targetNamespace'"
     * @generated
     */
    String getPurposeURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getPurposeURI <em>Purpose URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Purpose URI</em>' attribute.
     * @see #getPurposeURI()
     * @generated
     */
    void setPurposeURI(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getFileType_RelativePathName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='relativePathName' namespace='##targetNamespace'"
     * @generated
     */
    String getRelativePathName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileType#getRelativePathName <em>Relative Path Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Relative Path Name</em>' attribute.
     * @see #getRelativePathName()
     * @generated
     */
    void setRelativePathName(String value);

} // FileType
