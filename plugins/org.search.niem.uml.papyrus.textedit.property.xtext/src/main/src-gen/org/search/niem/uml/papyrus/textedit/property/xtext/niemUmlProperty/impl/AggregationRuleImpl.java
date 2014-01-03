/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.AggregationRuleImpl#getAggregation <em>Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregationRuleImpl extends MinimalEObjectImpl.Container implements AggregationRule
{
  /**
   * The default value of the '{@link #getAggregation() <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggregation()
   * @generated
   * @ordered
   */
  protected static final AggregationKind AGGREGATION_EDEFAULT = AggregationKind.NONE;

  /**
   * The cached value of the '{@link #getAggregation() <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggregation()
   * @generated
   * @ordered
   */
  protected AggregationKind aggregation = AGGREGATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AggregationRuleImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return NiemUmlPropertyPackage.Literals.AGGREGATION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregationKind getAggregation()
  {
    return aggregation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggregation(AggregationKind newAggregation)
  {
    AggregationKind oldAggregation = aggregation;
    aggregation = newAggregation == null ? AGGREGATION_EDEFAULT : newAggregation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NiemUmlPropertyPackage.AGGREGATION_RULE__AGGREGATION, oldAggregation, aggregation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case NiemUmlPropertyPackage.AGGREGATION_RULE__AGGREGATION:
        return getAggregation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case NiemUmlPropertyPackage.AGGREGATION_RULE__AGGREGATION:
        setAggregation((AggregationKind)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case NiemUmlPropertyPackage.AGGREGATION_RULE__AGGREGATION:
        setAggregation(AGGREGATION_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case NiemUmlPropertyPackage.AGGREGATION_RULE__AGGREGATION:
        return aggregation != AGGREGATION_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (aggregation: ");
    result.append(aggregation);
    result.append(')');
    return result.toString();
  }

} //AggregationRuleImpl
