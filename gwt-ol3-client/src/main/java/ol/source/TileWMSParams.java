/**
 *
 * @author mribeiro
 * @date 07/06/16 18:05
 *
 */
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileWMSParams extends ImageWMSParams {

	/**
	 *
	 * @param tiled
	 */
	@JsProperty(name = "TILED")
	public native void setTiled(boolean tiled);
}