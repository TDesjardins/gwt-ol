/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
package ol;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author <a href="mailto:peter.zanetti@tol.bz.it">Peter Zanetti</a>.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LogoOptions implements Options {

    /**
     * {@link #setHref}
     *
     * @param href Link url for the logo. Will be followed when the logo is clicked
     */
    @JsProperty
    public native void setHref(String href);

    @JsProperty
    public native String getHref();

    /**
     * {@link #setSrc}
     *
     * @param src Image src for the logo.
     */
    @JsProperty
    public native void setSrc(String src);

    @JsProperty
    public native String getSrc();

}
