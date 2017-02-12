package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Size;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageWMSParams {

    @JsOverlay
    public static String DELIMITER = ",";

    @JsProperty(name = "LAYERS")
    public native void setLayers(String layers);

    @JsOverlay
    public final void setLayers(String... layerNames) {
        setLayers(String.join(ImageWMSParams.DELIMITER, layerNames));
    }

    @JsProperty(name = "LAYERS")
    public native String getLayers();

    @JsProperty(name = "WIDTH")
    public native void setWidth(int width);

    @JsProperty(name = "HEIGHT")
    public native void setHeight(int height);

    @JsOverlay
    public final void setSize(Size size) {
        setWidth(size.getWidth());
        setHeight(size.getHeight());
    }

    @JsProperty(name = "VERSION")
    public native void setVersion(String version);

}
