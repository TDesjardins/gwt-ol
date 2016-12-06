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

    /**
     * The map logo. A logo to be displayed on the map at all times.
     *  To disable the map logo, set the option to false. By default, the OpenLayers 3 logo is shown.
     *
     * @param value
     *              boolean
     */
    @JsProperty
    void setLogo(boolean value);

    /**
     * The map logo. A logo to be displayed on the map at all times.
     * If a string is provided, it will be set as the image source of the logo.
     * @param value
     *              String
     */
    @JsProperty
    void setLogo(String value);

}
