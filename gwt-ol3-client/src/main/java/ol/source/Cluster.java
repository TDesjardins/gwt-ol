/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Layer source to cluster vector data. Works out of the box with point geometries. For other
 * geometry types, or if not all geometries should be considered for clustering, a custom
 * geometryFunction can be defined.
 * 
 * @author mazlixek
 */
@JsType(isNative = true)
public class Cluster extends Vector {

  public Cluster() {}

  public Cluster(ClusterOptions clusterOptions) {}

  /**
   * Get the distance in pixels between clusters.
   */
  public native int getDistance();

  /**
   * Set the distance in pixels between clusters.
   * 
   * @param distance The distance in pixels.
   */
  @JsProperty
  public native void setDistance(int distance);

  /**
   * Get a reference to the wrapped source.
   */
  public native Vector getSource();
}
