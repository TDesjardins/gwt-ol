package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;

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
 *          19-05-2016.
 */
@JsType(isNative = true)
public class Select extends Interaction {

    public Select() {}
    
    public Select(SelectOptions selectOptions) {}
    
    @JsProperty
    public native void setOptions(SelectOptions options);

	public native Collection<Feature> getFeatures();
	
	/**
	 * Events emitted by {@link Select} instances are instances of this type.
	 * 
	 * @author Tino Desjardins
	 *
	 */
	@JsType(isNative = true)
	public interface Event extends ol.event.Event {

	    @JsProperty
	    public String getType();
	    
	}

}
