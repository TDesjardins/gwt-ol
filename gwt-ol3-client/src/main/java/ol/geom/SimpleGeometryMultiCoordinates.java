package ol.geom;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 * This is an additional class to provide an array of arrays of coordinates for
 * geometries and still allow {@link Point} to be a {@link SimpleGeometry}
 * though it only has one coordinate.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public abstract class SimpleGeometryMultiCoordinates extends SimpleGeometry {

    /**
     * Return the coordinates of this geometry.
     *
     * @return Coordinates.
     */
    public native Coordinate[][] getCoordinates();

    /**
     *
     * Set the coordinates of the polygon.
     *
     * @param coordinates
     */
    public native void setCoordinates(Coordinate[][] coordinates);

    /**
     * Set the coordinates of this geometry.
     *
     * @param coordinates
     *            Coordinates.
     * @param geometryLayout
     *            opt_layout Layout.
     */
    public native void setCoordinates(Coordinate[][] coordinates, @Nullable String geometryLayout);

}
