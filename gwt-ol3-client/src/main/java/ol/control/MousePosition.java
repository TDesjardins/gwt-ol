package ol.control;

import jsinterop.annotations.JsType;

import ol.proj.Projection;

/**
 * A control to show the 2D coordinates of the mouse cursor. By default, these
 * are in the view projection, but can be in any supported projection. By
 * default the control is shown in the top right corner of the map, but this can
 * be changed by using the css selector `.ol-mouse-position`.
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true)
public interface MousePosition extends Control {

    /**
     * Return the projection that is used to report the mouse position.
     * 
     * @return {ol.proj.Projection|undefined} The projection to report mouse
     *         position in.
     * @observable
     * @api stable
     */
    Projection getProjection();

    /**
     * Set the projection that is used to report the mouse position.
     * 
     * @param projection
     *            The projection to report mouse position in.
     * @observable
     * @api stable
     */
    void setProjection(Projection projection);

}
