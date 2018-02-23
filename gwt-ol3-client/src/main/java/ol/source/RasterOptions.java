/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.source;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import ol.RasterOperation;

/**
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RasterOptions extends SourceOptions {

    @JsProperty
    public native void setSources(Source[] sources);

    @JsOverlay
    public final void setSource(Source source) {
        setSources(new Source[] { source });
    }

    @JsProperty
    public native Source[] getSources();

    @JsProperty
    public native void setOperation(RasterOperation<?> operation);

    @JsProperty
    public native RasterOperation<?> getOperation();

    @JsOverlay
    public final void disableWorkerSupport() {
        setThreads(0);
    }

    @JsProperty
    native void setThreads(int number);

    @JsProperty
    native int getThreads();

    @JsProperty(name = "operationType")
    public native String getOperationTypeString();

    @JsProperty(name = "operationType")
    public native void setOperationTypeString(String operationType);

    @JsOverlay
    public final RasterOperationType getOperationType() {
        return RasterOperationType.fromString(getOperationTypeString());
    }

    @JsOverlay
    public final void setOperationType(RasterOperationType operationType) {
        setOperationTypeString(operationType.getValue());
    }

}
