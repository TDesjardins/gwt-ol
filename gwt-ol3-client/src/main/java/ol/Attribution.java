package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Attribution {
    
    public static native Attribution newInstance(AttributionOptions attributionOptions) /*-{
        return new $wnd.ol.Attribution(attributionOptions);
    }-*/;
    
    public abstract String getHTML();
    
}

