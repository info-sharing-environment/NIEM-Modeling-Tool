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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Relationship Type</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.RelationshipType#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.RelationshipType#getRelationshipCode <em>Relationship Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.RelationshipType#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getRelationshipType()
 * @model extendedMetaData="name='RelationshipType' kind='empty'"
 * @generated
 */
public interface RelationshipType extends EObject {
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
     * @see org.search.niem.mpd.cat.CatPackage#getRelationshipType_DescriptionText()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='descriptionText' namespace='##targetNamespace'"
     * @generated
     */
    String getDescriptionText();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.RelationshipType#getDescriptionText <em>Description Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description Text</em>' attribute.
     * @see #getDescriptionText()
     * @generated
     */
    void setDescriptionText(String value);

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
     * @see org.search.niem.mpd.cat.CatPackage#getRelationshipType_RelationshipCode()
     * @model unsettable="true" required="true"
     *        extendedMetaData="kind='attribute' name='relationshipCode' namespace='##targetNamespace'"
     * @generated
     */
    RelationshipCodeSimpleType getRelationshipCode();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.RelationshipType#getRelationshipCode <em>Relationship Code</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * Unsets the value of the '{@link org.search.niem.mpd.cat.RelationshipType#getRelationshipCode
     * <em>Relationship Code</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetRelationshipCode()
     * @see #getRelationshipCode()
     * @see #setRelationshipCode(RelationshipCodeSimpleType)
     * @generated
     */
    void unsetRelationshipCode();

    /**
     * Returns whether the value of the '{@link org.search.niem.mpd.cat.RelationshipType#getRelationshipCode
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
     * Returns the value of the '<em><b>Resource URI</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource URI</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource URI</em>' attribute.
     * @see #setResourceURI(String)
     * @see org.search.niem.mpd.cat.CatPackage#getRelationshipType_ResourceURI()
     * @model dataType="org.search.niem.mpd.cat.URISimpleType" required="true"
     *        extendedMetaData="kind='attribute' name='resourceURI' namespace='##targetNamespace'"
     * @generated
     */
    String getResourceURI();

    /**
     * Sets the value of the '{@link org.search.niem.mpd.cat.RelationshipType#getResourceURI <em>Resource URI</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource URI</em>' attribute.
     * @see #getResourceURI()
     * @generated
     */
    void setResourceURI(String value);

} // RelationshipType
