package ol.source;

import jsinterop.annotations.JsType;

/**
 * Base class for sources providing tiles divided into a tile grid over http.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class UrlTile extends Tile {
    
    /**
     * Return the URLs used for this source. When a tileUrlFunction is used
     * instead of url or urls, null will be returned.
     * 
     * @return {!Array.<string>|null} URLs.
     */
    public native String[] getUrls();

    /**
     * Set the URL to use for requests.
     * 
     * @param url
     *            URL.
     */
    public native void setUrl(String url);

    /**
     * Set the URLs to use for requests.
     * 
     * @param urls
     *            URLs.
     */
    public native void setUrls(String[] urls);
    
}
