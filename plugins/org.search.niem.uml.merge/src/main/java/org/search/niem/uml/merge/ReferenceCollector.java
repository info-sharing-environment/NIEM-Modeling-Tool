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
package org.search.niem.uml.merge;

import static java.util.Collections.singleton;
import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.search.niem.uml.util.NIEMUmlExt.isNiemNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.isXmlPrimitiveType;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.util.EcoreExt;
import org.search.niem.uml.util.UMLExt;

public class ReferenceCollector {

    private final Collection<Element> toMerge;

    public ReferenceCollector(final Collection<Element> toMerge) {
        this.toMerge = toMerge;
    }

    public Collection<EObject> collect(final IProgressMonitor monitor) {
        monitor.beginTask(Activator.INSTANCE.getString("_UI_NIEM_ReferenceCollector_progress"), toMerge.size() * 3);
        try {
            final Collection<EObject> acc = new LinkedHashSet<>();
            for (Collection<Element> more = toMerge; !more.isEmpty(); more = gatherElementsToCopy(acc, more, monitor)) {
            }
            return acc;
        } finally {
            monitor.done();
        }
    }

    private Collection<Element> gatherElementsToCopy(final Collection<EObject> acc, final Collection<Element> pelion,
            final IProgressMonitor monitor) {
        final Collection<Element> ossa = new LinkedHashSet<>();
        for (final Element e : pelion) {
            if (isXmlPrimitiveType(e)) {
                continue;
            }
            acc.add(e);
            acc.addAll(e.getStereotypeApplications());
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            monitor.subTask(Activator.INSTANCE.getString("_UI_NIEM_ReferenceCollector_progress_addingElement", new Object[] {
                    EcoreExt.getName(e.eClass()), defaultIfBlank(UMLExt.getName(e), "unnamed") }));
            monitor.worked(1);
            if (isNiemNamespace(e)) {
                continue;
            }
            collectAbsent(acc, ossa, e, UMLPackage.Literals.ELEMENT__OWNER);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.ELEMENT__OWNED_COMMENT);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.PROPERTY__ASSOCIATION);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.PROPERTY__SUBSETTED_PROPERTY);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.PROPERTY__DEFAULT_VALUE);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER_VALUE);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER_VALUE);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.TYPED_ELEMENT__TYPE);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.ASSOCIATION__MEMBER_END);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.CLASSIFIER__GENERALIZATION);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.NAMED_ELEMENT__CLIENT_DEPENDENCY);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.GENERALIZATION__GENERAL);
            collectAbsent(acc, ossa, e, UMLPackage.Literals.DEPENDENCY__SUPPLIER);
        }
        return ossa;
    }

    private Collection<Element> collectAbsent(final Collection<EObject> acc, final Collection<Element> absent,
            final Element referer, final EReference ref) {
        final Collection<Element> referees;
        if (ref.isMany()) {
            referees = EcoreExt.<Element> getMany(ref, referer);
        } else {
            final Element referee = EcoreExt.<Element> get(ref, referer);
            referees = referee == null ? Collections.<Element> emptyList() : singleton(referee);
        }
        for (final Element referee : referees) {
            if (!acc.contains(referee)) {
                absent.add(referee);
            }
        }
        return absent;
    }
}