package ol.interaction;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class Modify implements Pointer {

    public static native Modify newInstance() /*-{
        return new $wnd.ol.interaction.Modify();
    }-*/;
    
}

