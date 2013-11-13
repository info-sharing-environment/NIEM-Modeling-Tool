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
package org.search.niem.uml.ui.acceptance_tests;

import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.hamcrest.CoreMatchers.not;
import static org.search.niem.uml.ui.PerspectiveFactory.THE_NIEM_UML_PERSPECTIVE_ID;
import static org.search.niem.uml.ui.acceptance_tests.UIUtils.get_the_active_editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.search.niem.uml.util.EcoreExt;
import org.search.niem.uml.util.UMLExt;

public class NIEMMatchers {
    public static Matcher<IFile> is_open_in_papyrus() {
        return new NiemMatcher<IFile>() {

            @Override
            protected void describeMismatchSafely(final IFile f, final Description d) {
                d.appendValue(f.getName() + " is not open in an active Papyrus editor.");
            }

            @Override
            protected boolean matchesSafely(final IFile f) {
                final IEditorPart theActiveEditor = get_the_active_editor();

                return PapyrusMultiDiagramEditor.EDITOR_ID.equals(theActiveEditor.getEditorSite().getId())
                        && f.equals(((FileEditorInput) theActiveEditor.getEditorInput()).getFile());
            }
        };
    }

    public static Matcher<Element> has_applied_stereotype(final String theQualifiedName) {
        return new NiemMatcher<Element>() {
            @Override
            protected void describeMismatchSafely(final Element p, final Description d) {
                d.appendValue(defaultIfBlank(UMLExt.getName(p), EcoreExt.getName(p.eClass())) + " does not have the "
                        + theQualifiedName + " stereotype applied.");
            }

            @Override
            protected boolean matchesSafely(final Element item) {
                return item.getAppliedStereotype(theQualifiedName) != null;
            }
        };
    }

    public static Matcher<Package> has_applied_profile(final String theQualifiedName) {
        return new NiemMatcher<Package>() {
            @Override
            protected void describeMismatchSafely(final Package p, final Description d) {
                d.appendValue(p.getName() + " does not have the " + theQualifiedName + " profile applied.");
            }

            @Override
            protected boolean matchesSafely(final Package item) {
                return item.getAppliedProfile(theQualifiedName) != null;
            }
        };
    }

    public static Matcher<IFile> exists() {
        return new NiemMatcher<IFile>() {

            @Override
            protected void describeMismatchSafely(final IFile f, final Description d) {
                d.appendValue(f.getFullPath() + " does not exist.");
            }

            @Override
            protected boolean matchesSafely(final IFile f) {
                return f.exists();
            }
        };
    }

    public static Matcher<IWorkbench> is_not_open_to_the_niem_uml_perspective() {
        return not(is_open_to_the_niem_uml_perspective());
    }

    public static Matcher<IWorkbench> is_open_to_the_niem_uml_perspective() {
        return new NiemMatcher<IWorkbench>() {

            @Override
            protected void describeMismatchSafely(final IWorkbench w, final Description d) {
                d.appendValue("The workbench is open to " + theCurrentPrespectiveId(w) + " instead of "
                        + THE_NIEM_UML_PERSPECTIVE_ID);
            }

            @Override
            protected boolean matchesSafely(final IWorkbench w) {
                return THE_NIEM_UML_PERSPECTIVE_ID.equals(theCurrentPrespectiveId(w));
            }
        };
    }

    private static String theCurrentPrespectiveId(final IWorkbench w) {
        return w.getActiveWorkbenchWindow().getActivePage().getPerspective().getId();
    }

    private static abstract class NiemMatcher<T> extends TypeSafeMatcher<T> {
        @Override
        public void describeTo(final Description description) {
        }
    }
}
