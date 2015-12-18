package ol.style;

import com.google.gwt.core.client.js.*;

import ol.Options;

/**
 * Options for the {@link Style}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface StyleOptions extends Options {

    /**
     * {@link Fill} style.
     * 
     * @param fill
     *            {@link Fill}
     * @return this instance.
     */
    @JsProperty
    public StyleOptions fill(Fill fill);

    /**
     * {@link Image} style.
     * 
     * @param image
     *            {@link Image}
     * @return this instance.
     */
    @JsProperty
    public StyleOptions image(Image image);

    /**
     * {@link Stroke} style.
     * 
     * @param stroke
     *            {@link Stroke}
     * @return this instance.
     */
    @JsProperty
    public StyleOptions stroke(Stroke stroke);

    /**
     * Z index.
     * 
     * @param zIndex
     *            Z index
     * @return this instance.
     */
    @JsProperty
    public StyleOptions zIndex(int zIndex);
}
