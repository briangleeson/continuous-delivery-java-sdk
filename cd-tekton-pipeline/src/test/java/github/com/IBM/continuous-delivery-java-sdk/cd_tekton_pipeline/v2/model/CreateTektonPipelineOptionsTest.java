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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.WorkerWithId;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTektonPipelineOptions model.
 */
public class CreateTektonPipelineOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTektonPipelineOptions() throws Throwable {
    WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
      .id("testString")
      .build();
    assertEquals(workerWithIdModel.id(), "testString");

    CreateTektonPipelineOptions createTektonPipelineOptionsModel = new CreateTektonPipelineOptions.Builder()
      .enableSlackNotifications(false)
      .enablePartialCloning(false)
      .id("testString")
      .worker(workerWithIdModel)
      .build();
    assertEquals(createTektonPipelineOptionsModel.enableSlackNotifications(), Boolean.valueOf(false));
    assertEquals(createTektonPipelineOptionsModel.enablePartialCloning(), Boolean.valueOf(false));
    assertEquals(createTektonPipelineOptionsModel.id(), "testString");
    assertEquals(createTektonPipelineOptionsModel.worker(), workerWithIdModel);
  }
}