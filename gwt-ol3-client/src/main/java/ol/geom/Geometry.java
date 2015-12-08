package ol.geom;

import com.google.gwt.core.client.js.JsType;

import ol.*;

/**
 * Base for vector geometries.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface Geometry extends Observable {

    /**
     * Make a complete copy of the geometry.
     *
     * @return {@link Geometry} Clone.
     */
    Geometry clone();

    /**
     * Return the closest point of the geometry to the passed point as
     * {@link Coordinate} coordinate.
     *
     * @param point
     *            Point.
     * @return Closest point.
     * @api stable
     */
    Coordinate getClosestPoint(Coordinate point);

    /**
     * Get the extent of the geometry.
     *
     * @return {ol.Extent} extent Extent.
     */
    Extent getExtent();

    /**
     * Get the type of this geometry.
     * 
     * @return Geometry type.
     */
    String getType();

    /**
     * Create a simplified version of this geometry. For linestrings, this uses
     * the the
     * <a href="https://en.wikipedia.org/wiki/Ramer-Douglas-Peucker_algorithm">
     * Douglas Peucker</a> algorithm. For polygons, a quantization-based
     * simplification is used to preserve topology.
     *
     * @function
     * @param tolerance
     *            The tolerance distance for simplification.
     * @return {@link Geometry} A new, simplified version of the original
     *         geometry.
     */
    Geometry simplify(double tolerance);

    /**
     * Transform each coordinate of the geometry from one coordinate reference
     * system to another. The geometry is modified in place. For example, a line
     * will be transformed to a line and a circle to a circle. If you do not
     * want the geometry modified in place, first clone() it and then use this
     * function on the clone.
     *
     * @param source
     *            The current projection. Can be a string identifier or a
     *            {@link ol.proj.Projection} object.
     * @param destination
     *            The desired projection. Can be a string identifier or a
     *            {@link ol.proj.Projection} object.
     * @return {@link Geometry} This geometry. Note that original geometry is
     *         modified in place.
     */
    Geometry transform(String source, String destination);
}
