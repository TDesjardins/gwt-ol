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
package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * @author mribeiro
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RegularShapeOptions implements Options {


    /**
     * Fill style.
     *
     * @param fill {@link Fill}
     */
    @JsProperty
    public native void setFill(Fill fill);

    /**
     * Number of points for stars and regular polygons. In case of a polygon, the number of points is the number of sides. Required.
     *
     * @param number number of points
     */
    @JsProperty
    public native void setPoints(int number);

    /**
     * Radius of a regular polygon.
     *
     * @param radius radius
     */
    @JsProperty
    public native void setRadius(int radius);

    /**
     * Shape's angle in radians. A value of 0 will have one of the shape's point facing up. Default value is 0.
     *
     * @param angle in rad
     */
    @JsProperty
    public native void setAngle(double angle);

    /**
     * Stroke style.
     *
     * @param stroke {@link Stroke}
     */
    @JsProperty
    public native void setStroke(Stroke stroke);

    /**
     * Rotation in radians (positive rotation clockwise). Default is 0
     *
     * @param rotation in rad
     */
    @JsProperty
    public native void setRotation(double rotation);

    /**
     * Inner radius of a star.
     *
     * @param radius1 radius
     */
    @JsProperty
    public native void setRadius1(int radius1);

    /**
     * Outer radius of a star.
     *
     * @param radius2 radius
     */
    @JsProperty
    public native void setRadius2(int radius2);

    /**
     * Whether to rotate the shape with the view. Default is false.
     * @param value
     */
    @JsProperty
    public native void setRotateWithView(boolean value);
}
