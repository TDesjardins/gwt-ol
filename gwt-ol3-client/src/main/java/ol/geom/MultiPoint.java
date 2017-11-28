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
 * MultiPoint geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiPoint extends SimpleGeometryCoordinates {

    public MultiPoint(Coordinate[] coordinates) {}

    public MultiPoint(Coordinate[] coordinates, String geometryLayout) {}

    /**
     * Append the passed point to this multipoint.
     * 
     * @param point
     *            Point.
     */
    public native void appendPoint(Point point);

    /**
     * Return the point at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.Point} Point.
     */
    public native Point getPoint(int index);

    /**
     * Return the points of this multipoint.
     * 
     * @return {Array.<ol.geom.Point>} Points.
     */
    public native Point[] getPoints();
    
}
