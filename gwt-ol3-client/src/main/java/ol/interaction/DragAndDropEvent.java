package ol.interaction;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Feature;
import ol.event.Event;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface DragAndDropEvent extends Event {

    @JsProperty
    public Feature[] getFeatures();
    
    @JsProperty
    public Projection getProjection();
    
}

