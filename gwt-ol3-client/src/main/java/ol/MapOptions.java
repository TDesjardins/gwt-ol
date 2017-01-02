package ol;

import jsinterop.annotations.JsPackage;
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
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MapOptions implements Options {

    @JsProperty
    public native double getPixelRatio();

    @JsProperty
    public native String getTarget();

    @JsProperty
    public native void setTarget(String target);

    @JsProperty
    public native void setLayers(Collection<Base> layers);

    @JsProperty
    public native View getView();

    /**
     * Controls initially added to the map.
     *
     * @param controls controls
     */
    @JsProperty
    public native void setControls(Collection<Control> controls);

    /**
     * Set the map's view. No layer sources will be fetched unless this is
     * specified at construction time or through ol.Map#setView.
     *
     * @param view {@link View}
     */
    @JsProperty
    public native void setView(View view);

    @JsProperty
    public native void setInteractions(Interaction[] interactions);

	/**
	 * Interactions that are initially added to the map. If not specified,
	 * ol.interaction.defaults() is used.
	 *
	 * @param interactions
	 */
	@JsProperty
	public native void setInteractions(Collection<Interaction> interactions);

    /**
     * The map logo. A logo to be displayed on the map at all times.
     *  To disable the map logo, set the option to false. By default, the OpenLayers 3 logo is shown.
     *
     * @param value
     *              boolean
     */
    @JsProperty
    public native void setLogo(boolean value);

    /**
     * The map logo. A logo to be displayed on the map at all times.
     * If a string is provided, it will be set as the image source of the logo.
     * @param value
     *              String
     */
    @JsProperty
    public native void setLogo(String value);

}
