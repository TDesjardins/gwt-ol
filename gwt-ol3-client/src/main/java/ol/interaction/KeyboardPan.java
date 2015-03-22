package ol.interaction;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class KeyboardPan implements Interaction {

    public static native KeyboardPan newInstance() /*-{
        return new $wnd.ol.interaction.KeyboardPan();
    }-*/;
    
}

