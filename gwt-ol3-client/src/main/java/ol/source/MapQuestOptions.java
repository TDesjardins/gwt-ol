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
public interface MapQuestOptions extends Options {

    /**
     * 
     * @param layer
     *            osm, sat, hyb
     */
    @JsProperty
    void setLayer(String layer);

}
