package ol.proj;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Projection {
    
    String getCode();
    
    double[] getExtent();
    
    void setExtent(double[] extent);
    
    double getMetersPerUnit();
    
    String getUnits();
    
    boolean isGlobal();

}

