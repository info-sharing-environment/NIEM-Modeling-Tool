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

public interface PreferenceConstants {

    String SEPARATOR = "::";

    String P_DEFAULT_MODEL_NAME = "defaultModelNamePreference";
    String P_EXCHANGE_MODEL_TARGET_NAMESPACE = "exchangeModelTargetNamespace";
    String P_EXTENSION_MODEL_TARGET_NAMESPACE = "extensionModelTargetNamespace";
    String P_MPD_BASE_URI = "mpdBaseURI";
    String P_MPD_VERSION_NUMBER = "mpdVersionNumber";
    String P_MPD_DESCRIPTION = "mpdDescription";
    String P_MPD_PURPOSE = "mpdPurpose";
    String P_MPD_SECURITY_MARKING = "mpdSecurityMarking";
    String P_DOMAINS = "domains";
    String P_KEYWORDS = "keywords";
    String P_AUTHORITATIVE_SOURCE_NAME = "authoritativeSourceName";
    String P_AUTHORITATIVE_SOURCE_ADDRESS = "authoritativeSourceAddress";
    String P_AUTHORITATIVE_SOURCE_WEBSITE = "authoritativeSourceWebsite";
    String P_POINTS_OF_CONTACT = "pointsOfContact";

    String P_SYNC_CLASS_DIAGRAMS_WITH_UML = "synchClassDiagramsWithUML";
    String P_RESTRICT_NIEM_SUBSET_CONTENT = "restrictNiemSubsetContent";
    String P_INITIAL_PROPERTY_AGGREGATION = "initialPropertyAggregation";
    String P_NIEM_REFERENCE_ELEMENT_LEGAL_FONT = "niemReferenceElementLegalFont";
    String P_NIEM_REFERENCE_ELEMENT_LEGAL_COLOR = "niemReferenceElementLegalColor";
    String P_NIEM_REFERENCE_ELEMENT_ILLEGAL_FONT = "niemReferenceElementIllegalFont";
    String P_NIEM_REFERENCE_ELEMENT_ILLEGAL_COLOR = "niemReferenceElementIllegalColor";
    String P_CLASS_DIAGRAM_COLUMNS = "classDiagramColumns";
    String P_CLASS_DIAGRAM_VERTICAL_PADDING = "classDiagramVerticalPadding";
    String P_CLASS_DIAGRAM_COLUMN_WIDTH = "classDiagramColumnWidth";
    String P_CLASS_DIAGRAM_ELEMENT_WIDTH = "classDiagramElementWidth";

    // TODO: remove this in Luna
    String P_DISPLAY_MESSAGE_FOR_DELETE_ACTION = "displayMessageForDeleteActionPreferenceKey";
}
