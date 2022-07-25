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

package github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CancelTektonPipelineRunOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineDefinitionOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelinePropertiesOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineRunOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerPropertiesOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Definition;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DefinitionScmSource;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DefinitionsCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DefinitionsCollectionDefinitionsItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelineDefinitionOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelineOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelinePropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelineRunOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DeleteTektonPipelineTriggerPropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.DuplicateTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Events;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GenericSecret;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineDefinitionOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelinePropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineRunLogContentOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineRunLogsOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineRunOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.GetTektonPipelineTriggerPropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelineDefinitionsOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelinePropertiesOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelineRunsOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelineTriggerPropertiesOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ListTektonPipelineTriggersOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Log;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.LogsCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRun;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunWorker;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunsCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunsCollectionFirst;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunsCollectionLast;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunsCollectionNext;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PipelineRunsCollectionPipelineRunsItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.PropertiesCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Property;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ReplaceTektonPipelineDefinitionOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ReplaceTektonPipelinePropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.ReplaceTektonPipelineTriggerPropertyOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.RerunTektonPipelineRunOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TektonPipeline;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TektonPipelinePatch;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TektonPipelinePipelineDefinition;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TektonPipelineRunsPager;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Toolchain;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Trigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerGenericTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerGenericTriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerManualTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerManualTriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerPatch;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerPropertiesCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerPropertiesCollectionPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerProperty;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmSource;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmTriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerTimerTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerTimerTriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggersCollection;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.UpdateTektonPipelineOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.UpdateTektonPipelineTriggerOptions;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.UserInfo;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Worker;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.WorkerWithId;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import github.com/IBM/continuous-delivery-java-sdk.test.SdkIntegrationTestBase;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the CdTektonPipeline service.
 */
public class CdTektonPipelineIT extends SdkIntegrationTestBase {
  public CdTektonPipeline service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../cd_tekton_pipeline_v2.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = CdTektonPipeline.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CdTektonPipeline.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateTektonPipeline() throws Exception {
    try {
      WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
        .id("public")
        .build();

      CreateTektonPipelineOptions createTektonPipelineOptions = new CreateTektonPipelineOptions.Builder()
        .enableSlackNotifications(false)
        .enablePartialCloning(false)
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .worker(workerWithIdModel)
        .build();

      // Invoke operation
      Response<TektonPipeline> response = service.createTektonPipeline(createTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      TektonPipeline tektonPipelineResult = response.getResult();

      assertNotNull(tektonPipelineResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipeline() throws Exception {
    try {
      GetTektonPipelineOptions getTektonPipelineOptions = new GetTektonPipelineOptions.Builder()
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<TektonPipeline> response = service.getTektonPipeline(getTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TektonPipeline tektonPipelineResult = response.getResult();

      assertNotNull(tektonPipelineResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateTektonPipeline() throws Exception {
    try {
      WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
        .id("public")
        .build();

      TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
        .enableSlackNotifications(false)
        .enablePartialCloning(false)
        .worker(workerWithIdModel)
        .build();
      Map<String, Object> tektonPipelinePatchModelAsPatch = tektonPipelinePatchModel.asPatch();

      UpdateTektonPipelineOptions updateTektonPipelineOptions = new UpdateTektonPipelineOptions.Builder()
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .tektonPipelinePatch(tektonPipelinePatchModelAsPatch)
        .build();

      // Invoke operation
      Response<TektonPipeline> response = service.updateTektonPipeline(updateTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TektonPipeline tektonPipelineResult = response.getResult();

      assertNotNull(tektonPipelineResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTektonPipelineRuns() throws Exception {
    try {
      ListTektonPipelineRunsOptions listTektonPipelineRunsOptions = new ListTektonPipelineRunsOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .start("testString")
        .limit(Long.valueOf("10"))
        .offset(Long.valueOf("26"))
        .status("succeeded")
        .triggerName("manual-trigger")
        .build();

      // Invoke operation
      Response<PipelineRunsCollection> response = service.listTektonPipelineRuns(listTektonPipelineRunsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PipelineRunsCollection pipelineRunsCollectionResult = response.getResult();

      assertNotNull(pipelineRunsCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListTektonPipelineRuns" })
  public void testListTektonPipelineRunsWithPager() throws Exception {
    try {
      ListTektonPipelineRunsOptions options = new ListTektonPipelineRunsOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .limit(Long.valueOf("10"))
        .offset(Long.valueOf("26"))
        .status("succeeded")
        .triggerName("manual-trigger")
        .build();

      // Test getNext().
      List<PipelineRunsCollectionPipelineRunsItem> allResults = new ArrayList<>();
      TektonPipelineRunsPager pager = new TektonPipelineRunsPager(service, options);
      while (pager.hasNext()) {
        List<PipelineRunsCollectionPipelineRunsItem> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new TektonPipelineRunsPager(service, options);
      List<PipelineRunsCollectionPipelineRunsItem> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateTektonPipelineRun() throws Exception {
    try {
      CreateTektonPipelineRunOptions createTektonPipelineRunOptions = new CreateTektonPipelineRunOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerName("Generic Webhook Trigger - 0")
        .triggerProperties(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .secureTriggerProperties(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .triggerHeader(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .triggerBody(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
        .build();

      // Invoke operation
      Response<PipelineRun> response = service.createTektonPipelineRun(createTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PipelineRun pipelineRunResult = response.getResult();

      assertNotNull(pipelineRunResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineRun() throws Exception {
    try {
      GetTektonPipelineRunOptions getTektonPipelineRunOptions = new GetTektonPipelineRunOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .includes("definitions")
        .build();

      // Invoke operation
      Response<PipelineRun> response = service.getTektonPipelineRun(getTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PipelineRun pipelineRunResult = response.getResult();

      assertNotNull(pipelineRunResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCancelTektonPipelineRun() throws Exception {
    try {
      CancelTektonPipelineRunOptions cancelTektonPipelineRunOptions = new CancelTektonPipelineRunOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .force(true)
        .build();

      // Invoke operation
      Response<PipelineRun> response = service.cancelTektonPipelineRun(cancelTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      PipelineRun pipelineRunResult = response.getResult();

      assertNotNull(pipelineRunResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRerunTektonPipelineRun() throws Exception {
    try {
      RerunTektonPipelineRunOptions rerunTektonPipelineRunOptions = new RerunTektonPipelineRunOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<PipelineRun> response = service.rerunTektonPipelineRun(rerunTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PipelineRun pipelineRunResult = response.getResult();

      assertNotNull(pipelineRunResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineRunLogs() throws Exception {
    try {
      GetTektonPipelineRunLogsOptions getTektonPipelineRunLogsOptions = new GetTektonPipelineRunLogsOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<LogsCollection> response = service.getTektonPipelineRunLogs(getTektonPipelineRunLogsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      LogsCollection logsCollectionResult = response.getResult();

      assertNotNull(logsCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineRunLogContent() throws Exception {
    try {
      GetTektonPipelineRunLogContentOptions getTektonPipelineRunLogContentOptions = new GetTektonPipelineRunLogContentOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .pipelineRunId("bf4b3abd-0c93-416b-911e-9cf42f1a1085")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<Log> response = service.getTektonPipelineRunLogContent(getTektonPipelineRunLogContentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Log logResult = response.getResult();

      assertNotNull(logResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTektonPipelineDefinitions() throws Exception {
    try {
      ListTektonPipelineDefinitionsOptions listTektonPipelineDefinitionsOptions = new ListTektonPipelineDefinitionsOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<DefinitionsCollection> response = service.listTektonPipelineDefinitions(listTektonPipelineDefinitionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DefinitionsCollection definitionsCollectionResult = response.getResult();

      assertNotNull(definitionsCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateTektonPipelineDefinition() throws Exception {
    try {
      DefinitionScmSource definitionScmSourceModel = new DefinitionScmSource.Builder()
        .url("https://github.com/IBM/tekton-tutorial.git")
        .branch("master")
        .tag("testString")
        .path(".tekton")
        .serviceInstanceId("testString")
        .build();

      CreateTektonPipelineDefinitionOptions createTektonPipelineDefinitionOptions = new CreateTektonPipelineDefinitionOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .scmSource(definitionScmSourceModel)
        .id("testString")
        .build();

      // Invoke operation
      Response<Definition> response = service.createTektonPipelineDefinition(createTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Definition definitionResult = response.getResult();

      assertNotNull(definitionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineDefinition() throws Exception {
    try {
      GetTektonPipelineDefinitionOptions getTektonPipelineDefinitionOptions = new GetTektonPipelineDefinitionOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
        .build();

      // Invoke operation
      Response<Definition> response = service.getTektonPipelineDefinition(getTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Definition definitionResult = response.getResult();

      assertNotNull(definitionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceTektonPipelineDefinition() throws Exception {
    try {
      DefinitionScmSource definitionScmSourceModel = new DefinitionScmSource.Builder()
        .url("https://github.com/IBM/tekton-tutorial.git")
        .branch("master")
        .tag("testString")
        .path(".tekton")
        .serviceInstanceId("071d8049-d984-4feb-a2ed-2a1e938918ba")
        .build();

      ReplaceTektonPipelineDefinitionOptions replaceTektonPipelineDefinitionOptions = new ReplaceTektonPipelineDefinitionOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
        .scmSource(definitionScmSourceModel)
        .id("22f92ab1-e0ac-4c65-84e7-8a4cb32dba0f")
        .build();

      // Invoke operation
      Response<Definition> response = service.replaceTektonPipelineDefinition(replaceTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Definition definitionResult = response.getResult();

      assertNotNull(definitionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTektonPipelineProperties() throws Exception {
    try {
      ListTektonPipelinePropertiesOptions listTektonPipelinePropertiesOptions = new ListTektonPipelinePropertiesOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .name("prod")
        .type(java.util.Arrays.asList("secure", "text"))
        .sort("name")
        .build();

      // Invoke operation
      Response<PropertiesCollection> response = service.listTektonPipelineProperties(listTektonPipelinePropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PropertiesCollection propertiesCollectionResult = response.getResult();

      assertNotNull(propertiesCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateTektonPipelineProperties() throws Exception {
    try {
      CreateTektonPipelinePropertiesOptions createTektonPipelinePropertiesOptions = new CreateTektonPipelinePropertiesOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .name("key1")
        .value("https://github.com/IBM/tekton-tutorial.git")
        .xEnum(java.util.Arrays.asList("testString"))
        .type("text")
        .path("testString")
        .build();

      // Invoke operation
      Response<Property> response = service.createTektonPipelineProperties(createTektonPipelinePropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Property propertyResult = response.getResult();

      assertNotNull(propertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineProperty() throws Exception {
    try {
      GetTektonPipelinePropertyOptions getTektonPipelinePropertyOptions = new GetTektonPipelinePropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .propertyName("debug-pipeline")
        .build();

      // Invoke operation
      Response<Property> response = service.getTektonPipelineProperty(getTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Property propertyResult = response.getResult();

      assertNotNull(propertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceTektonPipelineProperty() throws Exception {
    try {
      ReplaceTektonPipelinePropertyOptions replaceTektonPipelinePropertyOptions = new ReplaceTektonPipelinePropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .propertyName("debug-pipeline")
        .name("key1")
        .value("https://github.com/IBM/tekton-tutorial.git")
        .xEnum(java.util.Arrays.asList("testString"))
        .type("text")
        .path("testString")
        .build();

      // Invoke operation
      Response<Property> response = service.replaceTektonPipelineProperty(replaceTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Property propertyResult = response.getResult();

      assertNotNull(propertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTektonPipelineTriggers() throws Exception {
    try {
      ListTektonPipelineTriggersOptions listTektonPipelineTriggersOptions = new ListTektonPipelineTriggersOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .type("manual,scm")
        .name("testString")
        .eventListener("testString")
        .workerId("testString")
        .workerName("testString")
        .disabled("true")
        .tags("tag1,tag2")
        .build();

      // Invoke operation
      Response<TriggersCollection> response = service.listTektonPipelineTriggers(listTektonPipelineTriggersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggersCollection triggersCollectionResult = response.getResult();

      assertNotNull(triggersCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateTektonPipelineTrigger() throws Exception {
    try {
      Worker workerModel = new Worker.Builder()
        .name("testString")
        .type("testString")
        .id("public")
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

      CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptions = new CreateTektonPipelineTriggerOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .type("manual")
        .name("Manual Trigger")
        .eventListener("pr-listener")
        .tags(java.util.Arrays.asList("testString"))
        .worker(workerModel)
        .maxConcurrentRuns(Long.valueOf("3"))
        .disabled(false)
        .secret(genericSecretModel)
        .cron("testString")
        .timezone("testString")
        .scmSource(triggerScmSourceModel)
        .events(eventsModel)
        .build();

      // Invoke operation
      Response<Trigger> response = service.createTektonPipelineTrigger(createTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Trigger triggerResult = response.getResult();

      assertNotNull(triggerResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineTrigger() throws Exception {
    try {
      GetTektonPipelineTriggerOptions getTektonPipelineTriggerOptions = new GetTektonPipelineTriggerOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .build();

      // Invoke operation
      Response<Trigger> response = service.getTektonPipelineTrigger(getTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Trigger triggerResult = response.getResult();

      assertNotNull(triggerResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateTektonPipelineTrigger() throws Exception {
    try {
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
      Map<String, Object> triggerPatchModelAsPatch = triggerPatchModel.asPatch();

      UpdateTektonPipelineTriggerOptions updateTektonPipelineTriggerOptions = new UpdateTektonPipelineTriggerOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .triggerPatch(triggerPatchModelAsPatch)
        .build();

      // Invoke operation
      Response<Trigger> response = service.updateTektonPipelineTrigger(updateTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Trigger triggerResult = response.getResult();

      assertNotNull(triggerResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDuplicateTektonPipelineTrigger() throws Exception {
    try {
      DuplicateTektonPipelineTriggerOptions duplicateTektonPipelineTriggerOptions = new DuplicateTektonPipelineTriggerOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .sourceTriggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .name("triggerName")
        .build();

      // Invoke operation
      Response<Trigger> response = service.duplicateTektonPipelineTrigger(duplicateTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Trigger triggerResult = response.getResult();

      assertNotNull(triggerResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListTektonPipelineTriggerProperties() throws Exception {
    try {
      ListTektonPipelineTriggerPropertiesOptions listTektonPipelineTriggerPropertiesOptions = new ListTektonPipelineTriggerPropertiesOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .name("prod")
        .type("secure,text")
        .sort("name")
        .build();

      // Invoke operation
      Response<TriggerPropertiesCollection> response = service.listTektonPipelineTriggerProperties(listTektonPipelineTriggerPropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerPropertiesCollection triggerPropertiesCollectionResult = response.getResult();

      assertNotNull(triggerPropertiesCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateTektonPipelineTriggerProperties() throws Exception {
    try {
      CreateTektonPipelineTriggerPropertiesOptions createTektonPipelineTriggerPropertiesOptions = new CreateTektonPipelineTriggerPropertiesOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .name("key1")
        .value("https://github.com/IBM/tekton-tutorial.git")
        .xEnum(java.util.Arrays.asList("testString"))
        .type("text")
        .path("testString")
        .build();

      // Invoke operation
      Response<TriggerProperty> response = service.createTektonPipelineTriggerProperties(createTektonPipelineTriggerPropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      TriggerProperty triggerPropertyResult = response.getResult();

      assertNotNull(triggerPropertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetTektonPipelineTriggerProperty() throws Exception {
    try {
      GetTektonPipelineTriggerPropertyOptions getTektonPipelineTriggerPropertyOptions = new GetTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .propertyName("debug-pipeline")
        .build();

      // Invoke operation
      Response<TriggerProperty> response = service.getTektonPipelineTriggerProperty(getTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerProperty triggerPropertyResult = response.getResult();

      assertNotNull(triggerPropertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testReplaceTektonPipelineTriggerProperty() throws Exception {
    try {
      ReplaceTektonPipelineTriggerPropertyOptions replaceTektonPipelineTriggerPropertyOptions = new ReplaceTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .propertyName("debug-pipeline")
        .name("key1")
        .value("https://github.com/IBM/tekton-tutorial.git")
        .xEnum(java.util.Arrays.asList("testString"))
        .type("text")
        .path("testString")
        .build();

      // Invoke operation
      Response<TriggerProperty> response = service.replaceTektonPipelineTriggerProperty(replaceTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerProperty triggerPropertyResult = response.getResult();

      assertNotNull(triggerPropertyResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipelineTriggerProperty() throws Exception {
    try {
      DeleteTektonPipelineTriggerPropertyOptions deleteTektonPipelineTriggerPropertyOptions = new DeleteTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .propertyName("debug-pipeline")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipelineTriggerProperty(deleteTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipelineTrigger() throws Exception {
    try {
      DeleteTektonPipelineTriggerOptions deleteTektonPipelineTriggerOptions = new DeleteTektonPipelineTriggerOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipelineTrigger(deleteTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipelineRun() throws Exception {
    try {
      DeleteTektonPipelineRunOptions deleteTektonPipelineRunOptions = new DeleteTektonPipelineRunOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipelineRun(deleteTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipelineProperty() throws Exception {
    try {
      DeleteTektonPipelinePropertyOptions deleteTektonPipelinePropertyOptions = new DeleteTektonPipelinePropertyOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .propertyName("debug-pipeline")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipelineProperty(deleteTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipelineDefinition() throws Exception {
    try {
      DeleteTektonPipelineDefinitionOptions deleteTektonPipelineDefinitionOptions = new DeleteTektonPipelineDefinitionOptions.Builder()
        .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
        .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipelineDefinition(deleteTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteTektonPipeline() throws Exception {
    try {
      DeleteTektonPipelineOptions deleteTektonPipelineOptions = new DeleteTektonPipelineOptions.Builder()
        .id("94619026-912b-4d92-8f51-6c74f0692d90")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTektonPipeline(deleteTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
