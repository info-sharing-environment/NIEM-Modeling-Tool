How To Build the NIEM Modeling Tool from Source
================================================

0. Install the latest versions of maven and git
1. git clone https://github.com/info-sharing-environment/NIEM-Modeling-Tool.git
2. cd NIEM-Modeling-Tool
3. Set your MAVEN_OPTS to "-Xms512m -Xmx1024m -XX:MaxPermSize=128m"
4. mvn clean verify

How To Import The NIEM Modeling Tool Into Eclipse
=================================================

0. Make sure that the eclipse.ini file in the root of your eclipse installation has the following settings:
    -vmargs
    -Xms512m
    -Xmx1024m

1. Add the following update sites through the update site manager:
    http://download.eclipse.org/modeling/mdt/papyrus/updates/releases/kepler/
    http://download.eclipse.org/epsilon/updates/
    http://download.eclipse.org/tools/orbit/downloads/drops/R20140114142710/repository/

2. Select "--All Available Sites--" from the "Work with:" dropdown and install the following features:
    + Collaboration
     - Eclipse Git Team Provider
     - m2e - Maven Integration for Eclipse
    + Eclipse Java Development Tools
     - Eclipse Java Development Tools
    + Eclipse Plug-in Development Tools
     - Eclipse Plug-in Development Environment
    + Epsilon Core
     - Epsilon Core
    + Epsilon Core Development Tools
     - Epsilon Core Development Tools
    + Epsilon EMF Integration
     - Epsilon Validation Language EMF Integration
     - Epsilon Wizard Language EMF Integration
    + Epsilon UML Integration
     - Epsilon UML Integration
    + Modeling
     - EMF - Eclipse Modeling Framework SDK
     - EMF Model Transaction SDK
     - EMF Validation Framework SDK
     - Graphical Modeling Framework (GMF) Notation SDK
     - Graphical Modeling Framework (GMF) Runtime SDK
     - Graphical Modeling Framework (GMF) Tooling SDK
     - OCL End User SDK
     - Papyrus UML
     - QVT Operational SDK
     - UML2 Extender SDK
     - XSD - XML Schema Definition SDK
     - Xtext SDK
    + Orbit Bundles By Name: com.google.*
     - Guava (the first one)
    + Orbit Bundles By Name: org.apache.*
     - Apache Commons IO
    + Programming Languages
     - Eclipse XML Editors and Tools
     
3. Import -> Maven -> Existing Maven Project from the root NIEM-Modeling-Tool directory
    There may be one red X for the maven-clean-plugin that can be resolved later from a quick-fix in the Problems View
    
4. Follow the directions in the README.md files in the org.search.niem.uml.papyrus.textedit.property.xtext and org.search.niem.uml.papyrus.textedit.property.xtext.ui projects for adding Xtext builders and project natures to the corresponding .project files in those projects. 
    

     
