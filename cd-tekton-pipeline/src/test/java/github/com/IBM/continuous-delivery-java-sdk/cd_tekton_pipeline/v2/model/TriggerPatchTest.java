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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Events;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GenericSecret;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerPatch;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmSource;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Worker;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggerPatch model.
 */
public class TriggerPatchTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggerPatch() throws Throwable {
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

    TriggerPatch triggerPatchModel = new TriggerPatch.Builder()
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
    assertEquals(triggerPatchModel.type(), "manual");
    assertEquals(triggerPatchModel.name(), "start-deploy");
    assertEquals(triggerPatchModel.eventListener(), "testString");
    assertEquals(triggerPatchModel.tags(), java.util.Arrays.asList("testString"));
    assertEquals(triggerPatchModel.worker(), workerModel);
    assertEquals(triggerPatchModel.maxConcurrentRuns(), Long.valueOf("4"));
    assertEquals(triggerPatchModel.disabled(), Boolean.valueOf(true));
    assertEquals(triggerPatchModel.secret(), genericSecretModel);
    assertEquals(triggerPatchModel.cron(), "testString");
    assertEquals(triggerPatchModel.timezone(), "America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC");
    assertEquals(triggerPatchModel.scmSource(), triggerScmSourceModel);
    assertEquals(triggerPatchModel.events(), eventsModel);

    String json = TestUtilities.serialize(triggerPatchModel);

    TriggerPatch triggerPatchModelNew = TestUtilities.deserialize(json, TriggerPatch.class);
    assertTrue(triggerPatchModelNew instanceof TriggerPatch);
    assertEquals(triggerPatchModelNew.type(), "manual");
    assertEquals(triggerPatchModelNew.name(), "start-deploy");
    assertEquals(triggerPatchModelNew.eventListener(), "testString");
    assertEquals(triggerPatchModelNew.worker().toString(), workerModel.toString());
    assertEquals(triggerPatchModelNew.maxConcurrentRuns(), Long.valueOf("4"));
    assertEquals(triggerPatchModelNew.disabled(), Boolean.valueOf(true));
    assertEquals(triggerPatchModelNew.secret().toString(), genericSecretModel.toString());
    assertEquals(triggerPatchModelNew.cron(), "testString");
    assertEquals(triggerPatchModelNew.timezone(), "America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC");
    assertEquals(triggerPatchModelNew.scmSource().toString(), triggerScmSourceModel.toString());
    assertEquals(triggerPatchModelNew.events().toString(), eventsModel.toString());
  }
  @Test
  public void testTriggerPatchAsPatch() throws Throwable {
    Worker workerModel = new Worker.Builder()
      .name("testString")
      .type("testString")
      .id("testString")
      .build();

    GenericSecret genericSecretModel = new GenericSecret.Builder()
      .type("token_matches")
      .value("testString")
      .source("header")
      .keyName("testString")
      .algorithm("md4")
      .build();

    TriggerScmSource triggerScmSourceModel = new TriggerScmSource.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .serviceInstanceId("testString")
      .build();

    Events eventsModel = new Events.Builder()
      .push(true)
      .pullRequestClosed(true)
      .pullRequest(true)
      .build();

    TriggerPatch triggerPatchModel = new TriggerPatch.Builder()
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

    Map<String, Object> mergePatch = triggerPatchModel.asPatch();

    assertEquals(mergePatch.get("type"), "manual");
    assertEquals(mergePatch.get("name"), "start-deploy");
    assertEquals(mergePatch.get("event_listener"), "testString");
    assertTrue(mergePatch.containsKey("tags"));
    assertTrue(mergePatch.containsKey("worker"));
    assertTrue(mergePatch.containsKey("max_concurrent_runs"));
    assertTrue(mergePatch.containsKey("disabled"));
    assertTrue(mergePatch.containsKey("secret"));
    assertEquals(mergePatch.get("cron"), "testString");
    assertEquals(mergePatch.get("timezone"), "America/Los_Angeles, CET, Europe/London, GMT, US/Eastern, or UTC");
    assertTrue(mergePatch.containsKey("scm_source"));
    assertTrue(mergePatch.containsKey("events"));
  }

}