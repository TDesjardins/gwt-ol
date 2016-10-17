package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.GenericFunction;
import ol.Options;

/**
 * Interaction for modifying feature geometries.
 * 
 * @author guandalini
 */
@JsType(isNative = true)
public interface ModifyOptions extends Options {

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event will be considered to add or move a vertex to
	 * the sketch. Default is ol.events.condition.primaryAction.
	 * 
	 * @param function
	 */
	@JsProperty
	void setCondition(GenericFunction<?, ?> function);

	/**
	 * A function that takes an ol.MapBrowserEvent and returns a boolean to
	 * indicate whether that event should be handled. By default,
	 * ol.events.condition.singleClick with ol.events.condition.noModifierKeys
	 * results in a vertex deletion.
	 * 
	 * @param function
	 */
	@JsProperty
	void setDeleteCondition(GenericFunction<?, ?> function);

	/**
	 * Pixel tolerance for considering the pointer close enough to a segment or
	 * vertex for editing. Default is 10.
	 * 
	 * @param clickTolerance
	 */
	@JsProperty
	void setPixelTolerance(int clickTolerance);

	/**
	 * Style used for the features being modified. By default the default edit
	 * style is used (see ol.style).
	 * 
	 * @param styleFunction
	 */
	@JsProperty
	void setStyle(GenericFunction<?, ?> styleFunction);

	/**
	 * The features the interaction works on. Required.
	 * 
	 * @param features
	 */
	@JsProperty
	void setFeatures(Collection<Feature> features);

	/**
	 * Wrap the world horizontally on the sketch overlay. Default is false.
	 * 
	 * @param wrapX
	 */
	@JsProperty
	void setWrapX(boolean wrapX);

}