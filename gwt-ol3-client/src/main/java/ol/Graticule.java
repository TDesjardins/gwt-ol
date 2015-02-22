package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Graticule {
    
    public static native Graticule newInstance() /*-{
        return new $wnd.ol.Graticule();
    }-*/;
    
    public abstract void setMap(Map map);
    
}

