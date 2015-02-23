package ol.control;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Attribution implements Control {
    
    public static native Attribution newInstance() /*-{
        return new $wnd.ol.control.Attribution();
    }-*/;
    
    public abstract void setCollapsed(boolean collapsed);
    
    public abstract void setCollapsible(boolean collapsible);
    
}

