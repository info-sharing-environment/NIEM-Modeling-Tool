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
package org.search.niem.mpd.cat.util;

import static org.search.niem.uml.util.EcoreExt.get;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.search.niem.mpd.Activator;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.FileSetType;
import org.search.niem.mpd.cat.FileType;
import org.search.niem.mpd.cat.FolderType;

public class CatExt {
    public static String getTheMPDName(final Resource r) {
        final List<EObject> theContents = r.getContents();
        if (!theContents.isEmpty()) {
            final CatalogType theCatalog = getTheCatalog(theContents.get(0));
            return theCatalog == null ? null : theCatalog.getMpdName();
        }
        return null;
    }

    public static CatalogType getTheCatalog(final EObject theDocumentRoot) {
        return get(CatPackage.Literals.DOCUMENT_ROOT__CATALOG, theDocumentRoot);
    }

    public static boolean isACatalog(final File theFile) {
        if (!theFile.exists()) {
            return false;
        }
        try (InputStream in = new BufferedInputStream(new FileInputStream(theFile))) {
            final IContentType contentType = Platform.getContentTypeManager().findContentTypeFor(in, theFile.getName());
            return contentType != null && Activator.CONTENT_TYPE.equals(contentType.getId());
        } catch (final IOException e) {
            Activator.INSTANCE.log(e);
        }
        return false;
    }

    public static String[] getCatalogFileExtensions() {
        return Platform.getContentTypeManager().getContentType(Activator.CONTENT_TYPE)
                .getFileSpecs(IContentType.FILE_EXTENSION_SPEC);
    }

    public static void addCatalogFileSet(final CatalogType catalog, final FileSetType fileSet) {
        catalog.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, fileSet);
    }

    public static void addCatalogFolder(final CatalogType catalog, final FolderType folder) {
        catalog.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FOLDER, folder);
    }

    public static void addCatalogFile(final CatalogType catalog, final FileType file) {
        catalog.getArtifactGroup().add(CatPackage.Literals.DOCUMENT_ROOT__FILE, file);
    }
}
