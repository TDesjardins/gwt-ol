package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Size;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageWMSParams {

	@JsProperty
	public String	LAYERS;

	@JsProperty
	public int		WIDTH;

	@JsProperty
	public int		HEIGHT;

	@JsProperty
	public String	VERSION;
	
	@JsProperty(name = "LAYERS")
	public native void setLayers(String layers);

	@JsProperty(name = "WIDTH")
	public native void setWidth(String width);

	@JsProperty(name = "HEIGHT")
	public native void setHeight(String height);

	@JsOverlay
	public void setSize(Size size) {
		HEIGHT = size.getHeight();
		WIDTH = size.getWidth();
	}
	
    /**
    *
    * @param version
    */
   @JsProperty(name = "VERSION")
   public native void setVersion(String version);	
}
