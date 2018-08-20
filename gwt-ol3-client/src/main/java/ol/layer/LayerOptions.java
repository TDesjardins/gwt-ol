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
package ol.layer;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.Options;
import ol.source.Source;

/**
 * Layer options
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LayerOptions implements Options {

    /**
     * The bounding extent for layer rendering. The layer will not be rendered
     * outside of this extent.
     *
     * @param extent extent
     */
    @JsProperty
    public native void setExtent(Extent extent);

    /**
     * The maximum resolution (exclusive) below which this layer will be
     * visible.
     *
     * @param maxResolution maximum resolution
     */
    @JsProperty
    public native void setMaxResolution(double maxResolution);

    /**
     * The minimum resolution (inclusive) at which this layer will be visible.
     *
     * @param minResolution minimum resolution
     */
    @JsProperty
    public native void setMinResolution(double minResolution);

    /**
     * Opacity (0, 1). Default is 1.
     *
     * @param opacity opacity
     */
    @JsProperty
    public native void setOpacity(double opacity);

    /**
     * Source for this layer. Required.
     *
     * @param source {@link Source}
     */
    @JsProperty
    public native void setSource(Source source);

    /**
     * Visibility. Default is true (visible).
     *
     * @param visible visible?
     */
    @JsProperty
    public native void setVisible(boolean visible);

    /**
     * The z-index for layer rendering. At rendering time, the layers will be
     * ordered, first by Z-index and then by position. The default Z-index is 0.
     *
     * @param zIndex z-index
     */
    @JsProperty
    public native void setZIndex(int zIndex);

}
