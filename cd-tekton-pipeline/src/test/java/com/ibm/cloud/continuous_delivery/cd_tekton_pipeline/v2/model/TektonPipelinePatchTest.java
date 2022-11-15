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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TektonPipelinePatch;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.WorkerIdentity;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TektonPipelinePatch model.
 */
public class TektonPipelinePatchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTektonPipelinePatch() throws Throwable {
    WorkerIdentity workerIdentityModel = new WorkerIdentity.Builder()
      .id("testString")
      .build();
    assertEquals(workerIdentityModel.id(), "testString");

    TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
      .enableNotifications(false)
      .enablePartialCloning(false)
      .worker(workerIdentityModel)
      .build();
    assertEquals(tektonPipelinePatchModel.enableNotifications(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModel.enablePartialCloning(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModel.worker(), workerIdentityModel);

    String json = TestUtilities.serialize(tektonPipelinePatchModel);

    TektonPipelinePatch tektonPipelinePatchModelNew = TestUtilities.deserialize(json, TektonPipelinePatch.class);
    assertTrue(tektonPipelinePatchModelNew instanceof TektonPipelinePatch);
    assertEquals(tektonPipelinePatchModelNew.enableNotifications(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModelNew.enablePartialCloning(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModelNew.worker().toString(), workerIdentityModel.toString());
  }
  @Test
  public void testTektonPipelinePatchAsPatch() throws Throwable {
    WorkerIdentity workerIdentityModel = new WorkerIdentity.Builder()
      .id("testString")
      .build();

    TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
      .enableNotifications(false)
      .enablePartialCloning(false)
      .worker(workerIdentityModel)
      .build();

    Map<String, Object> mergePatch = tektonPipelinePatchModel.asPatch();

    assertTrue(mergePatch.containsKey("enable_notifications"));
    assertTrue(mergePatch.containsKey("enable_partial_cloning"));
    assertTrue(mergePatch.containsKey("worker"));
  }

}