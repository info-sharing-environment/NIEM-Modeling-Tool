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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.search.niem.mpd.cat.AuthoritativeSourceType;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.POCType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Authoritative Source Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl#getASName <em>AS Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl#getASAddressText <em>AS Address Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl#getASWebSiteURL <em>AS Web Site URL</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.AuthoritativeSourceTypeImpl#getPOC <em>POC</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AuthoritativeSourceTypeImpl extends MinimalEObjectImpl.Container implements AuthoritativeSourceType {
    /**
     * The default value of the '{@link #getASName() <em>AS Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getASName()
     * @generated
     * @ordered
     */
    protected static final String AS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getASName() <em>AS Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getASName()
     * @generated
     * @ordered
     */
    protected String aSName = AS_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getASAddressText() <em>AS Address Text</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getASAddressText()
     * @generated
     * @ordered
     */
    protected static final String AS_ADDRESS_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getASAddressText() <em>AS Address Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getASAddressText()
     * @generated
     * @ordered
     */
    protected String aSAddressText = AS_ADDRESS_TEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getASWebSiteURL() <em>AS Web Site URL</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getASWebSiteURL()
     * @generated
     * @ordered
     */
    protected static final String AS_WEB_SITE_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getASWebSiteURL() <em>AS Web Site URL</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getASWebSiteURL()
     * @generated
     * @ordered
     */
    protected String aSWebSiteURL = AS_WEB_SITE_URL_EDEFAULT;

    /**
     * The cached value of the '{@link #getPOC() <em>POC</em>}' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPOC()
     * @generated
     * @ordered
     */
    protected EList<POCType> pOC;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AuthoritativeSourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.AUTHORITATIVE_SOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASName() {
        return aSName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASName(final String newASName) {
        final String oldASName = aSName;
        aSName = newASName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_NAME, oldASName,
                    aSName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASAddressText() {
        return aSAddressText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASAddressText(final String newASAddressText) {
        final String oldASAddressText = aSAddressText;
        aSAddressText = newASAddressText;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT,
                    oldASAddressText, aSAddressText));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getASWebSiteURL() {
        return aSWebSiteURL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setASWebSiteURL(final String newASWebSiteURL) {
        final String oldASWebSiteURL = aSWebSiteURL;
        aSWebSiteURL = newASWebSiteURL;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL,
                    oldASWebSiteURL, aSWebSiteURL));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<POCType> getPOC() {
        if (pOC == null) {
            pOC = new EObjectContainmentEList<POCType>(POCType.class, this, CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC);
        }
        return pOC;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC:
            return ((InternalEList<?>) getPOC()).basicRemove(otherEnd, msgs);
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
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_NAME:
            return getASName();
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT:
            return getASAddressText();
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL:
            return getASWebSiteURL();
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC:
            return getPOC();
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
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_NAME:
            setASName((String) newValue);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT:
            setASAddressText((String) newValue);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL:
            setASWebSiteURL((String) newValue);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC:
            getPOC().clear();
            getPOC().addAll((Collection<? extends POCType>) newValue);
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
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_NAME:
            setASName(AS_NAME_EDEFAULT);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT:
            setASAddressText(AS_ADDRESS_TEXT_EDEFAULT);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL:
            setASWebSiteURL(AS_WEB_SITE_URL_EDEFAULT);
            return;
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC:
            getPOC().clear();
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
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_NAME:
            return AS_NAME_EDEFAULT == null ? aSName != null : !AS_NAME_EDEFAULT.equals(aSName);
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_ADDRESS_TEXT:
            return AS_ADDRESS_TEXT_EDEFAULT == null ? aSAddressText != null : !AS_ADDRESS_TEXT_EDEFAULT
                    .equals(aSAddressText);
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__AS_WEB_SITE_URL:
            return AS_WEB_SITE_URL_EDEFAULT == null ? aSWebSiteURL != null : !AS_WEB_SITE_URL_EDEFAULT.equals(aSWebSiteURL);
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE__POC:
            return pOC != null && !pOC.isEmpty();
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
        result.append(" (aSName: ");
        result.append(aSName);
        result.append(", aSAddressText: ");
        result.append(aSAddressText);
        result.append(", aSWebSiteURL: ");
        result.append(aSWebSiteURL);
        result.append(')');
        return result.toString();
    }

} // AuthoritativeSourceTypeImpl
