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
     * @return first coordinate.
     */
    public native Coordinate getFirstCoordinate();

    /**
     * Return the last coordinate of the geometry.
     *
     * @return last point.
     */
    public native Coordinate getLastCoordinate();

    /**
     * Return the layout of the geometry.
     *
     * @return Layout.
     */
    public native String getLayout();

    /**
     * Translate the geometry. This modifies the geometry coordinates in place.
     * If instead you want a new geometry, first {@link clone()} this geometry.
     *
     * @param deltaX Delta X.
     * @param deltaY Delta Y.
     */
    public native void translate(double deltaX, double deltaY);

}
