package ol.style;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Style {
    
    public static native Style newInstance(StyleOptions styleOptions) /*-{
        return new $wnd.ol.style.Style(styleOptions);
    }-*/;
    
}

