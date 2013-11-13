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
import org.search.niem.mpd.cat.FileType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getExternalURI <em>External URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getId <em>Id</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getNatureURI <em>Nature URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getPurposeURI <em>Purpose URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.FileTypeImpl#getRelativePathName <em>Relative Path Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FileTypeImpl extends MinimalEObjectImpl.Container implements FileType {
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FileTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.FILE_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__DESCRIPTION_TEXT,
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__EXTERNAL_URI, oldExternalURI,
                    externalURI));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__ID, oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__NATURE_URI, oldNatureURI, natureURI));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__PURPOSE_URI, oldPurposeURI,
                    purposeURI));
        }
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.FILE_TYPE__RELATIVE_PATH_NAME,
                    oldRelativePathName, relativePathName));
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
        case CatPackage.FILE_TYPE__DESCRIPTION_TEXT:
            return getDescriptionText();
        case CatPackage.FILE_TYPE__EXTERNAL_URI:
            return getExternalURI();
        case CatPackage.FILE_TYPE__ID:
            return getId();
        case CatPackage.FILE_TYPE__NATURE_URI:
            return getNatureURI();
        case CatPackage.FILE_TYPE__PURPOSE_URI:
            return getPurposeURI();
        case CatPackage.FILE_TYPE__RELATIVE_PATH_NAME:
            return getRelativePathName();
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
        case CatPackage.FILE_TYPE__DESCRIPTION_TEXT:
            setDescriptionText((String) newValue);
            return;
        case CatPackage.FILE_TYPE__EXTERNAL_URI:
            setExternalURI((String) newValue);
            return;
        case CatPackage.FILE_TYPE__ID:
            setId((String) newValue);
            return;
        case CatPackage.FILE_TYPE__NATURE_URI:
            setNatureURI((String) newValue);
            return;
        case CatPackage.FILE_TYPE__PURPOSE_URI:
            setPurposeURI((String) newValue);
            return;
        case CatPackage.FILE_TYPE__RELATIVE_PATH_NAME:
            setRelativePathName((String) newValue);
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
        case CatPackage.FILE_TYPE__DESCRIPTION_TEXT:
            setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
            return;
        case CatPackage.FILE_TYPE__EXTERNAL_URI:
            setExternalURI(EXTERNAL_URI_EDEFAULT);
            return;
        case CatPackage.FILE_TYPE__ID:
            setId(ID_EDEFAULT);
            return;
        case CatPackage.FILE_TYPE__NATURE_URI:
            setNatureURI(NATURE_URI_EDEFAULT);
            return;
        case CatPackage.FILE_TYPE__PURPOSE_URI:
            setPurposeURI(PURPOSE_URI_EDEFAULT);
            return;
        case CatPackage.FILE_TYPE__RELATIVE_PATH_NAME:
            setRelativePathName(RELATIVE_PATH_NAME_EDEFAULT);
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
        case CatPackage.FILE_TYPE__DESCRIPTION_TEXT:
            return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT
                    .equals(descriptionText);
        case CatPackage.FILE_TYPE__EXTERNAL_URI:
            return EXTERNAL_URI_EDEFAULT == null ? externalURI != null : !EXTERNAL_URI_EDEFAULT.equals(externalURI);
        case CatPackage.FILE_TYPE__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
        case CatPackage.FILE_TYPE__NATURE_URI:
            return NATURE_URI_EDEFAULT == null ? natureURI != null : !NATURE_URI_EDEFAULT.equals(natureURI);
        case CatPackage.FILE_TYPE__PURPOSE_URI:
            return PURPOSE_URI_EDEFAULT == null ? purposeURI != null : !PURPOSE_URI_EDEFAULT.equals(purposeURI);
        case CatPackage.FILE_TYPE__RELATIVE_PATH_NAME:
            return RELATIVE_PATH_NAME_EDEFAULT == null ? relativePathName != null : !RELATIVE_PATH_NAME_EDEFAULT
                    .equals(relativePathName);
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
        result.append(", externalURI: ");
        result.append(externalURI);
        result.append(", id: ");
        result.append(id);
        result.append(", natureURI: ");
        result.append(natureURI);
        result.append(", purposeURI: ");
        result.append(purposeURI);
        result.append(", relativePathName: ");
        result.append(relativePathName);
        result.append(')');
        return result.toString();
    }

} // FileTypeImpl
