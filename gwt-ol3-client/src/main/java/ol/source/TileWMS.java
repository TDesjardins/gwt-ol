/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
/**
 *
 * @author mribeiro
 * @date 07/06/16 18:03
 *
 */
package ol.source;

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;

/**
 *
 */
@JsType(isNative = true)
public class TileWMS extends TileImage {

	/**
	 * Constructs a(n) {@link TileWMS} object.
	 *
	 */
	public TileWMS(TileWMSOptions options) {}

	public native String getGetFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
			WMSFeatureInfoParams params);

	public native TileWMSParams getParams();

	public native void updateParams(TileWMSParams params);

}