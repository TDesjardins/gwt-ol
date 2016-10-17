package ol.interaction; 
 
import jsinterop.annotations.JsProperty; 
import jsinterop.annotations.JsType; 
import ol.Collection; 
import ol.Feature; 
import ol.event.Event; 
 
/** 
 * Events emitted by ol.interaction.Modify instances are instances of this type.
 * 
 * @author guadanlini
 */ 
@JsType(isNative = true) 
public interface ModifyEvent extends Event { 
 
  /** 
   * The features being modified. 
   * 
   * @return {@link ol.Feature} 
   */ 
  @JsProperty 
  Collection<Feature> getFeatures(); 
 
} 