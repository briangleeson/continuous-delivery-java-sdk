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

package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2;

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.*;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.CdToolchain;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.*;
import com.ibm.cloud.continuous_delivery.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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
  public CdToolchain toolchainSvc = null;
  public CdTektonPipeline pipelineSvc = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  // Variables to hold link values
  String toolchainIdLink = null;
  String githubToolIdLink = null;
  String pipelineIdLink = null;
  String definitionIdLink = null;
  String propIdLink = null;
  String triggerIdLink = null;
  String triggerPropIdLink = null;
  String runIdLink = null;
  String rerunIdLink = null;
  String propertyName = "prop1";
  String triggerName = "start-deploy";
  String triggerPropName = "triggerProp1";

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

    toolchainSvc = CdToolchain.newInstance();
    pipelineSvc = CdTektonPipeline.newInstance();
    assertNotNull(toolchainSvc);
    assertNotNull(toolchainSvc.getServiceUrl());
    assertNotNull(pipelineSvc);
    assertNotNull(pipelineSvc.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CdTektonPipeline.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(pipelineSvc.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateToolchain() throws Exception {
    try {
      CreateToolchainOptions createToolchainOptions = new CreateToolchainOptions.Builder()
        .name("PipelineJavaSdkTest")
        .resourceGroupId(config.get("RESOURCE_GROUP_ID"))
        .description("A sample toolchain to test the API")
        .build();

      // Invoke operation
      Response<ToolchainPost> response = toolchainSvc.createToolchain(createToolchainOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ToolchainPost toolchainPostResult = response.getResult();

      assertNotNull(toolchainPostResult);
      toolchainIdLink = toolchainPostResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateToolchain" })
  public void testCreateGithubTool() throws Exception {
    try {
      Map<String, Object> paramList = new HashMap<>();
      paramList.put("repo_url", "https://github.com/open-toolchain/hello-tekton.git");
      paramList.put("type", "link");
      paramList.put("enable_traceability", false);
      paramList.put("has_issues", false);
      CreateToolOptions createToolOptions = new CreateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolTypeId("githubconsolidated")
        .name("app-repo-1")
        .parameters(paramList)
        .build();

      // Invoke operation
      Response<ToolchainToolPost> response = toolchainSvc.createTool(createToolOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ToolchainToolPost toolchainToolPostResult = response.getResult();

      assertNotNull(toolchainToolPostResult);
      githubToolIdLink = toolchainToolPostResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateToolchain" })
  public void testCreatePipelineTool() throws Exception {
    try {
      Map<String, Object> paramList = new HashMap<>();
      paramList.put("type", "tekton");
      paramList.put("name", "tekton-pipeline");
      CreateToolOptions createToolOptions = new CreateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolTypeId("pipeline")
        .parameters(paramList)
        .build();

      // Invoke operation
      Response<ToolchainToolPost> response = toolchainSvc.createTool(createToolOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ToolchainToolPost toolchainToolPostResult = response.getResult();

      assertNotNull(toolchainToolPostResult);
      pipelineIdLink = toolchainToolPostResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreatePipelineTool" })
  public void testCreateTektonPipeline() throws Exception {
    try {
      WorkerIdentity workerIdentityModel = new WorkerIdentity.Builder()
        .id("public")
        .build();

      CreateTektonPipelineOptions createTektonPipelineOptions = new CreateTektonPipelineOptions.Builder()
        .id(pipelineIdLink)
        .enableNotifications(false)
        .enablePartialCloning(false)
        .worker(workerIdentityModel)
        .build();

      // Invoke operation
      Response<TektonPipeline> response = pipelineSvc.createTektonPipeline(createTektonPipelineOptions).execute();
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

  @Test(dependsOnMethods = { "testCreateTektonPipeline" })
  public void testGetTektonPipeline() throws Exception {
    try {
      GetTektonPipelineOptions getTektonPipelineOptions = new GetTektonPipelineOptions.Builder()
        .id(pipelineIdLink)
        .build();

      // Invoke operation
      Response<TektonPipeline> response = pipelineSvc.getTektonPipeline(getTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TektonPipeline tektonPipelineResult = response.getResult();
      assertNotNull(tektonPipelineResult);
      assertNotNull(tektonPipelineResult.getHref());
      assertEquals(tektonPipelineResult.getId(), pipelineIdLink);
      assertEquals(tektonPipelineResult.getName(), "tekton-pipeline");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetTektonPipeline" })
  public void testUpdateTektonPipeline() throws Exception {
    try {
      TektonPipelinePatch tektonPipelinePatchModel = new TektonPipelinePatch.Builder()
        .enableNotifications(true)
        .enablePartialCloning(true)
        .build();
      Map<String, Object> tektonPipelinePatchModelAsPatch = tektonPipelinePatchModel.asPatch();

      UpdateTektonPipelineOptions updateTektonPipelineOptions = new UpdateTektonPipelineOptions.Builder()
        .id(pipelineIdLink)
        .tektonPipelinePatch(tektonPipelinePatchModelAsPatch)
        .build();

      // Invoke operation
      Response<TektonPipeline> response = pipelineSvc.updateTektonPipeline(updateTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TektonPipeline tektonPipelineResult = response.getResult();
      assertNotNull(tektonPipelineResult);
      assertNotNull(tektonPipelineResult.getHref());
      assertEquals(tektonPipelineResult.getId(), pipelineIdLink);
      assertEquals(tektonPipelineResult.getName(), "tekton-pipeline");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline" })
  public void testCreateTektonPipelineDefinition() throws Exception {
    try {
      DefinitionSourceProperties definitionSourcePropertiesModel = new DefinitionSourceProperties.Builder()
        .url("https://github.com/open-toolchain/hello-tekton.git")
        .branch("master")
        .path(".tekton")
        .build();

      DefinitionSource definitionSourceModel = new DefinitionSource.Builder()
        .type("git")
        .xProperties(definitionSourcePropertiesModel)
        .build();

      CreateTektonPipelineDefinitionOptions createTektonPipelineDefinitionOptions = new CreateTektonPipelineDefinitionOptions.Builder()
        .pipelineId(pipelineIdLink)
        .source(definitionSourceModel)
        .build();

      // Invoke operation
      Response<Definition> response = pipelineSvc.createTektonPipelineDefinition(createTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Definition definitionResult = response.getResult();
      assertNotNull(definitionResult);
      assertNotNull(definitionResult.getHref());
      assertNotNull(definitionResult.getId());
      definitionIdLink = definitionResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineDefinition" })
  public void testGetTektonPipelineDefinition() throws Exception {
    try {
      GetTektonPipelineDefinitionOptions getTektonPipelineDefinitionOptions = new GetTektonPipelineDefinitionOptions.Builder()
        .pipelineId(pipelineIdLink)
        .definitionId(definitionIdLink)
        .build();

      // Invoke operation
      Response<Definition> response = pipelineSvc.getTektonPipelineDefinition(getTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Definition definitionResult = response.getResult();
      assertNotNull(definitionResult);
      assertNotNull(definitionResult.getHref());
      assertNotNull(definitionResult.getId());
      assertNotNull(definitionResult.getSource());
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineDefinition" })
  public void testListTektonPipelineDefinitions() throws Exception {
    try {
      ListTektonPipelineDefinitionsOptions listTektonPipelineDefinitionsOptions = new ListTektonPipelineDefinitionsOptions.Builder()
        .pipelineId(pipelineIdLink)
        .build();

      // Invoke operation
      Response<DefinitionsCollection> response = pipelineSvc.listTektonPipelineDefinitions(listTektonPipelineDefinitionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      DefinitionsCollection definitionsCollectionResult = response.getResult();
      assertNotNull(definitionsCollectionResult);
      assertNotNull(definitionsCollectionResult.getDefinitions());
      assertNotNull(definitionsCollectionResult.getDefinitions().get(0));
      assertNotNull(definitionsCollectionResult.getDefinitions().get(0).getHref());
      assertNotNull(definitionsCollectionResult.getDefinitions().get(0).getId());
      assertNotNull(definitionsCollectionResult.getDefinitions().get(0).getSource());
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline" })
  public void testCreateTektonPipelineProperties() throws Exception {
    try {
      CreateTektonPipelinePropertiesOptions createTektonPipelinePropertiesOptions = new CreateTektonPipelinePropertiesOptions.Builder()
        .pipelineId(pipelineIdLink)
        .name(propertyName)
        .type("text")
        .value("prop1Value")
        .build();

      // Invoke operation
      Response<Property> response = pipelineSvc.createTektonPipelineProperties(createTektonPipelinePropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Property propertyResult = response.getResult();
      assertNotNull(propertyResult);
      assertNotNull(propertyResult.href());
      assertEquals(propertyResult.name(), propertyName);
      assertEquals(propertyResult.type(), "text");
      assertEquals(propertyResult.value(), "prop1Value");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineProperties" })
  public void testGetTektonPipelineProperty() throws Exception {
    try {
      GetTektonPipelinePropertyOptions getTektonPipelinePropertyOptions = new GetTektonPipelinePropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .propertyName(propertyName)
        .build();

      // Invoke operation
      Response<Property> response = pipelineSvc.getTektonPipelineProperty(getTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Property propertyResult = response.getResult();
      assertNotNull(propertyResult);
      assertNotNull(propertyResult.href());
      assertEquals(propertyResult.name(), propertyName);
      assertEquals(propertyResult.type(), "text");
      assertEquals(propertyResult.value(), "prop1Value");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetTektonPipelineProperty" })
  public void testReplaceTektonPipelineProperty() throws Exception {
    try {
      ReplaceTektonPipelinePropertyOptions replaceTektonPipelinePropertyOptions = new ReplaceTektonPipelinePropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .propertyName(propertyName)
        .name(propertyName)
        .type("text")
        .value("editedValue")
        .build();

      // Invoke operation
      Response<Property> response = pipelineSvc.replaceTektonPipelineProperty(replaceTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Property propertyResult = response.getResult();
      assertNotNull(propertyResult);
      assertNotNull(propertyResult.href());
      assertEquals(propertyResult.name(), propertyName);
      assertEquals(propertyResult.type(), "text");
      assertEquals(propertyResult.value(), "editedValue");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineProperties", "testReplaceTektonPipelineProperty" })
  public void testListTektonPipelineProperties() throws Exception {
    try {
      ListTektonPipelinePropertiesOptions listTektonPipelinePropertiesOptions = new ListTektonPipelinePropertiesOptions.Builder()
        .pipelineId(pipelineIdLink)
        .sort("name")
        .build();

      // Invoke operation
      Response<PropertiesCollection> response = pipelineSvc.listTektonPipelineProperties(listTektonPipelinePropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PropertiesCollection propertiesCollectionResult = response.getResult();
      assertNotNull(propertiesCollectionResult);
      Property propertyResult = propertiesCollectionResult.getXProperties().get(0);
      assertNotNull(propertyResult.href());
      assertEquals(propertyResult.name(), propertyName);
      assertEquals(propertyResult.type(), "text");
      assertEquals(propertyResult.value(), "editedValue");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline" })
  public void testCreateTektonPipelineTrigger() throws Exception {
    try {
      CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptions = new CreateTektonPipelineTriggerOptions.Builder()
        .pipelineId(pipelineIdLink)
        .type("manual")
        .name("Manual1")
        .eventListener("listener")
        .tags(java.util.Arrays.asList("tag1"))
        .build();

      // Invoke operation
      Response<Trigger> response = pipelineSvc.createTektonPipelineTrigger(createTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Trigger triggerResult = response.getResult();
      assertNotNull(triggerResult);
      assertNotNull(triggerResult.getHref());
      assertNotNull(triggerResult.getId());
      triggerIdLink = triggerResult.getId();
      assertEquals(triggerResult.getName(), "Manual1");
      assertEquals(triggerResult.getType(), "manual");
      assertEquals(triggerResult.getEventListener(), "listener");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineTrigger" })
  public void testGetTektonPipelineTrigger() throws Exception {
    try {
      GetTektonPipelineTriggerOptions getTektonPipelineTriggerOptions = new GetTektonPipelineTriggerOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .build();

      // Invoke operation
      Response<Trigger> response = pipelineSvc.getTektonPipelineTrigger(getTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Trigger triggerResult = response.getResult();
      assertNotNull(triggerResult);
      assertNotNull(triggerResult.getHref());
      assertEquals(triggerResult.getName(), "Manual1");
      assertEquals(triggerResult.getType(), "manual");
      assertEquals(triggerResult.isEnabled(), true);
      assertEquals(triggerResult.getEventListener(), "listener");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetTektonPipelineTrigger" })
  public void testUpdateTektonPipelineTrigger() throws Exception {
    try {
      TriggerPatch triggerPatchModel = new TriggerPatch.Builder()
        .type("manual")
        .name(triggerName)
        .eventListener("listener")
        .tags(java.util.Arrays.asList("tag2"))
        .maxConcurrentRuns(Long.valueOf("2"))
        .build();
      Map<String, Object> triggerPatchModelAsPatch = triggerPatchModel.asPatch();

      UpdateTektonPipelineTriggerOptions updateTektonPipelineTriggerOptions = new UpdateTektonPipelineTriggerOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .triggerPatch(triggerPatchModelAsPatch)
        .build();

      // Invoke operation
      Response<Trigger> response = pipelineSvc.updateTektonPipelineTrigger(updateTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Trigger triggerResult = response.getResult();
      assertNotNull(triggerResult);
      assertNotNull(triggerResult.getHref());
      assertEquals(triggerResult.getName(), triggerName);
      assertEquals(triggerResult.getType(), "manual");
      assertEquals(triggerResult.isEnabled(), true);
      assertEquals(triggerResult.getEventListener(), "listener");
      assertEquals(triggerResult.getMaxConcurrentRuns(), 2);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateTektonPipelineTrigger" })
  public void testDuplicateTektonPipelineTrigger() throws Exception {
    try {
      DuplicateTektonPipelineTriggerOptions duplicateTektonPipelineTriggerOptions = new DuplicateTektonPipelineTriggerOptions.Builder()
        .pipelineId(pipelineIdLink)
        .sourceTriggerId(triggerIdLink)
        .name("duplicateTrigger")
        .build();

      // Invoke operation
      Response<Trigger> response = pipelineSvc.duplicateTektonPipelineTrigger(duplicateTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      Trigger triggerResult = response.getResult();
      assertNotNull(triggerResult);
      assertNotNull(triggerResult.getHref());
      assertEquals(triggerResult.getName(), "duplicateTrigger");
      assertEquals(triggerResult.getType(), "manual");
      assertEquals(triggerResult.isEnabled(), true);
      assertEquals(triggerResult.getEventListener(), "listener");
      assertEquals(triggerResult.getMaxConcurrentRuns(), 2);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineTrigger", "testDuplicateTektonPipelineTrigger" })
  public void testListTektonPipelineTriggers() throws Exception {
    try {
      ListTektonPipelineTriggersOptions listTektonPipelineTriggersOptions = new ListTektonPipelineTriggersOptions.Builder()
        .pipelineId(pipelineIdLink)
        .type("manual")
        .build();

      // Invoke operation
      Response<TriggersCollection> response = pipelineSvc.listTektonPipelineTriggers(listTektonPipelineTriggersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggersCollection triggersCollectionResult = response.getResult();
      assertNotNull(triggersCollectionResult);
      assertNotNull(triggersCollectionResult.getTriggers());
      assertEquals(triggersCollectionResult.getTriggers().size(), 2);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineTrigger" })
  public void testCreateTektonPipelineTriggerProperties() throws Exception {
    try {
      CreateTektonPipelineTriggerPropertiesOptions createTektonPipelineTriggerPropertiesOptions = new CreateTektonPipelineTriggerPropertiesOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .name(propertyName)
        .type("text")
        .value(triggerPropName)
        .build();

      // Invoke operation
      Response<TriggerProperty> response = pipelineSvc.createTektonPipelineTriggerProperties(createTektonPipelineTriggerPropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      TriggerProperty triggerPropertyResult = response.getResult();
      assertNotNull(triggerPropertyResult);
      assertNotNull(triggerPropertyResult.getHref());
      assertEquals(triggerPropertyResult.getName(), propertyName);
      assertEquals(triggerPropertyResult.getType(), "text");
      assertEquals(triggerPropertyResult.getValue(), triggerPropName);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testUpdateTektonPipelineTrigger", "testCreateTektonPipelineDefinition" })
  public void testCreateTektonPipelineRun() throws Exception {
    try {
      PipelineRunTrigger pipelineRunTriggerModel = new PipelineRunTrigger.Builder()
        .name(triggerName)
        .xProperties(java.util.Collections.singletonMap("runProp1", "runProp1"))
        .secureProperties(java.util.Collections.singletonMap("runSecProp1", "runSecProp1"))
        .headers(java.util.Collections.singletonMap("runHeader1", "runHeader1"))
        .body(java.util.Collections.singletonMap("runBody1", "runBody1"))
        .build();

      CreateTektonPipelineRunOptions createTektonPipelineRunOptions = new CreateTektonPipelineRunOptions.Builder()
        .pipelineId(pipelineIdLink)
        .trigger(pipelineRunTriggerModel)
        .build();

      // Invoke operation
      Response<PipelineRun> response = pipelineSvc.createTektonPipelineRun(createTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PipelineRun pipelineRunResult = response.getResult();
      assertNotNull(pipelineRunResult);
      assertNotNull(pipelineRunResult.getId());
      runIdLink = pipelineRunResult.getId();
      assertNotNull(pipelineRunResult.getHref());
      assertNotNull(pipelineRunResult.getStatus());
      assertNotNull(pipelineRunResult.getXProperties());
      assertNotNull(pipelineRunResult.getEventParamsBlob());
      assertNotNull(pipelineRunResult.getRunUrl());
      assertEquals(pipelineRunResult.getListenerName(), "listener");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineTriggerProperties" })
  public void testGetTektonPipelineTriggerProperty() throws Exception {
    try {
      GetTektonPipelineTriggerPropertyOptions getTektonPipelineTriggerPropertyOptions = new GetTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .propertyName(propertyName)
        .build();

      // Invoke operation
      Response<TriggerProperty> response = pipelineSvc.getTektonPipelineTriggerProperty(getTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerProperty triggerPropertyResult = response.getResult();
      assertNotNull(triggerPropertyResult);
      assertNotNull(triggerPropertyResult.getHref());
      assertEquals(triggerPropertyResult.getName(), propertyName);
      assertEquals(triggerPropertyResult.getType(), "text");
      assertEquals(triggerPropertyResult.getValue(), triggerPropName);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetTektonPipelineTriggerProperty" })
  public void testReplaceTektonPipelineTriggerProperty() throws Exception {
    try {
      ReplaceTektonPipelineTriggerPropertyOptions replaceTektonPipelineTriggerPropertyOptions = new ReplaceTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .propertyName(propertyName)
        .name(propertyName)
        .type("text")
        .value("triggerPropEdited")
        .build();

      // Invoke operation
      Response<TriggerProperty> response = pipelineSvc.replaceTektonPipelineTriggerProperty(replaceTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerProperty triggerPropertyResult = response.getResult();
      assertNotNull(triggerPropertyResult);
      assertNotNull(triggerPropertyResult.getHref());
      assertEquals(triggerPropertyResult.getName(), propertyName);
      assertEquals(triggerPropertyResult.getType(), "text");
      assertEquals(triggerPropertyResult.getValue(), "triggerPropEdited");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testReplaceTektonPipelineTriggerProperty" })
  public void testListTektonPipelineTriggerProperties() throws Exception {
    try {
      ListTektonPipelineTriggerPropertiesOptions listTektonPipelineTriggerPropertiesOptions = new ListTektonPipelineTriggerPropertiesOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .type("text")
        .sort("name")
        .build();

      // Invoke operation
      Response<TriggerPropertiesCollection> response = pipelineSvc.listTektonPipelineTriggerProperties(listTektonPipelineTriggerPropertiesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      TriggerPropertiesCollection triggerPropertiesCollectionResult = response.getResult();
      assertNotNull(triggerPropertiesCollectionResult);
      assertEquals(triggerPropertiesCollectionResult.getXProperties().size(), 1);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineRun" })
  public void testGetTektonPipelineRun() throws Exception {
    try {
      GetTektonPipelineRunOptions getTektonPipelineRunOptions = new GetTektonPipelineRunOptions.Builder()
        .pipelineId(pipelineIdLink)
        .id(runIdLink)
        .build();

      // Invoke operation
      Response<PipelineRun> response = pipelineSvc.getTektonPipelineRun(getTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PipelineRun pipelineRunResult = response.getResult();
      assertNotNull(pipelineRunResult);
      assertNotNull(pipelineRunResult.getHref());
      assertNotNull(pipelineRunResult.getStatus());
      assertNotNull(pipelineRunResult.getXProperties());
      assertNotNull(pipelineRunResult.getEventParamsBlob());
      assertNotNull(pipelineRunResult.getRunUrl());
      assertEquals(pipelineRunResult.getListenerName(), "listener");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineRun" })
  public void testRerunTektonPipelineRun() throws Exception {
    try {
      RerunTektonPipelineRunOptions rerunTektonPipelineRunOptions = new RerunTektonPipelineRunOptions.Builder()
        .pipelineId(pipelineIdLink)
        .id(runIdLink)
        .build();

      // Invoke operation
      Response<PipelineRun> response = pipelineSvc.rerunTektonPipelineRun(rerunTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      PipelineRun pipelineRunResult = response.getResult();
      assertNotNull(pipelineRunResult);
      assertNotNull(pipelineRunResult.getId());
      rerunIdLink = pipelineRunResult.getId();
      assertNotNull(pipelineRunResult.getHref());
      assertNotNull(pipelineRunResult.getStatus());
      assertNotNull(pipelineRunResult.getXProperties());
      assertNotNull(pipelineRunResult.getEventParamsBlob());
      assertNotNull(pipelineRunResult.getRunUrl());
      assertEquals(pipelineRunResult.getListenerName(), "listener");
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineRun", "testRerunTektonPipelineRun" })
  public void testListTektonPipelineRuns() throws Exception {
    try {
      ListTektonPipelineRunsOptions listTektonPipelineRunsOptions = new ListTektonPipelineRunsOptions.Builder()
        .pipelineId(pipelineIdLink)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PipelineRunsCollection> response = pipelineSvc.listTektonPipelineRuns(listTektonPipelineRunsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PipelineRunsCollection pipelineRunsCollectionResult = response.getResult();
      assertNotNull(pipelineRunsCollectionResult);
      assertNotNull(pipelineRunsCollectionResult.getPipelineRuns());
      assertEquals(pipelineRunsCollectionResult.getPipelineRuns().size(), 2);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipelineRun", "testRerunTektonPipelineRun" })
  public void testListTektonPipelineRunsWithPager() throws Exception {
    try {
      ListTektonPipelineRunsOptions options = new ListTektonPipelineRunsOptions.Builder()
        .pipelineId(pipelineIdLink)
        .limit(Long.valueOf("1"))
        .triggerName(triggerName)
        .build();

      // Test getNext().
      List<PipelineRun> allResults = new ArrayList<>();
      TektonPipelineRunsPager pager = new TektonPipelineRunsPager(pipelineSvc, options);
      while (pager.hasNext()) {
        List<PipelineRun> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new TektonPipelineRunsPager(pipelineSvc, options);
      List<PipelineRun> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

/*
  @Test(dependsOnMethods = { "testRerunTektonPipelineRun" })
  public void testGetTektonPipelineRunLogs() throws Exception {
    try {
      GetTektonPipelineRunLogsOptions getTektonPipelineRunLogsOptions = new GetTektonPipelineRunLogsOptions.Builder()
        .pipelineId(pipelineIdLink)
        .id(runIdLink)
        .build();

      // Invoke operation
      Response<LogsCollection> response = pipelineSvc.getTektonPipelineRunLogs(getTektonPipelineRunLogsOptions).execute();
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

  @Test(dependsOnMethods = { "testGetTektonPipelineRunLogs" })
  public void testGetTektonPipelineRunLogContent() throws Exception {
    try {
      GetTektonPipelineRunLogContentOptions getTektonPipelineRunLogContentOptions = new GetTektonPipelineRunLogContentOptions.Builder()
        .pipelineId(pipelineIdLink)
        .pipelineRunId(runIdLink)
        .id()
        .build();

      // Invoke operation
      Response<StepLog> response = pipelineSvc.getTektonPipelineRunLogContent(getTektonPipelineRunLogContentOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      StepLog stepLogResult = response.getResult();
      assertNotNull(stepLogResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }
*/


  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testCreateTektonPipelineRun", "testGetTektonPipelineRun", "testListTektonPipelineRuns", "testListTektonPipelineRunsWithPager" })
  public void testDeleteTektonPipelineRun() throws Exception {
    try {
      DeleteTektonPipelineRunOptions deleteTektonPipelineRunOptions = new DeleteTektonPipelineRunOptions.Builder()
        .pipelineId(pipelineIdLink)
        .id(runIdLink)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipelineRun(deleteTektonPipelineRunOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testReplaceTektonPipelineTriggerProperty", "testCreateTektonPipelineRun" })
  public void testDeleteTektonPipelineTriggerProperty() throws Exception {
    try {
      DeleteTektonPipelineTriggerPropertyOptions deleteTektonPipelineTriggerPropertyOptions = new DeleteTektonPipelineTriggerPropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .propertyName(triggerPropName)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipelineTriggerProperty(deleteTektonPipelineTriggerPropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testUpdateTektonPipelineTrigger", "testCreateTektonPipelineRun", "testDeleteTektonPipelineTriggerProperty" })
  public void testDeleteTektonPipelineTrigger() throws Exception {
    try {
      DeleteTektonPipelineTriggerOptions deleteTektonPipelineTriggerOptions = new DeleteTektonPipelineTriggerOptions.Builder()
        .pipelineId(pipelineIdLink)
        .triggerId(triggerIdLink)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipelineTrigger(deleteTektonPipelineTriggerOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testReplaceTektonPipelineProperty", "testDeleteTektonPipelineTrigger" })
  public void testDeleteTektonPipelineProperty() throws Exception {
    try {
      DeleteTektonPipelinePropertyOptions deleteTektonPipelinePropertyOptions = new DeleteTektonPipelinePropertyOptions.Builder()
        .pipelineId(pipelineIdLink)
        .propertyName(propertyName)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipelineProperty(deleteTektonPipelinePropertyOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testCreateTektonPipelineDefinition", "testCreateTektonPipelineRun", "testDeleteTektonPipelineProperty" })
  public void testDeleteTektonPipelineDefinition() throws Exception {
    try {
      DeleteTektonPipelineDefinitionOptions deleteTektonPipelineDefinitionOptions = new DeleteTektonPipelineDefinitionOptions.Builder()
        .pipelineId(pipelineIdLink)
        .definitionId(definitionIdLink)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipelineDefinition(deleteTektonPipelineDefinitionOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTektonPipeline", "testDeleteTektonPipelineDefinition" })
  public void testDeleteTektonPipeline() throws Exception {
    try {
      DeleteTektonPipelineOptions deleteTektonPipelineOptions = new DeleteTektonPipelineOptions.Builder()
        .id(pipelineIdLink)
        .build();

      // Invoke operation
      Response<Void> response = pipelineSvc.deleteTektonPipeline(deleteTektonPipelineOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateToolchain", "testDeleteTektonPipeline" })
  public void testDeleteToolchain() throws Exception {
    try {
      DeleteToolchainOptions deleteToolchainOptions = new DeleteToolchainOptions.Builder()
        .toolchainId(toolchainIdLink)
        .build();

      // Invoke operation
      Response<Void> response = toolchainSvc.deleteToolchain(deleteToolchainOptions).execute();
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
