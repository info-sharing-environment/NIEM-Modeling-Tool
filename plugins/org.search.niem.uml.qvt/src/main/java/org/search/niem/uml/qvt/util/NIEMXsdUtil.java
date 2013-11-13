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
package org.search.niem.uml.qvt.util;

import org.eclipse.xsd.XSDAnnotation;
import org.search.niem.uml.library.Activator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NIEMXsdUtil {

    public static Element findElementByTag(final XSDAnnotation annotation, final String qualifiedName) {
        final String[] namespaceUriAndTagName = qualifiedName2NamespaceUriAndTagName(qualifiedName);
        for (final Element appinfo : annotation.getApplicationInformation()) {
            final NodeList elements = appinfo.getElementsByTagNameNS(namespaceUriAndTagName[0], namespaceUriAndTagName[1]);
            if (elements.getLength() > 0) {
                return (Element) elements.item(0);
            }
        }
        return null;
    }

    public static void addAppinfo(final XSDAnnotation annotation, final String elementName, final String textContent) {
        final Element appinfo = createAppinfo(annotation);
        appinfo.appendChild(setTextContent(textContent, createElement(elementName, appinfo)));
    }

    private static <N extends Node> N setTextContent(final String textContent, final N n) {
        n.setTextContent(textContent);
        return n;
    }

    public static void addAppinfo(final XSDAnnotation annotation, final String elementName, final String name,
            final String namespace) {
        final Element appinfo = createAppinfo(annotation);
        appinfo.appendChild(setAppinfoAttributes(createElement(elementName, appinfo), name, namespace));
    }

    private static Element createElement(final String qualifiedName, final Element parent) {
        final String[] namespaceUriAndTagName = qualifiedName2NamespaceUriAndTagName(qualifiedName);
        return parent.getOwnerDocument().createElementNS(namespaceUriAndTagName[0], qualifiedName);
    }

    private static String[] qualifiedName2NamespaceUriAndTagName(final String qualifiedName) {
        final int index = qualifiedName.indexOf(":");
        final String namespaceURI;
        final String tagName;
        if (index > 0 && index < qualifiedName.length() - 1) {
            namespaceURI = Activator.INSTANCE.toNamespace(qualifiedName.substring(0, index));
            tagName = qualifiedName.substring(index + 1);
        } else {
            namespaceURI = null;
            tagName = qualifiedName;
        }
        return new String[] { namespaceURI, tagName };
    }

    private static Element createAppinfo(final XSDAnnotation annotation) {
        return addAppinfo(annotation, annotation.createApplicationInformation(null));
    }

    private static Element addAppinfo(final XSDAnnotation annotation, final Element appinfo) {
        annotation.getApplicationInformation().add(appinfo);
        annotation.getElement().appendChild(appinfo);
        return appinfo;
    }

    public static Element setAppinfoAttributes(final Element appinfo, final String name, final String namespace) {
        final String namespaceURI = appinfo.getNamespaceURI();
        final String prefix = Activator.INSTANCE.toPrefix(namespaceURI);
        appinfo.setAttributeNS(namespaceURI, prefix == null ? "name" : prefix + ":name", name);
        appinfo.setAttributeNS(namespaceURI, prefix == null ? "namespace" : prefix + ":namespace", namespace);
        return appinfo;
    }
}
