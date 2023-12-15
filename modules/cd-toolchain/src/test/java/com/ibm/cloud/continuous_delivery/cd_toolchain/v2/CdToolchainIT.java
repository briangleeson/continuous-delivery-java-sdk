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

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2;

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolchainEventOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.DeleteToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.DeleteToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.GetToolByIdOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.GetToolchainByIdOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ListToolchainsOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ListToolsOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolModel;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolModelReferent;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.Toolchain;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionFirst;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionLast;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionNext;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollectionPrevious;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeData;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeDataApplicationJson;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainModel;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainTool;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollectionFirst;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollectionLast;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollectionNext;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollectionPrevious;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.continuous_delivery.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
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
 * Integration test class for the CdToolchain service.
 */
public class CdToolchainIT extends SdkIntegrationTestBase {
  public CdToolchain service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  // Variables to hold link values
  String toolIdLink = null;
  String toolchainIdLink = null;

  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../cd_toolchain_v2.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = CdToolchain.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CdToolchain.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateToolchain() throws Exception {
    try {
      CreateToolchainOptions createToolchainOptions = new CreateToolchainOptions.Builder()
        .name("TestToolchainV2")
        .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
        .description("A sample toolchain to test the API")
        .build();

      // Invoke operation
      Response<ToolchainPost> response = service.createToolchain(createToolchainOptions).execute();
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
  public void testCreateTool() throws Exception {
    try {
      CreateToolOptions createToolOptions = new CreateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolTypeId("draservicebroker")
        .name("testString")
        .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();

      // Invoke operation
      Response<ToolchainToolPost> response = service.createTool(createToolOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      ToolchainToolPost toolchainToolPostResult = response.getResult();

      assertNotNull(toolchainToolPostResult);
      toolIdLink = toolchainToolPostResult.getId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateTool" })
  public void testListToolchains() throws Exception {
    try {
      ListToolchainsOptions listToolchainsOptions = new ListToolchainsOptions.Builder()
        .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
        .limit(Long.valueOf("10"))
        .start("testString")
        .name("TestToolchainV2")
        .build();

      // Invoke operation
      Response<ToolchainCollection> response = service.listToolchains(listToolchainsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainCollection toolchainCollectionResult = response.getResult();

      assertNotNull(toolchainCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListToolchains" })
  public void testListToolchainsWithPager() throws Exception {
    try {
      ListToolchainsOptions options = new ListToolchainsOptions.Builder()
        .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
        .limit(Long.valueOf("10"))
        .name("TestToolchainV2")
        .build();

      // Test getNext().
      List<ToolchainModel> allResults = new ArrayList<>();
      ToolchainsPager pager = new ToolchainsPager(service, options);
      while (pager.hasNext()) {
        List<ToolchainModel> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ToolchainsPager(service, options);
      List<ToolchainModel> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListToolchains" })
  public void testGetToolchainById() throws Exception {
    try {
      GetToolchainByIdOptions getToolchainByIdOptions = new GetToolchainByIdOptions.Builder()
        .toolchainId(toolchainIdLink)
        .build();

      // Invoke operation
      Response<Toolchain> response = service.getToolchainById(getToolchainByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Toolchain toolchainResult = response.getResult();

      assertNotNull(toolchainResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetToolchainById" })
  public void testUpdateToolchain() throws Exception {
    try {
      ToolchainPrototypePatch toolchainPrototypePatchModel = new ToolchainPrototypePatch.Builder()
        .name("newToolchainName")
        .description("New toolchain description")
        .build();
      Map<String, Object> toolchainPrototypePatchModelAsPatch = toolchainPrototypePatchModel.asPatch();

      UpdateToolchainOptions updateToolchainOptions = new UpdateToolchainOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolchainPrototypePatch(toolchainPrototypePatchModelAsPatch)
        .build();

      // Invoke operation
      Response<ToolchainPatch> response = service.updateToolchain(updateToolchainOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainPatch toolchainPatchResult = response.getResult();

      assertNotNull(toolchainPatchResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateToolchain" })
  public void testCreateToolchainEvent() throws Exception {
    try {
      ToolchainEventPrototypeDataApplicationJson toolchainEventPrototypeDataApplicationJsonModel = new ToolchainEventPrototypeDataApplicationJson.Builder()
        .content(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();

      ToolchainEventPrototypeData toolchainEventPrototypeDataModel = new ToolchainEventPrototypeData.Builder()
        .applicationJson(toolchainEventPrototypeDataApplicationJsonModel)
        .textPlain("This event is dispatched because the pipeline failed")
        .build();

      CreateToolchainEventOptions createToolchainEventOptions = new CreateToolchainEventOptions.Builder()
        .toolchainId(toolchainIdLink)
        .title("My-custom-event")
        .description("This is my custom event")
        .contentType("application/json")
        .data(toolchainEventPrototypeDataModel)
        .build();

      // Invoke operation
      Response<ToolchainEventPost> response = service.createToolchainEvent(createToolchainEventOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainEventPost toolchainEventPostResult = response.getResult();

      assertNotNull(toolchainEventPostResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateToolchainEvent" })
  public void testListTools() throws Exception {
    try {
      ListToolsOptions listToolsOptions = new ListToolsOptions.Builder()
        .toolchainId(toolchainIdLink)
        .limit(Long.valueOf("10"))
        .start("testString")
        .build();

      // Invoke operation
      Response<ToolchainToolCollection> response = service.listTools(listToolsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainToolCollection toolchainToolCollectionResult = response.getResult();

      assertNotNull(toolchainToolCollectionResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListTools" })
  public void testListToolsWithPager() throws Exception {
    try {
      ListToolsOptions options = new ListToolsOptions.Builder()
        .toolchainId(toolchainIdLink)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<ToolModel> allResults = new ArrayList<>();
      ToolsPager pager = new ToolsPager(service, options);
      while (pager.hasNext()) {
        List<ToolModel> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new ToolsPager(service, options);
      List<ToolModel> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testListTools" })
  public void testGetToolById() throws Exception {
    try {
      GetToolByIdOptions getToolByIdOptions = new GetToolByIdOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .build();

      // Invoke operation
      Response<ToolchainTool> response = service.getToolById(getToolByIdOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainTool toolchainToolResult = response.getResult();

      assertNotNull(toolchainToolResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetToolById" })
  public void testUpdateTool() throws Exception {
    try {
      ToolchainToolPrototypePatch toolchainToolPrototypePatchModel = new ToolchainToolPrototypePatch.Builder()
        .name("MyTool")
        .toolTypeId("draservicebroker")
        .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
        .build();
      Map<String, Object> toolchainToolPrototypePatchModelAsPatch = toolchainToolPrototypePatchModel.asPatch();

      UpdateToolOptions updateToolOptions = new UpdateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .toolchainToolPrototypePatch(toolchainToolPrototypePatchModelAsPatch)
        .build();

      // Invoke operation
      Response<ToolchainToolPatch> response = service.updateTool(updateToolOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ToolchainToolPatch toolchainToolPatchResult = response.getResult();

      assertNotNull(toolchainToolPatchResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateTool" })
  public void testDeleteTool() throws Exception {
    try {
      DeleteToolOptions deleteToolOptions = new DeleteToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteTool(deleteToolOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testDeleteTool" })
  public void testDeleteToolchain() throws Exception {
    try {
      DeleteToolchainOptions deleteToolchainOptions = new DeleteToolchainOptions.Builder()
        .toolchainId(toolchainIdLink)
        .build();

      // Invoke operation
      Response<Void> response = service.deleteToolchain(deleteToolchainOptions).execute();
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
