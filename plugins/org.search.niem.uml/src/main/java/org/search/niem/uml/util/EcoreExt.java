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

import static java.util.Arrays.asList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.search.niem.uml.Activator;

public class EcoreExt {

    public static <T extends EObject> Collection<T> getObjectsByStrictType(final Collection<T> ts, final EClass type) {
        final Collection<T> result = new ArrayList<>();
        for (final T t : ts) {
            if (t.eClass() == type) {
                result.add(t);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> Collection<T> filterByType(final Collection<T> toFilter, final EClassifier type) {
        final Collection<T> filtered = new ArrayList<>();
        for (final Object t : toFilter) {
            if (!type.isInstance(t)) {
                filtered.add((T) t);
            }
        }
        return filtered;
    }

    public static EPackage getPackage(final EClass c) {
        return c == null ? null : c.getEPackage();
    }

    public static EClass getEClass(final EObject e) {
        return e == null ? null : e.eClass();
    }

    public static String getName(final ENamedElement e) {
        return get(EcorePackage.Literals.ENAMED_ELEMENT__NAME, e);
    }

    public static String getNsURI(final EObject e) {
        return get(EcorePackage.Literals.EPACKAGE__NS_URI, e);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(final EStructuralFeature f, final EObject e) {
        return f.getEContainingClass().isInstance(e) ? (T) e.eGet(f) : null;
    }

    public static <T> List<T> getMany(final EStructuralFeature f, final EObject e) {
        final List<T> l = get(f, e);
        return l == null ? Collections.<T> emptyList() : l;
    }

    @SuppressWarnings("unchecked")
    public static <T> T apply(final EOperation o, final EObject e, final Object... args) {
        try {
            return (T) (o.getEContainingClass().isInstance(e) ? e.eInvoke(o, new BasicEList<>(asList(args))) : null);
        } catch (final InvocationTargetException exception) {
            Activator.INSTANCE.log(exception);
            return null;
        }
    }

    public static <T> List<T> applyForMany(final EOperation o, final EObject e, final Object... args) {
        final List<T> l = apply(o, e, args);
        return l == null ? Collections.<T> emptyList() : l;
    }
}
