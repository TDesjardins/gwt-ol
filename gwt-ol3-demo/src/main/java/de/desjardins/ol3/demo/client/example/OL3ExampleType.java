package de.desjardins.ol3.demo.client.example;

import de.desjardins.ol3.demo.client.example.Example;

/**
 * Provided example types.
 *
 * @author Tino Desjardins
 *
 */
public enum OL3ExampleType {
    
    GraticuleExample(new GraticuleExample()),
    ImageExample(new StaticImageExample()),
    MapGuideExample(new MapGuideExample()),
    MeasureExample(new MeasureExample()),
    OsmExample(new OsmExample()),
    OverlayExamples(new OverlayExample()),
    TileExample(new TileExample()),
    WmsExample(new WmsExample()),
    XyzExample(new XyzExample());

    
    private Example example;
    
    private OL3ExampleType(Example example) {
        this.example = example;
    }
    
    public Example getExample() {
        return this.example;
    }
    
}

