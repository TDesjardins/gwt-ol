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
 * {@link ol.geom.Polygon#circular(Sphere, Coordinate, double, int)}.
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
     * @param coordinates
     *            List of coordinates of a linear ring. If the ring is oriented
     *            clockwise, the area will be positive, otherwise it will be
     *            negative.
     * @return {number} Area.
     */
    @JsMethod(name = "getArea", namespace = PACKAGE_SPHERE)
    public static native double getArea(ol.geom.Geometry geometry);

    @JsMethod(name = "getArea", namespace = PACKAGE_SPHERE)
    public static native double getArea(ol.geom.Geometry geometry, SphereMetricOptions sphereMetricOptions);

    /**
     * Get the great circle distance (in meters) between two geographic coordinates
     *
     * @param coordinate1
     *            Coordinate 1.
     * @param coordinate2
     *            Coordinate 2.
     * @return {number} Haversine distance.
     */
    @JsMethod(name = "getDistance", namespace = PACKAGE_SPHERE)
    public static native double getDistance(ol.Coordinate coordinate1, ol.Coordinate coordinate2);

    @JsMethod(name = "getDistance", namespace = PACKAGE_SPHERE)
    public static native double getDistance(ol.Coordinate coordinate1, ol.Coordinate coordinate2, SphereMetricOptions sphereMetricOptions);

}
