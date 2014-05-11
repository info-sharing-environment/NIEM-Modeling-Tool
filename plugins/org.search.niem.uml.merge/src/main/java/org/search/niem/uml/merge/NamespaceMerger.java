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

import static org.apache.commons.lang.StringUtils.capitalize;
import static org.apache.commons.lang.StringUtils.defaultIfBlank;
import static org.eclipse.emf.common.util.ECollections.indexOf;
import static org.search.niem.uml.merge.NamespaceMergeUtil.findEquivalent;
import static org.search.niem.uml.util.NIEMUmlExt.isNiemNamespace;
import static org.search.niem.uml.util.UMLExt.getName;
import static org.search.niem.uml.util.UMLExt.isStereotypeApplication;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.search.niem.uml.util.EcoreExt;
import org.search.niem.uml.util.UMLExt;

public class NamespaceMerger extends Copier {

    private static final long serialVersionUID = 1;

    private final Package thePIM;
    private final Collection<EObject> toMerge;
    private final Collection<PackageableElement> newNamespaces = new LinkedHashSet<>();
    private final Collection<EObject> newStereotypeApplications = new LinkedHashSet<>();
    private final Collection<EObject> newPackagedElements = new LinkedHashSet<>();

    private IProgressMonitor monitor;

    public NamespaceMerger(final Package thePIM, final Collection<EObject> toMerge) {
        this.thePIM = thePIM;
        this.toMerge = toMerge;
    }

    public Collection<EObject> getNewStereotypeApplications() {
        return newStereotypeApplications;
    }

    public Collection<PackageableElement> getNewNamespaces() {
        return newNamespaces;
    }

    public void copyAll(final IProgressMonitor monitor) {
        this.monitor = monitor;
        monitor.beginTask(Activator.INSTANCE.getString("_UI_NIEM_PackageMerger_progress"), toMerge.size());
        try {
            copyAll(toMerge);
        } finally {
            monitor.done();
        }
    }

    @Override
    protected void copyReference(final EReference eReference, final EObject eObject, final EObject copyEObject) {
        if (isPseudoDerived(eReference) || !wasCopied(copyEObject)) {
            return;
        }
        super.copyReference(eReference, eObject, copyEObject);
    }

    private boolean wasCopied(final EObject copyEObject) {
        return newNamespaces.contains(copyEObject) || newStereotypeApplications.contains(copyEObject)
                || newPackagedElements.contains(copyEObject);
    }

    @Override
    public EObject copy(final EObject eObject) {
        if (!toMerge.contains(eObject)) {
            return null;
        }
        if (containsKey(eObject)) {
            return get(eObject);
        }
        monitor.subTask(Activator.INSTANCE.getString("_UI_NIEM_PackageMerger_progress_mergingElement", new Object[] {
                EcoreExt.getName(eObject.eClass()), defaultIfBlank(UMLExt.getName(eObject), "unnamed") }));
        final EObject copyEObject;
        final EObject found = findEquivalent(eObject, thePIM);
        if (found != null) {
            copyEObject = found;
            put(eObject, copyEObject);
        } else {
            copyEObject = simpleCopy(eObject);
        }
        copyContainments(eObject, copyEObject);

        copyProxyURI(eObject, copyEObject);

        monitor.worked(1);
        return copyEObject;
    }

    private EObject simpleCopy(final EObject theSource) {
        final EObject theCopy = super.createCopy(theSource);
        put(theSource, theCopy);
        copyAttributes(theSource, theCopy);
        if (isStereotypeApplication(theSource)) {
            newStereotypeApplications.add(theCopy);
        } else if (isNiemNamespace(theSource)) {
            theCopy.eSet(UMLPackage.Literals.NAMED_ELEMENT__NAME,
                    normalize(EcoreExt.<String> get(UMLPackage.Literals.NAMED_ELEMENT__NAME, theSource), thePIM));
            newNamespaces.add((PackageableElement) theCopy);
        } else {
            newPackagedElements.add(theCopy);
        }
        return theCopy;
    }

    private static String normalize(final String referenceLibraryName, final EObject aPIMElement) {
        final StringBuilder theNormalizedName = new StringBuilder(getThePIMModelName(aPIMElement));
        final String[] segments = referenceLibraryName.split("-");
        for (final String segment : segments) {
            theNormalizedName.append(isTitleCase(segment) ? segment.toUpperCase() : capitalize(segment));
        }
        theNormalizedName.append("Subset");
        return theNormalizedName.toString();
    }

    private static String getThePIMModelName(final EObject aPIMElement) {
        return aPIMElement.eResource().getURI().trimFileExtension().lastSegment();
    }

    private static boolean isTitleCase(final String word) {
        return "niem".equalsIgnoreCase(word);
    }

    private void copyAttributes(final EObject source, final EObject target) {
        for (final EAttribute eAttribute : source.eClass().getEAllAttributes()) {
            if (canBeCopied(eAttribute)) {
                copyAttribute(eAttribute, source, target);
            }
        }
    }

    private void copyContainments(final EObject source, final EObject target) {
        for (final EReference eReference : source.eClass().getEAllReferences()) {
            if (canBeCopied(eReference)) {
                copyContainment(eReference, source, target);
            }
        }
    }

    @Override
    protected void copyContainment(final EReference eReference, final EObject eObject, final EObject copyEObject) {
        if (UMLPackage.Literals.CLASSIFIER.isInstance(eObject) && eObject.eIsSet(eReference) && eReference.isMany()
                && !((Collection<?>) eObject.eGet(eReference)).isEmpty()) {
            @SuppressWarnings("unchecked")
            final EList<EObject> source = (EList<EObject>) eObject.eGet(eReference);
            @SuppressWarnings("unchecked")
            final EList<EObject> target = (EList<EObject>) copyEObject.eGet(getTarget(eReference));
            target.addAll(copyAll(source));
            final Namespace original = (Namespace) eObject;
            ECollections.sort(target, new Comparator<EObject>() {
                @Override
                public int compare(final EObject left, final EObject right) {
                    return Integer.compare(indexOf(source, original.getOwnedMember(getName(left)), 0),
                            indexOf(source, original.getOwnedMember(getName(right)), 0));
                }
            });
        } else {
            super.copyContainment(eReference, eObject, copyEObject);
        }
    }

    private boolean canBeCopied(final EReference eReference) {
        return eReference.isContainment() && canBeCopied((EStructuralFeature) eReference);
    }

    private boolean canBeCopied(final EStructuralFeature eStructuralFeature) {
        return eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived() && !isPseudoDerived(eStructuralFeature);
    }

    private boolean isPseudoDerived(final EStructuralFeature eStructuralFeature) {
        return UMLPackage.Literals.INSTANCE_SPECIFICATION__CLASSIFIER.equals(eStructuralFeature);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Collection<T> copyAll(final Collection<? extends T> eObjects) {
        return (Collection<T>) super.copyAll(intersection(toMerge, eObjects));
    }

    private static <E> Collection<E> intersection(final Collection<? extends E> left, final Collection<? extends E> right) {
        final Collection<E> intersection = new LinkedHashSet<>();
        for (final E e : left) {
            if (right.contains(e)) {
                intersection.add(e);
            }
        }
        return intersection;
    }

}