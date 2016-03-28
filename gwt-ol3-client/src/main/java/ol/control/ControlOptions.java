package ol.control;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import com.google.gwt.dom.client.Element;

import ol.Options;

/**
 * Control options.
 *
 * @author sbaumhekel
 *
 */
@JsType
public interface ControlOptions extends Options {

    /**
     * The element is the control's container element.
     * This only needs to be specified if you're developing a custom control.
     * 
     * @param element control's container element
     * @return this instance
     */
    @JsProperty
    ControlOptions setElement(Element element);
    
    /**
     * Specify a target if you want the control to be rendered outside of the map's viewport.
     * 
     * @param target
     *            target element
     * @return this instance
     */
    @JsProperty
    ControlOptions setTarget(Element target);

}
