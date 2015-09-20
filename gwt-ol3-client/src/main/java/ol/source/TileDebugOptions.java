package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.tilegrid.TileGrid;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface TileDebugOptions {
    
    /**
     * 
     * @param projection projection
     */
    @JsProperty
    void setProjection(String projection);
    
    /**
     * 
     * @param tileGrid tilegrid
     */
    @JsProperty
    void setTileGrid(TileGrid tileGrid);
    
    /**
     * 
     * @param wrapX
     */
    @JsProperty
    void setWrapX(boolean wrapX);
    
}

