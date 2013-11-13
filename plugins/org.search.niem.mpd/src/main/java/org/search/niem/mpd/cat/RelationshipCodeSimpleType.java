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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Relationship Code Simple Type</b></em>
 * ', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage#getRelationshipCodeSimpleType()
 * @model extendedMetaData="name='RelationshipCodeSimpleType'"
 * @generated
 */
public enum RelationshipCodeSimpleType implements Enumerator {
    /**
     * The '<em><b>Version Of</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #VERSION_OF_VALUE
     * @generated
     * @ordered
     */
    VERSION_OF(0, "versionOf", "version_of"),

    /**
     * The '<em><b>Specializes</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SPECIALIZES_VALUE
     * @generated
     * @ordered
     */
    SPECIALIZES(1, "specializes", "specializes"),

    /**
     * The '<em><b>Generalizes</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #GENERALIZES_VALUE
     * @generated
     * @ordered
     */
    GENERALIZES(2, "generalizes", "generalizes"),

    /**
     * The '<em><b>Supersedes</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SUPERSEDES_VALUE
     * @generated
     * @ordered
     */
    SUPERSEDES(3, "supersedes", "supersedes"),

    /**
     * The '<em><b>Deprecates</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DEPRECATES_VALUE
     * @generated
     * @ordered
     */
    DEPRECATES(4, "deprecates", "deprecates"),

    /**
     * The '<em><b>Adapts</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ADAPTS_VALUE
     * @generated
     * @ordered
     */
    ADAPTS(5, "adapts", "adapts"),

    /**
     * The '<em><b>Updates</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #UPDATES_VALUE
     * @generated
     * @ordered
     */
    UPDATES(6, "updates", "updates"),

    /**
     * The '<em><b>Conforms To</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #CONFORMS_TO_VALUE
     * @generated
     * @ordered
     */
    CONFORMS_TO(7, "conformsTo", "conforms_to");

    /**
     * The '<em><b>Version Of</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Version Of</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #VERSION_OF
     * @model name="versionOf" literal="version_of"
     * @generated
     * @ordered
     */
    public static final int VERSION_OF_VALUE = 0;

    /**
     * The '<em><b>Specializes</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Specializes</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SPECIALIZES
     * @model name="specializes"
     * @generated
     * @ordered
     */
    public static final int SPECIALIZES_VALUE = 1;

    /**
     * The '<em><b>Generalizes</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Generalizes</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #GENERALIZES
     * @model name="generalizes"
     * @generated
     * @ordered
     */
    public static final int GENERALIZES_VALUE = 2;

    /**
     * The '<em><b>Supersedes</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Supersedes</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SUPERSEDES
     * @model name="supersedes"
     * @generated
     * @ordered
     */
    public static final int SUPERSEDES_VALUE = 3;

    /**
     * The '<em><b>Deprecates</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Deprecates</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DEPRECATES
     * @model name="deprecates"
     * @generated
     * @ordered
     */
    public static final int DEPRECATES_VALUE = 4;

    /**
     * The '<em><b>Adapts</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Adapts</b></em>' literal object isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #ADAPTS
     * @model name="adapts"
     * @generated
     * @ordered
     */
    public static final int ADAPTS_VALUE = 5;

    /**
     * The '<em><b>Updates</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Updates</b></em>' literal object isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #UPDATES
     * @model name="updates"
     * @generated
     * @ordered
     */
    public static final int UPDATES_VALUE = 6;

    /**
     * The '<em><b>Conforms To</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Conforms To</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #CONFORMS_TO
     * @model name="conformsTo" literal="conforms_to"
     * @generated
     * @ordered
     */
    public static final int CONFORMS_TO_VALUE = 7;

    /**
     * An array of all the '<em><b>Relationship Code Simple Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final RelationshipCodeSimpleType[] VALUES_ARRAY = new RelationshipCodeSimpleType[] { VERSION_OF,
            SPECIALIZES, GENERALIZES, SUPERSEDES, DEPRECATES, ADAPTS, UPDATES, CONFORMS_TO, };

    /**
     * A public read-only list of all the '<em><b>Relationship Code Simple Type</b></em>' enumerators. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<RelationshipCodeSimpleType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Relationship Code Simple Type</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static RelationshipCodeSimpleType get(final String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            final RelationshipCodeSimpleType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Relationship Code Simple Type</b></em>' literal with the specified name. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static RelationshipCodeSimpleType getByName(final String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            final RelationshipCodeSimpleType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Relationship Code Simple Type</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static RelationshipCodeSimpleType get(final int value) {
        switch (value) {
        case VERSION_OF_VALUE:
            return VERSION_OF;
        case SPECIALIZES_VALUE:
            return SPECIALIZES;
        case GENERALIZES_VALUE:
            return GENERALIZES;
        case SUPERSEDES_VALUE:
            return SUPERSEDES;
        case DEPRECATES_VALUE:
            return DEPRECATES;
        case ADAPTS_VALUE:
            return ADAPTS;
        case UPDATES_VALUE:
            return UPDATES;
        case CONFORMS_TO_VALUE:
            return CONFORMS_TO;
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
    private RelationshipCodeSimpleType(final int value, final String name, final String literal) {
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

} // RelationshipCodeSimpleType
