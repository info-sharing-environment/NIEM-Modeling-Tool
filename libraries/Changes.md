Differences between NIEM\_UML\_1.0\_Beta1 and NIEM\_UML\_1.0\_Final
----------------------------------------------------

### NIEMglobals.qvto (Minor) ###
 * \- comments
 * \+ 2 properties 

### NIEMmpdartifact2model.qvto (Minor) ###
 * \- comments, import schema
 * \+ default version, appinfo2 namespace
 * Δ 2 surrounding ifs, lower bound
 
### NIEMmpdartifact2model.qvto (Minor) ###
 * \- comments
 * \+ CMOF model type, explicitRelativePathName
 * Δ UML model type

### NIEMpim2psm.qvto (Major) ###
 * \- comments, log statements
 * \+ gatherAllPimSchemas, mapMpdFolderType helper, constraintMode, suppressPsmSchemaTypeMap, AttributeGroupDefinitions mapping, changelog information, constraintSchemas, applyAdditionalProfiles, isNIEMConformant check, mapping of ordered properties, isRestricted guard, many more
 * Δ generalized a few type declarations, mapping order of pim schemas, NIEMSimpleType_primitive mapping order, supplier resolution for UML Realizations, use of BaseNiemName, default purposeCode from exchange to extension, complex type with simple content mapping, how type names are determined, NIEMRoleOf_generalization, many more

### NIEMplatformBinding.qvto (Medium) ###
 * \- comments
 * \+ getNearestNIEMSchemaPackage, getSchemaTargetNamespace, getFileTypeNatureCode (must be implemented), getFileSetTypeNatureCode (must be implemented), getSchemaDefaultPrefix (must be implemented), getFileTypeRelativePathName (must be implemented), getBaseNiemName (must be implemented), changelog (must be implemented), getPimConstraintModels (must be implemented), getSupplierDependency (must be implemented), more new queries implemented at the end
  
### NIEMpsm2xsd.qvto (Major) ###
 * \- comments, log statements
 * \+ umlSchemaForSchemaAnyType, StructuresSequenceID, ValueRestrictionCSC mapping, XSDProperty_AttributeUse_attributeDeclaration_anonymousType mapping, attribute group definitions, NIEMList_init mapping, Union_init mapping, ValueRestrictionCSC mapping, many more
 * Δ reordered AbstractXSDRedefineContent mapping disjunctions, how the schema for schema is set, ObjectType_datatypeSimpleContent mapping, NIEMList mapping, Union mapping, NIEMComplexTypeContentSimpleTypeDefinition mapping, many more
  
  
  
### FILE (SEVERITY) ###
 * \- comments, log statements
 * \+ 
 * Δ 