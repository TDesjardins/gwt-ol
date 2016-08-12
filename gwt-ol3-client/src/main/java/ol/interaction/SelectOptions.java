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

    @JsProperty
    void setStyle(GenericFunction styleFunction);

    @JsProperty
    void setLayers(Layer[] layers);

    @JsProperty
    void setRemoveCondition(GenericFunction function);

    @JsProperty
    void setMulti(boolean multi);

    @JsProperty
    void setToogleCondition(GenericFunction function);

}
