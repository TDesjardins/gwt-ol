package ol.tilegrid;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class TileGrid {
    
    public static native TileGrid newInstance(TileGridOptions tileGridOptions) /*-{
        return new $wnd.ol.tilegrid.TileGrid(tileGridOptions);
    }-*/;
    
}

