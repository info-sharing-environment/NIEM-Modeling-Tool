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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.MPDClassCodeSimpleType;
import org.search.niem.mpd.cat.MetadataType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Catalog Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getArtifactGroup <em>Artifact Group</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getArtifact <em>Artifact</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getMetadata <em>Metadata</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getDescriptionText <em>Description Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getMpdClassCode <em>Mpd Class Code</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getMpdName <em>Mpd Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getMpdURI <em>Mpd URI</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.CatalogTypeImpl#getMpdVersionID <em>Mpd Version ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CatalogTypeImpl extends MinimalEObjectImpl.Container implements CatalogType {
    /**
     * The cached value of the '{@link #getArtifactGroup() <em>Artifact Group</em>}' attribute list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getArtifactGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap artifactGroup;

    /**
     * The cached value of the '{@link #getMetadata() <em>Metadata</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMetadata()
     * @generated
     * @ordered
     */
    protected MetadataType metadata;

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
     * The default value of the '{@link #getMpdClassCode() <em>Mpd Class Code</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdClassCode()
     * @generated
     * @ordered
     */
    protected static final MPDClassCodeSimpleType MPD_CLASS_CODE_EDEFAULT = MPDClassCodeSimpleType.RELEASE;

    /**
     * The cached value of the '{@link #getMpdClassCode() <em>Mpd Class Code</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdClassCode()
     * @generated
     * @ordered
     */
    protected MPDClassCodeSimpleType mpdClassCode = MPD_CLASS_CODE_EDEFAULT;

    /**
     * This is true if the Mpd Class Code attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean mpdClassCodeESet;

    /**
     * The default value of the '{@link #getMpdName() <em>Mpd Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdName()
     * @generated
     * @ordered
     */
    protected static final String MPD_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdName() <em>Mpd Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdName()
     * @generated
     * @ordered
     */
    protected String mpdName = MPD_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getMpdURI() <em>Mpd URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdURI()
     * @generated
     * @ordered
     */
    protected static final String MPD_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdURI() <em>Mpd URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getMpdURI()
     * @generated
     * @ordered
     */
    protected String mpdURI = MPD_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getMpdVersionID() <em>Mpd Version ID</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdVersionID()
     * @generated
     * @ordered
     */
    protected static final String MPD_VERSION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMpdVersionID() <em>Mpd Version ID</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMpdVersionID()
     * @generated
     * @ordered
     */
    protected String mpdVersionID = MPD_VERSION_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CatalogTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.CATALOG_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FeatureMap getArtifactGroup() {
        if (artifactGroup == null) {
            artifactGroup = new BasicFeatureMap(this, CatPackage.CATALOG_TYPE__ARTIFACT_GROUP);
        }
        return artifactGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<EObject> getArtifact() {
        return getArtifactGroup().list(CatPackage.Literals.CATALOG_TYPE__ARTIFACT);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMetadata(final MetadataType newMetadata, NotificationChain msgs) {
        final MetadataType oldMetadata = metadata;
        metadata = newMetadata;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CatPackage.CATALOG_TYPE__METADATA, oldMetadata, newMetadata);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMetadata(final MetadataType newMetadata) {
        if (newMetadata != metadata) {
            NotificationChain msgs = null;
            if (metadata != null) {
                msgs = ((InternalEObject) metadata).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - CatPackage.CATALOG_TYPE__METADATA, null, msgs);
            }
            if (newMetadata != null) {
                msgs = ((InternalEObject) newMetadata).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - CatPackage.CATALOG_TYPE__METADATA, null, msgs);
            }
            msgs = basicSetMetadata(newMetadata, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__METADATA, newMetadata,
                    newMetadata));
        }
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
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__DESCRIPTION_TEXT,
                    oldDescriptionText, descriptionText));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MPDClassCodeSimpleType getMpdClassCode() {
        return mpdClassCode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdClassCode(final MPDClassCodeSimpleType newMpdClassCode) {
        final MPDClassCodeSimpleType oldMpdClassCode = mpdClassCode;
        mpdClassCode = newMpdClassCode == null ? MPD_CLASS_CODE_EDEFAULT : newMpdClassCode;
        final boolean oldMpdClassCodeESet = mpdClassCodeESet;
        mpdClassCodeESet = true;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__MPD_CLASS_CODE, oldMpdClassCode,
                    mpdClassCode, !oldMpdClassCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void unsetMpdClassCode() {
        final MPDClassCodeSimpleType oldMpdClassCode = mpdClassCode;
        final boolean oldMpdClassCodeESet = mpdClassCodeESet;
        mpdClassCode = MPD_CLASS_CODE_EDEFAULT;
        mpdClassCodeESet = false;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.UNSET, CatPackage.CATALOG_TYPE__MPD_CLASS_CODE,
                    oldMpdClassCode, MPD_CLASS_CODE_EDEFAULT, oldMpdClassCodeESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSetMpdClassCode() {
        return mpdClassCodeESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdName() {
        return mpdName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdName(final String newMpdName) {
        final String oldMpdName = mpdName;
        mpdName = newMpdName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__MPD_NAME, oldMpdName, mpdName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdURI() {
        return mpdURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdURI(final String newMpdURI) {
        final String oldMpdURI = mpdURI;
        mpdURI = newMpdURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__MPD_URI, oldMpdURI, mpdURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMpdVersionID() {
        return mpdVersionID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMpdVersionID(final String newMpdVersionID) {
        final String oldMpdVersionID = mpdVersionID;
        mpdVersionID = newMpdVersionID;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.CATALOG_TYPE__MPD_VERSION_ID, oldMpdVersionID,
                    mpdVersionID));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setMpdClassCode(final String mpdClassCode) {
        setMpdClassCode(MPDClassCodeSimpleType.get(mpdClassCode));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case CatPackage.CATALOG_TYPE__ARTIFACT_GROUP:
            return ((InternalEList<?>) getArtifactGroup()).basicRemove(otherEnd, msgs);
        case CatPackage.CATALOG_TYPE__ARTIFACT:
            return ((InternalEList<?>) getArtifact()).basicRemove(otherEnd, msgs);
        case CatPackage.CATALOG_TYPE__METADATA:
            return basicSetMetadata(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CatPackage.CATALOG_TYPE__ARTIFACT_GROUP:
            if (coreType) {
                return getArtifactGroup();
            }
            return ((FeatureMap.Internal) getArtifactGroup()).getWrapper();
        case CatPackage.CATALOG_TYPE__ARTIFACT:
            return getArtifact();
        case CatPackage.CATALOG_TYPE__METADATA:
            return getMetadata();
        case CatPackage.CATALOG_TYPE__DESCRIPTION_TEXT:
            return getDescriptionText();
        case CatPackage.CATALOG_TYPE__MPD_CLASS_CODE:
            return getMpdClassCode();
        case CatPackage.CATALOG_TYPE__MPD_NAME:
            return getMpdName();
        case CatPackage.CATALOG_TYPE__MPD_URI:
            return getMpdURI();
        case CatPackage.CATALOG_TYPE__MPD_VERSION_ID:
            return getMpdVersionID();
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
        case CatPackage.CATALOG_TYPE__ARTIFACT_GROUP:
            ((FeatureMap.Internal) getArtifactGroup()).set(newValue);
            return;
        case CatPackage.CATALOG_TYPE__METADATA:
            setMetadata((MetadataType) newValue);
            return;
        case CatPackage.CATALOG_TYPE__DESCRIPTION_TEXT:
            setDescriptionText((String) newValue);
            return;
        case CatPackage.CATALOG_TYPE__MPD_CLASS_CODE:
            setMpdClassCode((MPDClassCodeSimpleType) newValue);
            return;
        case CatPackage.CATALOG_TYPE__MPD_NAME:
            setMpdName((String) newValue);
            return;
        case CatPackage.CATALOG_TYPE__MPD_URI:
            setMpdURI((String) newValue);
            return;
        case CatPackage.CATALOG_TYPE__MPD_VERSION_ID:
            setMpdVersionID((String) newValue);
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
        case CatPackage.CATALOG_TYPE__ARTIFACT_GROUP:
            getArtifactGroup().clear();
            return;
        case CatPackage.CATALOG_TYPE__METADATA:
            setMetadata((MetadataType) null);
            return;
        case CatPackage.CATALOG_TYPE__DESCRIPTION_TEXT:
            setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
            return;
        case CatPackage.CATALOG_TYPE__MPD_CLASS_CODE:
            unsetMpdClassCode();
            return;
        case CatPackage.CATALOG_TYPE__MPD_NAME:
            setMpdName(MPD_NAME_EDEFAULT);
            return;
        case CatPackage.CATALOG_TYPE__MPD_URI:
            setMpdURI(MPD_URI_EDEFAULT);
            return;
        case CatPackage.CATALOG_TYPE__MPD_VERSION_ID:
            setMpdVersionID(MPD_VERSION_ID_EDEFAULT);
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
        case CatPackage.CATALOG_TYPE__ARTIFACT_GROUP:
            return artifactGroup != null && !artifactGroup.isEmpty();
        case CatPackage.CATALOG_TYPE__ARTIFACT:
            return !getArtifact().isEmpty();
        case CatPackage.CATALOG_TYPE__METADATA:
            return metadata != null;
        case CatPackage.CATALOG_TYPE__DESCRIPTION_TEXT:
            return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT
                    .equals(descriptionText);
        case CatPackage.CATALOG_TYPE__MPD_CLASS_CODE:
            return isSetMpdClassCode();
        case CatPackage.CATALOG_TYPE__MPD_NAME:
            return MPD_NAME_EDEFAULT == null ? mpdName != null : !MPD_NAME_EDEFAULT.equals(mpdName);
        case CatPackage.CATALOG_TYPE__MPD_URI:
            return MPD_URI_EDEFAULT == null ? mpdURI != null : !MPD_URI_EDEFAULT.equals(mpdURI);
        case CatPackage.CATALOG_TYPE__MPD_VERSION_ID:
            return MPD_VERSION_ID_EDEFAULT == null ? mpdVersionID != null : !MPD_VERSION_ID_EDEFAULT.equals(mpdVersionID);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eInvoke(final int operationID, final EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
        case CatPackage.CATALOG_TYPE___SET_MPD_CLASS_CODE__STRING:
            setMpdClassCode((String) arguments.get(0));
            return null;
        }
        return super.eInvoke(operationID, arguments);
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
        result.append(" (artifactGroup: ");
        result.append(artifactGroup);
        result.append(", descriptionText: ");
        result.append(descriptionText);
        result.append(", mpdClassCode: ");
        if (mpdClassCodeESet) {
            result.append(mpdClassCode);
        } else {
            result.append("<unset>");
        }
        result.append(", mpdName: ");
        result.append(mpdName);
        result.append(", mpdURI: ");
        result.append(mpdURI);
        result.append(", mpdVersionID: ");
        result.append(mpdVersionID);
        result.append(')');
        return result.toString();
    }

} // CatalogTypeImpl
