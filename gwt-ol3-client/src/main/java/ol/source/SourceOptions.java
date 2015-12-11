package ol.source;

import com.google.gwt.core.client.js.*;

import ol.*;

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
     * @param attributions
     *            attributions
     * @return this instance
     */
    @JsProperty
    SourceOptions setAttributions(Attribution[] attributions);

    /**
     * Set the Projection. Default is EPSG:3857.
     * 
     * @param projection
     *            projection
     * @return this instance
     */
    @JsProperty
    SourceOptions setProjection(String projection);

}
