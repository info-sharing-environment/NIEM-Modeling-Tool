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
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Catalog Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getArtifactGroup <em>Artifact Group</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getArtifact <em>Artifact</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getMetadata <em>Metadata</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getMpdClassCode <em>Mpd Class Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getMpdName <em>Mpd Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getMpdURI <em>Mpd URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.CatalogType#getMpdVersionID <em>Mpd Version ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getCatalogType()
 * @model extendedMetaData="name='CatalogType' kind='elementOnly'"
 * @generated
 */
public interface CatalogType extends EObject {
    /**
     * Returns the value of the '<em><b>Artifact Group</b></em>' attribute list. The list contents are of type
     * {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Artifact Group</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Artifact Group</em>' attribute list.
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_ArtifactGroup()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true" many="true"
     *        extendedMetaData="kind='group' name='Artifact:group' namespace='##targetNamespace'"
     * @generated
     */
    FeatureMap getArtifactGroup();

    /**
     * Returns the value of the '<em><b>Artifact</b></em>' containment reference list. The list contents are of type
     * {@link org.eclipse.emf.ecore.EObject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Artifact</em>' containment reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Artifact</em>' containment reference list.
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_Artifact()
     * @model containment="true" required="true" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='Artifact' namespace='##targetNamespace' group='Artifact:group'"
     * @generated
     */
    EList<EObject> getArtifact();

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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_Metadata()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='Metadata' namespace='##targetNamespace'"
     * @generated
     */
    MetadataType getMetadata();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMetadata <em>Metadata</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Metadata</em>' containment reference.
     * @see #getMetadata()
     * @generated
     */
    void setMetadata(MetadataType value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_DescriptionText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='descriptionText' namespace='##targetNamespace'"
     * @generated
     */
    String getDescriptionText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getDescriptionText <em>Description Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description Text</em>' attribute.
     * @see #getDescriptionText()
     * @generated
     */
    void setDescriptionText(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_MpdClassCode()
     * @model unsettable="true" required="true"
     *        extendedMetaData="kind='attribute' name='mpdClassCode' namespace='##targetNamespace'"
     * @generated
     */
    MPDClassCodeSimpleType getMpdClassCode();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdClassCode <em>Mpd Class Code</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * Unsets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdClassCode <em>Mpd Class Code</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMpdClassCode()
     * @see #getMpdClassCode()
     * @see #setMpdClassCode(MPDClassCodeSimpleType)
     * @generated
     */
    void unsetMpdClassCode();

    /**
     * Returns whether the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdClassCode <em>Mpd Class Code</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_MpdName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='mpdName' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdName();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdName <em>Mpd Name</em>}' attribute. <!--
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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_MpdURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='mpdURI' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdURI <em>Mpd URI</em>}' attribute. <!--
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
     * @see org.search.niem.mpd.cat.CatPackage#getCatalogType_MpdVersionID()
     * @model dataType="org.search.niem.mpd.cat.MPDVersionIDSimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='mpdVersionID' namespace='##targetNamespace'"
     * @generated
     */
    String getMpdVersionID();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.CatalogType#getMpdVersionID <em>Mpd Version ID</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mpd Version ID</em>' attribute.
     * @see #getMpdVersionID()
     * @generated
     */
    void setMpdVersionID(String value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model mpdClassCodeDataType="org.eclipse.emf.ecore.xml.type.String" mpdClassCodeUnique="false"
     *        mpdClassCodeRequired="true" mpdClassCodeOrdered="false"
     * @generated
     */
    void setMpdClassCode(String mpdClassCode);

} // CatalogType
