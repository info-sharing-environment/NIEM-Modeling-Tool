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
package org.search.niem.mpd;

public interface Constants {
    String BASE_MPD_NAMESPACE = "http://reference.niem.gov/niem/resource/mpd/lexicon/1.1/";
    String NATURE_TYPE = "nature";
    String PURPOSE_TYPE = "purpose";
    String XML_NATURE = BASE_MPD_NAMESPACE + NATURE_TYPE + "#xml";
    String TEXT_NATURE = BASE_MPD_NAMESPACE + NATURE_TYPE + "#text";
    String SAMPLE_PURPOSE = BASE_MPD_NAMESPACE + PURPOSE_TYPE + "#sample-instance";
    String CHANGELOG_PURPOSE = BASE_MPD_NAMESPACE + PURPOSE_TYPE + "#changelog";
    String EXCHANGE_SCHEMA_NATURE = BASE_MPD_NAMESPACE + NATURE_TYPE + "#niem-exchange-schema";
    String EXCHANGE_SCHEMA_SET_PURPOSE = BASE_MPD_NAMESPACE + PURPOSE_TYPE + "#exchange-schema-set";
}
