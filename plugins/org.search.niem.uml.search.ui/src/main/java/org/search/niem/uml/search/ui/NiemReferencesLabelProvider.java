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

import static org.apache.commons.lang.StringUtils.join;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider.FontAndColorProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Must not implement {@link ITableLabelProvider}, {@link ITableColorProvider} or {@link ITableFontProvider} in order for
 * tooltips to show. See {@link CellLabelProvider#createViewerLabelProvider} for why.
 */
class NiemReferencesLabelProvider extends CellLabelProvider implements ILabelProvider, INotifyChangedListener,
        IColorProvider, IFontProvider {

    private final FontAndColorProvider delegate;

    NiemReferencesLabelProvider(final AdapterFactoryLabelProvider.FontAndColorProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getToolTipText(final Object element) {
        if (!UMLPackage.Literals.ELEMENT.isInstance(element)) {
            return null;
        }
        final Element e = (Element) element;
        final Collection<Comment> comments = e.getOwnedComments();
        if (comments.isEmpty()) {
            return null;
        }
        final Collection<String> commentStrings = new ArrayList<>(comments.size());
        for (final Comment comment : comments) {
            commentStrings.add(comment.getBody());
        }
        return join(commentStrings, "\n");
    }

    @Override
    public Point getToolTipShift(final Object object) {
        return new Point(5, 5);
    }

    @Override
    public int getToolTipDisplayDelayTime(final Object object) {
        return 500;
    }

    @Override
    public int getToolTipTimeDisplayed(final Object object) {
        return SWT.DEFAULT;
    }

    @Override
    public void update(final ViewerCell cell) {
        final Object element = cell.getElement();
        cell.setBackground(getBackground(element));
        cell.setFont(getFont(element));
        cell.setForeground(getForeground(element));
        cell.setImage(getImage(element));
        cell.setText(getText(element));
    }

    @Override
    public void dispose() {
        try {
            delegate.dispose();
        } finally {
            super.dispose();
        }
    }

    @Override
    public Font getFont(final Object element) {
        return delegate.getFont(element);
    }

    @Override
    public Color getForeground(final Object element) {
        return delegate.getForeground(element);
    }

    @Override
    public Color getBackground(final Object element) {
        return delegate.getBackground(element);
    }

    @Override
    public void notifyChanged(final Notification notification) {
        delegate.notifyChanged(notification);
    }

    @Override
    public Image getImage(final Object element) {
        return delegate.getImage(element);
    }

    @Override
    public String getText(final Object element) {
        return delegate.getText(element);
    }
}
