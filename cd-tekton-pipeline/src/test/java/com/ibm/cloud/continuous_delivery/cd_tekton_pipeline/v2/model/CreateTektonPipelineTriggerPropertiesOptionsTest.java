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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerPropertiesOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTektonPipelineTriggerPropertiesOptions model.
 */
public class CreateTektonPipelineTriggerPropertiesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTektonPipelineTriggerPropertiesOptions() throws Throwable {
    CreateTektonPipelineTriggerPropertiesOptions createTektonPipelineTriggerPropertiesOptionsModel = new CreateTektonPipelineTriggerPropertiesOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .name("testString")
      .value("testString")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("secure")
      .path("testString")
      .build();
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.triggerId(), "1bb892a1-2e04-4768-a369-b1159eace147");
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.name(), "testString");
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.value(), "testString");
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.xEnum(), java.util.Arrays.asList("testString"));
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.type(), "secure");
    assertEquals(createTektonPipelineTriggerPropertiesOptionsModel.path(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineTriggerPropertiesOptionsError() throws Throwable {
    new CreateTektonPipelineTriggerPropertiesOptions.Builder().build();
  }

}