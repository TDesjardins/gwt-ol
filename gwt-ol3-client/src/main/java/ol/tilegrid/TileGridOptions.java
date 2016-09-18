package ol.tilegrid;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Coordinate;
import ol.Extent;
import ol.Options;
import ol.Size;

/**
 * {@link TileGrid} options.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface TileGridOptions extends Options {

    /**
     * Set the Extent for the tile grid. No tiles outside this extent will be
     * requested by ol.source.Tile sources. When no origin or origins are
     * configured, the origin will be set to the top-left corner of the extent.
     *
     * @param extent {@link Extent}
     */
    @JsProperty
    void setExtent(Extent extent);

    /**
     * Set the Maximum zoom. Default is based on resolutions array.
     *
     * @param maxZoom maximum zoom
     */
    @JsProperty
    void setMaxZoom(int maxZoom);

    /**
     * Set the Minimum zoom. Default is 0.
     *
     * @param minZoom minimum zoom
     */
    @JsProperty
    void setMinZoom(int minZoom);

    /**
     * Set the tile grid origin, i.e. where the x and y axes meet ([z, 0, 0]).
     * Tile coordinates increase left to right and upwards. If not specified,
     * extent or origins must be provided.
     * 
     * @param coordinate {@link Coordinate}
     */
    @JsProperty
    void setOrigin(Coordinate coordinate);

    /**
     * Set the tile grid origins, i.e. where the x and y axes meet ([z, 0, 0]),
     * for each zoom level. If given, the array length should match the length
     * of the resolutions array, i.e. each resolution can have a different
     * origin. Tile coordinates increase left to right and upwards. If not
     * specified, extent or origin must be provided.
     * 
     * @param origins origins
     */
    @JsProperty
    void setOrigins(Coordinate[] origins);

    /**
     * Set resolutions. The array index of each resolution needs to match the
     * zoom level. This means that even if a minZoom is configured, the
     * resolutions array will have a length of maxZoom + 1. Required.
     * 
     * @param resolutions resolutions
     */
    @JsProperty
    void setResolutions(double[] resolutions);

    /**
     * Set the tile size. Default is [256, 256].
     * 
     * @param tileSize tile size
     */
    @JsProperty
    void setTileSize(Size tileSize);

    /**
     * Set the tile sizes. If given, the array length should match the length of
     * the resolutions array, i.e. each resolution can have a different tile
     * size.
     * 
     * @param tileSizes tile sizes
     */
    @JsProperty
    void setTileSizes(Size[] tileSizes);

}
