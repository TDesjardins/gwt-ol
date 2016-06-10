/**
 * $$Id$$
 *
 * @author mribeiro
 * @date 08/06/16 10:57
 * <p/>
 * Copyright (C) 2016 MRibeiro
 * marco.lob@gmail.com
 * <p/>
 * All rights reserved.
 */
package ol;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Object parameter of the {@link ol.Collection} features event listener.
 *
 * e.g.
 * Select select = ...
 * select.getFeatures().on("<event_name>"), function (SelectObjectEvent){...});
 */
@JsType(isNative = true)
public interface FeatureObjectEvent extends ObjectEvent{

    /**
     * The name feature involved in the event.
     *
     * @return {@link Feature}
     *          feature.
     */
    @JsProperty
    Feature getElement();
}