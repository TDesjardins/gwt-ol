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
package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.LogoOptions;
import ol.proj.Projection;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Base class for {@link ol.layer.Layer} sources.
 *
 * A generic `change` event is triggered when the state of the source changes.
 *
 * @author Tino Desjardins
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.source.Source.html
 * 
 */
@JsType(isNative = true)
public class Source extends ol.Object {

    /**
     * Get the attributions of the source.
     * 
     * @return Attributions.
     */
    @JsProperty
    private native String[] getAttributions();

    /**
     * Get the logo of the source.
     *
     * @return {@link LogoOptions}
     */
    public native LogoOptions getLogo();

    /**
     * Get the projection of the source.
     * 
     * @return {ol.proj.Projection} Projection.
     */
    public native Projection getProjection();

    /**
     * @return {Array.<number>|undefined} Resolutions.
     */
    public native double[] getResolutions();

    /**
     * Get the state of the source: one of 'undefined', 'loading', 'ready' or
     * 'error'.
     * 
     * @return {ol.source.State} State.
     */
    public native String getState();

    /**
     * Refreshes the source and finally dispatches a 'change' event.
     */
    public native void refresh();

    /**
     * Set the attributions.
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
     * Set the projection of the source.
     * 
     * @param projection
     *            Projection.
     */
    public native void setProjection(Projection projection);

}
