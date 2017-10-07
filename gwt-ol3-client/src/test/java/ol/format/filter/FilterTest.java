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

            During during2 = Filter.during("dateAttribute", "2017-07-10", "2017-07-12");
            assertTrue(during2 instanceof During);

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

            EqualTo equalTo2 = Filter.equalTo("attribute", "value");
            assertTrue(equalTo2 instanceof EqualTo);

            EqualTo equalToInteger2 = Filter.equalTo("attribute", 1);
            assertTrue(equalToInteger2 instanceof EqualTo);

            EqualTo equalToDouble2 = Filter.equalTo("attribute", 1.25);
            assertTrue(equalToDouble2 instanceof EqualTo);

        });
    }

    public void testGreaterThan() {
        injectUrlAndTest(() -> {

            GreaterThan greaterThan = new GreaterThan("attribute", 5);
            assertNotNull(greaterThan);

            GreaterThan greaterThan2 = Filter.greaterThan("attribute", 5);
            assertTrue(greaterThan2 instanceof GreaterThan);

        });
    }

    public void testGreaterThanOrEqualTo() {
        injectUrlAndTest(() -> {

            GreaterThanOrEqualTo greaterThanOrEqualTo = new GreaterThanOrEqualTo("attribute", 5);
            assertNotNull(greaterThanOrEqualTo);

            GreaterThanOrEqualTo greaterThanOrEqualTo2 = Filter.greaterThanOrEqualTo("attribute", 5);
            assertTrue(greaterThanOrEqualTo2 instanceof GreaterThanOrEqualTo);

        });
    }

    public void testIntersects() {
        injectUrlAndTest(() -> {

            Intersects intersectsFilter = new Intersects("geometryName", new Circle(Coordinate.create(0, 0), 2), "EPSG:3857");
            assertNotNull(intersectsFilter);

            Intersects intersectsFilter2 = Filter.intersects("geometryName", new Circle(Coordinate.create(0, 0), 2), "EPSG:3857");
            assertTrue(intersectsFilter2 instanceof Intersects);

        });
    }

    public void testIsBetween() {
        injectUrlAndTest(() -> {

            IsBetween isBetween = new IsBetween("attribute", 5, 10);
            assertNotNull(isBetween);

            IsBetween isBetween2 = Filter.between("attribute", 5, 10);
            assertTrue(isBetween2 instanceof IsBetween);
 
        });
    }

    public void testIsLike() {
        injectUrlAndTest(() -> {

            IsLike isLike = new IsLike("attribute", "value");
            assertNotNull(isLike);

            IsLike isLike2 = Filter.like("attribute", "value");
            assertTrue(isLike2 instanceof IsLike);
        });
    }

    public void testIsNull() {
        injectUrlAndTest(() -> {

            IsNull isNull = new IsNull("attribute");
            assertNotNull(isNull);

            IsNull isNull2 = Filter.isNull("attribute");
            assertTrue(isNull2 instanceof IsNull);
        });
    }

    public void testLessThan() {
        injectUrlAndTest(() -> {

            LessThan lessThan = new LessThan("attribute", 5);
            assertNotNull(lessThan);

            LessThan lessThan2 = Filter.lessThan("attribute", 5);
            assertTrue(lessThan2 instanceof LessThan);

        });
    }

    public void testLessThanOrEqualTo() {
        injectUrlAndTest(() -> {

            LessThanOrEqualTo lessThanOrEqualTo = new LessThanOrEqualTo("attribute", 5);
            assertNotNull(lessThanOrEqualTo);

            LessThanOrEqualTo lessThanOrEqualTo2 = Filter.lessThanOrEqualTo("attribute", 5);
            assertTrue(lessThanOrEqualTo2 instanceof LessThanOrEqualTo);
        });
    }

    public void testNot() {
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            
            Not not = new Not(equalTo);
            assertNotNull(not);

            Not not2 = Filter.not(equalTo);
            assertTrue(not2 instanceof Not);
 
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

            NotEqualTo notEqualTo2 = Filter.notEqualTo("attribute", "value");
            assertTrue(notEqualTo2 instanceof NotEqualTo);

            NotEqualTo notEqualToInteger2 = Filter.notEqualTo("attribute", 1);
            assertTrue(notEqualToInteger2 instanceof NotEqualTo);

            NotEqualTo notEqualToDouble2 = Filter.notEqualTo("attribute", 1.25);
            assertTrue(notEqualToDouble2 instanceof NotEqualTo);

        });
    }

    public void testOr() {
        injectUrlAndTest(() -> {

            EqualTo equalTo = new EqualTo("attribute", "value");
            EqualTo equalTo2 = new EqualTo("attribute2", 1);

            Or orFilter = new Or(equalTo, equalTo2);
            assertNotNull(orFilter);

            Or orFilter2 = Filter.or(equalTo, equalTo2);
            assertTrue(orFilter2 instanceof Or);
        });
    }

    public void testWithin() {
        injectUrlAndTest(() -> {

            Within within = new Within("geometryName", new Circle(Coordinate.create(5, 5), 5), "EPSG:3857");
            assertNotNull(within);

            Within within2 = Filter.within("geometryName", new Circle(Coordinate.create(5, 5), 5));
            assertTrue(within2 instanceof Within);

            Within within3 = Filter.within("geometryName", new Circle(Coordinate.create(5, 5), 5), "EPSG:3857");
            assertTrue(within3 instanceof Within);

        });
    }

}
