package ol.control;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public interface Attribution extends Control {

    void setCollapsed(boolean collapsed);

    void setCollapsible(boolean collapsible);

}
