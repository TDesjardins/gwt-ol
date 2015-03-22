package ol.interaction;

import com.google.gwt.core.client.js.JsType;

/**
 * 
 * @author Tino Desjardins
 *
 */
@JsType
public abstract class DragAndDrop implements Interaction {
    
    public static native DragAndDrop newInstance() /*-{
        return new $wnd.ol.interaction.DragAndDrop();
    }-*/;
    
}

