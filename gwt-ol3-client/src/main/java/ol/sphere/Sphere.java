/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.sphere;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.Coordinate;

/**
 * Class to create objects that can be used with
 * {@link ol.geom.Polygon#circular(Coordinate, double, int)}.
 *
 * For example to create a sphere whose radius is equal to the semi-major axis
 * of the WGS84 ellipsoid:
 *
 * ```js var wgs84Sphere= new ol.Sphere(6378137); ```
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public class Sphere {

    @JsOverlay
    private static final String PACKAGE_SPHERE = "ol.sphere";

    /**
     * Get the spherical area of a geometry. This is the area (in meters) assuming that polygon edges are segments of great circles on a sphere.
     *
     * @param geometry geometry
     * @return area.
     */
    @JsMethod(name = "getArea", namespace = PACKAGE_SPHERE)
    public static native double getArea(ol.geom.Geometry geometry);

    /**
     * Get the spherical area of a geometry. This is the area (in meters) assuming that polygon edges are segments of great circles on a sphere.
     *
     * @param geometry geometry
     * @param sphereMetricOptions Options for the area calculation. By default, geometries are assumed to be in 'EPSG:3857'. You can change this
     * by providing a projection option.
     * @return area
     */
    @JsMethod(name = "getArea", namespace = PACKAGE_SPHERE)
    public static native double getArea(ol.geom.Geometry geometry, SphereMetricOptions sphereMetricOptions);

    /**
     * Get the great circle distance (in meters) between two geographic coordinates.
     *
     * @param coordinate1
     *            Coordinate 1.
     * @param coordinate2
     *            Coordinate 2.
     * @return {number} great circle distance (in meters).
     */
    @JsMethod(name = "getDistance", namespace = PACKAGE_SPHERE)
    public static native double getDistance(ol.Coordinate coordinate1, ol.Coordinate coordinate2);

    /**
     * Get the great circle distance (in meters) between two geographic coordinates.
     *
     * @param coordinate1 Coordinate 1
     * @param coordinate2 Coordinate 2
     * @param radius The sphere radius to use. Defaults to the Earth's mean radius using the WGS84 ellipsoid.
     * @return great circle distance (in meters)
     */
    @JsMethod(name = "getDistance", namespace = PACKAGE_SPHERE)
    public static native double getDistance(ol.Coordinate coordinate1, ol.Coordinate coordinate2, double radius);

    /**
     * Get the spherical length of a geometry. This length is the sum of the great circle distances between coordinates. For polygons, the length
     * is the sum of all rings. For points, the length is zero. For multi-part geometries, the length is the sum of the length of each part.
     *
     * @param geometry geometry
     * @return spherical length
     */
    @JsMethod(name = "getLength", namespace = PACKAGE_SPHERE)
    public static native double getLength(ol.geom.Geometry geometry);

    /**
     * Get the spherical length of a geometry. This length is the sum of the great circle distances between coordinates. For polygons, the length
     * is the sum of all rings. For points, the length is zero. For multi-part geometries, the length is the sum of the length of each part.
     *
     * @param geometry geometry
     * @param sphereMetricOptions Options for the length calculation. By default, geometries are assumed to be in 'EPSG:3857'. You can change
     * this by providing a projection option.
     * @return spherical length
     */
    @JsMethod(name = "getLength", namespace = PACKAGE_SPHERE)
    public static native double getLength(ol.geom.Geometry geometry, SphereMetricOptions sphereMetricOptions);

}
