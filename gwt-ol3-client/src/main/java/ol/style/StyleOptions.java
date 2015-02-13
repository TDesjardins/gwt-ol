package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Options for the {@link Style}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class StyleOptions {
    
    public static native StyleOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract StyleOptions fill(Fill fill);
    
    @JsProperty
    public abstract void setStroke(Stroke stroke);
    
    @JsProperty
    public abstract StyleOptions stroke(Stroke stroke);
    
    @JsProperty
    public abstract void setZIndex(int zIndex);
    
    @JsProperty
    public abstract StyleOptions zIndex(int zIndex);
    
}

