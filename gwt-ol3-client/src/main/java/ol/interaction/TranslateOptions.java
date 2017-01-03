
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TranslateOptions implements Options {

	/**
	 * Only features contained in this collection will be able to be translated. If not specified, all features on the map will be able to be translated.
	 * 
	 * @param features
	 */
	@JsProperty
	public native void setFeatures(Collection<Feature> features);

}
