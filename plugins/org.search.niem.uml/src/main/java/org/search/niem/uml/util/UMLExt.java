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
package org.search.niem.uml.util;

import static org.eclipse.uml2.common.util.UML2Util.getValidJavaIdentifier;
import static org.eclipse.uml2.uml.util.UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI;
import static org.eclipse.uml2.uml.util.UMLUtil.getBaseElement;
import static org.eclipse.uml2.uml.util.UMLUtil.getStereotype;
import static org.search.niem.uml.util.EcoreExt.apply;
import static org.search.niem.uml.util.EcoreExt.applyForMany;
import static org.search.niem.uml.util.EcoreExt.get;
import static org.search.niem.uml.util.EcoreExt.getMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLExt {

    public static Collection<Element> collectOwnedElementsAndRelationships(final Iterable<? extends EObject> elements) {
        final Collection<Element> ownedElementsAndRelationships = new HashSet<>();
        for (final EObject element : elements) {
            ownedElementsAndRelationships.addAll(collectOwnedElementsAndRelationships(element));
        }
        return ownedElementsAndRelationships;
    }

    public static Collection<Element> collectOwnedElementsAndRelationships(final EObject element) {
        final Collection<Element> ownedElements = getOwnedAndTypedElements(element);
        final Collection<Element> ownedElementsAndRelationships = new ArrayList<>(ownedElements);
        ownedElementsAndRelationships.addAll(getRelationships(element, UMLPackage.Literals.GENERALIZATION));
        ownedElementsAndRelationships.addAll(getRelationships(element, UMLPackage.Literals.REALIZATION));
        for (final Element ownedElement : ownedElements) {
            ownedElementsAndRelationships.addAll(getRelationships(ownedElement, UMLPackage.Literals.REALIZATION));
            ownedElementsAndRelationships.addAll(getRelationships(ownedElement, UMLPackage.Literals.ASSOCIATION));
        }
        return ownedElementsAndRelationships;
    }

    private static Collection<Element> getOwnedAndTypedElements(final EObject eObject) {
        final Collection<Element> ownedAndTypedElements = new LinkedHashSet<>(getOwnedElements(eObject));
        final Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
        for (final Setting s : settings) {
            if (s.getEStructuralFeature() == UMLPackage.Literals.TYPED_ELEMENT__TYPE) {
                ownedAndTypedElements.add((Element) s.getEObject());
            }
        }
        return ownedAndTypedElements;
    }

    public static boolean isStereotypeApplication(final EObject e) {
        return getStereotype(e) != null;
    }

    public static String getBody(final EObject e) {
        return get(UMLPackage.Literals.COMMENT__BODY, e);
    }

    public static Type getType(final EObject e) {
        return get(UMLPackage.Literals.TYPED_ELEMENT__TYPE, e);
    }

    public static List<Element> getOwnedElements(final EObject e) {
        return getMany(UMLPackage.Literals.ELEMENT__OWNED_ELEMENT, e);
    }

    public static List<Property> getOwnedAttributes(final EObject e) {
        return getMany(UMLPackage.Literals.DATA_TYPE.isInstance(e) ? UMLPackage.Literals.DATA_TYPE__OWNED_ATTRIBUTE
                : UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE, e);
    }

    public static List<Generalization> getGeneralizations(final EObject e) {
        return getMany(UMLPackage.Literals.CLASSIFIER__GENERALIZATION, e);
    }

    public static List<NamedElement> getClients(final EObject e) {
        return getMany(UMLPackage.Literals.DEPENDENCY__CLIENT, e);
    }

    public static List<NamedElement> getSuppliers(final EObject e) {
        return getMany(UMLPackage.Literals.DEPENDENCY__SUPPLIER, e);
    }

    public static Classifier getGeneral(final EObject e) {
        return get(UMLPackage.Literals.GENERALIZATION__GENERAL, e);
    }

    public static Classifier getSpecific(final EObject e) {
        return get(UMLPackage.Literals.GENERALIZATION__SPECIFIC, e);
    }

    public static void setName(final EObject e, final String name) {
        e.eSet(UMLPackage.Literals.NAMED_ELEMENT__NAME, name);
    }

    public static String getName(final EObject e) {
        return get(UMLPackage.Literals.NAMED_ELEMENT__NAME, e);
    }

    public static String getQualifiedName(final EObject e) {
        return get(UMLPackage.Literals.NAMED_ELEMENT__QUALIFIED_NAME, e);
    }

    public static <T extends Element> T getOwner(final EObject e) {
        return get(UMLPackage.Literals.ELEMENT__OWNER, e);
    }

    public static List<Property> getMemberEnds(final EObject e) {
        return getMany(UMLPackage.Literals.ASSOCIATION__MEMBER_END, e);
    }

    public static Package getNearestPackage(final EObject e) {
        return apply(UMLPackage.Literals.ELEMENT___GET_NEAREST_PACKAGE, e);
    }

    public static Collection<Package> getNestedPackages(final EObject e) {
        return applyForMany(UMLPackage.Literals.PACKAGE___GET_NESTED_PACKAGES, e);
    }

    public static Collection<PackageableElement> getPackagedElements(final EObject e) {
        final Collection<PackageableElement> packagedElements = getMany(UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, e);
        return packagedElements.isEmpty() ? EcoreExt.<PackageableElement> getMany(
                UMLPackage.Literals.COMPONENT__PACKAGED_ELEMENT, e) : packagedElements;
    }

    public static Collection<Stereotype> getAppliedStereotypes(final EObject e) {
        return applyForMany(UMLPackage.Literals.ELEMENT___GET_APPLIED_STEREOTYPES, e);
    }

    public static List<Relationship> getRelationships(final EObject e, final EClass type) {
        return applyForMany(UMLPackage.Literals.ELEMENT___GET_RELATIONSHIPS__ECLASS, e, type);
    }

    public static void remove(final Element element) {
        final Collection<EObject> theStereotypeApplications = new ArrayList<>();
        theStereotypeApplications.addAll(element.getStereotypeApplications());
        final TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(element, true);
        while (contents.hasNext()) {
            final EObject next = contents.next();
            if (next instanceof Element) {
                theStereotypeApplications.addAll(((Element) next).getStereotypeApplications());
            }
        }
        for (final EObject theStereotypeApplication : theStereotypeApplications) {
            getBaseElement(theStereotypeApplication).unapplyStereotype(getStereotype(theStereotypeApplication));
        }
        getMany(UMLPackage.Literals.ENUMERATION__OWNED_LITERAL,
                EcoreExt.<Enumeration> get(UMLPackage.Literals.ENUMERATION_LITERAL__ENUMERATION, element)).remove(element);
        element.destroy();
    }

    public static void copyAttributes(final EObject from, final EObject to) {
        final Map<String, EStructuralFeature> featureNames2Features = new HashMap<>();
        for (final EStructuralFeature eStructuralFeature : from.eClass().getEAllStructuralFeatures()) {
            final String featureName = eStructuralFeature.getName();
            if (!featureName.startsWith(Extension.METACLASS_ROLE_PREFIX)) {
                featureNames2Features.put(featureName, eStructuralFeature);
            }
        }
        for (final Entry<String, EStructuralFeature> e : featureNames2Features.entrySet()) {
            final EStructuralFeature targetFeature = to.eClass().getEStructuralFeature(e.getKey());
            if (targetFeature != null) {
                to.eSet(targetFeature, from.eGet(e.getValue()));
            }
        }
    }

    public static <T> T getStereotypeValue(final EObject stereotypeApplication, final String property) {
        return getStereotypeValue(stereotypeApplication, property, false);
    }

    /**
     * Copied from {@link org.eclipse.uml2.uml.internal.operations.ElementOperations#getValue(Element, Stereotype, String)}
     */
    @SuppressWarnings({ "restriction", "unchecked" })
    public static <T> T getStereotypeValue(EObject stereotypeApplication, final String property, final boolean checkIfSet) {
        EClass eClass = stereotypeApplication.eClass();
        final String[] segments = property.split(NamedElement.SEPARATOR);

        for (int i = 0, length = segments.length; i < length; i++) {
            final String segment = segments[i];
            EStructuralFeature eStructuralFeature = null;
            int index = -1;

            if (segment.indexOf('[') == -1) {
                eStructuralFeature = eClass.getEStructuralFeature(getValidJavaIdentifier(segment));
            } else {
                eStructuralFeature = eClass.getEStructuralFeature(getValidJavaIdentifier(segment.substring(0,
                        segment.indexOf('['))));

                try {
                    index = Integer.parseInt(segment.substring(segment.indexOf('[') + 1, segment.indexOf(']')));
                } catch (final Exception e) {
                    throw new IllegalArgumentException(String.valueOf(property));
                }
            }

            if (eStructuralFeature == null) {
                throw new IllegalArgumentException(String.valueOf(property));
            }

            final EClassifier eType = eStructuralFeature.getEType();

            if (i + 1 < length) {

                if (stereotypeApplication == null || !(eType instanceof EClass)) {

                    throw new IllegalArgumentException(String.valueOf(property));
                }

                eClass = (EClass) eType;

                if (eStructuralFeature.isMany()) {
                    final List<EObject> list = (List<EObject>) stereotypeApplication.eGet(eStructuralFeature);
                    stereotypeApplication = list.get(index);
                } else {
                    stereotypeApplication = (EObject) stereotypeApplication.eGet(eStructuralFeature);
                }
            } else {
                Object value = null;

                if (eStructuralFeature.isMany()) {
                    final List<Object> list = stereotypeApplication == null ? Collections.emptyList()
                            : (List<Object>) stereotypeApplication.eGet(eStructuralFeature);

                    value = index == -1 ? list : list.get(index);
                } else if (stereotypeApplication == null) {
                    value = eStructuralFeature.getDefaultValue();
                } else if (!checkIfSet || stereotypeApplication.eIsSet(eStructuralFeature)) {
                    value = stereotypeApplication.eGet(eStructuralFeature);
                }

                if (eType instanceof EEnum && value instanceof EEnumLiteral) {
                    final EAnnotation eAnnotation = eType.getEAnnotation(UML2_UML_PACKAGE_2_0_NS_URI);

                    if (eAnnotation != null) {
                        final EList<EObject> references = eAnnotation.getReferences();

                        if (references.size() > 0) {
                            final Object reference = references.get(0);

                            if (reference instanceof Enumeration) {
                                value = ((Enumeration) reference).getOwnedLiteral(((EEnumLiteral) value).getName());
                            }
                        }
                    }
                }

                return (T) value;
            }
        }

        return null;
    }

    /**
     * Copied from
     * {@link org.eclipse.uml2.uml.internal.operations.ElementOperations#setValue(Element, Stereotype, String, Object)}
     */
    @SuppressWarnings("restriction")
    public static void setStereotypeValue(EObject stereotypeApplication, final String property, Object newValue) {

        EClass eClass = stereotypeApplication.eClass();
        final String[] segments = property.split(NamedElement.SEPARATOR);

        for (int i = 0, length = segments.length; i < length; i++) {
            final String segment = segments[i];
            EStructuralFeature eStructuralFeature = null;
            int index = -1;

            if (segment.indexOf('[') == -1) {
                eStructuralFeature = eClass.getEStructuralFeature(getValidJavaIdentifier(segment));
            } else {
                eStructuralFeature = eClass.getEStructuralFeature(getValidJavaIdentifier(segment.substring(0,
                        segment.indexOf('['))));

                try {
                    index = Integer.parseInt(segment.substring(segment.indexOf('[') + 1, segment.indexOf(']')));
                } catch (final Exception e) {
                    throw new IllegalArgumentException(String.valueOf(property));
                }
            }

            if (eStructuralFeature == null) {
                throw new IllegalArgumentException(String.valueOf(property));
            }

            final EClassifier eType = eStructuralFeature.getEType();

            if (i + 1 < length) {

                if (!(eType instanceof EClass)) {
                    throw new IllegalArgumentException(String.valueOf(property));
                }

                eClass = (EClass) eType;

                if (eStructuralFeature.isMany()) {
                    @SuppressWarnings("unchecked")
                    final List<Object> list = (List<Object>) stereotypeApplication.eGet(eStructuralFeature);
                    final int size = list.size();

                    if (size <= index) {

                        if (!((EReference) eStructuralFeature).isContainment()) {
                            throw new IllegalArgumentException(String.valueOf(property));
                        }

                        for (int j = size; j <= index; j++) {
                            list.add(j, EcoreUtil.create(eClass));
                        }
                    }

                    stereotypeApplication = (EObject) list.get(index);
                } else {
                    Object value = stereotypeApplication.eGet(eStructuralFeature);

                    if (value == null) {

                        if (!((EReference) eStructuralFeature).isContainment()) {
                            throw new IllegalArgumentException(String.valueOf(property));
                        }

                        stereotypeApplication.eSet(eStructuralFeature, value = EcoreUtil.create(eClass));
                    }

                    stereotypeApplication = (EObject) value;
                }
            } else {

                if (newValue != null) {

                    if (eType instanceof EClass) {
                        final EClass eClassType = (EClass) eType;

                        if (newValue instanceof List<?>) {
                            @SuppressWarnings("unchecked")
                            final Iterator<Object> j = ((List<Object>) newValue).iterator();

                            while (j.hasNext()) {

                                if (!eClassType.isInstance(j.next())) {
                                    throw new IllegalArgumentException(String.valueOf(newValue));
                                }
                            }
                        } else if (!eClassType.isInstance(newValue)) {
                            throw new IllegalArgumentException(String.valueOf(newValue));
                        }
                    } else if (eType instanceof EDataType) {
                        final EDataType eDataType = (EDataType) eType;
                        final EFactory eFactoryInstance = eDataType.getEPackage().getEFactoryInstance();

                        if (newValue instanceof List<?>) {
                            @SuppressWarnings("unchecked")
                            final List<Object> newList = new ArrayList<Object>((List<Object>) newValue);

                            if (eDataType instanceof EEnum) {
                                final EEnum eEnum = (EEnum) eDataType;

                                for (final ListIterator<Object> li = newList.listIterator(); li.hasNext();) {

                                    final Object item = li.next();

                                    if (item instanceof EnumerationLiteral) {
                                        li.set(eEnum.getEEnumLiteral(((EnumerationLiteral) item).getName()).getInstance());
                                    }
                                }
                            }

                            for (final ListIterator<Object> li = newList.listIterator(); li.hasNext();) {

                                final Object item = li.next();

                                if (item instanceof String) {

                                    try {
                                        li.set(eFactoryInstance.createFromString(eDataType, (String) item));
                                    } catch (final Exception e) {
                                        // ignore
                                    }
                                }
                            }

                            newValue = newList;
                        } else {

                            if (eDataType instanceof EEnum) {
                                final EEnum eEnum = (EEnum) eDataType;

                                if (newValue instanceof EnumerationLiteral) {
                                    newValue = eEnum.getEEnumLiteral(((EnumerationLiteral) newValue).getName())
                                            .getInstance();
                                }
                            }

                            if (newValue instanceof String) {

                                try {
                                    newValue = eFactoryInstance.createFromString(eDataType, (String) newValue);
                                } catch (final Exception e) {
                                    // ignore
                                }
                            }
                        }
                    }
                }

                if (newValue == null) {
                    newValue = eStructuralFeature.getDefaultValue();
                }

                if (eStructuralFeature.isMany()) {

                    if (index == -1) {

                        if (newValue instanceof List<?>) {
                            stereotypeApplication.eSet(eStructuralFeature, newValue);
                        } else {
                            throw new IllegalArgumentException(String.valueOf(newValue));
                        }
                    } else {
                        @SuppressWarnings("unchecked")
                        final List<Object> list = (List<Object>) stereotypeApplication.eGet(eStructuralFeature);

                        for (int j = list.size(); j < index; j++) {
                            list.add(j, eStructuralFeature.getDefaultValue());
                        }

                        if (index == list.size()) {
                            list.add(index, newValue);
                        } else {
                            list.set(index, newValue);
                        }
                    }

                } else {
                    stereotypeApplication.eSet(eStructuralFeature, newValue);
                }
            }
        }
    }
}
