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

import javax.validation.constraints.NotNull;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array of numbers representing an xy coordinate. Example: [16, 48].
 *
 * @author sbaumhekel
 * @author TDesjardins
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Coordinate implements JsArrayLike<Double> {

    @JsOverlay
    private static final String PACKAGE_COORDINATE = "ol.coordinate";

    /**
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Coordinate(double x, double y) {}

    /**
     * @param x X-coordinate
     * @param y Y-coordinate
     * @param z Z-coordinate
     */
    public Coordinate(double x, double y, double z) {}

    /**
     * Creates an instance.
     *
     * @param x X-coordinate (longitude)
     * @param y Y-coordinate (latitude)
     * @return {@link Coordinate}
     *
     * @deprecated Use {@link #Coordinate(double, double)} instead.
     */
    @Deprecated
    @JsOverlay
    public static Coordinate create(@NotNull double x, @NotNull double y) {
        return new Coordinate(x, y);
    };

    /**
     * Creates an instance.
     *
     * @param x X-coordinate (longitude)
     * @param y Y-coordinate (latitude)
     * @param z Z-coordinate (height)
     * @return {@link Coordinate}
     *
     * @deprecated Use {@link #Coordinate(double, double, double)} instead.
     */
    @Deprecated
    @JsOverlay
    public static Coordinate create(@NotNull double x, @NotNull double y, @NotNull double z) {
        return new Coordinate(x, y, z);
    };

    /**
     * Add `delta` to `coordinate`. `coordinate` is modified in place and
     * returned by the function. Example: var coord = [7.85, 47.983333];
     * ol.coordinate.add(coord, [-2, 4]); // coord is now [5.85, 51.983333]
     *
     * @param delta
     *            {ol.Coordinate} delta Delta.
     * @return {ol.Coordinate} The input coordinate adjusted by the given delta.
     */
    @JsOverlay
    public final Coordinate add(Coordinate delta) {
        return add(this, delta);
    }

    @JsMethod(name = "add", namespace = PACKAGE_COORDINATE)
    private static native Coordinate add(Coordinate coordinate, Coordinate delta);

    /**
     * Clones this object.
     *
     * @return {ol.Coordinate} clone
     */
    @JsOverlay
    public final Coordinate cloneObject() {
        return this.slice(0);
    };

    private native Coordinate slice(int begin);

    /**
     * Gets the dimension of this coordinate.
     *
     * @return dimension
     */
    @JsOverlay
    public final int getDimension() {
        return this.getLength();
    }

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

    /**
     * Gets the Z-coordinate (height).
     *
     * @return Z-coordinate (height)
     */
    @JsOverlay
    public final double getZ() {
        if (this.getLength() > 2) {
            return this.getAt(2);
        }
        return Double.NaN;
    }

    /**
     * Sets the Z-coordinate (height).
     *
     * @param z Z-coordinate (height)
     */
    @JsOverlay
    public final void setZ(double z) {
        this.setAt(2, z);
    }

    /**
     * Gets the latitude.
     *
     * @return latitude
     */
    @JsOverlay
    public final double lat() {
        return this.getY();
    }

    /**
     * Gets the length of the array.
     *
     * @return the array length
     * @deprecated Use {@link ol.Coordinate#getLength()}
     */
    @Deprecated
    @JsOverlay
    public final int length() {
        return this.getLength();
    }

    /**
     * Gets the longitude.
     *
     * @return longitude
     */
    @JsOverlay
    public final double lon() {
        return this.getX();
    }

    /**
     * Returns a coordinate function that can be used to format
     * a {ol.Coordinate} to a string.
     *
     * @param fractionDigits The number of digits to include after the decimal point.
     * Default is `0`
     * @return format function
     */
    @JsMethod(name = "createStringXY", namespace = PACKAGE_COORDINATE)
    public final static native GenericFunction<Coordinate, String> createStringXY(int fractionDigits);

    /**
     * Format a coordinate as a comma delimited string. Example without
     * specifying fractional digits: var coord = [7.85, 47.983333]; var out =
     * ol.coordinate.toStringXY(coord); // out is now '8, 48' Example explicitly
     * specifying 1 fractional digit: var coord = [7.85, 47.983333]; var out =
     * ol.coordinate.toStringXY(coord, 1); // out is now '7.8, 48.0'
     *
     * @param fractionDigits
     *            The number of digits to include after the decimal point.
     *            Default is `0`.
     * @return {string} XY.
     */
    @JsOverlay
    public final String toStringXY(int fractionDigits) {
        return toStringXY(this, fractionDigits);
    }

    @JsMethod(name = "toStringXY", namespace = PACKAGE_COORDINATE)
    private final static native String toStringXY(Coordinate coordinate, int fractionDigits);

}
