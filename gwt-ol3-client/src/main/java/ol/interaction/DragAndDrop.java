package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Feature;
import ol.proj.Projection;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class DragAndDrop extends Interaction {

    @JsType(isNative = true)
    public interface Event extends ol.event.Event {

        @JsProperty
        public Feature[] getFeatures();
        
        @JsProperty
        public Projection getProjection();
        
    }
    
}
