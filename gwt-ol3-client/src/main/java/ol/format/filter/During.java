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
package ol.format.filter;

import jsinterop.annotations.JsType;

/**
 * Represents a During comparison operator.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class During extends Comparison {

	/**
	 *
	 * @param propertyName Name of the context property to compare.
	 * @param begin The begin date in ISO-8601 format.
	 * @param end The end date in ISO-8601 format.
	 */
	public During(String propertyName, String begin, String end) {
	    super("During", propertyName);
	}

}
