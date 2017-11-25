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
package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Options for configuring the default controls of maps.
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DefaultControlsOptions implements Options {

    /**
     * @param attribution Attribution. Default is true.
     */
    @JsProperty
    public native void setAttribution(boolean attribution);

    /**
     * @param attributionOptions attribution options
     */
    @JsProperty
    public native void setAttributionOptions(AttributionOptions attributionOptions);

    /**
     * @param rotate Rotate. Default is true.
     */
    @JsProperty
    public native void setRotate(boolean rotate);

    /**
     * @param rotateOptions rotate options
     */
    @JsProperty
    public native void setRotateOptions(RotateOptions rotateOptions);

    /**
     * @param zoom Zoom. Default is true.
     */
    @JsProperty
    public native void setZoom(boolean zoom);

    /**
     * @param zoomOptions zoom options
     */
    @JsProperty
    public native void setZoomOptions(ZoomOptions zoomOptions);

}
