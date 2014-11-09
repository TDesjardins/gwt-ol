package ol;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.proj.Projection;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public interface ViewOptions {
    
	@JsProperty
	void setProjection(Projection projection);
	
}

