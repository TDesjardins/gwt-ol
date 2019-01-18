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
package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.proj.Projection;

/**
 * Source options.
 *
 * @author Tino Desjardins
 *
 * see https://openlayers.org/en/latest/apidoc/ol.source.Source.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SourceOptions implements Options {

    /**
     * Set the Attributions.
     *
     * @param attributions attributions
     */
    @JsOverlay
    public final void setAttributions(String... attributions) {
        setAttributionValues(attributions);
    }

    @JsProperty(name = "attributions")
    private native void setAttributionValues(String[] attributions);

    /**
     * Get the attributions of the source.
     *
     * @return Attributions.
     */
    @JsProperty
    public native String[] getAttributions();

    /**
     * Set the Projection. Default is EPSG:3857.
     *
     * @param projection projection
     */
    @JsProperty
    public native void setProjection(Projection projection);

    @JsProperty
    public native Projection getProjection();

    /**
     * Wrap the world horizontally. Default is true. For vector editing across
     * the -180° and 180° meridians to work properly, this should be set to
     * false. The resulting geometry coordinates will then exceed the world
     * bounds.
     *
     * @param wrapX wrap?  Default is true
     */
    @JsProperty
    public native void setWrapX(boolean wrapX);

}
