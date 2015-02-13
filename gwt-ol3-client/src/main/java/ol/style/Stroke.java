package ol.style;

import com.google.gwt.core.client.js.JsType;

/**
 * stroke style
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Stroke {
    
    public static native Stroke newInstance(StrokeOptions strokeOptions) /*-{
        return new $wnd.ol.style.Stroke(strokeOptions);
    }-*/;
    
}

