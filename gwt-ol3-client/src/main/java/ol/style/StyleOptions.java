package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

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
     * @param fill {@link Fill}
     */
    @JsProperty
    public void setFill(Fill fill);

    /**
     * {@link Image} style.
     * 
     * @param image {@link Image}
     */
    @JsProperty
    public void setImage(Image image);

    /**
     * {@link Stroke} style.
     * 
     * @param stroke {@link Stroke}
     */
    @JsProperty
    public void setStroke(Stroke stroke);

    /**
     * Z index.
     * 
     * @param zIndex Z-index
     */
    @JsProperty
    public void setZIndex(int zIndex);
    
}
