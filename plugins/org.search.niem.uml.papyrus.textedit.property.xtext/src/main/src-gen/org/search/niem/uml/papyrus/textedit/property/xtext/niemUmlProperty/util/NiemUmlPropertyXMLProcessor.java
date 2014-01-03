/**
 */
package org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NiemUmlPropertyXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NiemUmlPropertyXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    NiemUmlPropertyPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the NiemUmlPropertyResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new NiemUmlPropertyResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new NiemUmlPropertyResourceFactoryImpl());
    }
    return registrations;
  }

} //NiemUmlPropertyXMLProcessor
