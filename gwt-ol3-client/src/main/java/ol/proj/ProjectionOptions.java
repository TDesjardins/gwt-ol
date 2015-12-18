package ol.proj;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

import ol.Extent;
import ol.Options;

/**
 * @author Tino Desjardins
 */
@JsType
public interface ProjectionOptions extends Options {

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
    void setExtent(Extent extent);

    @JsProperty
    ProjectionOptions extent(Extent imageExtent);

}
