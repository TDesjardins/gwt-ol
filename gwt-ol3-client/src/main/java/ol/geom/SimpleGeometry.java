package ol.geom;

import com.google.gwt.core.client.js.JsType;

import ol.Coordinate;

/**
 *
 * Abstract base class; only used for creating subclasses; do not instantiate in
 * apps, as cannot be rendered.
 *
 * @author sbaumhekel
 */
@JsType
public interface SimpleGeometry extends Geometry {
    /**
     * Return the first coordinate of the geometry.
     *
     * @return {ol.Coordinate} First coordinate.
     */
    Coordinate getFirstCoordinate();

    /**
     * Return the last coordinate of the geometry.
     *
     * @return {ol.Coordinate} Last point.
     */
    Coordinate getLastCoordinate();

    /**
     * Return the {@link ol.geom.GeometryLayout layout} of the geometry.
     *
     * @return Layout.
     */
    String getLayout();

}
