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
 * FullScreen options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FullScreenOptions extends ControlOptions {

    /**
     * CSS class name. Default is "ol-full-screen".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Full keyboard access.
     * @param keys
     *            keys
     */
    @JsProperty
    public native void setKeys(boolean keys);

    /**
     * Text label to use for the button. Default is \u2922 (NORTH EAST AND SOUTH
     * WEST ARROW). Instead of text, also a Node (e.g. a span element) can be
     * used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Text label to use for the button when full-screen is active. Default is
     * \u00d7 (a cross). Instead of text, also a Node (e.g. a span element) can
     * be used.
     * @param labelActive
     *            labelActive
     */
    @JsProperty
    public native void setLabelActive(String labelActive);

    /**
     * Text label to use for the button tip. Default is "Toggle full-screen".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

}
