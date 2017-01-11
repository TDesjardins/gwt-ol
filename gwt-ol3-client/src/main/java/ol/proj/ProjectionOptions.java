package ol.proj;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import ol.Options;
import ol.Extent;
import jsinterop.annotations.JsType;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ProjectionOptions implements Options {
    
    @JsProperty
    public native void setCode(String code);
    
    @JsProperty
    public native void setUnits(String units);

    @JsProperty
    public native void setGlobal(boolean global);
    
    @JsProperty
    public native void setExtent(Extent extent);
    
}
