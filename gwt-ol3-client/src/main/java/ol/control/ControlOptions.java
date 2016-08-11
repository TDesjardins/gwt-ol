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
     * @param element
     *            control's container element
     */
    @JsProperty
    void setTarget(Element element);

}
