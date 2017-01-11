package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Abstract options for URL based tiles.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileImageOptions extends UrlTileOptions {}
