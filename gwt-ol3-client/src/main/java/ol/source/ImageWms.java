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

import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.proj.Projection;

/**
 * @author Tino Desjardins
 */
@JsType(isNative = true, name = "ImageWMS")
public class ImageWms extends Image {

    public ImageWms(ImageWmsOptions imageWMSOptions) {}

    public native String getFeatureInfoUrl(Coordinate coordinate, double resolution, Projection projection,
            WmsFeatureInfoParams params);

    public native void setImageLoadFunction(ImageLoadFunction imageLoadFunction);

    public native ImageLoadFunction getImageLoadFunction();

    public native String getUrl();

    public native void setUrl(String url);

    public native ImageWmsParams getParams();

    public native void updateParams(ImageWmsParams params);

}
