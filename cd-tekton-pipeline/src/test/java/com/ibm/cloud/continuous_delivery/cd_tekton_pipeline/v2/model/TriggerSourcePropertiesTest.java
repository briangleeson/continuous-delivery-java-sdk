/*
 * (C) Copyright IBM Corp. 2022.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerSourceProperties;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerSourcePropertiesTool;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggerSourceProperties model.
 */
public class TriggerSourcePropertiesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggerSourceProperties() throws Throwable {
    TriggerSourcePropertiesTool triggerSourcePropertiesToolModel = new TriggerSourcePropertiesTool.Builder()
      .id("testString")
      .build();
    assertEquals(triggerSourcePropertiesToolModel.id(), "testString");

    TriggerSourceProperties triggerSourcePropertiesModel = new TriggerSourceProperties.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .tool(triggerSourcePropertiesToolModel)
      .build();
    assertEquals(triggerSourcePropertiesModel.url(), "testString");
    assertEquals(triggerSourcePropertiesModel.branch(), "testString");
    assertEquals(triggerSourcePropertiesModel.pattern(), "testString");
    assertEquals(triggerSourcePropertiesModel.blindConnection(), Boolean.valueOf(true));
    assertEquals(triggerSourcePropertiesModel.hookId(), "testString");
    assertEquals(triggerSourcePropertiesModel.tool(), triggerSourcePropertiesToolModel);

    String json = TestUtilities.serialize(triggerSourcePropertiesModel);

    TriggerSourceProperties triggerSourcePropertiesModelNew = TestUtilities.deserialize(json, TriggerSourceProperties.class);
    assertTrue(triggerSourcePropertiesModelNew instanceof TriggerSourceProperties);
    assertEquals(triggerSourcePropertiesModelNew.url(), "testString");
    assertEquals(triggerSourcePropertiesModelNew.branch(), "testString");
    assertEquals(triggerSourcePropertiesModelNew.pattern(), "testString");
    assertEquals(triggerSourcePropertiesModelNew.blindConnection(), Boolean.valueOf(true));
    assertEquals(triggerSourcePropertiesModelNew.hookId(), "testString");
    assertEquals(triggerSourcePropertiesModelNew.tool().toString(), triggerSourcePropertiesToolModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTriggerSourcePropertiesError() throws Throwable {
    new TriggerSourceProperties.Builder().build();
  }

}