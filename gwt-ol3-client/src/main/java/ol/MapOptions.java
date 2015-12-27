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
    View getView();

    @JsProperty
    MapOptions layers(Collection<Base> layers);

    /**
     * Controls initially added to the map.
     *
     * @param controls
     *            controls
     * @return this instance
     */
    @JsProperty
    MapOptions setControls(Collection<Control> controls);

    @JsProperty
    MapOptions setLayers(Collection<Base> layers);

    @JsProperty
    MapOptions setTarget(String target);

    /**
     * Set the map's view. No layer sources will be fetched unless this is
     * specified at construction time or through ol.Map#setView.
     * 
     * @param view
     *            {@link View}
     * @return this instance
     */
    @JsProperty
    MapOptions setView(View view);

    @JsProperty
    MapOptions target(String target);

    /**
     * Set the map's view. No layer sources will be fetched unless this is
     * specified at construction time or through ol.Map#setView.
     * 
     * @param view
     *            {@link View}
     * @return this instance
     */
    @JsProperty
    MapOptions view(View view);

}
