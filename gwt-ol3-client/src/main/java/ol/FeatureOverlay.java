package ol;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class FeatureOverlay {
    
    public static native FeatureOverlay newInstance(FeatureOverlayOptions featureOverlayOptions) /*-{
        return new $wnd.ol.FeatureOverlay(featureOverlayOptions);
    }-*/;
    
}

