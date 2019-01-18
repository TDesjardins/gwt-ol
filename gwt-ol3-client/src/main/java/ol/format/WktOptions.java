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
package ol.format;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;

/**
 * WKT options.
 *
 * @author gkresic
 *
 * see https://openlayers.org/en/latest/apidoc/ol.format.WKT.html
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WktOptions implements Options {

	/**
	 * @param splitCollection Whether to split GeometryCollections into multiple features on reading. Default is <code>false</code>.
	 */
	@JsProperty
	public native void setSplitCollection(boolean splitCollection);

	@JsProperty
	public native boolean getSplitCollection();

}
