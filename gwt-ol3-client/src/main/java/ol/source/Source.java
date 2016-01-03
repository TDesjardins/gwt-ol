package ol.source;

import jsinterop.annotations.JsType;

import ol.Attribution;
import ol.proj.Projection;

/**
 * Abstract base class; normally only used for creating subclasses and not
 * instantiated in apps. Base class for {@link ol.layer.Layer} sources.
 *
 * A generic `change` event is triggered when the state of the source changes.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Source extends ol.Object {
    /**
     * Get the attributions of the source.
     * 
     * @return {Array.<ol.Attribution>} Attributions.
     */
    Attribution[] getAttributions();

    /**
     * Get the projection of the source.
     * 
     * @return {ol.proj.Projection} Projection.
     */
    Projection getProjection();

    /**
     * @return {Array.<number>|undefined} Resolutions.
     */
    double[] getResolutions();

    /**
     * Get the state of the source: one of 'undefined', 'loading', 'ready' or
     * 'error'.
     * 
     * @return {ol.source.State} State.
     */
    String getState();

    /**
     * Set the attributions of the source.
     * 
     * @param attributions
     *            Attributions.
     */
    void setAttributions(Attribution[] attributions);

    /**
     * Set the projection of the source.
     * 
     * @param projection
     *            Projection.
     */
    void setProjection(Projection projection);
}
