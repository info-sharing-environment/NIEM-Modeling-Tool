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
package org.search.niem.uml.qvt.ui.handlers;

import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.uml.util.EcoreExt.filterByType;
import static org.search.niem.uml.util.UMLExt.isStereotypeApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.qvt.ui.Activator;

final class NIEMpim2psmDelegate extends TransformDelegate {

    private BasicModelExtent niemUml;

    protected NIEMpim2psmDelegate(final URI selection) {
        super(selection, org.search.niem.uml.qvt.Activator.INSTANCE.getNIEMpim2psmLocation(), Activator.INSTANCE
                .getString("_UI_NIEMpim2psm_Command_name"));
    }

    @Override
    protected final ModelExtent[] arguments() {
        niemUml = new BasicModelExtent(theSelectedResource.getContents());
        return new ModelExtent[] { niemUml };
    }

    @Override
    protected final void persist() throws IOException {
        theSelectedResource.getContents().clear();
        theSelectedResource.getContents()
                .addAll(filterByType(filterDanglingStereotypeApplications(niemUml.getContents()),
                        UMLPackage.Literals.GENERALIZATION));
        theSelectedResource.save(resourceSet.getLoadOptions());
    }

    @Override
    public void close() throws Exception {
        niemUml = null;
        super.close();
    }

    private static Collection<EObject> filterDanglingStereotypeApplications(final Collection<EObject> toFilter) {
        final Collection<EObject> filtered = new ArrayList<>();
        for (final EObject e : toFilter) {
            if (!(isStereotypeApplication(e) && getBaseElement(e) == null)) {
                filtered.add(e);
            }
        }
        return filtered;
    }
}