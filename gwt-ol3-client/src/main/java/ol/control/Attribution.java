package ol.control;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Attribution extends Control {

    
    public Attribution() {}
    
    public Attribution(AttributionOptions attributionOptions) {}
    
    public native void setCollapsed(boolean collapsed);

    public native void setCollapsible(boolean collapsible);

}
