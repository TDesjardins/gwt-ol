package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.layer.Base;

/**
 * Options for the map.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface MapOptions extends Options {

    @JsProperty
    double getPixelRatio();

    @JsProperty
    String getTarget();

    @JsProperty
    void setTarget(String target);

    @JsProperty
    MapOptions target(String target);

    @JsProperty
    void setLayers(Collection<Base> layers);

    @JsProperty
    MapOptions layers(Collection<Base> layers);

    @JsProperty
    View getView();

    @JsProperty
    void setView(View view);

    @JsProperty
    MapOptions view(View view);

}
