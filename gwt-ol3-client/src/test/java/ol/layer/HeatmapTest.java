/*******************************************************************************
 * Copyright 2014, 2021 gwt-ol
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
import ol.format.Kml;
import ol.source.VectorOptions;

/**
 * A test case for {@link ol.layer.Heatmap}.
 *
 * @author Tino Desjardins
 *
 */
public class HeatmapTest extends GwtOLBaseTestCase {

    public void testVectorLayer() {

        injectUrlAndTest(() -> {

            HeatmapOptions heatmapOptions = new HeatmapOptions();
            assertNotNull(heatmapOptions);

            VectorOptions vectorOptions = new VectorOptions();
            vectorOptions.setUrl("https://openlayers.org/en/latest/examples/data/kml/2012_Earthquakes_Mag5.kml");
            vectorOptions.setFormat(new Kml());
            ol.source.Vector vector = new ol.source.Vector(vectorOptions);

            heatmapOptions.setSource(vector);
            heatmapOptions.setBlur(2);
            heatmapOptions.setRadius(15);
            heatmapOptions.setWeight((Feature feature) -> {

                String magnitudeValue = feature.get("name");
                String parsedMagnitude = magnitudeValue.substring(2);
                parsedMagnitude = parsedMagnitude.substring(0, parsedMagnitude.indexOf(" "));

                return Double.parseDouble(parsedMagnitude) - 5;

            });

            /*Heatmap heatmap = new Heatmap(heatmapOptions);
            assertNotNull(heatmap);
            assertTrue(heatmap instanceof Base);
            assertTrue(heatmap instanceof Layer);
            assertTrue(heatmap instanceof Vector);*/

        });

    }

}
