package ol.control;

import com.google.gwt.core.client.JavaScriptObject;
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
public class MousePosition extends Control {

    public MousePosition() {}
    
    public MousePosition(MousePositionOptions mousePositionOptions) {}
    
	/**
     * 
     * @param coordinateFormat Coordinate format function.
     */
    public native void setCoordinateFormat(JavaScriptObject coordinateFormat);

    /**
     * Return the projection that is used to report the mouse position.
     * 
     * @return {ol.proj.Projection|undefined} The projection to report mouse
     *         position in.
     * @observable
     * @api stable
     */
    public native Projection getProjection();

    /**
     * Set the projection that is used to report the mouse position.
     * 
     * @param projection
     *            The projection to report mouse position in.
     * @observable
     * @api stable
     */
    public native void setProjection(Projection projection);

}
