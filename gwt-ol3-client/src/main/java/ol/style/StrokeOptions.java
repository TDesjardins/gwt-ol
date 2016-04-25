package ol.style;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Options;
import ol.color.Color;

/**
 * Options for the style {@link Stroke}.
 *
 * @author Tino Desjardins
 *
 */
@JsType
public interface StrokeOptions extends Options {

    /**
     * Set the stroke color.
     *
     * @param color
     *            {@link Color}
     * @return this instance
     */
    @JsProperty
    public StrokeOptions color(Color color);

    /**
     * Set the stroke width.
     *
     * @param width
     *            width
     * @return this instance
     */
    @JsProperty
    public StrokeOptions width(int width);
    
    /**
     * Set the Line cap style: butt, round, or square. Default is round.
     *
     * @param lineCap
     *            lineCap
     * @return this instance
     */
    @JsProperty
    public StrokeOptions lineCap(String lineCap);
    
    /**
     * Set the Line join style: bevel, round, or miter. Default is round.
     *
     * @param lineJoin
     *           lineJoin
     * @return this instance
     */
    @JsProperty
    public StrokeOptions lineJoin(String lineJoin);
    
    /**
     * Set the Line dash pattern. Default is undefined (no dash).
     *
     * @param lineDash
     *           int []
     * @return this instance
     */
    @JsProperty
    public StrokeOptions lineDash(int [] lineDash);
    
    /**
     * Set the Miter limit. Default is 10.
     *
     * @param miterLimit
     *           int
     * @return this instance
     */
    @JsProperty
    public StrokeOptions miterLimit(int  miterLimit);
    

    

}
