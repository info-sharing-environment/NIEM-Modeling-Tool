org.search.niem.uml.qvt
========================================================================

In order to get the QVTO files to compile, you must Export -> Deployable plugins and fragments -> org.search.niem.uml.qvt into your Eclipse host in order for the org.search.niem.NiemQvt Java blackbox extensions to be recognized.
Then you must configure the project Properties -> QVT Settings -> Metamodel Mappings with this Target Model URI: platform:/resource/org.search.niem.mpd/src/main/resources/model/mpd-catalog-1.0.ecore
Then you should add the following to the .project file


<code lang="xml">
<?xml version="1.0" encoding="UTF-8"?>
&lt;projectDescription&gt;
	....
	&lt;buildSpec&gt;
		....
		&lt;buildCommand&gt;
			&lt;name&gt;org.eclipse.m2m.qvt.oml.project.QVTOBuilder&lt;/name&gt;
			&lt;arguments&gt;
				&lt;dictionary&gt;
					&lt;key&gt;src_container&lt;/key&gt;
					&lt;value&gt;src/main/qvt&lt;/value&gt;
				&lt;/dictionary&gt;
			&lt;/arguments&gt;
		&lt;/buildCommand&gt;
	&lt;/buildSpec&gt;
	&lt;natures&gt;
		....
		&lt;nature&gt;org.eclipse.m2m.qvt.oml.project.QVTONature&lt;/nature&gt;
	&lt;/natures&gt;
&lt;/projectDescription&gt;
</code>




* Needed to change getNearesProfileApplication in NIEMpsm2xsd.qvto from
query UML::Package::getNearesProfileApplication(profile:UML::Profile):UML::Package=
	if(self.isProfileApplied(profile))then self else self.owner.getNearestPackage().getNearesProfileApplication(profile) endif;
to
query UML::Package::getNearesProfileApplication(profile:UML::Profile):UML::Package {
	if(self.isProfileApplied(profile))then{
	   return self;
	}endif;
	if(self.owner.oclIsUndefined()) then{
		return null;
	}endif;
	return self.owner.getNearestPackage().getNearesProfileApplication(profile);
}

* Needed to change XSDModelGroupDefinition_Property mapping in NIEMpsm2xsd.qvto from
mapping UML::Property::XSDModelGroupDefinition_Property(inout xsdContainer:XSD::XSDConcreteComponent):XSD::XSDModelGroupDefinition@xsd
	when{self.type.getNearestPackage().isModelGroupDefinitions()}
to
mapping UML::Property::XSDModelGroupDefinition_Property(inout xsdContainer:XSD::XSDConcreteComponent):XSD::XSDModelGroupDefinition@xsd
	when{not(self.type.oclIsUndefined()) and self.type.getNearestPackage().isModelGroupDefinitions()}

* Needed to change XSDParticle mapping in NIEMpsm2xsd.qvto from
mapping UML::Property::XSDParticle(inout xsdContainer:XSD::XSDConcreteComponent):XSD::XSDParticle@xsd 
	when{
		self.isElementReference()
		or self.type.getNearestPackage().isModelGroupDefinitions()
		or self.IsStereotypeApplied(NIEMAnyPropertyStereotype)
		or self.type.isChoiceModelGroup()
		or self.type.isAnonymousModelGroup()
		}
to
mapping UML::Property::XSDParticle(inout xsdContainer:XSD::XSDConcreteComponent):XSD::XSDParticle@xsd 
	when{
		self.isElementReference()
        or self.IsStereotypeApplied(NIEMAnyPropertyStereotype)
        or(not(self.type.oclIsUndefined()) 
            and (self.type.getNearestPackage().isModelGroupDefinitions()
		      or self.type.isChoiceModelGroup()
		      or self.type.isAnonymousModelGroup()))
		}

* Needed to change the prefixToNamespace Tuple in NIEMpsm2xsd.qvto from
        Tuple{prefix:String="edxl-cap",namespace:String="http://niem.gov/niem/edxl/2.1"}
  to
        Tuple{prefix:String="edxl-cap",namespace:String="http://niem.gov/niem/edxl-cap/2.1"}

* Needed to add the following namespace tuples to NIEMpsm2xsd.qvto

        Tuple{prefix:String="ct",namespace:String="urn:oasis:names:tc:ciq:ct:3"}
        Tuple{prefix:String="geo-oasis",namespace:String="urn:oasis:names:tc:emergency:EDXL:HAVE:1.0:geo-oasis"}
        Tuple{prefix:String="have-gml",namespace:String="http://www.opengis.net/gml"}
        Tuple{prefix:String="xal",namespace:String="urn:oasis:names:tc:ciq:xal:3"}
        Tuple{prefix:String="xlink1",namespace:String="http://www.w3.org/1999/xlink1"}
        Tuple{prefix:String="xnl",namespace:String="urn:oasis:names:tc:ciq:xnl:3"}
        Tuple{prefix:String="xpil",namespace:String="urn:oasis:names:tc:ciq:xpil:3"}
        
* Needed to change the way the XSDImport namespace was resolved (or rather NOT properly resolved) in the mappings in NIEMpsm2xsd.qvto 
**  from
            var importSchema:XSD::XSDSchema=xsdImport.resolvedSchema;
            var importNamespace:String=importSchema.targetNamespace;
    to
            var pimStereotypeInstance:Stdlib::Element=self.GetStereotypeApplication(NIEMSchemaStereotype).oclAsType(Stdlib::Element);
            var importNamespace:String=pimStereotypeInstance.getSchemaTargetNamespace();
**  from
            var importNamespace:String=result.resolvedSchema.targetNamespace;
    to
            var pimStereotypeInstance:Stdlib::Element=self.GetStereotypeApplication(NIEMSchemaStereotype).oclAsType(Stdlib::Element);
            var importNamespace:String=pimStereotypeInstance.getSchemaTargetNamespace();
            
**  from
            var schemaDirective:XSD::XSDSchemaDirective=result;
            var referencedSchema:String=schemaDirective.resolvedSchema.schemaLocation;
    to
            // This will not work if mapping UML::PackageImport::XSDInclude is activated
            var schemaDirective:XSD::XSDSchemaDirective=result;
            var referencedSchemaLocation:String=self.getNearestNIEMSchemaPackage().map AbstractXSDSchema().schemaLocation;
            var referencedSchema:String=referencedSchemaLocation.startsWithXmlSchemasFolder();

* In NIEMpsm2xsd.qvto, in order to support sibling schemas, needed to add a helper function startsWithXmlSchemasFolder
** Updated mapping  UML::Element::XSDSchemaDirective to use it
** Updated mapping  XSD::XSDSchema::XSDImport_infrastructure to use it
        
* Because of bug in substitution group serialization, needed to change XSDElementDeclaration_topLevel mapping in NIEMpsm2xsd.qvto from
        self.subsettedProperty.toPsmTopLevelElement()->forEach(targetSubsettedProperty){
            substitutionGroupAffiliation:=targetSubsettedProperty;
            // also set the appinfoBase of the element
            result.appInfoBase(targetSubsettedProperty);
            
        };
    to
        self.subsettedProperty->forEach(subsettedProperty){
            var targetSubsettedProperty:XSD::XSDElementDeclaration;
            if(subsettedProperty.referencesTopLevel()) then {
                targetSubsettedProperty:=subsettedProperty.referencesTopLevelProperty().toPsmTopLevelElement();
            } else {
                targetSubsettedProperty:=subsettedProperty.toPsmTopLevelElement();
            } endif;
            
            substitutionGroupAffiliation:=targetSubsettedProperty;
            // also set the appinfoBase of the element
            result.appInfoBase(targetSubsettedProperty);
        };
* Because the MPD Catalog XML would not validate, changed the following in NIEMmpdmodel2artifact.qvto:
** Changed the line in mapping UML::Component  ::ModelPackageDescription():CAT::CatalogType from 
        //TODO   md.creationDate:=self.getAnyValue(artifactStereotype,'CreationDate').oclAsType(XSD::Date);
        //pimmpd.getMpdCreationDate()
    to
        md.setCreationDate(pimmpd.getMpdCreationDate());
** Changed the line in mapping UML::Usage::ModelPackageDescriptionFile(inout catalog:CAT::CatalogType):CAT::FileType from
        id:=self.getFileId();
    to
        id:='File'+self.getFileId();
** Needed to add this line to mapping UML::Component    ::ModelPackageDescription():CAT::CatalogType
        result.setMpdClassCode(pimmpd.getMpdPackageCode());
* Because of a bug where complex types of simple content (e.g., nc:TextType) are not being emitted properly as XSDs, changed the following in NIEMpsm2xsd.qvto:
        query UML::Classifier::isPsmComplexTypeContentSimpleTypeDefinition():Boolean=
            self.simpleContent()
                ->select(c|
                    c.oclIsKindOf(UML::DataType)and(
                        (c.isXmlPrimitive() and c.getUmlProxySchemaType().oclIsUndefined())
                        or not(c.isXmlPrimitive())
                    )   
                    )->notEmpty();
    to
        query UML::Classifier::isPsmComplexTypeContentSimpleTypeDefinition():Boolean=
            self.simpleContent()
                ->select(c|
                    c.oclIsKindOf(UML::DataType)and(
                        (c.isXmlPrimitive() and not(c.getUmlProxySchemaType().oclIsUndefined()))
                        or not(c.isXmlPrimitive())
                    )   
                    )->notEmpty();
* Because of a bug where complex types of simple content (e.g., nc:TextType) are not being emitted properly as XSDs, changed the following in NIEMpsm2xsd.qvto:
        mapping UML::Classifier::NIEMComplexTypeContentSimpleTypeDefinition(inout psmOwner:XSD::XSDComplexTypeDefinition):XSD::XSDSimpleTypeDefinition@xsd
        //  inherits UML::Classifier::XSDTypeDefinition
            when{self.isPsmComplexTypeContentSimpleTypeDefinition()
                or self.inheritsPimSimpleTypeDefinition()
            }
        {
            init{}
            psmOwner.content:=result;   
            if(self.isPsmComplexTypeContentSimpleTypeDefinition())then{
               self.map NIEMSimpleObjectAttributeGroup(psmOwner);
            } endif;
        }
    to
        mapping UML::Classifier::NIEMComplexTypeContentSimpleTypeDefinition(inout psmOwner:XSD::XSDComplexTypeDefinition):XSD::XSDSimpleTypeDefinition@xsd
        //  inherits UML::Classifier::XSDTypeDefinition
            when{self.isPsmComplexTypeContentSimpleTypeDefinition()
                or self.inheritsPimSimpleTypeDefinition()
            }
        {
            init{}
            psmOwner.content:=result;
            if(self.isPsmComplexTypeContentSimpleTypeDefinition() and not(self.simpleContent()->exists(c|c.isXmlPrimitive() and not(c.getUmlProxySchemaType().oclIsUndefined()))))then{
               self.map NIEMSimpleObjectAttributeGroup(psmOwner);
            } endif;
        }
* Because of a bug where complex types of simple content (e.g., nc:TextType) are not being emitted properly as XSDs, changed the following in NIEMpsm2xsd.qvto:
        mapping UML::Property::XSDProperty_AttributeUse_ref(inout classifier:XSD::XSDConcreteComponent):XSD::XSDAttributeUse@xsd
            inherits UML::Property::XSDProperty_AttributeUse
            when{self.isNiemAttribute() and self.referencesTopLevel()}
            {
            }
    to
        mapping UML::Property::XSDProperty_AttributeUse_ref(inout classifier:XSD::XSDConcreteComponent):XSD::XSDAttributeUse@xsd
            inherits UML::Property::XSDProperty_AttributeUse
            when{self.isNiemAttribute() and self.referencesTopLevel()}
            {
               content.resolvedAttributeDeclaration := self.referencesTopLevelProperty().toPsmTopLevelAttribute();
            }
* To fix a bug where Enumeration restriction bases were being set to xsd:anySimpleType, changed the following in the mapping UML::Enumeration::Enumeration in NIEMpsm2xsd.qvto:
            /*
        if(self.getGenerals()->isEmpty())then{
        // must lead to xsd token base
            umlSchemaForSchemaToken.mapBaseTypeDefinition(result);
        }endif;
        */
    to
        if(self.getGenerals()->isEmpty())then{
        // must lead to xsd token base
            baseTypeDefinition := umlSchemaForSchemaToken;
        }endif;
* In order to support FileSet types, needed to make the following changes:
** In the NIEMpim2psm.qvto, changed the mapping String::MpdFileSetType from
        mapping String::MpdFileSetType(inout mpdModel:UML::Component,fileTypes:Set(UML::Usage)):UML::Component@niemUml{
            mpdModel.packagedElement+=result;
            fileTypes->forEach(fileType){
                var elementImport:UML::ElementImport=new UML::ElementImport@niemUml();
                elementImport.importingNamespace:=result;
                elementImport.importedElement:=fileType;
                };
            var stereotypeInstance:Stdlib::Element=result.ApplyStereotype(NIEMModelPackageDescriptionFileSetStereotype);
            stereotypeInstance.setFileSetTypeNatureURI(natureFilesetURI);
            stereotypeInstance.setFileSetTypePurposeURI(self);
        }
    to
        mapping String::MpdFileSetType(inout mpdModel:UML::Component,fileTypes:Set(UML::Usage)):UML::Component@niemUml{
            mpdModel.packagedElement+=result;
            fileTypes->forEach(fileType){
                var elementImport:UML::ElementImport=new UML::ElementImport@niemUml();
                elementImport.importingNamespace:=result;
                elementImport.importedElement:=fileType;
                fileType.client+=result;
                fileType.client:=fileType.client->excluding(mpdModel);
                result.packagedElement+=fileType;
                };
            var stereotypeInstance:Stdlib::Element=result.ApplyStereotype(NIEMModelPackageDescriptionFileSetStereotype);
            stereotypeInstance.setFileSetTypeNatureURI(natureFilesetURI);
            stereotypeInstance.setFileSetTypePurposeURI(self);
        }
** In the NIEMpsm2xsd.qvto, added a new query to get nested FileSets from the mpd:
        query UML::Component::withAllFileSets():Set(UML::Component) {
            var allFileSets:Bag(UML::Component)=self.allSubobjectsOfType(UML::Component).oclAsType(UML::Component)
                ->select(i|i.IsStereotypeApplied(NIEMModelPackageDescriptionFileSetStereotype));
            allFileSets+=self;
            return allFileSets->asSet();
        }
** In the NIEMpsm2xsd.qvto, using this new query in the getSchemaImports() and the getTopNiemFolders() queries.
*** Changed getSchemaImports from
        query getSchemaImports():Set(UML::Usage)=
            mpdComponent.clientDependency
            ->select(i|i.IsStereotypeApplied(NIEMModelPackageDescriptionFileStereotype))
            .oclAsType(UML::Usage)->asSet();
to
        query getSchemaImports():Set(UML::Usage)=
            mpdComponent.withAllFileSets().clientDependency
            ->select(i|i.IsStereotypeApplied(NIEMModelPackageDescriptionFileStereotype))
            .oclAsType(UML::Usage)->asSet();
*** Changed getTopNiemFolders from
        query UML::Component::getTopNiemFolders():Set(UML::Package)=
            self.elementImport.importedElement.oclAsType(UML::NamedElement)->asSet()
            ->union(self.clientDependency.supplier->asSet())
                ->select(e|e.oclIsKindOf(UML::Package))
                .oclAsType(UML::Package)
                .getNearesProfileApplication(structureProfile)->asSet();
    to
        query UML::Component::getTopNiemFolders():Set(UML::Package) {
            var allFileSets:Set(UML::Component)=self.withAllFileSets();
            allFileSets.elementImport.importedElement.oclAsType(UML::NamedElement)->asSet()
                ->union(allFileSets.clientDependency.supplier->asSet())
                ->select(e|e.oclIsKindOf(UML::Package)).oclAsType(UML::Package)
                .getNearesProfileApplication(structureProfile)->asSet();
        }
** In the NIEMmpdmodel2artifact.qvto, modified how the file ids are generated so that they are unique within FileSet elements.
** Added new properties to NIEMglobals.qvto to support natureURIs and purposeURIs inside filesets: baseMPDNamespace, purposeSetMemberURI, natureSubsetSchemaURI, natureExtensionSchemaURI, natureExchangeSchemaURI
** In the NIEMmpdmodel2artifact.qvto, modified the UML::Usage::ModelPackageDescriptionFile(inout fileSet:CAT::FileSetType):CAT::FileType mapping to set the natureURI and purposeURI based on whether the defaultPurpose is subset, exchange or extension.

* Needed to add a configuration property for the XMLschemas folder in the NIEMpsm2xsd.qvto in order to make its name configurable.

* Added a way to set the relativePathName for an MPD and to set this property in the NIEMmpdartifact2model.qvto:
** Put the line "pimNdrSchemaInstance.setFileTypeRelativePathName(self.relativePathName);" in the mapping CAT::FileType::FileType(inout pimPackage:UML::NamedElement,inout pimComponent:UML::Component):UML::Usage@pimUml
* Needed to add a new query in the NIEMpim2psm.qvto called substringWithDefault to handle cases where substring was being called on a string and the result returned was oclUndefined; e.g., when toUnassociationName is called on 'AssociationType'. This problem exists in the queries toUntypedName, toUnaugmentationName, toUnmetadataName, toUnadapterName, toUnassociationName, toUnsimpleName, toUncodeName and toUncodesimpleName
* Needed to change the adjustPropertyHolders helper function in the NIEMmpdartifact2model.qvto so that if an owned attributes of a PropertyHolder is not a source property, then it is removed from the PropertyHolder and if any property holders end up empty, then they are removed as well.
* Needed to move the toRelativePathName() query from the NIEMmpdmodel2artifact.qvto to the NIEMplatformBinding.qvto so that it can be used by the NIEMpim2psm.qvto. The mapping UML::Package::NIEMNamespace and mapping UML::ElementImport::ModelPackageDescriptionFile in the NIEMpim2psm.qvto have been changed to set the relativePathName on the NIEMModelPackageDescriptionFileStereotype of UML Usages in the generated PSM because of error markers appearing in the problems view.
* Since users can now add PropertyHolders to NIEM library subset, we need to make sure the comments for elements declared within classes get propagated up.
** In the NIEMpim2psm.qvto, modified the function helper  UML::Property::resolvePIMPropertyReference(psmContext:UML::Property,domainContext:UML::Package):UML::Property with a new else block:
        if(referencedPSMTopLevelProperty.oclIsUndefined()) then {
            // no such property, need to create one
            referencedPSMTopLevelProperty:=self.makeTopLevelPSMProperty(psmContext,domainContext);
        }
        else {
            if(referencedPSMTopLevelProperty.ownedComment->isEmpty() and psmContext.ownedComment->notEmpty()) then {
                // top-level property needs documentation
                psmContext.ownedComment.body->forEach(body){
                    var comment:UML::Comment=new UML::Comment@niemUml(); 
                    referencedPSMTopLevelProperty.ownedComment+=comment;
                    comment.annotatedElement+=referencedPSMTopLevelProperty;
                    comment.body:=body;
                    comment.ApplyStereotype(NIEMDescriptionStereotype);
                }
            } endif;
        }
        endif;
* In order to support substitutionGroups across namespaces, in the NIEMpsm2xsd.qvto, modified the mapping UML::Package::Namespace():XSD::XSDSchema@xsd inherits UML::Package::XSDSchema when{self.IsStereotypeApplied(NIEMSchemaStereotype)} with the following change from
        // gather all references to schema components via typedElements, generalizations, dependencies;
        // collect the schemas for those schema components in packageRefs
        var packageRefs:Set(UML::Package)=Set{};
        self.allSubobjectsOfKind(UML::Property).oclAsType(UML::Property)
            ->select(p|not(p.type.oclIsUndefined())).type->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
        self.allSubobjectsOfKind(UML::Classifier).oclAsType(UML::Classifier).general
            ->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
        self.allSubobjectsOfKind(UML::DirectedRelationship).oclAsType(UML::DirectedRelationship).target
            ->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
  to
        // gather all references to schema components via typedElements, generalizations, dependencies and subsetted properties;
        // collect the schemas for those schema components in packageRefs
        var packageRefs:Set(UML::Package)=Set{};
        self.allSubobjectsOfKind(UML::Property).oclAsType(UML::Property)
            ->select(p|not(p.type.oclIsUndefined())).type->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
        self.allSubobjectsOfKind(UML::Classifier).oclAsType(UML::Classifier).general
            ->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
        self.allSubobjectsOfKind(UML::DirectedRelationship).oclAsType(UML::DirectedRelationship).target
            ->forEach(type){packageRefs+=type.getNearestNIEMSchemaPackage();};
        self.allSubobjectsOfKind(UML::Property).oclAsType(UML::Property).subsettedProperty
            ->forEach(p){packageRefs+=p.getNearestNIEMSchemaPackage();};

* Needed to change NIEMplatformBinding.qvto query UML::Element::getNearestNIEMSchemaPackage():UML::Package{ to check for NIEMInformationModelStereotype application as well as NIEMSchemaStereotype application

* Changed references from "isStereotypeApplied" to "IsStereotypeApplied" for consistency

* In order to fix a problem where the NIEMpsm2xsd.qvto transformation produces an appinfo:Base of structures:Object when the base type is in the NIEM proxy schema when it should be producing an appinfo:Base with a target namespace of "http://niem.gov/niem/proxy/xsd/2.0", changed the else clause in the NIEMpsm2xsd.qvto mapping UML::Class::ObjectType_datatypeSimpleContent from
        }else{          
            derivationMethod:=XSD::XSDDerivationMethod::extension;
            var baseType:XSD::XSDTypeDefinition=general.toPsmClassifier();
            baseType.mapBaseTypeDefinition(result);
        }endif;
  to
         
        }else{          
            derivationMethod:=XSD::XSDDerivationMethod::extension;
            var baseType:XSD::XSDTypeDefinition=general.toPsmClassifier();
            baseType.mapBaseTypeDefinition(result);
            // base proxy issue: if base is in proxy schema, set appinfo:Base to the proxy type (instead of structures:Object)
            var proxyClassifier:XSD::XSDTypeDefinition=general.getUmlProxySchemaType();
            if(not(proxyClassifier.oclIsUndefined()))then{result.appInfoBase(proxyClassifier);}endif;
        }endif;

* In the NIEMmpdartifact2model.qvto, the documentRoot property was not being set properly, even though it is referenced in the expandURI query function.

* In the NIEMmpdartifact2model.qvto, calls to the setModelInformationDefaultPurpose helper function now pass the fileTypeNatureURI rather than the fileTypePurposeURI.

* In the NIEMmpdartifact2model.qvto, the FileType mapping sets the MPD FileType PurposeCode for UML::Usages based on the Catalog FileType natureURI attribute rather than the purposeURI if the UML::Usage refers to an InformationModel.

* In the NIEMpim2psm.qvto, added a collectMpdFiles helper function that looks for all UML::Usages in a Component or its sub-components that are stereotyped as MPD Files so that they can be mapped correctly from a PIM to a PSM.
