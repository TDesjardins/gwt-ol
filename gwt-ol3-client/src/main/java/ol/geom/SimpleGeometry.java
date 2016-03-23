package ol.geom;

import jsinterop.annotations.JsType;

import ol.Coordinate;

/**
 *
 * Abstract base class; only used for creating subclasses; do not instantiate in
 * apps, as cannot be rendered.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public abstract class SimpleGeometry extends Geometry {
    
    /**
     * Return the first coordinate of the geometry.
     *
     * @return {ol.Coordinate} First coordinate.
     */
    public native Coordinate getFirstCoordinate();

    /**
     * Return the last coordinate of the geometry.
     *
     * @return {ol.Coordinate} Last point.
     */
    public native Coordinate getLastCoordinate();

    /**
     * Return the {@link ol.geom.GeometryLayout layout} of the geometry.
     *
     * @return Layout.
     */
    public native String getLayout();

}
