package ol.geom;

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 * Point geometry.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public class Point extends SimpleGeometry {
    
    /**
     * Return the coordinates of this geometry.
     *
     * @return Coordinates.
     */
    public native Coordinate getCoordinates();

    /**
     * Set the coordinates of this geometry.
     *
     * @param coordinates
     *            Coordinates.
     * @param geometryLayout
     *            opt_layout Layout.
     */
    public native void setCoordinates(Coordinate coordinates, @Nullable String geometryLayout);
    
}
