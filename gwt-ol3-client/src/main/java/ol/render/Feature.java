/*******************************************************************************
 * Copyright 2017, 2017 gwt-ol3
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
package ol.render;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.geom.GeometryType;

/**
* Lightweight, read-only, {@link ol.Feature} and {@link ol.geom.Geometry} like structure, optimized for rendering and styling.
* Geometry access through the API is limited to getting the type and extent of the geometry.
* 
* @author gkresic
*/
@JsType(isNative = true)
public class Feature {

	/**
     * Get a feature property by its key.
     *
     * @param key Key
     * 
     * @return Value for the requested key. 
     */
    public native <T> T get(String key);
    
    /**
     * Get the extent of this feature's geometry.
     * 
     * @return {@link Extent}.
     */
    public native Extent getExtent();
    
    /**
     * For API compatibility with {@link ol.Feature}, this method is useful when determining the geometry type in style function (see {@link #getType}).
     * 
     * @return {@link Feature}.
     */
    public native Feature getGeometry();

    /**
     * Get the feature identifier. This is a stable identifier for the feature and is set when reading data from a remote source.
     * 
     * @return Id.
     */
    public native String getId();

    /**
     * Get the type of this feature's geometry.
     * 
     * @return Geometry type.
     */
    public native GeometryType getType();
    
}
