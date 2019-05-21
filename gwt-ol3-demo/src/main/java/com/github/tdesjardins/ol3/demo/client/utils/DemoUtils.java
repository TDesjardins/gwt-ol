/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package com.github.tdesjardins.ol3.demo.client.utils;

import com.github.tdesjardins.ol3.demo.client.constants.DemoConstants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;

import jsinterop.base.Js;
import ol.Collection;
import ol.Coordinate;
import ol.OLFactory;
import ol.OLUtil;
import ol.control.Control;
import ol.control.ControlOptions;
import ol.control.FullScreen;
import ol.control.MousePosition;
import ol.control.ZoomSlider;
import ol.control.ZoomToExtent;
import ol.geom.Polygon;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.source.Osm;
import ol.source.XyzOptions;

/**
 *
 * @author Tino Desjardins
 *
 */
public final class DemoUtils {

    private DemoUtils() {
        throw new AssertionError();
    }

    /**
     * Creates some default controls and adds it to the collection.
     *
     * @param controls collection with controls
     */
    public static void addDefaultControls(final Collection<Control> controls) {

        controls.push(new FullScreen());
        controls.push(new ZoomSlider());
        MousePosition mousePosition = new MousePosition();
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        controls.push(mousePosition);
        controls.push(new ZoomToExtent());

    }

    /**
     * Create a MapBox logo.
     *
     * @return MapBox logo
     */
    public static Control createMapboxLogo() {

        ControlOptions controlOptions = new ControlOptions();

        LinkElement mapboxLogo = Document.get().createLinkElement();
        mapboxLogo.setHref("https://mapbox.com/about/maps");
        mapboxLogo.setTarget("_blank");

        mapboxLogo.getStyle().setPosition(Position.ABSOLUTE);
        mapboxLogo.getStyle().setLeft(2, Unit.PX);
        mapboxLogo.getStyle().setBottom(5, Unit.PX);
        mapboxLogo.getStyle().setWidth(126, Unit.PX);
        mapboxLogo.getStyle().setHeight(40, Unit.PX);
        mapboxLogo.getStyle().setDisplay(Display.BLOCK);
        mapboxLogo.getStyle().setOverflow(Overflow.HIDDEN);

        mapboxLogo.getStyle().setBackgroundImage("url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIIAAAAoCAMAAAAFWtJHAAAAwFBMVEUAAAAAAAAAAABtbW0AAAAAAAAAAAAAAAAAAAAAAAClpaUAAADp6ekAAAD5+fna2toAAAAMDAzv7+/Nzc0AAAA2Njb8/Pz9/f3T09MAAAAAAAD7+/sAAAArKyuxsbH39/fs7OwbGxuIiIjz8/N8fHyenp7u7u74+PgAAAC8vLxWVlbx8fF1dXXl5eVcXFyUlJTQ0NDFxcVCQkLAwMC4uLj19fXo6OjW1tarq6ve3t77+/vi4uL6+vrKysrNzc3///8w7gSSAAAAP3RSTlMAOQNdPSYBPywKexLLGPCxNEHXnzFL+v2nGwf1IEiE6dBFad9jd9PuLo1V2mDDV3Cjl06SiuXIq4C3973ym6BQMVUPAAAEXElEQVR4Ae2WCVP6OBiH05L0l1IqrVbkKHJ54I0oHn+PfP9vtUle0z/YdhbH2XVnd58ZnRJIeHiPJOx//mH4vQSAN+8FjAhFxgHIaPvJeZ99hxwEElon5iAQbj85Y98g8ODwjEOMAvGFyeE3FEKgodTBqj0BJGN9DhyNd5Ta3ean9QEopfaA+LsKhnEKRExqg4FSP6Og7oEkAjBWnxSCgBX4xF+kcLoPcOBQrSv0e5kH7s1j37jECQieCTPiFGxL5VHw2zQWCeeJiPt6kjRQw0XSkIdVChf67xGa4alSnZlT6HEQ8CK9ANbhvXUF9xlDkBfTuHDWScgC9+z5FQpPI12TlwC6+sV7ixR8CUMKiwjm2GQeOQWHMGuHGdbnObJAwCEqFJpNU5H6uaPUaEIKiQfg+PHk1+u4OwW9PlWW2ctbA4BHCtp+cNK+H8Jos4gDmC5ar4Nx9waaG/2B13NgDqS7+vm2RgEtEws82P+kwIHhs/pgkQKcFIhfd7CogtGNjYMHTLpurD0ERbYFw4JaD3GlQuNAL/JEsSAF4HqlCnaHACk4WhOn4OgCkMD5hSpYNYDJTD8Y46n+jsE1kPhVCuR6QBXhFK7MUOu9O6b1SWF3b+/9ZVWMGOlu93E8UDaAhgc7bfH+0DHqKXCkHzoNDFfU+zxiVQrUC9QXTuHYtKpN59OA3IxCG4b7jh6ZFuVockaNTW09mkJzOaPU49a6mE9cAchZpQJNpUWcwgV9r6FJswsFKrITp2B5pMBMdnS0z2HZNy2+BNKxSZxZfglkrFYBJxQnpzA5sN/HheR2aFQoZBLAi149dQoyAYYjW0hHlHguBAdMcR0DuDZ5omevX6+AI8qcU7ikKT3GBHCnXwydgmCC0tRwCnGQ2Wp6Be71yNIWfQSkOl9vAI1SBCNWrwC01RROgX7BuT2HI4r7tFAw086p/NwZEdOEa7R1uAFuNmQPuKAEAjYNQ0CyeoUEWHYBnpQVQgpvc0Ph+gsKlAnKg1+vEHsw5LKciLKCAJobiWBzYFGbCKpHqkZZrxBFHEASyFI59vJPCskcwNVGOWZAOqsrR+pKbaNeAMT1CixMEtlnsqopNxUMzVJT3tY35aXZm6a6Y9QhwMN6BUJWbE1lhbMO1WehkO7poO0sK7em9MJGxp1XSbC1gtugzzSLQmGsX7VntJGSwsPZ2d2z3bIPKzdoOp3Wzqt8G4XyMVUoFIxLx1S7+piaHtCvR3FeRVsq0GFdp9C5TbGpcNqsPqyHKxcfd14h21KhuLKUFU4f3osrC7F6uV3WXFnadL7wyAPeKDXw2RoJCO5GY4DouYvb/gepVXheLoewzPseQG9N/vzilrMIjoStE3++zvle4eSurw7XEe76ynI4aq+v7lEyt1x5awiFlFLQbHKIpabnM3eJLym4Szzzc/du7SU+zOXv9UNpECH7IoH/gecURPlN9vdQpeD47yhIFNX0U0QgvID9nENm+yxk/xb+AGAjNfRZuk9qAAAAAElFTkSuQmCC)");

        
        
        controlOptions.setElement(Js.cast(mapboxLogo));

        return new Control(controlOptions);
    }

    /**
     * Creates a test polygon geometry (triangle).
     *
     * @return test polygon geometry (EPSG:3857)
     */
    public static Polygon createTestPolygon() {

        Coordinate[][] coordinates = new Coordinate[1][4];

        Coordinate point1 = new Coordinate(13.36, 52.53);
        Coordinate point2 = new Coordinate(13.36, 52.51);
        Coordinate point3 = new Coordinate(13.37, 52.52);
        Coordinate point4 = new Coordinate(13.36, 52.53);

        coordinates[0][0] = point1;
        coordinates[0][1] = point2;
        coordinates[0][2] = point3;
        coordinates[0][3] = point4;

        Coordinate[][] tranformedCoordinates = new Coordinate[coordinates.length][];

        tranformedCoordinates[0] = OLUtil.transform(coordinates[0], DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);
        return OLFactory.createPolygon(tranformedCoordinates);

    }

    public static Base createOsmLayer() {
        XyzOptions osmSourceOptions = OLFactory.createOptions();

        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);

        return new Tile(osmLayerOptions);
    }

}
