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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import ol.Pixel;;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Render {

    @JsOverlay
    private static final String PACKAGE_RENDER = "ol.render";

    /**
     * Gets the pixel of the event's canvas context from the map viewport's CSS pixel.
     *
     * @param renderEvent Render event.
     * @param pixel CSS pixel relative to the top-left corner of the map viewport.
     * @return Pixel on the event's canvas context.
     */
    @JsMethod(name = "getRenderPixel", namespace = PACKAGE_RENDER)
    public static native Pixel getRenderPixel(Event renderEvent, Pixel pixel);

    /**
     * Gets a vector context for drawing to the event's canvas.
     *
     * @param renderEvent Render event.
     * @return Vector context.
     */
    @JsMethod(name = "getVectorContext", namespace = PACKAGE_RENDER)
    public static native VectorContext getVectorContext(Event renderEvent);

}
