package ol;

import jsinterop.annotations.JsProperty;

import jsinterop.annotations.JsType;
import ol.control.Control;
import ol.interaction.Interaction;
import ol.layer.Base;

/**
 * Options for the map.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
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
     * @param view {@link View}
     */
    @JsProperty
    void setView(View view);

    @JsProperty
    void setInteractions(Interaction[] interactions);

	/**
	 * Interactions that are initially added to the map. If not specified,
	 * ol.interaction.defaults() is used.
	 *
	 * @param interactions
	 */
	@JsProperty
	void setInteractions(Collection<Interaction> interactions);

}
