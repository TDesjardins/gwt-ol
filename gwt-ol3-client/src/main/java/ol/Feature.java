package ol;

import com.google.gwt.core.client.js.JsType;

import ol.geom.Geometry;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Feature extends Object {
    
    Feature clone();
    
    Geometry getGeometry();
    
    String getGeometryName();
    
    String getId();
    
    void setGeometry(Geometry geometry);
    
    void setGeometryName(String geometryName);
    
    void setId(String id);
    
}

