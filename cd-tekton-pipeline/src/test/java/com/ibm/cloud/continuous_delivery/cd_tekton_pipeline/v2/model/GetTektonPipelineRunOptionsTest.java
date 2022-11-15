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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetTektonPipelineRunOptions model.
 */
public class GetTektonPipelineRunOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetTektonPipelineRunOptions() throws Throwable {
    GetTektonPipelineRunOptions getTektonPipelineRunOptionsModel = new GetTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .includes("definitions")
      .build();
    assertEquals(getTektonPipelineRunOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(getTektonPipelineRunOptionsModel.id(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(getTektonPipelineRunOptionsModel.includes(), "definitions");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineRunOptionsError() throws Throwable {
    new GetTektonPipelineRunOptions.Builder().build();
  }

}