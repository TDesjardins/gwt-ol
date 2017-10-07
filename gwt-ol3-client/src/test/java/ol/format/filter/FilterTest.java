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
package ol.format.filter;

import ol.Coordinate;
import ol.Extent;
import ol.GwtOL3BaseTestCase;
import ol.geom.Circle;

/**
 * Test for filters.
 *
 * @author Tino Desjardins
 *
 */
public class FilterTest extends GwtOL3BaseTestCase {

    public void testAnd() {
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            EqualTo equalTo2 = new EqualTo("attribute2", 1);

            And andFilter = new And(equalTo, equalTo2);
            assertNotNull(andFilter);

            assertNotNull(Filter.and(equalTo, equalTo2));

        });
    }

    public void testBbox() {
        injectUrlAndTest(() -> {

            Bbox bboxFilter = new Bbox("geometryName", Extent.create(0, 0, 1, 1), "EPSG:3857");
            assertNotNull(bboxFilter);

            bboxFilter.setExtent(Extent.create(1, 1, 2, 2));
            bboxFilter.setGeometryName("geometryAttribute");
            bboxFilter.setSrsName("EPSG:4326");

            Filter.bbox("geometryName", Extent.create(0, 0, 100, 100), "EPSG:3857");
        });
    }

    public void testDuring() {
        injectUrlAndTest(() -> {

            During during = new During("dateAttribute", "2017-07-10", "2017-07-12");
            assertNotNull(during);

        });
    }

    public void testEqualTo() {        
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            assertNotNull(equalTo);

            EqualTo equalToInteger = new EqualTo("attribute", 1);
            assertNotNull(equalToInteger);

            EqualTo equalToDouble = new EqualTo("attribute", 1.25);
            assertNotNull(equalToDouble);

        });
    }

    public void testGreaterThan() {
        injectUrlAndTest(() -> {

            GreaterThan greaterThan = new GreaterThan("attribute", 5);
            assertNotNull(greaterThan);

        });
    }

    public void testGreaterThanOrEqualTo() {
        injectUrlAndTest(() -> {

            GreaterThanOrEqualTo greaterThanOrEqualTo = new GreaterThanOrEqualTo("attribute", 5);
            assertNotNull(greaterThanOrEqualTo);

        });
    }

    public void testIntersects() {
        injectUrlAndTest(() -> {

            Intersects intersectsFilter = new Intersects("geometryName", new Circle(Coordinate.create(0, 0), 2), "EPSG:3857");
            assertNotNull(intersectsFilter);

        });
    }

    public void testIsBetween() {
        injectUrlAndTest(() -> {

            IsBetween isBetween = new IsBetween("attribute", 5, 10);
            assertNotNull(isBetween);

        });
    }

    public void testIsLike() {
        injectUrlAndTest(() -> {

            IsLike isLike = new IsLike("attribute", "value");
            assertNotNull(isLike);

        });
    }

    public void testIsNull() {
        injectUrlAndTest(() -> {

            IsNull isNull = new IsNull("attribute");
            assertNotNull(isNull);

        });
    }

    public void testLessThan() {
        injectUrlAndTest(() -> {

            LessThan lessThan = new LessThan("attribute", 5);
            assertNotNull(lessThan);

        });
    }

    public void testLessThanOrEqualTo() {
        injectUrlAndTest(() -> {

            LessThanOrEqualTo lessThanOrEqualTo = new LessThanOrEqualTo("attribute", 5);
            assertNotNull(lessThanOrEqualTo);

        });
    }

    public void testNot() {
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            
            Not not = new Not(equalTo);
            assertNotNull(not);

        });
    }

    public void testNotEqualTo() {
        injectUrlAndTest(() -> {

            NotEqualTo notEqualTo = new NotEqualTo("attribute", "value");
            assertNotNull(notEqualTo);

            NotEqualTo notEqualToInteger = new NotEqualTo("attribute", 1);
            assertNotNull(notEqualToInteger);

            NotEqualTo notEqualToDouble = new NotEqualTo("attribute", 1.25);
            assertNotNull(notEqualToDouble);

        });
    }

    public void testOr() {
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            EqualTo equalTo2 = new EqualTo("attribute2", 1);

            Or orFilter = new Or(equalTo, equalTo2);
            assertNotNull(orFilter);

        });
    }

    public void testWithin() {
        injectUrlAndTest(() -> {

            Within within = new Within("geometryName", new Circle(Coordinate.create(5, 5), 5), "EPSG:3857");
            assertNotNull(within);

        });
    }

}
