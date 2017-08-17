/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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

/**
 *
 * @author Tino Desjardins
 *
 */
public class CoordinateTest extends GwtOL3BaseTestCase {

    public void testCoordinate() {

        injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                Coordinate coordinate = Coordinate.create(5.333, 12.25);
                assertNotNull(coordinate);
                assertTrue(coordinate.getDimension() == 2);
                
                assertEquals(coordinate.getX(), 5.333);
                assertEquals(coordinate.getY(), 12.25);
                assertEquals(coordinate.toStringXY(2), "5.33, 12.25");
                
            }
            
        });

    }

}
