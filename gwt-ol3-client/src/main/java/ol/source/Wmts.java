/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true, name = "WMTS")
public class Wmts extends TileImage {

    public Wmts() {}

    public Wmts(WmtsOptions wmtsOptions) {}

    /**
     * @return image format of the WMTS source.
     */
    public native String getFormat();

    /**
     * @return layer of the WMTS source.
     */
    public native String getLayer();

    /**
     * @return matrix set of the WMTS source.
     */
    public native String getMatrixSet();

    /**
     * @return request encoding, either "KVP" or "REST".
     */
    public native String getRequestEncoding();

    /**
     * @return style of the WMTS source.
     */
    public native String getStyle();

    /**
     * @return version of the WMTS source.
     */
    public native String getVersion();

}
