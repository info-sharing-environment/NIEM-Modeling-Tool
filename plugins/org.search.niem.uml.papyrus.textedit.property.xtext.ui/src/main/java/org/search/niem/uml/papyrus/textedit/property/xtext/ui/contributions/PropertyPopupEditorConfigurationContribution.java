/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  SEARCH.ORG - Extended implementation
 *
 *****************************************************************************/
package org.search.niem.uml.papyrus.textedit.property.xtext.ui.contributions;

import static org.eclipse.papyrus.infra.gmfdiag.xtext.glue.contentassist.CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth;
import static org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil.getMultiplicityAsString;
import static org.eclipse.papyrus.uml.tools.utils.NamedElementUtil.getVisibilityAsSign;
import static org.eclipse.papyrus.uml.tools.utils.PropertyUtil.getDerived;
import static org.eclipse.papyrus.uml.tools.utils.PropertyUtil.getModifiersAsString;
import static org.eclipse.papyrus.uml.tools.utils.PropertyUtil.getName;
import static org.eclipse.papyrus.uml.tools.utils.TypeUtil.UNDEFINED_TYPE_NAME;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.validation.SemanticValidator;
import org.eclipse.papyrus.uml.textedit.property.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.search.niem.uml.papyrus.textedit.property.xtext.niemUmlProperty.PropertyRule;
import org.search.niem.uml.papyrus.textedit.property.xtext.ui.internal.NIEMUmlPropertyActivator;

import com.google.inject.Injector;

/**
 * Copied and extended from
 * {@link #org.eclipse.papyrus.uml.textedit.property.xtext.ui.contributions.PropertyPopupEditorConfigurationContribution()}
 * 
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration of
 *         an xtext generated editor, for properties of UML classifiers.
 * 
 * @author SEARCH.ORG
 */
public class PropertyPopupEditorConfigurationContribution extends PopupEditorConfiguration {

    private Property property;

    private boolean newIsDerived;

    private boolean newIsReadOnly;

    private boolean newIsUnique;

    private boolean newIsUnion;

    private boolean newIsOrdered;

    private int newLowerBound;

    private int newUpperBound;

    private String newDefault;

    private String newName;

    private Classifier newType;

    private VisibilityKind newVisibility;

    private AggregationKind newAggregation;

    private List<Property> newRedefines = new ArrayList<Property>();

    private List<Property> newSubsets = new ArrayList<Property>();

    /**
     * Default implementation of the constructor for this class
     */
    public PropertyPopupEditorConfigurationContribution() {
        super();
    }

    @Override
    public IPopupEditorHelper createPopupEditorHelper(final Object editPart) {

        // resolves the edit part, and the associated semantic element
        IGraphicalEditPart graphicalEditPart = null;
        if (!(editPart instanceof IGraphicalEditPart)) {
            return null;
        }
        graphicalEditPart = (IGraphicalEditPart) editPart;
        if (!(graphicalEditPart.resolveSemanticElement() instanceof Property)) {
            return null;
        }
        property = (Property) graphicalEditPart.resolveSemanticElement();

        UmlPropertyJavaValidator.init(property);

        // retrieves the XText injector
        final Injector injector = NIEMUmlPropertyActivator.getInstance().getInjector(
                "org.search.niem.uml.papyrus.textedit.property.xtext.NIEMUmlProperty");

        // builds the text content and extension for a temporary file, to be edited by the xtext editor
        final String textToEdit = getTextToEdit(graphicalEditPart.resolveSemanticElement());
        final String fileExtension = ".niemumlproperty";

        // builds a new IXtextEMFReconciler.
        // Its purpose is to extract any relevant information from the textual specification,
        // and then merge it in the context UML model if necessary
        final IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

            @Override
            public void reconcile(final EObject modelObject, final EObject xtextObject) {
                // first: retrieves / determines if the xtextObject is a PropertyRule object
                EObject modifiedObject = xtextObject;
                if (!(modelObject instanceof Property)) {
                    return;
                }
                while (xtextObject != null && !(xtextObject instanceof PropertyRule)) {
                    modifiedObject = modifiedObject.eContainer();
                }
                if (modifiedObject == null) {
                    return;
                }
                final PropertyRule propertyRuleObject = (PropertyRule) xtextObject;

                // Retrieves the information to be populated in modelObject
                newIsDerived = propertyRuleObject.getIsDerived() != null && propertyRuleObject.getIsDerived().equals("/");
                newIsReadOnly = false;
                newIsUnique = false;
                newIsUnion = false;
                newIsOrdered = false;
                newRedefines = new ArrayList<Property>();
                newSubsets = new ArrayList<Property>();
                if (propertyRuleObject.getModifiers() != null) {
                    for (final ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
                        if (modifier.getRedefines() == null && modifier.getSubsets() == null) {
                            switch (modifier.getValue()) {
                            case ORDERED:
                                newIsOrdered = true;
                                break;
                            case READ_ONLY:
                                newIsReadOnly = true;
                                break;
                            case UNION:
                                newIsUnion = true;
                                break;
                            case UNIQUE:
                                newIsUnique = true;
                                break;
                            default:
                                break;
                            }
                        }
                    }
                    for (final ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
                        if (modifier.getRedefines() != null) {
                            newRedefines.add(modifier.getRedefines().getProperty());
                        } else if (modifier.getSubsets() != null) {
                            newSubsets.add(modifier.getSubsets().getProperty());
                        }
                    }
                }
                newLowerBound = 1;
                newUpperBound = 1;
                if (propertyRuleObject.getMultiplicity() != null) {
                    if (propertyRuleObject.getMultiplicity().getBounds().size() == 1) {
                        final String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
                        if (tempBound.equals("*")) {
                            newLowerBound = 0;
                            newUpperBound = -1;
                        } else {
                            newLowerBound = new Integer(tempBound).intValue();
                            newUpperBound = new Integer(tempBound).intValue();
                        }
                    } else { // size == 2
                        String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
                        newLowerBound = new Integer(tempBound).intValue();
                        tempBound = propertyRuleObject.getMultiplicity().getBounds().get(1).getValue();
                        if (tempBound.equals("*")) {
                            newUpperBound = -1;
                        } else {
                            newUpperBound = new Integer(tempBound).intValue();
                        }
                    }
                }

                if (propertyRuleObject.getDefault() != null) {
                    newDefault = propertyRuleObject.getDefault().getDefault();
                } else {
                    newDefault = null;
                }

                newName = "" + propertyRuleObject.getName();

                final TypeRule typeRule = propertyRuleObject.getType();
                if (typeRule == null) {
                    newType = null;
                } else {
                    newType = typeRule.getType();
                }

                newVisibility = VisibilityKind.PUBLIC_LITERAL;

                switch (propertyRuleObject.getVisibility()) {
                case PUBLIC:
                    newVisibility = VisibilityKind.PUBLIC_LITERAL;
                    break;
                case PACKAGE:
                    newVisibility = VisibilityKind.PACKAGE_LITERAL;
                    break;
                case PRIVATE:
                    newVisibility = VisibilityKind.PRIVATE_LITERAL;
                    break;
                case PROTECTED:
                    newVisibility = VisibilityKind.PROTECTED_LITERAL;
                    break;
                default:
                    break;
                }

                newAggregation = AggregationKind.NONE_LITERAL;

                if (propertyRuleObject.getAggregation() != null) {
                    switch (propertyRuleObject.getAggregation().getAggregation()) {
                    case NONE:
                        newAggregation = AggregationKind.NONE_LITERAL;
                        break;
                    case SHARED:
                        newAggregation = AggregationKind.SHARED_LITERAL;
                        break;
                    case COMPOSITE:
                        newAggregation = AggregationKind.COMPOSITE_LITERAL;
                        break;
                    default:
                        break;
                    }
                }

                final org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = getUpdateCommand(property);
                final List<Property> editedObjects = new ArrayList<Property>();
                editedObjects.add(property);

                final TransactionalEditingDomain editingDomain = org.eclipse.emf.transaction.util.TransactionUtil
                        .getEditingDomain(property);

                if (updateCommand.canExecute()) {// && !(TransactionUtil.isReadTransactionInProgress(editingDomain, true,
                                                 // true))
                    editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));
                    return;
                }
            }
        };
        return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension,
                new SemanticValidator());
    }

    private CompositeCommand getUpdateCommand(final EObject editedObject) {
        final org.eclipse.gmf.runtime.common.core.command.CompositeCommand updateCommand = new CompositeCommand(
                "Property update");
        final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editedObject);

        final SetRequest setIsDerivedRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_IsDerived(),
                newIsDerived);
        final ICommand setIsDerivedCommand = provider.getEditCommand(setIsDerivedRequest);
        updateCommand.add(setIsDerivedCommand);

        final SetRequest setIsReadOnlyRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), newIsReadOnly);
        final ICommand setIsReadOnlyCommand = provider.getEditCommand(setIsReadOnlyRequest);
        updateCommand.add(setIsReadOnlyCommand);

        final SetRequest setIsUniqueRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), newIsUnique);
        final ICommand setIsUniqueCommand = provider.getEditCommand(setIsUniqueRequest);
        updateCommand.add(setIsUniqueCommand);

        final SetRequest setIsDerivedUnionRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), newIsUnion);
        final ICommand setIsDerivedUnionCommand = provider.getEditCommand(setIsDerivedUnionRequest);
        updateCommand.add(setIsDerivedUnionCommand);

        final SetRequest setIsOrderedRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), newIsOrdered);
        final ICommand setIsOrderedCommand = provider.getEditCommand(setIsOrderedRequest);
        updateCommand.add(setIsOrderedCommand);

        final SetRequest setLowerRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(),
                newLowerBound);
        final ICommand setLowerCommand = provider.getEditCommand(setLowerRequest);
        updateCommand.add(setLowerCommand);

        final SetRequest setUpperRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(),
                newUpperBound);
        final ICommand setUpperCommand = provider.getEditCommand(setUpperRequest);
        updateCommand.add(setUpperCommand);

        final SetRequest setNameRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
        final ICommand setNameCommand = provider.getEditCommand(setNameRequest);
        updateCommand.add(setNameCommand);

        final SetRequest setTypeRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getTypedElement_Type(), newType);
        final ICommand setTypeCommand = provider.getEditCommand(setTypeRequest);
        updateCommand.add(setTypeCommand);

        final SetRequest setVisibilityRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility);
        final ICommand setVisibilityCommand = provider.getEditCommand(setVisibilityRequest);
        updateCommand.add(setVisibilityCommand);

        final SetRequest setAggregationRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getProperty_Aggregation(), newAggregation);
        final ICommand setAggregationCommand = provider.getEditCommand(setAggregationRequest);
        updateCommand.add(setAggregationCommand);

        final SetRequest setDefaultValueRequest = new SetRequest(editedObject, UMLPackage.eINSTANCE.getProperty_Default(),
                newDefault);
        final ICommand setDefaultValueCommand = provider.getEditCommand(setDefaultValueRequest);
        updateCommand.add(setDefaultValueCommand);

        final SetRequest setRedefinedPropertiesRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), newRedefines);
        final ICommand setRedefinedPropertiesCommand = provider.getEditCommand(setRedefinedPropertiesRequest);
        updateCommand.add(setRedefinedPropertiesCommand);

        final SetRequest setSubsettedPropertiesRequest = new SetRequest(editedObject,
                UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), newSubsets);
        final ICommand setSubsettedPropertiesCommand = provider.getEditCommand(setSubsettedPropertiesRequest);
        updateCommand.add(setSubsettedPropertiesCommand);

        return updateCommand;
    }

    @Override
    public String getTextToEdit(final Object editedObject) {
        if (editedObject instanceof Property) {
            return getLabel((Property) editedObject);
            // TODO: default values not supported by the grammar
            // TODO: either complete the grammar, or use another label provider
        }
        return "not a Property";
    }

    private String getLabel(final Property property) {

        final String visibility = getVisibilityAsSign(property);
        final String isDerived = getDerived(property);
        final String name = getName(property);
        final String type = property.getType() == null ? UNDEFINED_TYPE_NAME : getQualifiedNameLabelWithSufficientDepth(
                property.getType(), UmlPropertyJavaValidator.getModel());
        final String multiplicityAsString = getMultiplicityAsString(property).trim();
        final String multiplicity = multiplicityAsString.equals("[1]") ? "" : multiplicityAsString;
        final String modifiers = getModifiersAsString(property, false);
        final String aggregation = getAggregation(property);
        final String _default = getDefault(property);

        final String label = String.format(" %s%s %s : %s %s %s%s%s", visibility, isDerived, name, type, multiplicity,
                modifiers, aggregation, _default);

        return label.trim();
    }

    private String getAggregation(final Property property) {
        return property.getAggregation() == null ? "" : " @" + property.getAggregation().getName();
    }

    private String getDefault(final Property property) {
        return property.getDefault() == null ? "" : " = " + "\"" + property.getDefault() + "\"";
    }
}
