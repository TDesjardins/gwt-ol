/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *******************************************************************************/
package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.format.Feature;

/**
 * Vector source options.
 *
 * @author mazlixek
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClusterOptions extends SourceOptions {

  /**
   * Minimum distance in pixels between clusters. Default is 20.
   * 
   * @return number | undefined
   */
  @JsProperty
  public native int getDistance();

  /**
   * Minimum distance in pixels between clusters. Default is 20.
   */
  @JsProperty
  public native void setDistance(int distance);

  /**
   * Format.
   * 
   * @return {@link ol.format.Feature}
   */
  @JsProperty
  public native Feature getFormat();

  /**
   * Format.
   */
  @JsProperty
  public native void setFormat(Feature format);

  /**
   * {@link ol.source.Vector}
   */
  @JsProperty
  public native Vector getSource();

  /**
   * {@link ol.source.Vector}
   */
  @JsProperty
  public native void setSource(Vector source);

  /**
   * Wrap the world horizontally. Default is true. For vector editing across the -180° and 180°
   * meridians to work properly, this should be set to false. The resulting geometry coordinates
   * will then exceed the world bounds.
   * 
   * @param WrapX. Default is true
   */
  @JsProperty
  public native void setWrapX(boolean wrapX);


}
