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
package ol.color;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * A color represented as a short array [red, green, blue, alpha]. red, green,
 * and blue should be integers in the range 0..255 inclusive. alpha should be a
 * float in the range 0..1 inclusive.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Color implements JsArrayLike<Double> {

    @JsOverlay
    private static final String PACKAGE_COLOR = "ol.color";

    /**
     * @param red red (0-255)
     * @param green green (0-255)
     * @param blue blue (0-255)
     * @param alpha alpha (0-1), 1 is solid
     */
    public Color(int red, int green, int blue, double alpha) {}

    /**
     * This method maintains a cache of calculated arrays which means the result
     * should not be modified.
     *
     * @param colorString colorString color in rgb(r,g,b) or rgba(r,g,b,a) format,
     * or in hex #rrggbb or #rgb format
     * @return cached color
     */
    @JsMethod(name = "asArray", namespace = PACKAGE_COLOR)
    private static native Color asArray(String colorString);

    /**
     * Return the color as an rgba string.
     *
     * @return rgba string
     */
    @JsOverlay
    public final String asString() {
        return Color.asString(this);
    }

    /**
     * Return the color as an rgba string.
     *
     * @param color
     * @return rgba string
     */
    @JsMethod(namespace = PACKAGE_COLOR)
    private static native String asString(Color color);

    /**
     * Clones this object.
     *
     * @return clone
     */
    @JsOverlay
    public final Color cloneObject() {
        return this.slice(0);
    };

    /**
     * 
     * @param colorString color in rgb(r,g,b) or rgba(r,g,b,a) format, or in hex #rrggbb
     * or #rgb format
     *
     * @return color
     */
    @JsOverlay
    public static final Color getColorFromString(String colorString) {
        // clone because original color is cached
        return asArray(colorString).cloneObject();
    };

    /**
     * Gets the alpha value.
     *
     * @return alpha value (0-1)
     */
    @JsOverlay
    public final float getAlpha() {
        return this.getAt(3).floatValue();
    };

    /**
     * Gets the blue value.
     *
     * @return blue value (0-255)
     */
    @JsOverlay
    public final int getBlue() {
        return this.getAt(2).intValue();
    };

    /**
     * Gets the green value.
     *
     * @return green value (0-255)
     */
    @JsOverlay
    public final int getGreen() {
        return this.getAt(1).intValue();
    };

    /**
     * Gets the red value.
     *
     * @return red value (0-255)
     */
    @JsOverlay
    public final int getRed() {
        return this.getAt(0).intValue();
    };

    private native Color slice(int begin);

}
