package ol.style;

import com.google.gwt.core.client.js.*;

import ol.Options;

/**
 * Options for the map.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface CircleOptions extends Options {

    @JsProperty
    CircleOptions fill(Fill fill);

    @JsProperty
    CircleOptions radius(int radius);

    @JsProperty
    CircleOptions snapToPixel(boolean snapToPixel);

    @JsProperty
    CircleOptions stroke(Stroke stroke);

}
