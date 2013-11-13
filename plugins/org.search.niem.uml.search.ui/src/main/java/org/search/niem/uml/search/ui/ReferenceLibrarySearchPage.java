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

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.search.niem.uml.search.Criteria;
import org.search.niem.uml.search.MatchType;
import org.search.niem.uml.search.ui.help.NiemUmlHelpContextIds;

public class ReferenceLibrarySearchPage extends DialogPage implements ISearchPage {

    private static final int HISTORY_SIZE = 10;
    private static final String PAGE_NAME = "ReferenceLibrarySearchPage";

    private static final String STORE_SEARCH_CRITERIA = "searchCriteria";
    private static final String STORE_MATCH_TYPES = "matchTypes";
    private static final String STORE_SEARCH_TERM = "searchTerm";
    private static final Pattern searchCriteriaPattern = Pattern.compile(STORE_SEARCH_CRITERIA + "\\[(\\d+)]");

    private final List<Criteria> history = new LinkedList<>();

    private Combo searchTerm;
    private ISearchPageContainer container;
    private Iterable<Button> matchTypes;
    private ResourceSet resourceSet;

    public ReferenceLibrarySearchPage() {
    }

    public ReferenceLibrarySearchPage(final String title) {
        super(title);
    }

    public ReferenceLibrarySearchPage(final String title, final ImageDescriptor image) {
        super(title, image);
    }

    @Override
    public void setContainer(final ISearchPageContainer container) {
        this.container = container;
    }

    @Override
    public void createControl(final Composite parent) {
        resourceSet = UMLResourcesUtil.init(new ResourceSetImpl());

        initializeDialogUnits(parent);
        readCriteria();

        final Composite pageContainer = new Composite(parent, SWT.NONE);

        style(pageContainer, createSearchTermContainer(pageContainer), createMatchContainer(pageContainer));

        if (!history.isEmpty()) {
            updateControls(history.get(0));
        }

        setControl(pageContainer);

        PlatformUI.getWorkbench().getHelpSystem()
                .setHelp(pageContainer, NiemUmlHelpContextIds.REFERENCE_LIBRARY_SEARCH_PAGE);
    }

    private void style(final Composite pageContainer, final Composite searchTermContainer, final Composite matchContainer) {
        Dialog.applyDialogFont(pageContainer);
        GridLayoutFactory.swtDefaults().generateLayout(searchTermContainer);
        GridLayoutFactory.swtDefaults().generateLayout(matchContainer);
        GridLayoutFactory.swtDefaults().spacing(10, 10).generateLayout(pageContainer);
    }

    private Composite createMatchContainer(final Composite parent) {
        final Group g = new Group(parent, SWT.NONE);
        g.setText(getString("_UI_NIEM_SearchPage_match_label"));

        matchTypes = asList(
                createMatchTypeButton(g, getString("_UI_NIEM_SearchPage_match_fullName_label"), MatchType.FULL_NAMES_ONLY,
                        false),
                createMatchTypeButton(g, getString("_UI_NIEM_SearchPage_match_definitions_label"), MatchType.DEFINITIONS,
                        false),
                createMatchTypeButton(g, getString("_UI_NIEM_SearchPage_match_externals_label"), MatchType.EXTERNALS, false));

        return g;
    }

    private Button createMatchTypeButton(final Composite parent, final String text, final Integer matchType,
            final boolean isSelected) {
        final Button button = new Button(parent, SWT.CHECK);
        button.setText(text);
        button.setSelection(isSelected);
        button.setData(matchType);
        return button;
    }

    private Composite createSearchTermContainer(final Composite parent) {
        final Composite container = new Composite(parent, SWT.NONE);

        final Label label = new Label(container, SWT.LEFT);
        label.setText(getString("_UI_NIEM_SearchPage_term_label"));

        searchTerm = new Combo(container, SWT.SINGLE | SWT.BORDER);
        searchTerm.setVisibleItemCount(HISTORY_SIZE);
        searchTerm.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                handleSearchTermSelected();
                updateOKStatus();
            }
        });
        searchTerm.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(final ModifyEvent e) {
                updateOKStatus();
            }
        });

        for (final Criteria c : history) {
            searchTerm.add(c.searchTerm);
        }

        return container;
    }

    private void handleSearchTermSelected() {
        updateControls(history.get(searchTerm.getSelectionIndex()));
    }

    private void updateControls(final Criteria currentCriteria) {
        for (final Button b : matchTypes) {
            b.setSelection(((Integer) b.getData() & currentCriteria.matchType) > 0);
        }
        searchTerm.setText(currentCriteria.searchTerm);
    }

    private void updateOKStatus() {
        container.setPerformActionEnabled(isNotBlank(searchTerm.getText()));
    }

    @Override
    public boolean performAction() {
        final Criteria currentCriteria = new Criteria(searchTerm.getText(), getSelectedMatchTypes());
        NewSearchUI.runQueryInBackground(new ReferenceLibrarySearchQuery(currentCriteria, resourceSet));
        updateHistory(currentCriteria);
        writeCriteria();
        return true;
    }

    private int getSelectedMatchTypes() {
        int matchType = 0;
        for (final Button b : matchTypes) {
            if (b.getSelection()) {
                matchType |= (Integer) b.getData();
            }
        }
        return matchType;
    }

    private void updateHistory(final Criteria currentCriteria) {
        Criteria criteriaToRemove = null;
        for (final Criteria c : history) {
            if (currentCriteria.searchTerm.equals(c.searchTerm)) {
                criteriaToRemove = c;
                break;
            }
        }
        if (criteriaToRemove != null) {
            history.remove(criteriaToRemove);
        } else if (history.size() == HISTORY_SIZE) {
            history.remove(HISTORY_SIZE - 1);
        }
        history.add(0, currentCriteria);
    }

    @Override
    public void setVisible(final boolean visible) {
        super.setVisible(visible);
        if (visible && searchTerm != null) {
            searchTerm.setFocus();
            updateOKStatus();
        }
    }

    private String getString(final String key) {
        return Activator.INSTANCE.getString(key);
    }

    private void readCriteria() {
        final IDialogSettings s = Activator.getPlugin().getDialogSettings().getSection(PAGE_NAME);
        if (s == null) {
            return;
        }
        final IDialogSettings allCriteria = s.getSection(STORE_SEARCH_CRITERIA);
        if (allCriteria == null) {
            return;
        }
        final IDialogSettings[] sections = allCriteria.getSections();
        if (sections == null) {
            return;
        }
        final ArrayList<IDialogSettings> sortedSections = new ArrayList<>(asList(sections));
        Collections.sort(sortedSections, new Comparator<IDialogSettings>() {
            @Override
            public int compare(final IDialogSettings left, final IDialogSettings right) {
                return Integer.compare(getIndex(left.getName()), getIndex(right.getName()));
            }
        });
        for (final IDialogSettings searchCriteria : sortedSections) {
            int matchType = 0;
            try {
                matchType = searchCriteria.getInt(STORE_MATCH_TYPES);
            } catch (final NumberFormatException e) {
                // no-op
            }
            history.add(new Criteria(searchCriteria.get(STORE_SEARCH_TERM), matchType));
        }
    }

    private int getIndex(final String searchCriteriaTag) {
        final Matcher m = searchCriteriaPattern.matcher(searchCriteriaTag);
        if (m.matches()) {
            return Integer.parseInt(m.group(1));
        }
        Activator.INSTANCE.log("Unexpected tag name " + searchCriteriaTag);
        return -1;
    }

    private void writeCriteria() {
        final IDialogSettings s = DialogSettings.getOrCreateSection(Activator.getPlugin().getDialogSettings(), PAGE_NAME);
        final int historySize = Math.min(history.size(), HISTORY_SIZE);
        final IDialogSettings allCriteria = DialogSettings.getOrCreateSection(s, STORE_SEARCH_CRITERIA);
        for (int i = 0; i < historySize; i++) {
            final IDialogSettings searchCriteria = allCriteria.addNewSection(STORE_SEARCH_CRITERIA + "[" + i + "]");
            final Criteria criteria = history.get(i);
            searchCriteria.put(STORE_SEARCH_TERM, criteria.searchTerm);
            searchCriteria.put(STORE_MATCH_TYPES, criteria.matchType);
        }
    }
}
