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

import ol.GwtOL3BaseTestCase;

/**
 * Test for filters.
 * 
 * @author Tino Desjardins
 *
 */
public class FilterTest extends GwtOL3BaseTestCase {
   
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
    
}
