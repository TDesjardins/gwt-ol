package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Attribution;

import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType
public interface ImageStaticOptions {

    @JsProperty
    void setAttributions (Attribution[] attributions);
    
    @JsProperty
    void setCrossOrigin(String crossOrigin);
    
    @JsProperty
    ImageStaticOptions crossOrigin(String crossOrigin);
    
    @JsProperty
    void setImageExtent(double[] extent);

    @JsProperty
    ImageStaticOptions imageExtent(double[] extent);

    @JsProperty
    void setImageSize(int[] imageSize);

    @JsProperty
    ImageStaticOptions imageSize(int[] imageSize);

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
