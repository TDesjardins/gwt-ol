package ol.source;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import ol.Attribution;
import ol.LogoOptions;
import ol.Options;
import ol.proj.Projection;

/**
 * Source options.
 *
 * @author Tino Desjardins
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SourceOptions implements Options {

    /**
     * Set the Attributions.
     *
     * @param attributions attributions
     */
    @JsProperty
    public native void setAttributions(Attribution[] attributions);

    @JsProperty
    public native Attribution[] getAttributions();

  	@JsProperty
  	public native void setLogo(LogoOptions logo);

  	@JsProperty
  	public native LogoOptions getLogo();
  	
    /**
     * Set the Projection. Default is EPSG:3857.
     *
     * @param projection projection
     */
    @JsProperty
    public native void setProjection(Projection projection);
    
    @JsProperty
    public native Projection getProjection();
}
