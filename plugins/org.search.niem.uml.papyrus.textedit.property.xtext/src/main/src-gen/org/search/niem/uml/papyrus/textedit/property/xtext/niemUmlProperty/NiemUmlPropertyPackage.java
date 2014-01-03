/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyFactory
 * @model kind="package"
 * @generated
 */
public interface NiemUmlPropertyPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "niemUmlProperty";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://search.org/niem/uml/papyrus/textedit/property/xtext/NiemUmlProperty";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "niemUmlProperty";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NiemUmlPropertyPackage eINSTANCE = org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl.init();

  /**
   * The meta object id for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.PropertyRuleImpl <em>Property Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.PropertyRuleImpl
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getPropertyRule()
   * @generated
   */
  int PROPERTY_RULE = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__VISIBILITY = UmlPropertyPackage.PROPERTY_RULE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Is Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__IS_DERIVED = UmlPropertyPackage.PROPERTY_RULE__IS_DERIVED;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__NAME = UmlPropertyPackage.PROPERTY_RULE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__TYPE = UmlPropertyPackage.PROPERTY_RULE__TYPE;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__MULTIPLICITY = UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__MODIFIERS = UmlPropertyPackage.PROPERTY_RULE__MODIFIERS;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__DEFAULT = UmlPropertyPackage.PROPERTY_RULE__DEFAULT;

  /**
   * The feature id for the '<em><b>Aggregation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__AGGREGATION = UmlPropertyPackage.PROPERTY_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE_FEATURE_COUNT = UmlPropertyPackage.PROPERTY_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.AggregationRuleImpl <em>Aggregation Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.AggregationRuleImpl
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getAggregationRule()
   * @generated
   */
  int AGGREGATION_RULE = 1;

  /**
   * The feature id for the '<em><b>Aggregation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION_RULE__AGGREGATION = 0;

  /**
   * The number of structural features of the '<em>Aggregation Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind <em>Aggregation Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getAggregationKind()
   * @generated
   */
  int AGGREGATION_KIND = 2;


  /**
   * Returns the meta object for class '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule <em>Property Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Rule</em>'.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule
   * @generated
   */
  EClass getPropertyRule();

  /**
   * Returns the meta object for the containment reference '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule#getAggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Aggregation</em>'.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule#getAggregation()
   * @see #getPropertyRule()
   * @generated
   */
  EReference getPropertyRule_Aggregation();

  /**
   * Returns the meta object for class '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule <em>Aggregation Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregation Rule</em>'.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule
   * @generated
   */
  EClass getAggregationRule();

  /**
   * Returns the meta object for the attribute '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule#getAggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Aggregation</em>'.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule#getAggregation()
   * @see #getAggregationRule()
   * @generated
   */
  EAttribute getAggregationRule_Aggregation();

  /**
   * Returns the meta object for enum '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind <em>Aggregation Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Aggregation Kind</em>'.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind
   * @generated
   */
  EEnum getAggregationKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  NiemUmlPropertyFactory getNiemUmlPropertyFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.PropertyRuleImpl <em>Property Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.PropertyRuleImpl
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getPropertyRule()
     * @generated
     */
    EClass PROPERTY_RULE = eINSTANCE.getPropertyRule();

    /**
     * The meta object literal for the '<em><b>Aggregation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_RULE__AGGREGATION = eINSTANCE.getPropertyRule_Aggregation();

    /**
     * The meta object literal for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.AggregationRuleImpl <em>Aggregation Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.AggregationRuleImpl
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getAggregationRule()
     * @generated
     */
    EClass AGGREGATION_RULE = eINSTANCE.getAggregationRule();

    /**
     * The meta object literal for the '<em><b>Aggregation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATION_RULE__AGGREGATION = eINSTANCE.getAggregationRule_Aggregation();

    /**
     * The meta object literal for the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind <em>Aggregation Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind
     * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyPackageImpl#getAggregationKind()
     * @generated
     */
    EEnum AGGREGATION_KIND = eINSTANCE.getAggregationKind();

  }

} //NiemUmlPropertyPackage
