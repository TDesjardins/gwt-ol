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

import ol.Extent;
import ol.Options;
import ol.Size;

/**
 * Options for grid with a standard XYZ tiling scheme.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class XyzTileGridOptions implements Options {

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
     * Set the Maximum zoom. Default is based on resolutions array.
     *
     * @param maxZoom maximum zoom
     */
    @JsProperty
    public native void setMaxZoom(int maxZoom);

    /**
     * Set the Minimum zoom. Default is 0.
     *
     * @param minZoom minimum zoom
     */
    @JsProperty
    public native void setMinZoom(int minZoom);

    /**
     * Set the tile size. Default is [256, 256].
     *
     * @param tileSize tile size
     */
    @JsProperty
    public native void setTileSize(Size tileSize);

}
