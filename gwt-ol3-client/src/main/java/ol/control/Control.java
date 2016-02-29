package ol.control;

import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Map;
import ol.Object;

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

    /**
     * Get the control's container element.
     *
     * @return {@link Element}
     */
    @JsProperty
    public native Element getElement();

    /**
     * Get the map associated with this control.
     * @return {ol.Map} Map.
     */
    public native Map getMap();

    /**
     * Remove the control from its current map and attach it to the new map.
     * Subclasses may set up event handlers to get notified about changes to the
     * map here.
     * @param map
     *            {ol.Map} .
     */
    public native void setMap(Map map);

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
