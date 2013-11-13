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
package org.search.niem.uml.search.ui;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;

public class ReferenceLibrarySearchResult extends AbstractTextSearchResult {

    private final ReferenceLibrarySearchQuery searchQuery;

    public ReferenceLibrarySearchResult(final ReferenceLibrarySearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public String getLabel() {
        return Activator.INSTANCE.getString("_UI_NIEM_SearchResult_label", new Object[] { searchQuery.criteria.searchTerm,
                getMatchCount() });
    }

    @Override
    public String getTooltip() {
        return Activator.INSTANCE.getString("_UI_NIEM_SearchResult_tooltip");
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ExtendedImageRegistry.INSTANCE.getImageDescriptor(Activator.INSTANCE
                .getImage("full/eview16/niem_search_result.png"));
    }

    @Override
    public ISearchQuery getQuery() {
        return searchQuery;
    }

    @Override
    public IEditorMatchAdapter getEditorMatchAdapter() {
        return null;
    }

    @Override
    public IFileMatchAdapter getFileMatchAdapter() {
        return null;
    }
}
