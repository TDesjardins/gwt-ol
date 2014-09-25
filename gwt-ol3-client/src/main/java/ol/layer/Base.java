package ol.layer;

import com.google.gwt.core.client.js.JsType;

/**
 * Base for OL3-Layers.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Base {
    
    float getBrightness();
    
    void setBrightness(float brightness);
    
    float getContrast();
    
    void setContrast(float contrast);
    
    float getMaxResolution();
    
    void setMaxResolution(float maxResolution);
    
    float getMinResolution();
    
    void setMinResolution(float minResolution);
    
    float getOpacity();
    
    void setOpacity(float opacity);
    
    float getSaturation();
    
    void setSaturation(float saturation);

    boolean getVisible();
    
    void setVisible(boolean visible);

}

