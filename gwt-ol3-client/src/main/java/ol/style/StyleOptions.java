package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Options for the {@link Style}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface StyleOptions extends Options {

    /**
     * {@link Fill} style.
     * 
     * @param fill {@link Fill}
     */
    @JsProperty
    void setFill(Fill fill);

    /**
     * {@link Image} style.
     * 
     * @param image {@link Image}
     */
    @JsProperty
    void setImage(Image image);

    /**
     * {@link Stroke} style.
     * 
     * @param stroke {@link Stroke}
     */
    @JsProperty
    void setStroke(Stroke stroke);

    /**
     * Z index.
     * 
     * @param zIndex Z-index
     */
    @JsProperty
    void setZIndex(int zIndex);

    /**
     * Text style.
     *
     * @param text {@Text text}
     */
    @JsProperty
    void setText(Text text);

}
