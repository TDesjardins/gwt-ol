package ol.interaction;

import jsinterop.annotations.JsType;

/**
 * The draw event type.
 *
 * @author Peter Zanetti
 * 
 * @see https://github.com/openlayers/ol3/blob/master/src/ol/interaction/draw.js
 *
 */
@JsType
public enum DrawEventType {
  /**
   * Triggered upon feature draw start
   * 
   * @see ol.interaction.Draw.Event#drawstart
   */
		drawstart,
	  /**
	   * Triggered upon feature draw end
	   * 
	   * @see ol.interaction.Draw.Event#drawend
	   */
		drawend
}
