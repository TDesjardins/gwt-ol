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
package ol.style;

import jsinterop.annotations.JsType;

/**
 * Set regular shape style for vector features.
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.style.RegularShape.html
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class RegularShape extends Image {

    public RegularShape() {}
    
    public RegularShape(RegularShapeOptions regularShapeOptions) {}
    
    /**
     * Get the angle used in generating the shape.
     *
     * @return Shape's rotation in radians.
     */
    public native double getAngle();

    /**
     * Get the fill style for the shape.
     *
     * @return {@link Fill} style.
     */
    public native Fill getFill();

    /**
     * Get the number of points for generating the shape.
     *
     * @return Number of points for stars and regular polygons.
     */
    public native int getPoints();

    /**
     * Get the (primary) radius for the shape.
     *
     * @return Radius.
     */
    public native int getRadius();

    /**
     * Get the secondary radius for the shape.
     *
     * @return Radius2.
     */
    public native int getRadius2();

    /**
     * Get the stroke style for the shape.
     *
     * @return {@link Stroke} style.
     */
    public native Stroke getStroke();

}
