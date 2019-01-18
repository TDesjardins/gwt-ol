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
import ol.Extent;

/**
 * Represents a BBOX operator to test whether a geometry-valued
 * property intersects a fixed bounding box.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Bbox extends Filter {

	/**
	 *
	 * @param geometryName Geometry name to use.
	 * @param extent Extent.
	 * @param srsName SRS name. No srsName attribute will be set on geometries when this is not provided.
	 */
	public Bbox(String geometryName, Extent extent, String srsName){
		super("BBOX");
	}

	@JsProperty
	public native void setGeometryName(String geometryName);

	@JsProperty
    public native void setExtent(Extent extent);

	@JsProperty
    public native void setSrsName(String srsName);

}
