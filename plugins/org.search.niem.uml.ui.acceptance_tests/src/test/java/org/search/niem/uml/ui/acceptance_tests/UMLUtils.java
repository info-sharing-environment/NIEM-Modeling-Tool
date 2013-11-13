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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class UMLUtils {

    public static Model get_the_root_model(final IFile aUmlFile) {
        return (Model) UMLResourcesUtil.init(new ResourceSetImpl())
                .getResource(URI.createPlatformResourceURI(aUmlFile.getFullPath().toString(), true), true).getContents()
                .get(0);
    }
}
