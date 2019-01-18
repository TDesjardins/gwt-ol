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
package proj4;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array of numbers representing an xy coordinate. Example: [16, 48].
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Coordinate implements JsArrayLike<Double> {

    /**
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Coordinate(double x, double y) {}

    /**
     * Gets the X-coordinate (longitude).
     *
     * @return X-coordinate (longitude)
     */
    @JsOverlay
    public final double getX() {
        if (this.getLength() > 0) {
            return this.getAt(0);
        }
        return Double.NaN;
    }

    /**
     * Sets the X-coordinate (longitude).
     *
     * @param x X-coordinate (longitude)
     */
    @JsOverlay
    public final void setX(double x) {
        this.setAt(0, x);
    }

    /**
     * Gets the Y-coordinate (latitude).
     *
     * @return Y-coordinate (latitude)
     */
    @JsOverlay
    public final double getY() {
        if (this.getLength() > 1) {
            return this.getAt(1);
        }
        return Double.NaN;
    }

    /**
     * Sets the Y-coordinate (latitude).
     *
     * @param y Y-coordinate (latitude)
     */
    @JsOverlay
    public final void setY(double y) {
        this.setAt(1, y);
    }

}
