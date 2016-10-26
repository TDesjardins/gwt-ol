package ol.event;

import ol.source.TileEvent;

/**
 * A listener for tile starts loading.
 * 
 */
public interface TileLoadStartListener {

	/**
	 * Triggered when a tile starts loading.
	 * 
	 * @param evt
	 *            {@link TileEvent}
	 */
	void onTileLoadStart(TileEvent evt);

}
