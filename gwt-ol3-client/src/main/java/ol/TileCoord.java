/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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
 *
 * An array of three numbers representing the location of a tile in a tile grid.
 * The order is z, x, and y. z is the zoom level.
 *
 */
public class TileCoord extends JavaScriptObject {

	@Deprecated
	protected TileCoord() {
	}

	/**
	 * Clones this object.
	 *
	 * @return {ol.TileCoord} clone
	 */
	public final native Size cloneObject() /*-{
											return this.slice(0);
											}-*/;

	/**
	 * Gets the zoom.
	 *
	 * @return zoom
	 */
	public final native int getZ() /*-{
										return this[0];
										}-*/;

	/**
	 * Gets the x.
	 *
	 * @return x
	 */
	public final native int getX() /*-{
										return this[1];
										}-*/;

	/**
	 * Gets the y.
	 *
	 * @return y
	 */
	public final native int getY() /*-{
										return this[2];
										}-*/;

}
