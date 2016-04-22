package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface TextOptions extends Options {

	/**
	 * Font style as CSS 'font' value, see:
	 * https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/font. Default is '10px sans-serif'
	 * @param font String
	 */
	@JsProperty
	void setFont(String font);

	/**
	 * Horizontal text offset in pixels. A positive will shift the text right. Default is 0.
	 * @param offsetX int
	 */
	@JsProperty
	void setOffsetX(int offsetX);

	/**
	 * Vertical text offset in pixels. A positive will shift the text down. Default is 0.
	 * @param offsetY int
	 */
	@JsProperty
	void setOffsetY(int offsetY);

	/**
	 * Rotation in radians (positive rotation clockwise). Default is 0.
	 * @param rotation int
	 */
	@JsProperty
	void setRotation(int rotation);

	/**
	 * Scale.
	 * @param scale int
	 */
	@JsProperty
	void setScale(int scale);

	/**
	 * Fill style. If none is provided, we'll use a dark fill-style (#333).
	 * @param fill ol.style.Fill
	 */
	@JsProperty
	void setFill(ol.style.Fill fill);

	/**
	 * Stroke style.
	 * @param stroke ol.style.Stroke
	 */
	@JsProperty
	void setStroke(ol.style.Stroke stroke);

	/**
	 * Text content.
	 * @param text String
	 */
	@JsProperty
	void setText(String text);

	/**
	 * Text alignment. Possible values: 'left', 'right', 'center', 'end' or 'start'. Default is 'start'.
	 * @param textAlign String
	 */
	@JsProperty
	void setTextAlign(String textAlign);

	/**
	 * Text base line. Possible values: 'bottom', 'top', 'middle', 'alphabetic', 'hanging', 'ideographic'. Default is
	 * 'alphabetic'.
	 * @param textBaseline String
	 */
	@JsProperty
	void setTextBaseline(String textBaseline);

}
