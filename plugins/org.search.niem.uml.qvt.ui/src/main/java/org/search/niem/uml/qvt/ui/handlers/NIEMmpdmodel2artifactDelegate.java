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

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.io.FileUtils.writeStringToFile;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.eclipse.core.resources.IResource.DEPTH_INFINITE;
import static org.search.niem.mpd.Constants.CHANGELOG_PURPOSE;
import static org.search.niem.mpd.Constants.EXCHANGE_SCHEMA_NATURE;
import static org.search.niem.mpd.Constants.EXCHANGE_SCHEMA_SET_PURPOSE;
import static org.search.niem.mpd.Constants.SAMPLE_PURPOSE;
import static org.search.niem.mpd.Constants.TEXT_NATURE;
import static org.search.niem.mpd.Constants.XML_NATURE;
import static org.search.niem.mpd.cat.util.CatExt.addCatalogFile;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_CHANGELOG_FILE_NAME;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_MPD_CATALOG_FILE_NAME;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_SAMPLE_XML_SUFFIX;
import static org.search.niem.uml.qvt.ui.preferences.PreferenceConstants.P_XML_SAMPLES_FOLDER;
import static org.search.niem.uml.util.NIEMUmlExt.findPsmMpd;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDAuthoritativeSourceName;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDBaseURI;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDClassCode;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDCreationDate;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDDomains;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDKeywords;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDLastRevisionDate;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDPointOfContactEmailAddresses;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDPointOfContactName;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDPointOfContactPhoneNumbers;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDPointsOfContact;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDSecurityMarking;
import static org.search.niem.uml.util.NIEMUmlExt.getMPDVersionID;
import static org.search.niem.uml.util.URIExt.appendPath;
import static org.search.niem.uml.util.URIExt.relativize;
import static org.search.niem.uml.util.URIExt.toFile;
import static org.search.niem.uml.util.URIExt.toIFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSchema;
import org.search.niem.mpd.cat.CatFactory;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.FileSetType;
import org.search.niem.mpd.cat.FileType;
import org.search.niem.mpd.cat.util.CatExt;
import org.search.niem.mpd.cat.util.CatResourceFactoryImpl;
import org.search.niem.uml.qvt.ui.Activator;

final class NIEMmpdmodel2artifactDelegate extends NIEMpsm2xsdDelegate {

    private static final String CHANGELOG_TEXT = "Changelog for %s%nVersion %s %s%nDescription of Changes:";
    private ModelExtent theTargetContents;

    protected NIEMmpdmodel2artifactDelegate(final URI selection) {
        super(selection, org.search.niem.uml.qvt.Activator.INSTANCE.getNIEMmpdmodel2artifactLocation(), Activator.INSTANCE
                .getString("_UI_NIEMmpdmodel2artifact_Command_name"));
    }

    @Override
    protected String getValidationMessage(final IStatus status) {
        return Activator.INSTANCE.getString("_UI_NIEMmpdmodel2artifact_validation_dialog_message");
    }

    @Override
    protected IStatus validate() {
        final MultiStatus theValidationStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK,
                Activator.INSTANCE.getString("_UI_NIEMmpdmodel2artifact_status_message"), null);
        final Element theMPD = findPsmMpd(theSelectedResource);
        if (theMPD == null) {
            return theValidationStatus;
        }
        if (isBlank(getMPDVersionID(theMPD))) {
            thePropertyIsMissing(theValidationStatus, "_UI_CatalogType_mpdVersionID_feature");
        }
        if (isBlank(getMPDBaseURI(theMPD))) {
            thePropertyIsMissing(theValidationStatus, "_UI_CatalogType_mpdURI_feature");
        }
        if (getMPDClassCode(theMPD) == null) {
            thePropertyIsMissing(theValidationStatus, "_UI_CatalogType_mpdClassCode_feature");
        }
        if (isBlank(getMPDCreationDate(theMPD))) {
            thePropertyIsMissing(theValidationStatus, "_UI_MetadataType_creationDate_feature");
        }
        if (isBlank(getMPDSecurityMarking(theMPD))) {
            thePropertyIsMissing(theValidationStatus, "_UI_MetadataType_securityMarkingText_feature");
        }
        if (getMPDDomains(theMPD).isEmpty()) {
            thePropertyIsMissing(theValidationStatus, "_UI_MetadataType_domainText_feature");
        }
        if (getMPDKeywords(theMPD).isEmpty()) {
            thePropertyIsMissing(theValidationStatus, "_UI_MetadataType_keywordText_feature");
        }
        if (isBlank(getMPDAuthoritativeSourceName(theMPD))) {
            thePropertyIsMissing(theValidationStatus, "_UI_AuthoritativeSourceType_aSName_feature");
        }
        final List<EObject> mpdPointsOfContact = getMPDPointsOfContact(theMPD);
        if (mpdPointsOfContact.isEmpty()) {
            thePropertyIsMissing(theValidationStatus, "_UI_AuthoritativeSourceType_pOC_feature");
        }
        for (final EObject poc : mpdPointsOfContact) {
            if (isBlank(getMPDPointOfContactName(poc))) {
                thePropertyIsMissing(theValidationStatus, "_UI_POCType_pOCName_feature");
            }
            if (getMPDPointOfContactEmailAddresses(poc).isEmpty()) {
                thePropertyIsMissing(theValidationStatus, "_UI_POCType_pOCEmail_feature");
            }
            if (getMPDPointOfContactPhoneNumbers(poc).isEmpty()) {
                thePropertyIsMissing(theValidationStatus, "_UI_POCType_pOCTelephone_feature");
            }
        }
        return theValidationStatus;
    }

    @Override
    protected final ModelExtent[] arguments() {
        theTargetContents = new BasicModelExtent(Collections.<EObject> emptyList());
        final ModelExtent targetLocation = new BasicModelExtent(Collections.<EObject> emptyList());
        final List<ModelExtent> arguments = new ArrayList<>(asList(super.arguments()));
        arguments.add(arguments.size() - 1, targetLocation);
        arguments.add(theTargetContents);
        return arguments.toArray(new ModelExtent[arguments.size()]);
    }

    @Override
    protected final void persist() throws IOException {
        super.persist();
        final Iterable<Resource> theSamples = generateTheXmlSamples(appendPath(targetFolder(), getXmlSamplesDirectory()));
        final URI theCatalogURI = appendPath(targetFolder(), getMPDCatalogName());
        final URI theCatalogParent = theCatalogURI.trimSegments(1);

        int index = 1;
        for (final Resource aSample : theSamples) {
            addFile("sample" + index++, XML_NATURE, SAMPLE_PURPOSE, "./" + relativize(theCatalogParent, aSample.getURI()));
        }

        final URI theChangelogURI = appendPath(targetFolder(), getChangelogName());
        final File theChangelog = toFile(theChangelogURI);
        if (!theChangelog.exists()) {
            final Element theMPD = findPsmMpd(theSelectedResource);
            writeStringToFile(theChangelog,
                    format(CHANGELOG_TEXT, getMPDBaseURI(theMPD), getMPDVersionID(theMPD), getMPDLastRevisionDate(theMPD)));
        }
        addFile("changelog1", TEXT_NATURE, CHANGELOG_PURPOSE, "./" + relativize(theCatalogParent, theChangelogURI));

        final Resource theCatalog = new CatResourceFactoryImpl().createResource(theCatalogURI);
        theCatalog.getContents().addAll(theTargetContents.getContents());
        theCatalog.save(resourceSet.getLoadOptions());

        refresh();
    }

    private void thePropertyIsMissing(final MultiStatus theStatusAccumulator, final String thePropertyKey) {
        theStatusAccumulator.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, Activator.INSTANCE.getString(
                "_UI_NIEMmpdmodel2artifact_status_missing_property",
                new Object[] { org.search.niem.mpd.Activator.INSTANCE.getString(thePropertyKey) })));
    }

    private void addFile(final String id, final String nature, final String purpose, final String relativePath) {
        final FileType aFile = CatFactory.eINSTANCE.createFileType();
        aFile.setId(id);
        aFile.setNatureURI(nature);
        aFile.setPurposeURI(purpose);
        aFile.setRelativePathName(relativePath);
        addCatalogFile(getTheCatalog(), aFile);
    }

    private String getMPDCatalogName() {
        return getThePrefenceStore().getString(P_MPD_CATALOG_FILE_NAME);
    }

    private String getXmlSamplesDirectory() {
        return getThePrefenceStore().getString(P_XML_SAMPLES_FOLDER);
    }

    private String getSampleXmlSuffix() {
        return getThePrefenceStore().getString(P_SAMPLE_XML_SUFFIX);
    }

    private String getChangelogName() {
        return getThePrefenceStore().getString(P_CHANGELOG_FILE_NAME);
    }

    private IPreferenceStore getThePrefenceStore() {
        return Activator.getPlugin().getPreferenceStore();
    }

    private Iterable<XSDSchema> getTheExchangeSchemas() {
        final Collection<XSDSchema> theExchangeSchemas = new ArrayList<>();
        final CatalogType theCatalog = getTheCatalog();
        @SuppressWarnings("unchecked")
        final Collection<FileSetType> fileSets = (Collection<FileSetType>) theCatalog.getArtifactGroup().get(
                CatPackage.Literals.DOCUMENT_ROOT__FILE_SET, false);
        for (final FileSetType fileSet : fileSets) {
            if (isExchangeSchemaSet(fileSet)) {
                final List<FileType> files = fileSet.getFile();
                for (final FileType file : files) {
                    if (isExchangeSchema(file)) {
                        theExchangeSchemas.add(findSchemaFor(file));
                    }
                }
            }
        }
        @SuppressWarnings("unchecked")
        final Collection<FileType> files = (Collection<FileType>) theCatalog.getArtifactGroup().get(
                CatPackage.Literals.DOCUMENT_ROOT__FILE, false);
        for (final FileType file : files) {
            if (isExchangeSchema(file)) {
                theExchangeSchemas.add(findSchemaFor(file));
            }
        }
        return theExchangeSchemas;
    }

    private CatalogType getTheCatalog() {
        return CatExt.getTheCatalog((EObject) EcoreUtil.getObjectByType(theTargetContents.getContents(),
                CatPackage.Literals.DOCUMENT_ROOT));
    }

    private XSDSchema findSchemaFor(final FileType file) {
        final Iterable<XSDSchema> targetSchemas = getTargetSchemas();
        final String[] pathSegments = file.getRelativePathName().replaceFirst("^\\./", "").split("/");
        NEXT_SCHEMA: for (final XSDSchema nextSchema : targetSchemas) {
            final URI nextSchemaURI = nextSchema.eResource().getURI();
            final int segmentCount = nextSchemaURI.segmentCount();
            if (pathSegments.length > segmentCount) {
                continue NEXT_SCHEMA;
            }
            for (int i = 0; i < pathSegments.length; i++) {
                if (!pathSegments[pathSegments.length - 1 - i].equals(nextSchemaURI.segment(segmentCount - 1 - i))) {
                    continue NEXT_SCHEMA;
                }
            }
            return nextSchema;
        }
        return null;
    }

    private boolean isExchangeSchemaSet(final FileSetType fileSet) {
        final String purposeURI = fileSet.getPurposeURI();
        return EXCHANGE_SCHEMA_SET_PURPOSE.equals(purposeURI);
    }

    private boolean isExchangeSchema(final FileType file) {
        final String natureURI = file.getNatureURI();
        return EXCHANGE_SCHEMA_NATURE.equals(natureURI);
    }

    private void refresh() {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    toIFolder(targetFolder()).refreshLocal(DEPTH_INFINITE, new NullProgressMonitor());
                } catch (final CoreException e) {
                    Activator.INSTANCE.log(e);
                }
            }
        });
    }

    private Iterable<Resource> generateTheXmlSamples(final URI theSamplesDirectory) {
        toFile(theSamplesDirectory).mkdirs();
        final Collection<Resource> theXmlSamples = new ArrayList<>();
        for (final XSDSchema xsdSchema : getTheExchangeSchemas()) {
            for (final XSDElementDeclaration xsdElementDeclaration : xsdSchema.getElementDeclarations()) {
                final String elementName = xsdElementDeclaration.getName();
                if (xsdElementDeclaration.getSchema() == xsdSchema && elementName != null) {
                    SafeRunner.run(new ISafeRunnable() {
                        @Override
                        public void run() throws Exception {
                            final Resource anXmlSample = new NewXMLGeneratorExtension(xsdSchema, theSamplesDirectory
                                    .appendSegment(elementName + getSampleXmlSuffix()).appendFileExtension("xml"),
                                    elementName).generateSample();
                            theXmlSamples.add(anXmlSample);
                        }

                        @Override
                        public void handleException(final Throwable e) {
                            Activator.INSTANCE.log(e);
                        }
                    });
                }
            }
        }
        return theXmlSamples;
    }
}