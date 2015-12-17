package ol.control;

import com.google.gwt.core.client.js.*;
import com.google.gwt.dom.client.Element;

import ol.Map;
import ol.Object;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.control.Control")
public interface Control extends Object {

    /**
     * Get the control's container element.
     * 
     * @return {@link Element}
     */
    @JsProperty
    Element getElement();

    Map getMap();

    void setMap(Map map);

}
