/*
 * (C) Copyright IBM Corp. 2024.
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
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.Toolchain;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeData;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPrototypeDataApplicationJson;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainModel;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainTool;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CdToolchain service.
 */
public class CdToolchainTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CdToolchain cdToolchainService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new CdToolchain(serviceName, null);
  }

  // Test the getServiceUrlForRegion() method
  @Test
  public void testGetServiceUrlForRegion() throws Throwable {
    assertNull(CdToolchain.getServiceUrlForRegion("INVALID_REGION"));
    assertEquals(CdToolchain.getServiceUrlForRegion("us-south"), "https://api.us-south.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("us-east"), "https://api.us-east.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("eu-de"), "https://api.eu-de.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("eu-gb"), "https://api.eu-gb.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("jp-osa"), "https://api.jp-osa.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("jp-tok"), "https://api.jp-tok.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("au-syd"), "https://api.au-syd.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("ca-tor"), "https://api.ca-tor.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("br-sao"), "https://api.br-sao.devops.cloud.ibm.com/toolchain/v2");
    assertEquals(CdToolchain.getServiceUrlForRegion("eu-es"), "https://api.eu-es.devops.cloud.ibm.com/toolchain/v2");
  }

  // Test the listToolchains operation with a valid options model parameter
  @Test
  public void testListToolchainsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 10, \"limit\": 5, \"first\": {\"href\": \"href\"}, \"previous\": {\"start\": \"start\", \"href\": \"href\"}, \"next\": {\"start\": \"start\", \"href\": \"href\"}, \"last\": {\"start\": \"start\", \"href\": \"href\"}, \"toolchains\": [{\"id\": \"id\", \"name\": \"TestToolchainV2\", \"description\": \"A sample toolchain to test the API\", \"account_id\": \"accountId\", \"location\": \"location\", \"resource_group_id\": \"6a9a01f2cff54a7f966f803d92877123\", \"crn\": \"crn\", \"href\": \"href\", \"ui_href\": \"uiHref\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\"}]}";
    String listToolchainsPath = "/toolchains";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListToolchainsOptions model
    ListToolchainsOptions listToolchainsOptionsModel = new ListToolchainsOptions.Builder()
      .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
      .limit(Long.valueOf("10"))
      .start("testString")
      .name("TestToolchainV2")
      .build();

    // Invoke listToolchains() with a valid options model and verify the result
    Response<ToolchainCollection> response = cdToolchainService.listToolchains(listToolchainsOptionsModel).execute();
    assertNotNull(response);
    ToolchainCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listToolchainsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("resource_group_id"), "6a9a01f2cff54a7f966f803d92877123");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("name"), "TestToolchainV2");
  }

  // Test the listToolchains operation with and without retries enabled
  @Test
  public void testListToolchainsWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testListToolchainsWOptions();

    cdToolchainService.disableRetries();
    testListToolchainsWOptions();
  }

  // Test the listToolchains operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListToolchainsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.listToolchains(null).execute();
  }

  // Test the listToolchains operation using the ToolchainsPager.getNext() method
  @Test
  public void testListToolchainsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"toolchains\":[{\"id\":\"id\",\"name\":\"TestToolchainV2\",\"description\":\"A sample toolchain to test the API\",\"account_id\":\"accountId\",\"location\":\"location\",\"resource_group_id\":\"6a9a01f2cff54a7f966f803d92877123\",\"crn\":\"crn\",\"href\":\"href\",\"ui_href\":\"uiHref\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"toolchains\":[{\"id\":\"id\",\"name\":\"TestToolchainV2\",\"description\":\"A sample toolchain to test the API\",\"account_id\":\"accountId\",\"location\":\"location\",\"resource_group_id\":\"6a9a01f2cff54a7f966f803d92877123\",\"crn\":\"crn\",\"href\":\"href\",\"ui_href\":\"uiHref\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\"}],\"limit\":1}";
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

    ListToolchainsOptions listToolchainsOptions = new ListToolchainsOptions.Builder()
      .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
      .limit(Long.valueOf("10"))
      .name("TestToolchainV2")
      .build();

    List<ToolchainModel> allResults = new ArrayList<>();
    ToolchainsPager pager = new ToolchainsPager(cdToolchainService, listToolchainsOptions);
    while (pager.hasNext()) {
      List<ToolchainModel> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listToolchains operation using the ToolchainsPager.getAll() method
  @Test
  public void testListToolchainsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"toolchains\":[{\"id\":\"id\",\"name\":\"TestToolchainV2\",\"description\":\"A sample toolchain to test the API\",\"account_id\":\"accountId\",\"location\":\"location\",\"resource_group_id\":\"6a9a01f2cff54a7f966f803d92877123\",\"crn\":\"crn\",\"href\":\"href\",\"ui_href\":\"uiHref\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"toolchains\":[{\"id\":\"id\",\"name\":\"TestToolchainV2\",\"description\":\"A sample toolchain to test the API\",\"account_id\":\"accountId\",\"location\":\"location\",\"resource_group_id\":\"6a9a01f2cff54a7f966f803d92877123\",\"crn\":\"crn\",\"href\":\"href\",\"ui_href\":\"uiHref\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\"}],\"limit\":1}";
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

    ListToolchainsOptions listToolchainsOptions = new ListToolchainsOptions.Builder()
      .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
      .limit(Long.valueOf("10"))
      .name("TestToolchainV2")
      .build();

    ToolchainsPager pager = new ToolchainsPager(cdToolchainService, listToolchainsOptions);
    List<ToolchainModel> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createToolchain operation with a valid options model parameter
  @Test
  public void testCreateToolchainWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"TestToolchainV2\", \"description\": \"A sample toolchain to test the API\", \"account_id\": \"accountId\", \"location\": \"location\", \"resource_group_id\": \"6a9a01f2cff54a7f966f803d92877123\", \"crn\": \"crn\", \"href\": \"href\", \"ui_href\": \"uiHref\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\"}";
    String createToolchainPath = "/toolchains";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateToolchainOptions model
    CreateToolchainOptions createToolchainOptionsModel = new CreateToolchainOptions.Builder()
      .name("TestToolchainV2")
      .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
      .description("A sample toolchain to test the API")
      .build();

    // Invoke createToolchain() with a valid options model and verify the result
    Response<ToolchainPost> response = cdToolchainService.createToolchain(createToolchainOptionsModel).execute();
    assertNotNull(response);
    ToolchainPost responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createToolchainPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createToolchain operation with and without retries enabled
  @Test
  public void testCreateToolchainWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testCreateToolchainWOptions();

    cdToolchainService.disableRetries();
    testCreateToolchainWOptions();
  }

  // Test the createToolchain operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateToolchainNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.createToolchain(null).execute();
  }

  // Test the getToolchainById operation with a valid options model parameter
  @Test
  public void testGetToolchainByIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"TestToolchainV2\", \"description\": \"A sample toolchain to test the API\", \"account_id\": \"accountId\", \"location\": \"location\", \"resource_group_id\": \"6a9a01f2cff54a7f966f803d92877123\", \"crn\": \"crn\", \"href\": \"href\", \"ui_href\": \"uiHref\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\"}";
    String getToolchainByIdPath = "/toolchains/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetToolchainByIdOptions model
    GetToolchainByIdOptions getToolchainByIdOptionsModel = new GetToolchainByIdOptions.Builder()
      .toolchainId("testString")
      .build();

    // Invoke getToolchainById() with a valid options model and verify the result
    Response<Toolchain> response = cdToolchainService.getToolchainById(getToolchainByIdOptionsModel).execute();
    assertNotNull(response);
    Toolchain responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getToolchainByIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getToolchainById operation with and without retries enabled
  @Test
  public void testGetToolchainByIdWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testGetToolchainByIdWOptions();

    cdToolchainService.disableRetries();
    testGetToolchainByIdWOptions();
  }

  // Test the getToolchainById operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetToolchainByIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.getToolchainById(null).execute();
  }

  // Test the deleteToolchain operation with a valid options model parameter
  @Test
  public void testDeleteToolchainWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteToolchainPath = "/toolchains/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteToolchainOptions model
    DeleteToolchainOptions deleteToolchainOptionsModel = new DeleteToolchainOptions.Builder()
      .toolchainId("testString")
      .build();

    // Invoke deleteToolchain() with a valid options model and verify the result
    Response<Void> response = cdToolchainService.deleteToolchain(deleteToolchainOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteToolchainPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteToolchain operation with and without retries enabled
  @Test
  public void testDeleteToolchainWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testDeleteToolchainWOptions();

    cdToolchainService.disableRetries();
    testDeleteToolchainWOptions();
  }

  // Test the deleteToolchain operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteToolchainNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.deleteToolchain(null).execute();
  }

  // Test the updateToolchain operation with a valid options model parameter
  @Test
  public void testUpdateToolchainWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"TestToolchainV2\", \"description\": \"A sample toolchain to test the API\", \"account_id\": \"accountId\", \"location\": \"location\", \"resource_group_id\": \"6a9a01f2cff54a7f966f803d92877123\", \"crn\": \"crn\", \"href\": \"href\", \"ui_href\": \"uiHref\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\"}";
    String updateToolchainPath = "/toolchains/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ToolchainPrototypePatch model
    ToolchainPrototypePatch toolchainPrototypePatchModel = new ToolchainPrototypePatch.Builder()
      .name("newToolchainName")
      .description("New toolchain description")
      .build();
    Map<String, Object> toolchainPrototypePatchModelAsPatch = toolchainPrototypePatchModel.asPatch();

    // Construct an instance of the UpdateToolchainOptions model
    UpdateToolchainOptions updateToolchainOptionsModel = new UpdateToolchainOptions.Builder()
      .toolchainId("testString")
      .toolchainPrototypePatch(toolchainPrototypePatchModelAsPatch)
      .build();

    // Invoke updateToolchain() with a valid options model and verify the result
    Response<ToolchainPatch> response = cdToolchainService.updateToolchain(updateToolchainOptionsModel).execute();
    assertNotNull(response);
    ToolchainPatch responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateToolchainPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateToolchain operation with and without retries enabled
  @Test
  public void testUpdateToolchainWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testUpdateToolchainWOptions();

    cdToolchainService.disableRetries();
    testUpdateToolchainWOptions();
  }

  // Test the updateToolchain operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateToolchainNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.updateToolchain(null).execute();
  }

  // Test the createToolchainEvent operation with a valid options model parameter
  @Test
  public void testCreateToolchainEventWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\"}";
    String createToolchainEventPath = "/toolchains/testString/events";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ToolchainEventPrototypeDataApplicationJson model
    ToolchainEventPrototypeDataApplicationJson toolchainEventPrototypeDataApplicationJsonModel = new ToolchainEventPrototypeDataApplicationJson.Builder()
      .content(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the ToolchainEventPrototypeData model
    ToolchainEventPrototypeData toolchainEventPrototypeDataModel = new ToolchainEventPrototypeData.Builder()
      .applicationJson(toolchainEventPrototypeDataApplicationJsonModel)
      .build();

    // Construct an instance of the CreateToolchainEventOptions model
    CreateToolchainEventOptions createToolchainEventOptionsModel = new CreateToolchainEventOptions.Builder()
      .toolchainId("testString")
      .title("My-custom-event")
      .description("This is my custom event")
      .contentType("application/json")
      .data(toolchainEventPrototypeDataModel)
      .build();

    // Invoke createToolchainEvent() with a valid options model and verify the result
    Response<ToolchainEventPost> response = cdToolchainService.createToolchainEvent(createToolchainEventOptionsModel).execute();
    assertNotNull(response);
    ToolchainEventPost responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createToolchainEventPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createToolchainEvent operation with and without retries enabled
  @Test
  public void testCreateToolchainEventWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testCreateToolchainEventWOptions();

    cdToolchainService.disableRetries();
    testCreateToolchainEventWOptions();
  }

  // Test the createToolchainEvent operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateToolchainEventNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.createToolchainEvent(null).execute();
  }

  // Test the listTools operation with a valid options model parameter
  @Test
  public void testListToolsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"start\": \"start\", \"href\": \"href\"}, \"next\": {\"start\": \"start\", \"href\": \"href\"}, \"last\": {\"start\": \"start\", \"href\": \"href\"}, \"tools\": [{\"id\": \"id\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"tool_type_id\": \"toolTypeId\", \"toolchain_id\": \"toolchainId\", \"toolchain_crn\": \"toolchainCrn\", \"href\": \"href\", \"referent\": {\"ui_href\": \"uiHref\", \"api_href\": \"apiHref\"}, \"name\": \"MyTool\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"state\": \"configured\"}]}";
    String listToolsPath = "/toolchains/testString/tools";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListToolsOptions model
    ListToolsOptions listToolsOptionsModel = new ListToolsOptions.Builder()
      .toolchainId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listTools() with a valid options model and verify the result
    Response<ToolchainToolCollection> response = cdToolchainService.listTools(listToolsOptionsModel).execute();
    assertNotNull(response);
    ToolchainToolCollection responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listToolsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listTools operation with and without retries enabled
  @Test
  public void testListToolsWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testListToolsWOptions();

    cdToolchainService.disableRetries();
    testListToolsWOptions();
  }

  // Test the listTools operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListToolsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.listTools(null).execute();
  }

  // Test the listTools operation using the ToolsPager.getNext() method
  @Test
  public void testListToolsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"tools\":[{\"id\":\"id\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"tool_type_id\":\"toolTypeId\",\"toolchain_id\":\"toolchainId\",\"toolchain_crn\":\"toolchainCrn\",\"href\":\"href\",\"referent\":{\"ui_href\":\"uiHref\",\"api_href\":\"apiHref\"},\"name\":\"MyTool\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"parameters\":{\"anyKey\":\"anyValue\"},\"state\":\"configured\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"tools\":[{\"id\":\"id\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"tool_type_id\":\"toolTypeId\",\"toolchain_id\":\"toolchainId\",\"toolchain_crn\":\"toolchainCrn\",\"href\":\"href\",\"referent\":{\"ui_href\":\"uiHref\",\"api_href\":\"apiHref\"},\"name\":\"MyTool\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"parameters\":{\"anyKey\":\"anyValue\"},\"state\":\"configured\"}]}";
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

    ListToolsOptions listToolsOptions = new ListToolsOptions.Builder()
      .toolchainId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ToolModel> allResults = new ArrayList<>();
    ToolsPager pager = new ToolsPager(cdToolchainService, listToolsOptions);
    while (pager.hasNext()) {
      List<ToolModel> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listTools operation using the ToolsPager.getAll() method
  @Test
  public void testListToolsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"start\":\"1\"},\"total_count\":2,\"limit\":1,\"tools\":[{\"id\":\"id\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"tool_type_id\":\"toolTypeId\",\"toolchain_id\":\"toolchainId\",\"toolchain_crn\":\"toolchainCrn\",\"href\":\"href\",\"referent\":{\"ui_href\":\"uiHref\",\"api_href\":\"apiHref\"},\"name\":\"MyTool\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"parameters\":{\"anyKey\":\"anyValue\"},\"state\":\"configured\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"tools\":[{\"id\":\"id\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"tool_type_id\":\"toolTypeId\",\"toolchain_id\":\"toolchainId\",\"toolchain_crn\":\"toolchainCrn\",\"href\":\"href\",\"referent\":{\"ui_href\":\"uiHref\",\"api_href\":\"apiHref\"},\"name\":\"MyTool\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"parameters\":{\"anyKey\":\"anyValue\"},\"state\":\"configured\"}]}";
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

    ListToolsOptions listToolsOptions = new ListToolsOptions.Builder()
      .toolchainId("testString")
      .limit(Long.valueOf("10"))
      .build();

    ToolsPager pager = new ToolsPager(cdToolchainService, listToolsOptions);
    List<ToolModel> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createTool operation with a valid options model parameter
  @Test
  public void testCreateToolWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"tool_type_id\": \"toolTypeId\", \"toolchain_id\": \"toolchainId\", \"toolchain_crn\": \"toolchainCrn\", \"href\": \"href\", \"referent\": {\"ui_href\": \"uiHref\", \"api_href\": \"apiHref\"}, \"name\": \"MyTool\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"state\": \"configured\"}";
    String createToolPath = "/toolchains/testString/tools";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateToolOptions model
    CreateToolOptions createToolOptionsModel = new CreateToolOptions.Builder()
      .toolchainId("testString")
      .toolTypeId("draservicebroker")
      .name("testString")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Invoke createTool() with a valid options model and verify the result
    Response<ToolchainToolPost> response = cdToolchainService.createTool(createToolOptionsModel).execute();
    assertNotNull(response);
    ToolchainToolPost responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createToolPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTool operation with and without retries enabled
  @Test
  public void testCreateToolWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testCreateToolWOptions();

    cdToolchainService.disableRetries();
    testCreateToolWOptions();
  }

  // Test the createTool operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateToolNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.createTool(null).execute();
  }

  // Test the getToolById operation with a valid options model parameter
  @Test
  public void testGetToolByIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"tool_type_id\": \"toolTypeId\", \"toolchain_id\": \"toolchainId\", \"toolchain_crn\": \"toolchainCrn\", \"href\": \"href\", \"referent\": {\"ui_href\": \"uiHref\", \"api_href\": \"apiHref\"}, \"name\": \"MyTool\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"state\": \"configured\"}";
    String getToolByIdPath = "/toolchains/testString/tools/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetToolByIdOptions model
    GetToolByIdOptions getToolByIdOptionsModel = new GetToolByIdOptions.Builder()
      .toolchainId("testString")
      .toolId("testString")
      .build();

    // Invoke getToolById() with a valid options model and verify the result
    Response<ToolchainTool> response = cdToolchainService.getToolById(getToolByIdOptionsModel).execute();
    assertNotNull(response);
    ToolchainTool responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getToolByIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getToolById operation with and without retries enabled
  @Test
  public void testGetToolByIdWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testGetToolByIdWOptions();

    cdToolchainService.disableRetries();
    testGetToolByIdWOptions();
  }

  // Test the getToolById operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetToolByIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.getToolById(null).execute();
  }

  // Test the deleteTool operation with a valid options model parameter
  @Test
  public void testDeleteToolWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteToolPath = "/toolchains/testString/tools/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteToolOptions model
    DeleteToolOptions deleteToolOptionsModel = new DeleteToolOptions.Builder()
      .toolchainId("testString")
      .toolId("testString")
      .build();

    // Invoke deleteTool() with a valid options model and verify the result
    Response<Void> response = cdToolchainService.deleteTool(deleteToolOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteToolPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTool operation with and without retries enabled
  @Test
  public void testDeleteToolWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testDeleteToolWOptions();

    cdToolchainService.disableRetries();
    testDeleteToolWOptions();
  }

  // Test the deleteTool operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteToolNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.deleteTool(null).execute();
  }

  // Test the updateTool operation with a valid options model parameter
  @Test
  public void testUpdateToolWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"tool_type_id\": \"toolTypeId\", \"toolchain_id\": \"toolchainId\", \"toolchain_crn\": \"toolchainCrn\", \"href\": \"href\", \"referent\": {\"ui_href\": \"uiHref\", \"api_href\": \"apiHref\"}, \"name\": \"MyTool\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"parameters\": {\"anyKey\": \"anyValue\"}, \"state\": \"configured\"}";
    String updateToolPath = "/toolchains/testString/tools/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ToolchainToolPrototypePatch model
    ToolchainToolPrototypePatch toolchainToolPrototypePatchModel = new ToolchainToolPrototypePatch.Builder()
      .name("MyTool")
      .toolTypeId("draservicebroker")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    Map<String, Object> toolchainToolPrototypePatchModelAsPatch = toolchainToolPrototypePatchModel.asPatch();

    // Construct an instance of the UpdateToolOptions model
    UpdateToolOptions updateToolOptionsModel = new UpdateToolOptions.Builder()
      .toolchainId("testString")
      .toolId("testString")
      .toolchainToolPrototypePatch(toolchainToolPrototypePatchModelAsPatch)
      .build();

    // Invoke updateTool() with a valid options model and verify the result
    Response<ToolchainToolPatch> response = cdToolchainService.updateTool(updateToolOptionsModel).execute();
    assertNotNull(response);
    ToolchainToolPatch responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateToolPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateTool operation with and without retries enabled
  @Test
  public void testUpdateToolWRetries() throws Throwable {
    cdToolchainService.enableRetries(4, 30);
    testUpdateToolWOptions();

    cdToolchainService.disableRetries();
    testUpdateToolWOptions();
  }

  // Test the updateTool operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateToolNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    cdToolchainService.updateTool(null).execute();
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
    cdToolchainService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    cdToolchainService = CdToolchain.newInstance(serviceName);
    String url = server.url("/").toString();
    cdToolchainService.setServiceUrl(url);
  }
}