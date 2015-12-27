package ol;

import com.google.gwt.core.client.js.*;

import ol.control.Control;
import ol.layer.Base;

/**
 * Options for the map.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface MapOptions extends Options {

    @JsProperty
    double getPixelRatio();

    @JsProperty
    String getTarget();
    
    @JsProperty
    void setTarget(String target);
    
    @JsProperty
    void setLayers(Collection<Base> layers);

    @JsProperty
    View getView();

    /**
     * Controls initially added to the map.
     *
     * @param controls controls
     */
    @JsProperty
    void setControls(Collection<Control> controls);

    /**
     * Set the map's view. No layer sources will be fetched unless this is
     * specified at construction time or through ol.Map#setView.
     * 
     * @param view
     *            {@link View}
     * @return this instance
     */
    @JsProperty
    void setView(View view);

}
