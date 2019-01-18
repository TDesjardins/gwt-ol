/*******************************************************************************
 * Copyright 2017, 2018 gwt-ol3
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
import ol.Feature;
import ol.geom.Circle;
import ol.geom.Geometry;
import ol.style.Style;

/**
* Context for drawing geometries. A vector context is available on render events and does not need to be constructed directly.
*
* Since concrete implementation classes (<code>ol.render.canvas.Immediate</code> and <code>ol.render.webgl.Immediate</code>)
* are not (directly) available, all of their methods are exposed here.
*
* @author gkresic
*
* see https://openlayers.org/en/latest/apidoc/ol.render.VectorContext.html
*/
@JsType(isNative = true)
public interface VectorContext {

	/**
	 * Render a circle geometry into the canvas. Rendering is immediate and uses the current fill and stroke styles.
	 *
	 * @param circle Circle geometry.
	 */
	public void drawCircle(Circle circle);

	/**
	 * Render a feature into the canvas. Note that any <code>zIndex</code> on the provided style will be ignored - features are rendered
	 * immediately in the order that this method is called. If you need <code>zIndex</code> support, you should be using an {@link ol.layer.Vector} instead.
	 *
	 * @param feature Feature.
	 * @param style Style.
	 */
	public void drawFeature(Feature feature, Style style);

	/**
	 * Render a geometry into the canvas. Call {@link #setStyle} first to set the rendering style.
	 *
	 * @param geometry The geometry to render.
	 */
	public void drawGeometry(Geometry geometry);

	/**
	 * Render a geometry into the canvas. Call {@link #setStyle} first to set the rendering style.
	 *
	 * @param geometry The geometry to render.
	 */
	public void drawGeometry(ol.render.Feature geometry);

	/**
	 * Set the rendering style. Note that since this is an immediate rendering API, any <code>zIndex</code> on the provided style will be ignored.
	 *
	 * @param style The rendering style.
	 */
	public void setStyle(Style style);

}
