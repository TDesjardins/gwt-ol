/**
 *
 * @author mribeiro
 * @date 07/06/16 18:03
 *
 */
package ol.source;

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;

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
			WMSFeatureInfoParams params);

	public native TileWMSParams getParams();

	public native void updateParams(TileWMSParams params);

}