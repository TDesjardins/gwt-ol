/*******************************************************************************
 * Copyright 2014, 2020 gwt-ol
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
import ol.proj.Projection;
import ol.tilegrid.TileGrid;

/**
 * Base class for sources providing images divided into a tile grid.
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class TileImage extends UrlTile {

    public native void setRenderReprojectionEdges(boolean render);

    public native void setTileGridForProjection(Projection projection, TileGrid tilegrid);

}
