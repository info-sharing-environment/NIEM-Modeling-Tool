/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;

import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationKind;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyFactory;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NiemUmlPropertyPackageImpl extends EPackageImpl implements NiemUmlPropertyPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aggregationRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum aggregationKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private NiemUmlPropertyPackageImpl()
  {
    super(eNS_URI, NiemUmlPropertyFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link NiemUmlPropertyPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static NiemUmlPropertyPackage init()
  {
    if (isInited) return (NiemUmlPropertyPackage)EPackage.Registry.INSTANCE.getEPackage(NiemUmlPropertyPackage.eNS_URI);

    // Obtain or create and register package
    NiemUmlPropertyPackageImpl theNiemUmlPropertyPackage = (NiemUmlPropertyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NiemUmlPropertyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NiemUmlPropertyPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    UmlPropertyPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theNiemUmlPropertyPackage.createPackageContents();

    // Initialize created meta-data
    theNiemUmlPropertyPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theNiemUmlPropertyPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(NiemUmlPropertyPackage.eNS_URI, theNiemUmlPropertyPackage);
    return theNiemUmlPropertyPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyRule()
  {
    return propertyRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyRule_Aggregation()
  {
    return (EReference)propertyRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAggregationRule()
  {
    return aggregationRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregationRule_Aggregation()
  {
    return (EAttribute)aggregationRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAggregationKind()
  {
    return aggregationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NiemUmlPropertyFactory getNiemUmlPropertyFactory()
  {
    return (NiemUmlPropertyFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    propertyRuleEClass = createEClass(PROPERTY_RULE);
    createEReference(propertyRuleEClass, PROPERTY_RULE__AGGREGATION);

    aggregationRuleEClass = createEClass(AGGREGATION_RULE);
    createEAttribute(aggregationRuleEClass, AGGREGATION_RULE__AGGREGATION);

    // Create enums
    aggregationKindEEnum = createEEnum(AGGREGATION_KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    UmlPropertyPackage theUmlPropertyPackage = (UmlPropertyPackage)EPackage.Registry.INSTANCE.getEPackage(UmlPropertyPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    propertyRuleEClass.getESuperTypes().add(theUmlPropertyPackage.getPropertyRule());

    // Initialize classes and features; add operations and parameters
    initEClass(propertyRuleEClass, PropertyRule.class, "PropertyRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyRule_Aggregation(), this.getAggregationRule(), null, "aggregation", null, 0, 1, PropertyRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aggregationRuleEClass, AggregationRule.class, "AggregationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAggregationRule_Aggregation(), this.getAggregationKind(), "aggregation", null, 0, 1, AggregationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(aggregationKindEEnum, AggregationKind.class, "AggregationKind");
    addEEnumLiteral(aggregationKindEEnum, AggregationKind.NONE);
    addEEnumLiteral(aggregationKindEEnum, AggregationKind.SHARED);
    addEEnumLiteral(aggregationKindEEnum, AggregationKind.COMPOSITE);

    // Create resource
    createResource(eNS_URI);
  }

} //NiemUmlPropertyPackageImpl
