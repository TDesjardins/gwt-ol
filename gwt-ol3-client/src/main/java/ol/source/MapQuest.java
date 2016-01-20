package ol.source;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class MapQuest extends Xyz {

    public MapQuest(MapQuestOptions mapQuestOptions) {}

    @JsProperty
    public native void setLayer(String layer);

}

