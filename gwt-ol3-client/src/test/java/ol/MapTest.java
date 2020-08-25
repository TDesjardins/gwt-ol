/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Node;
import ol.layer.Layer;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;

/**
 *
 * @author Tino Desjardins
 *
 */
public class MapTest extends GwtOLBaseTestCase {

    public static final String MAP_ID = "map";

    public static final int MAP_SIZE_WIDTH = 800;

    public static final int MAP_SIZE_HEIGHT = 600;

    public void testMapCreation() {

        injectUrlAndTest(() -> {

            this.createAndAppendMapElement(MAP_ID, MAP_SIZE_WIDTH, MAP_SIZE_HEIGHT);

            ProjectionOptions projectionOptions = new ProjectionOptions();
            projectionOptions.setCode("EPSG:21781");
            projectionOptions.setUnits("m");

            Projection projection = new Projection(projectionOptions);

            ViewOptions viewOptions = new ViewOptions();
            viewOptions.setProjection(projection);
            View view = new View(viewOptions);

            Coordinate centerCoordinate = new Coordinate(660000, 190000);

            view.setCenter(centerCoordinate);
            view.setZoom(9);

            final MapOptions mapOptions = new MapOptions();
            mapOptions.setTarget(MAP_ID);
            mapOptions.setView(view);

            Map map = new Map(mapOptions);
            assertNotNull(map);

            assertNotNull(map.getSize());

            assertEquals(MAP_SIZE_WIDTH, map.getSize().getWidth());
            assertEquals(MAP_SIZE_HEIGHT, map.getSize().getHeight());

            FeatureAtPixelOptions featureAtPixelOptions = new FeatureAtPixelOptions();

            map.forEachFeatureAtPixel(new Pixel(100, 100), new FeatureAtPixelFunction() {

                @Override
                public boolean call(Feature feature, Layer layer) {
                    return false;
                }

            }, featureAtPixelOptions);

        });

    }

    private Node createAndAppendMapElement(String id, int width, int height) {

        Element mapDiv = DomGlobal.document.createElement("div");
        mapDiv.setAttribute("id", id);
        mapDiv.setAttribute("style", "width: " + width + "px; height: " + height + "px");

        return DomGlobal.document.body.appendChild(mapDiv);

    }

}
