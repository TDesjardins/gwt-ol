package ol.source;

import jsinterop.annotations.JsType;

/**
 * Base class for sources providing tiles divided into a tile grid over http.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public interface UrlTile extends Tile {
    /**
     * Return the URLs used for this source. When a tileUrlFunction is used
     * instead of url or urls, null will be returned.
     * 
     * @return {!Array.<string>|null} URLs.
     */
    String[] getUrls();

    /**
     * Set the URL to use for requests.
     * 
     * @param url
     *            URL.
     */
    void setUrl(String url);

    /**
     * Set the URLs to use for requests.
     * 
     * @param urls
     *            URLs.
     */
    void setUrls(String[] urls);
}
