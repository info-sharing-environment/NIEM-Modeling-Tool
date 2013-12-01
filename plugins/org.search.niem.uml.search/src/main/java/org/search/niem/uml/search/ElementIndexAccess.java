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

import static org.search.niem.uml.library.Activator.REFERENCE_LIBRARY_URI;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;

public abstract class ElementIndexAccess implements IndexAccess {

    protected static final String FIELD_RESOURCE = "RESOURCE";
    private static final String FIELD_ID = "ID";

    private final ResourceSet resourceSet;
    private File indexDirectory;
    private IndexWriter indexWriter;
    private final String indexLocation;

    protected ElementIndexAccess(final ResourceSet resourceSet, final String indexLocation) {
        this.resourceSet = resourceSet;
        this.indexLocation = indexLocation;
    }

    @Override
    public final ResourceSet getResourceSet() {
        return resourceSet;
    }

    @Override
    public final EObject fromDocument(final Document d) {
        return getResourceSet().getEObject(
                REFERENCE_LIBRARY_URI.appendSegment(d.get(FIELD_RESOURCE)).appendFragment(d.get(FIELD_ID)), true);
    }

    private File getIndexDirectory() {
        if (indexDirectory == null) {
            final File indexSubdirectory = new File(Activator.getPlugin().getStateLocation().toFile(), "index");
            indexDirectory = new File(indexSubdirectory, indexLocation);
        }
        return indexDirectory;
    }

    private Analyzer createAnalyzer() {
        return new StandardAnalyzer(VERSION);
    }

    private IndexWriter getIndexWriter() throws IOException {
        if (indexWriter == null) {
            final File theIndexDirectory = getIndexDirectory();
            theIndexDirectory.mkdirs();
            indexWriter = new IndexWriter(FSDirectory.open(theIndexDirectory), new IndexWriterConfig(IndexAccess.VERSION,
                    createAnalyzer()).setOpenMode(OpenMode.CREATE));
        }
        return indexWriter;
    }

    @Override
    public final void add(final Element e) throws IOException {
        if (shouldIndex(e)) {
            getIndexWriter().addDocument(toDocument(e));
        }
    }

    protected abstract boolean shouldIndex(EObject e);

    protected Document toDocument(final Element e) {
        final Document d = new Document();
        final URI uri = EcoreUtil.getURI(e);
        d.add(new Field(FIELD_RESOURCE, uri.lastSegment(), Store.YES, Index.NOT_ANALYZED));
        d.add(new Field(FIELD_ID, uri.fragment(), Store.YES, Index.NOT_ANALYZED));
        return d;
    }

    protected abstract Query parse(Criteria c);

    @Override
    public final boolean needsIndexing() {
        final File theIndexDirectory = getIndexDirectory();
        return !theIndexDirectory.exists() || theIndexDirectory.isFile()
                || !new File(theIndexDirectory, "segments_1").exists();
    }

    @Override
    public final Collection<Document> search(final Criteria criteria, final int maxResults) {
        try {
            return do_search(criteria, maxResults);
        } catch (final IOException e) {
            throw new IllegalStateException("Unable to perform search because index is inaccessible or corrupted.", e);
        }
    }

    private final Collection<Document> do_search(final Criteria criteria, final int maxResults)
            throws CorruptIndexException, IOException {
        try (final IndexReader reader = IndexReader.open(FSDirectory.open(getIndexDirectory()));
                final IndexSearcher searcher = new IndexSearcher(reader)) {
            final TopDocs hits = searcher.search(parse(criteria), maxResults);
            final ScoreDoc[] scoreDocs = hits.scoreDocs;
            final Collection<Document> matches = new LinkedHashSet<>();
            for (int n = 0; n < scoreDocs.length; ++n) {
                final ScoreDoc sd = scoreDocs[n];
                final int docId = sd.doc;
                final Document d = searcher.doc(docId);
                matches.add(d);
            }
            return matches;
        }
    }

    @Override
    public final void close() throws IOException {
        if (indexWriter != null) {
            indexWriter.close();
        }
    }
}
