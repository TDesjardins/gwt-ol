package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Attribution;
import ol.Options;
import ol.proj.Projection;

/**
 * Source options.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true)
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
    void setProjection(Projection projection);

}
