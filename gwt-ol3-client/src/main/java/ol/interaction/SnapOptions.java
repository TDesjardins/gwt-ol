/*
 * Copyright (c) 2001-2016 Territorium Online Srl. All Rights Reserved.
 *
 * This file contains Original Code and/or Modifications of Original Code as
 * defined in and that are subject to the Territorium Online License Version
 * 1.0. You may not use this file except in compliance with the License. Please
 * obtain a copy of the License at http://www.tol.info/license/ and read it
 * before using this file.
 *
 * The Original Code and all software distributed under the License are
 * distributed on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS
 * OR IMPLIED, AND TERRITORIUM ONLINE HEREBY DISCLAIMS ALL SUCH WARRANTIES,
 * INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY, FITNESS FOR
 * A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT. Please see the
 * License for the specific language governing rights and limitations under the
 * License.
 */
package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;
import ol.Options;
import ol.source.Vector;

/**
 * The {@link SnapOptions} class
 */
@JsType(isNative = true)
public interface SnapOptions extends Options {

	/**
	 * Snap to these features. Either this option or source should be provided.
	 * 
	 * @param features
	 */
	@JsProperty
	public void setFeatures(Collection<Feature> features);

	/**
	 * Snap to edges. Default is true.
	 * 
	 * @param edge
	 */
	@JsProperty
	public void setEdge(boolean edge);

	/**
	 * Snap to vertices. Default is true.
	 * 
	 * @param vertex
	 */
	@JsProperty
	public void setVertex(boolean vertex);

	/**
	 * Pixel tolerance for considering the pointer close enough to a segment or
	 * vertex for snapping. Default is 10 pixels.
	 * 
	 * @param tolerance
	 */
	@JsProperty
	public void setPixelTolerance(double tolerance);

	/**
	 * Snap to features from this source. Either this option or features should
	 * be provided
	 * 
	 * @param source
	 */
	@JsProperty
	public void setSource(Vector source);

}
