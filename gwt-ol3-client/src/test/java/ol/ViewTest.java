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
package ol;

import ol.View;
import ol.ViewOptions;
import ol.Object.Event;
import ol.event.EventListener;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;

/**
 *
 * @author Tino Desjardins
 *
 */
public class ViewTest extends GwtOLBaseTestCase {

    private boolean centerChanged = false;
    private boolean resolutionChanged = false;
    private boolean rotationChanged = false;

    public void testView() {

        injectUrlAndTest(() -> {

            View view = getTestView();

            assertNotNull(view);
            assertTrue(view instanceof Object);

            Extent calculatedExtent = view.calculateExtent(new Size(100, 100));
            assertNotNull(calculatedExtent);

            view.fit(calculatedExtent);

            view.cancelAnimations();

            view.centerOn(new Coordinate(660000, 190000), new Size(100, 100), new Pixel(25, 25));

            assertFalse(view.getAnimating());

            assertFalse(view.getInteracting());

            view.getResolutionForExtent(calculatedExtent);

            view.getResolutionForExtent(calculatedExtent, new Size(100, 100));

            view.getResolutionForZoom(5);

            view.adjustRotation(1f);
            view.adjustRotation(1f, new Coordinate(660000, 190000));

            view.adjustZoom(1f);
            view.adjustZoom(1f, new Coordinate(660000, 190000));

        });

    }

    public void testViewEvents() {

        injectUrlAndTest(() -> {

            View view = getTestView();

            view.addCenterChangeListener(new EventListener<Object.Event>() {

                @Override
                public void onEvent(Event event) {
                    centerChanged = true;
                }
            });

            view.addResolutionChangeListener(new EventListener<Object.Event>() {

                @Override
                public void onEvent(Event event) {
                    resolutionChanged = true;

                }
            });

            view.addRotationChangeListener(new EventListener<Object.Event>() {

                @Override
                public void onEvent(Event event) {
                    rotationChanged = true;

                }
            });

            assertFalse(this.centerChanged);
            assertFalse(this.resolutionChanged);
            assertFalse(this.rotationChanged);

            view.setCenter(new Coordinate(660000, 190001));

            assertTrue(this.centerChanged);
            assertFalse(this.resolutionChanged);
            assertFalse(this.rotationChanged);

            view.setZoom(8);

            assertTrue(this.resolutionChanged);
            assertFalse(this.rotationChanged);

            view.setRotation(Math.PI);

            assertTrue(this.rotationChanged);
        });

    }

    private View getTestView() {

        ProjectionOptions projectionOptions = new ProjectionOptions();
        projectionOptions.setCode("EPSG:21781");
        projectionOptions.setUnits("m");

        assertNotNull(projectionOptions);

        Projection projection = new Projection(projectionOptions);

        assertNotNull(projection);

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.setProjection(projection);
        View view = new View(viewOptions);

        Coordinate centerCoordinate = new Coordinate(660000, 190000);

        view.setCenter(centerCoordinate);
        view.setZoom(9);
        return view;
    }

}
