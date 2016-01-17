package ol.interaction;

import jsinterop.annotations.JsType;

import ol.Feature;

/**
 * Interaction for drawing feature geometries.
 * 
 * @author sbaumhekel
 *
 */
@JsType(isNative = true)
public class Draw extends Interaction {
    
    /**
     * Extend an existing geometry by adding additional points. This only works
     * on features with `LineString` geometries, where the interaction will
     * extend lines by adding points to the end of the coordinates array.
     * 
     * @param feature
     *            Feature to be extended.
     */
    public native void extend(Feature feature);

    /**
     * Stop drawing and add the sketch feature to the target layer. The
     * {@link ol.interaction.DrawEventType.DRAWEND} event is dispatched before
     * inserting the feature.
     * 
     * @api
     */
    public native void finishDrawing();

    /**
     * Remove last point of the feature currently being drawn.
     */
    public native void removeLastPoint();
    
}
