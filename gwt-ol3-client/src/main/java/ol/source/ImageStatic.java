package ol.source;

import jsinterop.annotations.JsType;

import ol.control.Attribution;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class ImageStatic extends Image {
    
    public ImageStatic() {}
    
    public ImageStatic(ImageStaticOptions imageStaticOptions) {}
    
    public native void setAttributions (Attribution[] attributions);
            
}

