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
 * params for MapGuide-requests.
 * @author tlochmann
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageMapGuideParams {

    /**
     * @param format
     *  MapGuide image format (JPG/PNG/PNG8)
     *
     */
    @JsProperty(name = "FORMAT")
    public native void setFormat(String format);
    
    /**
     * @param hideLayers List of layers to hide.
     */
    @JsProperty(name = "HIDELAYERS")
    public native void setHideLayers(String hideLayers);
    
	/**
     * @param mapDefinition
     * 			MapGuide mapDefinition e.g. "Library://Samples/Sheboygan/Maps/Sheboygan.MapDefinition"
     */
    @JsProperty(name = "MAPDEFINITION")
    public native void setMapDefinition(String mapDefinition);

    /**
     * 
     * @param mapName Name of the map to display.
     */
    @JsProperty(name = "MAPNAME")
    public native void setMapName(String mapName);
    
    @JsProperty(name = "PASSWORD")
    public native void setPassword(String password);
    
    /**
     * @param showLayers List of layers to display.
     */
    @JsProperty(name = "SHOWLAYERS")
    public native void setShowLayers(String showLayers);
    
    @JsProperty(name = "USERNAME")
    public native void setUserName(String userName);
    
    /**
     * @param version
     * 	MapGuide image version
     *
     */
    @JsProperty(name = "VERSION")
    public native void setVersion(String version);

}
