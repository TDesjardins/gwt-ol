package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.GenericFunction;
import ol.Options;
import ol.layer.Layer;

/**
 * Options for interaction {@link Select}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface SelectOptions extends Options{

    @JsProperty(name = "style")
    void setStyle(GenericFunction styleFunction);

//    @JsProperty(name = "style")
//    @JsProperty
//    void setStyle(Style selectStyle);

    @JsProperty(name = "layers")
    void setLayers(Layer[] layers);

    @JsProperty(name = "removeCondition")
    void setRemoveCondition(GenericFunction function);

    @JsProperty(name = "multi")
    void setMulti(boolean multi);

    @JsProperty(name = "toggleCondition")
    void setToogleCondition(GenericFunction function);

}
