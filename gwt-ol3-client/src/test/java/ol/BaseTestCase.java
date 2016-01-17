package ol;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class BaseTestCase extends GWTTestCase {

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
    
    public interface TestWithInjection {
        
        public void test();
        
    }

}
