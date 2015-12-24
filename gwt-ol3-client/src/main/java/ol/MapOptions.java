package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.layer.Base;

/**
 * Options for the map.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface MapOptions {
    
    @JsProperty
    double getPixelRatio();
    
    @JsProperty
    String getTarget();
    
    @JsProperty
    void setTarget(String target);
    
    @JsProperty
    void setLayers(Collection<Base> layers);

    
    @JsProperty
    View getView();
    
    @JsProperty
    void setView(View view);
    
}

