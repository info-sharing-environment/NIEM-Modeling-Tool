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

import static org.eclipse.emf.common.util.URI.createURI;
import static org.eclipse.emf.ecore.util.EcoreUtil.getObjectsByType;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SCHEMAS_FOLDER;
import static org.search.niem.uml.util.URIExt.appendPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.search.niem.uml.qvt.ui.Activator;

class NIEMpsm2xsdDelegate extends TransformDelegate {

    private static final String NIEM_XSD_LIBRARY = "platform:/plugin/" + org.search.niem.xsd.library.Activator.SCHEMA_FOLDER;

    private ModelExtent targetContents;
    private URI targetFolder;
    private final Collection<Resource> infrastructureResources = new ArrayList<>(4);

    protected NIEMpsm2xsdDelegate(final URI selection) {
        this(selection, org.search.niem.uml.qvt.Activator.INSTANCE.getNIEMpsm2xsdLocation(), Activator.INSTANCE
                .getString("_UI_NIEMpsm2xsd_Command_name"));
    }

    protected NIEMpsm2xsdDelegate(final URI selection, final URI transformationURI, final String name) {
        super(selection, transformationURI, name);
    }

    private Resource getInfrastructureResource(final URI uri, final URI targetFolder) {
        final URI oldPrefix = URI.createURI(NIEM_XSD_LIBRARY);
        final URI newLocation = uri.replacePrefix(oldPrefix, targetFolder);
        final Resource newResource = resourceSet.createResource(newLocation);
        newResource.getContents().addAll(resourceSet.getResource(uri, true).getContents());
        infrastructureResources.add(newResource);
        return newResource;
    }

    @Override
    protected Map<String, Object> getConfigProperties() {
        final Map<String, Object> configProperties = super.getConfigProperties();
        configProperties.put("xmlSchemasFolder", getXmlSchemasFolder());
        return configProperties;
    }

    private String getXmlSchemasFolder() {
        return Activator.getPlugin().getPreferenceStore().getString(P_XML_SCHEMAS_FOLDER);
    }

    @Override
    protected ModelExtent[] arguments() {
        final ModelExtent psmContents = new BasicModelExtent(theSelectedResource.getContents());
        targetContents = new BasicModelExtent(Collections.<EObject> emptyList());
        targetFolder = theSelectedResource.getURI().trimFileExtension();
        final URI infrastructureTargetFolder = createURI(appendPath(targetFolder, getXmlSchemasFolder()).toString() + "/",
                true);

        final Collection<ModelExtent> modelExtents = new ArrayList<>(6);
        modelExtents.add(psmContents);
        for (final URI infrastructureSchemaLocation : org.search.niem.xsd.library.Activator.INSTANCE
                .getInfrastructureSchemaLocations()) {
            modelExtents.add(new BasicModelExtent(getInfrastructureResource(infrastructureSchemaLocation,
                    infrastructureTargetFolder).getContents()));
        }
        modelExtents.add(targetContents);
        return modelExtents.toArray(new ModelExtent[modelExtents.size()]);
    }

    protected final Iterable<XSDSchema> getTargetSchemas() {
        return getObjectsByType(targetContents.getContents(), XSDPackage.Literals.XSD_SCHEMA);
    }

    @Override
    protected void persist() throws IOException {
        final HashMap<Object, Object> saveOptions = new HashMap<>(resourceSet.getLoadOptions());
        for (final Resource infrastructureResource : infrastructureResources) {
            infrastructureResource.save(saveOptions);
        }
        for (final XSDSchema schema : getTargetSchemas()) {
            final Resource xsd = resourceSet.createResource(appendPath(targetFolder, schema.getSchemaLocation()));
            xsd.getContents().add(schema);
            xsd.save(saveOptions);
        }
    }

    protected final URI targetFolder() {
        return targetFolder;
    }

    @Override
    public void close() throws Exception {
        targetContents = null;
        targetFolder = null;
        infrastructureResources.clear();
        super.close();
    }
}