package ol.source;

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public class ImageWMS extends Image {
    
    public ImageWMS(ImageWMSOptions imageWMSOptions) {}

    public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
            WMSFeatureInfoParams params);

    public native void setImageLoadFunction(ImageLoadFunction imageLoadFunction);

    public native ImageLoadFunction getImageLoadFunction();

    public native String getUrl();

    public native void setUrl(String url);

    public native ImageWMSParams getParams();

    public native void updateParams(ImageWMSParams params);

}
