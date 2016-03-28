package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Size;
import ol.tilegrid.TileGrid;

/**
 * XYZ options.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface XyzOptions extends SourceOptions {

    /**
     * Gets the {@link TileGrid}.
     *
     * @return tileGrid {@link TileGrid}
     */
    @JsProperty
    TileGrid getTileGrid();

    /**
     * Set the optional max zoom level. Default is 18.
     *
     * @param maxZoom
     *            max zoom
     *
     * @return this instance
     */
    @JsProperty
    XyzOptions setMaxZoom(int maxZoom);

    /**
     * Set the {@link TileGrid}.
     *
     * @param tileGrid
     *            {@link TileGrid}
     *
     * @return this instance
     */
    @JsProperty
    XyzOptions setTileGrid(TileGrid tileGrid);

    /**
     * Set the {@link Size} of a tile.
     * @param size {@link Size}
     * @return this instance
     */
    @JsProperty
    XyzOptions setTileSize(Size size);
    
    /**
     * Set the URL template. Must include {x}, {y} or {-y}, and {z}
     * placeholders. A {?-?} template pattern, for example
     * subdomain{a-f}.domain.com, may be used instead of defining each one
     * separately in the urls option.
     *
     * @param url
     *            URL template
     * @return this instance
     */
    @JsProperty
    XyzOptions setUrl(String url);

    /**
     * Set the URL templates. Must include {x}, {y} or {-y}, and {z}
     * placeholders. A {?-?} template pattern, for example
     * subdomain{a-f}.domain.com, may be used instead of defining each one
     * separately in the urls option.
     *
     * @param urls
     *            array of URL templates
     * @return this instance
     */
    @JsProperty
    XyzOptions setUrls(String[] urls);

}
