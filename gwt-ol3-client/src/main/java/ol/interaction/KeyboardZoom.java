package ol.interaction;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class KeyboardZoom implements Interaction {

    public static native KeyboardZoom newInstance() /*-{
        return new $wnd.ol.interaction.KeyboardZoom();
    }-*/;
   
}

