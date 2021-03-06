/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.tilegrid.TileGrid;

/**
 * Abstract tile options.
 *
 * @author Tino Desjardins
 *
 * see https://openlayers.org/en/latest/apidoc/ol.source.Tile.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileOptions extends SourceOptions {

    /**
     * @return Cache size.
     */
    @JsProperty
    public native int getCacheSize();

    /**
     * @param cacheSize Cache size
     */
    @JsProperty
    public native void setCacheSize(int cacheSize);

    /**
     * Gets the {@link TileGrid}.
     *
     * @return tileGrid {@link TileGrid}
     */
    @JsProperty
    public native TileGrid getTileGrid();

    /**
     * Set the {@link TileGrid}.
     *
     * @param tileGrid {@link TileGrid}
     */
    @JsProperty
    public native void setTileGrid(TileGrid tileGrid);

    /**
     * Duration of the opacity transition for rendering. To disable the opacity transition, pass transition: 0, default 250.
     *
     * @param duration in milliseconds.
     */
    @JsProperty
    public native void setTransition(int duration);

}
