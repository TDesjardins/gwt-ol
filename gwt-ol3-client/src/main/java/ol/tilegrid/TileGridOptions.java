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

import jsinterop.annotations.JsPackage;
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
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileGridOptions implements Options {

    /**
     * Set the Extent for the tile grid. No tiles outside this extent will be
     * requested by ol.source.Tile sources. When no origin or origins are
     * configured, the origin will be set to the top-left corner of the extent.
     *
     * @param extent {@link Extent}
     */
    @JsProperty
    public native void setExtent(Extent extent);

    /**
     * Set the Minimum zoom. Default is 0.
     *
     * @param minZoom minimum zoom
     */
    @JsProperty
    public native void setMinZoom(int minZoom);

    /**
     * Set the tile grid origin, i.e. where the x and y axes meet ([z, 0, 0]).
     * Tile coordinates increase left to right and upwards. If not specified,
     * extent or origins must be provided.
     *
     * @param coordinate {@link Coordinate}
     */
    @JsProperty
    public native void setOrigin(Coordinate coordinate);

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
    public native void setOrigins(Coordinate[] origins);

    /**
     * Set resolutions. The array index of each resolution needs to match the
     * zoom level. This means that even if a minZoom is configured, the
     * resolutions array will have a length of maxZoom + 1. Required.
     *
     * @param resolutions resolutions
     */
    @JsProperty
    public native void setResolutions(double[] resolutions);

    /**
     * Set the tile size. Default is [256, 256].
     *
     * @param tileSize tile size
     */
    @JsProperty
    public native void setTileSize(Size tileSize);

    /**
     * Set the tile sizes. If given, the array length should match the length of
     * the resolutions array, i.e. each resolution can have a different tile
     * size.
     *
     * @param tileSizes tile sizes
     */
    @JsProperty
    public native void setTileSizes(Size[] tileSizes);

}
