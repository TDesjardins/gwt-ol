package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Feature;
import ol.event.Event;
import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface DragAndDropEvent extends Event {

    @JsProperty
    public Feature[] getFeatures();
    
    @JsProperty
    public Projection getProjection();
    
}

