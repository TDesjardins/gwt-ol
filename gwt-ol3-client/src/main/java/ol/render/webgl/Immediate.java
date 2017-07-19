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
package ol.render.webgl;

import jsinterop.annotations.JsType;

import ol.Feature;
import ol.geom.Geometry;
import ol.render.VectorContext;
import ol.style.Style;

/**
* 
* @author gkresic
* 
* @see https://openlayers.org/en/latest/apidoc/ol.render.webgl.Immediate.html
*/
@JsType(isNative = true)
public class Immediate extends VectorContext {

	/**
	 * 
	 * @param feature Feature.
	 * @param style Style.
	 */
	public native void drawFeature(Feature feature, Style style);

	/**
	 * Render a geometry into the canvas. Call {@link #setStyle} first to set the rendering style.
	 * 
	 * @param geometry The geometry to render.
	 */
	public native void drawGeometry(Geometry geometry);
	
	/**
	 * Render a geometry into the canvas. Call {@link #setStyle} first to set the rendering style.
	 * 
	 * @param geometry The geometry to render.
	 */
	public native void drawGeometry(ol.render.Feature geometry);
	
	/**
	 * Set the rendering style. Note that since this is an immediate rendering API, any <code>zIndex</code> on the provided style will be ignored.
	 * 
	 * @param style The rendering style.
	 */
	public native void setStyle(Style style);
	
}
