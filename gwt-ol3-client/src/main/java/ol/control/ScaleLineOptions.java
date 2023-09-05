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

/**
 * Scale line control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ScaleLineOptions extends ControlOptions {

    /**
     * Render scalebars instead of a line (default: false).
     *
     * @param renderScalebar should a scalebar be rendered
     */
    @JsProperty
    public native void setBar(boolean renderScalebar);

    /**
     * CSS class name. Default is "ol-scale-line".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     *  dpi of output device such as printer. Only applies when bar is true. If undefined the
     *  OGC default screen pixel size of 0.28mm will be assumed.
     *
     * @param dpi dpi of output device
     */
    @JsProperty
    public native void setDpi(double dpi);

    /**
     * Minimum width in pixels. Default is 64.
     *
     * @param minWidth
     *            minimum width
     */
    @JsProperty
    public native void setMinWidth(int minWidth);

    /**
     * Maximum width in pixels at the OGC default dpi. The width will be adjusted to match the dpi used.
     *
     * @param maxWidth Maximum width in pixels at the OGC default dpi
     */
    @JsProperty
    public native void setMaxWidth(int maxWidth);

    /**
     * Number of steps the scalebar should use. Use even numbers for best results. Only applies when bar is true.
     *
     * @param steps Number of steps the scalebar should use
     */
    @JsProperty
    public native void setSteps(int steps);

    /**
     * Render the text scale above of the scalebar. Only applies when bar is true.
     *
     * @param renderTextAboveScalebar if text should be rendered above of the scalebar
     */
    @JsProperty
    public native void setText(boolean renderTextAboveScalebar);

    /**
     * Units. Default is metric.
     * @param units
     *            units
     */
    @JsProperty
    public native void setUnits(String units);

}
