package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 * @author Tino Desjardins
 */
@JsType
public interface TextOptions extends Options {

	/**
	 * Font style as CSS 'font' value, see:
	 * https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/font. Default is '10px sans-serif'
	 * @param font String
	 * @return this instance.
	 */
	@JsProperty
	TextOptions font(String font);

	/**
	 * Horizontal text offset in pixels. A positive will shift the text right. Default is 0.
	 * @param offsetX int
	 * @return this instance.
	 */
	@JsProperty
	TextOptions offsetX(int offsetX);

	/**
	 * Vertical text offset in pixels. A positive will shift the text down. Default is 0.
	 * @param offsetY int
	 * @return this instance.
	 */
	@JsProperty
	TextOptions offsetY(int offsetY);

	/**
	 * Rotation in radians (positive rotation clockwise). Default is 0.
	 * @param rotation int
	 * @return this instance.
	 */
	@JsProperty
	TextOptions rotation(int rotation);

	/**
	 * Scale.
	 * @param scale int
	 * @return this instance.
	 */
	@JsProperty
	TextOptions scale(int scale);

	/**
	 * Fill style. If none is provided, we'll use a dark fill-style (#333).
	 * @param fill ol.style.Fill
	 * @return this instance.
	 */
	@JsProperty
	TextOptions fill(ol.style.Fill fill);

	/**
	 * Stroke style.
	 * @param stroke ol.style.Stroke
	 * @return this instance.
	 */
	@JsProperty
	TextOptions stroke(ol.style.Stroke stroke);

	/**
	 * Text content.
	 * @param text String
	 * @return this instance.
	 */
	@JsProperty
	TextOptions text(String text);

	/**
	 * Text alignment. Possible values: 'left', 'right', 'center', 'end' or 'start'. Default is 'start'.
	 * @param textAlign String
	 * @return this instance.
	 */
	@JsProperty
	TextOptions textAlign(String textAlign);

	/**
	 * Text base line. Possible values: 'bottom', 'top', 'middle', 'alphabetic', 'hanging', 'ideographic'. Default is
	 * 'alphabetic'.
	 * @param textBaseline String
	 * @return this instance.
	 */
	@JsProperty
	TextOptions textBaseline(String textBaseline);

}
