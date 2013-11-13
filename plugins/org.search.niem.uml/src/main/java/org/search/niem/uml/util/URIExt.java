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

import static org.eclipse.core.runtime.URIUtil.makeRelative;
import static org.eclipse.emf.common.util.URI.decode;
import static org.eclipse.emf.common.util.URI.encodeOpaquePart;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class URIExt {
    public static URI appendPath(final URI base, final String path) {
        final String[] segments = path.split("/");
        URI schemaURI = base;
        for (final String segment : segments) {
            if (!".".equals(segment)) {
                schemaURI = schemaURI.appendSegment(segment);
            }
        }
        return schemaURI;
    }

    public static File toFile(final URI uri) {
        if (uri.isPlatformResource()) {
            return toIFile(uri).getLocation().toFile();
        }
        if (uri.isFile()) {
            return new File(uri.toFileString());
        }
        return null;
    }

    public static IFile toIFile(final URI uri) {
        return getWorkspaceRoot().getFile(toIPath(uri));
    }

    public static IFolder toIFolder(final URI uri) {
        return getWorkspaceRoot().getFolder(toIPath(uri));
    }

    private static IPath toIPath(final URI uri) {
        return Path.fromPortableString(uri.toPlatformString(true));
    }

    private static IWorkspaceRoot getWorkspaceRoot() {
        return ResourcesPlugin.getWorkspace().getRoot();
    }

    private static String relativize(final File from, final File to) {
        return decode(makeRelative(to.toURI(), from.toURI()).toString());
    }

    public static String relativize(final URI from, final URI to) {
        return relativize(toFile(from), toFile(to));
    }

    public static String encode(final String s) {
        return encodeOpaquePart(s, false);
    }
}