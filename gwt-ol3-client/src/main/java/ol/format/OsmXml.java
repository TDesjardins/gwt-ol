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

import jsinterop.annotations.JsType;
import ol.proj.Projection;
import ol.Feature;
import ol.Options;

import javax.annotation.Nullable;
/**
 * OSM-XML format
 *
 * @author mazlixek
 *
 * @see http://openlayers.org/en/latest/apidoc/ol.format.OSMXML.html
 */
@JsType(isNative = true, name = "OSMXML")
public class OsmXml extends XmlFeature {

	public OsmXml() {}
    
    public OsmXml(Options osmXmlOptions) {}


	/**
	 * Read all features from a OpenStreetMaps.org OSMXML source. Works with both Feature and FeatureCollection sources.
	 * @param source Document | Node | Object | string
	 * @param readOptions Read options.
	 * @return [] {@link Feature}
	 */
	public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

	/**
	 * Read the projection from an OSM source.
	 * @param source Document | Node | Object | string
	 * @return {@link Geometry}
	 */
	public native Projection readProjection(java.lang.Object source);
    
}
