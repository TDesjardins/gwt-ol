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
package com.github.tdesjardins.ol3.demo.client.example;

import com.github.desjardins.elemental.XMLSerializer;
import com.github.tdesjardins.ol3.demo.client.utils.DemoUtils;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import elemental2.dom.Node;
import ol.Coordinate;
import ol.Feature;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.format.GeoJson;
import ol.format.Wfs;
import ol.format.WfsWriteFeatureOptions;
import ol.format.filter.IsLike;
import ol.layer.VectorLayerOptions;
import ol.source.Vector;

/**
 * WFS example with filter.
 *
 * @author Tino Desjardins
 *
 */
public class WfsExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show()
     */
    @Override
    public void show(String exampleId) {

        // create a vector layer
        Vector vectorSource = new Vector();
        VectorLayerOptions vectorLayerOptions = new VectorLayerOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector wfsLayer = new ol.layer.Vector(vectorLayerOptions);

        // create a view
        View view = new View();

        Coordinate centerCoordinate = new Coordinate(-8908887.277395891, 5381918.072437216);
        view.setCenter(centerCoordinate);
        view.setZoom(12);
        view.setMaxZoom(19);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(DemoUtils.createOsmLayer());
        map.addLayer(wfsLayer);

        Wfs wfs = new Wfs();
        WfsWriteFeatureOptions wfsWriteFeatureOptions = new WfsWriteFeatureOptions();

        String[] featureTypes = {"water_areas"};
        wfsWriteFeatureOptions.setSrsName("EPSG:3857");
        wfsWriteFeatureOptions.setFeaturePrefix("osm");
        wfsWriteFeatureOptions.setFeatureNS("http://openstreemap.org");
        wfsWriteFeatureOptions.setFeatureTypes(featureTypes);

        // set a filter
        wfsWriteFeatureOptions.setFilter(new IsLike("name", "Mississippi*"));
        wfsWriteFeatureOptions.setOutputFormat("application/json");

        // create WFS-XML node
        Node wfsNode = wfs.writeGetFeature(wfsWriteFeatureOptions);

        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, "https://ahocevar.com/geoserver/wfs");
        requestBuilder.setRequestData(new XMLSerializer().serializeToString(wfsNode));
        requestBuilder.setCallback(new RequestCallback() {

            @Override
            public void onResponseReceived(com.google.gwt.http.client.Request request, Response response) {

                GeoJson geoJson = new GeoJson();
                Feature[] features = geoJson.readFeatures(response.getText());

                vectorSource.addFeatures(features);
                map.getView().fit(vectorSource.getExtent());
            }

            @Override
            public void onError(com.google.gwt.http.client.Request request, Throwable exception) {
                Window.alert(exception.getMessage());
            }

        });

        try {
            requestBuilder.send();
        } catch (RequestException e) {
            Window.alert(e.getMessage());
        }

    }

}

