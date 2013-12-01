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
package org.search.niem.uml.library;

import static com.google.common.collect.Maps.unmodifiableBiMap;
import static java.util.Arrays.asList;

import java.util.Collection;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Activator extends EMFPlugin {

    public static final String PLUGIN_ID = "org.search.niem.uml.library"; //$NON-NLS-1$

    public static final URI REFERENCE_LIBRARY_URI = URI.createURI(
            "http://www.omg.org/spec/NIEM-UML/20120501/NIEM-Reference", true);

    public static int LIBRARY_COUNT = 47;

    public static final Activator INSTANCE = new Activator();

    private static Implementation plugin;

    public Activator() {
        super(new ResourceLocator[] {});
    }

    public Collection<URI> getReferenceLibraries() {
        return ReferenceLibraryUtil.referenceLibraries;
    }

    public String toPrefix(final String namespace) {
        return NamespaceUtil.prefixes2namespaceURIs.inverse().get(namespace);
    }

    public String toNamespace(final String prefix) {
        return NamespaceUtil.prefixes2namespaceURIs.get(prefix);
    }

    public boolean isReferenceLibraryNamespace(final String namespace) {
        return NamespaceUtil.prefixes2namespaceURIs.containsValue(namespace);
    }

    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    public static Implementation getPlugin() {
        return plugin;
    }

    public static class Implementation extends EclipsePlugin {

        public Implementation() {
            super();

            plugin = this;
        }
    }

    private static final class ReferenceLibraryUtil {

        // @formatter:off
        private static final Collection<URI> referenceLibraries = asList(
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-ansi_d20"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-apco"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-atf"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-cbrncl"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-census"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-dea"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-dod_jcs-pub2.0-misc"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-edxl-cap"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-edxl-de"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-edxl-have"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-edxl"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-fbi"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-fips_10-4"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-fips_5-2"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-fips_6-4"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-geospatial"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-have-codes"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-hazmat"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-icism"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-iso_3166"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-iso_4217"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-iso_639-3"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-itis"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-lasd"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-mmucc_2"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-mn_offense"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-nga"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-nlets"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-nonauthoritative-code"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-post-canada"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-sar"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-twpdes"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-ucr"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-unece_rec20-misc"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-usps_states"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-common-ut_offender-tracking-misc"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-core"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-emergencyManagement"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-familyServices"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-infrastructureProtection"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-intelligence"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-jxdm"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-maritime"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-domains-screening"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-external-cap"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-external-de"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-external-have"),
                REFERENCE_LIBRARY_URI.appendSegment("NIEM-Reference-external-ogc")
                );
        // @formatter:on
    }

    private static final class NamespaceUtil {

        private static final BiMap<String, String> prefixes2namespaceURIs;

        static {
            final BiMap<String, String> m = HashBiMap.create(47);
            m.put("ansi-nist", "http://niem.gov/niem/ansi-nist/2.0");
            m.put("ansi_d20", "http://niem.gov/niem/ansi_d20/2.0");
            m.put("apco", "http://niem.gov/niem/apco/2.1");
            m.put("atf", "http://niem.gov/niem/atf/2.0");
            m.put("can", "http://niem.gov/niem/post-canada/2.0");
            m.put("cap", "urn:oasis:names:tc:emergency:cap:1.1");
            m.put("cbrn", "http://niem.gov/niem/domains/cbrn/2.1");
            m.put("cbrncl", "http://niem.gov/niem/cbrncl/2.1");
            m.put("census", "http://niem.gov/niem/census/2.0");
            m.put("de", "urn:oasis:names:tc:emergency:EDXL:DE:1.0");
            m.put("dea", "http://niem.gov/niem/dea/2.1");
            m.put("dod_jcs-pub2.0", "http://niem.gov/niem/dod_jcs-pub2.0-misc/2.0");
            m.put("edxl", "http://niem.gov/niem/edxl/2.1");
            m.put("edxl-cap", "http://niem.gov/niem/edxl-cap/2.1");
            m.put("edxl-de", "http://niem.gov/niem/edxl-de/2.1");
            m.put("edxl-have", "http://niem.gov/niem/edxl-have/2.1");
            m.put("em", "http://niem.gov/niem/domains/emergencyManagement/2.1");
            m.put("fbi", "http://niem.gov/niem/fbi/2.0");
            m.put("fips_10-4", "http://niem.gov/niem/fips_10-4/2.0");
            m.put("fips_5-2", "http://niem.gov/niem/fips_5-2/2.0");
            m.put("fips_6-4", "http://niem.gov/niem/fips_6-4/2.0");
            m.put("fs", "http://niem.gov/niem/domains/familyServices/2.1");
            m.put("gco", "http://www.isotc211.org/2005/gco");
            m.put("geo", "http://niem.gov/niem/geospatial/2.1");
            m.put("gmd", "http://www.isotc211.org/2005/gmd");
            m.put("gml", "http://www.opengis.net/gml/3.2");
            m.put("gmx", "http://www.isotc211.org/2005/gmx");
            m.put("gsr", "http://www.isotc211.org/2005/gsr");
            m.put("gss", "http://www.isotc211.org/2005/gss");
            m.put("gts", "http://www.isotc211.org/2005/gts");
            m.put("have", "urn:oasis:names:tc:emergency:EDXL:HAVE:1.0");
            m.put("have-codes", "http://niem.gov/niem/have-codes/2.1");
            m.put("hazmat", "http://niem.gov/niem/hazmat/2.1");
            m.put("icism", "urn:us:gov:ic:ism:v2");
            m.put("im", "http://niem.gov/niem/domains/immigration/2.1");
            m.put("intel", "http://niem.gov/niem/domains/intelligence/2.1");
            m.put("ip", "http://niem.gov/niem/domains/infrastructureProtection/2.1");
            m.put("iso_3166", "http://niem.gov/niem/iso_3166/2.0");
            m.put("iso_4217", "http://niem.gov/niem/iso_4217/2.0");
            m.put("iso_639-3", "http://niem.gov/niem/iso_639-3/2.0");
            m.put("it", "http://niem.gov/niem/domains/internationalTrade/2.1");
            m.put("itis", "http://niem.gov/niem/itis/2.1");
            m.put("j", "http://niem.gov/niem/domains/jxdm/4.1");
            m.put("lasd", "http://niem.gov/niem/lasd/2.0");
            m.put("m", "http://niem.gov/niem/domains/maritime/2.1");
            m.put("mmucc_2", "http://niem.gov/niem/mmucc_2/2.1");
            m.put("mn_off", "http://niem.gov/niem/mn_offense/2.0");
            m.put("nc", "http://niem.gov/niem/niem-core/2.0");
            m.put("nga", "http://niem.gov/niem/nga/2.0");
            m.put("niem-xsd", "http://niem.gov/niem/proxy/xsd/2.0");
            m.put("nlets", "http://niem.gov/niem/nlets/2.1");
            m.put("nonauth", "http://niem.gov/niem/nonauthoritative-code/2.0");
            m.put("sar", "http://niem.gov/niem/sar/2.1");
            m.put("scr", "http://niem.gov/niem/domains/screening/2.1");
            m.put("twpdes", "http://niem.gov/niem/twpdes/2.0");
            m.put("ucr", "http://niem.gov/niem/ucr/2.0");
            m.put("unece", "http://niem.gov/niem/unece_rec20-misc/2.0");
            m.put("usps", "http://niem.gov/niem/usps_states/2.0");
            m.put("ut_offender", "http://niem.gov/niem/ut_offender-tracking-misc/2.0");
            m.put("xhtml", "http://www.w3.org/1999/xhtml");
            m.put("xlink", "http://www.w3.org/1999/xlink");
            m.put("i", "http://niem.gov/niem/appinfo/2.0");
            m.put("s", "http://niem.gov/niem/structures/2.0");
            m.put("xls", "http://niem.gov/niem/external/ogc/xls/1.1.0/dhs-gmo/2.1.0");
            m.put("ct", "urn:oasis:names:tc:ciq:ct:3");
            m.put("geo-oasis", "urn:oasis:names:tc:emergency:EDXL:HAVE:1.0:geo-oasis");
            m.put("have-gml", "http://www.opengis.net/gml");
            m.put("xal", "urn:oasis:names:tc:ciq:xal:3");
            m.put("xlink1", "http://www.w3.org/1999/xlink1");
            m.put("xnl", "urn:oasis:names:tc:ciq:xnl:3");
            m.put("xpil", "urn:oasis:names:tc:ciq:xpil:3");

            prefixes2namespaceURIs = unmodifiableBiMap(m);
        }
    }
}
