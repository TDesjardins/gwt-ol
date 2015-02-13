package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Options for the style {@link Fill}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class FillOptions {
    
    public static native FillOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract FillOptions color(String color);
    
}

