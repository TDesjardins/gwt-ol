package ol.source;

import jsinterop.annotations.JsType;
import ol.Extent;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Image extends Source {

	public native ol.Image getImageInternal(Extent extent, double resolution, double pixelRatio, Projection projection);
	
}
