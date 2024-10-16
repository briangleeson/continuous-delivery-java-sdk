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

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainPrototypePatch model.
 */
public class ToolchainPrototypePatchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainPrototypePatch() throws Throwable {
    ToolchainPrototypePatch toolchainPrototypePatchModel = new ToolchainPrototypePatch.Builder()
      .name("newToolchainName")
      .description("New toolchain description")
      .build();
    assertEquals(toolchainPrototypePatchModel.name(), "newToolchainName");
    assertEquals(toolchainPrototypePatchModel.description(), "New toolchain description");

    String json = TestUtilities.serialize(toolchainPrototypePatchModel);

    ToolchainPrototypePatch toolchainPrototypePatchModelNew = TestUtilities.deserialize(json, ToolchainPrototypePatch.class);
    assertTrue(toolchainPrototypePatchModelNew instanceof ToolchainPrototypePatch);
    assertEquals(toolchainPrototypePatchModelNew.name(), "newToolchainName");
    assertEquals(toolchainPrototypePatchModelNew.description(), "New toolchain description");
  }
  @Test
  public void testToolchainPrototypePatchAsPatch() throws Throwable {
    ToolchainPrototypePatch toolchainPrototypePatchModel = new ToolchainPrototypePatch.Builder()
      .name("newToolchainName")
      .description("New toolchain description")
      .build();

    Map<String, Object> mergePatch = toolchainPrototypePatchModel.asPatch();

    assertEquals(mergePatch.get("name"), "newToolchainName");
    assertEquals(mergePatch.get("description"), "New toolchain description");
  }

}