/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage
 * @generated
 */
public interface NiemUmlPropertyFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NiemUmlPropertyFactory eINSTANCE = org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.NiemUmlPropertyFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Property Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Rule</em>'.
   * @generated
   */
  PropertyRule createPropertyRule();

  /**
   * Returns a new object of class '<em>Aggregation Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregation Rule</em>'.
   * @generated
   */
  AggregationRule createAggregationRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  NiemUmlPropertyPackage getNiemUmlPropertyPackage();

} //NiemUmlPropertyFactory
