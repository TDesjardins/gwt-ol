package ol.style;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * Options for the {@link Style}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class StyleOptions implements Options {

    /**
     * {@link Fill} style.
     *
     * @param fill {@link Fill}
     */
    @JsProperty
    public native void setFill(Fill fill);

    /**
     * {@link Image} style.
     *
     * @param image {@link Image}
     */
    @JsProperty
    public native void setImage(Image image);

    /**
     * {@link Stroke} style.
     *
     * @param stroke {@link Stroke}
     */
    @JsProperty
    public native void setStroke(Stroke stroke);

    /**
     * Z index.
     *
     * @param zIndex Z-index
     */
    @JsProperty
    public native void setZIndex(int zIndex);

    /**
     * Text style.
     *
     * @param text {@Text text}
     */
    @JsProperty
    public native void setText(Text text);

}
