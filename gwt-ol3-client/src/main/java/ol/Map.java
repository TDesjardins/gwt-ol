package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import ol.control.Control;
import ol.interaction.Interaction;
import ol.layer.Base;

/**
 * Map with controls, layers and interactions.
 * 
 * @author Tino Desjardins
 */
@JsType
public interface Map extends Object {

    public Collection<Control> getControls();

    @JsProperty
    public double getPixelRatio();

    public String getTarget();
    
    /**
     * The container for the map, either the element itself or the id of the element. If not specified at construction time, ol.Map#setTarget must be called for the map to be rendered.
     * @param o id or element
     */
    public void setTarget(java.lang.Object o);

    public int getRevision();

    public Collection<Base> getLayers();
    
    /**
     * Get the view associated with this map. A view manages properties such as center and resolution.
     * @return The view that controls this map. 
     */
    public View getView();

    public void setView(View view);

    public void addControl(Control control);

    public void removeControl(Control control);

    public void addInteraction(Interaction interaction);

    public void removeInteraction(Interaction interaction);

    public void addLayer(Base layer);

    public void removeLayer(Base layer);

    /**
     * Requests a render frame; rendering will effectively occur at the next browser animation frame.
     */
    public void render();

    /**
     * Force a recalculation of the map viewport size. This should be called when third-party code changes the size of the map viewport.
     */
    public void updateSize();

}
