package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Options for the {@link Style}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface StyleOptions {

    /**
     * @param fill
     * @return
     */
    @JsProperty
    public StyleOptions fill(Fill fill);

    @JsProperty
    public void setStroke(Stroke stroke);

    @JsProperty
    public StyleOptions stroke(Stroke stroke);

    @JsProperty
    public void setZIndex(int zIndex);

    @JsProperty
    public StyleOptions zIndex(int zIndex);

}
