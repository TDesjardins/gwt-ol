package ol.style;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Text {
    
    public static native Text newInstance(TextOptions textOptions) /*-{
        return new $wnd.ol.style.Text(textOptions);
    }-*/;
    
}

