package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface StamenOptions extends Options {

    /**
     * 
     * @param layerName
     *            watercolor, toner
     */
    @JsProperty
    void setLayer(String layerName);

}
