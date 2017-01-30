package ol.source;

import jsinterop.annotations.JsType;
import ol.proj.Projection;
import ol.tilegrid.TileGrid;

/**
 * Base class for sources providing images divided into a tile grid.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class TileImage extends UrlTile {

	public native void setRenderReprojectionEdges(boolean render);
	
	public native void setTileGridForProjection(Projection projection, TileGrid tilegrid); 
}
