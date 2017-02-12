package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * 
 * @author Peter Zanetti
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WMSFeatureInfoParams {
    
	@JsProperty(name = "QUERY_LAYERS")
	public native void setQueryLayers(String layers);

	@JsProperty(name = "INFO_FORMAT")
	public native void setInfoFormat(String version);

}
