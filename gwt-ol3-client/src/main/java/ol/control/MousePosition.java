package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class MousePosition implements Control {
    
    public static native MousePosition newInstance() /*-{
        return new $wnd.ol.control.MousePosition();
    }-*/;
    
}

