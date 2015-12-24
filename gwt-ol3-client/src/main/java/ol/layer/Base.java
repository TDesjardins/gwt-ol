package ol.layer;

import com.google.gwt.core.client.js.JsType;

import ol.Object;

/**
 * Base for OL3-Layers.
 *
 * @author Tino Desjardins
 *
 */
@JsType(prototype = "ol.layer.Base")
public interface Base extends Object {

    float getBrightness();

    float getContrast();

    float getMaxResolution();

    float getMinResolution();

    float getOpacity();

    float getSaturation();

    boolean getVisible();

    /**
     * Return the Z-index of the layer, which is used to order layers before
     * rendering. The default Z-index is 0.
     * 
     * @return {number} The Z-index of the layer.
     */
    int getZIndex();

    void setBrightness(float brightness);

    void setContrast(float contrast);

    void setMaxResolution(float maxResolution);

    void setMinResolution(float minResolution);

    void setOpacity(float opacity);

    void setSaturation(float saturation);

    void setVisible(boolean visible);

    /**
     * Set Z-index of the layer, which is used to order layers before rendering.
     * The default Z-index is 0.
     * 
     * @param zindex
     *            The z-index of the layer.
     */
    void setZIndex(int zindex);

}
