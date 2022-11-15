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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Property;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTektonPipelineRunOptions model.
 */
public class CreateTektonPipelineRunOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTektonPipelineRunOptions() throws Throwable {
    Property propertyModel = new Property.Builder()
      .name("testString")
      .value("testString")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("secure")
      .path("testString")
      .build();
    assertEquals(propertyModel.name(), "testString");
    assertEquals(propertyModel.value(), "testString");
    assertEquals(propertyModel.xEnum(), java.util.Arrays.asList("testString"));
    assertEquals(propertyModel.type(), "secure");
    assertEquals(propertyModel.path(), "testString");

    CreateTektonPipelineRunOptions createTektonPipelineRunOptionsModel = new CreateTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerName("start-deploy")
      .triggerProperties(java.util.Arrays.asList("testString"))
      .secureTriggerProperties(java.util.Arrays.asList("testString"))
      .triggerHeaders(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .triggerBody(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(createTektonPipelineRunOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(createTektonPipelineRunOptionsModel.triggerName(), "start-deploy");
    assertEquals(createTektonPipelineRunOptionsModel.triggerProperties(), java.util.Arrays.asList("testString"));
    assertEquals(createTektonPipelineRunOptionsModel.secureTriggerProperties(), java.util.Arrays.asList("testString"));
    assertEquals(createTektonPipelineRunOptionsModel.triggerHeaders(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createTektonPipelineRunOptionsModel.triggerBody(), java.util.Collections.singletonMap("anyKey", "anyValue"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineRunOptionsError() throws Throwable {
    new CreateTektonPipelineRunOptions.Builder().build();
  }

}