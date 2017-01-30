package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Base class for sources providing tiles divided into a tile grid over http.
 *
 * @author sbaumhekel
 */
@JsType(isNative = true)
public class UrlTile extends Tile {
    
	/**
	 * Optional function to get tile URL given a tile coordinate and the
	 * projection. Required if url or urls are not provided.
	 */
	public native void setTileUrlFunction(TileUrlFunction callback);

	public native TileUrlFunction getTileUrlFunction();
	
	/**
	 * Optional function to load a tile given a URL. The default is
	 * 
	 * function(imageTile, src) { imageTile.getImage().src = src; };
	 */
	public native void setTileLoadFunction(TileLoadFunction callback);
	
	@JsProperty
	public native TileLoadFunction getTileLoadFunction();
	
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
