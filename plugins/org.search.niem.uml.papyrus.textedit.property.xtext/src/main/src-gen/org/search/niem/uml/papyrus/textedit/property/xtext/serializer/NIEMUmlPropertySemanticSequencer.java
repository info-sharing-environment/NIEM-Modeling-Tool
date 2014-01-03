package org.search.niem.uml.papyrus.textedit.property.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.property.xtext.serializer.UmlPropertySemanticSequencer;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.QualifiedName;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.AggregationRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.NiemUmlPropertyPackage;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.services.NIEMUmlPropertyGrammarAccess;

@SuppressWarnings("all")
public class NIEMUmlPropertySemanticSequencer extends UmlPropertySemanticSequencer {

	@Inject
	private NIEMUmlPropertyGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == NiemUmlPropertyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case NiemUmlPropertyPackage.AGGREGATION_RULE:
				if(context == grammarAccess.getAggregationRuleRule()) {
					sequence_AggregationRule(context, (AggregationRule) semanticObject); 
					return; 
				}
				else break;
			case NiemUmlPropertyPackage.PROPERTY_RULE:
				if(context == grammarAccess.getPropertyRuleRule()) {
					sequence_PropertyRule(context, (PropertyRule) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == UmlPropertyPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlPropertyPackage.BOUND_SPECIFICATION:
				if(context == grammarAccess.getBoundSpecificationRule()) {
					sequence_BoundSpecification(context, (BoundSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.DEFAULT_VALUE_RULE:
				if(context == grammarAccess.getDefaultValueRuleRule()) {
					sequence_DefaultValueRule(context, (DefaultValueRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MODIFIER_SPECIFICATION:
				if(context == grammarAccess.getModifierSpecificationRule()) {
					sequence_ModifierSpecification(context, (ModifierSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MODIFIERS_RULE:
				if(context == grammarAccess.getModifiersRuleRule()) {
					sequence_ModifiersRule(context, (ModifiersRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.MULTIPLICITY_RULE:
				if(context == grammarAccess.getMultiplicityRuleRule()) {
					sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.REDEFINES_RULE:
				if(context == grammarAccess.getRedefinesRuleRule()) {
					sequence_RedefinesRule(context, (RedefinesRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.SUBSETS_RULE:
				if(context == grammarAccess.getSubsetsRuleRule()) {
					sequence_SubsetsRule(context, (SubsetsRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPropertyPackage.TYPE_RULE:
				if(context == grammarAccess.getTypeRuleRule()) {
					sequence_TypeRule(context, (TypeRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     aggregation=AggregationKind
	 */
	protected void sequence_AggregationRule(EObject context, AggregationRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NiemUmlPropertyPackage.Literals.AGGREGATION_RULE__AGGREGATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NiemUmlPropertyPackage.Literals.AGGREGATION_RULE__AGGREGATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAggregationRuleAccess().getAggregationAggregationKindEnumRuleCall_1_0(), semanticObject.getAggregation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         visibility=VisibilityKind 
	 *         isDerived='/'? 
	 *         name=ID 
	 *         type=TypeRule? 
	 *         multiplicity=MultiplicityRule? 
	 *         modifiers=ModifiersRule? 
	 *         aggregation=AggregationRule? 
	 *         default=DefaultValueRule?
	 *     )
	 */
	protected void sequence_PropertyRule(EObject context, PropertyRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
