org.search.niem.uml.resources
========================================================================

In order to get the NIEM-Reference library files to work in eclipse the following modifications had to be made:
* Add xmi:type="uml:Property" to the 2 constrainedElements in the NIEM-UML-Profile.xmi where the attributes were missing
* Remove "private" modifier from Restriction, NIEMType and Application stereotypes in NIEM Common Profiles (because the base type cannot be resolved for extending stereotypes and you will see the message "impossible to retrieve the stereotype <qualified name>" in the logs)
* Added Ecore profile definitions
* Change the generated EPackage xmi:ids from UUIDs to NIEM_UML_Profile-NIEM_Common_Profile-ePackage, NIEM_UML_Profile-Model_Package_Description_Profile-ePackage, NIEM_UML_Profile-NIEM_PSM_Profile-ePackage, NIEM_UML_Profile-NIEM_PIM_Profile-ePackage and NIEM_UML_Profile-NIEM_UML_Profile-ePackage
* Change the xmlns:cmof="http://schema.omg.org/spec/CMOF" to xmlns:cmof="http://www.omg.org/spec/MOF/20110701/cmof.xmi"
* In the NIEM-UML-Profile.xmi, removed escaped quotes from default values, e.g., &quot;##any&quot; is now ##any, &quot;1&quot; is now 1 and &quot;strict&quot; is now strict
* In the NIEM-UML-Profile.xmi, changed references from 'http://reference.niem.gov/niem/resource/mpd/lexicon/1.0' to 'http://reference.niem.gov/niem/resource/mpd/lexicon/1.1'
