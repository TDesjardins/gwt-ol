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
package ol.format.filter;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import ol.Extent;

/**
 * Abstract class; normally only used for creating subclasses 
 * and not instantiated in apps. Base class for WFS GetFeature filters.
 * 
 * @author hmgn
 *
 */
@JsType(isNative = true)
public abstract class Filter {
	
    @JsOverlay
    private static final String PACKAGE_FILTER = "ol.format.filter";

    /**
     * @deprecated This constructor is only to satisfy JsInterop.
     * Do not use this!
     */
    public Filter() {}
    
	/**
	 * Constructor
	 * 
	 * @param tagName The XML tag name for this filter.
	 */
	public Filter(String tagName) {}
	
	@JsMethod(name = "and", namespace = PACKAGE_FILTER)
    public static native And and(Filter... conditions);

	@JsMethod(name = "bbox", namespace = PACKAGE_FILTER)
    public static native And bbox(String geometryName, Extent extent);

	@JsMethod(name = "bbox", namespace = PACKAGE_FILTER)
    public static native And bbox(String geometryName, Extent extent, String srsName);
}
