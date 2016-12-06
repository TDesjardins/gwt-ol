package ol.interaction;

import jsinterop.annotations.JsType;

/**
 *   Draw mode.  This collapses multi-part geometry types with their single-part
 *
 * @author Peter Zanetti
 * 
 * https://github.com/openlayers/ol3/blob/master/src/ol/interaction/draw.js
 *
 */
@JsType
public enum DrawMode {
	Point,
	LineString,
	Polygon,
	Circle	
}
