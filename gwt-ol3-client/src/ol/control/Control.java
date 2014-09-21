package ol.control;

import com.google.gwt.core.client.js.JsType;

import ol.Map;
import ol.Object;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Control extends Object {
    
    Map getMap();

    void setMap(Map map);
    
}

