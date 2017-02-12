package com.github.tdesjardins.ol3.demo.client.example;

/**
 * Provided example types.
 *
 * @author Tino Desjardins
 *
 */
public enum OL3ExampleType {

    AnimationExample(new AnimationExample()),
    ArcGISExample(new ArcGISExample()),
    GeoJSONExample(new GeoJSONExample()),
    GraticuleExample(new GraticuleExample()),
    ImageExample(new StaticImageExample()),
    MapEventsExample(new MapEventsExample()),
    MapGuideExample(new MapGuideExample()),
    MarkerExample(new MarkerExample()),
    MeasureExample(new MeasureExample()),
    OsmExample(new OsmExample()),
    OverlayExample(new OverlayExample()),
    SelectFeatureExample(new SelectFeaturesExample()),
    TileExample(new TileExample()),
    TileWmsExample(new TileWmsExample()),
    WmsExample(new WmsExample()),
    WmtsExample(new WmtsExample()),
    XyzExample(new XyzExample());

    private transient Example example;

    OL3ExampleType(Example example) {
        this.example = example;
    }

    public Example getExample() {
        return this.example;
    }

}

