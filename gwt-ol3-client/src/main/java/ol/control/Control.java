package ol.control;

import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Map;
import ol.Object;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
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
