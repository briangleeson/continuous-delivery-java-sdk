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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelineTriggersOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTektonPipelineTriggersOptions model.
 */
public class ListTektonPipelineTriggersOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTektonPipelineTriggersOptions() throws Throwable {
    ListTektonPipelineTriggersOptions listTektonPipelineTriggersOptionsModel = new ListTektonPipelineTriggersOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .type("manual,scm")
      .name("testString")
      .eventListener("testString")
      .workerId("testString")
      .workerName("testString")
      .disabled("true")
      .tags("tag1,tag2")
      .build();
    assertEquals(listTektonPipelineTriggersOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(listTektonPipelineTriggersOptionsModel.type(), "manual,scm");
    assertEquals(listTektonPipelineTriggersOptionsModel.name(), "testString");
    assertEquals(listTektonPipelineTriggersOptionsModel.eventListener(), "testString");
    assertEquals(listTektonPipelineTriggersOptionsModel.workerId(), "testString");
    assertEquals(listTektonPipelineTriggersOptionsModel.workerName(), "testString");
    assertEquals(listTektonPipelineTriggersOptionsModel.disabled(), "true");
    assertEquals(listTektonPipelineTriggersOptionsModel.tags(), "tag1,tag2");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelineTriggersOptionsError() throws Throwable {
    new ListTektonPipelineTriggersOptions.Builder().build();
  }

}