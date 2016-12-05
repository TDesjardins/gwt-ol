package ol.event;

import ol.source.Tile;

/**
 * A listener for tile starts loading.
 * 
 */
public interface TileLoadStartListener {

	/**
	 * Triggered when a tile starts loading.
	 * 
	 * @param evt
	 *            {@link ol.source.Tile.Event}
	 */
	void onTileLoadStart(Tile.Event evt);

}
