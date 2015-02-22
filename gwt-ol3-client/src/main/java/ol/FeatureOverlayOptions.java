package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.style.Style;

/**
 * Options for {@link FeatureOverlay}.
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class FeatureOverlayOptions {
    
    public static native FeatureOverlayOptions newInstance() /*-{
        return {};
    }-*/;
    
    @JsProperty
    public abstract void setFeatures(Collection<Feature> features);
    
    @JsProperty
    public abstract void setMap(Map map);
    
    @JsProperty
    public abstract void setStyle(Style style);
    
}

