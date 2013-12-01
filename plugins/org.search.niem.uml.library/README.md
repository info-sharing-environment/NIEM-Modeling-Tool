org.search.niem.uml.library
========================================================================

In order to use the NIEM-Reference schemas, the XMI files had to be modified as follows:
* Changing file extension from .xmi to .uml
* Adding XMI type attributes
 - s/<type href/<type xmi:type="uml:Type" href/
 - s/<supplier href/<supplier xmi:type="uml:NamedElement" href/
 - s/<general href/<general xmi:type="uml:Classifier" href/
* In order to get cross-references to resolve correctly the substituted cross-referenced xmi:types for UML types, suppliers and generals must be set correctly:
 - All xmi:type references must be made specific (xmi:type="Type", xmi:type="NamedElement" and xmi:type="Classifier" must be changed to use the real subtype of the referenced elements, which is non-trivial since not every name follows a strict convention that can easily be mapped using a regular expression)
* Replacing headers so stereotype applications are resolved correctly
 - substituting <xmi:XMI xmlns:xmi="http://www.omg.org/spec/XMI/20110701"> with <xmi:XMI xmlns:xmi="http://www.omg.org/spec/XMI/20110701" xsi:schemaLocation="http://www.omg.org/spec/UML/20110701 http://www.eclipse.org/uml2/4.0.0/UML http://www.omg.org/spec/NIEM-UML/20120501/NIEM_Common_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_Common_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/Model_Package_Description_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-Model_Package_Description_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PIM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PIM_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PSM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PSM_Profile-ePackage">
