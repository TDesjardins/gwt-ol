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
 * An array of numbers representing an extent: `[minx, miny, maxx, maxy]`.
 *
 * @author sbaumhekel
 */
public class Extent extends JavaScriptObject {

    @Deprecated
    protected Extent() {
    }

    /**
     * Constructs an instance.
     *
     * @param minX minimum coordinate X
     * @param minY minimum coordinate Y
     * @param maxX maximum coordinate X
     * @param maxY maximum coordinate Y
     * @return {@link Extent}
     */
    public static native Extent create(double minX, double minY, double maxX, double maxY) /*-{
    	return [ minX, minY, maxX, maxY ];
    }-*/;

    /**
     * Clones this object.
     *
     * @return {ol.Extent} clone
     */
    public final native Extent cloneObject() /*-{
    	return this.slice(0);
    }-*/;

    /**
     * Gets the minimum X coordinate.
     *
     * @return minimum X coordinate.
     */
    public final native double getLowerLeftX() /*-{
    	return this[0];
    }-*/;

    /**
     * Gets the minimum Y coordinate.
     *
     * @return minimum Y coordinate.
     */
    public final native double getLowerLeftY() /*-{
    	return this[1];
    }-*/;

    /**
     * Gets the maximum X coordinate.
     *
     * @return maximum X coordinate.
     */
    public final native double getUpperRightX() /*-{
    	return this[2];
    }-*/;

    /**
     * Gets the maximum Y coordinate.
     *
     * @return maximum Y coordinate.
     */
    public final native double getUpperRightY() /*-{
    	return this[3];
    }-*/;

}
