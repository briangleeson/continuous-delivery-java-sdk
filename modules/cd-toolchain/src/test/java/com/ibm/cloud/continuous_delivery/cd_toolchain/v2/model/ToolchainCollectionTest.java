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

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionFirst;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionLast;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionNext;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionPrevious;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainModel;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainCollection model.
 */
public class ToolchainCollectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainCollection() throws Throwable {
    ToolchainCollection toolchainCollectionModel = new ToolchainCollection();
    assertNull(toolchainCollectionModel.getTotalCount());
    assertNull(toolchainCollectionModel.getLimit());
    assertNull(toolchainCollectionModel.getFirst());
    assertNull(toolchainCollectionModel.getPrevious());
    assertNull(toolchainCollectionModel.getNext());
    assertNull(toolchainCollectionModel.getLast());
    assertNull(toolchainCollectionModel.getToolchains());
  }
}