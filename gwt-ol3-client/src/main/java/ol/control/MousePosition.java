/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.control;

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.GenericFunction;
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
    public native void setCoordinateFormat(GenericFunction<Coordinate, String> coordinateFormat);

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
