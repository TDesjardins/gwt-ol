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
 * Rotate control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RotateOptions extends ControlOptions {

    /**
     * Hide the control when rotation is 0. Default is true.
     * @param autoHide
     *            auto hide
     */
    @JsProperty
    public native void setAutoHide(boolean autoHide);

    /**
     * CSS class name. Default is "ol-rotate".
     * @param className
     *            class name
     */
    @JsProperty
    public native void setClassName(String className);

    /**
     * Animation duration in milliseconds. Default is 250.
     * @param duration
     *            animation duration
     */
    @JsProperty
    public native void setDuration(int duration);

    /**
     * Text label to use for the rotate button. Default is (arrow up). Instead
     * of text, also a Node (e.g. a span element) can be used.
     * @param label
     *            label
     */
    @JsProperty
    public native void setLabel(String label);

    /**
     * Text label to use for the button tip. Default is "Reset rotation".
     * @param tipLabel
     *            tip label
     */
    @JsProperty
    public native void setTipLabel(String tipLabel);

}
