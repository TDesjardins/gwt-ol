package ol.tilegrid;

import jsinterop.annotations.JsType;

import ol.Coordinate;
import ol.Extent;
import ol.Size;

/**
 * Base class for setting the grid pattern for sources accessing tiled-image
 * servers.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface TileGrid {

    /**
     * Get the extent for this tile grid, if it was configured.
     * 
     * @return {ol.Extent} Extent.
     */
    Extent getExtent();

    /**
     * Get the maximum zoom level for the grid.
     * 
     * @return {number} Max zoom.
     */
    int getMaxZoom();

    /**
     * Get the minimum zoom level for the grid.
     * 
     * @return {number} Min zoom.
     */
    int getMinZoom();

    /**
     * Get the origin for the grid at the given zoom level.
     * 
     * @param z
     *            Z.
     * @return {ol.Coordinate} Origin.
     */
    Coordinate getOrigin(int z);

    /**
     * Get the resolution for the given zoom level.
     * 
     * @param z
     *            Z.
     * @return {number} Resolution.
     */
    double getResolution(int z);

    /**
     * Get the list of resolutions for the tile grid.
     * 
     * @return {Array.<number>} Resolutions.
     */
    double[] getResolutions();

    /**
     * Get the tile size for a zoom level. The type of the return value matches
     * the `tileSize` or `tileSizes` that the tile grid was configured with. To
     * always get an `ol.Size`, run the result through `ol.size.toSize()`.
     * 
     * @param z
     *            Z.
     * @return {number|ol.Size} Tile size.
     */
    Size getTileSize(int z);

}
