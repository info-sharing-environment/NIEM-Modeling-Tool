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
package org.search.niem.uml.papyrus;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class NiemModelSetServiceFactory extends ModelSetServiceFactory {

    @Override
    public Object createServiceInstance() {
        final ResourceSet resourceSet = UMLResourcesUtil.init((ResourceSet) super.createServiceInstance());
        resourceSet.getResource(URI.createURI("http://www.omg.org/spec/NIEM-UML/20120501/XmlPrimitiveTypes.xmi"), true);
        return resourceSet;
    }
}
