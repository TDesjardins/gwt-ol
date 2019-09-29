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
package com.github.desjardins.gwt.junit.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Tino Desjardins
 *
 */
public abstract class BaseTestCase extends GWTTestCase {

    private static Set<String> loadedScriptUrls = new HashSet<>();

    private List<String> scriptUrls;
    private String moduleName;
    private int testDelay;

    /**
    *
    * @param scriptUrl URL of external script
    * @param moduleName module to test
    * @param testDelay max delay for finishing test
    */
   public BaseTestCase(String scriptUrl, String moduleName, int testDelay) {
       this(Arrays.asList(scriptUrl), moduleName, testDelay);
   }

    /**
     *
     * @param scriptUrls URLs of external script
     * @param moduleName module to test
     * @param testDelay max delay for finishing test
     */
    public BaseTestCase(List<String> scriptUrls, String moduleName, int testDelay) {
        this.scriptUrls = scriptUrls;
        this.moduleName = moduleName;
        this.testDelay = testDelay;
    }

    @Override
    public String getModuleName() {
        return this.moduleName;
    }

    /**
     * Method for tests which need injected scripts.
     */
    protected void injectUrlAndTest(final TestWithInjection testWithInjection) {

        this.delayTestFinish(this.testDelay);

        this.loadScripts(this.scriptUrls, 0, new Callback<Void, Exception>() {

            @Override
            public void onSuccess(Void result) {
                testWithInjection.test();
                finishTest();
            }

            @Override
            public void onFailure(Exception reason) {
                assertNotNull(reason);
                fail("Injection failed: " + reason.toString());
            }

        });

    }

    /**
     * Load the list of scripts asynchronously only if they are not already loaded.
     *
     * @param urls URLs of the scripts to load
     * @param currentUrlIndex current url index
     * @param callback callback that gets invoked asynchronously
     */
    private void loadScripts(List<String> urls, int currentUrlIndex, Callback<Void, Exception> callback) {

        if (currentUrlIndex < urls.size()) {

            String currentUrl = urls.get(currentUrlIndex);

            if (scriptAlreadyLoaded(currentUrl)) {

                loadScripts(urls, currentUrlIndex + 1, callback);

            } else {

                ScriptInjector.fromUrl(currentUrl).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {

                    @Override
                    public void onFailure(Exception reason) {
                        callback.onFailure(reason);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        loadedScriptUrls.add(currentUrl);
                        loadScripts(urls, currentUrlIndex + 1, callback);

                    }

                }).inject();
            }

        } else {
            callback.onSuccess(null);
        }

    }

    /**
     * Checks if the script was already loaded by this class.
     *
     * @return true if script was already loaded
     */
    private boolean scriptAlreadyLoaded(String scriptUrl) {
        return loadedScriptUrls.contains(scriptUrl);
    }

    @FunctionalInterface
    public interface TestWithInjection {

        public void test();

    }

}
