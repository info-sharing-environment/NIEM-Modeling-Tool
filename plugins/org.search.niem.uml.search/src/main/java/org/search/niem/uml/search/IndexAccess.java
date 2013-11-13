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
package org.search.niem.uml.search;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

import org.apache.lucene.document.Document;
import org.apache.lucene.util.Version;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Element;

interface IndexAccess extends Closeable {

    Version VERSION = Version.LUCENE_35;

    ResourceSet getResourceSet();

    EObject fromDocument(final Document d);

    void add(Element e) throws IOException;

    boolean needsIndexing();

    Collection<Document> search(Criteria criteria, int maxResults) throws IOException;
}
