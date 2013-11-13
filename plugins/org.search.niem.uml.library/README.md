org.search.niem.uml.library
========================================================================

In order to use the NIEM-Reference schemas, the XMI files had to be modified as follows:
* Adding XMI type attributes
 - s/<type$/<type xmi:type="uml:Type"/
 - s/<supplier$/<supplier xmi:type="uml:NamedElement"/
  - For XmiPrimitiveTypes, the supplier must be xmi:type="uml:PrimitiveType" (e.g., see NIEM-Reference-common-lasd)
 - s/<general$/<general xmi:type="uml:Classifier"/
* Replacing headers so stereotype applications are resolved correctly
 - substituting <xmi:XMI xmlns:xmi="http://www.omg.org/spec/XMI/20110701"> with <xmi:XMI xmlns:xmi="http://www.omg.org/spec/XMI/20110701" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.omg.org/spec/NIEM-UML/20120501/NIEM_Common_Profile pathmap://NIEM_UML/NIEM-UML-Profile.xmi#NIEM_UML_Profile-NIEM_Common_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/Model_Package_Description_Profile pathmap://NIEM_UML/NIEM-UML-Profile.xmi#NIEM_UML_Profile-Model_Package_Description_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PIM_Profile pathmap://NIEM_UML/NIEM-UML-Profile.xmi#NIEM_UML_Profile-NIEM_PIM_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PSM_Profile pathmap://NIEM_UML/NIEM-UML-Profile.xmi#NIEM_UML_Profile-NIEM_PSM_Profile-ePackage">
* Changing NIEM-Reference file extensions to UML rather than XMI because of QVT limitation
* Updating internal cross-references to NIEM-Reference .xmi files
 - Replacing href="(.*)NIEM-Reference\-(.*)\.xmi with href="$1NIEM-Reference-$2.uml
* Updating NIEM-Reference file headers to use the xsi:schemaLocation "http://www.omg.org/spec/UML/20110701 http://www.eclipse.org/uml2/4.0.0/UML"
* In order to get cross-references to resolve correctly, the following changes had to be made:
 - All hrefs to NIEM Reference files must be relative (they are all in the same folder anyway)
 - All xmi:type references must be made specific (xmi:type="Type", xmi:type="NamedElement" and xmi:type="Classifier" must be changed to use the real subtype of the referenced elements, which is non-trivial since not every name follows a strict convention that can easily be mapped using a regular expression)
