/**
 * $$Id$$
 *
 * @author mribeiro
 * @date 07/06/16 18:04
 * <p/>
 * Copyright (C) 2016 MRibeiro
 * marco.lob@gmail.com
 * <p/>
 * All rights reserved.
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
    @JsProperty(name = "url")
    void setUrl(String url);

    /**
     *
     * @param serverType
     */
    @JsProperty(name = "serverType")
    void setServerType(String serverType);

    /**
     *
     * @param crossOrigin
     */
    @JsProperty(name = "crossOrigin")
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
    @JsProperty(name = "projection")
    void setProjection(Projection projection);

}