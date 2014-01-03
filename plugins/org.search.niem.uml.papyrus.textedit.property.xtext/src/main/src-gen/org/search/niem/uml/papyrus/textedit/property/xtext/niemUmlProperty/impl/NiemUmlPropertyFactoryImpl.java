/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NiemUmlPropertyFactoryImpl extends EFactoryImpl implements NiemUmlPropertyFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NiemUmlPropertyFactory init()
  {
    try
    {
      NiemUmlPropertyFactory theNiemUmlPropertyFactory = (NiemUmlPropertyFactory)EPackage.Registry.INSTANCE.getEFactory(NiemUmlPropertyPackage.eNS_URI);
      if (theNiemUmlPropertyFactory != null)
      {
        return theNiemUmlPropertyFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new NiemUmlPropertyFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NiemUmlPropertyFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case NiemUmlPropertyPackage.PROPERTY_RULE: return createPropertyRule();
      case NiemUmlPropertyPackage.AGGREGATION_RULE: return createAggregationRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case NiemUmlPropertyPackage.AGGREGATION_KIND:
        return createAggregationKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case NiemUmlPropertyPackage.AGGREGATION_KIND:
        return convertAggregationKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyRule createPropertyRule()
  {
    PropertyRuleImpl propertyRule = new PropertyRuleImpl();
    return propertyRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregationRule createAggregationRule()
  {
    AggregationRuleImpl aggregationRule = new AggregationRuleImpl();
    return aggregationRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregationKind createAggregationKindFromString(EDataType eDataType, String initialValue)
  {
    AggregationKind result = AggregationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAggregationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NiemUmlPropertyPackage getNiemUmlPropertyPackage()
  {
    return (NiemUmlPropertyPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static NiemUmlPropertyPackage getPackage()
  {
    return NiemUmlPropertyPackage.eINSTANCE;
  }

} //NiemUmlPropertyFactoryImpl
