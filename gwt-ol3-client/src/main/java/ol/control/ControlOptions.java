package ol.control;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Control options.
 *
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface ControlOptions extends Options {

    /**
     * The element is the control's container element.
     * This only needs to be specified if you're developing a custom control.
     * 
     * @param element control's container element
     */
    @JsProperty
    void setElement(Element element);
    
    /**
     * Specify a target if you want the control to be rendered outside of the map's viewport.
     * 
     * @param target
     *            target element
     */
    @JsProperty
    void setTarget(Element target);

}
