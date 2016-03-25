package ol.source;

import jsinterop.annotations.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class ImageWMS extends Image {
    
    public ImageWMS(ImageWMSOptions imageWMSOptions) {}
    
    public native String getUrl();
    
    public native void setUrl(String url); 
    
}

