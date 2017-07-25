/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
public interface Stroke {

    /**
     * Set the color.
     *
     * @param color color.
     */
    void setColor(Color color);

    /**
     * Get the stroke color.
     *
     * @return
     */
    Color getColor();

    /**
     * Clones the Stroke
     *
     * @return
     */
    Stroke clone();

    /**
     * Get the line cap type for the stroke.
     *
     * @return
     */
    String getLineCap();

    /**
     * Get the line dash style for the stroke.
     *
     * @return
     */
    int[] getLineDash();

    /**
     * Get the line dash offset for the stroke.
     *
     * @return Line dash offset.
     */
    int getLineDashOffset();

    /**
     * Get the line join type for the stroke.
     *
     * @return
     */
    String getLineJoin();

    /**
     * Get the miter limit for the stroke.
     *
     * @return
     */
    int getMiterLimit();

    /**
     * Get the stroke width.
     *
     * @return
     */
    int getWidth();

    /**
     * Set the line cap.
     *
     * @param value
     */
    void setLineCap(String value);

    /**
     * Set the line dash.
     *
     * Please note that Internet Explorer 10 and lower do not support the setLineDash method on the CanvasRenderingContext2D
     * and therefore this property will have no visual effect in these browsers.
     *
     * @param value
     */
    void setLineDash(int[] value);

    /**
     * Set the line dash offset.
     *
     * @param lineDashOffset Line dash offset.
     */
    void setLineDashOffset(int lineDashOffset);

    /**
     * Set the line join.
     *
     * @param value
     */
    void setLineJoin(String value);

    /**
     * Set the miter limit.
     *
     * @param value
     */
    void setMiterLimit(int value);

    /**
     * Set the width.
     *
     * @param value
     */
    void setWidth(int value);

}
