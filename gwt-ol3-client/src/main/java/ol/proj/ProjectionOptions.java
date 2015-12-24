package ol.proj;

import ol.Extent;

import jsinterop.annotations.JsType;

/**
 * @author Tino Desjardins
 */
@JsType
public class ProjectionOptions {

    public String code;
    
    public Extent extent;
    
    public boolean global;
    
    public String units;
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setUnits(String units) {
        this.units = units;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }
    
    public void setExtent(Extent extent) {
        this.extent = extent;
    }
    
}

