package ol.source;

import com.google.gwt.core.client.js.JsType;

/**
 * Base class for sources providing images divided into a tile grid.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.TileImage")
public interface TileImage extends UrlTile {
}
