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
package ol.layer;

import ol.Feature;
import ol.GwtOLBaseTestCase;
import ol.style.Style;
import ol.style.StyleFunction;

/**
 * A test case for {@link ol.layer.Vector}.
 *
 * @author Tino Desjardins
 *
 */
public class VectorTest extends GwtOLBaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void testVectorLayer() {

        injectUrlAndTest(() -> {

            VectorLayerOptions vectorLayerOptions = new VectorLayerOptions();
            assertNotNull(vectorLayerOptions);
            Vector vectorLayer = new Vector(vectorLayerOptions);
            assertTrue(vectorLayer instanceof Base);
            assertTrue(vectorLayer instanceof Layer);
            assertTrue(vectorLayer instanceof Vector);

            vectorLayer.setStyle(new Style());
            assertTrue(vectorLayer.getStyle() instanceof Style);
            assertTrue(vectorLayer.getStyles() instanceof Style[]);

            Style[] styles = {new Style(), new Style()};

            vectorLayer.setStyles(styles);

            assertTrue(vectorLayer.getStyle() instanceof Style);
            assertTrue(vectorLayer.getStyles() instanceof Style[]);
            assertTrue(vectorLayer.getStyles().length == 2);

            vectorLayer.setStyleFunction((Feature feature, double resolution) -> {
                return null;
            });

            assertTrue(vectorLayer.getStyle() == null);
            assertTrue(vectorLayer.getStyleFunction() instanceof StyleFunction);

        });

    }

}
