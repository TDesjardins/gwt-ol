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

import java.util.Objects;

/**
 * Available server types: `'carmentaserver'`, `'geoserver'`, `'mapserver'`, `'qgis'`. These are servers that have vendor parameters beyond the WMS
 * specification that OpenLayers can make use of.
 * 
 * @author Peter Zanetti
 */
public enum WmsServerType {

    CARMENTA_SERVER("carmentaserver"),
    GEOSERVER("geoserver"),
    MAPSERVER("mapserver"),
    QGIS("qgis");

    private final String value;

    /**
     * Constructs a(n) {@link WmsServerType} object.
     *
     * @param value
     */
    WmsServerType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static final WmsServerType getInstance(String value) {

        for (WmsServerType wmsServerType : WmsServerType.class.getEnumConstants()) {
            if (Objects.equals(wmsServerType.getValue(), value)) {
                return wmsServerType;
            }
        }

        return null;

    }

}
