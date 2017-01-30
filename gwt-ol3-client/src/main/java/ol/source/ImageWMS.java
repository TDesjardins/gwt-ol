package ol.source;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;
import tol.j2cl.elem.global.Map;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class ImageWMS extends Image {

	public ImageWMS(ImageWMSOptions imageWMSOptions) {}

	public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
			Map<String> params);

	public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
			WMSFeatureInfoParams params);

	public native void setImageLoadFunction(ImageLoadFunction imageLoadFunction);

	public native ImageLoadFunction getImageLoadFunction();

	public native String getUrl();

	public native void setUrl(String url);

	@JsMethod(name = "getParams")
	public native Map<String> getParams();

	@JsMethod(name = "getParams")
	public native ImageWMSParams getImageWMSParams();

	public native void updateParams(Map<String> params);

	public native void updateParams(ImageWMSParams params);
}
