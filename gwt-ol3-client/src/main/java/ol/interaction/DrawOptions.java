package ol.interaction;

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
@JsType(isNative = true)
public interface DrawOptions extends Options {

	/**
	 * The maximum distance in pixels between "down" and "up" for a "up" event to
	 * be considered a "click" event and actually add a point/vertex to the
	 * geometry being drawn. Default is 6 pixels. That value was chosen for the
	 * draw interaction to behave correctly on mouse as well as on touch devices.
	 *
	 * @param clickTolerance clickTolerance
	 */
	@JsProperty
	void setClickTolerance(int clickTolerance);

	/**
	 * 
	 * Function that is called when a geometry's coordinates are updated.
	 * 
	 * @param geometryFunction
	 */
	@JsProperty
	void setGeometryFunction(GeometryFunction<?, ?, ?> geometryFunction);

	/**
	 * Destination collection for the drawn features.
	 *
	 * @param features features
	 */
	@JsProperty
	void setFeatures(Collection<Feature> features);

	/**
	 * The number of points that can be drawn before a polygon ring or line string
	 * is finished. The default is no restriction.
	 *
	 * @param maxPoints maxPoints
	 */
	@JsProperty
	void setMaxPoints(int maxPoints);

	/**
	 * The number of points that must be drawn before a polygon ring or line
	 * string can be finished. Default is 3 for polygon rings and 2 for line
	 * strings.
	 *
	 * @param minPoints minPoints
	 */
	@JsProperty
	void setMinPoints(int minPoints);

	/**
	 * Pixel distance for snapping to the drawing finish. Default is 12.
	 *
	 * @param snapTolerance snapTolerance
	 */
	@JsProperty
	void setSnapTolerance(int snapTolerance);

	/**
	 * Destination source for the drawn features.
	 *
	 * @param source source
	 */
	@JsProperty
	void setSource(Vector source);

	/**
	 * Style for sketch features.
	 *
	 * @param style style
	 */
	@JsProperty
	void setStyle(Style style);

	/**
	 * Drawing type ('Point', 'LineString', 'Polygon', 'MultiPoint',
	 * 'MultiLineString', 'MultiPolygon' or 'Circle'). Required.
	 *
	 * @param type type
	 */
	@JsProperty
	void setType(String type);

	/**
	 * Wrap the world horizontally on the sketch overlay. Default is false.
	 *
	 * @param wrapX wrapX
	 */
	@JsProperty
	void setWrapX(boolean wrapX);

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. By default
	 * ol.events.condition.noModifierKeys, i.e. a click, adds a vertex or
	 * deactivates freehand drawing.
	 * 
	 * @param condition condition
	 */
	@JsProperty
	void setCondition(GenericFunction<?, ?> condition);

}
