package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Options for the map.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class CircleOptions {
    
    public static native CircleOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract CircleOptions fill(Fill fill);
    
    @JsProperty
    public abstract CircleOptions radius(int radius);
    
    @JsProperty
    public abstract CircleOptions snapToPixel(boolean snapToPixel);
    
    @JsProperty
    public abstract CircleOptions stroke(Stroke stroke);
    
}

