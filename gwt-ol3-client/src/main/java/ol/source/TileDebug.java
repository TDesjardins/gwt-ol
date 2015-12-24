package ol.source;

import com.google.gwt.core.client.js.JsType;

/**
 * A pseudo tile source, which does not fetch tiles from a server, but renders a
 * grid outline for the tile grid/projection along with the coordinates for each
 * tile. See examples/canvas-tiles for an example.
 *
 * Uses Canvas context2d, so requires Canvas support.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.source.TileDebug")
public interface TileDebug extends Tile {

}
