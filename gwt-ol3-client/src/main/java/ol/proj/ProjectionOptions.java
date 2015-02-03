package ol.proj;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * @author Tino Desjardins
 */
@JsType
public interface ProjectionOptions {

    @JsProperty
    void setCode(String code);

    @JsProperty
    ProjectionOptions code(String code);

    @JsProperty
    void setUnits(String units);

    @JsProperty
    ProjectionOptions units(String units);

    @JsProperty
    void setGlobal(boolean global);

    @JsProperty
    ProjectionOptions global(boolean global);

    @JsProperty
    void setExtent(double[] extent);

    @JsProperty
    ProjectionOptions extent(double[] extent);

}

