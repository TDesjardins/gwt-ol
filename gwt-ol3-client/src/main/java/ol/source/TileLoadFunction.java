package ol.source;

import jsinterop.annotations.JsFunction;
import ol.ImageTile;

/**
 *
 * 
 * The <code>TileLoadFunction</code> is used to hook into
 * 
 * @author Peter Zanetti
 */
@JsFunction
@FunctionalInterface
public interface TileLoadFunction {

	void loadTile(ImageTile imageTile, String src);
}
