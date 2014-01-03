/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule#getAggregation <em>Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage#getAggregationRule()
 * @model
 * @generated
 */
public interface AggregationRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Aggregation</b></em>' attribute.
   * The literals are from the enumeration {@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregation</em>' attribute.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind
   * @see #setAggregation(AggregationKind)
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage#getAggregationRule_Aggregation()
   * @model
   * @generated
   */
  AggregationKind getAggregation();

  /**
   * Sets the value of the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule#getAggregation <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregation</em>' attribute.
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind
   * @see #getAggregation()
   * @generated
   */
  void setAggregation(AggregationKind value);

} // AggregationRule
