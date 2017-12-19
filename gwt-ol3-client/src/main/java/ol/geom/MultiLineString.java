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
 * MultiLineString geometry.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class MultiLineString extends SimpleGeometryMultiCoordinates {

    public MultiLineString(Coordinate[] coordinates) {}

    public MultiLineString(Coordinate[] coordinates, String geometryLayout) {}

    /**
     * Append the passed linestring to the multilinestring.
     * 
     * @param lineString LineString.
     */
    public native void appendLineString(LineString lineString);

    /**
     * Return the linestring at the specified index.
     * 
     * @param index
     *            Index.
     * @return {ol.geom.LineString} LineString.
     */
    public native LineString getLineString(int index);

    /**
     * Return the linestrings of this multilinestring.
     * 
     * @return {Array.<ol.geom.LineString>} LineStrings.
     */
    public native LineString[] getLineStrings();
    
}
