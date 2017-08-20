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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An array of numbers representing an xy coordinate. Example: [16, 48].
 *
 * @author sbaumhekel
 */
public class Coordinate extends JavaScriptObject {

    @Deprecated
    protected Coordinate() {
    }

    /**
     * Creates an instance.
     *
     * @param x X-coordinate (longitude)
     * @param y Y-coordinate (latitude)
     * @return {@link Coordinate}
     */
    public static native Coordinate create(@NotNull double x, @NotNull double y) /*-{
        return [x, y];
    }-*/;
    
    /**
     * Creates an instance.
     *
     * @param x X-coordinate (longitude)
     * @param y Y-coordinate (latitude)
     * @param z Z-coordinate (height)
     * @return {@link Coordinate}
     */
    public static native Coordinate create(@NotNull double x, @NotNull double y, @NotNull double z) /*-{
        return [x, y, z];
    }-*/;

    /**
     * Add `delta` to `coordinate`. `coordinate` is modified in place and
     * returned by the function. Example: var coord = [7.85, 47.983333];
     * ol.coordinate.add(coord, [-2, 4]); // coord is now [5.85, 51.983333]
     *
     * @param delta
     *            {ol.Coordinate} delta Delta.
     * @return {ol.Coordinate} The input coordinate adjusted by the given delta.
     */
    public final native Coordinate add(Coordinate delta) /*-{
    	return $wnd.ol.coordinate.add(this, delta);
    }-*/;

    /**
     * Clones this object.
     *
     * @return {ol.Coordinate} clone
     */
    public final native Coordinate cloneObject() /*-{
    	return this.slice(0);
    }-*/;

    /**
     * Gets the value at a given index.
     *
     * @param index
     *            the index to be retrieved
     * @return the value at the given index
     */
    private final native double get(int index) /*-{
    	return this[index];
    }-*/;

	/**
	 * Sets the value at a given index.
	 *
	 * @param index the index to be retrieved
	 * @param value to set
	 */
	private final native double set(int index, double value) /*-{
		this[index] = value;
	}-*/;

    /**
     * Gets the dimension of this coordinate.
     *
     * @return dimension
     */
    public final int getDimension() {
        return this.length();
    }

    /**
     * Gets the X-coordinate (longitude).
     *
     * @return X-coordinate (longitude)
     */
    public final double getX() {
        if (this.getDimension() > 0) {
            return this.get(0);
        }
        return Double.NaN;
    }

	/**
	 * Sets the X-coordinate (longitude).
	 *
	 * @param x X-coordinate (longitude)
	 */
	public final void setX(double x) {
	    this.set(0, x);
	}

    /**
     * Gets the Y-coordinate (latitude).
     *
     * @return Y-coordinate (latitude)
     */
    public final double getY() {
        if (this.getDimension() > 1) {
            return this.get(1);
        }
        return Double.NaN;
    }

	/**
	 * Sets the Y-coordinate (latitude).
	 *
	 * @param y Y-coordinate (latitude)
	 */
	public final void setY(double y) {
		this.set(1, y);
	}

    /**
     * Gets the Z-coordinate (height).
     *
     * @return Z-coordinate (height)
     */
    public final double getZ() {
        if (this.getDimension() > 2) {
            return this.get(2);
        }
        return Double.NaN;
    }
    
    /**
     * Sets the Z-coordinate (height).
     *
     * @param z Z-coordinate (height)
     */
    public final void setZ(double z) {
        this.set(2, z);
    }

    /**
     * Gets the latitude.
     *
     * @return latitude
     */
    public final double lat() {
        return this.getY();
    }

    /**
     * Gets the length of the array.
     *
     * @return the array length
     */
    public final native int length() /*-{
    	return this.length;
    }-*/;

    /**
     * Gets the longitude.
     *
     * @return longitude
     */
    public final double lon() {
        return this.getX();
    }

    /**
     * Returns a {@link ol.CoordinateFormatType} function that can be used to format
     * a {ol.Coordinate} to a string.
     *
     * @param fractionDigits The number of digits to include after the decimal point.
     * Default is `0`
     * @return format function
     */
    public final static native JavaScriptObject createStringXY(int fractionDigits) /*-{
    	return $wnd.ol.coordinate.createStringXY(fractionDigits);
    }-*/;

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
     * @api stable
     */
    public final native String toStringXY(int fractionDigits) /*-{
    	return $wnd.ol.coordinate.toStringXY(this, fractionDigits);
    }-*/;

}
