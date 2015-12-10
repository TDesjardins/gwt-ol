package ol.geom;

import javax.annotation.Nullable;

import ol.Coordinate;

/**
 * This is an additional class to provide an array of coordinates for geometries
 * and still allow {@link Point} to be a {@link SimpleGeometry} though it only
 * has one coordinate.
 * 
 * @author sbaumhekel
 */
public interface SimpleGeometryMultiCoordinates extends SimpleGeometry {
    /**
     * Return the coordinates of this geometry.
     *
     * @return Coordinates.
     */
    Coordinate[] getCoordinates();

    /**
     * Set the coordinates of this geometry.
     *
     * @param coordinates
     *            Coordinates.
     * @param geometryLayout
     *            opt_layout Layout.
     */
    void setCoordinates(Coordinate[] coordinates, @Nullable String geometryLayout);

}
