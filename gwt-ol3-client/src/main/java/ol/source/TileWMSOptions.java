/**
 *
 * @author mribeiro
 * @date 07/06/16 18:04
 *
 */
package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 *
 */
@JsType(isNative = true)
public interface TileWMSOptions extends Options{

    /**
     *
     * @param url
     */
    @JsProperty
    void setUrl(String url);

    /**
     *
     * @param serverType
     */
    @JsProperty
    void setServerType(String serverType);

    /**
     *
     * @param crossOrigin
     */
    @JsProperty
    void setCrossOrigin(String crossOrigin);

    /**
     *
     * @param tileWMSParams
     *            params for WMS-requests
     */
    @JsProperty
    void setParams(TileWMSParams tileWMSParams);

    /**
     *
     * @param projection
     */
    @JsProperty
    void setProjection(Projection projection);

}