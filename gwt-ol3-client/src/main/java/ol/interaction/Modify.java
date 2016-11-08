package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Modify extends Pointer {

    public Modify(ModifyOptions modifyOptions) {}
    
    /** 
     * Events emitted by ol.interaction.Modify instances are instances of this type.
     * 
     * @author guadanlini
     */ 
    @JsType(isNative = true) 
    public interface Event extends ol.event.Event { 
     
      /** 
       * The features being modified. 
       * 
       * @return {@link ol.Feature} 
       */ 
      @JsProperty 
      Collection<Feature> getFeatures(); 
     
    } 
    
}
