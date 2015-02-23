package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;


/**
 * Options for {@link Attribution}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class AttributionOptions {
    
    public static native AttributionOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract void setHtml(String html);
    
    @JsProperty
    public abstract AttributionOptions html(String html);
    
}

