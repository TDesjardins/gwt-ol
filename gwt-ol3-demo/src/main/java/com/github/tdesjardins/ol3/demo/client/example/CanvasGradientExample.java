/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
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
/**
 *
 */
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;

import elemental2.dom.CanvasGradient;
import elemental2.dom.CanvasPattern;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.CanvasRenderingContext2D.FillStyleUnionType;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLCanvasElement;
import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.control.ScaleLine;
import ol.geom.Polygon;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;
import ol.style.Fill;
import ol.style.FillOptions;
import ol.style.Stroke;
import ol.style.Style;

/**
 * Example for canvas gradient styling.
 *
 * @author Tino Desjardins
 */
public class CanvasGradientExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        Coordinate centerCoordinate = new Coordinate(13.37, 52.52);
        Coordinate transformedMidPoint = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        // create a polygon
        Polygon polygon = DemoUtils.createTestPolygon();

        // create a feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        // TODO Setter for ID seems to doesn't have an effect in feature options.
        // featureOptions.setId("g1");
        featureOptions.setGeometry(polygon);

        Feature feature = new Feature(featureOptions);
        feature.setId("g1");
        feature.set("name", "triangle");

        Style style = new Style();

        FillOptions fillOptions = new FillOptions();
        fillOptions.setColor(createGradient());

        Fill fill = new Fill(fillOptions);

        style.setFill(fill);
        style.setStroke(new Stroke());

        feature.setStyle(style);

        // create another feature via cloning
        Feature feature2 = feature.clone();
        feature2.setId("g2");
        feature2.getGeometry().rotate(180, transformedMidPoint);

        Style style2 = new Style();

        FillOptions fillOptions2 = new FillOptions();
        fillOptions2.setColor(createPattern());

        Fill fill2 = new Fill(fillOptions2);

        style2.setFill(fill2);
        style2.setStroke(new Stroke());

        feature2.setStyle(style2);

        Collection<Feature> lstFeatures = new Collection<Feature>();
        lstFeatures.push(feature);
        lstFeatures.push(feature2);

        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(lstFeatures);
        Vector vectorSource = new Vector(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = new ol.layer.Vector(vectorLayerOptions);

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        view.setCenter(transformedMidPoint);
        view.setZoom(14);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        Collection<Base> lstLayer = new Collection<Base>();
        lstLayer.push(osmLayer);
        lstLayer.push(vectorLayer);
        mapOptions.setLayers(lstLayer);
        Map map = new Map(mapOptions);

        // add some controls
        map.addControl(new ScaleLine());

        MousePositionOptions mousePositionOptions = OLFactory.createOptions();
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode(DemoConstants.EPSG_4326);
        mousePositionOptions.setProjection(new Projection(projectionOptions));

        MousePosition mousePosition = new MousePosition(mousePositionOptions);
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        map.addControl(mousePosition);

    }

    /**
     * Creates a trashy canvas pattern.
     *
     * @return trashy canvas pattern
     */
    private CanvasPattern createPattern() {

        HTMLCanvasElement canvas = createCanvas();
        CanvasRenderingContext2D context = (CanvasRenderingContext2D) (Object) canvas.getContext("2d");

        double pixelRatio = 1;

        canvas.width = (int)(8 * pixelRatio);
        canvas.height = (int)(8 * pixelRatio);

        // white background;
        context.fillStyle = FillStyleUnionType.of("white");
        context.fillRect(0, 0, canvas.width, canvas.height);

        // outer circle
        context.fillStyle = FillStyleUnionType.of("rgba(102, 0, 102, 0.5)");
        context.beginPath();
        context.arc(4 * pixelRatio, 4 * pixelRatio, 3 * pixelRatio, 0, 2 * Math.PI);
        context.fill();

        // inner circle
        context.fillStyle = FillStyleUnionType.of("rgb(55, 0, 170)");
        context.beginPath();
        context.arc(4 * pixelRatio, 4 * pixelRatio, 1.5 * pixelRatio, 0, 2 * Math.PI);
        context.fill();

        return context.createPattern(canvas, "repeat");

    }

    private CanvasGradient createGradient() {

        CanvasRenderingContext2D context = createContextFromCanvas(createCanvas());

        CanvasGradient canvasGradient = context.createLinearGradient(0, 0, 512, 0);
        canvasGradient.addColorStop(0, "red");
        canvasGradient.addColorStop(1 / 6, "orange");
        canvasGradient.addColorStop(2 / 6, "yellow");
        canvasGradient.addColorStop(3 / 6, "green");
        canvasGradient.addColorStop(4 / 6, "aqua");
        canvasGradient.addColorStop(5 / 6, "blue");
        canvasGradient.addColorStop(1, "purple");

        return canvasGradient;

    }

    private static HTMLCanvasElement createCanvas() {

        return (HTMLCanvasElement)DomGlobal.document.createElement("canvas");

    }

    private static CanvasRenderingContext2D createContextFromCanvas(HTMLCanvasElement canvas) {

        return (CanvasRenderingContext2D) (Object) canvas.getContext("2d");

    }

}
