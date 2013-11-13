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
package org.search.niem.uml.papyrus.editors.readonly;

import static com.google.common.base.Optional.absent;
import static org.search.niem.uml.util.NIEMUmlExt.isInReferenceLibrarySubset;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.search.niem.uml.papyrus.Activator;
import org.search.niem.uml.papyrus.preferences.PreferenceConstants;

import com.google.common.base.Optional;

public class ReferenceSubsetElementHandler implements IReadOnlyHandler {

    public ReferenceSubsetElementHandler(final EditingDomain editingDomain) {
    }

    @Override
    public Optional<Boolean> anyReadOnly(final URI[] uris) {
        return absent();
    }

    @Override
    public Optional<Boolean> makeWritable(final URI[] uris) {
        return absent();
    }

    @Override
    public Optional<Boolean> isReadOnly(final EObject eObject) {
        if (Activator.getPlugin().getPreferenceStore().getBoolean(PreferenceConstants.P_RESTRICT_NIEM_SUBSET_CONTENT)
                && isInReferenceLibrarySubset(eObject)) {
            return Optional.of(true);
        }
        return Optional.<Boolean> absent();
    }

    @Override
    public Optional<Boolean> makeWritable(final EObject eObject) {
        return absent();
    }
}
