/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule#getAggregation <em>Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage#getPropertyRule()
 * @model
 * @generated
 */
public interface PropertyRule extends org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule
{
  /**
   * Returns the value of the '<em><b>Aggregation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregation</em>' containment reference.
   * @see #setAggregation(AggregationRule)
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage#getPropertyRule_Aggregation()
   * @model containment="true"
   * @generated
   */
  AggregationRule getAggregation();

  /**
   * Sets the value of the '{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule#getAggregation <em>Aggregation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregation</em>' containment reference.
   * @see #getAggregation()
   * @generated
   */
  void setAggregation(AggregationRule value);

} // PropertyRule
