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
package ol.format;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.format.filter.Filter;

/**
 * The {@link WfsWriteFeatureOptions} class represents the options for
 * writing GetFeature-Requests.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WfsWriteFeatureOptions implements Options {

    /**
     * 
     * @param featureNS
     */
	@JsProperty(name = "featureNS")
	public native void setFeatureNS(String featureNS);

	/**
     * 
     * @param featurePrefix
     */
    @JsProperty
    public native void setFeaturePrefix(String featurePrefix);
    
    /**
     * 
     * @param featureTypes
     */
    @JsProperty
    public native void setFeatureTypes(String[] featureTypes);
    
    @JsProperty
    public native void setFilter(Filter filter);
    
    @JsProperty
    public native void setGeometryName(String geometryName);
    
    @JsProperty
    public native void setOutputFormat(String outputFormat);
    
    /**
     * 
     * @param srsName
     */
    @JsProperty
    public native void setSrsName(String srsName);
    
}