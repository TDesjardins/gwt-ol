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
import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class StrokeOptions implements Options {

    /**
     * Set the stroke color.
     *
     * @param color {@link Color}
     */
    @JsProperty
    public native void setColor(Color color);

    /**
     * Set the stroke width.
     *
     * @param width width
     */
    @JsProperty
    public native void setWidth(int width);

    /**
     * Set the Line cap style: butt, round, or square. Default is round.
     *
     * @param lineCap
     *            lineCap
     */
    @JsProperty
    public native void setLineCap(String lineCap);

    /**
     * Set the Line join style: bevel, round, or miter. Default is round.
     *
     * @param lineJoin
     *           lineJoin
     */
    @JsProperty
    public native void setLineJoin(String lineJoin);

    /**
     * Set the Line dash pattern. Default is undefined (no dash).
     *
     * @param lineDash
     *           int[]
     */
    @JsProperty
    public native void setLineDash(int[] lineDash);

    /**
     * Set the Miter limit. Default is 10.
     *
     * @param miterLimit
     *           int
     */
    @JsProperty
    public native void setMiterLimit(int miterLimit);

}
