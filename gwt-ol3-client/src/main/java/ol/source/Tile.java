package ol.source;

import com.google.gwt.core.client.js.JsType;

import ol.tilegrid.TileGrid;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface Tile extends Source {
    
    TileGrid getTileGrid();
    
}

