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

/**
 * Polygon geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class Polygon extends SimpleGeometryMultiCoordinates {

    public Polygon(Coordinate[][] coordinates) {}

    public Polygon(Coordinate[][] coordinates, String geometryLayout) {}

    /**
     * Create an approximation of a circle on the surface of a sphere.
     * @param sphere
     *            The sphere.
     * @param center
     *            Center (`[lon, lat]` in degrees).
     * @param radius
     *            The great-circle distance from the center to the polygon
     *            vertices.
     * @return {ol.geom.Polygon} The "circular" polygon.
     */
    public static native Polygon circular(ol.sphere.Sphere sphere, ol.Coordinate center, double radius);

    /**
     * Create an approximation of a circle on the surface of a sphere.
     * @param sphere
     *            The sphere.
     * @param center
     *            Center (`[lon, lat]` in degrees).
     * @param radius
     *            The great-circle distance from the center to the polygon
     *            vertices.
     * @param opt_n
     *            Optional number of vertices for the resulting polygon. Default
     *            is `32`.
     * @return {ol.geom.Polygon} The "circular" polygon.
     */
    public static native Polygon circular(ol.sphere.Sphere sphere, ol.Coordinate center, double radius, int opt_n);

    /**
     * Create a regular polygon from a circle.
     * @param circle
     *            Circle geometry.
     * @return {ol.geom.Polygon} Polygon geometry.
     */
    public static native Polygon fromCircle(Circle circle);

    /**
     * Create a regular polygon from a circle.
     * @param circle
     *            Circle geometry.
     * @param opt_sides
     *            Number of sides of the polygon. Default is 32.
     * @param opt_angle
     *            Start angle for the first vertex of the polygon in radians.
     *            Default is 0.
     * @return {ol.geom.Polygon} Polygon geometry.
     */
    public static native Polygon fromCircle(Circle circle, int opt_sides, double opt_angle);

    /**
     * Create a polygon from an extent. The layout used is `XY`.
     * @param extent
     *            The extent.
     * @return {ol.geom.Polygon} The polygon.
     */
    public static native Polygon fromExtent(ol.Extent extent);

    /**
     * Append the passed linear ring to this polygon.
     *
     * @param linearRing
     *            Linear ring.
     */
    public native void appendLinearRing(LinearRing linearRing);

    /**
     * Return the area of the polygon on projected plane.
     *
     * @return {number} Area (on projected plane).
     */
    public native double getArea();

    /**
     * Return an interior point of the polygon.
     *
     * @return {ol.geom.Point} Point.
     */
    public native Point getInteriorPoint();

    /**
     * Return the Nth linear ring of the polygon geometry. Return `null` if the
     * given index is out of range. The exterior linear ring is available at
     * index `0` and the interior rings at index `1` and beyond.
     *
     * @param index
     *            Index.
     * @return {ol.geom.LinearRing} Linear ring.
     */
    public native LinearRing getLinearRing(int index);

    /**
     * Return the number of rings of the polygon, this includes the exterior
     * ring and any interior rings.
     *
     * @return {number} Number of rings.
     */
    public native int getLinearRingCount();

    /**
     * Return the linear rings of the polygon.
     *
     * @return {Array.<ol.geom.LinearRing>} Linear rings.
     */
    public native LinearRing[] getLinearRings();

}
