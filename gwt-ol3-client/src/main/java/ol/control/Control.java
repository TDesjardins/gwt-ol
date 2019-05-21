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
package ol.control;

import elemental2.dom.Element;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Object;
import ol.PluggableMap;

/**
 * A control is a visible widget with a DOM element in a fixed position on the
 * screen. They can involve user input (buttons), or be informational only; the
 * position is determined using CSS. By default these are placed in the
 * container with CSS class name `ol-overlaycontainer-stopevent`, but can use
 * any outside DOM element.
 *
 * This is the base class for controls. You can use it for simple custom
 * controls by creating the element with listeners, creating an instance: ```js
 * var myControl = new ol.control.Control({element: myElement}); ``` and then
 * adding this to the map.
 *
 * The main advantage of having this as a control rather than a simple separate
 * DOM element is that preventing propagation is handled for you. Controls will
 * also be `ol.Object`s in a `ol.Collection`, so you can use their methods.
 *
 * You can also extend this base for your own control class. See
 * examples/custom-controls for an example of how to do this.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Control extends Object {

    @JsOverlay
    private static final String PACKAGE_CONTROL = "ol.control";

    public Control() {}

    public Control(ControlOptions controlOptions) {}

    @JsMethod(name = "defaults", namespace = PACKAGE_CONTROL)
    public static native Collection<Control> defaults();

    @JsMethod(name = "defaults", namespace = PACKAGE_CONTROL)
    public static native Collection<Control> defaults(DefaultControlsOptions defaultOption);

    /**
     * Get the control's container element.
     *
     * @return control's container element
     */
    @JsProperty
    public native Element getElement();

    /**
     * Get the map associated with this control.
     * @return map of this control.
     */
    public native PluggableMap getMap();

    /**
     * Remove the control from its current map and attach it to the new map.
     * Subclasses may set up event handlers to get notified about changes to the
     * map here.
     * @param map
     *            {ol.PluggableMap} .
     */
    public native void setMap(PluggableMap map);

    /**
     * This function is used to set a target element for the control. It has no
     * effect if it is called after the control has been added to the map (i.e.
     * after `setMap` is called on the control). If no `target` is set in the
     * options passed to the control constructor and if `setTarget` is not
     * called then the control is added to the map's overlay container.
     * @param target
     *            Target.
     */
    public native void setTarget(Element target);

}
