package ol.interaction;

import com.google.gwt.core.client.js.JsType;

import ol.Feature;

/**
 * Interaction for drawing feature geometries.
 * 
 * @author sbaumhekel
 *
 */
@JsType(prototype = "ol.interaction.Draw")
public interface Draw extends Interaction {
    /**
     * Extend an existing geometry by adding additional points. This only works
     * on features with `LineString` geometries, where the interaction will
     * extend lines by adding points to the end of the coordinates array.
     * 
     * @param feature
     *            Feature to be extended.
     */
    void extend(Feature feature);

    /**
     * Stop drawing and add the sketch feature to the target layer. The
     * {@link ol.interaction.DrawEventType.DRAWEND} event is dispatched before
     * inserting the feature.
     * 
     * @api
     */
    void finishDrawing();

    /**
     * Remove last point of the feature currently being drawn.
     */
    void removeLastPoint();
}
