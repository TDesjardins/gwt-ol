package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface XyzOptions extends SourceOptions {
    
    /**
     * 
     * @param url
     */
    @JsProperty
    void setUrl(String url);
    
}

