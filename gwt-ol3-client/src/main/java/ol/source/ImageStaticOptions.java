package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Extent;

import ol.Size;
import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType
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
