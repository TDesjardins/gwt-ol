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
public interface MapQuestOptions extends Options {

    /**
     * 
     * @param layer
     *            osm, sat, hyb
     */
    @JsProperty
    void setLayer(String layer);

}
