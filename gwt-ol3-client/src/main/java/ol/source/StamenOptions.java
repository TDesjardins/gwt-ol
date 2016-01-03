package ol.source;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Options;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface StamenOptions extends Options {

    /**
     * 
     * @param layerName
     *            watercolor, toner
     */
    @JsProperty
    void setLayer(String layerName);

}
