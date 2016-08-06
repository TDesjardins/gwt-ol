package ol.interaction;

import ol.Collection;
import ol.Feature;

import com.google.gwt.core.client.js.JsType;

/**
 * Interaction for selecting vector features. By default, selected features are
 * styled differently, so this interaction can be used for visual highlighting, 
 * as well as selecting features for other actions, such as modification or output. 
 * There are three ways of controlling which features are selected:
 * 	using the browser event as defined by the condition and optionally the toggle, add/remove, and multi options;
 * 	a layers filter;
 * 	and a further feature filter using the filter option.
 * 
 * Selected features are added to an internal unmanaged layer.
 * 
 * @author Tino Desjardins
 */
@JsType(prototype = "ol.interaction.Select")
public interface Select extends Interaction {

	public Collection<Feature> getFeatures();
	
}
