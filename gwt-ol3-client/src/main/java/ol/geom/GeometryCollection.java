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

import javax.annotation.Nullable;

import jsinterop.annotations.JsType;

/**
 * GeometryCollection.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class GeometryCollection extends Geometry {
    
    public GeometryCollection() {}
    
    public GeometryCollection(@Nullable Geometry[] geometries) {}
    
    /**
     * Return the geometries that make up this geometry collection.
     * 
     * @return {Array.<ol.geom.Geometry>} Geometries.
     */
    public native Geometry[] getGeometries();

    /**
     * Test if the geometry and the passed extent intersect.
     * 
     * @param extent
     *            Extent.
     * @return {boolean} `true` if the geometry and the extent intersect.
     */
    public native boolean intersectsExtent(ol.Extent extent);

    /**
     * Set the geometries that make up this geometry collection.
     * 
     * @param geometries
     *            Geometries.
     */
    public native void setGeometries(ol.geom.Geometry[] geometries);

    /**
     * Translate the geometry. This modifies the geometry coordinates in place.
     * If instead you want a new geometry, first `clone()` this geometry.
     * 
     * @param deltaX
     *            Delta X.
     * @param deltaY
     *            Delta Y.
     */
    public native void translate(double deltaX, double deltaY);

}
