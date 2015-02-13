package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Options for the style {@link Stroke}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class StrokeOptions {
    
    public static native StrokeOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract StrokeOptions color(String color);
    
    @JsProperty
    public abstract StrokeOptions width(int width);
    
}

