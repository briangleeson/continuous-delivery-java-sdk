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

package github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TektonPipelinePatch;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.WorkerWithId;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
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
    WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
      .id("testString")
      .build();
    assertEquals(workerWithIdModel.id(), "testString");

    TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
      .enableSlackNotifications(false)
      .enablePartialCloning(false)
      .worker(workerWithIdModel)
      .build();
    assertEquals(tektonPipelinePatchModel.enableSlackNotifications(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModel.enablePartialCloning(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModel.worker(), workerWithIdModel);

    String json = TestUtilities.serialize(tektonPipelinePatchModel);

    TektonPipelinePatch tektonPipelinePatchModelNew = TestUtilities.deserialize(json, TektonPipelinePatch.class);
    assertTrue(tektonPipelinePatchModelNew instanceof TektonPipelinePatch);
    assertEquals(tektonPipelinePatchModelNew.enableSlackNotifications(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModelNew.enablePartialCloning(), Boolean.valueOf(false));
    assertEquals(tektonPipelinePatchModelNew.worker().toString(), workerWithIdModel.toString());
  }
  @Test
  public void testTektonPipelinePatchAsPatch() throws Throwable {
    WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
      .id("testString")
      .build();

    TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
      .enableSlackNotifications(false)
      .enablePartialCloning(false)
      .worker(workerWithIdModel)
      .build();

    Map<String, Object> mergePatch = tektonPipelinePatchModel.asPatch();

    assertTrue(mergePatch.containsKey("enable_slack_notifications"));
    assertTrue(mergePatch.containsKey("enable_partial_cloning"));
    assertTrue(mergePatch.containsKey("worker"));
  }

}