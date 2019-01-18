/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * An array of numbers representing an extent: `[minx, miny, maxx, maxy]`.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true, name = "Array", namespace = JsPackage.GLOBAL)
public class Extent implements JsArrayLike<Double> {

    @JsOverlay
    private static final String PACKAGE_EXTENT = "ol.extent";

    /**
     * @param minX minimum coordinate X
     * @param minY minimum coordinate Y
     * @param maxX maximum coordinate X
     * @param maxY maximum coordinate Y
     */
    public Extent(double minX, double minY, double maxX, double maxY) {}

    /**
     * @param buffer the amount by which the extent should be buffered.
     * @return extent increased by the provided value.
     */
    @JsOverlay
    public final Extent buffer(double buffer) {
        return buffer(this, buffer);
    }

    @JsMethod(name = "buffer", namespace = PACKAGE_EXTENT)
    private static native Extent buffer(Extent extent, double buffer);

    /**
     * @param coordinate coordinate to check.
     * @return true if the passed coordinate is contained or on the edge of the extent.
     */
    @JsOverlay
    public final boolean containsCoordinate(Coordinate coordinate) {
        return containsCoordinate(this, coordinate);
    }

    @JsMethod(name = "containsCoordinate", namespace = PACKAGE_EXTENT)
    private static native boolean containsCoordinate(Extent extent, Coordinate coordinater);

    /**
     * Check if this extent contains another.
     *
     * @param extent extent to check.
     * @return true if it lies completely within this extent, including if they share one or more edges.
     */
    @JsOverlay
    public final boolean containsExtent(Extent extent) {
        return containsExtent(this, extent);
    }

    @JsMethod(name = "containsExtent", namespace = PACKAGE_EXTENT)
    private static native boolean containsExtent(Extent extent1, Extent extent2);

    
    /**
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return true if the passed coordinate is contained or on the edge of the extent.
     */
    @JsOverlay
    public final boolean containsXY(double x, double y) {
        return containsXY(this, x, y);
    }

    @JsMethod(name = "containsXY", namespace = PACKAGE_EXTENT)
    private static native boolean containsXY(Extent extent, double x, double y);

    /**
     * Constructs an instance.
     *
     * @param minX minimum coordinate X
     * @param minY minimum coordinate Y
     * @param maxX maximum coordinate X
     * @param maxY maximum coordinate Y
     * @return {@link Extent}
     * @deprecated Use {@link #Extent(double, double, double, double)} instead.
     */
    @Deprecated
    @JsOverlay
    public final static Extent create(double minX, double minY, double maxX, double maxY) {
        return new Extent(minX, minY, maxX, maxY);
    };

    /**
     * @return an empty extent
     */
    @JsMethod(name = "createEmpty", namespace = PACKAGE_EXTENT)
    public static native Extent createEmpty();

    /**
     * Clones this object.
     *
     * @return {ol.Extent} clone
     */
    @JsOverlay
    public final Extent cloneObject() {
        return this.slice(0);
    };

    private native Extent slice(int begin);

    /**
     * @param extent extent to check
     * @return if extents are equivalent.
     */
    @JsOverlay
    public final boolean equals(Extent extent) {
        return equals(this, extent);
    }

    @JsMethod(name = "equals", namespace = PACKAGE_EXTENT)
    private static native boolean equals(Extent extent1, Extent extent2);

    /**
     * Modify this extent to include another extent.
     *
     * @param extent the extent that will be included.
     * @return a reference to this (extended) extent
     */
    @JsOverlay
    public final Extent extend(Extent extent) {
        return extend(this, extent);
    }

    @JsMethod(name = "extend", namespace = PACKAGE_EXTENT)
    private static native Extent extend(Extent extent1, Extent extent2);

    /**
     * @return the area of the extent.
     */
    @JsOverlay
    public final double getArea() {
        return Extent.getArea(this);
    }

    @JsMethod(name = "getArea", namespace = PACKAGE_EXTENT)
    private static native double getArea(Extent extent);

    /**
     * @return the height of the extent.
     */
    @JsOverlay
    public final double getHeight() {
        return Extent.getHeight(this);
    }

    @JsMethod(name = "getHeight", namespace = PACKAGE_EXTENT)
    private static native double getHeight(Extent extent);

    /**
     * Gets the minimum X coordinate.
     *
     * @return minimum X coordinate.
     */
    @JsOverlay
    public final double getLowerLeftX() {
        if (this.getLength() > 0) {
            return this.getAt(0);
        }
        return Double.NaN;
    };

    /**
     * Gets the minimum Y coordinate.
     *
     * @return minimum Y coordinate.
     */
    @JsOverlay
    public final double getLowerLeftY() {
        if (this.getLength() > 1) {
            return this.getAt(1);
        }
        return Double.NaN;
    };

    /**
     * Gets the maximum X coordinate.
     *
     * @return maximum X coordinate.
     */
    @JsOverlay
    public final double getUpperRightX() {
        if (this.getLength() > 2) {
            return this.getAt(2);
        }
        return Double.NaN;
    };

    /**
     * Gets the maximum Y coordinate.
     *
     * @return maximum Y coordinate.
     */
    @JsOverlay
    public final double getUpperRightY() {
        if (this.getLength() > 3) {
            return this.getAt(3);
        }
        return Double.NaN;
    };

    /**
     * @return the top left coordinate of extent.
     */
    @JsOverlay
    public final Coordinate getTopLeft() {
        return Extent.getTopLeft(this);
    }

    @JsMethod(name = "getTopLeft", namespace = PACKAGE_EXTENT)
    private static native Coordinate getTopLeft(Extent extent);

    /**
     * @return the width of the extent.
     */
    @JsOverlay
    public final double getWidth() {
        return Extent.getWidth(this);
    }

    @JsMethod(name = "getWidth", namespace = PACKAGE_EXTENT)
    private static native double getWidth(Extent extent);

    /**
     * @return true if the extent is empty
     */
    @JsOverlay
    public final boolean isEmpty() {
        return Extent.isEmpty(this);
    }

    @JsMethod(name = "isEmpty", namespace = PACKAGE_EXTENT)
    private static native boolean isEmpty(Extent extent);

}
