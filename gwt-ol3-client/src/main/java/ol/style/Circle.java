package ol.style;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Circle {
    
    public static native Circle newInstance(CircleOptions circleOptions) /*-{
        return new $wnd.ol.style.Circle(circleOptions);
    }-*/;
    
}

