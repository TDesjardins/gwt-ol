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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array with two elements, representing a pixel. The first element is the
 * x-coordinate, the second the y-coordinate of the pixel.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Pixel implements JsArrayLike<Double> {

    /**
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Pixel(int x, int y) {}

    /**
     * Clones this object.
     *
     * @return {ol.Pixel} clone
     */
    @JsOverlay
    public final Pixel cloneObject() {
        return this.slice(0);
    };

    private native Pixel slice(int begin);

    /**
     * Gets the X-coordinate.
     *
     * @return X-coordinate
     */
    @JsOverlay
    public final int getX() {
        if (this.getLength() > 0) {
            return this.getAt(0).intValue();
        }
        return -1;
    }

    /**
     * Gets the Y-coordinate.
     *
     * @return Y-coordinate
     */
    @JsOverlay
    public final int getY() {
        if (this.getLength() > 1) {
            return this.getAt(1).intValue();
        }
        return -1;
    }

}
