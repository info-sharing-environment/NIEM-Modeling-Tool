/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl.PropertyRuleImpl#getAggregation <em>Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyRuleImpl extends org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl implements PropertyRule
{
  /**
   * The cached value of the '{@link #getAggregation() <em>Aggregation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggregation()
   * @generated
   * @ordered
   */
  protected AggregationRule aggregation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyRuleImpl()
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
    return NiemUmlPropertyPackage.Literals.PROPERTY_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregationRule getAggregation()
  {
    return aggregation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAggregation(AggregationRule newAggregation, NotificationChain msgs)
  {
    AggregationRule oldAggregation = aggregation;
    aggregation = newAggregation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION, oldAggregation, newAggregation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggregation(AggregationRule newAggregation)
  {
    if (newAggregation != aggregation)
    {
      NotificationChain msgs = null;
      if (aggregation != null)
        msgs = ((InternalEObject)aggregation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION, null, msgs);
      if (newAggregation != null)
        msgs = ((InternalEObject)newAggregation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION, null, msgs);
      msgs = basicSetAggregation(newAggregation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION, newAggregation, newAggregation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION:
        return basicSetAggregation(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION:
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
      case NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION:
        setAggregation((AggregationRule)newValue);
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
      case NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION:
        setAggregation((AggregationRule)null);
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
      case NiemUmlPropertyPackage.PROPERTY_RULE__AGGREGATION:
        return aggregation != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyRuleImpl
