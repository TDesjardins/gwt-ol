/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.geom;

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.Extent;
import ol.Observable;
import ol.proj.Projection;

/**
 * Base for vector geometries.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Geometry extends Observable {

    /**
     * Make a complete copy of the geometry.
     *
     * @return {@link Geometry} Clone.
     */
    public native Geometry clone();

    /**
     * Return the closest point of the geometry to the passed point as
     * {@link Coordinate} coordinate.
     *
     * @param point
     *            Point.
     * @return Closest point.
     * @api stable
     */
    public native Coordinate getClosestPoint(Coordinate point);

    /**
     * Get the extent of the geometry.
     *
     * @return {ol.Extent} extent Extent.
     */
    public native Extent getExtent();

    /**
     * Get the type of this geometry.
     *
     * @return Geometry type.
     */
    public native String getType();

    /**
     * Rotate the geometry around a given coordinate. This modifies the geometry
     * coordinates in place.
     * @param angle
     *            Rotation angle in radians.
     * @param anchor
     *            The rotation center.
     */
    public native void rotate(double angle, Coordinate anchor);

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
    public native Geometry simplify(double tolerance);

    /**
     * Transform each coordinate of the geometry from one coordinate reference
     * system to another. The geometry is modified in place. For example, a line
     * will be transformed to a line and a circle to a circle. If you do not
     * want the geometry modified in place, first clone() it and then use this
     * function on the clone.
     *
     * @param source
     *            The current projection. Can be a string identifier.
     * @param destination
     *            The desired projection. Can be a string identifier.
     * @return {@link Geometry} This geometry. Note that original geometry is
     *         modified in place.
     */
    public native Geometry transform(String source, String destination);

    /**
     * Transform each coordinate of the geometry from one coordinate reference
     * system to another. The geometry is modified in place. For example, a line
     * will be transformed to a line and a circle to a circle. If you do not
     * want the geometry modified in place, first clone() it and then use this
     * function on the clone.
     *
     * @param geom {@link Geometry}
     *
     * @param source
     *            The current projection. Can be a {@link ol.proj.Projection} object.
     * @param destination
     *            The desired projection. Can be a {@link ol.proj.Projection} object.
     * @return {@link Geometry} This geometry. Note that original geometry is
     *         modified in place.
     */
    public native Geometry transform(Projection source, Projection destination);

    /**
     * Returns true if this geometry includes the specified coordinate.
     * If the coordinate is on the boundary of the geometry, returns false.
     *
     * @param coordinate
     *                  The coordinate to check if intersects this geometry.
     * @return
     *          true if intersects otherwise false
     */
    public native boolean intersectsCoordinate(Coordinate coordinate);

}
