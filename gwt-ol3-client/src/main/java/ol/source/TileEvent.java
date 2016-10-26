package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.event.Event;

/**
 * Events emitted by {@link ol.source.Tile} instances are instances of this
 * type.
 * 
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public interface TileEvent extends Event {

	/**
	 * The tile related to the event.
	 * 
	 * @return ol.Tile
	 */
	@JsProperty
	public ol.Tile getTile();
}
