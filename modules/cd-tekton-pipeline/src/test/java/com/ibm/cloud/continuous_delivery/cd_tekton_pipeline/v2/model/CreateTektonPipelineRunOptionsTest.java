/*
 * (C) Copyright IBM Corp. 2023.
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
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunTrigger;
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
      .type("secure")
      .build();
    assertEquals(propertyModel.name(), "testString");
    assertEquals(propertyModel.value(), "testString");
    assertEquals(propertyModel.type(), "secure");

    PipelineRunTrigger pipelineRunTriggerModel = new PipelineRunTrigger.Builder()
      .name("start-deploy")
      .xProperties(java.util.Collections.singletonMap("runProp1", "runProp1"))
      .secureProperties(java.util.Collections.singletonMap("runSecProp1", "runSecProp1"))
      .headers(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .body(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(pipelineRunTriggerModel.name(), "start-deploy");
    assertEquals(pipelineRunTriggerModel.xProperties(), java.util.Collections.singletonMap("runProp1", "runProp1"));
    assertEquals(pipelineRunTriggerModel.secureProperties(), java.util.Collections.singletonMap("runSecProp1", "runSecProp1"));

    CreateTektonPipelineRunOptions createTektonPipelineRunOptionsModel = new CreateTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerName("start-deploy")
      .triggerProperties(java.util.Collections.singletonMap("runProp1", "runProp1"))
      .secureTriggerProperties(java.util.Collections.singletonMap("runSecProp1", "runSecProp1"))
      .triggerHeaders(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .triggerBody(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .trigger(pipelineRunTriggerModel)
      .build();
    assertEquals(createTektonPipelineRunOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(createTektonPipelineRunOptionsModel.triggerName(), "start-deploy");
    assertEquals(createTektonPipelineRunOptionsModel.triggerProperties(), java.util.Collections.singletonMap("runProp1", "runProp1"));
    assertEquals(createTektonPipelineRunOptionsModel.secureTriggerProperties(), java.util.Collections.singletonMap("runSecProp1", "runSecProp1"));
    assertEquals(createTektonPipelineRunOptionsModel.triggerHeaders(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createTektonPipelineRunOptionsModel.triggerBody(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createTektonPipelineRunOptionsModel.trigger(), pipelineRunTriggerModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineRunOptionsError() throws Throwable {
    new CreateTektonPipelineRunOptions.Builder().build();
  }

}