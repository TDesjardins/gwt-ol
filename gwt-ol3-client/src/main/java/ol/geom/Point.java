package ol.geom;

import javax.annotation.Nullable;

import com.google.gwt.core.client.js.JsType;

import ol.Coordinate;

/**
 * Point geometry.
 *
 * @author sbaumhekel
 *
 */
@JsType(prototype = "ol.geom.Point")
public interface Point extends SimpleGeometry {
    /**
     * Return the coordinates of this geometry.
     *
     * @return Coordinates.
     */
    Coordinate getCoordinates();

    /**
     * Set the coordinates of this geometry.
     *
     * @param coordinates
     *            Coordinates.
     * @param geometryLayout
     *            opt_layout Layout.
     */
    void setCoordinates(Coordinate coordinates, @Nullable String geometryLayout);
}
