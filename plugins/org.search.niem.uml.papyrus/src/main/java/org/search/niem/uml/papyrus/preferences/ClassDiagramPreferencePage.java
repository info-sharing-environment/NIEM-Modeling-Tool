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
package org.search.niem.uml.papyrus.preferences;

import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMNS;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_COLUMN_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_ELEMENT_WIDTH;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_CLASS_DIAGRAM_VERTICAL_PADDING;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_INITIAL_PROPERTY_AGGREGATION;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_ILLEGAL_FONT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_LEGAL_COLOR;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_NIEM_REFERENCE_ELEMENT_LEGAL_FONT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_RESTRICT_NIEM_SUBSET_CONTENT;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_SYNC_CLASS_DIAGRAMS_WITH_UML;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.uml2.uml.AggregationKind;
import org.search.niem.uml.papyrus.Activator;

public class ClassDiagramPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public ClassDiagramPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getPlugin().getPreferenceStore());
        setDescription(Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_description"));
    }

    @Override
    public void createFieldEditors() {
        addField(new BooleanFieldEditor(P_SYNC_CLASS_DIAGRAMS_WITH_UML,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_synchClassDiagramsWithUML"),
                getFieldEditorParent()));
        addField(new BooleanFieldEditor(P_RESTRICT_NIEM_SUBSET_CONTENT,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_restrictNiemSubsetContent"),
                getFieldEditorParent()));
        addField(new ComboFieldEditor(P_INITIAL_PROPERTY_AGGREGATION,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_initialPropertyAggregation"), new String[][] {
                        { AggregationKind.NONE_LITERAL.getName(), AggregationKind.NONE_LITERAL.getName() },
                        { AggregationKind.SHARED_LITERAL.getName(), AggregationKind.SHARED_LITERAL.getName() },
                        { AggregationKind.COMPOSITE_LITERAL.getName(), AggregationKind.COMPOSITE_LITERAL.getName() } },
                getFieldEditorParent()));
        addField(new ColorFieldEditor(P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_niemReferenceElementIllegalColor"),
                getFieldEditorParent()));
        addField(new FontFieldEditor(P_NIEM_REFERENCE_ELEMENT_ILLEGAL_FONT,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_niemReferenceElementIllegalFont"),
                getFieldEditorParent()));
        addField(new ColorFieldEditor(P_NIEM_REFERENCE_ELEMENT_LEGAL_COLOR,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_niemReferenceElementLegalColor"),
                getFieldEditorParent()));
        addField(new FontFieldEditor(P_NIEM_REFERENCE_ELEMENT_LEGAL_FONT,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_niemReferenceElementLegalFont"),
                getFieldEditorParent()));
        addField(new IntegerFieldEditor(P_CLASS_DIAGRAM_COLUMNS,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_classDiagramColumns"), getFieldEditorParent()));
        addField(new IntegerFieldEditor(P_CLASS_DIAGRAM_ELEMENT_WIDTH,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_classDiagramElementWidth"),
                getFieldEditorParent()));
        addField(new IntegerFieldEditor(P_CLASS_DIAGRAM_COLUMN_WIDTH,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_classDiagramColumnWidth"),
                getFieldEditorParent()));
        addField(new IntegerFieldEditor(P_CLASS_DIAGRAM_VERTICAL_PADDING,
                Activator.INSTANCE.getString("_UI_ClassDiagramPreferencePage_classDiagramVerticalPadding"),
                getFieldEditorParent()));
    }

    @Override
    public void init(final IWorkbench workbench) {
    }
}