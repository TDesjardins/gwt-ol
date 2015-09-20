package ol.source;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class TileDebug implements Tile {
    
    public static native TileDebug newInstance(TileDebugOptions tileDebugOptions) /*-{
        return new $wnd.ol.source.TileDebug(tileDebugOptions);
    }-*/;
    
}

