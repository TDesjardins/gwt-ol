package ol.source;

import com.google.gwt.core.client.js.JsType;

/**
 * Source for OSM layer.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Osm implements Xyz {
    
    public static native Osm newInstance(XyzOptions osmOptions) /*-{
        return new $wnd.ol.source.OSM(osmOptions);
    }-*/;
    
}

