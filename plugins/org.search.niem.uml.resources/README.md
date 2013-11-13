org.search.niem.uml.resources
========================================================================

In order to get the NIEM-Reference library files to work in eclipse the following modifications had to be made:
* Add xmi:type="uml:Property" to the 2 constrainedElements in the NIEM-UML-Profile.xmi where the attributes were missing
* Remove "private" modifier from Restriction, NIEMType and Application stereotypes in NIEM Common Profiles (because the base type cannot be resolved for extending stereotypes and you will see the message "impossible to retrieve the stereotype <qualified name>" in the logs)
* Added Ecore profile definitions
* In the NIEM-UML-Profile.xmi, removed escaped quotes from default values, e.g., &quot;##any&quot; is now ##any, &quot;1&quot; is now 1 and &quot;strict&quot; is now strict
* In the NIEM-UML-Profile.xmi, changed references from 'http://reference.niem.gov/niem/resource/mpd/lexicon/1.0' to 'http://reference.niem.gov/niem/resource/mpd/lexicon/1.1'
