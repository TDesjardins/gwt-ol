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
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.GeometryFunction;
import ol.Options;
import ol.source.Vector;
import ol.style.Style;

/**
 * Options for {@link Draw}.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DrawOptions implements Options {

	/**
	 * The maximum distance in pixels between "down" and "up" for a "up" event to
	 * be considered a "click" event and actually add a point/vertex to the
	 * geometry being drawn. Default is 6 pixels. That value was chosen for the
	 * draw interaction to behave correctly on mouse as well as on touch devices.
	 *
	 * @param clickTolerance clickTolerance
	 */
	@JsProperty
	public native void setClickTolerance(int clickTolerance);

	/**
	 * 
	 * Function that is called when a geometry's coordinates are updated.
	 * 
	 * @param geometryFunction
	 */
	@JsProperty
	public native void setGeometryFunction(GeometryFunction<?, ?, ?> geometryFunction);

	/**
	 * Destination collection for the drawn features.
	 *
	 * @param features features
	 */
	@JsProperty
	public native void setFeatures(Collection<Feature> features);

	/**
	 * The number of points that can be drawn before a polygon ring or line string
	 * is finished. The default is no restriction.
	 *
	 * @param maxPoints maxPoints
	 */
	@JsProperty
	public native void setMaxPoints(int maxPoints);

	/**
	 * The number of points that must be drawn before a polygon ring or line
	 * string can be finished. Default is 3 for polygon rings and 2 for line
	 * strings.
	 *
	 * @param minPoints minPoints
	 */
	@JsProperty
	public native void setMinPoints(int minPoints);

	/**
	 * Pixel distance for snapping to the drawing finish. Default is 12.
	 *
	 * @param snapTolerance snapTolerance
	 */
	@JsProperty
	public native void setSnapTolerance(int snapTolerance);

	/**
	 * Destination source for the drawn features.
	 *
	 * @param source source
	 */
	@JsProperty
	public native void setSource(Vector source);

	/**
	 * Style for sketch features.
	 *
	 * @param style style
	 */
	@JsProperty
	public native void setStyle(Style style);

	/**
	 * Drawing type ('Point', 'LineString', 'Polygon', 'MultiPoint',
	 * 'MultiLineString', 'MultiPolygon' or 'Circle'). Required.
	 *
	 * @param type type
	 */
	@JsProperty
	public native void setType(String type);

	/**
	 * Wrap the world horizontally on the sketch overlay. Default is false.
	 *
	 * @param wrapX wrapX
	 */
	@JsProperty
	public native void setWrapX(boolean wrapX);

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. By default
	 * ol.events.condition.noModifierKeys, i.e. a click, adds a vertex or
	 * deactivates freehand drawing.
	 * 
	 * @param condition condition
	 */
	@JsProperty
	public native void setCondition(GenericFunction<?, ?> condition);

}
