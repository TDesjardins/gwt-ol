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
package ol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An array with two elements, representing a pixel. The first element is the
 * x-coordinate, the second the y-coordinate of the pixel.
 *
 * @author sbaumhekel
 */
public class Pixel extends JavaScriptObject {

    @Deprecated
    protected Pixel() {
    }

    /**
     * Clones this object.
     *
     * @return {ol.Pixel} clone
     */
    public final native Pixel cloneObject() /*-{
    	return this.slice(0);
    }-*/;

    /**
     * Gets the X-coordinate.
     *
     * @return X-coordinate
     */
    public final native int getX() /*-{
    	return this[0];
    }-*/;

    /**
     * Gets the Y-coordinate.
     *
     * @return Y-coordinate
     */
    public final native int getY() /*-{
    	return this[1];
    }-*/;

}
