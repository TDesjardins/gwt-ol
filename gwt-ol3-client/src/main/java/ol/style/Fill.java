package ol.style;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Fill {
    
    public static native Fill newInstance(FillOptions fillOptions) /*-{
        return new $wnd.ol.style.Fill(fillOptions);
    }-*/;
    
}

