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
package ol;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public abstract class BaseTestCase extends GWTTestCase {

    private String scriptUrl;
    private String moduleName;
    private int testDelay;
    
    /**
     * 
     * @param scriptUrl URL of external Script
     * @param moduleName module to test
     * @param testDelay max delay for finishing test
     */
    public BaseTestCase(String scriptUrl, String moduleName, int testDelay) {
        this.scriptUrl = scriptUrl;
        this.moduleName = moduleName;
        this.testDelay = testDelay;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }
    
    /**
     * Method for tests which need injected script.
     */
    protected void injectUrlAndTest(final TestWithInjection testWithInjection) {
      
      delayTestFinish(testDelay);

      ScriptInjector.fromUrl(this.scriptUrl).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {

        @Override
        public void onFailure(Exception reason) {
          assertNotNull(reason);
          fail("Injection failed: " + reason.toString());
        }

        @Override
        public void onSuccess(Void result) {
            testWithInjection.test();
            finishTest();
        }

      }).inject();
      
    }
    
    @FunctionalInterface
    public interface TestWithInjection {
        
        public void test();
        
    }

}
