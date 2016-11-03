package ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * An array of three numbers representing the location of a tile in a tile grid.
 * The order is z, x, and y. z is the zoom level.
 *
 */
public class TileCoord extends JavaScriptObject {

	@Deprecated
	protected TileCoord() {
	}

	/**
	 * Clones this object.
	 *
	 * @return {ol.TileCoord} clone
	 */
	public final native Size cloneObject() /*-{
											return this.slice(0);
											}-*/;

	/**
	 * Gets the zoom.
	 *
	 * @return zoom
	 */
	public final native int getZ() /*-{
										return this[0];
										}-*/;

	/**
	 * Gets the x.
	 *
	 * @return x
	 */
	public final native int getX() /*-{
										return this[1];
										}-*/;

	/**
	 * Gets the y.
	 *
	 * @return y
	 */
	public final native int getY() /*-{
										return this[2];
										}-*/;

}
