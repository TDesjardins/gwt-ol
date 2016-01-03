package ol.source;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.Size;
import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface ImageStaticOptions extends SourceOptions {
    
    @JsProperty
    void setCrossOrigin(String crossOrigin);
    
    @JsProperty
    void setImageExtent(Extent extent);

    @JsProperty
    void setImageSize(Size imageSize);

    @JsProperty
    void setProjection(Projection projection);

    /**
     * @param url URL to image
     */
    @JsProperty
    void setUrl(String url);

}
