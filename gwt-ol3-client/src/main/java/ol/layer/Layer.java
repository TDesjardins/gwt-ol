package ol.layer;

import com.google.gwt.core.client.js.JsType;

import ol.source.Source;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Layer extends Base {

    Source getSource();
    
    void setSource(Source source);

}

