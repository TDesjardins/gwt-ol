package ol.source;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 *  Source for data from ArcGIS Rest services providing single, untiled images.
 *
 * @author Peter Zanetti
 */
@JsType(isNative = true)
public class ImageArcGISRest extends Image {

	public ImageArcGISRest(ImageArcGISRestOptions options) {}

	@JsMethod
	public native ImageLoadFunction getImageLoadFunction();
}
