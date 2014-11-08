package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface StaticImageOptions {
    
	@JsProperty
	void setExtent(double[] extent);
	
	@JsProperty
	void setImageSize(double[] imageSize);
	
    /**
     * 
     * @param url URL to image
     */
    @JsProperty
    void setUrl(String url);
    
}

