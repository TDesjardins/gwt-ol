/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
 * Circle geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class Circle extends SimpleGeometry {
    
    /**
     * Return the center of the circle as {@link ol.Coordinate coordinate}.
     * 
     * @return {ol.Coordinate} Center.
     */
    public native Coordinate getCenter();

    /**
     * Return the radius of the circle.
     * 
     * @return {number} Radius.
     */
    public native double getRadius();

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
