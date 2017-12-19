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

import jsinterop.annotations.JsType;
import ol.color.Color;

/**
 * stroke style
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class Stroke {

    public Stroke() {}

    public Stroke(StrokeOptions strokeOptions) {}

    /**
     * Set the color.
     *
     * @param color color.
     */
    public native void setColor(Color color);

    /**
     * Get the stroke color.
     *
     * @return
     */
    public native Color getColor();

    /**
     * Clones the Stroke
     *
     * @return
     */
    public native Stroke clone();

    /**
     * Get the line cap type for the stroke.
     *
     * @return
     */
    public native String getLineCap();

    /**
     * Get the line dash style for the stroke.
     *
     * @return
     */
    public native int[] getLineDash();

    /**
     * Get the line dash offset for the stroke.
     *
     * @return Line dash offset.
     */
    public native int getLineDashOffset();

    /**
     * Get the line join type for the stroke.
     *
     * @return
     */
    public native String getLineJoin();

    /**
     * Get the miter limit for the stroke.
     *
     * @return
     */
    public native int getMiterLimit();

    /**
     * Get the stroke width.
     *
     * @return
     */
    public native int getWidth();

    /**
     * Set the line cap.
     *
     * @param value
     */
    public native void setLineCap(String value);

    /**
     * Set the line dash.
     *
     * Please note that Internet Explorer 10 and lower do not support the setLineDash method on the CanvasRenderingContext2D
     * and therefore this property will have no visual effect in these browsers.
     *
     * @param value
     */
    public native void setLineDash(int[] value);

    /**
     * Set the line dash offset.
     *
     * @param lineDashOffset Line dash offset.
     */
    public native void setLineDashOffset(int lineDashOffset);

    /**
     * Set the line join.
     *
     * @param value
     */
    public native void setLineJoin(String value);

    /**
     * Set the miter limit.
     *
     * @param value
     */
    public native void setMiterLimit(int value);

    /**
     * Set the width.
     *
     * @param value
     */
    public native void setWidth(int value);

}
