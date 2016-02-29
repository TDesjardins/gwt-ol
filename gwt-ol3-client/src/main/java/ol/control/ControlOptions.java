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
     * @param element
     *            control's container element
     * @return this instance
     */
    @JsProperty
    ControlOptions setTarget(Element element);

}
