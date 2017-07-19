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
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link VectorTile}
 * 
 * @author gkresic
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.source.VectorTile.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VectorTileOptions extends UrlTileOptions {
    
    /**
     * @param format Feature format for tiles. Used and required by the default {@link #setTileLoadFunction(TileLoadFunction)}.
     */
    @JsProperty
    public native void setFormat(ol.format.Feature format);

    @JsProperty
    public native ol.format.Feature getFormat();

    /**
     * @param overlaps This source may have overlapping geometries. Default is <code>true</code>. Setting this to <code>false</code> (e.g. for sources with polygons that represent administrative boundaries or TopoJSON sources) allows the renderer to optimise fill and stroke operations.
     */
    @JsProperty
    public native void setOverlaps(Boolean overlaps);

    @JsProperty
    public native Boolean getOverlaps();

    /**
     * @param tile Class used to instantiate image tiles. Default is {@link ol.VectorTile}.
     */
    @JsProperty
    public native void setTileClass(ol.Tile tile);

    @JsProperty
    public native ol.Tile getTileClass();

}