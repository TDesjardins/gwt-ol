package ol.animation;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.Options;

/**
 * Options for animation. See {@link ol.View#animate(AnimationOptions...)}
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AnimationOptions implements Options {

    @JsProperty
    public native void setAnchor(Coordinate anchor);
    
    @JsProperty
    public native void setCenter(Coordinate center);
    
    @JsProperty
    public native void setDuration(int duration);
    
    @JsProperty
    public native void setResolution(double resolution);
    
    @JsProperty
    public native void setRotation(double rotation);
    
    @JsProperty
    public native void setZoom(double zoom);

}
