/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
package ol;

import ol.style.Style;

/**
 * Test for {@link ol.Feature}.
 *
 * @author Tino Desjardins
 *
 */
public class FeatureTest extends GwtOL3BaseTestCase {

    private static final String FEATURE_ID = "#1";
    private static final String GEOMETRY_NAME = "geometry";

    public void testFeature() {

        injectUrlAndTest(() -> {

            Feature feature = new Feature();

            assertNotNull(feature);
            assertTrue(feature instanceof Object);
            assertTrue(feature instanceof Observable);

            feature.setId(FEATURE_ID);
            assertEquals(FEATURE_ID, feature.getId());

            feature.setGeometryName(GEOMETRY_NAME);
            assertEquals(GEOMETRY_NAME, feature.getGeometryName());

            feature.setStyle(new Style());
            assertTrue(feature.getStyle() instanceof Style);
            assertTrue(feature.getStyles() instanceof Style[]);

            Style[] styles = new Style[2];
            styles[0] = new Style();
            styles[1] = new Style();

            feature.setStyles(styles);
            
            assertTrue(feature.getStyle() instanceof Style);
            assertTrue(feature.getStyles() instanceof Style[]);
            assertTrue(feature.getStyles().length == 2);

            feature.setStyleFunction((Double resolution) -> {
                return null;
            });

            assertTrue(feature.getStyle() == null);
            assertTrue(feature.getStyleFunction() instanceof GenericFunction);
            
        });

    }

}
