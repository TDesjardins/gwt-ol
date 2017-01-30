package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import tol.j2cl.elem.global.Map;
import tol.j2cl.elem.util.Constant;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageWMSOptions extends SourceOptions {

	@JsProperty
	public native void setCrossOrigin(String crossOrigin);

	@JsProperty
	public native String getCrossOrigin();

	@JsProperty(name = "serverType")
	public native String getServerTypeString();

	@JsProperty(name = "serverType")
	public native void setServerTypeString(String serverType);

	@JsOverlay
	public WMSServerType getServerType() {
		return Constant.of(WMSServerType.class, getServerTypeString());
	}

	@JsOverlay
	public void setServerType(WMSServerType serverType) {
		setServerTypeString(serverType.getValue());
	}

	@JsProperty
	public native void setImageLoadFunction(ImageLoadFunction imageLoadFunction);

	@JsProperty
	public native ImageLoadFunction getImageLoadFunction();

	/**
	 * 
	 * @param imageWMSParams params for WMS-requests
	 */
	@JsProperty(name = "params")
	public native void setParams(ImageWMSParams params);

	@JsProperty(name = "params")
	public native void setParams(Map<String> params);
	
	@JsProperty(name = "params")
	public native ImageWMSParams getImageWMSParams();

	@JsProperty(name = "params")
	public native Map<String> getParams();

	/**
	 * 
	 * @param ratio
	 */
	@JsProperty
	public native void setRatio(float ratio);

	@JsProperty
	public native float getRatio();

	@JsProperty
	public native void setResolutions(double[] resolutions);

	@JsProperty
	public native double[] getResolutions();

	/**
	 * 
	 * @param url WMS service URL
	 */
	@JsProperty
	public native void setUrl(String url);

	@JsProperty
	public native String getUrl();

}
