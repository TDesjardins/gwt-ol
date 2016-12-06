package ol.event;

import ol.source.Tile;

/**
 * A listener for tile finishes loading.
 * 
 */
public interface TileLoadEndListener {

	/**
	 * Triggered when a tile finishes loading.
	 * 
	 * @param evt
	 *            {@link TileEvent}
	 */
	void onTileLoadEnd(Tile.Event evt);

}
