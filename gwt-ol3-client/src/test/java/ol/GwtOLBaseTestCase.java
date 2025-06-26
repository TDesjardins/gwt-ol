/*******************************************************************************
 * Copyright 2014, 2021 gwt-ol
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

import com.github.desjardins.gwt.junit.client.BaseTestCase;

import java.util.Arrays;

/**
 *
 * @author Tino Desjardins
 *
 */
public abstract class GwtOLBaseTestCase extends BaseTestCase {

    public GwtOLBaseTestCase() {

        super(Arrays.asList(
                "//cdn.jsdelivr.net/npm/ol@10.6.1/dist/ol.min.js"),
                "ol.GwtOLTest",
                10000);
    }

}
