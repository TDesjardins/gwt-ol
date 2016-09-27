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
package ol.format;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Options;
import ol.proj.Projection;

/**
 * The {@link WKTFeatureOptions} class represents the options for reading or
 * writing a feature from or to wkt
 */
@JsType(isNative = true)
public interface WKTFeatureOptions extends Options {

	/**
	 * Projection of the data we are reading. If not provided, the projection will
	 * be derived from the data (where possible) or the defaultDataProjection of
	 * the format is assigned (where set). If the projection can not be derived
	 * from the data and if no defaultDataProjection is set for a format, the
	 * features will not be reprojected.
	 * 
	 * @param projection
	 */
	@JsProperty
	void setDataProjection(Projection projection);

	/**
	 * Projection of the feature geometries created by the format reader. If not
	 * provided, features will be returned in the dataProjection.
	 * 
	 * @param projection
	 */
	@JsProperty
	void setFeatureProjection(Projection projection);

}
