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
package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.proj.Projection;

/**
 * Options for creating a {@link ol.View}.
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewOptions implements Options {

    @JsProperty
    public native void setCenter(Coordinate coordinate);

    @JsProperty
    public native void setExtent(Extent extent);

    @JsProperty
    public native void setMaxResolution(double maxResolution);

    @JsProperty
    public native void setMinResolution(double minResolution);

    @JsProperty
    public native void setMaxZoom(double maxZoom);

    @JsProperty
    public native void setMinZoom(double minZoom);

    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * {@link #setProjection}
     *
     * @param srsCode combination of authority and identifier such as "EPSG:4326"
     */
    @JsProperty
    public native void setProjection(String srsCode);

    @JsProperty
    public native void setResolutions(double[] resolutions);

    @JsProperty
    public native void setZoom(double zoom);

    @JsProperty
    public native void setZoomFactor(double zoomFactor);
}
