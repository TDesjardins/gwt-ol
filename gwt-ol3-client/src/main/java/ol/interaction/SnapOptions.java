
package ol.interaction;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.source.Vector;

/**
 * @author guandalini
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SnapOptions implements Options {

	/**
	 * Snap to these features. Either this option or source should be provided.
	 * 
	 * @param features
	 */
	@JsProperty
	public native void setFeatures(Collection<Feature> features);

	/**
	 * Snap to edges. Default is true.
	 * 
	 * @param edge
	 */
	@JsProperty
	public native void setEdge(boolean edge);

	/**
	 * Snap to vertices. Default is true.
	 * 
	 * @param vertex
	 */
	@JsProperty
	public native void setVertex(boolean vertex);

	/**
	 * Pixel tolerance for considering the pointer close enough to a segment or
	 * vertex for snapping. Default is 10 pixels.
	 * 
	 * @param tolerance
	 */
	@JsProperty
	public native void setPixelTolerance(double tolerance);

	/**
	 * Snap to features from this source. Either this option or features should be
	 * provided
	 * 
	 * @param source
	 */
	@JsProperty
	public native void setSource(Vector source);

}
