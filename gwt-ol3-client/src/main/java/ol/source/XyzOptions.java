package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Size;

/**
 * XYZ options.
 *
 * @author Tino Desjardins
 *
 * @see http://openlayers.org/en/latest/apidoc/ol.source.XYZ.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class XyzOptions extends TileImageOptions {

	/**
	 * Set the optional max zoom level. Default is 18.
	 *
	 * @param maxZoom max zoom
	 */
	@JsProperty
	public native void setMaxZoom(int maxZoom);

	@JsProperty
	public native int getMaxZoom();

	/**
	 * Set the tile size used by the tile service. Default is [256, 256] pixels.
	 * 
	 * @param tileSize tile size
	 */
	@JsProperty
	public native void setTileSize(Size tileSize);
	
    @JsProperty
    public native Size getTileSize();
}
