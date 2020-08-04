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
package ol.tilegrid;

import ol.Coordinate;
import ol.Extent;
import ol.GwtOLBaseTestCase;
import ol.TileCoord;

/**
 * Test for {@link ol.tilegrid.TileGrid}.
 *
 * @author Tino Desjardins
 */
public class TileGridTest extends GwtOLBaseTestCase {

    public void testTileGrid() {

        injectUrlAndTest(() -> {

            TileGridOptions tileGridOptions = new TileGridOptions();
            tileGridOptions.setExtent(new Extent(1, 1, 50000, 50000));
            tileGridOptions.setMinZoom(0);
            tileGridOptions.setResolutions(new double[] {4, 3, 2, 1});
            assertNotNull(tileGridOptions);

            TileGrid tileGrid = new TileGrid(tileGridOptions);
            assertNotNull(tileGrid);
            assertEquals(0, tileGrid.getMinZoom());
            assertEquals(3, tileGrid.getMaxZoom());

            XyzTileGridOptions xyzTileGridOptions = new XyzTileGridOptions();
            xyzTileGridOptions.setMinZoom(0);
            xyzTileGridOptions.setMaxZoom(12);
            assertNotNull(xyzTileGridOptions);

            TileGrid tileGridXyz = TileGrid.createXyz(xyzTileGridOptions);
            assertNotNull(tileGridXyz);
            assertEquals(0, tileGridXyz.getMinZoom());
            assertEquals(12, tileGridXyz.getMaxZoom());

            TileCoord tileCoord = new TileCoord(1, 1, 1);

            Extent coordExtent = tileGridXyz.getTileCoordExtent(tileCoord);
            assertNotNull(coordExtent);

            Extent coordExtent2 = tileGridXyz.getTileCoordExtent(tileCoord, new Extent(1, 1, 4, 4));
            assertNotNull(coordExtent2);

            Coordinate tileCoordinate2 = tileGrid.getTileCoordForCoordAndResolution(new Coordinate(1, 1), 4d);
            assertNotNull(tileCoordinate2);

            Coordinate tileCoordinate3 = tileGrid.getTileCoordForCoordAndResolution(new Coordinate(1, 1), 4d, tileCoord);
            assertNotNull(tileCoordinate3);

            TileCoord tileCoord2 = tileGrid.getTileCoordForCoordAndZ(new Coordinate(1, 1), 0);
            assertNotNull(tileCoord2);

            TileCoord tileCoord3 = tileGrid.getTileCoordForCoordAndZ(new Coordinate(1, 1), 0, new TileCoord(1, 1, 1));
            assertNotNull(tileCoord3);

        });

    }

}
