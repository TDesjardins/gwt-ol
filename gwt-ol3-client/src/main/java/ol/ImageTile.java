package ol;

import com.google.gwt.dom.client.ImageElement;

import jsinterop.annotations.JsType;

/**
 *
 * ImageTile.
 *
 */
@JsType(isNative = true)
public class ImageTile extends Tile {

	public native ImageElement getImage();
}
