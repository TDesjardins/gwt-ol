package ol.source;

import jsinterop.annotations.JsFunction;
import ol.Image;

/**
 * A function that takes an ol.Image for the image and a {string} for the src as arguments. It is supposed to make it so the underlying image ol.Image#getImage
 * is assigned the content specified by the src. If not specified, the default is
 * 
 * @author Peter Zanetti
 */
@JsFunction
@FunctionalInterface
public interface ImageLoadFunction {

    public void loadImage(Image image, String src);
}
