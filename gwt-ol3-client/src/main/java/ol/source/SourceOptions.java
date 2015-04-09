package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Attribution;

/**
 * @author Tino Desjardins
 */
@JsType
public interface SourceOptions {

    @JsProperty
    void setAttributions (Attribution[] attributions);
    
}
