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
package ol.format.filter;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.geom.Geometry;

/**
 * Represents a spatial operator to test whether a geometry-valued 
 * property relates to a given geometry.
 * 
 * @author hmgn
 *
 */
@JsType(isNative = true)
public abstract class Spatial extends Filter {

	/**
	 * Constructor
	 * 
	 * @param tagName The XML tag name for this filter.
	 * @param geometryName Geometry name to use.
	 * @param geometry Geometry.
	 * @param srsName SRS name. No srsName attribute will be set on geometries when this is not provided.
	 */
	public Spatial(String tagName, String geometryName, Geometry geometry, String srsName){
		super(tagName);
	}
	
	@JsProperty
	public native void setGeometry(Geometry geometry);

}
