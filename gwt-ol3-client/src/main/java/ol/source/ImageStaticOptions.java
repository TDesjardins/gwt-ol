package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.Size;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageStaticOptions extends SourceOptions {

    @JsProperty
    public native void setCrossOrigin(String crossOrigin);

    @JsProperty
    public native void setImageExtent(Extent extent);

    @JsProperty
    public native void setImageSize(Size imageSize);

    /**
     * @param url URL to image
     */
    @JsProperty
    public native void setUrl(String url);

}
