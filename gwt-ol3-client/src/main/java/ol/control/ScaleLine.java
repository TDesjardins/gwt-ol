package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class ScaleLine implements Control {
    
    public static native ScaleLine newInstance() /*-{
        return new $wnd.ol.control.ScaleLine();
    }-*/;
    
}

