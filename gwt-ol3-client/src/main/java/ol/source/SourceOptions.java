package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Attribution;
import ol.Options;
import ol.proj.Projection;

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
    void setAttributions(Attribution[] attributions);

    /**
     * Set the Projection. Default is EPSG:3857.
     *
     * @param projection
     *            projection
     * @return this instance
     */
    @JsProperty
    void setProjection(Projection projection);

}
