/*******************************************************************************
 * Copyright 2014, 2022 gwt-ol
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
 * WKB options.
 *
 * @author T. Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WkbOptions implements Options {

    /**
     * @param splitCollection Whether to split GeometryCollections into multiple features on reading. Default is <code>false</code>.
     */
    @JsProperty
    public native void setSplitCollection(boolean splitCollection);

    @JsProperty
    public native boolean getSplitCollection();

    /**
     * Use EWKB format for output.
     *
     * @param ewkb
     */
    @JsProperty
    public native void setEwkb(boolean ewkb);

    /**
     * @return use EWKB format for output.
     */
    @JsProperty
    public native boolean getEwkb();

    /**
     * Returns hex string instead of ArrayBuffer for output. This also is used as a hint
     * internally whether it should load contents as text or ArrayBuffer on reading.
     *
     * @param hex
     */
    @JsProperty
    public native void setHex(boolean hex);

    /**
     * @return if hex string is used instead of ArrayBuffer
     */
    @JsProperty
    public native boolean getHex();


    /**
     * Use littleEndian for output.
     *
     * @param littleEndian
     */
    @JsProperty
    public native void setLittleEndian(boolean littleEndian);


    /**
     * 
     * @return if littleEndian is used for output.
     */
    @JsProperty
    public native boolean getLittleEndian();

}
