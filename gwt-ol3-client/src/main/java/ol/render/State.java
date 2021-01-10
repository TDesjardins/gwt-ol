/*******************************************************************************
 * Copyright 2014, 2021 gwt-ol
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
package ol.render;

import elemental2.dom.CanvasRenderingContext2D;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.geom.SimpleGeometryCoordinates;

/**
 * Render state.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface State {

    /**
     * @return Canvas context that the layer is being rendered to.
     */
    @JsProperty
    public CanvasRenderingContext2D getContext();

    @JsProperty
    public ol.Feature getFeature();

    @JsProperty
    public SimpleGeometryCoordinates getGeometry();

    /**
     * @return Pixel ratio used by the layer renderer.
     */
    @JsProperty
    public double getPixelRatio();

    /**
     * @return Resolution that the render batch was created and optimized for.
     * This is not the view's resolution that is being rendered.
     */
    @JsProperty
    public double getResolution();

    /**
     * @return Rotation of the rendered layer in radians.
     */
    @JsProperty
    public double getRotation();

}
