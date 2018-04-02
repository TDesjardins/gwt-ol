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

import ol.Collection;
import ol.GwtOLBaseTestCase;
import ol.OLFactory;
import ol.source.Vector;

/**
 * A test case for {@link ol.layer.Group}.
 *
 * @author sbaumhekel
 * @author Tino Desjardins
 *
 */
public class LayerGroupTest extends GwtOLBaseTestCase {

    @SuppressWarnings({ "static-method", "javadoc" })
    public void testLayerGroup() {

        injectUrlAndTest(() -> {

            // create empty layer group and ensure it is empty
            Group layerGroup = new Group();
            Collection<ol.layer.Base> layers1 = layerGroup.getLayers();

            assertEquals(0, layers1.getLength());

            // add two layers and ensure they are in there
            Layer vectorLayer1 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(new Vector()));
            Layer vectorLayer2 = OLFactory.createVector(OLFactory.createLayerOptionsWithSource(new Vector()));

            ol.Collection<Base> layers2 = new Collection<Base>();
            layers2.push(vectorLayer1);
            layers2.push(vectorLayer2);
            layerGroup.setLayers(layers2);
            layers1 = layerGroup.getLayers();

            assertEquals(2, layers1.getLength());

        });

    }

}
