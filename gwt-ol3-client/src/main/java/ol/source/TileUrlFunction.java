package ol.source;

import jsinterop.annotations.JsFunction;
import ol.TileCoord;
import ol.proj.Projection;

/**
 *
 * 
 * The <code>TileUrlFunction</code> is used to hook into
 * 
 * @author Peter Zanetti
 */
@JsFunction
@FunctionalInterface
public interface TileUrlFunction {

	String getUrl(TileCoord tileCoord, double pixelRatio, Projection projection);
}
