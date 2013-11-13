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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.ClassItemProvider;
import org.eclipse.uml2.uml.edit.providers.CommentItemProvider;
import org.eclipse.uml2.uml.edit.providers.DataTypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.EnumerationItemProvider;
import org.eclipse.uml2.uml.edit.providers.EnumerationLiteralItemProvider;
import org.eclipse.uml2.uml.edit.providers.PackageItemProvider;
import org.eclipse.uml2.uml.edit.providers.PrimitiveTypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.PropertyItemProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

public class SearchResultsItemProviderAdapterFactory extends UMLItemProviderAdapterFactory {
    @Override
    public Adapter createClassAdapter() {
        if (classItemProvider == null) {
            classItemProvider = new SearchResultsClassItemProvider(this);
        }
        return classItemProvider;
    }

    @Override
    public Adapter createDataTypeAdapter() {
        if (dataTypeItemProvider == null) {
            dataTypeItemProvider = new SearchResultsDataTypeItemProvider(this);
        }
        return dataTypeItemProvider;
    }

    @Override
    public Adapter createEnumerationAdapter() {
        if (enumerationItemProvider == null) {
            enumerationItemProvider = new SearchResultsEnumerationItemProvider(this);
        }
        return enumerationItemProvider;
    }

    @Override
    public Adapter createPrimitiveTypeAdapter() {
        if (primitiveTypeItemProvider == null) {
            primitiveTypeItemProvider = new SearchResultsPrimitiveTypeItemProvider(this);
        }
        return primitiveTypeItemProvider;
    }

    @Override
    public Adapter createPropertyAdapter() {
        if (propertyItemProvider == null) {
            propertyItemProvider = new SearchResultsPropertyItemProvider(this);
        }
        return propertyItemProvider;
    }

    @Override
    public Adapter createCommentAdapter() {
        if (commentItemProvider == null) {
            commentItemProvider = new SearchResultsCommentItemProvider(this);
        }
        return commentItemProvider;
    }

    @Override
    public Adapter createPackageAdapter() {
        if (packageItemProvider == null) {
            packageItemProvider = new SearchResultsPackageItemProvider(this);
        }
        return packageItemProvider;
    }

    @Override
    public Adapter createEnumerationLiteralAdapter() {
        if (enumerationLiteralItemProvider == null) {
            enumerationLiteralItemProvider = new SearchResultsEnumerationLiteralItemProvider(this);
        }
        return enumerationLiteralItemProvider;
    }

    protected static interface ILabelAppender {
        StringBuffer appendLabel(final StringBuffer text, final Object object);
    }

    protected static class SearchResultsClassItemProvider extends ClassItemProvider implements ILabelAppender {

        public SearchResultsClassItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            return getClassifierText(object, this, adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            return super.appendLabel(text, object);
        }
    }

    protected static class SearchResultsDataTypeItemProvider extends DataTypeItemProvider implements ILabelAppender {

        public SearchResultsDataTypeItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            return getClassifierText(object, this, adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            return super.appendLabel(text, object);
        }
    }

    protected static class SearchResultsEnumerationItemProvider extends EnumerationItemProvider implements ILabelAppender {

        public SearchResultsEnumerationItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            return getClassifierText(object, this, adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            return super.appendLabel(text, object);
        }
    }

    protected static class SearchResultsPrimitiveTypeItemProvider extends PrimitiveTypeItemProvider implements
            ILabelAppender {

        public SearchResultsPrimitiveTypeItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            return getClassifierText(object, this, adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            return super.appendLabel(text, object);
        }
    }

    protected static class SearchResultsPropertyItemProvider extends PropertyItemProvider implements ILabelAppender {

        public SearchResultsPropertyItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            final StringBuffer text = appendLabel(new StringBuffer(), object);
            if (object instanceof TypedElement) {
                final TypedElement element = (TypedElement) object;
                appendType(text, element.getType()).toString();
            }
            return text.toString();
        }

        private StringBuffer appendType(final StringBuffer text, final Type type) {
            if (type == null) {
                return text;
            }
            return ((ILabelAppender) adapterFactory.adapt(type, ItemProviderAdapter.class)).appendLabel(
                    text.append(" (of type "), type).append(')');
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            return super.appendLabel(text, object);
        }
    }

    protected static class SearchResultsEnumerationLiteralItemProvider extends EnumerationLiteralItemProvider {
    
        public SearchResultsEnumerationLiteralItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }
    
        @Override
        protected boolean shouldAppendType() {
            return false;
        }
    }

    private static final class SearchResultsCommentItemProvider extends CommentItemProvider {

        public SearchResultsCommentItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        protected boolean shouldAppendType() {
            return false;
        }
    }

    private static final class SearchResultsPackageItemProvider extends PackageItemProvider {

        public SearchResultsPackageItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(final Object object) {
            return appendLabel(new StringBuffer(), object).toString();
        }
    }

    private static String getClassifierText(final Object object, final ILabelAppender labelAppender,
            final AdapterFactory adapterFactory) {
        final StringBuffer text = labelAppender.appendLabel(new StringBuffer(), object);
        if (UMLPackage.Literals.CLASSIFIER.isInstance(object)) {
            appendSupertypes(text, (Classifier) object, adapterFactory);
        }
        return text.toString();
    }

    private static StringBuffer appendSupertypes(final StringBuffer text, final Classifier classifier,
            final AdapterFactory adapterFactory) {
        final Collection<Classifier> generals = classifier.getGenerals();
        if (!generals.isEmpty()) {
            final Iterator<Classifier> i = generals.iterator();
            final Classifier first = i.next();
            ((ILabelAppender) adapterFactory.adapt(first, ItemProviderAdapter.class)).appendLabel(text.append(" (extends "),
                    first);
            while (i.hasNext()) {
                final Classifier next = i.next();
                ((ILabelAppender) adapterFactory.adapt(next, ItemProviderAdapter.class))
                        .appendLabel(text.append(", "), next);
            }
            text.append(")");
        }
        return text;
    }
}
