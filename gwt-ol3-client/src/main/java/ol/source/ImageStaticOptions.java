package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.*;
import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType
public interface ImageStaticOptions extends SourceOptions {
    
    @JsProperty
    void setCrossOrigin(String crossOrigin);
    
    @JsProperty
    ImageStaticOptions crossOrigin(String crossOrigin);
    
    @JsProperty
    void setImageExtent(Extent extent);

    @JsProperty
    ImageStaticOptions imageExtent(Extent imageExtent);

    @JsProperty
    void setImageSize(int[] imageSize);

    @JsProperty
    ImageStaticOptions imageSize(Size size);

    @JsProperty
    void setProjection(Projection projection);

    @JsProperty
    ImageStaticOptions projection(Projection projection);

    /**
     * @param url URL to image
     */
    @JsProperty
    void setUrl(String url);

    @JsProperty
    ImageStaticOptions url(String url);

}
