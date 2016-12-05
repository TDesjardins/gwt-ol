
package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface TranslateOptions extends Options {

	/**
	 * Only features contained in this collection will be able to be translated. If not specified, all features on the map will be able to be translated.
	 * 
	 * @param features
	 */
	@JsProperty
	public void setFeatures(Collection<Feature> features);

}
