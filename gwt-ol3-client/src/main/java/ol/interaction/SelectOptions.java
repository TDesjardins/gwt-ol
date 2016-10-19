package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.Options;
import ol.layer.Layer;

/**
 * Options for interaction {@link Select}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface SelectOptions extends Options{

	/**
	 * 
	 * Style for the selected features. By default the default edit style is used
	 * (see ol.style).
	 *
	 * @param styleFunction
	 */
    @JsProperty
    void setStyle(GenericFunction<?, ?> styleFunction);

	/**
	 * 
	 * A list of layers from which features should be selected. Alternatively, a
	 * filter function can be provided. The function will be called for each layer
	 * in the map and should return true for layers that you want to be
	 * selectable. If the option is absent, all visible layers will be considered
	 * selectable.
	 *
	 * @param layers
	 */
    @JsProperty
    void setLayers(Layer[] layers);

	/**
	 * 
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. By default, this is
	 * ol.events.condition.never. Use this if you want to use different events for
	 * add and remove instead of toggle.
	 *
	 * @param function
	 */
    @JsProperty
    void setRemoveCondition(GenericFunction<?, ?> function);

	/**
	 * 
	 * A boolean that determines if the default behaviour should select only
	 * single features or all (overlapping) features at the clicked map position.
	 * Default is false i.e single select
	 *
	 * @param multi
	 */
    @JsProperty
    void setMulti(boolean multi);

	/**
	 * 
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. This is in addition to the
	 * condition event. By default, ol.events.condition.shiftKeyOnly, i.e.
	 * pressing shift as well as the condition event, adds that feature to the
	 * current selection if it is not currently selected, and removes it if it is.
	 * See add and remove if you want to use different events instead of a toggle.
	 *
	 * @param function
	 */
    @JsProperty
    void setToogleCondition(GenericFunction<?, ?> function);

	/**
	 * Collection where the interaction will place selected features. Optional. If
	 * not set the interaction will create a collection. In any case the
	 * collection used by the interaction is returned by
	 * ol.interaction.Select#getFeatures.
	 *
	 * @param features
	 */
	@JsProperty
	void setFeatures(Collection<Feature> features);
}
