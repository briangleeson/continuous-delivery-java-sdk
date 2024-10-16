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
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainToolPost model.
 */
public class ToolchainToolPostTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainToolPost() throws Throwable {
    ToolchainToolPost toolchainToolPostModel = new ToolchainToolPost();
    assertNull(toolchainToolPostModel.getId());
    assertNull(toolchainToolPostModel.getResourceGroupId());
    assertNull(toolchainToolPostModel.getCrn());
    assertNull(toolchainToolPostModel.getToolTypeId());
    assertNull(toolchainToolPostModel.getToolchainId());
    assertNull(toolchainToolPostModel.getToolchainCrn());
    assertNull(toolchainToolPostModel.getHref());
    assertNull(toolchainToolPostModel.getReferent());
    assertNull(toolchainToolPostModel.getName());
    assertNull(toolchainToolPostModel.getUpdatedAt());
    assertNull(toolchainToolPostModel.getParameters());
    assertNull(toolchainToolPostModel.getState());
  }
}