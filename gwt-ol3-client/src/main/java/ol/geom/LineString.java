package ol.geom;

import javax.annotation.Nullable;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.js.JsType;

import ol.Coordinate;

/**
 * Linestring geometry.
 * 
 * @author sbaumhekel
 */
@JsType
public interface LineString extends SimpleGeometry {

    /**
     * Return the coordinates of the linestring.
     * 
     * @return Coordinates.
     */
    JsArray<Coordinate> getCoordinates();

    /**
     * Set the coordinates of the linestring.
     * 
     * @param coordinates
     *            Coordinates.
     * @param geometryLayout
     *            opt_layout Layout.
     */
    void setCoordinates(JsArray<Coordinate> coordinates, @Nullable String geometryLayout);

}
