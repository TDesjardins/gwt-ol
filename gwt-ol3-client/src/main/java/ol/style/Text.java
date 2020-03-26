/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ol.style;

import jsinterop.annotations.JsType;

/**
 *
 * @author Tino Desjardins
 *
 */
@JsType(isNative = true)
public class Text {

    public Text() {}

    public Text(TextOptions textOptions) {}

    /**
     * @return the font name
     */
    public native String getFont();

    /**
     * @param backgroundFill background fill
     */
    public native void setBackgroundFill(Stroke backgroundFill);

    /**
     * @param backgroundStroke background stroke
     */
    public native void setBackgroundStroke(Stroke backgroundStroke);
    
    /**
     * @param fill Fill style
     */
    public native void setFill(Fill fill);

    /**
     * @param font Font
     */
    public native void setFont(String font);

    /**
     * @param maxAngle maximum angle between adjacent characters.
     */
    public native void setMaxAngle(double maxAngle);

    /**
     * Set the text.
     *
     * @param text
     */
    public native void setText(String text);

    /**
     * Clones the Text.
     */
    public native Text clone();

}
