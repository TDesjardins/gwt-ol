package ol.style;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Options;
import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface StrokeOptions extends Options {

    /**
     * Set the stroke color.
     *
     * @param color {@link Color}
     */
    @JsProperty
    public void setColor(Color color);

    /**
     * Set the stroke width.
     *
     * @param width width
     */
    @JsProperty
    public void setWidth(int width);

    /**
     * Set the Line cap style: butt, round, or square. Default is round.
     *
     * @param lineCap
     *            lineCap
     */
    @JsProperty
    public void setLineCap(String lineCap);

    /**
     * Set the Line join style: bevel, round, or miter. Default is round.
     *
     * @param lineJoin
     *           lineJoin
     */
    @JsProperty
    public void setLineJoin(String lineJoin);

    /**
     * Set the Line dash pattern. Default is undefined (no dash).
     *
     * @param lineDash
     *           int[]
     */
    @JsProperty
    public void setLineDash(int[] lineDash);

    /**
     * Set the Miter limit. Default is 10.
     *
     * @param miterLimit
     *           int
     */
    @JsProperty
    public void setMiterLimit(int miterLimit);

}
