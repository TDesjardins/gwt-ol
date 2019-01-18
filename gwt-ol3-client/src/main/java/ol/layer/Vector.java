/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.layer;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.style.Style;
import ol.style.StyleFunction;

/**
 * Vector data that is rendered client-side. Note that any property set in the
 * options is set as a {@link ol.Object} property on the layer object; for
 * example, setting `title: 'My Title'` in the options means that `title` is
 * observable, and has get/set accessors.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Vector extends Layer {


    public Vector() {}

    public Vector(VectorLayerOptions vectorLayerOptions) {}

    /**
     * Get the style for features. This returns whatever was passed to the
     * `style` option at construction or to the `setStyle` method.
     *
     * @return style for features.
     */
    @JsMethod(name = "getStyle")
    private native Object getNativeStyle();

    /**
     * @return The vector style.
     */
    @JsOverlay
    public final Style getStyle() {

        java.lang.Object nativeStyle = this.getNativeStyle();

        if (nativeStyle instanceof Style[]) {
            Style[] styles = (Style[])nativeStyle;

            if (styles.length > 0) {
                return styles[0];
            }

        } else if (nativeStyle instanceof Style) {
            return (Style)nativeStyle;
        }

        return null;
    }

    /**
     * @return The vectors styles.
     */
    @JsOverlay
    public final Style[] getStyles() {

        java.lang.Object nativeStyle = this.getNativeStyle();

        if (nativeStyle instanceof Style[]) {
            return (Style[])this.getNativeStyle();
        } else if (nativeStyle instanceof Style) {
            Style[] styles = new Style[1];
            styles[0] = (Style)nativeStyle;
            return styles;
        }

        return null;

    }

    /**
     * @return The vector's style function.
     */
    public native StyleFunction getStyleFunction();

    @JsMethod(name = "setStyle")
    private native void setNativeStyle(java.lang.Object style);

    /**
     * Set the style for features. This can be a single style object, an array
     * of styles, or a function that takes a feature and resolution and returns
     * an array of styles. If it is `undefined` the default style is used. If it
     * is `null` the layer has no style (a `null` style), so only features that
     * have their own styles will be rendered in the layer. See {@link ol.style}
     * for information on the default style.
     *
     * @param style
     *            Layer style.
     */
    public native void setStyle(ol.style.Style style);

    @JsOverlay
    public final void setStyles(Style[] styles) {
        setNativeStyle(styles);
    }

    /**
     * @deprecated Use {@link ol.layer.Vector#setStyleFunction(StyleFunction)} instead.
     */
    @Deprecated
    public native void setStyle(StyleFunction style);

    @JsOverlay
    public final void setStyleFunction(StyleFunction styleFunction) {
        setNativeStyle(styleFunction);
    }

}
