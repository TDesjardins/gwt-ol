package ol.layer;

import jsinterop.annotations.JsType;

import ol.Object;

/**
 * Base for OL3-Layers.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public abstract class Base extends Object {

    public native float getBrightness();

    public native float getContrast();

    public native float getMaxResolution();

    public native float getMinResolution();

    public native float getOpacity();

    public native float getSaturation();

    public native boolean getVisible();

    /**
     * Return the Z-index of the layer, which is used to order layers before
     * rendering. The default Z-index is 0.
     *
     * @return {number} The Z-index of the layer.
     */
    public native int getZIndex();

    public native void setBrightness(float brightness);

    public native void setContrast(float contrast);

    public native void setMaxResolution(float maxResolution);

    public native void setMinResolution(float minResolution);

    public native void setOpacity(float opacity);

    public native void setSaturation(float saturation);

    public native void setVisible(boolean visible);

    /**
     * Set Z-index of the layer, which is used to order layers before rendering.
     * The default Z-index is 0.
     *
     * @param zindex
     *            The z-index of the layer.
     */
    public native void setZIndex(int zindex);

}
