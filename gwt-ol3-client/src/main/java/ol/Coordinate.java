package ol;

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
	public final double setX(double x) {
		if (this.getDimension() > 0) {
			return this.set(0, x);
		}
		return Double.NaN;
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
	public final double setY(double y) {
		if (this.getDimension() > 1) {
			return this.set(1, y);
		}
		return Double.NaN;
	}

    /**
     * Gets the Y-coordinate (latitude).
     *
     * @return Y-coordinate (latitude)
     */
    public final double getZ() {
        if (this.getDimension() > 2) {
            return this.get(2);
        }
        return Double.NaN;
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
    public final static native JavaScriptObject createStringXY(int fractionDigits)
    /*-{
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
