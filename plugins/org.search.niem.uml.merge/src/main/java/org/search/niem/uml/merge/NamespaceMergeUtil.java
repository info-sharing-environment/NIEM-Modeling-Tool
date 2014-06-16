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

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.uml2.uml.util.UMLUtil.findNamedElements;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.search.niem.uml.util.CollectionExt.allAreNull;
import static org.search.niem.uml.util.CollectionExt.anyIsNull;
import static org.search.niem.uml.util.EcoreExt.get;
import static org.search.niem.uml.util.EcoreExt.getEClass;
import static org.search.niem.uml.util.EcoreExt.getNsURI;
import static org.search.niem.uml.util.EcoreExt.getPackage;
import static org.search.niem.uml.util.NIEMUmlExt.findNearestNiemNamespacePackage;
import static org.search.niem.uml.util.NIEMUmlExt.getTargetNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.isNiemNamespace;
import static org.search.niem.uml.util.NIEMUmlExt.isXmlPrimitiveType;
import static org.search.niem.uml.util.NIEMUmlExt.namesMatch;
import static org.search.niem.uml.util.UMLExt.getBody;
import static org.search.niem.uml.util.UMLExt.getClients;
import static org.search.niem.uml.util.UMLExt.getGeneral;
import static org.search.niem.uml.util.UMLExt.getMemberEnds;
import static org.search.niem.uml.util.UMLExt.getName;
import static org.search.niem.uml.util.UMLExt.getOwner;
import static org.search.niem.uml.util.UMLExt.getSuppliers;
import static org.search.niem.uml.util.UMLExt.getType;
import static org.search.niem.uml.util.UMLExt.isStereotypeApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.search.niem.uml.util.EcoreExt;
import org.search.niem.uml.util.UMLExt;

public class NamespaceMergeUtil {
    public static Collection<Element> mapEquivalents(final Collection<EObject> referenceLibraryElements,
            final Package inThePIM) {
        final Collection<Element> pimEquivalents = new ArrayList<>();

        Namespace theCurrentOwner = null;
        Namespace theEquivalentOwnerInThePIM = null;
        for (final EObject visibleElement : referenceLibraryElements) {
            final Namespace theOwner = getOwner(visibleElement);
            if (theOwner != theCurrentOwner) {
                theCurrentOwner = theOwner;
                theEquivalentOwnerInThePIM = findEquivalent(theOwner, inThePIM);
            }
            if (theEquivalentOwnerInThePIM == null) {
                continue;
            }
            final NamedElement theElement = theEquivalentOwnerInThePIM.getMember(getName(visibleElement), false,
                    getEClass(visibleElement));
            if (theElement != null) {
                pimEquivalents.add(theElement);
            }
        }

        return pimEquivalents;
    }

    public static <T extends EObject> T findEquivalent(final T referenceLibraryElement, final Package inThePIM) {
        if (referenceLibraryElement == null) {
            return null;
        }
        if (isStereotypeApplication(referenceLibraryElement)) {
            @SuppressWarnings("unchecked")
            final T equivalentStereotypeApplication = (T) findEquivalentStereotypeApplication(referenceLibraryElement,
                    inThePIM);
            return equivalentStereotypeApplication;
        }
        if (!isBlank(UMLExt.getName(referenceLibraryElement))) {
            final NamedElement ne = (NamedElement) referenceLibraryElement;
            if (theNameIsUnique(ne)) {
                return findEquivalentNamedElement(ne, inThePIM);
            }
        }
        final EObject inTheEquivalentParent = findEquivalent(getOwner(referenceLibraryElement), inThePIM);
        if (inTheEquivalentParent == null) {
            return null;
        }
        return findImmediatelyContainedEquivalent(referenceLibraryElement, inTheEquivalentParent, inThePIM);
    }

    private static <T extends EObject> T findEquivalentNamedElement(final NamedElement referenceLibraryElement,
            final Package inThePIM) {
        // first find the target namespace of the referenceLibraryElement
        final Package namespaceInTheReferenceLibrary = findNearestNiemNamespacePackage(referenceLibraryElement
                .getNearestPackage());
        if (namespaceInTheReferenceLibrary == null) {
            return null;
        }
        // find the Package with the same targetNamespace in the PIM
        final Package namespaceInThePIM = findPackageWithTargetNamespace(inThePIM,
                getTargetNamespace(namespaceInTheReferenceLibrary));
        if (namespaceInThePIM == null) {
            return null;
        }
        final LinkedList<Element> pathToReferenceLibraryElement = new LinkedList<>();
        NamedElement next = referenceLibraryElement;
        while (next != namespaceInTheReferenceLibrary) {
            pathToReferenceLibraryElement.addFirst(next);
            next = next.getNamespace();
        }
        return findNamedElement(namespaceInThePIM, pathToReferenceLibraryElement);
    }

    public static Element findMatching(final EObject referenceLibraryElement, final Element inTheNamespace) {
        for (final Element member : EcoreUtil.<Element> getObjectsByType(inTheNamespace.getOwnedElements(),
                referenceLibraryElement.eClass())) {
            if (namesMatch(referenceLibraryElement, member)) {
                return member;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static <T extends EObject> T findNamedElement(final Package inTheNamespace, final Iterable<Element> withThePath) {
        // foreach path element, look for an element in the namespace with either a matching NIEMName, a matching name or, if
        // the path element ends with 'Type', the name without the 'Type' suffix
        Element nextNamespaceElement = inTheNamespace;
        for (final Element nextPathElement : withThePath) {
            final Element match = findMatching(nextPathElement, nextNamespaceElement);
            if (match == null) {
                return null;
            }
            nextNamespaceElement = match;
        }
        return (T) nextNamespaceElement;
    }

    private static Package findPackageWithTargetNamespace(final Package inThePackage, final String targetNamespace) {
        if (isNiemNamespace(inThePackage) && areEqual(getTargetNamespace(inThePackage), targetNamespace)) {
            return inThePackage;
        }
        for (final Package p : inThePackage.getNestedPackages()) {
            final Package packageWithTargetNamespace = findPackageWithTargetNamespace(p, targetNamespace);
            if (packageWithTargetNamespace != null) {
                return packageWithTargetNamespace;
            }
        }
        return null;
    }

    private static EObject findEquivalentStereotypeApplication(final EObject referenceLibraryElement, final Package inThePIM) {
        final Element pimEquivalentBaseElement = findEquivalent(getBaseElement(referenceLibraryElement), inThePIM);
        if (pimEquivalentBaseElement == null) {
            return null;
        }
        final Collection<EObject> equivalencies = new ArrayList<>();
        for (final EObject pimStereotypeApplication : pimEquivalentBaseElement.getStereotypeApplications()) {
            if (classesAreTheSame(referenceLibraryElement, pimStereotypeApplication)) {
                equivalencies.add(pimStereotypeApplication);
            }
        }
        if (equivalencies.isEmpty()) {
            return null;
        }
        if (equivalencies.size() > 1) {
            Activator.INSTANCE.log("Ambiguous matches found for stereotype application " + referenceLibraryElement);
        }
        return equivalencies.iterator().next();
    }

    private static <T extends EObject> T findEquivalent(final T referenceLibraryElement,
            final Collection<T> inThePIMContents, final Package inThePIM) {
        final Collection<T> equivalencies = new ArrayList<>();
        for (final T aPIMElement : EcoreUtil.<T> getObjectsByType(inThePIMContents, referenceLibraryElement.eClass())) {
            if (areEquivalent(referenceLibraryElement, aPIMElement, inThePIM)) {
                equivalencies.add(aPIMElement);
            }
        }
        if (equivalencies.isEmpty()) {
            return null;
        }
        if (equivalencies.size() > 1) {
            Activator.INSTANCE.log("Ambiguous matches found for element " + referenceLibraryElement);
        }
        return equivalencies.iterator().next();
    }

    private static <T extends EObject> T findImmediatelyContainedEquivalent(final T referenceLibraryElement,
            final EObject inThePIMElement, final Package inThePIM) {
        final EStructuralFeature feature = referenceLibraryElement.eContainingFeature();
        if (!inThePIMElement.eIsSet(feature)) {
            return null;
        }
        if (feature.isMany()) {
            return findEquivalent(referenceLibraryElement, EcoreExt.<T> getMany(feature, inThePIMElement), inThePIM);
        }
        final T child = get(feature, inThePIMElement);
        if (areEquivalent(referenceLibraryElement, child, inThePIM)) {
            return child;
        }
        return null;
    }

    private static boolean areEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        /* @formatter:off */
        return allAreNull(aReferenceLibraryElement, aPIMElement) ||
                !anyIsNull(aReferenceLibraryElement, aPIMElement)
                && classesAreTheSame(aReferenceLibraryElement, aPIMElement)
                && namesAreTheSame(aReferenceLibraryElement, aPIMElement)
                && bodiesAreTheSame(aReferenceLibraryElement, aPIMElement)
                && typesAreEquivalent(aReferenceLibraryElement, aPIMElement, inThePIM)
                && memberEndsAreEquivalent(aReferenceLibraryElement, aPIMElement, inThePIM)
                && clientsAreEquivalent(aReferenceLibraryElement, aPIMElement, inThePIM)
                && suppliersAreEquivalent(aReferenceLibraryElement, aPIMElement, inThePIM)
                && generalsAreEquivalent(aReferenceLibraryElement, aPIMElement, inThePIM);
        /* @formatter:on */
    }

    private static boolean generalsAreEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        final Classifier referenceLibraryGeneral = getGeneral(aReferenceLibraryElement);
        final Classifier pimElementGeneral = getGeneral(aPIMElement);
        return isXmlPrimitiveType(referenceLibraryGeneral) ? areEqual(UMLExt.getName(referenceLibraryGeneral),
                UMLExt.getName(pimElementGeneral)) : findEquivalent(referenceLibraryGeneral, inThePIM) == pimElementGeneral;
    }

    private static boolean clientsAreEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        final List<NamedElement> referenceLibraryClients = getClients(aReferenceLibraryElement);
        final List<NamedElement> pimClients = getClients(aPIMElement);
        if (referenceLibraryClients.size() != pimClients.size()) {
            return false;
        }
        for (int i = 0; i < referenceLibraryClients.size(); i++) {
            if (findEquivalent(referenceLibraryClients.get(i), inThePIM) != pimClients.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean suppliersAreEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        final List<NamedElement> referenceLibrarySuppliers = getSuppliers(aReferenceLibraryElement);
        final List<NamedElement> pimSuppliers = getSuppliers(aPIMElement);
        if (referenceLibrarySuppliers.size() != pimSuppliers.size()) {
            return false;
        }
        for (int i = 0; i < referenceLibrarySuppliers.size(); i++) {
            if (findEquivalent(referenceLibrarySuppliers.get(i), inThePIM) != pimSuppliers.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean memberEndsAreEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        final List<Property> referenceLibraryMemberEnds = getMemberEnds(aReferenceLibraryElement);
        final List<Property> pimMemberEnds = getMemberEnds(aPIMElement);
        if (referenceLibraryMemberEnds.size() != pimMemberEnds.size()) {
            return false;
        }
        for (int i = 0; i < referenceLibraryMemberEnds.size(); i++) {
            if (!areEquivalent(referenceLibraryMemberEnds.get(i), pimMemberEnds.get(i), inThePIM)) {
                return false;
            }
        }
        return true;
    }

    private static boolean typesAreEquivalent(final EObject aReferenceLibraryElement, final EObject aPIMElement,
            final Package inThePIM) {
        final Type referenceLibraryType = getType(aReferenceLibraryElement);
        final Type pimType = getType(aPIMElement);
        return isXmlPrimitiveType(referenceLibraryType) ? areEqual(UMLExt.getName(referenceLibraryType),
                UMLExt.getName(pimType)) : findEquivalent(referenceLibraryType, inThePIM) == pimType;
    }

    private static boolean bodiesAreTheSame(final EObject left, final EObject right) {
        return ObjectUtils.equals(getBody(left), getBody(right));
    }

    private static boolean classesAreTheSame(final EObject left, final EObject right) {
        final EClass leftClass = getEClass(left);
        final EClass rightClass = getEClass(right);
        return areEqual(EcoreExt.getName(leftClass), EcoreExt.getName(rightClass))
                && packagesAreTheSame(getPackage(leftClass), getPackage(rightClass));
    }

    private static boolean packagesAreTheSame(final EPackage left, final EPackage right) {
        return areEqual(EcoreExt.getName(left), EcoreExt.getName(right)) && areEqual(getNsURI(left), getNsURI(right));
    }

    private static boolean namesAreTheSame(final EObject aReferenceLibraryElement, final EObject aPIMElement) {
        if (isNiemNamespace(aReferenceLibraryElement) && isNiemNamespace(aPIMElement)) {
            return areEqual(getTargetNamespace((Element) aReferenceLibraryElement),
                    getTargetNamespace((Element) aPIMElement));
        }
        return namesMatch(aReferenceLibraryElement, aPIMElement);
    }

    private static boolean areEqual(final Object left, final Object right) {
        return ObjectUtils.equals(left, right);
    }

    private static boolean theNameIsUnique(final NamedElement e) {
        return findNamedElements(e.eResource(), e.getQualifiedName()).size() == 1;
    }
}
