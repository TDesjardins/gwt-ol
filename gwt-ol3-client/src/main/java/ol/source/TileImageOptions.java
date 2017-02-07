package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Abstract options for URL based tiles.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileImageOptions extends UrlTileOptions {

	/**
	 * Optional function to load a tile given a URL. The default is
	 * 
	 * function(imageTile, src) { imageTile.getImage().src = src; };
	 */
	@JsProperty
	public native void setTileLoadFunction(TileLoadFunction callback);

	@JsProperty
	public native TileLoadFunction getTileLoadFunction();
}
