/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol
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
package ol.format;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.annotations.JsProperty;
import ol.Options;
import ol.style.Style;

/**
 * Options for KML format.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class KmlOptions implements Options {

    /**
     * @param extractStyles Extract styles from the KML (default: true).
     */
    @JsProperty
    public native void setExtractStyles(boolean extractStyles);

    /**
     * @param showPointNames Show names as labels for placemarks which contain points (default: true).
     */
    @JsProperty
    public native void setShowPointNames(boolean showPointNames);

    /**
     * @param defaultStyle Default style. The default default style is the same as Google Earth.
     */
    @JsProperty
    public native void setDefaultStyle(Style[] defaultStyle);

    /**
     * @param writeStyles Write styles into KML (default: true).
     */
    @JsProperty
    public native void setWriteStyles(boolean writeStyles);

}
