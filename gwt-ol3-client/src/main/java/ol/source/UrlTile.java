/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
