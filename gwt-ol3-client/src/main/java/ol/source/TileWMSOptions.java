/**
 *
 * @author mribeiro
 * @date 07/06/16 18:04
 *
 */
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileWMSOptions implements Options{

    /**
     *
     * @param url
     */
    @JsProperty
    public native void setUrl(String url);

    /**
     *
     * @param serverType
     */
    @JsProperty
    public native void setServerType(String serverType);

    /**
     *
     * @param crossOrigin
     */
    @JsProperty
    public native void setCrossOrigin(String crossOrigin);

    /**
     *
     * @param tileWMSParams
     *            params for WMS-requests
     */
    @JsProperty
    public native void setParams(TileWMSParams tileWMSParams);

    /**
     *
     * @param projection
     */
    @JsProperty
    public native void setProjection(Projection projection);

}