package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class ZoomSlider implements Control {
    
    public static native ZoomSlider newInstance() /*-{
        return new $wnd.ol.control.ZoomSlider();
    }-*/;
    
}

