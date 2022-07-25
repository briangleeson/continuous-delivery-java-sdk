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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Events;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GenericSecret;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmSource;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Worker;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
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
    Worker workerModel = new Worker.Builder()
      .name("testString")
      .type("testString")
      .id("testString")
      .build();
    assertEquals(workerModel.name(), "testString");
    assertEquals(workerModel.type(), "testString");
    assertEquals(workerModel.id(), "testString");

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

    TriggerScmSource triggerScmSourceModel = new TriggerScmSource.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .serviceInstanceId("testString")
      .build();
    assertEquals(triggerScmSourceModel.url(), "testString");
    assertEquals(triggerScmSourceModel.branch(), "testString");
    assertEquals(triggerScmSourceModel.pattern(), "testString");
    assertEquals(triggerScmSourceModel.blindConnection(), Boolean.valueOf(true));
    assertEquals(triggerScmSourceModel.hookId(), "testString");
    assertEquals(triggerScmSourceModel.serviceInstanceId(), "testString");

    Events eventsModel = new Events.Builder()
      .push(true)
      .pullRequestClosed(true)
      .pullRequest(true)
      .build();
    assertEquals(eventsModel.push(), Boolean.valueOf(true));
    assertEquals(eventsModel.pullRequestClosed(), Boolean.valueOf(true));
    assertEquals(eventsModel.pullRequest(), Boolean.valueOf(true));

    CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptionsModel = new CreateTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .type("manual")
      .name("start-deploy")
      .eventListener("testString")
      .tags(java.util.Arrays.asList("testString"))
      .worker(workerModel)
      .maxConcurrentRuns(Long.valueOf("4"))
      .disabled(true)
      .secret(genericSecretModel)
      .cron("testString")
      .timezone("America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC")
      .scmSource(triggerScmSourceModel)
      .events(eventsModel)
      .build();
    assertEquals(createTektonPipelineTriggerOptionsModel.pipelineId(), "94619026-912b-4d92-8f51-6c74f0692d90");
    assertEquals(createTektonPipelineTriggerOptionsModel.type(), "manual");
    assertEquals(createTektonPipelineTriggerOptionsModel.name(), "start-deploy");
    assertEquals(createTektonPipelineTriggerOptionsModel.eventListener(), "testString");
    assertEquals(createTektonPipelineTriggerOptionsModel.tags(), java.util.Arrays.asList("testString"));
    assertEquals(createTektonPipelineTriggerOptionsModel.worker(), workerModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.maxConcurrentRuns(), Long.valueOf("4"));
    assertEquals(createTektonPipelineTriggerOptionsModel.disabled(), Boolean.valueOf(true));
    assertEquals(createTektonPipelineTriggerOptionsModel.secret(), genericSecretModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.cron(), "testString");
    assertEquals(createTektonPipelineTriggerOptionsModel.timezone(), "America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC");
    assertEquals(createTektonPipelineTriggerOptionsModel.scmSource(), triggerScmSourceModel);
    assertEquals(createTektonPipelineTriggerOptionsModel.events(), eventsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineTriggerOptionsError() throws Throwable {
    new CreateTektonPipelineTriggerOptions.Builder().build();
  }

}