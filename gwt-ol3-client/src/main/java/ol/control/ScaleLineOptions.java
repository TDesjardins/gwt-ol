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
     * CSS class name. Default is "ol-scale-line".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Minimum width in pixels. Default is 64.
     * @param minWidth
     *            minimum width
     */
    @JsProperty
    public native void setMinWidth(int minWidth);

    /**
     * Units. Default is metric.
     * @param units
     *            units
     */
    @JsProperty
    public native void setUnits(String units);

}
