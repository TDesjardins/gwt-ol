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

/**
 * MultiPolygon geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiPolygon extends SimpleGeometryMultiCoordinates {
    
    /**
     * Append the passed polygon to this multipolygon.
     * 
     * @param polygon
     *            Polygon.
     * @api stable
     */
    public native void appendPolygon(Polygon polygon);

    /**
     * Return the polygon at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.Polygon} Polygon.
     * @api stable
     */
    public native Polygon getPolygon(int index);

    /**
     * Return the polygons of this multipolygon.
     * 
     * @return {Array.<ol.geom.Polygon>} Polygons.
     * @api stable
     */
    public native Polygon[] getPolygons();
    
}
