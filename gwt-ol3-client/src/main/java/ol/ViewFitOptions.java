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

/**
 * Options for calling {@link ol.View#fit(Extent, ViewFitOptions)} or
 * {@link ol.View#fit(ol.geom.SimpleGeometry, ViewFitOptions)}.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewFitOptions implements Options {

    /**
     * The duration of the animation in milliseconds. By default, there is no
     * animations.
     * @param duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Maximum zoom level that we zoom to. If minResolution is given, this
     * property is ignored.
     * @param maxZoom
     */
    @JsProperty
    public native void setMaxZoom(double maxZoom);

    /**
     * Minimum resolution that we zoom to. Default is 0.
     * @param minResolution
     */
    @JsProperty
    public native void setMinResolution(double minResolution);

    /**
     * Get the nearest extent. Default is false.
     * @param nearest
     */
    @JsProperty
    public native void setNearest(boolean nearest);

    /**
     * The size in pixels of the box to fit the extent into. Default is the
     * current size of the first map in the DOM that uses this view, or [100,
     * 100] if no such map is found.
     * @param size
     */
    @JsProperty
    public native void setSize(ol.Size size);

}
