package ol.geom;

import com.google.gwt.core.client.js.JsType;

import ol.Coordinate;

/**
 * Point geometry.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface Point extends SimpleGeometry {
     /**
     * Return the coordinate of the point.
     *
     * @return coordinate of the point.
     */
    abstract Coordinate getCoordinates();

}
