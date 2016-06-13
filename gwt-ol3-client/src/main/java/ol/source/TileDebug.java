package ol.source;

import jsinterop.annotations.JsType;

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
@JsType(isNative = true)
public class TileDebug extends Tile {
	
	public TileDebug(TileDebugOptions tileDebugOptions) {}

}
