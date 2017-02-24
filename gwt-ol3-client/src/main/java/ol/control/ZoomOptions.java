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
package ol.control;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Zoom control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ZoomOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-zoom".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * The zoom delta applied on each click. Default is 1.
     * @param delta
     *            delta
     */
    @JsProperty
    public native void setDelta(int delta);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Text label to use for the zoom-in button. Default is "+". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomInLabel
     *            label
     */
    @JsProperty
    public native void setZoomInLabel(String zoomInLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom in".
     * @param zoomInTipLabel
     *            label
     */
    @JsProperty
    public native void setZoomInTipLabel(String zoomInTipLabel);

    /**
     * Text label to use for the zoom-out button. Default is "-". Instead of
     * text, also a Node (e.g. a span element) can be used.
     * @param zoomOutLabel
     *            label
     */
    @JsProperty
    public native void setZoomOutLabel(String zoomOutLabel);

    /**
     * Text label to use for the button tip. Default is "Zoom out".
     * @param zoomOutTipLabel
     *            label
     */
    @JsProperty
    public native void setZoomOutTipLabel(String zoomOutTipLabel);

}
