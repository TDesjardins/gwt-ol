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
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Size;

/**
 * XYZ options.
 *
 * @author Tino Desjardins
 *
 * @see http://openlayers.org/en/latest/apidoc/ol.source.XYZ.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class XyzOptions extends TileImageOptions {

    /**
     * Set the optional max zoom level. Default is 18.
     *
     * @param maxZoom max zoom
     */
    @JsProperty
    public native void setMaxZoom(int maxZoom);

    @JsProperty
    public native int getMaxZoom();

    /**
     * Set the tile size used by the tile service. Default is [256, 256] pixels.
     * 
     * @param tileSize tile size
     */
    @JsProperty
    public native void setTileSize(Size tileSize);

    @JsProperty
    public native Size getTileSize();

}
