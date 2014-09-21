package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import java.util.List;

import ol.control.Control;
import ol.interaction.Interaction;
import ol.layer.Base;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Map {
    
    @JsProperty
    double getPixelRatio();
    
    @JsProperty
    String getTarget();
    
    int getRevision();
    
    /*@JsProperty
    void setLayers(List<Base> layers);*/
    
    @JsProperty
    void setLayers(List<Base> layers);
    
    Collection<Base> getLayers();
    
    void setView(View view);
    
    void addControl(Control control);
    
    void removeControl(Control control);
    
    void addInteraction(Interaction interaction);
    
    void removeInteraction(Interaction interaction);
    
    void addLayer(Base layer);
    
    void removeLayer(Base layer);
    
    /**
     * Requests a render frame; rendering will effectively occur at the next browser animation frame.
     */
    void render();
    
    /**
     * Force a recalculation of the map viewport size. This should be called when third-party code changes the size of the map viewport.
     */
    void updateSize();
    
}

