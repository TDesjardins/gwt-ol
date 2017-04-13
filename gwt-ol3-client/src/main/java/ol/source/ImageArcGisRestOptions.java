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
 * Image ArcGIS Rest Options.
 * 
 * @author Peter Zanetti
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageArcGisRestOptions extends SourceOptions {

    @JsProperty
    public native void setCrossOrigin(String crossOrigin);

    @JsProperty
    public native String getCrossOrigin();

    @JsProperty
    public native void setImageLoadFunction(ImageLoadFunction imageLoadFunction);

    @JsProperty
    public native ImageLoadFunction getImageLoadFunction();

    @JsProperty
    public native void setParams(ImageArcGisRestParams params);

    @JsProperty
    public native ImageArcGisRestParams getParams();

    @JsProperty
    public native void setRatio(float ratio);

    @JsProperty
    public native float getRatio();

    @JsProperty
    public native void setResolutions(double[] resolutions);

    @JsProperty
    public native double[] getResolutions();

    @JsProperty
    public native void setUrl(String url);

    @JsProperty
    public native String getUrl();
}
