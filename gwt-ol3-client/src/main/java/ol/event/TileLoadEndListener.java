package ol.event;

import ol.source.TileEvent;

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
	void onTileLoadEnd(TileEvent evt);

}
