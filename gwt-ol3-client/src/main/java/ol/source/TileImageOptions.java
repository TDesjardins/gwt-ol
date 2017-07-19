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
 * Options for {@link TileImage}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileImageOptions extends UrlTileOptions {
	
    /**
     * @param crossOrigin The <code>crossOrigin</code> attribute for loaded images. Note that you must provide a <code>crossOrigin</code> value if you are using the WebGL renderer or if you want to access pixel data with the Canvas renderer. See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/CORS_enabled_image">https://developer.mozilla.org/en-US/docs/Web/HTML/CORS_enabled_image</a> for more detail.
     */
    @JsProperty
    public native void setCrossOrigin(String crossOrigin);

    @JsProperty
    public native String getCrossOrigin();

    /**
     * @param opaque Whether the layer is opaque.
     */
    @JsProperty
    public native void setOpaque(Boolean opaque);

    @JsProperty
    public native Boolean getOpaque();

    /**
     * @param reprojectionErrorThreshold Maximum allowed reprojection error (in pixels). Default is <code>0.5</code>. Higher values can increase reprojection performance, but decrease precision.
     */
    @JsProperty
    public native void setReprojectionErrorThreshold(double reprojectionErrorThreshold);

    @JsProperty
    public native double getReprojectionErrorThreshold();

    /**
     * @param tile Class used to instantiate image tiles. Default is {@link ol.ImageTile}.
     */
    @JsProperty
    public native void setTileClass(ol.Tile tile);

    @JsProperty
    public native ol.Tile getTileClass();

}
