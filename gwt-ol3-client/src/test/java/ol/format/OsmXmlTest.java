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
package ol.format;

import ol.Feature;
import ol.GwtOL3BaseTestCase;

/**
 *
 * @author mazlixek
 *
 */
public class OsmXmlTest extends GwtOL3BaseTestCase {

	private OsmXml osmXmlFormat;
    private String osmXmlString = "<?xml version='1.0' encoding='UTF-8'?><osm version='0.6' generator='CGImap 0.5.8 (4084 thorn-03.openstreetmap.org)' copyright='OpenStreetMap and contributors' attribution='http://www.openstreetmap.org/copyright' license='http://opendatacommons.org/licenses/odbl/1-0/'><bounds minlat='50.8919300' minlon='12.3964900' maxlat='50.8920400' maxlon='12.3966500'/>      <node id='1113060015' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:42:43Z' user='br01005' uid='396517' lat='50.8921008' lon='12.3965259'/>      <node id='1113060411' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:42:52Z' user='br01005' uid='396517' lat='50.8919987' lon='12.3965422'/>      <node id='1113060835' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:43:02Z' user='br01005' uid='396517' lat='50.8920533' lon='12.3965494'/>      <node id='1113061147' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:43:12Z' user='br01005' uid='396517' lat='50.8919691' lon='12.3963921'/>      <node id='1113061701' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:43:24Z' user='br01005' uid='396517' lat='50.8920472' lon='12.3965182'/>      <node id='1113061936' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:43:33Z' user='br01005' uid='396517' lat='50.8920650' lon='12.3963445'/>      <node id='2176933186' visible='true' version='1' changeset='15183012' timestamp='2013-02-27T10:13:34Z' user='br01005' uid='396517' lat='50.8919619' lon='12.3965529'/>      <node id='2176933187' visible='true' version='1' changeset='15183012' timestamp='2013-02-27T10:13:34Z' user='br01005' uid='396517' lat='50.8919746' lon='12.3966147'/>      <node id='2176933188' visible='true' version='1' changeset='15183012' timestamp='2013-02-27T10:13:34Z' user='br01005' uid='396517' lat='50.8919868' lon='12.3965400'/>      <node id='2176933189' visible='true' version='1' changeset='15183012' timestamp='2013-02-27T10:13:34Z' user='br01005' uid='396517' lat='50.8919995' lon='12.3966018'/>      <way id='96068819' visible='true' version='1' changeset='7040922' timestamp='2011-01-21T14:43:54Z' user='br01005' uid='396517'>       <nd ref='1113061936'/>       <nd ref='1113060015'/>       <nd ref='1113060835'/>       <nd ref='1113061701'/>       <nd ref='1113060411'/>       <nd ref='1113061147'/>       <nd ref='1113061936'/>       <tag k='building' v='yes'/>      </way>      <way id='207438886' visible='true' version='1' changeset='15183012' timestamp='2013-02-27T10:13:40Z' user='br01005' uid='396517'>       <nd ref='2176933188'/>       <nd ref='2176933189'/>       <nd ref='2176933187'/>       <nd ref='2176933186'/>       <nd ref='2176933188'/>       <tag k='building' v='yes'/>      </way>    </osm>";
	
	@Override
	protected void gwtSetUp() throws Exception {
	    injectUrlAndTest(() -> osmXmlFormat = new OsmXml());
	}
    
    public void testReadFeatureCollectionFromOsmXml() {        
        injectUrlAndTest(() -> {
            Feature[] features = osmXmlFormat.readFeatures(osmXmlString, null);
            assertNotNull(features);
            assertTrue(features.length > 0);
        });
    }
}
