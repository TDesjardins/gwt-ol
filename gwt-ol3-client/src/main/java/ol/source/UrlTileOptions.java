package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Abstract options für URL based tiles.
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface UrlTileOptions extends TileOptions {
    
    /**
     * Return the URLs used for this source. When a tileUrlFunction is used
     * instead of url or urls, null will be returned.
     * 
     * @return {!Array.<string>|null} URLs.
     */
    @JsProperty
    String[] getUrls();

    /**
     * Set the URL to use for requests.
     * 
     * @param url
     *            URL.
     */
    @JsProperty
    void setUrl(String url);

    /**
     * Set the URLs to use for requests.
     * 
     * @param urls
     *            URLs.
     */
    @JsProperty
    void setUrls(String[] urls);

}