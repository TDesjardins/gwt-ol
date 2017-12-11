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
package ol.tilegrid;

import ol.GwtOL3BaseTestCase;
import ol.OLFactory;

/**
 * Test for {@link ol.tilegrid.TileGrid}.
 * 
 * @author Tino Desjardins
 */
public class TileGridTest extends GwtOL3BaseTestCase {

    public void testTileGrid() {

        injectUrlAndTest(() -> {

            TileGridOptions tileGridOptions = new TileGridOptions();
            tileGridOptions.setMinZoom(0);
            tileGridOptions.setMaxZoom(12);
            assertNotNull(tileGridOptions);
            TileGrid tileGrid = OLFactory.createTileGridXYZ(tileGridOptions);
            assertNotNull(tileGrid);
            assertEquals(0, tileGrid.getMinZoom());
            assertEquals(12, tileGrid.getMaxZoom());

        });

    }

}
