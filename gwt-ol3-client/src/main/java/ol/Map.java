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
public abstract class Map implements Object {

    public static native <T> Map createInstance(MapOptions mapOptions) /*-{
        return new $wnd.ol.Map(mapOptions);
    }-*/;

    public abstract Collection<Control> getControls();

    @JsProperty
    public abstract double getPixelRatio();

    public abstract String getTarget();

    public abstract int getRevision();

    public abstract Collection<Base> getLayers();

    public abstract void setView(View view);

    public abstract void addControl(Control control);

    public abstract void removeControl(Control control);

    public abstract void addInteraction(Interaction interaction);

    public abstract void removeInteraction(Interaction interaction);

    public abstract void addLayer(Base layer);

    public abstract void removeLayer(Base layer);

    /**
     * Requests a render frame; rendering will effectively occur at the next browser animation frame.
     */
    public abstract void render();

    /**
     * Force a recalculation of the map viewport size. This should be called when third-party code changes the size of the map viewport.
     */
    public abstract void updateSize();

}
