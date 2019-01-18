/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol3
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
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.style.Style;
import ol.style.StyleFunction;

/**
 * Options for {@link ol.interaction.Extent}.
 *
 * @author gkresic
 *
 * see https://openlayers.org/en/latest/apidoc/module-ol_interaction_Extent.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ExtentOptions implements Options {

    /**
     * @param extent Initial extent. Defaults to no initial extent.
     */
    @JsProperty
    public native void setExtent(ol.Extent extent);

    @JsProperty
    public native ol.Extent getExtent();

    /**
     * @param style Style for the drawn extent box. Defaults to module:ol/style/Style~createEditing()['Polygon']
     */
    @JsProperty
    public native void setBoxStyle(Style style);

    /**
     * @param styleFunction Function that provides style for the drawn extent box. Defaults to module:ol/style/Style~createEditing()['Polygon']
     */
    @JsProperty
    public native void setBoxStyle(StyleFunction styleFunction);

    /**
     * @param pixelTolerance Pixel tolerance for considering the pointer close enough to a segment or vertex for editing. Default is <code>10</code>.
     */
    @JsProperty
    public native void setPixelTolerance(int pixelTolerance);

    @JsProperty
    public native int getPixelTolerance();

    /**
     * @param style Style for the cursor used to draw the extent. Defaults to module:ol/style/Style~createEditing()['Point']
     */
    @JsProperty
    public native void setPointerStyle(Style style);

    /**
     * @param styleFunction Function that provides style for the cursor used to draw the extent. Defaults to module:ol/style/Style~createEditing()['Point']
     */
    @JsProperty
    public native void setPointerStyle(StyleFunction styleFunction);

    /**
     * @param wrapX Wrap the drawn extent across multiple maps in the X direction? Only affects visuals, not functionality. Default is <code>false</code>.
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

    @JsProperty
    public native boolean getWrapX();

}
