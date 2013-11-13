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

import static org.search.niem.uml.util.NIEMUmlExt.findTargetNamespace;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.library.Activator;

public class NamespaceDecoratingItemProviderAdapterFactory extends SearchResultsItemProviderAdapterFactory {

    @Override
    public Adapter createClassAdapter() {
        if (classItemProvider == null) {
            classItemProvider = new NamespaceDecoratingClassItemProvider(this);
        }
        return classItemProvider;
    }

    @Override
    public Adapter createDataTypeAdapter() {
        if (dataTypeItemProvider == null) {
            dataTypeItemProvider = new NamespaceDecoratingDataTypeItemProvider(this);
        }
        return dataTypeItemProvider;
    }

    @Override
    public Adapter createEnumerationAdapter() {
        if (enumerationItemProvider == null) {
            enumerationItemProvider = new NamespaceDecoratingEnumerationItemProvider(this);
        }
        return enumerationItemProvider;
    }

    @Override
    public Adapter createPrimitiveTypeAdapter() {
        if (primitiveTypeItemProvider == null) {
            primitiveTypeItemProvider = new NamespaceDecoratingPrimitiveTypeItemProvider(this);
        }
        return primitiveTypeItemProvider;
    }

    @Override
    public Adapter createPropertyAdapter() {
        if (propertyItemProvider == null) {
            propertyItemProvider = new NamespaceDecoratingPropertyItemProvider(this);
        }
        return propertyItemProvider;
    }

    protected static class NamespaceDecoratingClassItemProvider extends SearchResultsClassItemProvider {

        public NamespaceDecoratingClassItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            if (UMLPackage.Literals.ELEMENT.isInstance(object)) {
                appendNamespacePrefix(text, (Element) object);
            }
            return super.appendLabel(text, object);
        }
    }

    protected static class NamespaceDecoratingDataTypeItemProvider extends SearchResultsDataTypeItemProvider {

        public NamespaceDecoratingDataTypeItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            if (UMLPackage.Literals.ELEMENT.isInstance(object)) {
                appendNamespacePrefix(text, (Element) object);
            }
            return super.appendLabel(text, object);
        }
    }

    protected static class NamespaceDecoratingEnumerationItemProvider extends SearchResultsEnumerationItemProvider {

        public NamespaceDecoratingEnumerationItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            if (UMLPackage.Literals.ELEMENT.isInstance(object)) {
                appendNamespacePrefix(text, (Element) object);
            }
            return super.appendLabel(text, object);
        }
    }

    protected static class NamespaceDecoratingPrimitiveTypeItemProvider extends SearchResultsPrimitiveTypeItemProvider {

        public NamespaceDecoratingPrimitiveTypeItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            if (UMLPackage.Literals.ELEMENT.isInstance(object)) {
                appendNamespacePrefix(text, (Element) object);
            }
            return super.appendLabel(text, object);
        }
    }

    protected static class NamespaceDecoratingPropertyItemProvider extends SearchResultsPropertyItemProvider {

        public NamespaceDecoratingPropertyItemProvider(final AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public StringBuffer appendLabel(final StringBuffer text, final Object object) {
            if (UMLPackage.Literals.ELEMENT.isInstance(object)) {
                appendNamespacePrefix(text, (Element) object);
            }
            return super.appendLabel(text, object);
        }
    }

    private static StringBuffer appendNamespacePrefix(final StringBuffer text, final Element element) {
        final String targetNamespace = findTargetNamespace(element.getNearestPackage());
        return targetNamespace == null ? text : text.append(Activator.INSTANCE.toPrefix(targetNamespace)).append(':');
    }
}
