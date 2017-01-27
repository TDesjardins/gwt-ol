/**
 *
 * @author mribeiro
 * @date 07/06/16 18:04
 *
 */
package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import tol.j2cl.elem.global.Map;
import tol.j2cl.elem.util.Constant;

/**
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileWMSOptions extends TileImageOptions {

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

	/**
	 *
	 * @param tileWMSParams params for WMS-requests
	 */
	@JsProperty(name = "params")
	public native void setParams(TileWMSParams params);

	@JsProperty(name = "params")
	public native void setParams(Map<String> params);

	@JsProperty(name = "params")
	public native TileWMSParams getTileWMSParams();

	@JsProperty(name = "params")
	public native Map<String> getParams();

}