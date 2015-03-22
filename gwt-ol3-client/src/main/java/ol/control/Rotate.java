package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Rotate implements Control {
    
    public static native Rotate newInstance() /*-{
        return new $wnd.ol.control.Rotate();
    }-*/;
    
}

