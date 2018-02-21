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

/**
 * Raster operation type. Supported values are 'pixel' and 'image'.
 *
 * @author Daniel Eggert (daniel.eggert@gfz-potsdam.de)
 *
 */
public enum RasterOperationType {

    /**
     * operations will be called with an array of pixels from input sources
     */
    PIXEL,

    /**
     * operations will be called with an array of ImageData objects from input sources
     */
    IMAGE;

    /**
     * @return value of this type as a lower case string
     */
    public String getValue() {
        return this.toString().toLowerCase();
    }

    /**
     * Returns the enum value for the given string value.
     * 
     * @param type
     * @return
     */
    public static RasterOperationType fromString(String type) {
        for (RasterOperationType roType : values()) {
            if (roType.getValue().equals(type)) {
                return roType;
            }
        }

        return null;
    }

}
