package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class FullScreen implements Control {
    
    public static native FullScreen newInstance() /*-{
        return new $wnd.ol.control.FullScreen();
    }-*/;
    
}

