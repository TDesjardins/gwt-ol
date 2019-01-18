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
import ol.geom.Geometry;
import ol.utils.OLTestUtils;

/**
 * Test for WKT format.
 * 
 * @author gkresic
 *
 */
public class WktTest extends GwtOLBaseTestCase {

    private Wkt wktFormat;
    private Wkt splittingWktFormat;

    @Override
    protected void gwtSetUp() throws Exception {

        injectUrlAndTest(() -> {

            WktOptions wktOptions = new WktOptions();
            assertNotNull(wktOptions);

            wktOptions.setSplitCollection(false);
            wktFormat = new Wkt(wktOptions);
            assertNotNull(wktFormat);

            wktOptions.setSplitCollection(true);
            splittingWktFormat = new Wkt(wktOptions);
            assertNotNull(splittingWktFormat);

        });

    }

    public void testFeatureToWkt() {

        injectUrlAndTest(() -> {

            WktWriteOptions writeOptions = new WktWriteOptions();
            assertNotNull(writeOptions);
            writeOptions.setDecimals(3);

            String wkt = wktFormat.writeFeature(OLTestUtils.createLineFeature(), writeOptions);
            assertNotNull(wkt);

        });

    }

    public void testFeaturesToWkt() {

        injectUrlAndTest(() -> {

            String wkt = wktFormat.writeFeatures(OLTestUtils.createLineFeatures(), null);
            assertNotNull(wkt);

        });

    }

    public void testGeometryToWkt() {

        injectUrlAndTest(() -> {

            String wkt = wktFormat.writeGeometry(OLTestUtils.createLineFeature().getGeometry());
            assertNotNull(wkt);

        });

    }

    public void testWktToFeature() {

        injectUrlAndTest(() -> {

            String wkt = wktFormat.writeFeature(OLTestUtils.createLineFeature(), null);
            assertNotNull(wkt);

            WktReadOptions readOptions = new WktReadOptions();
            assertNotNull(readOptions);

            Feature feature = wktFormat.readFeature(wkt, readOptions);
            assertNotNull(feature);

        });

    }

    public void testWktToFeatures() {

        injectUrlAndTest(() -> {

            String wkt = wktFormat.writeFeatures(OLTestUtils.createLineFeatures(), null);
            assertNotNull(wkt);

            Feature[] features;

            features = wktFormat.readFeatures(wkt, null);
            assertNotNull(features);
            assertEquals(1, features.length);

            features = splittingWktFormat.readFeatures(wkt, null);
            assertNotNull(features);
            assertEquals(2, features.length);

        });

    }

    public void testWktToGeometry() {
        
        injectUrlAndTest(() -> {

            String wkt = wktFormat.writeGeometry(OLTestUtils.createLineFeature().getGeometry());
            assertNotNull(wkt);

            Geometry geometry = wktFormat.readGeometry(wkt, null);
            assertNotNull(geometry);

        });

    }

}
