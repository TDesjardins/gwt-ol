package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;

/**
 * Options for {@link Text}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class TextOptions implements Options {
    
    public static native TextOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract TextOptions text(String text);
    
}

