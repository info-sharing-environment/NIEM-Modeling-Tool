/*
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SEARCH Group, Incorporated - initial API and implementation
 *
 */
package org.search.niem.uml.ui;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.join;
import static org.eclipse.papyrus.uml.tools.model.UmlUtils.getUmlResource;
import static org.eclipse.uml2.uml.util.UMLUtil.findNamedElements;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.search.niem.uml.ui.acceptance_tests.NIEMMatchers.has_applied_stereotype;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.doubleClick;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.findByElement;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.findByName;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.findThePaletteTool;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.getActiveEditPart;
import static org.search.niem.uml.ui.acceptance_tests.PapyrusUtils.leftClick;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_active_editor;
import static org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryNiemUmlModel.THE_MODEL_NAME;
import static org.search.niem.uml.util.NIEMTypes.AdapterType;
import static org.search.niem.uml.util.NIEMTypes.AssociationType;
import static org.search.niem.uml.util.NIEMTypes.AugmentationType;
import static org.search.niem.uml.util.NIEMTypes.Choice;
import static org.search.niem.uml.util.NIEMTypes.List;
import static org.search.niem.uml.util.NIEMTypes.MetadataType;
import static org.search.niem.uml.util.NIEMTypes.Namespace;
import static org.search.niem.uml.util.NIEMTypes.ObjectType;
import static org.search.niem.uml.util.NIEMTypes.PropertyHolder;
import static org.search.niem.uml.util.NIEMTypes.RoleOf;
import static org.search.niem.uml.util.NIEMTypes.Union;
import static org.search.niem.uml.util.NIEMTypes.ValueRestriction;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Tool;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryNiemUmlModel;
import org.search.niem.uml.ui.acceptance_tests.rules.CreatesATemporaryProject;
import org.search.niem.uml.ui.acceptance_tests.rules.DisablesProjectPerspectiveSwitching;
import org.search.niem.uml.ui.acceptance_tests.rules.OpensEditors;

@RunWith(Theories.class)
public class NiemUmlEditorTest {

    private static final String THE_EXCHANGE_NAME = THE_MODEL_NAME + "Exchange";
    private static final String THE_PIM_NAME = THE_MODEL_NAME + "PIM";
    // @formatter:off
    @DataPoints
    public static NIEMTypeData[] TYPE_DATA = {
//        XXX: for Association Classes, we need to click on 2 other classes in the diagram in order for the Association Class to appear
        new NIEMTypeData("NIEM UML/Object Type (Class)", "ObjectType1", ObjectType),
//        new NIEMTypeData("NIEM UML/Object Type (AssociationClass)", "ObjectType1", ObjectType),
        new NIEMTypeData("NIEM UML/Association Type (Class)", "AssociationType1", AssociationType),
//        new NIEMTypeData("NIEM UML/Association Type (AssociationClass)", "AssociationType1", AssociationType),
        new NIEMTypeData("NIEM UML/Metadata Type (Class)", "MetadataType1", MetadataType),
//        new NIEMTypeData("NIEM UML/Metadata Type (AssociationClass)", "MetadataType1", MetadataType),
        new NIEMTypeData("NIEM UML/Augmentation Type (Class)", "AugmentationType1", AugmentationType),
//        new NIEMTypeData("NIEM UML/Augmentation Type (AssociationClass)", "AugmentationType1", AugmentationType),
        new NIEMTypeData("NIEM UML/Adapter Type (Class)", "AdapterType1", AdapterType),
//        new NIEMTypeData("NIEM UML/Adapter Type (AssociationClass)", "AdapterType1", AdapterType),
        new NIEMTypeData("NIEM UML/Property Holder (Class)", "PropertyHolder1", PropertyHolder),
        new NIEMTypeData("NIEM UML/Union (DataType)", "Union1", Union),
        new NIEMTypeData("NIEM UML/Value Restriction (DataType)", "ValueRestriction1", ValueRestriction),
        new NIEMTypeData("NIEM UML/Value Restriction (Enumeration)", "ValueRestriction1", ValueRestriction),
        new NIEMTypeData("NIEM UML/Value Restriction (PrimitiveType)", "ValueRestriction1", ValueRestriction),
        new NIEMTypeData("NIEM UML/Choice (Class)", "Choice1", Choice),
        new NIEMTypeData("NIEM UML/List (DataType)", "List1", List),
    };

    @DataPoints
    public static NIEMAttributeData[] ATTRIBUTE_DATA = {
        new NIEMAttributeData("NIEM UML/Role Of (Property)", "RoleOf1", RoleOf, "Class1"),
    };
    // @formatter:on

    private final CreatesATemporaryProject theProjectProvider;

    // @formatter:off
    @Rule
    public final TestRule ruleChain = RuleChain
        .outerRule(new DisablesProjectPerspectiveSwitching())
        .around(theProjectProvider = new CreatesATemporaryProject())
        .around(new CreatesATemporaryNiemUmlModel(theProjectProvider))
        .around(new OpensEditors());
    // @formatter:on

    @Test
    public void should_add_a_niem_conformant_namespace_to_the_diagram() throws ServiceException {
        final IMultiDiagramEditor theActiveEditor = (IMultiDiagramEditor) get_the_active_editor();

        final EditPart thePIMEditPart = getActiveEditPart(theActiveEditor);
        doubleClick(findThePaletteTool(thePIMEditPart, "NIEM UML/NIEM-conformant Namespace"), thePIMEditPart.getViewer());

        final NamedElement theNewNamespace = findNamedElements(
                getUmlResource(theActiveEditor.getServicesRegistry().getService(ModelSet.class)),
                join(asList("Data", THE_PIM_NAME, "Namespace1"), NamedElement.SEPARATOR)).iterator().next();
        assertThat(theNewNamespace, has_applied_stereotype(Namespace));

        assertThat(findByElement(thePIMEditPart, theNewNamespace), is(notNullValue()));
    }

    @Theory
    public void should_add_a_niem_type_to_the_diagram(final NIEMTypeData typeData) throws ServiceException {
        final IMultiDiagramEditor theActiveEditor = (IMultiDiagramEditor) get_the_active_editor();
        final EditPart theExchangeEditPart = navigate(theActiveEditor, THE_EXCHANGE_NAME);

        doubleClick(findThePaletteTool(theExchangeEditPart, typeData.thePalettePath), theExchangeEditPart.getViewer());

        final NamedElement theNewObjectType = findNamedElements(
                getUmlResource(theActiveEditor.getServicesRegistry().getService(ModelSet.class)),
                join(asList("Data", THE_PIM_NAME, THE_EXCHANGE_NAME, typeData.theNewTypeName), NamedElement.SEPARATOR))
                .iterator().next();
        assertThat(theNewObjectType, has_applied_stereotype(typeData.theExpectedStereotype));
    }

    @Ignore
    @Theory
    public void should_add_a_niem_property_to_the_diagram(final NIEMAttributeData attributeData) throws ServiceException,
            InterruptedException {
        final IMultiDiagramEditor theActiveEditor = (IMultiDiagramEditor) get_the_active_editor();

        final EditPart theExchangeEditPart = navigate(theActiveEditor, THE_EXCHANGE_NAME);

        final EditPartViewer theViewer = theExchangeEditPart.getViewer();
        doubleClick(findThePaletteTool(theExchangeEditPart, "Nodes/Class"), theViewer);

        final Tool thePaletteTool = findThePaletteTool(theExchangeEditPart, attributeData.thePalettePath);
        leftClick(thePaletteTool, theViewer);

        final GraphicalEditPart theContainingType = (GraphicalEditPart) findByName(theExchangeEditPart, "Class1");
        final GraphicalEditPart theAttributeCompartment = (GraphicalEditPart) theContainingType.getChildren().get(1);

        // theViewer.reveal(theAttributeCompartment);
        // theViewer.select(theAttributeCompartment);

        leftClick(thePaletteTool, theAttributeCompartment);

        // final Request request = new Request();
        // request.setType(RequestConstants.REQ_DIRECT_EDIT);
        // theAttributeCompartment.performRequest(request);

        final NamedElement theNewAttribute = findNamedElements(
                getUmlResource(theActiveEditor.getServicesRegistry().getService(ModelSet.class)),
                join(asList("Data", THE_PIM_NAME, THE_EXCHANGE_NAME, "Class1", attributeData.theNewAttributeName),
                        NamedElement.SEPARATOR)).iterator().next();
        assertThat(theNewAttribute, has_applied_stereotype(attributeData.theExpectedStereotype));
    }

    private EditPart navigate(final IMultiDiagramEditor theActiveEditor, final String... links) {
        for (final String link : links) {
            doubleClick(findByName(getActiveEditPart(theActiveEditor), link));
        }
        return getActiveEditPart(theActiveEditor);
    }

    private static final class NIEMTypeData {
        final String thePalettePath;
        final String theNewTypeName;
        final String theExpectedStereotype;

        NIEMTypeData(final String thePalettePath, final String theNewTypeName, final String theExpectedStereotype) {
            this.thePalettePath = thePalettePath;
            this.theNewTypeName = theNewTypeName;
            this.theExpectedStereotype = theExpectedStereotype;
        }
    }

    private static final class NIEMAttributeData {
        final String thePalettePath;
        final String theNewAttributeName;
        final String theExpectedStereotype;
        final String theContainingTypeName;

        NIEMAttributeData(final String thePalettePath, final String theNewAttributeName, final String theExpectedStereotype,
                final String theContainingTypeName) {
            this.thePalettePath = thePalettePath;
            this.theNewAttributeName = theNewAttributeName;
            this.theExpectedStereotype = theExpectedStereotype;
            this.theContainingTypeName = theContainingTypeName;
        }
    }
}
