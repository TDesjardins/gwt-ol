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
package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for the circle style.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CircleOptions implements Options {

    /**
     * Fill style.
     * 
     * @param fill {@link Fill}
     */
    @JsProperty
    public native void setFill(Fill fill);

    /**
     * Circle radius. Required.
     * 
     * @param radius radius
     */
    @JsProperty
    public native void setRadius(double radius);

    /**
     * If true integral numbers of pixels are used as the X and Y pixel
     * coordinate when drawing the circle in the output canvas. If false
     * fractional numbers may be used. Using true allows for "sharp" rendering
     * (no blur), while using false allows for "accurate" rendering. Note that
     * accuracy is important if the circle's position is animated. Without it,
     * the circle may jitter noticeably. Default value is true.
     * 
     * @param snapToPixel snap to pixels?
     */
    @JsProperty
    public native void setSnapToPixel(boolean snapToPixel);

    /**
     * Stroke style.
     * 
     * @param stroke {@link Stroke}
     */
    @JsProperty
    public native void setStroke(Stroke stroke);

}
