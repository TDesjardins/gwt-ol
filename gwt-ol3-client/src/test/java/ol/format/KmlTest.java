/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.format;

import ol.Feature;
import ol.GwtOLBaseTestCase;
import ol.utils.OLTestUtils;

/**
 * Test for format KML.
 */
public class KmlTest extends GwtOLBaseTestCase {

    private Kml kmlFormat;

    @Override
    protected void gwtSetUp() throws Exception {
        injectUrlAndTest(() -> kmlFormat = new Kml());
    }

    public void testFormatKml() {

        injectUrlAndTest(() -> {

            Feature[] testFeatures = OLTestUtils.createLineFeatures();

            String kml = kmlFormat.writeFeatures(testFeatures);

            Feature[] features = kmlFormat.readFeatures(kml);
            assertNotNull(features);
            assertTrue(features.length > 0);

        });

    }

}
