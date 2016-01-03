package ol.proj;

import jsinterop.annotations.JsProperty;

import ol.Options;
import ol.Extent;
import jsinterop.annotations.JsType;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface ProjectionOptions extends Options {
    
    @JsProperty
    public void setCode(String code);
    
    @JsProperty
    public void setUnits(String units);

    @JsProperty
    public void setGlobal(boolean global);
    
    @JsProperty
    public void setExtent(Extent extent);
    
}
