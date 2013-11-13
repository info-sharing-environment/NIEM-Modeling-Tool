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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>File Set Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getFile <em>File</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getExternalURI <em>External URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getFiles <em>Files</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getId <em>Id</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getNatureURI <em>Nature URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.FileSetType#getPurposeURI <em>Purpose URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getFileSetType()
 * @model extendedMetaData="name='FileSetType' kind='elementOnly'"
 * @generated
 */
public interface FileSetType extends EObject {
    /**
     * Returns the value of the '<em><b>File</b></em>' containment reference list. The list contents are of type
     * {@link org.search.niem.mpd.cat.FileType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File</em>' containment reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>File</em>' containment reference list.
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_File()
     * @model containment="true" extendedMetaData="kind='element' name='File' namespace='##targetNamespace'"
     * @generated
     */
    EList<FileType> getFile();

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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_DescriptionText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='descriptionText' namespace='##targetNamespace'"
     * @generated
     */
    String getDescriptionText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getDescriptionText <em>Description Text</em>}'
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_ExternalURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType"
     *        extendedMetaData="kind='attribute' name='externalURI' namespace='##targetNamespace'"
     * @generated
     */
    String getExternalURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getExternalURI <em>External URI</em>}' attribute.
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_Files()
     * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
     *        extendedMetaData="kind='attribute' name='files' namespace='##targetNamespace'"
     * @generated
     */
    List<String> getFiles();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getFiles <em>Files</em>}' attribute. <!--
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
     *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getId <em>Id</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_NatureURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='natureURI' namespace='##targetNamespace'"
     * @generated
     */
    String getNatureURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getNatureURI <em>Nature URI</em>}' attribute. <!--
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
     * @see org.search.niem.mpd.cat.CatPackage#getFileSetType_PurposeURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='purposeURI' namespace='##targetNamespace'"
     * @generated
     */
    String getPurposeURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.FileSetType#getPurposeURI <em>Purpose URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Purpose URI</em>' attribute.
     * @see #getPurposeURI()
     * @generated
     */
    void setPurposeURI(String value);

} // FileSetType
