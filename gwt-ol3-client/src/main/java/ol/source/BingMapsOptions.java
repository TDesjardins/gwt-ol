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
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Bing Maps options.
 *
 * @author gkresic
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.source.BingMaps.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BingMapsOptions extends TileImageOptions {

	/**
	 * @param hidpi If <code>true</code> hidpi tiles will be requested. Default is <code>false</code>.
	 */
	@JsProperty
	public native void setHidpi(boolean hidpi);

	@JsProperty
	public native boolean getHidpi();

	/**
	 * @param culture Culture code. Default is <code>en-us</code>.
	 */
	@JsProperty
	public native void setCulture(String culture);
	
	@JsProperty
	public native String getCulture();
	
	/**
	 * @param key Bing Maps API key. Get yours at <a href="http://www.bingmapsportal.com/">http://www.bingmapsportal.com/</a>. Required.
	 */
	@JsProperty
	public native void setKey(String key);
	
	@JsProperty
	public native String getKey();
	
	/**
	 * @param imagerySet Type of imagery. Required.
	 * Use <code>"Aerial"</code> for default aerial images.
	 * See <a href="https://msdn.microsoft.com/en-us/library/ff701716.aspx">https://msdn.microsoft.com/en-us/library/ff701716.aspx</a> for other possible values.
	 */
	@JsProperty
	public native void setImagerySet(String imagerySet);

	@JsProperty
	public native String getImagerySet();

	/**
	 * @param maxZoom Max zoom. Default is what's advertized by the BingMaps service (21 currently).
	 */
	@JsProperty
	public native void setMaxZoom(int maxZoom);

	@JsProperty
	public native int getMaxZoom();

}
