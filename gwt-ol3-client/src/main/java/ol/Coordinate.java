package ol;

import com.google.gwt.core.client.JsArrayNumber;

/**
 * An array of numbers representing an xy coordinate. Example: [16, 48].
 * @author sbaumhekel
 */
public class Coordinate extends JsArrayNumber
{

	@Deprecated
	protected Coordinate()
	{
	}

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @return {@link Coordinate}
	 */
	public static native Coordinate create(double x, double y)
	/*-{
		return [ x, y ];
	}-*/;

	/**
	 * Constructs an instance.
	 * @param x X-coordinate (longitude)
	 * @param y Y-coordinate (latitude)
	 * @param z Z-coordinate
	 * @return {@link Coordinate}
	 */
	public static native Coordinate create(double x, double y, double z)
	/*-{
		return [ x, y, z ];
	}-*/;

	/**
	 * Constructs an instance.
	 * @param coords coordinate array
	 * @return {@link Coordinate}
	 */
	public static Coordinate create(double[] coords)
	{
		if (coords.length > 2)
		{
			return create(coords[0], coords[1], coords[2]);
		}
		else
		{
			return create(coords[0], coords[1]);
		}
	}

	/**
	 * Add `delta` to `coordinate`. `coordinate` is modified in place and returned by the function. Example: var coord =
	 * [7.85, 47.983333]; ol.coordinate.add(coord, [-2, 4]); // coord is now [5.85, 51.983333]
	 * @param delta {ol.Coordinate} delta Delta.
	 * @return {ol.Coordinate} The input coordinate adjusted by the given delta.
	 * @api stable
	 */
	public final native Coordinate add(Coordinate delta)
	/*-{
		return $wnd.ol.add(this, delta);
	}-*/;

	/**
	 * Gets the dimension of this coordinate.
	 * @return dimension
	 */
	public final int getDimension()
	{
		return this.length();
	}

	/**
	 * Gets the X-coordinate (longitude).
	 * @return X-coordinate (longitude)
	 */
	public final double getX()
	{
		if (this.length() > 0)
		{
			return this.get(0);
		}
		return Double.NaN;
	}

	/**
	 * Gets the Y-coordinate (latitude).
	 * @return Y-coordinate (latitude)
	 */
	public final double getY()
	{
		if (this.length() > 1)
		{
			return this.get(1);
		}
		return Double.NaN;
	}

	/**
	 * Gets the Y-coordinate (latitude).
	 * @return Y-coordinate (latitude)
	 */
	public final double getZ()
	{
		if (this.length() > 2)
		{
			return this.get(2);
		}
		return Double.NaN;
	}

	/**
	 * Gets the latitude.
	 * @return latitude
	 */
	public final double lat()
	{
		return this.getY();
	}

	/**
	 * Gets the longitude.
	 * @return longitude
	 */
	public final double lon()
	{
		return this.getX();
	}

	/**
	 * Format a coordinate as a comma delimited string. Example without specifying fractional digits: var coord = [7.85,
	 * 47.983333]; var out = ol.coordinate.toStringXY(coord); // out is now '8, 48' Example explicitly specifying 1
	 * fractional digit: var coord = [7.85, 47.983333]; var out = ol.coordinate.toStringXY(coord, 1); // out is now
	 * '7.8, 48.0'
	 * @param fractionDigits The number of digits to include after the decimal point. Default is `0`.
	 * @return {string} XY.
	 * @api stable
	 */
	public final native String toStringXY(int fractionDigits)
	/*-{
		return ol.coordinate.toStringXY(this, fractionDigits);
	}-*/;
}
