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

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

    public static String THE_NIEM_UML_PERSPECTIVE_ID = "org.search.niem.uml.perspective";

    private static final String MODEL_EXPLORER = "org.eclipse.papyrus.views.modelexplorer.modelexplorer";
    private static final String PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String EAST = "east";
    private static final String SOUTHWEST = "east";
    private static final float EDITOR_AREA_HEIGHT = 0.65f;
    private static final float EDITOR_AREA_WIDTH = 0.60f;

    @Override
    public void createInitialLayout(final IPageLayout layout) {
        final String editorArea = layout.getEditorArea();

        final float westWidth = (1 - EDITOR_AREA_WIDTH) / 2;
        final IFolderLayout west = layout.createFolder(WEST, IPageLayout.LEFT, westWidth, editorArea);
        west.addView(PROJECT_EXPLORER);

        final IFolderLayout southWest = layout.createFolder(SOUTHWEST, IPageLayout.BOTTOM, EDITOR_AREA_HEIGHT,
                PROJECT_EXPLORER);
        southWest.addView(IPageLayout.ID_OUTLINE);

        final IFolderLayout east = layout.createFolder(EAST, IPageLayout.RIGHT, EDITOR_AREA_WIDTH + westWidth, editorArea);
        east.addView(MODEL_EXPLORER);

        final IFolderLayout south = layout.createFolder(SOUTH, IPageLayout.BOTTOM, EDITOR_AREA_HEIGHT, editorArea);
        south.addView(IPageLayout.ID_PROP_SHEET);
        south.addView(IPageLayout.ID_PROBLEM_VIEW);
        south.addView("org.eclipse.search.ui.views.SearchView");
    }
}
