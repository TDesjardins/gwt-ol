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
import ol.Coordinate;
import ol.GenericFunction;
import ol.proj.Projection;

/**
 * Mouse position options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MousePositionOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-mouse-position".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * 
     * @param coordinateFormat Coordinate format function.
     */
    @JsProperty
    public native void setCoordinateFormat(GenericFunction<Coordinate, String> coordinateFormat);
    
    /**
     * Projection.
     * @param projection
     *            {@link Projection}
     */
    @JsProperty
    public native void setProjection(Projection projection);

    /**
     * Markup for undefined coordinates. Default is "" (empty string).
     * @param undefinedHTML
     *            undefined HTML
     */
    @JsProperty
    public native void setUndefinedHTML(String undefinedHTML);

}
