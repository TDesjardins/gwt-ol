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
 * Options for the {@link Style}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class StyleOptions implements Options {

    /**
     * {@link Fill} style.
     *
     * @param fill {@link Fill}
     */
    @JsProperty
    public native void setFill(Fill fill);

    /**
     * {@link Image} style.
     *
     * @param image {@link Image}
     */
    @JsProperty
    public native void setImage(Image image);

    /**
     * {@link Stroke} style.
     *
     * @param stroke {@link Stroke}
     */
    @JsProperty
    public native void setStroke(Stroke stroke);

    /**
     * Z index.
     *
     * @param zIndex Z-index
     */
    @JsProperty
    public native void setZIndex(int zIndex);

    /**
     * Text style.
     *
     * @param text {@Text text}
     */
    @JsProperty
    public native void setText(Text text);

}
