package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Attribution;
import ol.Options;

/**
 * Source options.
 * 
 * @author Tino Desjardins
 */
@JsType
public interface SourceOptions extends Options {

    /**
     * Set the Attributions.
     * 
     * @param attributions attributions
     */
    @JsProperty
    void setAttributions(Attribution[] attributions);

    /**
     * Set the Projection. Default is EPSG:3857.
     * 
     * @param projection projection
     */
    @JsProperty
    void setProjection(String projection);

}
