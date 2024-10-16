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

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolModelReferent;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainToolPatch model.
 */
public class ToolchainToolPatchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainToolPatch() throws Throwable {
    ToolchainToolPatch toolchainToolPatchModel = new ToolchainToolPatch();
    assertNull(toolchainToolPatchModel.getId());
    assertNull(toolchainToolPatchModel.getResourceGroupId());
    assertNull(toolchainToolPatchModel.getCrn());
    assertNull(toolchainToolPatchModel.getToolTypeId());
    assertNull(toolchainToolPatchModel.getToolchainId());
    assertNull(toolchainToolPatchModel.getToolchainCrn());
    assertNull(toolchainToolPatchModel.getHref());
    assertNull(toolchainToolPatchModel.getReferent());
    assertNull(toolchainToolPatchModel.getName());
    assertNull(toolchainToolPatchModel.getUpdatedAt());
    assertNull(toolchainToolPatchModel.getParameters());
    assertNull(toolchainToolPatchModel.getState());
  }
}