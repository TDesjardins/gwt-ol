/**
 * $$Id$$
 *
 * @author mribeiro
 * @date 07/06/16 17:27
 * <p/>
 * Copyright (C) 2016 MRibeiro
 * marco.lob@gmail.com
 * <p/>
 * All rights reserved.
 */
package ol.interaction;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.Collection;
import ol.Feature;

/**
 *  @author mribeiro
 *          19-05-2016.
 */
@JsType(isNative = true)
public class Select extends Interaction {

    @JsProperty(name = "options")
    public native void setOptions(SelectOptions options);

    public native Collection<Feature> getFeatures();

}