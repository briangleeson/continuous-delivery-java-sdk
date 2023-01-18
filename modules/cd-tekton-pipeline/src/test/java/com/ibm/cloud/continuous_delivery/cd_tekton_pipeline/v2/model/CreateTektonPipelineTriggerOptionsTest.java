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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GenericSecret;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerSourcePropertiesPrototype;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerSourcePrototype;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.WorkerIdentity;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTektonPipelineTriggerOptions model.
 */
public class CreateTektonPipelineTriggerOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTektonPipelineTriggerOptions() throws Throwable {
    WorkerIdentity workerIdentityModel = new WorkerIdentity.Builder()
      .id("testString")
      .build();
    assertEquals(workerIdentityModel.id(), "testString");

    GenericSecret genericSecretModel = new GenericSecret.Builder()
      .type("token_matches")
      .value("testString")
      .source("header")
      .keyName("testString")
      .algorithm("md4")
      .build();
    assertEquals(genericSecretModel.type(), "token_matches");
    assertEquals(genericSecretModel.value(), "testString");
    assertEquals(genericSecretModel.source(), "header");
    assertEquals(genericSecretModel.keyName(), "testString");
    assertEquals(genericSecretModel.algorithm(), "md4");

    TriggerSourcePropertiesPrototype triggerSourcePropertiesPrototypeModel = new TriggerSourcePropertiesPrototype.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .build();
    assertEquals(triggerSourcePropertiesPrototypeModel.url(), "testString");
    assertEquals(triggerSourcePropertiesPrototypeModel.branch(), "testString");
    assertEquals(triggerSourcePropertiesPrototypeModel.pattern(), "testString");

    TriggerSourcePrototype triggerSourcePrototypeModel = new TriggerSourcePrototype.Builder()
      .type("testString")
      .xProperties(triggerSourcePropertiesPrototypeModel)
      .build();
    assertEquals(triggerSourcePrototypeModel.type(), "testString");
    assertEquals(triggerSourcePrototypeModel.xProperties(), triggerSourcePropertiesPrototypeModel);

    CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptionsModel = new CreateTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .type("manual")
      .name("start-deploy")
      .eventListener("testString")
      .tags(java.util.Arrays.asList("testString"))
      .worker(workerIdentityModel)
      .maxConcurrentRuns(Long.valueOf("4"))
      .enabled(true)
      .secret(genericSecretModel)
      .cron("testString")
      .timezone("America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC")
      .source(triggerSourcePrototypeModel)
      .events(java.util.Arrays.asList("push", "pull_request"))
      .build();
    assertEquals(createTektonPipelineTriggerOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(createTektonPipelineTriggerOptionsModel.type(), "manual");
    assertEquals(createTektonPipelineTriggerOptionsModel.name(), "start-deploy");
    assertEquals(createTektonPipelineTriggerOptionsModel.eventListener(), "testString");
    assertEquals(createTektonPipelineTriggerOptionsModel.tags(), java.util.Arrays.asList("testString"));
    assertEquals(createTektonPipelineTriggerOptionsModel.worker(), workerIdentityModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.maxConcurrentRuns(), Long.valueOf("4"));
    assertEquals(createTektonPipelineTriggerOptionsModel.enabled(), Boolean.valueOf(true));
    assertEquals(createTektonPipelineTriggerOptionsModel.secret(), genericSecretModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.cron(), "testString");
    assertEquals(createTektonPipelineTriggerOptionsModel.timezone(), "America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC");
    assertEquals(createTektonPipelineTriggerOptionsModel.source(), triggerSourcePrototypeModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.events(), java.util.Arrays.asList("push", "pull_request"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineTriggerOptionsError() throws Throwable {
    new CreateTektonPipelineTriggerOptions.Builder().build();
  }

}