package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WMSFeatureInfoParams {

	@JsProperty
	public String	QUERY_LAYERS;

	@JsProperty
	public String	INFO_FORMAT;

	@JsProperty(name = "QUERY_LAYERS")
	public native void setQueryLayers(String layers);

	@JsProperty(name = "INFO_FORMAT")
	public native void setInfoFormat(String version);
}
