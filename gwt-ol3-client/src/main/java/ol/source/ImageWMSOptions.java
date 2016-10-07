package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface ImageWMSOptions extends Options {

    /**
     * 
     * @param imageWMSParams
     *            params for WMS-requests
     */
    @JsProperty
    void setParams(ImageWMSParams imageWMSParams);

    /**
     * 
     * @param ratio
     */
    @JsProperty
    void setRatio(float ratio);

    /**
     * 
     * @param url
     *            WMS service URL
     */
    @JsProperty
    void setUrl(String url);
    
    /**
     * 
     * @param projection
     */
    @JsProperty
    void setProjection(Projection projection);

}
