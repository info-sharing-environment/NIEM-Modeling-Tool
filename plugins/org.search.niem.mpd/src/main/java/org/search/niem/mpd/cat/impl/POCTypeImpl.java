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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.POCType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>POC Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.POCTypeImpl#getPOCName <em>POC Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.POCTypeImpl#getPOCEmail <em>POC Email</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.POCTypeImpl#getPOCTelephone <em>POC Telephone</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class POCTypeImpl extends MinimalEObjectImpl.Container implements POCType {
    /**
     * The default value of the '{@link #getPOCName() <em>POC Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOCName()
     * @generated
     * @ordered
     */
    protected static final String POC_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPOCName() <em>POC Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getPOCName()
     * @generated
     * @ordered
     */
    protected String pOCName = POC_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getPOCEmail() <em>POC Email</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOCEmail()
     * @generated
     * @ordered
     */
    protected EList<String> pOCEmail;

    /**
     * The cached value of the '{@link #getPOCTelephone() <em>POC Telephone</em>}' attribute list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPOCTelephone()
     * @generated
     * @ordered
     */
    protected EList<String> pOCTelephone;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected POCTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.POC_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPOCName() {
        return pOCName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPOCName(final String newPOCName) {
        final String oldPOCName = pOCName;
        pOCName = newPOCName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.POC_TYPE__POC_NAME, oldPOCName, pOCName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getPOCEmail() {
        if (pOCEmail == null) {
            pOCEmail = new EDataTypeEList<String>(String.class, this, CatPackage.POC_TYPE__POC_EMAIL);
        }
        return pOCEmail;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getPOCTelephone() {
        if (pOCTelephone == null) {
            pOCTelephone = new EDataTypeEList<String>(String.class, this, CatPackage.POC_TYPE__POC_TELEPHONE);
        }
        return pOCTelephone;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CatPackage.POC_TYPE__POC_NAME:
            return getPOCName();
        case CatPackage.POC_TYPE__POC_EMAIL:
            return getPOCEmail();
        case CatPackage.POC_TYPE__POC_TELEPHONE:
            return getPOCTelephone();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CatPackage.POC_TYPE__POC_NAME:
            setPOCName((String) newValue);
            return;
        case CatPackage.POC_TYPE__POC_EMAIL:
            getPOCEmail().clear();
            getPOCEmail().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.POC_TYPE__POC_TELEPHONE:
            getPOCTelephone().clear();
            getPOCTelephone().addAll((Collection<? extends String>) newValue);
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
        case CatPackage.POC_TYPE__POC_NAME:
            setPOCName(POC_NAME_EDEFAULT);
            return;
        case CatPackage.POC_TYPE__POC_EMAIL:
            getPOCEmail().clear();
            return;
        case CatPackage.POC_TYPE__POC_TELEPHONE:
            getPOCTelephone().clear();
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
        case CatPackage.POC_TYPE__POC_NAME:
            return POC_NAME_EDEFAULT == null ? pOCName != null : !POC_NAME_EDEFAULT.equals(pOCName);
        case CatPackage.POC_TYPE__POC_EMAIL:
            return pOCEmail != null && !pOCEmail.isEmpty();
        case CatPackage.POC_TYPE__POC_TELEPHONE:
            return pOCTelephone != null && !pOCTelephone.isEmpty();
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
        result.append(" (pOCName: ");
        result.append(pOCName);
        result.append(", pOCEmail: ");
        result.append(pOCEmail);
        result.append(", pOCTelephone: ");
        result.append(pOCTelephone);
        result.append(')');
        return result.toString();
    }

} // POCTypeImpl
