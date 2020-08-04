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
package ol.tilegrid;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

import ol.Coordinate;
import ol.Extent;
import ol.Size;
import ol.TileCoord;

/**
 * Base class for setting the grid pattern for sources accessing tiled-image
 * servers.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class TileGrid {

    @JsOverlay
    private static final String PACKAGE_TILEGRID = "ol.tilegrid";

    public TileGrid() {}

    public TileGrid(TileGridOptions tileGridOptions) {}

    /**
     * Creates a tile grid with a standard XYZ tiling scheme.
     *
     * @param tileGridOptions
     * @return grid with a standard XYZ tiling scheme
     */
    @JsMethod(name = "createXYZ", namespace = PACKAGE_TILEGRID)
    public static native TileGrid createXyz(XyzTileGridOptions tileGridOptions);

    /**
     * Get the extent for this tile grid, if it was configured.
     *
     * @return {ol.Extent} Extent.
     */
    public native Extent getExtent();

    /**
     * Get the maximum zoom level for the grid.
     *
     * @return {number} Max zoom.
     */
    public native int getMaxZoom();

    /**
     * Get the minimum zoom level for the grid.
     *
     * @return {number} Min zoom.
     */
    public native int getMinZoom();

    /**
     * Get the origin for the grid at the given zoom level.
     *
     * @param z
     *            Z.
     * @return {ol.Coordinate} Origin.
     */
    public native Coordinate getOrigin(int z);

    /**
     * Get the resolution for the given zoom level.
     *
     * @param z
     *            Z.
     * @return {number} Resolution.
     */
    public native double getResolution(int z);

    /**
     * Get the list of resolutions for the tile grid.
     *
     * @return resolutions.
     */
    public native double[] getResolutions();

    /**
     * Get the extent of a tile coordinate.
     *
     * @param tileCoord Tile coordinate.
     *
     * @return Extent.
     */
    public native Extent getTileCoordExtent(TileCoord tileCoord);

    /**
     * Get the extent of a tile coordinate.
     *
     * @param tileCoord Tile coordinate.
     * @param extent Temporary extent object.
     *
     * @return Extent.
     */
    public native Extent getTileCoordExtent(TileCoord tileCoord, Extent extent);

    /**
     * Get the tile coordinate for the given map coordinate and resolution. This method considers that
     * coordinates that intersect tile boundaries should be assigned the higher tile coordinate.
     *
     * @param coordinate Coordinate.
     * @param resolution Resolution.
     *
     * @return Tile coordinate.
     */
    public native Coordinate getTileCoordForCoordAndResolution(Coordinate coordinate, double resolution);

    /**
     * Get the tile coordinate for the given map coordinate and resolution. This method considers that
     * coordinates that intersect tile boundaries should be assigned the higher tile coordinate.
     *
     * @param coordinate Coordinate.
     * @param resolution Resolution.
     * @param tileCoord Destination object.
     *
     * @return Tile coordinate.
     */
    public native Coordinate getTileCoordForCoordAndResolution(Coordinate coordinate, double resolution,
        TileCoord tileCoord);

    /**
     * Get a tile coordinate given a map coordinate and zoom level.
     *
     * @param coordinate Coordinate.
     * @param z Zoom level.
     *
     * @return Tile coordinate.
     */
    public native TileCoord getTileCoordForCoordAndZ(Coordinate coordinate, int z);

    /**
     * Get a tile coordinate given a map coordinate and zoom level.
     *
     * @param coordinate Coordinate.
     * @param z Zoom level.
     * @param tileCoord Destination object.
     *
     * @return Tile coordinate.
     */
    public native TileCoord getTileCoordForCoordAndZ(Coordinate coordinate, int z, TileCoord tileCoord);

    /**
     * Get the tile size for a zoom level. The type of the return value matches
     * the `tileSize` or `tileSizes` that the tile grid was configured with. To
     * always get an `ol.Size`, run the result through `ol.size.toSize()`.
     *
     * @param z
     *            Z.
     * @return {number|ol.Size} Tile size.
     */
    public native Size getTileSize(int z);

}
