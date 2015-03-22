package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class ZoomToExtent implements Control {
    
    public static native ZoomToExtent newInstance() /*-{
        return new $wnd.ol.control.ZoomToExtent();
    }-*/;
    
}

