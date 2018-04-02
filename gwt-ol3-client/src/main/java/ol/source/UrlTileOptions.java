/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Abstract options für URL based tiles.
 * 
 * @author Tino Desjardins
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.source.UrlTile.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class UrlTileOptions extends TileOptions {

    /**
     * @param cacheSize Cache size. Default is <code>2048</code>.
     */
    @JsProperty
    public native void setCacheSize(int cacheSize);

    @JsProperty
    public native int getCacheSize();

    /**
     * @param state Source state.
     */
    @JsProperty
    public native void setState(String state);

    @JsProperty
    public native String getState();

    /**
     * Optional function to load a tile given a URL. The default is
     * 
     * function(imageTile, src) { imageTile.getImage().src = src; };
     */
    @JsProperty
    public native void setTileLoadFunction(TileLoadFunction callback);

    @JsProperty
    public native TileLoadFunction getTileLoadFunction();

    /**
     * @param tilePixelRatio The pixel ratio used by the tile service. For example, if the tile service advertizes 256px by 256px tiles but actually sends 512px by 512px images (for retina/hidpi devices) then <code>tilePixelRatio</code> should be set to <code>2</code>. Default is <code>1</code>.
     */
    @JsProperty
    public native void setTilePixelRatio(int tilePixelRatio);

    @JsProperty
    public native int getTilePixelRatio();

    /**
     * Optional function to get tile URL given a tile coordinate and the
     * projection. Required if url or urls are not provided.
     */
    @JsProperty
    public native void setTileUrlFunction(TileUrlFunction callback);

    @JsProperty
    public native TileUrlFunction getTileUrlFunction();

    /**
     * Return the URLs used for this source. When a tileUrlFunction is used
     * instead of url or urls, null will be returned.
     * 
     * @return {!Array.<string>|null} URLs.
     */
    @JsProperty
    public native String[] getUrls();

    @JsProperty 
    public native String getUrl();

    /**
     * Set the URL to use for requests.
     * 
     * @param url
     *            URL.
     */
    @JsProperty
    public native void setUrl(String url);

    /**
     * Set the URLs to use for requests.
     * 
     * @param urls
     *            URLs.
     */
    @JsProperty
    public native void setUrls(String[] urls);

    /**
     * @param wrapX Whether to wrap the world horizontally. The default, <code>null</code>, is to request out-of-bounds tiles from the server. When set to <code>false</code>, only one world will be rendered. When set to <code>true</code>, tiles will be requested for one world only, but they will be wrapped horizontally to render multiple worlds.
     */
    @JsProperty
    public native void setWrapX(Boolean wrapX);

    @JsProperty
    public native Boolean getWrapX();

}