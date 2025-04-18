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

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeData;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeDataApplicationJson;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeDataTextPlain;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ToolchainEventPrototypeData model.
 */
public class ToolchainEventPrototypeDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testToolchainEventPrototypeData() throws Throwable {
    ToolchainEventPrototypeDataApplicationJson toolchainEventPrototypeDataApplicationJsonModel = new ToolchainEventPrototypeDataApplicationJson.Builder()
      .content(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(toolchainEventPrototypeDataApplicationJsonModel.content(), java.util.Collections.singletonMap("anyKey", "anyValue"));

    ToolchainEventPrototypeDataTextPlain toolchainEventPrototypeDataTextPlainModel = new ToolchainEventPrototypeDataTextPlain.Builder()
      .content("This event is dispatched because the pipeline failed")
      .build();
    assertEquals(toolchainEventPrototypeDataTextPlainModel.content(), "This event is dispatched because the pipeline failed");

    ToolchainEventPrototypeData toolchainEventPrototypeDataModel = new ToolchainEventPrototypeData.Builder()
      .applicationJson(toolchainEventPrototypeDataApplicationJsonModel)
      .textPlain(toolchainEventPrototypeDataTextPlainModel)
      .build();
    assertEquals(toolchainEventPrototypeDataModel.applicationJson(), toolchainEventPrototypeDataApplicationJsonModel);
    assertEquals(toolchainEventPrototypeDataModel.textPlain(), toolchainEventPrototypeDataTextPlainModel);

    String json = TestUtilities.serialize(toolchainEventPrototypeDataModel);

    ToolchainEventPrototypeData toolchainEventPrototypeDataModelNew = TestUtilities.deserialize(json, ToolchainEventPrototypeData.class);
    assertTrue(toolchainEventPrototypeDataModelNew instanceof ToolchainEventPrototypeData);
    assertEquals(toolchainEventPrototypeDataModelNew.applicationJson().toString(), toolchainEventPrototypeDataApplicationJsonModel.toString());
    assertEquals(toolchainEventPrototypeDataModelNew.textPlain().toString(), toolchainEventPrototypeDataTextPlainModel.toString());
  }
}