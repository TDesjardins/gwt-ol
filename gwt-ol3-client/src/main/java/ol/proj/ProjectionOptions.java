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
package ol.proj;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

import ol.Options;
import ol.Extent;
import jsinterop.annotations.JsType;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ProjectionOptions implements Options {
    
    @JsProperty
    public native void setCode(String code);
    
    @JsProperty
    public native void setUnits(String units);

    @JsProperty
    public native void setGlobal(boolean global);
    
    @JsProperty
    public native void setExtent(Extent extent);
    
}
