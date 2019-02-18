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
package ol.source;

import ol.GwtOLBaseTestCase;

/**
 * A test case for {@link ol.source.Wmts}.
 */
public class WmtsTest extends GwtOLBaseTestCase {

    private static final String WMST_TEST_MATRIX_SET = "matrixSet1";
    private static final String WMTS_TEST_FORMAT = "image/png";
    private static final String WMTS_TEST_LAYER = "layer1";
    private static final String WMTS_TEST_REQUEST_ENCODING = "KVP";
    private static final String WMTS_TEST_STYLE = "default";
    private static final String WMTS_TEST_VERSION = "1.0.0";

    public void testTileWms() {

        injectUrlAndTest(() -> {

            WmtsOptions wmtsOptions = new WmtsOptions();
            wmtsOptions.setFormat(WMTS_TEST_FORMAT);
            wmtsOptions.setLayer(WMTS_TEST_LAYER);
            wmtsOptions.setMatrixSet(WMST_TEST_MATRIX_SET);
            wmtsOptions.setRequestEncoding(WMTS_TEST_REQUEST_ENCODING);
            wmtsOptions.setStyle(WMTS_TEST_STYLE);
            wmtsOptions.setVersion(WMTS_TEST_VERSION);

            Wmts wmts = new Wmts(wmtsOptions);

            assertNotNull(wmts);

            assertEquals(WMTS_TEST_FORMAT, wmts.getFormat());
            assertEquals(WMTS_TEST_LAYER, wmts.getLayer());
            assertEquals(WMST_TEST_MATRIX_SET, wmts.getMatrixSet());
            assertEquals(WMTS_TEST_REQUEST_ENCODING, wmts.getRequestEncoding());
            assertEquals(WMTS_TEST_STYLE, wmts.getStyle());
            assertEquals(WMTS_TEST_VERSION, wmts.getVersion());

        });

    }

}
