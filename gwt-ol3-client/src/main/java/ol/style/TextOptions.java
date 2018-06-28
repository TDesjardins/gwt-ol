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
	 * @param rotation Rotation in radians
	 */
	@JsProperty
	public native void setRotation(double rotation);

	/**
	 * Scale.
	 * @param scale Scale. Default is 1.
	 */
	@JsProperty
	public native void setScale(double scale);

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
	
	/**
	 * Text placement. Possible values: 'point', 'line'. The default value is point
	 * @param placement String
	 */
	@JsProperty
	public native void setPlacement(String placement);

	/**
	 * Allow text to exceed the width of the polygon at the label position or the length of the path that it follows. Default is false
	 * @param overflow boolean
	 */
	@JsProperty
	public native void setOverflow(boolean overflow);
}
