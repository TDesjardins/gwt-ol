/*******************************************************************************
 * Copyright 2014, 2015 gwt-ol3
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
package ol.color;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A color represented as a short array [red, green, blue, alpha]. red, green,
 * and blue should be integers in the range 0..255 inclusive. alpha should be a
 * float in the range 0..1 inclusive.
 *
 * @author sbaumhekel
 */
public class Color extends JavaScriptObject {

    @Deprecated
    protected Color() {
    }

    /**
     * Gets the alpha value.
     *
     * @return alpha value (0-1)
     */
    public final native float getAlpha() /*-{
		return this[3];
    }-*/;

    /**
     * Gets the blue value.
     *
     * @return blue value (0-255)
     */
    public final native int getBlue() /*-{
		return this[2];
    }-*/;

    /**
     * Gets the green value.
     *
     * @return green value (0-255)
     */
    public final native int getGreen() /*-{
		return this[1];
    }-*/;

    /**
     * Gets the red value.
     *
     * @return red value (0-255)
     */
    public final native int getRed() /*-{
		return this[0];
    }-*/;

}
