package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * A control displaying rough x-axis distances, calculated for the center of the
 * viewport. No scale line will be shown when the x-axis distance cannot be
 * calculated in the view projection (e.g. at or beyond the poles in EPSG:4326).
 * By default the scale line will show in the bottom left portion of the map,
 * but this can be changed by using the css selector `.ol-scale-line`.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.control.ScaleLine")
public interface ScaleLine extends Control {

}
