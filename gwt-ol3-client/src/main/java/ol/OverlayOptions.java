/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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
package ol;

import elemental2.dom.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * {@link Overlay} options.
 * @author sbaumhekel
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OverlayOptions implements Options {

    /**
     * If set to true the map is panned when calling setPosition, so that the
     * overlay is entirely visible in the current viewport. The default is
     * false.
     * @param autoPan
     *            auto pan?
     */
    @JsProperty
    public native void setAutoPan(boolean autoPan);

    /**
     * The margin (in pixels) between the overlay and the borders of the map
     * when autopanning. The default is 20.
     * @param autoPanMargin
     *            auto pan margin
     */
    @JsProperty
    public native void setAutoPanMargin(int autoPanMargin);

    /**
     * The overlay element.
     * @param element
     *            element
     */
    @JsProperty
    public native void setElement(Element element);

    /**
     * Set the overlay id. The overlay id can be used with the
     * ol.Map#getOverlayById method.
     * @param id
     *            id
     */
    @JsProperty
    public native void setId(String id);

    /**
     * Whether the overlay is inserted first in the overlay container, or
     * appended. Default is true. If the overlay is placed in the same container
     * as that of the controls (see the stopEvent option) you will probably set
     * insertFirst to true so the overlay is displayed below the controls.
     * @param insertFirst
     *            insert first?
     */
    @JsProperty
    public native void setInsertFirst(boolean insertFirst);

    /**
     * Offsets in pixels used when positioning the overlay. The first element in
     * the array is the horizontal offset. A positive value shifts the overlay
     * right. The second element in the array is the vertical offset. A positive
     * value shifts the overlay down. Default is [0, 0].
     * @param offset
     *            offset
     */
    @JsProperty
    public native void setOffset(Pixel offset);

    /**
     * The overlay position in map projection.
     * @param position
     *            position
     */
    @JsProperty
    public native void setPosition(Coordinate position);

    /**
     * Defines how the overlay is actually positioned with respect to its
     * position property. Possible values are 'bottom-left', 'bottom-center',
     * 'bottom-right', 'center-left', 'center-center', 'center-right',
     * 'top-left', 'top-center', and 'top-right'. Default is 'top-left'.
     * @param positioning
     *            positioning
     */
    @JsProperty
    public native void setPositioning(String positioning);

    /**
     * Whether event propagation to the map viewport should be stopped. Default
     * is true. If true the overlay is placed in the same container as that of
     * the controls (CSS class name ol-overlaycontainer-stopevent); if false it
     * is placed in the container with CSS class name ol-overlaycontainer.
     * @param stopEvent
     *            stop event propagation to the map viewport?
     */
    @JsProperty
    public native void setStopEvent(boolean stopEvent);

}
