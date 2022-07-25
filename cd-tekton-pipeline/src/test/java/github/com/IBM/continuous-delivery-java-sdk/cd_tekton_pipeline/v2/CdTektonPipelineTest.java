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
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.CdTektonPipeline;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CdTektonPipeline service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class CdTektonPipelineTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CdTektonPipeline cdTektonPipelineService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new CdTektonPipeline(serviceName, null);
  }

  // Test the getServiceUrlForRegion() method
  @Test
  public void testGetServiceUrlForRegion() throws Throwable {
    assertNull(CdTektonPipeline.getServiceUrlForRegion("INVALID_REGION"));
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("us-south"), "https://api.us-south.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("us-east"), "https://api.us-east.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("eu-de"), "https://api.eu-de.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("eu-gb"), "https://api.eu-gb.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("jp-osa"), "https://api.jp-osa.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("jp-tok"), "https://api.jp-tok.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("au-syd"), "https://api.au-syd.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("ca-tor"), "https://api.ca-tor.devops.cloud.ibm.com/pipeline/v2");
    assertEquals(CdTektonPipeline.getServiceUrlForRegion("br-sao"), "https://api.br-sao.devops.cloud.ibm.com/pipeline/v2");
  }

  // Test the createTektonPipeline operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelineWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"status\": \"configured\", \"resource_group_id\": \"resourceGroupId\", \"toolchain\": {\"id\": \"id\", \"crn\": \"crn:v1:staging:public:toolchain:us-south:a/0ba224679d6c697f9baee5e14ade83ac:bf5fa00f-ddef-4298-b87b-aa8b6da0e1a6::\"}, \"id\": \"id\", \"definitions\": [{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}], \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"pipeline_definition\": {\"status\": \"updated\", \"id\": \"id\"}, \"triggers\": [{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"runs_url\": \"runsUrl\", \"build_number\": 1, \"enable_slack_notifications\": true, \"enable_partial_cloning\": true, \"enabled\": false}";
    String createTektonPipelinePath = "/tekton_pipelines";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the WorkerWithId model
    WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
      .id("public")
      .build();

    // Construct an instance of the CreateTektonPipelineOptions model
    CreateTektonPipelineOptions createTektonPipelineOptionsModel = new CreateTektonPipelineOptions.Builder()
      .enableSlackNotifications(false)
      .enablePartialCloning(false)
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .worker(workerWithIdModel)
      .build();

    // Invoke createTektonPipeline() with a valid options model and verify the result
    Response<TektonPipeline> response = cdTektonPipelineService.createTektonPipeline(createTektonPipelineOptionsModel).execute();
    assertNotNull(response);
    TektonPipeline responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelinePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipeline operation with and without retries enabled
  @Test
  public void testCreateTektonPipelineWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelineWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelineWOptions();
  }

  // Test the getTektonPipeline operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"status\": \"configured\", \"resource_group_id\": \"resourceGroupId\", \"toolchain\": {\"id\": \"id\", \"crn\": \"crn:v1:staging:public:toolchain:us-south:a/0ba224679d6c697f9baee5e14ade83ac:bf5fa00f-ddef-4298-b87b-aa8b6da0e1a6::\"}, \"id\": \"id\", \"definitions\": [{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}], \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"pipeline_definition\": {\"status\": \"updated\", \"id\": \"id\"}, \"triggers\": [{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"runs_url\": \"runsUrl\", \"build_number\": 1, \"enable_slack_notifications\": true, \"enable_partial_cloning\": true, \"enabled\": false}";
    String getTektonPipelinePath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineOptions model
    GetTektonPipelineOptions getTektonPipelineOptionsModel = new GetTektonPipelineOptions.Builder()
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke getTektonPipeline() with a valid options model and verify the result
    Response<TektonPipeline> response = cdTektonPipelineService.getTektonPipeline(getTektonPipelineOptionsModel).execute();
    assertNotNull(response);
    TektonPipeline responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelinePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipeline operation with and without retries enabled
  @Test
  public void testGetTektonPipelineWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineWOptions();
  }

  // Test the getTektonPipeline operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipeline(null).execute();
  }

  // Test the updateTektonPipeline operation with a valid options model parameter
  @Test
  public void testUpdateTektonPipelineWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"status\": \"configured\", \"resource_group_id\": \"resourceGroupId\", \"toolchain\": {\"id\": \"id\", \"crn\": \"crn:v1:staging:public:toolchain:us-south:a/0ba224679d6c697f9baee5e14ade83ac:bf5fa00f-ddef-4298-b87b-aa8b6da0e1a6::\"}, \"id\": \"id\", \"definitions\": [{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}], \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"pipeline_definition\": {\"status\": \"updated\", \"id\": \"id\"}, \"triggers\": [{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"runs_url\": \"runsUrl\", \"build_number\": 1, \"enable_slack_notifications\": true, \"enable_partial_cloning\": true, \"enabled\": false}";
    String updateTektonPipelinePath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the WorkerWithId model
    WorkerWithId workerWithIdModel = new WorkerWithId.Builder()
      .id("public")
      .build();

    // Construct an instance of the TektonPipelinePatch model
    TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
      .enableSlackNotifications(false)
      .enablePartialCloning(false)
      .worker(workerWithIdModel)
      .build();
    Map<String, Object> tektonPipelinePatchModelAsPatch = tektonPipelinePatchModel.asPatch();

    // Construct an instance of the UpdateTektonPipelineOptions model
    UpdateTektonPipelineOptions updateTektonPipelineOptionsModel = new UpdateTektonPipelineOptions.Builder()
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .tektonPipelinePatch(tektonPipelinePatchModelAsPatch)
      .build();

    // Invoke updateTektonPipeline() with a valid options model and verify the result
    Response<TektonPipeline> response = cdTektonPipelineService.updateTektonPipeline(updateTektonPipelineOptionsModel).execute();
    assertNotNull(response);
    TektonPipeline responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTektonPipelinePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateTektonPipeline operation with and without retries enabled
  @Test
  public void testUpdateTektonPipelineWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testUpdateTektonPipelineWOptions();

    cdTektonPipelineService.disableRetries();
    testUpdateTektonPipelineWOptions();
  }

  // Test the updateTektonPipeline operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTektonPipelineNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.updateTektonPipeline(null).execute();
  }

  // Test the deleteTektonPipeline operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelineWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelinePath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelineOptions model
    DeleteTektonPipelineOptions deleteTektonPipelineOptionsModel = new DeleteTektonPipelineOptions.Builder()
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke deleteTektonPipeline() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipeline(deleteTektonPipelineOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelinePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipeline operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelineWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelineWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelineWOptions();
  }

  // Test the deleteTektonPipeline operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelineNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipeline(null).execute();
  }

  // Test the listTektonPipelineRuns operation with a valid options model parameter
  @Test
  public void testListTektonPipelineRunsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"pipeline_runs\": [{\"id\": \"id\", \"user_info\": {\"iam_id\": \"iamId\", \"sub\": \"sub\"}, \"status\": \"pending\", \"definition_id\": \"definitionId\", \"worker\": {\"name\": \"name\", \"agent\": \"agent\", \"service_id\": \"serviceId\", \"id\": \"id\"}, \"pipeline_id\": \"pipelineId\", \"listener_name\": \"listenerName\", \"trigger\": {\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}, \"event_params_blob\": \"eventParamsBlob\", \"event_header_params_blob\": \"eventHeaderParamsBlob\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"run_url\": \"runUrl\", \"href\": \"href\"}], \"offset\": 20, \"limit\": 20, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}}";
    String listTektonPipelineRunsPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTektonPipelineRunsOptions model
    ListTektonPipelineRunsOptions listTektonPipelineRunsOptionsModel = new ListTektonPipelineRunsOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .start("testString")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("26"))
      .status("succeeded")
      .triggerName("manual-trigger")
      .build();

    // Invoke listTektonPipelineRuns() with a valid options model and verify the result
    Response<PipelineRunsCollection> response = cdTektonPipelineService.listTektonPipelineRuns(listTektonPipelineRunsOptionsModel).execute();
    assertNotNull(response);
    PipelineRunsCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTektonPipelineRunsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("start"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("status"), "succeeded");
    assertEquals(query.get("trigger.name"), "manual-trigger");
  }

  // Test the listTektonPipelineRuns operation with and without retries enabled
  @Test
  public void testListTektonPipelineRunsWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testListTektonPipelineRunsWOptions();

    cdTektonPipelineService.disableRetries();
    testListTektonPipelineRunsWOptions();
  }

  // Test the listTektonPipelineRuns operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelineRunsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.listTektonPipelineRuns(null).execute();
  }

  // Test the listTektonPipelineRuns operation using the TektonPipelineRunsPager.getNext() method
  @Test
  public void testListTektonPipelineRunsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"total_count\":2,\"limit\":1,\"pipeline_runs\":[{\"id\":\"id\",\"user_info\":{\"iam_id\":\"iamId\",\"sub\":\"sub\"},\"status\":\"pending\",\"definition_id\":\"definitionId\",\"worker\":{\"name\":\"name\",\"agent\":\"agent\",\"service_id\":\"serviceId\",\"id\":\"id\"},\"pipeline_id\":\"pipelineId\",\"listener_name\":\"listenerName\",\"trigger\":{\"type\":\"type\",\"name\":\"start-deploy\",\"href\":\"href\",\"event_listener\":\"eventListener\",\"id\":\"id\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\",\"href\":\"href\"}],\"tags\":[\"tags\"],\"worker\":{\"name\":\"name\",\"type\":\"type\",\"id\":\"id\"},\"max_concurrent_runs\":4,\"disabled\":true},\"event_params_blob\":\"eventParamsBlob\",\"event_header_params_blob\":\"eventHeaderParamsBlob\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\"}],\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"run_url\":\"runUrl\",\"href\":\"href\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"pipeline_runs\":[{\"id\":\"id\",\"user_info\":{\"iam_id\":\"iamId\",\"sub\":\"sub\"},\"status\":\"pending\",\"definition_id\":\"definitionId\",\"worker\":{\"name\":\"name\",\"agent\":\"agent\",\"service_id\":\"serviceId\",\"id\":\"id\"},\"pipeline_id\":\"pipelineId\",\"listener_name\":\"listenerName\",\"trigger\":{\"type\":\"type\",\"name\":\"start-deploy\",\"href\":\"href\",\"event_listener\":\"eventListener\",\"id\":\"id\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\",\"href\":\"href\"}],\"tags\":[\"tags\"],\"worker\":{\"name\":\"name\",\"type\":\"type\",\"id\":\"id\"},\"max_concurrent_runs\":4,\"disabled\":true},\"event_params_blob\":\"eventParamsBlob\",\"event_header_params_blob\":\"eventHeaderParamsBlob\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\"}],\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"run_url\":\"runUrl\",\"href\":\"href\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListTektonPipelineRunsOptions listTektonPipelineRunsOptions = new ListTektonPipelineRunsOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("26"))
      .status("succeeded")
      .triggerName("manual-trigger")
      .build();

    List<PipelineRunsCollectionPipelineRunsItem> allResults = new ArrayList<>();
    TektonPipelineRunsPager pager = new TektonPipelineRunsPager(cdTektonPipelineService, listTektonPipelineRunsOptions);
    while (pager.hasNext()) {
      List<PipelineRunsCollectionPipelineRunsItem> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listTektonPipelineRuns operation using the TektonPipelineRunsPager.getAll() method
  @Test
  public void testListTektonPipelineRunsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?start=1\"},\"total_count\":2,\"limit\":1,\"pipeline_runs\":[{\"id\":\"id\",\"user_info\":{\"iam_id\":\"iamId\",\"sub\":\"sub\"},\"status\":\"pending\",\"definition_id\":\"definitionId\",\"worker\":{\"name\":\"name\",\"agent\":\"agent\",\"service_id\":\"serviceId\",\"id\":\"id\"},\"pipeline_id\":\"pipelineId\",\"listener_name\":\"listenerName\",\"trigger\":{\"type\":\"type\",\"name\":\"start-deploy\",\"href\":\"href\",\"event_listener\":\"eventListener\",\"id\":\"id\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\",\"href\":\"href\"}],\"tags\":[\"tags\"],\"worker\":{\"name\":\"name\",\"type\":\"type\",\"id\":\"id\"},\"max_concurrent_runs\":4,\"disabled\":true},\"event_params_blob\":\"eventParamsBlob\",\"event_header_params_blob\":\"eventHeaderParamsBlob\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\"}],\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"run_url\":\"runUrl\",\"href\":\"href\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"pipeline_runs\":[{\"id\":\"id\",\"user_info\":{\"iam_id\":\"iamId\",\"sub\":\"sub\"},\"status\":\"pending\",\"definition_id\":\"definitionId\",\"worker\":{\"name\":\"name\",\"agent\":\"agent\",\"service_id\":\"serviceId\",\"id\":\"id\"},\"pipeline_id\":\"pipelineId\",\"listener_name\":\"listenerName\",\"trigger\":{\"type\":\"type\",\"name\":\"start-deploy\",\"href\":\"href\",\"event_listener\":\"eventListener\",\"id\":\"id\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\",\"href\":\"href\"}],\"tags\":[\"tags\"],\"worker\":{\"name\":\"name\",\"type\":\"type\",\"id\":\"id\"},\"max_concurrent_runs\":4,\"disabled\":true},\"event_params_blob\":\"eventParamsBlob\",\"event_header_params_blob\":\"eventHeaderParamsBlob\",\"properties\":[{\"name\":\"name\",\"value\":\"value\",\"enum\":[\"xEnum\"],\"type\":\"secure\",\"path\":\"path\"}],\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"run_url\":\"runUrl\",\"href\":\"href\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListTektonPipelineRunsOptions listTektonPipelineRunsOptions = new ListTektonPipelineRunsOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("26"))
      .status("succeeded")
      .triggerName("manual-trigger")
      .build();

    TektonPipelineRunsPager pager = new TektonPipelineRunsPager(cdTektonPipelineService, listTektonPipelineRunsOptions);
    List<PipelineRunsCollectionPipelineRunsItem> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createTektonPipelineRun operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelineRunWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"user_info\": {\"iam_id\": \"iamId\", \"sub\": \"sub\"}, \"status\": \"pending\", \"definition_id\": \"definitionId\", \"worker\": {\"name\": \"name\", \"agent\": \"agent\", \"service_id\": \"serviceId\", \"id\": \"id\"}, \"pipeline_id\": \"pipelineId\", \"listener_name\": \"listenerName\", \"trigger\": {\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}, \"event_params_blob\": \"eventParamsBlob\", \"event_header_params_blob\": \"eventHeaderParamsBlob\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"run_url\": \"runUrl\"}";
    String createTektonPipelineRunPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateTektonPipelineRunOptions model
    CreateTektonPipelineRunOptions createTektonPipelineRunOptionsModel = new CreateTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerName("Generic Webhook Trigger - 0")
      .triggerProperties(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .secureTriggerProperties(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .triggerHeader(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .triggerBody(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();

    // Invoke createTektonPipelineRun() with a valid options model and verify the result
    Response<PipelineRun> response = cdTektonPipelineService.createTektonPipelineRun(createTektonPipelineRunOptionsModel).execute();
    assertNotNull(response);
    PipelineRun responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelineRunPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipelineRun operation with and without retries enabled
  @Test
  public void testCreateTektonPipelineRunWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelineRunWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelineRunWOptions();
  }

  // Test the createTektonPipelineRun operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineRunNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.createTektonPipelineRun(null).execute();
  }

  // Test the getTektonPipelineRun operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineRunWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"user_info\": {\"iam_id\": \"iamId\", \"sub\": \"sub\"}, \"status\": \"pending\", \"definition_id\": \"definitionId\", \"worker\": {\"name\": \"name\", \"agent\": \"agent\", \"service_id\": \"serviceId\", \"id\": \"id\"}, \"pipeline_id\": \"pipelineId\", \"listener_name\": \"listenerName\", \"trigger\": {\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}, \"event_params_blob\": \"eventParamsBlob\", \"event_header_params_blob\": \"eventHeaderParamsBlob\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"run_url\": \"runUrl\"}";
    String getTektonPipelineRunPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineRunOptions model
    GetTektonPipelineRunOptions getTektonPipelineRunOptionsModel = new GetTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .includes("definitions")
      .build();

    // Invoke getTektonPipelineRun() with a valid options model and verify the result
    Response<PipelineRun> response = cdTektonPipelineService.getTektonPipelineRun(getTektonPipelineRunOptionsModel).execute();
    assertNotNull(response);
    PipelineRun responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineRunPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("includes"), "definitions");
  }

  // Test the getTektonPipelineRun operation with and without retries enabled
  @Test
  public void testGetTektonPipelineRunWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineRunWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineRunWOptions();
  }

  // Test the getTektonPipelineRun operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineRunNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineRun(null).execute();
  }

  // Test the deleteTektonPipelineRun operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelineRunWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelineRunPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelineRunOptions model
    DeleteTektonPipelineRunOptions deleteTektonPipelineRunOptionsModel = new DeleteTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke deleteTektonPipelineRun() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipelineRun(deleteTektonPipelineRunOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelineRunPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipelineRun operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelineRunWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelineRunWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelineRunWOptions();
  }

  // Test the deleteTektonPipelineRun operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelineRunNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipelineRun(null).execute();
  }

  // Test the cancelTektonPipelineRun operation with a valid options model parameter
  @Test
  public void testCancelTektonPipelineRunWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"user_info\": {\"iam_id\": \"iamId\", \"sub\": \"sub\"}, \"status\": \"pending\", \"definition_id\": \"definitionId\", \"worker\": {\"name\": \"name\", \"agent\": \"agent\", \"service_id\": \"serviceId\", \"id\": \"id\"}, \"pipeline_id\": \"pipelineId\", \"listener_name\": \"listenerName\", \"trigger\": {\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}, \"event_params_blob\": \"eventParamsBlob\", \"event_header_params_blob\": \"eventHeaderParamsBlob\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"run_url\": \"runUrl\"}";
    String cancelTektonPipelineRunPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/94619026-912b-4d92-8f51-6c74f0692d90/cancel";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CancelTektonPipelineRunOptions model
    CancelTektonPipelineRunOptions cancelTektonPipelineRunOptionsModel = new CancelTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .force(true)
      .build();

    // Invoke cancelTektonPipelineRun() with a valid options model and verify the result
    Response<PipelineRun> response = cdTektonPipelineService.cancelTektonPipelineRun(cancelTektonPipelineRunOptionsModel).execute();
    assertNotNull(response);
    PipelineRun responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, cancelTektonPipelineRunPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the cancelTektonPipelineRun operation with and without retries enabled
  @Test
  public void testCancelTektonPipelineRunWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCancelTektonPipelineRunWOptions();

    cdTektonPipelineService.disableRetries();
    testCancelTektonPipelineRunWOptions();
  }

  // Test the cancelTektonPipelineRun operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCancelTektonPipelineRunNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.cancelTektonPipelineRun(null).execute();
  }

  // Test the rerunTektonPipelineRun operation with a valid options model parameter
  @Test
  public void testRerunTektonPipelineRunWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"user_info\": {\"iam_id\": \"iamId\", \"sub\": \"sub\"}, \"status\": \"pending\", \"definition_id\": \"definitionId\", \"worker\": {\"name\": \"name\", \"agent\": \"agent\", \"service_id\": \"serviceId\", \"id\": \"id\"}, \"pipeline_id\": \"pipelineId\", \"listener_name\": \"listenerName\", \"trigger\": {\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}, \"event_params_blob\": \"eventParamsBlob\", \"event_header_params_blob\": \"eventHeaderParamsBlob\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"run_url\": \"runUrl\"}";
    String rerunTektonPipelineRunPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/94619026-912b-4d92-8f51-6c74f0692d90/rerun";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the RerunTektonPipelineRunOptions model
    RerunTektonPipelineRunOptions rerunTektonPipelineRunOptionsModel = new RerunTektonPipelineRunOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke rerunTektonPipelineRun() with a valid options model and verify the result
    Response<PipelineRun> response = cdTektonPipelineService.rerunTektonPipelineRun(rerunTektonPipelineRunOptionsModel).execute();
    assertNotNull(response);
    PipelineRun responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, rerunTektonPipelineRunPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the rerunTektonPipelineRun operation with and without retries enabled
  @Test
  public void testRerunTektonPipelineRunWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testRerunTektonPipelineRunWOptions();

    cdTektonPipelineService.disableRetries();
    testRerunTektonPipelineRunWOptions();
  }

  // Test the rerunTektonPipelineRun operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRerunTektonPipelineRunNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.rerunTektonPipelineRun(null).execute();
  }

  // Test the getTektonPipelineRunLogs operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineRunLogsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"logs\": [{\"data\": \"data\", \"href\": \"href\", \"id\": \"id\", \"name\": \"name\"}]}";
    String getTektonPipelineRunLogsPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/94619026-912b-4d92-8f51-6c74f0692d90/logs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineRunLogsOptions model
    GetTektonPipelineRunLogsOptions getTektonPipelineRunLogsOptionsModel = new GetTektonPipelineRunLogsOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke getTektonPipelineRunLogs() with a valid options model and verify the result
    Response<LogsCollection> response = cdTektonPipelineService.getTektonPipelineRunLogs(getTektonPipelineRunLogsOptionsModel).execute();
    assertNotNull(response);
    LogsCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineRunLogsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineRunLogs operation with and without retries enabled
  @Test
  public void testGetTektonPipelineRunLogsWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineRunLogsWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineRunLogsWOptions();
  }

  // Test the getTektonPipelineRunLogs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineRunLogsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineRunLogs(null).execute();
  }

  // Test the getTektonPipelineRunLogContent operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineRunLogContentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"data\": \"data\", \"href\": \"href\", \"id\": \"id\", \"name\": \"name\"}";
    String getTektonPipelineRunLogContentPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/pipeline_runs/bf4b3abd-0c93-416b-911e-9cf42f1a1085/logs/94619026-912b-4d92-8f51-6c74f0692d90";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineRunLogContentOptions model
    GetTektonPipelineRunLogContentOptions getTektonPipelineRunLogContentOptionsModel = new GetTektonPipelineRunLogContentOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .pipelineRunId("bf4b3abd-0c93-416b-911e-9cf42f1a1085")
      .id("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke getTektonPipelineRunLogContent() with a valid options model and verify the result
    Response<Log> response = cdTektonPipelineService.getTektonPipelineRunLogContent(getTektonPipelineRunLogContentOptionsModel).execute();
    assertNotNull(response);
    Log responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineRunLogContentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineRunLogContent operation with and without retries enabled
  @Test
  public void testGetTektonPipelineRunLogContentWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineRunLogContentWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineRunLogContentWOptions();
  }

  // Test the getTektonPipelineRunLogContent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineRunLogContentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineRunLogContent(null).execute();
  }

  // Test the listTektonPipelineDefinitions operation with a valid options model parameter
  @Test
  public void testListTektonPipelineDefinitionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"definitions\": [{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\", \"href\": \"href\"}]}";
    String listTektonPipelineDefinitionsPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/definitions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTektonPipelineDefinitionsOptions model
    ListTektonPipelineDefinitionsOptions listTektonPipelineDefinitionsOptionsModel = new ListTektonPipelineDefinitionsOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .build();

    // Invoke listTektonPipelineDefinitions() with a valid options model and verify the result
    Response<DefinitionsCollection> response = cdTektonPipelineService.listTektonPipelineDefinitions(listTektonPipelineDefinitionsOptionsModel).execute();
    assertNotNull(response);
    DefinitionsCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTektonPipelineDefinitionsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listTektonPipelineDefinitions operation with and without retries enabled
  @Test
  public void testListTektonPipelineDefinitionsWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testListTektonPipelineDefinitionsWOptions();

    cdTektonPipelineService.disableRetries();
    testListTektonPipelineDefinitionsWOptions();
  }

  // Test the listTektonPipelineDefinitions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelineDefinitionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.listTektonPipelineDefinitions(null).execute();
  }

  // Test the createTektonPipelineDefinition operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelineDefinitionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}";
    String createTektonPipelineDefinitionPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/definitions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the DefinitionScmSource model
    DefinitionScmSource definitionScmSourceModel = new DefinitionScmSource.Builder()
      .url("https://github.com/IBM/tekton-tutorial.git")
      .branch("master")
      .tag("testString")
      .path(".tekton")
      .serviceInstanceId("testString")
      .build();

    // Construct an instance of the CreateTektonPipelineDefinitionOptions model
    CreateTektonPipelineDefinitionOptions createTektonPipelineDefinitionOptionsModel = new CreateTektonPipelineDefinitionOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .scmSource(definitionScmSourceModel)
      .id("testString")
      .build();

    // Invoke createTektonPipelineDefinition() with a valid options model and verify the result
    Response<Definition> response = cdTektonPipelineService.createTektonPipelineDefinition(createTektonPipelineDefinitionOptionsModel).execute();
    assertNotNull(response);
    Definition responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelineDefinitionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipelineDefinition operation with and without retries enabled
  @Test
  public void testCreateTektonPipelineDefinitionWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelineDefinitionWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelineDefinitionWOptions();
  }

  // Test the createTektonPipelineDefinition operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineDefinitionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.createTektonPipelineDefinition(null).execute();
  }

  // Test the getTektonPipelineDefinition operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineDefinitionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}";
    String getTektonPipelineDefinitionPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/definitions/94299034-d45f-4e9a-8ed5-6bd5c7bb7ada";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineDefinitionOptions model
    GetTektonPipelineDefinitionOptions getTektonPipelineDefinitionOptionsModel = new GetTektonPipelineDefinitionOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
      .build();

    // Invoke getTektonPipelineDefinition() with a valid options model and verify the result
    Response<Definition> response = cdTektonPipelineService.getTektonPipelineDefinition(getTektonPipelineDefinitionOptionsModel).execute();
    assertNotNull(response);
    Definition responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineDefinitionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineDefinition operation with and without retries enabled
  @Test
  public void testGetTektonPipelineDefinitionWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineDefinitionWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineDefinitionWOptions();
  }

  // Test the getTektonPipelineDefinition operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineDefinitionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineDefinition(null).execute();
  }

  // Test the replaceTektonPipelineDefinition operation with a valid options model parameter
  @Test
  public void testReplaceTektonPipelineDefinitionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"scm_source\": {\"url\": \"url\", \"branch\": \"branch\", \"tag\": \"tag\", \"path\": \"path\", \"service_instance_id\": \"serviceInstanceId\"}, \"id\": \"id\"}";
    String replaceTektonPipelineDefinitionPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/definitions/94299034-d45f-4e9a-8ed5-6bd5c7bb7ada";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DefinitionScmSource model
    DefinitionScmSource definitionScmSourceModel = new DefinitionScmSource.Builder()
      .url("https://github.com/IBM/tekton-tutorial.git")
      .branch("master")
      .tag("testString")
      .path(".tekton")
      .serviceInstanceId("071d8049-d984-4feb-a2ed-2a1e938918ba")
      .build();

    // Construct an instance of the ReplaceTektonPipelineDefinitionOptions model
    ReplaceTektonPipelineDefinitionOptions replaceTektonPipelineDefinitionOptionsModel = new ReplaceTektonPipelineDefinitionOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
      .scmSource(definitionScmSourceModel)
      .id("22f92ab1-e0ac-4c65-84e7-8a4cb32dba0f")
      .build();

    // Invoke replaceTektonPipelineDefinition() with a valid options model and verify the result
    Response<Definition> response = cdTektonPipelineService.replaceTektonPipelineDefinition(replaceTektonPipelineDefinitionOptionsModel).execute();
    assertNotNull(response);
    Definition responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceTektonPipelineDefinitionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceTektonPipelineDefinition operation with and without retries enabled
  @Test
  public void testReplaceTektonPipelineDefinitionWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testReplaceTektonPipelineDefinitionWOptions();

    cdTektonPipelineService.disableRetries();
    testReplaceTektonPipelineDefinitionWOptions();
  }

  // Test the replaceTektonPipelineDefinition operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceTektonPipelineDefinitionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.replaceTektonPipelineDefinition(null).execute();
  }

  // Test the deleteTektonPipelineDefinition operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelineDefinitionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelineDefinitionPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/definitions/94299034-d45f-4e9a-8ed5-6bd5c7bb7ada";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelineDefinitionOptions model
    DeleteTektonPipelineDefinitionOptions deleteTektonPipelineDefinitionOptionsModel = new DeleteTektonPipelineDefinitionOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .definitionId("94299034-d45f-4e9a-8ed5-6bd5c7bb7ada")
      .build();

    // Invoke deleteTektonPipelineDefinition() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipelineDefinition(deleteTektonPipelineDefinitionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelineDefinitionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipelineDefinition operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelineDefinitionWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelineDefinitionWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelineDefinitionWOptions();
  }

  // Test the deleteTektonPipelineDefinition operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelineDefinitionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipelineDefinition(null).execute();
  }

  // Test the listTektonPipelineProperties operation with a valid options model parameter
  @Test
  public void testListTektonPipelinePropertiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}]}";
    String listTektonPipelinePropertiesPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/properties";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTektonPipelinePropertiesOptions model
    ListTektonPipelinePropertiesOptions listTektonPipelinePropertiesOptionsModel = new ListTektonPipelinePropertiesOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .name("prod")
      .type(java.util.Arrays.asList("secure", "text"))
      .sort("name")
      .build();

    // Invoke listTektonPipelineProperties() with a valid options model and verify the result
    Response<PropertiesCollection> response = cdTektonPipelineService.listTektonPipelineProperties(listTektonPipelinePropertiesOptionsModel).execute();
    assertNotNull(response);
    PropertiesCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTektonPipelinePropertiesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("name"), "prod");
    assertEquals(query.get("type"), RequestUtils.join(java.util.Arrays.asList("secure", "text"), ","));
    assertEquals(query.get("sort"), "name");
  }

  // Test the listTektonPipelineProperties operation with and without retries enabled
  @Test
  public void testListTektonPipelinePropertiesWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testListTektonPipelinePropertiesWOptions();

    cdTektonPipelineService.disableRetries();
    testListTektonPipelinePropertiesWOptions();
  }

  // Test the listTektonPipelineProperties operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelinePropertiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.listTektonPipelineProperties(null).execute();
  }

  // Test the createTektonPipelineProperties operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelinePropertiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String createTektonPipelinePropertiesPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/properties";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateTektonPipelinePropertiesOptions model
    CreateTektonPipelinePropertiesOptions createTektonPipelinePropertiesOptionsModel = new CreateTektonPipelinePropertiesOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .name("key1")
      .value("https://github.com/IBM/tekton-tutorial.git")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("text")
      .path("testString")
      .build();

    // Invoke createTektonPipelineProperties() with a valid options model and verify the result
    Response<Property> response = cdTektonPipelineService.createTektonPipelineProperties(createTektonPipelinePropertiesOptionsModel).execute();
    assertNotNull(response);
    Property responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelinePropertiesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipelineProperties operation with and without retries enabled
  @Test
  public void testCreateTektonPipelinePropertiesWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelinePropertiesWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelinePropertiesWOptions();
  }

  // Test the createTektonPipelineProperties operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelinePropertiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.createTektonPipelineProperties(null).execute();
  }

  // Test the getTektonPipelineProperty operation with a valid options model parameter
  @Test
  public void testGetTektonPipelinePropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String getTektonPipelinePropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelinePropertyOptions model
    GetTektonPipelinePropertyOptions getTektonPipelinePropertyOptionsModel = new GetTektonPipelinePropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .propertyName("debug-pipeline")
      .build();

    // Invoke getTektonPipelineProperty() with a valid options model and verify the result
    Response<Property> response = cdTektonPipelineService.getTektonPipelineProperty(getTektonPipelinePropertyOptionsModel).execute();
    assertNotNull(response);
    Property responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelinePropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineProperty operation with and without retries enabled
  @Test
  public void testGetTektonPipelinePropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelinePropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelinePropertyWOptions();
  }

  // Test the getTektonPipelineProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelinePropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineProperty(null).execute();
  }

  // Test the replaceTektonPipelineProperty operation with a valid options model parameter
  @Test
  public void testReplaceTektonPipelinePropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String replaceTektonPipelinePropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceTektonPipelinePropertyOptions model
    ReplaceTektonPipelinePropertyOptions replaceTektonPipelinePropertyOptionsModel = new ReplaceTektonPipelinePropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .propertyName("debug-pipeline")
      .name("key1")
      .value("https://github.com/IBM/tekton-tutorial.git")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("text")
      .path("testString")
      .build();

    // Invoke replaceTektonPipelineProperty() with a valid options model and verify the result
    Response<Property> response = cdTektonPipelineService.replaceTektonPipelineProperty(replaceTektonPipelinePropertyOptionsModel).execute();
    assertNotNull(response);
    Property responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceTektonPipelinePropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceTektonPipelineProperty operation with and without retries enabled
  @Test
  public void testReplaceTektonPipelinePropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testReplaceTektonPipelinePropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testReplaceTektonPipelinePropertyWOptions();
  }

  // Test the replaceTektonPipelineProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceTektonPipelinePropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.replaceTektonPipelineProperty(null).execute();
  }

  // Test the deleteTektonPipelineProperty operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelinePropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelinePropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelinePropertyOptions model
    DeleteTektonPipelinePropertyOptions deleteTektonPipelinePropertyOptionsModel = new DeleteTektonPipelinePropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .propertyName("debug-pipeline")
      .build();

    // Invoke deleteTektonPipelineProperty() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipelineProperty(deleteTektonPipelinePropertyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelinePropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipelineProperty operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelinePropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelinePropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelinePropertyWOptions();
  }

  // Test the deleteTektonPipelineProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelinePropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipelineProperty(null).execute();
  }

  // Test the listTektonPipelineTriggers operation with a valid options model parameter
  @Test
  public void testListTektonPipelineTriggersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"triggers\": [{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}]}";
    String listTektonPipelineTriggersPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTektonPipelineTriggersOptions model
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

    // Invoke listTektonPipelineTriggers() with a valid options model and verify the result
    Response<TriggersCollection> response = cdTektonPipelineService.listTektonPipelineTriggers(listTektonPipelineTriggersOptionsModel).execute();
    assertNotNull(response);
    TriggersCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTektonPipelineTriggersPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("type"), "manual,scm");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("event_listener"), "testString");
    assertEquals(query.get("worker.id"), "testString");
    assertEquals(query.get("worker.name"), "testString");
    assertEquals(query.get("disabled"), "true");
    assertEquals(query.get("tags"), "tag1,tag2");
  }

  // Test the listTektonPipelineTriggers operation with and without retries enabled
  @Test
  public void testListTektonPipelineTriggersWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testListTektonPipelineTriggersWOptions();

    cdTektonPipelineService.disableRetries();
    testListTektonPipelineTriggersWOptions();
  }

  // Test the listTektonPipelineTriggers operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelineTriggersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.listTektonPipelineTriggers(null).execute();
  }

  // Test the createTektonPipelineTrigger operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelineTriggerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}";
    String createTektonPipelineTriggerPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Worker model
    Worker workerModel = new Worker.Builder()
      .name("testString")
      .type("testString")
      .id("public")
      .build();

    // Construct an instance of the GenericSecret model
    GenericSecret genericSecretModel = new GenericSecret.Builder()
      .type("token_matches")
      .value("testString")
      .source("header")
      .keyName("testString")
      .algorithm("md4")
      .build();

    // Construct an instance of the TriggerScmSource model
    TriggerScmSource triggerScmSourceModel = new TriggerScmSource.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .serviceInstanceId("testString")
      .build();

    // Construct an instance of the Events model
    Events eventsModel = new Events.Builder()
      .push(true)
      .pullRequestClosed(true)
      .pullRequest(true)
      .build();

    // Construct an instance of the CreateTektonPipelineTriggerOptions model
    CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptionsModel = new CreateTektonPipelineTriggerOptions.Builder()
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

    // Invoke createTektonPipelineTrigger() with a valid options model and verify the result
    Response<Trigger> response = cdTektonPipelineService.createTektonPipelineTrigger(createTektonPipelineTriggerOptionsModel).execute();
    assertNotNull(response);
    Trigger responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelineTriggerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipelineTrigger operation with and without retries enabled
  @Test
  public void testCreateTektonPipelineTriggerWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelineTriggerWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelineTriggerWOptions();
  }

  // Test the createTektonPipelineTrigger operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineTriggerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.createTektonPipelineTrigger(null).execute();
  }

  // Test the getTektonPipelineTrigger operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineTriggerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}";
    String getTektonPipelineTriggerPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineTriggerOptions model
    GetTektonPipelineTriggerOptions getTektonPipelineTriggerOptionsModel = new GetTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .build();

    // Invoke getTektonPipelineTrigger() with a valid options model and verify the result
    Response<Trigger> response = cdTektonPipelineService.getTektonPipelineTrigger(getTektonPipelineTriggerOptionsModel).execute();
    assertNotNull(response);
    Trigger responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineTriggerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineTrigger operation with and without retries enabled
  @Test
  public void testGetTektonPipelineTriggerWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineTriggerWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineTriggerWOptions();
  }

  // Test the getTektonPipelineTrigger operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineTriggerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineTrigger(null).execute();
  }

  // Test the updateTektonPipelineTrigger operation with a valid options model parameter
  @Test
  public void testUpdateTektonPipelineTriggerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}";
    String updateTektonPipelineTriggerPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Worker model
    Worker workerModel = new Worker.Builder()
      .name("testString")
      .type("testString")
      .id("testString")
      .build();

    // Construct an instance of the GenericSecret model
    GenericSecret genericSecretModel = new GenericSecret.Builder()
      .type("token_matches")
      .value("testString")
      .source("header")
      .keyName("testString")
      .algorithm("md4")
      .build();

    // Construct an instance of the TriggerScmSource model
    TriggerScmSource triggerScmSourceModel = new TriggerScmSource.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .serviceInstanceId("testString")
      .build();

    // Construct an instance of the Events model
    Events eventsModel = new Events.Builder()
      .push(true)
      .pullRequestClosed(true)
      .pullRequest(true)
      .build();

    // Construct an instance of the TriggerPatch model
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

    // Construct an instance of the UpdateTektonPipelineTriggerOptions model
    UpdateTektonPipelineTriggerOptions updateTektonPipelineTriggerOptionsModel = new UpdateTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .triggerPatch(triggerPatchModelAsPatch)
      .build();

    // Invoke updateTektonPipelineTrigger() with a valid options model and verify the result
    Response<Trigger> response = cdTektonPipelineService.updateTektonPipelineTrigger(updateTektonPipelineTriggerOptionsModel).execute();
    assertNotNull(response);
    Trigger responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTektonPipelineTriggerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateTektonPipelineTrigger operation with and without retries enabled
  @Test
  public void testUpdateTektonPipelineTriggerWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testUpdateTektonPipelineTriggerWOptions();

    cdTektonPipelineService.disableRetries();
    testUpdateTektonPipelineTriggerWOptions();
  }

  // Test the updateTektonPipelineTrigger operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTektonPipelineTriggerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.updateTektonPipelineTrigger(null).execute();
  }

  // Test the deleteTektonPipelineTrigger operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelineTriggerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelineTriggerPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelineTriggerOptions model
    DeleteTektonPipelineTriggerOptions deleteTektonPipelineTriggerOptionsModel = new DeleteTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .build();

    // Invoke deleteTektonPipelineTrigger() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipelineTrigger(deleteTektonPipelineTriggerOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelineTriggerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipelineTrigger operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelineTriggerWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelineTriggerWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelineTriggerWOptions();
  }

  // Test the deleteTektonPipelineTrigger operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelineTriggerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipelineTrigger(null).execute();
  }

  // Test the duplicateTektonPipelineTrigger operation with a valid options model parameter
  @Test
  public void testDuplicateTektonPipelineTriggerWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"type\": \"type\", \"name\": \"start-deploy\", \"href\": \"href\", \"event_listener\": \"eventListener\", \"id\": \"id\", \"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}], \"tags\": [\"tags\"], \"worker\": {\"name\": \"name\", \"type\": \"type\", \"id\": \"id\"}, \"max_concurrent_runs\": 4, \"disabled\": true}";
    String duplicateTektonPipelineTriggerPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/duplicate";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the DuplicateTektonPipelineTriggerOptions model
    DuplicateTektonPipelineTriggerOptions duplicateTektonPipelineTriggerOptionsModel = new DuplicateTektonPipelineTriggerOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .sourceTriggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .name("triggerName")
      .build();

    // Invoke duplicateTektonPipelineTrigger() with a valid options model and verify the result
    Response<Trigger> response = cdTektonPipelineService.duplicateTektonPipelineTrigger(duplicateTektonPipelineTriggerOptionsModel).execute();
    assertNotNull(response);
    Trigger responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, duplicateTektonPipelineTriggerPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the duplicateTektonPipelineTrigger operation with and without retries enabled
  @Test
  public void testDuplicateTektonPipelineTriggerWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDuplicateTektonPipelineTriggerWOptions();

    cdTektonPipelineService.disableRetries();
    testDuplicateTektonPipelineTriggerWOptions();
  }

  // Test the duplicateTektonPipelineTrigger operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDuplicateTektonPipelineTriggerNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.duplicateTektonPipelineTrigger(null).execute();
  }

  // Test the listTektonPipelineTriggerProperties operation with a valid options model parameter
  @Test
  public void testListTektonPipelineTriggerPropertiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"properties\": [{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\", \"href\": \"href\"}]}";
    String listTektonPipelineTriggerPropertiesPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/properties";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTektonPipelineTriggerPropertiesOptions model
    ListTektonPipelineTriggerPropertiesOptions listTektonPipelineTriggerPropertiesOptionsModel = new ListTektonPipelineTriggerPropertiesOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .name("prod")
      .type("secure,text")
      .sort("name")
      .build();

    // Invoke listTektonPipelineTriggerProperties() with a valid options model and verify the result
    Response<TriggerPropertiesCollection> response = cdTektonPipelineService.listTektonPipelineTriggerProperties(listTektonPipelineTriggerPropertiesOptionsModel).execute();
    assertNotNull(response);
    TriggerPropertiesCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTektonPipelineTriggerPropertiesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("name"), "prod");
    assertEquals(query.get("type"), "secure,text");
    assertEquals(query.get("sort"), "name");
  }

  // Test the listTektonPipelineTriggerProperties operation with and without retries enabled
  @Test
  public void testListTektonPipelineTriggerPropertiesWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testListTektonPipelineTriggerPropertiesWOptions();

    cdTektonPipelineService.disableRetries();
    testListTektonPipelineTriggerPropertiesWOptions();
  }

  // Test the listTektonPipelineTriggerProperties operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTektonPipelineTriggerPropertiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.listTektonPipelineTriggerProperties(null).execute();
  }

  // Test the createTektonPipelineTriggerProperties operation with a valid options model parameter
  @Test
  public void testCreateTektonPipelineTriggerPropertiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String createTektonPipelineTriggerPropertiesPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/properties";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateTektonPipelineTriggerPropertiesOptions model
    CreateTektonPipelineTriggerPropertiesOptions createTektonPipelineTriggerPropertiesOptionsModel = new CreateTektonPipelineTriggerPropertiesOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .name("key1")
      .value("https://github.com/IBM/tekton-tutorial.git")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("text")
      .path("testString")
      .build();

    // Invoke createTektonPipelineTriggerProperties() with a valid options model and verify the result
    Response<TriggerProperty> response = cdTektonPipelineService.createTektonPipelineTriggerProperties(createTektonPipelineTriggerPropertiesOptionsModel).execute();
    assertNotNull(response);
    TriggerProperty responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTektonPipelineTriggerPropertiesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTektonPipelineTriggerProperties operation with and without retries enabled
  @Test
  public void testCreateTektonPipelineTriggerPropertiesWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testCreateTektonPipelineTriggerPropertiesWOptions();

    cdTektonPipelineService.disableRetries();
    testCreateTektonPipelineTriggerPropertiesWOptions();
  }

  // Test the createTektonPipelineTriggerProperties operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTektonPipelineTriggerPropertiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.createTektonPipelineTriggerProperties(null).execute();
  }

  // Test the getTektonPipelineTriggerProperty operation with a valid options model parameter
  @Test
  public void testGetTektonPipelineTriggerPropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String getTektonPipelineTriggerPropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTektonPipelineTriggerPropertyOptions model
    GetTektonPipelineTriggerPropertyOptions getTektonPipelineTriggerPropertyOptionsModel = new GetTektonPipelineTriggerPropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .propertyName("debug-pipeline")
      .build();

    // Invoke getTektonPipelineTriggerProperty() with a valid options model and verify the result
    Response<TriggerProperty> response = cdTektonPipelineService.getTektonPipelineTriggerProperty(getTektonPipelineTriggerPropertyOptionsModel).execute();
    assertNotNull(response);
    TriggerProperty responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTektonPipelineTriggerPropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getTektonPipelineTriggerProperty operation with and without retries enabled
  @Test
  public void testGetTektonPipelineTriggerPropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testGetTektonPipelineTriggerPropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testGetTektonPipelineTriggerPropertyWOptions();
  }

  // Test the getTektonPipelineTriggerProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTektonPipelineTriggerPropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.getTektonPipelineTriggerProperty(null).execute();
  }

  // Test the replaceTektonPipelineTriggerProperty operation with a valid options model parameter
  @Test
  public void testReplaceTektonPipelineTriggerPropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"value\": \"value\", \"enum\": [\"xEnum\"], \"type\": \"secure\", \"path\": \"path\"}";
    String replaceTektonPipelineTriggerPropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ReplaceTektonPipelineTriggerPropertyOptions model
    ReplaceTektonPipelineTriggerPropertyOptions replaceTektonPipelineTriggerPropertyOptionsModel = new ReplaceTektonPipelineTriggerPropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .propertyName("debug-pipeline")
      .name("key1")
      .value("https://github.com/IBM/tekton-tutorial.git")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("text")
      .path("testString")
      .build();

    // Invoke replaceTektonPipelineTriggerProperty() with a valid options model and verify the result
    Response<TriggerProperty> response = cdTektonPipelineService.replaceTektonPipelineTriggerProperty(replaceTektonPipelineTriggerPropertyOptionsModel).execute();
    assertNotNull(response);
    TriggerProperty responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceTektonPipelineTriggerPropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceTektonPipelineTriggerProperty operation with and without retries enabled
  @Test
  public void testReplaceTektonPipelineTriggerPropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testReplaceTektonPipelineTriggerPropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testReplaceTektonPipelineTriggerPropertyWOptions();
  }

  // Test the replaceTektonPipelineTriggerProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceTektonPipelineTriggerPropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.replaceTektonPipelineTriggerProperty(null).execute();
  }

  // Test the deleteTektonPipelineTriggerProperty operation with a valid options model parameter
  @Test
  public void testDeleteTektonPipelineTriggerPropertyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTektonPipelineTriggerPropertyPath = "/tekton_pipelines/94619026-912b-4d92-8f51-6c74f0692d90/triggers/1bb892a1-2e04-4768-a369-b1159eace147/properties/debug-pipeline";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTektonPipelineTriggerPropertyOptions model
    DeleteTektonPipelineTriggerPropertyOptions deleteTektonPipelineTriggerPropertyOptionsModel = new DeleteTektonPipelineTriggerPropertyOptions.Builder()
      .pipelineId("94619026-912b-4d92-8f51-6c74f0692d90")
      .triggerId("1bb892a1-2e04-4768-a369-b1159eace147")
      .propertyName("debug-pipeline")
      .build();

    // Invoke deleteTektonPipelineTriggerProperty() with a valid options model and verify the result
    Response<Void> response = cdTektonPipelineService.deleteTektonPipelineTriggerProperty(deleteTektonPipelineTriggerPropertyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTektonPipelineTriggerPropertyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTektonPipelineTriggerProperty operation with and without retries enabled
  @Test
  public void testDeleteTektonPipelineTriggerPropertyWRetries() throws Throwable {
    cdTektonPipelineService.enableRetries(4, 30);
    testDeleteTektonPipelineTriggerPropertyWOptions();

    cdTektonPipelineService.disableRetries();
    testDeleteTektonPipelineTriggerPropertyWOptions();
  }

  // Test the deleteTektonPipelineTriggerProperty operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTektonPipelineTriggerPropertyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdTektonPipelineService.deleteTektonPipelineTriggerProperty(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    cdTektonPipelineService = null;
  }

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv()
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    cdTektonPipelineService = CdTektonPipeline.newInstance(serviceName);
    String url = server.url("/").toString();
    cdTektonPipelineService.setServiceUrl(url);
  }
}