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
 * An array of three numbers representing the location of a tile in a tile grid.
 * The order is z, x, and y. z is the zoom level.
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class TileCoord implements JsArrayLike<Double> {

    /**
     * @param z zoom
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public TileCoord(double z, double x, double y) {}

    /**
     * Clones this object.
     *
     * @return {ol.TileCoord} clone
     */
    @JsOverlay
    public final TileCoord cloneObject() {
    	return this.slice(0);
    };

    private native TileCoord slice(int begin);

    /**
     * Gets the zoom.
     *
     * @return zoom
     */
    @JsOverlay
    public final double getZ() {
        if (this.getLength() > 0) {
            return this.getAt(0);
        }
        return Double.NaN;
    };

    /**
     * Gets the x.
     *
     * @return x
     */
    @JsOverlay
    public final double getX() {
        if (this.getLength() > 1) {
            return this.getAt(1);
        }
        return Double.NaN;
    };

    /**
     * Gets the y.
     *
     * @return y
     */
    @JsOverlay
    public final double getY() {
        if (this.getLength() > 2) {
            return this.getAt(2);
        }
        return Double.NaN;
    };

}
