package org.search.niem.uml.papyrus.editor;

import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.PageBookView;

public class PaletteChangedListener extends NIEMPartAdapter implements IPageChangedListener {

    @Override
    public void partActivated(final IWorkbenchPartReference part) {
        if (itIsThePapyrusEditor(part)) {
            refreshPaletteView(part.getPart(true));
        }
    }

    @Override
    public void partOpened(final IWorkbenchPartReference part) {
        if (itIsThePapyrusEditor(part)) {
            getSashWindowsContainer(getServiceRegistry(part)).addPageChangedListener(this);
        }
    }

    @Override
    public void partClosed(final IWorkbenchPartReference part) {
        if (itIsThePapyrusEditor(part)) {
            getSashWindowsContainer(getServiceRegistry(part)).removePageChangedListener(this);
        }
    }

    @Override
    public void pageChanged(final IPage newPage) {
        if (newPage instanceof IEditorPage) {
            final IEditorPage editorPage = (IEditorPage) newPage;
            final IEditorPart editorPart = editorPage.getIEditorPart();
            if (editorPart != null) {
                refreshPaletteView(editorPart);
            }
        }
    }

    // from https://bugs.eclipse.org/bugs/show_bug.cgi?id=161491
    private void refreshPaletteView(final IWorkbenchPart part) {
        final PageBookView paletteView = findPaletteView(part);
        if (paletteView == null) {
            return;
        }
        part.getSite().getWorkbenchWindow().getWorkbench().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                paletteView.partClosed(part);
                paletteView.partActivated(part);
            }
        });
    }

    private PageBookView findPaletteView(final IWorkbenchPart part) {
        final IViewReference[] views = part.getSite().getPage().getViewReferences();
        for (final IViewReference view : views) {
            if (PaletteView.ID.equals(view.getId())) {
                return (PageBookView) view.getPart(true);
            }
        }
        return null;
    }

    private ISashWindowsContainer getSashWindowsContainer(final ServicesRegistry servicesRegistry) {
        try {
            return servicesRegistry.getService(ISashWindowsContainer.class);
        } catch (final ServiceException e) {
            throw new IllegalStateException("Unable to get the ISashWindowsContainer from the ServicesRegistry", e);
        }
    }
}
