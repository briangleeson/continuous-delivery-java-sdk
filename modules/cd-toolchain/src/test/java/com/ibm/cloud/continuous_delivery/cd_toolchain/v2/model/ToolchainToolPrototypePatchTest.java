/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model;

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainToolPrototypePatch model.
 */
public class ToolchainToolPrototypePatchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainToolPrototypePatch() throws Throwable {
    ToolchainToolPrototypePatch toolchainToolPrototypePatchModel = new ToolchainToolPrototypePatch.Builder()
      .name("MyTool")
      .toolTypeId("draservicebroker")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(toolchainToolPrototypePatchModel.name(), "MyTool");
    assertEquals(toolchainToolPrototypePatchModel.toolTypeId(), "draservicebroker");
    assertEquals(toolchainToolPrototypePatchModel.parameters(), java.util.Collections.singletonMap("anyKey", "anyValue"));

    String json = TestUtilities.serialize(toolchainToolPrototypePatchModel);

    ToolchainToolPrototypePatch toolchainToolPrototypePatchModelNew = TestUtilities.deserialize(json, ToolchainToolPrototypePatch.class);
    assertTrue(toolchainToolPrototypePatchModelNew instanceof ToolchainToolPrototypePatch);
    assertEquals(toolchainToolPrototypePatchModelNew.name(), "MyTool");
    assertEquals(toolchainToolPrototypePatchModelNew.toolTypeId(), "draservicebroker");
    assertEquals(toolchainToolPrototypePatchModelNew.parameters().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
  }
  @Test
  public void testToolchainToolPrototypePatchAsPatch() throws Throwable {
    ToolchainToolPrototypePatch toolchainToolPrototypePatchModel = new ToolchainToolPrototypePatch.Builder()
      .name("MyTool")
      .toolTypeId("draservicebroker")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    Map<String, Object> mergePatch = toolchainToolPrototypePatchModel.asPatch();

    assertEquals(mergePatch.get("name"), "MyTool");
    assertEquals(mergePatch.get("tool_type_id"), "draservicebroker");
    assertTrue(mergePatch.containsKey("parameters"));
  }

}