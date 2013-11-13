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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>MPD Class Code Simple Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getMPDClassCodeSimpleType()
 * @model extendedMetaData="name='MPDClassCodeSimpleType'"
 * @generated
 */
public enum MPDClassCodeSimpleType implements Enumerator {
    /**
     * The '<em><b>Release</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #RELEASE_VALUE
     * @generated
     * @ordered
     */
    RELEASE(0, "release", "release"),

    /**
     * The '<em><b>Core Update</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #CORE_UPDATE_VALUE
     * @generated
     * @ordered
     */
    CORE_UPDATE(1, "coreUpdate", "core-update"),

    /**
     * The '<em><b>Domain Update</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DOMAIN_UPDATE_VALUE
     * @generated
     * @ordered
     */
    DOMAIN_UPDATE(2, "domainUpdate", "domain-update"),

    /**
     * The '<em><b>Iepd</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #IEPD_VALUE
     * @generated
     * @ordered
     */
    IEPD(3, "iepd", "iepd"),

    /**
     * The '<em><b>Eiem</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #EIEM_VALUE
     * @generated
     * @ordered
     */
    EIEM(4, "eiem", "eiem");

    /**
     * The '<em><b>Release</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Release</b></em>' literal object isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #RELEASE
     * @model name="release"
     * @generated
     * @ordered
     */
    public static final int RELEASE_VALUE = 0;

    /**
     * The '<em><b>Core Update</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Core Update</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #CORE_UPDATE
     * @model name="coreUpdate" literal="core-update"
     * @generated
     * @ordered
     */
    public static final int CORE_UPDATE_VALUE = 1;

    /**
     * The '<em><b>Domain Update</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Domain Update</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DOMAIN_UPDATE
     * @model name="domainUpdate" literal="domain-update"
     * @generated
     * @ordered
     */
    public static final int DOMAIN_UPDATE_VALUE = 2;

    /**
     * The '<em><b>Iepd</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Iepd</b></em>' literal object isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #IEPD
     * @model name="iepd"
     * @generated
     * @ordered
     */
    public static final int IEPD_VALUE = 3;

    /**
     * The '<em><b>Eiem</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Eiem</b></em>' literal object isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #EIEM
     * @model name="eiem"
     * @generated
     * @ordered
     */
    public static final int EIEM_VALUE = 4;

    /**
     * An array of all the '<em><b>MPD Class Code Simple Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final MPDClassCodeSimpleType[] VALUES_ARRAY = new MPDClassCodeSimpleType[] { RELEASE, CORE_UPDATE,
            DOMAIN_UPDATE, IEPD, EIEM, };

    /**
     * A public read-only list of all the '<em><b>MPD Class Code Simple Type</b></em>' enumerators. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<MPDClassCodeSimpleType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>MPD Class Code Simple Type</b></em>' literal with the specified literal value. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static MPDClassCodeSimpleType get(final String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            final MPDClassCodeSimpleType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>MPD Class Code Simple Type</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static MPDClassCodeSimpleType getByName(final String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            final MPDClassCodeSimpleType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>MPD Class Code Simple Type</b></em>' literal with the specified integer value. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static MPDClassCodeSimpleType get(final int value) {
        switch (value) {
        case RELEASE_VALUE:
            return RELEASE;
        case CORE_UPDATE_VALUE:
            return CORE_UPDATE;
        case DOMAIN_UPDATE_VALUE:
            return DOMAIN_UPDATE;
        case IEPD_VALUE:
            return IEPD;
        case EIEM_VALUE:
            return EIEM;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private MPDClassCodeSimpleType(final int value, final String name, final String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // MPDClassCodeSimpleType
