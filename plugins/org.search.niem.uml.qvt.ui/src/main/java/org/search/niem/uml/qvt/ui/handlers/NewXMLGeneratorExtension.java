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
package org.search.niem.uml.qvt.ui.handlers;

import static org.apache.commons.io.IOUtils.closeQuietly;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilder.BUILD_FIRST_CHOICE;
import static org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilder.BUILD_FIRST_SUBSTITUTION;
import static org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilder.BUILD_OPTIONAL_ELEMENTS;
import static org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilder.BUILD_TEXT_NODES;
import static org.search.niem.uml.util.URIExt.encode;
import static org.search.niem.uml.util.URIExt.relativize;
import static org.search.niem.uml.util.URIExt.toFile;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.wst.xml.core.internal.contentmodel.CMDocument;
import org.eclipse.wst.xml.core.internal.contentmodel.CMElementDeclaration;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMContentBuilderImpl;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMWriter;
import org.eclipse.wst.xml.core.internal.contentmodel.util.NamespaceInfo;
import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Unfortunately, this is not easily testable since this class relies heavily on platform resource URIs.
 */
@SuppressWarnings("restriction")
class NewXMLGeneratorExtension extends org.eclipse.wst.xml.ui.internal.wizards.NewXMLGenerator {

    private static final String PLATFORM_RESOURCE = "platform:/resource";

    private final XSDSchema theSchema;
    private final String root;
    protected final URI xmlURI;

    public NewXMLGeneratorExtension(final XSDSchema theSchema, final URI xmlURI, final String root) {
        this.xmlURI = xmlURI;
        this.theSchema = theSchema;
        this.root = root;
    }

    public Resource generateSample() {
        final String theGrammarFile = PLATFORM_RESOURCE + theSchema.eResource().getURI().toPlatformString(true);
        final CMDocument cmDocument = createCMDocument(theGrammarFile, new String[2]);
        setGrammarURI(theGrammarFile);
        setCMDocument(cmDocument);
        setRootElementName(root);
        setBuildPolicy(BUILD_OPTIONAL_ELEMENTS | BUILD_FIRST_CHOICE | BUILD_FIRST_SUBSTITUTION | BUILD_TEXT_NODES);
        // setOptionalElementDepthLimit(-1);
        createNamespaceInfoList();
        resolveSchemaLocations();
        try {
            this.createXMLDocument(toFile(xmlURI).getPath());
        } catch (final Exception e) {
            throw new RuntimeException("Failed to create the XML resource.", e);
        }
        return new XMLResourceImpl(xmlURI);
    }

    private void resolveSchemaLocations() {
        for (final Object o : namespaceInfoList) {
            final NamespaceInfo info = (NamespaceInfo) o;
            if (isBlank(info.locationHint)) {
                info.locationHint = findLocation(info.uri);
            }
        }
    }

    private String findLocation(final String theNamespace) {
        if (theSchema.getTargetNamespace().equals(theNamespace)) {
            return encode(relativize(xmlURI.trimSegments(1), theSchema.eResource().getURI()));
        }
        for (final XSDImport i : EcoreUtil.<XSDImport> getObjectsByType(theSchema.getContents(),
                XSDPackage.Literals.XSD_IMPORT)) {
            if (i.getNamespace().equals(theNamespace)) {
                return "../" + encode(i.getSchemaLocation().replaceFirst("^\\./", ""));
            }
        }
        return null;
    }

    @Override
    public ByteArrayOutputStream createXMLDocument(final String xmlFileName, final String charset) throws Exception {
        return createXMLDocument(createDOMContentBuilder(xmlFileName), charset == null ? "UTF-8" : charset); //$NON-NLS-1$
    }

    private ByteArrayOutputStream createXMLDocument(final Document document, final String charset)
            throws UnsupportedEncodingException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final DOMWriter domWriter = new DOMWriterExtension(new OutputStreamWriter(out, charset));
        domWriter.print(document, charset, cmDocument.getNodeName(), getNonWhitespaceString(getPublicId()),
                getNonWhitespaceString(getSystemId()));
        closeQuietly(out);
        return out;
    }

    private Document createDOMContentBuilder(final String xmlFileName) throws Exception {
        final Document theDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        final DOMContentBuilderImpl contentBuilder = new DOMContentBuilderImpl(theDocument);

        contentBuilder.supressCreationOfDoctypeAndXMLDeclaration = true;
        contentBuilder.setBuildPolicy(buildPolicy);
        contentBuilder.setOptionalElementDepthLimit(optionalElementDepthLimit);
        contentBuilder.setExternalCMDocumentSupport(new MyExternalCMDocumentSupport(namespaceInfoList, xmlFileName) {
        });
        contentBuilder.createDefaultRootContent(getCMDocument(), (CMElementDeclaration) getCMDocument().getElements()
                .getNamedItem(getRootElementName()), namespaceInfoList);

        return theDocument;
    }

    private static final class DOMWriterExtension extends DOMWriter {
        DOMWriterExtension(final Writer writer) {
            super(writer);
        }

        @Override
        public void print(final Node node) {
            if (node != null) {
                final XMLVisitor visitor = new XMLVisitorExtension();
                visitor.visitNode(node);
            }
            out.flush();
        }

        private final class XMLVisitorExtension extends XMLVisitor {
            @Override
            public void visitElement(final Element element) {
                if (doShow(element) && element.getParentNode().getNodeType() == Node.DOCUMENT_NODE
                        && !(element.getChildNodes().getLength() > 0)) {
                    printIndent();
                    print("<"); //$NON-NLS-1$
                    print(element.getNodeName());
                    visitAttributesHelper(element);
                    println("/>"); //$NON-NLS-1$
                    return;
                }
                super.visitElement(element);
            }
        }
    }
}
