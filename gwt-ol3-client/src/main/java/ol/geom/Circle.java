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

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

import ol.Coordinate;
import ol.Extent;

/**
 * Circle geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class Circle extends SimpleGeometry {

   /**
    *
    * @param center Center
    * @param radius Radius
    */
   public Circle(Coordinate center, double radius) {}

   /**
    *
    * @param center Center
    * @param radius Radius
    * @param geometryLayout Layout
    */
   public Circle(Coordinate center, double radius, @Nullable String geometryLayout) {}

    /**
     * Return the center of the circle as {@link ol.Coordinate coordinate}.
     *
     * @return center.
     */
    public native Coordinate getCenter();

    /**
     * Return the radius of the circle.
     *
     * @return radius.
     */
    public native double getRadius();

    /**
     * Test if the geometry and the passed extent intersect.
     *
     * @param extent Extent.
     * @return if the geometry and the extent intersect.
     */
    public native boolean intersectsExtent(Extent extent);

    /**
     * Set the center of the circle as {@link ol.Coordinate coordinate}.
     *
     * @param center
     *            Center.
     */
    public native void setCenter(Coordinate center);

    /**
     * Set the center (as {@link ol.Coordinate coordinate}) and the radius (as
     * number) of the circle.
     *
     * @param center
     *            Center.
     * @param radius
     *            Radius.
     */
    public native void setCenterAndRadius(Coordinate center, double radius);

    /**
     * Set the radius of the circle. The radius is in the units of the
     * projection.
     *
     * @param radius
     *            Radius.
     */
    public native void setRadius(double radius);

}
