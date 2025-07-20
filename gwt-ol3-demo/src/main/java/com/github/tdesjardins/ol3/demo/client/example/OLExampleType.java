/*******************************************************************************
 * Copyright 2014, 2021 gwt-ol
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
package com.github.tdesjardins.ol3.demo.client.example;

/**
 * Provided example types.
 *
 * @author Tino Desjardins
 *
 */
public enum OLExampleType {

    AnimationExample(new AnimationExample()),
    ArcGISExample(new ArcGISExample()),
    BingMapsExample(new BingMapsExample()),
    CanvasGradientExample(new CanvasGradientExample()),
    ClusterExample(new ClusterExample()),
    ConstrainedExample(new ConstrainedViewExample()),
    DrawExample(new DrawExample()),
    GeoJSONExample(new GeoJsonExample()),
    GeolocationExample(new GeolocationExample()),
    GpxExample(new GpxExample()),
    GraticuleExample(new GraticuleExample()),
    HeatmapExample(new HeatmapExample()),
    ImageExample(new StaticImageExample()),
    MapBoxExample(new MapboxExample()),
    MapEventsExample(new MapEventsExample()),
    MapGuideExample(new MapGuideExample()),
    MarkerExample(new MarkerExample()),
    MeasureExample(new MeasureExample()),
    MvtExample(new MvtExample()),
    OsmExample(new OsmExample()),
    OverlayExample(new OverlayExample()),
    RasterExample(new RasterExample()),
    SelectFeaturesExample(new SelectFeaturesExample()),
    TileWmsExample(new TileWmsExample()),
    WfsExample(new WfsExample()),
    WmsExample(new WmsExample()),
    WmtsExample(new WmtsExample()),
    XyzExample(new XyzExample());

    private transient Example example;

    OLExampleType(Example example) {
        this.example = example;
    }

    public Example getExample() {
        return this.example;
    }

}

