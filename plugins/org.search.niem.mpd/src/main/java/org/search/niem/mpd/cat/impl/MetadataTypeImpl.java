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
import java.util.Collection;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.search.niem.mpd.Activator;
import org.search.niem.mpd.cat.AuthoritativeSourceType;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.MetadataType;
import org.search.niem.mpd.cat.RelationshipType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Metadata Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getSecurityMarkingText <em>Security Marking Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getLastRevisionDate <em>Last Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getNextRevisionDate <em>Next Revision Date</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getStatusText <em>Status Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getRelationship <em>Relationship</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getKeywordText <em>Keyword Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getDomainText <em>Domain Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getPurposeText <em>Purpose Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getExchangePatternText <em>Exchange Pattern Text</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getExchangePartnerName <em>Exchange Partner Name</em>}</li>
 * <li>{@link org.search.niem.mpd.cat.impl.MetadataTypeImpl#getAuthoritativeSource <em>Authoritative Source</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MetadataTypeImpl extends MinimalEObjectImpl.Container implements MetadataType {
    /**
     * The default value of the '{@link #getSecurityMarkingText() <em>Security Marking Text</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSecurityMarkingText()
     * @generated
     * @ordered
     */
    protected static final String SECURITY_MARKING_TEXT_EDEFAULT = "unclassified";

    /**
     * The cached value of the '{@link #getSecurityMarkingText() <em>Security Marking Text</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSecurityMarkingText()
     * @generated
     * @ordered
     */
    protected String securityMarkingText = SECURITY_MARKING_TEXT_EDEFAULT;

    /**
     * This is true if the Security Marking Text attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean securityMarkingTextESet;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected XMLGregorianCalendar creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getLastRevisionDate() <em>Last Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getLastRevisionDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar LAST_REVISION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastRevisionDate() <em>Last Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getLastRevisionDate()
     * @generated
     * @ordered
     */
    protected XMLGregorianCalendar lastRevisionDate = LAST_REVISION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getNextRevisionDate() <em>Next Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getNextRevisionDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar NEXT_REVISION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNextRevisionDate() <em>Next Revision Date</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getNextRevisionDate()
     * @generated
     * @ordered
     */
    protected XMLGregorianCalendar nextRevisionDate = NEXT_REVISION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getStatusText() <em>Status Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStatusText()
     * @generated
     * @ordered
     */
    protected static final String STATUS_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStatusText() <em>Status Text</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStatusText()
     * @generated
     * @ordered
     */
    protected String statusText = STATUS_TEXT_EDEFAULT;

    /**
     * The cached value of the '{@link #getRelationship() <em>Relationship</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRelationship()
     * @generated
     * @ordered
     */
    protected EList<RelationshipType> relationship;

    /**
     * The cached value of the '{@link #getKeywordText() <em>Keyword Text</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getKeywordText()
     * @generated
     * @ordered
     */
    protected EList<String> keywordText;

    /**
     * The cached value of the '{@link #getDomainText() <em>Domain Text</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDomainText()
     * @generated
     * @ordered
     */
    protected EList<String> domainText;

    /**
     * The cached value of the '{@link #getPurposeText() <em>Purpose Text</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPurposeText()
     * @generated
     * @ordered
     */
    protected EList<String> purposeText;

    /**
     * The cached value of the '{@link #getExchangePatternText() <em>Exchange Pattern Text</em>}' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExchangePatternText()
     * @generated
     * @ordered
     */
    protected EList<String> exchangePatternText;

    /**
     * The cached value of the '{@link #getExchangePartnerName() <em>Exchange Partner Name</em>}' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExchangePartnerName()
     * @generated
     * @ordered
     */
    protected EList<String> exchangePartnerName;

    /**
     * The cached value of the '{@link #getAuthoritativeSource() <em>Authoritative Source</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAuthoritativeSource()
     * @generated
     * @ordered
     */
    protected AuthoritativeSourceType authoritativeSource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MetadataTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CatPackage.Literals.METADATA_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSecurityMarkingText() {
        return securityMarkingText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSecurityMarkingText(final String newSecurityMarkingText) {
        final String oldSecurityMarkingText = securityMarkingText;
        securityMarkingText = newSecurityMarkingText;
        final boolean oldSecurityMarkingTextESet = securityMarkingTextESet;
        securityMarkingTextESet = true;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT,
                    oldSecurityMarkingText, securityMarkingText, !oldSecurityMarkingTextESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void unsetSecurityMarkingText() {
        final String oldSecurityMarkingText = securityMarkingText;
        final boolean oldSecurityMarkingTextESet = securityMarkingTextESet;
        securityMarkingText = SECURITY_MARKING_TEXT_EDEFAULT;
        securityMarkingTextESet = false;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.UNSET, CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT,
                    oldSecurityMarkingText, SECURITY_MARKING_TEXT_EDEFAULT, oldSecurityMarkingTextESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isSetSecurityMarkingText() {
        return securityMarkingTextESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCreationDate(final XMLGregorianCalendar newCreationDate) {
        final XMLGregorianCalendar oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__CREATION_DATE, oldCreationDate,
                    creationDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getLastRevisionDate() {
        return lastRevisionDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLastRevisionDate(final XMLGregorianCalendar newLastRevisionDate) {
        final XMLGregorianCalendar oldLastRevisionDate = lastRevisionDate;
        lastRevisionDate = newLastRevisionDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__LAST_REVISION_DATE,
                    oldLastRevisionDate, lastRevisionDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public XMLGregorianCalendar getNextRevisionDate() {
        return nextRevisionDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNextRevisionDate(final XMLGregorianCalendar newNextRevisionDate) {
        final XMLGregorianCalendar oldNextRevisionDate = nextRevisionDate;
        nextRevisionDate = newNextRevisionDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__NEXT_REVISION_DATE,
                    oldNextRevisionDate, nextRevisionDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getStatusText() {
        return statusText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStatusText(final String newStatusText) {
        final String oldStatusText = statusText;
        statusText = newStatusText;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__STATUS_TEXT, oldStatusText,
                    statusText));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<RelationshipType> getRelationship() {
        if (relationship == null) {
            relationship = new EObjectContainmentEList<RelationshipType>(RelationshipType.class, this,
                    CatPackage.METADATA_TYPE__RELATIONSHIP);
        }
        return relationship;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getKeywordText() {
        if (keywordText == null) {
            keywordText = new EDataTypeEList<String>(String.class, this, CatPackage.METADATA_TYPE__KEYWORD_TEXT);
        }
        return keywordText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getDomainText() {
        if (domainText == null) {
            domainText = new EDataTypeEList<String>(String.class, this, CatPackage.METADATA_TYPE__DOMAIN_TEXT);
        }
        return domainText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getPurposeText() {
        if (purposeText == null) {
            purposeText = new EDataTypeEList<String>(String.class, this, CatPackage.METADATA_TYPE__PURPOSE_TEXT);
        }
        return purposeText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getExchangePatternText() {
        if (exchangePatternText == null) {
            exchangePatternText = new EDataTypeEList<String>(String.class, this,
                    CatPackage.METADATA_TYPE__EXCHANGE_PATTERN_TEXT);
        }
        return exchangePatternText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<String> getExchangePartnerName() {
        if (exchangePartnerName == null) {
            exchangePartnerName = new EDataTypeEList<String>(String.class, this,
                    CatPackage.METADATA_TYPE__EXCHANGE_PARTNER_NAME);
        }
        return exchangePartnerName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AuthoritativeSourceType getAuthoritativeSource() {
        return authoritativeSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetAuthoritativeSource(final AuthoritativeSourceType newAuthoritativeSource,
            NotificationChain msgs) {
        final AuthoritativeSourceType oldAuthoritativeSource = authoritativeSource;
        authoritativeSource = newAuthoritativeSource;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE, oldAuthoritativeSource, newAuthoritativeSource);
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
    public void setAuthoritativeSource(final AuthoritativeSourceType newAuthoritativeSource) {
        if (newAuthoritativeSource != authoritativeSource) {
            NotificationChain msgs = null;
            if (authoritativeSource != null) {
                msgs = ((InternalEObject) authoritativeSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE, null, msgs);
            }
            if (newAuthoritativeSource != null) {
                msgs = ((InternalEObject) newAuthoritativeSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE, null, msgs);
            }
            msgs = basicSetAuthoritativeSource(newAuthoritativeSource, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE,
                    newAuthoritativeSource, newAuthoritativeSource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setCreationDate(final String dateString) {
        try {
            setCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString));
        } catch (final DatatypeConfigurationException e) {
            Activator.INSTANCE.log(e);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case CatPackage.METADATA_TYPE__RELATIONSHIP:
            return ((InternalEList<?>) getRelationship()).basicRemove(otherEnd, msgs);
        case CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE:
            return basicSetAuthoritativeSource(null, msgs);
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
        case CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT:
            return getSecurityMarkingText();
        case CatPackage.METADATA_TYPE__CREATION_DATE:
            return getCreationDate();
        case CatPackage.METADATA_TYPE__LAST_REVISION_DATE:
            return getLastRevisionDate();
        case CatPackage.METADATA_TYPE__NEXT_REVISION_DATE:
            return getNextRevisionDate();
        case CatPackage.METADATA_TYPE__STATUS_TEXT:
            return getStatusText();
        case CatPackage.METADATA_TYPE__RELATIONSHIP:
            return getRelationship();
        case CatPackage.METADATA_TYPE__KEYWORD_TEXT:
            return getKeywordText();
        case CatPackage.METADATA_TYPE__DOMAIN_TEXT:
            return getDomainText();
        case CatPackage.METADATA_TYPE__PURPOSE_TEXT:
            return getPurposeText();
        case CatPackage.METADATA_TYPE__EXCHANGE_PATTERN_TEXT:
            return getExchangePatternText();
        case CatPackage.METADATA_TYPE__EXCHANGE_PARTNER_NAME:
            return getExchangePartnerName();
        case CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE:
            return getAuthoritativeSource();
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
        case CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT:
            setSecurityMarkingText((String) newValue);
            return;
        case CatPackage.METADATA_TYPE__CREATION_DATE:
            setCreationDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.METADATA_TYPE__LAST_REVISION_DATE:
            setLastRevisionDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.METADATA_TYPE__NEXT_REVISION_DATE:
            setNextRevisionDate((XMLGregorianCalendar) newValue);
            return;
        case CatPackage.METADATA_TYPE__STATUS_TEXT:
            setStatusText((String) newValue);
            return;
        case CatPackage.METADATA_TYPE__RELATIONSHIP:
            getRelationship().clear();
            getRelationship().addAll((Collection<? extends RelationshipType>) newValue);
            return;
        case CatPackage.METADATA_TYPE__KEYWORD_TEXT:
            getKeywordText().clear();
            getKeywordText().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.METADATA_TYPE__DOMAIN_TEXT:
            getDomainText().clear();
            getDomainText().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.METADATA_TYPE__PURPOSE_TEXT:
            getPurposeText().clear();
            getPurposeText().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.METADATA_TYPE__EXCHANGE_PATTERN_TEXT:
            getExchangePatternText().clear();
            getExchangePatternText().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.METADATA_TYPE__EXCHANGE_PARTNER_NAME:
            getExchangePartnerName().clear();
            getExchangePartnerName().addAll((Collection<? extends String>) newValue);
            return;
        case CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE:
            setAuthoritativeSource((AuthoritativeSourceType) newValue);
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
        case CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT:
            unsetSecurityMarkingText();
            return;
        case CatPackage.METADATA_TYPE__CREATION_DATE:
            setCreationDate(CREATION_DATE_EDEFAULT);
            return;
        case CatPackage.METADATA_TYPE__LAST_REVISION_DATE:
            setLastRevisionDate(LAST_REVISION_DATE_EDEFAULT);
            return;
        case CatPackage.METADATA_TYPE__NEXT_REVISION_DATE:
            setNextRevisionDate(NEXT_REVISION_DATE_EDEFAULT);
            return;
        case CatPackage.METADATA_TYPE__STATUS_TEXT:
            setStatusText(STATUS_TEXT_EDEFAULT);
            return;
        case CatPackage.METADATA_TYPE__RELATIONSHIP:
            getRelationship().clear();
            return;
        case CatPackage.METADATA_TYPE__KEYWORD_TEXT:
            getKeywordText().clear();
            return;
        case CatPackage.METADATA_TYPE__DOMAIN_TEXT:
            getDomainText().clear();
            return;
        case CatPackage.METADATA_TYPE__PURPOSE_TEXT:
            getPurposeText().clear();
            return;
        case CatPackage.METADATA_TYPE__EXCHANGE_PATTERN_TEXT:
            getExchangePatternText().clear();
            return;
        case CatPackage.METADATA_TYPE__EXCHANGE_PARTNER_NAME:
            getExchangePartnerName().clear();
            return;
        case CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE:
            setAuthoritativeSource((AuthoritativeSourceType) null);
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
        case CatPackage.METADATA_TYPE__SECURITY_MARKING_TEXT:
            return isSetSecurityMarkingText();
        case CatPackage.METADATA_TYPE__CREATION_DATE:
            return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
        case CatPackage.METADATA_TYPE__LAST_REVISION_DATE:
            return LAST_REVISION_DATE_EDEFAULT == null ? lastRevisionDate != null : !LAST_REVISION_DATE_EDEFAULT
                    .equals(lastRevisionDate);
        case CatPackage.METADATA_TYPE__NEXT_REVISION_DATE:
            return NEXT_REVISION_DATE_EDEFAULT == null ? nextRevisionDate != null : !NEXT_REVISION_DATE_EDEFAULT
                    .equals(nextRevisionDate);
        case CatPackage.METADATA_TYPE__STATUS_TEXT:
            return STATUS_TEXT_EDEFAULT == null ? statusText != null : !STATUS_TEXT_EDEFAULT.equals(statusText);
        case CatPackage.METADATA_TYPE__RELATIONSHIP:
            return relationship != null && !relationship.isEmpty();
        case CatPackage.METADATA_TYPE__KEYWORD_TEXT:
            return keywordText != null && !keywordText.isEmpty();
        case CatPackage.METADATA_TYPE__DOMAIN_TEXT:
            return domainText != null && !domainText.isEmpty();
        case CatPackage.METADATA_TYPE__PURPOSE_TEXT:
            return purposeText != null && !purposeText.isEmpty();
        case CatPackage.METADATA_TYPE__EXCHANGE_PATTERN_TEXT:
            return exchangePatternText != null && !exchangePatternText.isEmpty();
        case CatPackage.METADATA_TYPE__EXCHANGE_PARTNER_NAME:
            return exchangePartnerName != null && !exchangePartnerName.isEmpty();
        case CatPackage.METADATA_TYPE__AUTHORITATIVE_SOURCE:
            return authoritativeSource != null;
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
        case CatPackage.METADATA_TYPE___SET_CREATION_DATE__STRING:
            setCreationDate((String) arguments.get(0));
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
        result.append(" (securityMarkingText: ");
        if (securityMarkingTextESet) {
            result.append(securityMarkingText);
        } else {
            result.append("<unset>");
        }
        result.append(", creationDate: ");
        result.append(creationDate);
        result.append(", lastRevisionDate: ");
        result.append(lastRevisionDate);
        result.append(", nextRevisionDate: ");
        result.append(nextRevisionDate);
        result.append(", statusText: ");
        result.append(statusText);
        result.append(", keywordText: ");
        result.append(keywordText);
        result.append(", domainText: ");
        result.append(domainText);
        result.append(", purposeText: ");
        result.append(purposeText);
        result.append(", exchangePatternText: ");
        result.append(exchangePatternText);
        result.append(", exchangePartnerName: ");
        result.append(exchangePartnerName);
        result.append(')');
        return result.toString();
    }

} // MetadataTypeImpl
