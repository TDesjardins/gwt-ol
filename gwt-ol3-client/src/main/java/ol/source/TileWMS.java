/**
 *
 * @author mribeiro
 * @date 07/06/16 18:03
 *
 */
package ol.source;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;
import tol.j2cl.elem.global.Map;

/**
 *
 */
@JsType(isNative = true)
public class TileWMS extends TileImage {

	/**
	 * Constructs a(n) {@link TileWMS} object.
	 *
	 */
	public TileWMS(TileWMSOptions options) {}

	public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
			Map<String> params);

	public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
			WMSFeatureInfoParams params);

	@JsMethod(name = "getParams")
	public native Map<String> getParams();

	@JsMethod(name = "getParams")
	public native TileWMSParams getTileWMSParams();

	public native void updateParams(Map<String> params);

	public native void updateParams(TileWMSOptions options);

}