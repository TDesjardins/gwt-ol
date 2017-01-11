package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TextOptions implements Options {

	/**
	 * Font style as CSS 'font' value, see:
	 * https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/font. Default is '10px sans-serif'
	 * @param font String
	 */
	@JsProperty
	public native void setFont(String font);

	/**
	 * Horizontal text offset in pixels. A positive will shift the text right. Default is 0.
	 * @param offsetX int
	 */
	@JsProperty
	public native void setOffsetX(int offsetX);

	/**
	 * Vertical text offset in pixels. A positive will shift the text down. Default is 0.
	 * @param offsetY int
	 */
	@JsProperty
	public native void setOffsetY(int offsetY);

	/**
	 * Rotation in radians (positive rotation clockwise). Default is 0.
	 * @param rotation int
	 */
	@JsProperty
	public native void setRotation(int rotation);

	/**
	 * Scale.
	 * @param scale int
	 */
	@JsProperty
	public native void setScale(int scale);

	/**
	 * Fill style. If none is provided, we'll use a dark fill-style (#333).
	 * @param fill ol.style.Fill
	 */
	@JsProperty
	public native void setFill(ol.style.Fill fill);

	/**
	 * Stroke style.
	 * @param stroke ol.style.Stroke
	 */
	@JsProperty
	public native void setStroke(ol.style.Stroke stroke);

	/**
	 * Text content.
	 * @param text String
	 */
	@JsProperty
	public native void setText(String text);

	/**
	 * Text alignment. Possible values: 'left', 'right', 'center', 'end' or 'start'. Default is 'start'.
	 * @param textAlign String
	 */
	@JsProperty
	public native void setTextAlign(String textAlign);

	/**
	 * Text base line. Possible values: 'bottom', 'top', 'middle', 'alphabetic', 'hanging', 'ideographic'. Default is
	 * 'alphabetic'.
	 * @param textBaseline String
	 */
	@JsProperty
	public native void setTextBaseline(String textBaseline);

}
