package ol.source;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

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
     * @param maxZoom max zoom
     */
    @JsProperty
    void setMaxZoom(int maxZoom);

    /**
     * Set the {@link TileGrid}.
     *
     * @param tileGrid {@link TileGrid}
     */
    @JsProperty
    void setTileGrid(TileGrid tileGrid);

    /**
     * Set the URL template. Must include {x}, {y} or {-y}, and {z}
     * placeholders. A {?-?} template pattern, for example
     * subdomain{a-f}.domain.com, may be used instead of defining each one
     * separately in the urls option.
     *
     * @param url
     *            URL template
     */
    @JsProperty
    void setUrl(String url);

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
    void setUrls(String[] urls);

}
