package ol.source;

import jsinterop.annotations.JsType;

/**
 * Layer source for the OpenStreetMap tile server.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, name = "OSM")
public class Osm extends Xyz {
    
    public Osm() {}
    
    public Osm(XyzOptions osmSourceOptions) {}
    
}

