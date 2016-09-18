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
public class TileGrid {

    public TileGrid() {}
    
    public TileGrid(TileGridOptions tileGridOptions) {}
    
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
     * @return {Array.<number>} Resolutions.
     */
    public native double[] getResolutions();

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
