package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageWMSOptions implements Options {

    /**
     * 
     * @param imageWMSParams
     *            params for WMS-requests
     */
    @JsProperty
    public native void setParams(ImageWMSParams imageWMSParams);

    /**
     * 
     * @param ratio
     */
    @JsProperty
    public native void setRatio(float ratio);

    /**
     * 
     * @param url
     *            WMS service URL
     */
    @JsProperty
    public native void setUrl(String url);
    
    /**
     * 
     * @param projection
     */
    @JsProperty
    public native void setProjection(Projection projection);

}
