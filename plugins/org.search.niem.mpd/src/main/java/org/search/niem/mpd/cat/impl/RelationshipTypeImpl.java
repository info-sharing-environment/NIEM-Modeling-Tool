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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.RelationshipCodeSimpleType;
import org.search.niem.mpd.cat.RelationshipType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Relationship Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.RelationshipTypeImpl#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.RelationshipTypeImpl#getRelationshipCode <em>Relationship Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.RelationshipTypeImpl#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RelationshipTypeImpl extends MinimalEObjectImpl.Container implements RelationshipType {
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
    protected RelationshipTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.RELATIONSHIP_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.RELATIONSHIP_TYPE__DESCRIPTION_TEXT,
                    oldDescriptionText, descriptionText));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE,
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
            eNotify(new ENotificationImpl(this, Notification.UNSET, CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE,
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.RELATIONSHIP_TYPE__RESOURCE_URI,
                    oldResourceURI, resourceURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CatPackage.RELATIONSHIP_TYPE__DESCRIPTION_TEXT:
            return getDescriptionText();
        case CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE:
            return getRelationshipCode();
        case CatPackage.RELATIONSHIP_TYPE__RESOURCE_URI:
            return getResourceURI();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CatPackage.RELATIONSHIP_TYPE__DESCRIPTION_TEXT:
            setDescriptionText((String) newValue);
            return;
        case CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE:
            setRelationshipCode((RelationshipCodeSimpleType) newValue);
            return;
        case CatPackage.RELATIONSHIP_TYPE__RESOURCE_URI:
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
        case CatPackage.RELATIONSHIP_TYPE__DESCRIPTION_TEXT:
            setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
            return;
        case CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE:
            unsetRelationshipCode();
            return;
        case CatPackage.RELATIONSHIP_TYPE__RESOURCE_URI:
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
        case CatPackage.RELATIONSHIP_TYPE__DESCRIPTION_TEXT:
            return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT
                    .equals(descriptionText);
        case CatPackage.RELATIONSHIP_TYPE__RELATIONSHIP_CODE:
            return isSetRelationshipCode();
        case CatPackage.RELATIONSHIP_TYPE__RESOURCE_URI:
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
        result.append(" (descriptionText: ");
        result.append(descriptionText);
        result.append(", relationshipCode: ");
        if (relationshipCodeESet) {
            result.append(relationshipCode);
        } else {
            result.append("<unset>");
        }
        result.append(", resourceURI: ");
        result.append(resourceURI);
        result.append(')');
        return result.toString();
    }

} // RelationshipTypeImpl
