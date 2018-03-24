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
package ol.source;

import ol.GwtOLBaseTestCase;

/**
 * A test case for {@link ol.source.TileWms}.
 *
 * @author Peter Zanetti
 */
public class TileWmsTest extends GwtOLBaseTestCase {

    public void testTileWms() {

        injectUrlAndTest(() -> {

            TileWmsParams params = new TileWmsParams();
            params.setLayers("topp:states");
            params.setTiled(true);

            TileWmsOptions options = new TileWmsOptions();
            options.setUrl("https://ahocevar.com/geoserver/wms");
            options.setParams(params);
            options.setServerType(WmsServerType.GEOSERVER);

            TileWms source = new TileWms(options);

            assertEquals("topp:states", source.getParams().getLayers());

            params.setLayers("topp");

            source.updateParams(params);
            assertEquals("topp", source.getParams().getLayers());
        });

    }

}
