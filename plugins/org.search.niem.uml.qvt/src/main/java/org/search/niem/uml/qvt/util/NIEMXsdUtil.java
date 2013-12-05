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

import java.util.List;

import org.eclipse.xsd.XSDAnnotation;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NIEMXsdUtil {

    private static Element findElementByTag(final XSDAnnotation annotation, final String qualifiedName) {
        for (final Element appinfo : annotation.getApplicationInformation()) {
            final NodeList elements = appinfo.getElementsByTagName(qualifiedName);
            if (elements.getLength() > 0) {
                return (Element) elements.item(0);
            }
        }
        return null;
    }

    private static Element addAppinfo(final XSDAnnotation annotation, final Element appinfo) {
        annotation.getApplicationInformation().add(appinfo);
        annotation.getElement().appendChild(appinfo);
        return appinfo;
    }

    public static Element setAttribute(final Element element, final String name, final String value) {
        element.setAttribute(name, value);
        return element;
    }

    public static <N extends Node> N setContent(final N n, final String textContent) {
        n.setTextContent(textContent);
        return n;
    }

    public static Element getOrCreateAppinfoElement(final XSDAnnotation annotation, final String qualifiedName) {
        final Element element = findElementByTag(annotation, qualifiedName);
        if (element == null) {
            return createAppinfoElement(annotation, qualifiedName);
        }
        return element;
    }

    public static Element createAppinfoElement(final XSDAnnotation annotation, final String qualifiedName) {
        final Element appInfo = getOrCreateAppinfo(annotation);
        return (Element) appInfo.appendChild(appInfo.getOwnerDocument().createElement(qualifiedName));
    }

    private static Element getOrCreateAppinfo(final XSDAnnotation annotation) {
        final List<Element> applicationInformation = annotation.getApplicationInformation();
        return applicationInformation.isEmpty() ? addAppinfo(annotation, annotation.createApplicationInformation(null))
                : applicationInformation.get(0);
    }

}
