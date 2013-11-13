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
package org.search.niem.uml.papyrus.views.properties.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.search.niem.uml.papyrus.views.properties.Activator;

public class JavaExt {

    @SuppressWarnings("unchecked")
    public static <T> T get(final String fieldNamed, final Object from) {
        return (T) (fieldNamed == null || from == null ? null : get(fieldNamed, from, from.getClass()));
    }

    private static Object get(final String fieldNamed, final Object from, final Class<?> type) {
        if (type == null) {
            return null;
        }
        for (final Field f : type.getDeclaredFields()) {
            if (fieldNamed.equals(f.getName())) {
                try {
                    f.setAccessible(true);
                    return f.get(from);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    Activator.INSTANCE.log(e);
                }
            }
        }
        return get(fieldNamed, from, type.getSuperclass());
    }

    public static <T> T get(final Class<T> fieldOfType, final Object from) {
        return fieldOfType == null || from == null ? null : get(fieldOfType, from, from.getClass());
    }

    @SuppressWarnings("unchecked")
    private static <T> T get(final Class<T> fieldOfType, final Object from, final Class<?> type) {
        if (type == null) {
            return null;
        }
        for (final Field f : type.getDeclaredFields()) {
            if (fieldOfType.isAssignableFrom(f.getType())) {
                try {
                    f.setAccessible(true);
                    return (T) f.get(from);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    Activator.INSTANCE.log(e);
                }
            }
        }
        return get(fieldOfType, from, type.getSuperclass());
    }

    public static boolean isInnerType(final Object o, final Class<?> outerType) {
        return o.getClass().getName().matches(outerType.getName().replaceAll("\\.", "\\.").concat(".*"));
    }

    public static <T> T call(final String method, final Object on) {
        @SuppressWarnings("unchecked")
        final T t = (T) (method == null || on == null ? null : call(method, on, on.getClass()));
        return t;
    }

    private static <T> T call(final String method, final Object on, final Class<?> type) {
        if (type == null) {
            return null;
        }
        try {
            final Method m = type.getDeclaredMethod(method);
            m.setAccessible(true);
            @SuppressWarnings("unchecked")
            final T t = (T) m.invoke(on);
            return t;
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | SecurityException
                | NoSuchMethodException e) {
            Activator.INSTANCE.log(e);
        }
        return call(method, on, type.getSuperclass());
    }
}
