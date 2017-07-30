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

import elemental2.dom.Node;

import javax.annotation.Nullable;

/**
 * Feature format for reading and writing data in the WFS format. By default, supports
 * WFS version 1.1.0. You can pass a GML format as option if you want to read a WFS
 * that contains GML2 (WFS 1.0.0). Also see ol.format.GMLBase which is used by this format.
 *
 * @author Tino Desjardins
 *
 * @see https://openlayers.org/en/latest/apidoc/ol.format.WFS.html
 */
@JsType(isNative = true, name = "WFS")
public class Wfs extends XmlFeature {

	public Wfs() {}
    
    public Wfs(Options wfsFormatOptions) {}


	/**
	 * Read all features from a WFS FeatureCollection.
	 * 
	 * @param source Document | Node | Object | string
	 * @param readOptions Read options.
	 * @return [] {@link Feature}
	 */
	public native Feature[] readFeatures(java.lang.Object source, @Nullable Options readOptions);

	/**
	 * Read the projection from a WFS source.
	 * 
	 * @param source Document | Node | Object | string
	 * @return {@link Geometry}
	 */
	public native Projection readProjection(java.lang.Object source);
	
	/**
	 * Encode format as WFS GetFeature and return the Node.
	 * 
	 * @param writeOptions write options
	 * @return root node
	 */
	public native Node writeGetFeature(WfsWriteFeatureOptions writeOptions);
	
	/**
	 * Encode format as WFS Transaction and return the Node.
	 * 
	 * @param inserts The features to insert.
	 * @param updates The features to update.
	 * @param deletes The features to delete.
	 * @param writeOptions write options
	 * @return root node
	 */
	public native Node writeTransaction(Feature[] inserts, Feature[] updates, Feature[] deletes, Options writeOptions);
    
}
