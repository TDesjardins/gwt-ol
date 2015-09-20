package ol.tilegrid;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface TileGridOptions {
	
    @JsProperty
    void setExtent(double[] extent);
    
    @JsProperty
    void setMinZoom(double minZoom);
	
    @JsProperty
	void setMaxZoom(double maxZoom);
    
    @JsProperty
    void setOrigin(double[] coodinate);
    
    @JsProperty
    void setOrigins(double[] origins);
	
    @JsProperty
	void setResolutions(double[] resolutions);
	
    @JsProperty
	void setTileSize(int[] tileSize);
    
    @JsProperty
    void setTileSizes(int[] tileSizes);
	
}

