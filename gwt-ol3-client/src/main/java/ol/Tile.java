package ol;

import jsinterop.annotations.JsType;

/**
 *
 * Base class for tiles.
 *
 */
@JsType(isNative = true)
public abstract class Tile {

	/**
	 * Get the tile coordinate for this tile.
	 * 
	 * @return TileCoord
	 */
	public native TileCoord getTileCoord();

	/**
	 * Load the image or retry if loading previously failed. Loading is taken
	 * care of by the tile queue, and calling this method is only needed for
	 * preloading or for reloading in case of an error.
	 * 
	 */
	public native void load();

}
