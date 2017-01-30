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
	public final WMSServerType getServerType() {
		return Constant.of(WMSServerType.class, getServerTypeString());
	}

	@JsOverlay
	public final void setServerType(WMSServerType serverType) {
		setServerTypeString(serverType.getValue());
	}

	/**
	 *
	 * @param tileWMSParams params for WMS-requests
	 */
	@JsProperty
	public native void setParams(TileWMSParams params);

	@JsProperty
	public native TileWMSParams getParams();
}