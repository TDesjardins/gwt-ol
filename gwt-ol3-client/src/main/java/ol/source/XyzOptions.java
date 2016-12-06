package ol.source;

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
@JsType(isNative = true)
public interface XyzOptions extends TileImageOptions {

	/**
	 * Set the optional max zoom level. Default is 18.
	 *
	 * @param maxZoom max zoom
	 */
	@JsProperty
	void setMaxZoom(int maxZoom);

	/**
	 * Optional function to get tile URL given a tile coordinate and the
	 * projection. Required if url or urls are not provided.
	 */
	@JsProperty
	void setTileUrlFunction(TileUrlFunction callback);

	/**
	 * Optional function to load a tile given a URL. The default is
	 * 
	 * function(imageTile, src) { imageTile.getImage().src = src; };
	 */
	@JsProperty
	void setTileLoadFunction(TileLoadFunction callback);

	/**
	 * Set the tile size used by the tile service. Default is [256, 256] pixels.
	 * 
	 * @param tileSize tile size
	 */
	@JsProperty
	void setTileSize(Size tileSize);
}
