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
package ol.animation;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Coordinate;
import ol.Options;
import ol.easing.EasingOperation;

/**
 * Options for animation. See {@link ol.View#animate(AnimationOptions...)}
 * 
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class AnimationOptions implements Options {

    @JsProperty
    public native void setAnchor(Coordinate anchor);
    
    @JsProperty
    public native void setCenter(Coordinate center);
    
    @JsProperty
    public native void setDuration(int duration);
    
    @JsProperty
    public native void setResolution(double resolution);
    
    @JsProperty
    public native void setRotation(double rotation);
    
    @JsProperty
    public native void setZoom(double zoom);

    @JsProperty
    public native void setEasing(EasingOperation easing);
}
