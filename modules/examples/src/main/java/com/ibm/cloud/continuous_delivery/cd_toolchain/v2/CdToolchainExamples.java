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
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainModel;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainTool;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPrototypePatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolsPager;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolchainOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the CD Toolchain service.
 *
 * The following configuration properties are assumed to be defined:
 * CD_TOOLCHAIN_URL=&lt;service base url&gt;
 * CD_TOOLCHAIN_AUTH_TYPE=iam
 * CD_TOOLCHAIN_APIKEY=&lt;IAM apikey&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class CdToolchainExamples {
  private static final Logger logger = LoggerFactory.getLogger(CdToolchainExamples.class);
  protected CdToolchainExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../cd_toolchain_v2.env");
  }

  /**
   * The main() function invokes operations of the CD Toolchain service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    CdToolchain cdToolchainService = CdToolchain.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(CdToolchain.DEFAULT_SERVICE_NAME);

    // Variables to hold link values
    String toolIdLink = null;
    String toolchainIdLink = null;

    try {
      System.out.println("createToolchain() result:");
      // begin-create_toolchain
      CreateToolchainOptions createToolchainOptions = new CreateToolchainOptions.Builder()
        .name("TestToolchainV2")
        .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
        .build();

      Response<ToolchainPost> response = cdToolchainService.createToolchain(createToolchainOptions).execute();
      ToolchainPost toolchainPost = response.getResult();

      System.out.println(toolchainPost);
      // end-create_toolchain

      toolchainIdLink = toolchainPost.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createTool() result:");
      // begin-create_tool
      CreateToolOptions createToolOptions = new CreateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolTypeId("draservicebroker")
        .build();

      Response<ToolchainToolPost> response = cdToolchainService.createTool(createToolOptions).execute();
      ToolchainToolPost toolchainToolPost = response.getResult();

      System.out.println(toolchainToolPost);
      // end-create_tool

      toolIdLink = toolchainToolPost.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listToolchains() result:");
      // begin-list_toolchains
      ListToolchainsOptions listToolchainsOptions = new ListToolchainsOptions.Builder()
        .resourceGroupId("6a9a01f2cff54a7f966f803d92877123")
        .limit(Long.valueOf("10"))
        .name("TestToolchainV2")
        .build();

      ToolchainsPager pager = new ToolchainsPager(cdToolchainService, listToolchainsOptions);
      List<ToolchainModel> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ToolchainModel> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_toolchains
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getToolchainById() result:");
      // begin-get_toolchain_by_id
      GetToolchainByIdOptions getToolchainByIdOptions = new GetToolchainByIdOptions.Builder()
        .toolchainId(toolchainIdLink)
        .build();

      Response<Toolchain> response = cdToolchainService.getToolchainById(getToolchainByIdOptions).execute();
      Toolchain toolchain = response.getResult();

      System.out.println(toolchain);
      // end-get_toolchain_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateToolchain() result:");
      // begin-update_toolchain
      ToolchainPrototypePatch toolchainPrototypePatchModel = new ToolchainPrototypePatch.Builder()
        .build();
      Map<String, Object> toolchainPrototypePatchModelAsPatch = toolchainPrototypePatchModel.asPatch();
      UpdateToolchainOptions updateToolchainOptions = new UpdateToolchainOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolchainPrototypePatch(toolchainPrototypePatchModelAsPatch)
        .build();

      Response<ToolchainPatch> response = cdToolchainService.updateToolchain(updateToolchainOptions).execute();
      ToolchainPatch toolchainPatch = response.getResult();

      System.out.println(toolchainPatch);
      // end-update_toolchain
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createToolchainEvent() result:");
      // begin-create_toolchain_event
      CreateToolchainEventOptions createToolchainEventOptions = new CreateToolchainEventOptions.Builder()
        .toolchainId(toolchainIdLink)
        .title("My-custom-event")
        .description("This is my custom event")
        .contentType("application/json")
        .build();

      Response<ToolchainEventPost> response = cdToolchainService.createToolchainEvent(createToolchainEventOptions).execute();
      ToolchainEventPost toolchainEventPost = response.getResult();

      System.out.println(toolchainEventPost);
      // end-create_toolchain_event
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTools() result:");
      // begin-list_tools
      ListToolsOptions listToolsOptions = new ListToolsOptions.Builder()
        .toolchainId(toolchainIdLink)
        .limit(Long.valueOf("10"))
        .build();

      ToolsPager pager = new ToolsPager(cdToolchainService, listToolsOptions);
      List<ToolModel> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ToolModel> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_tools
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getToolById() result:");
      // begin-get_tool_by_id
      GetToolByIdOptions getToolByIdOptions = new GetToolByIdOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .build();

      Response<ToolchainTool> response = cdToolchainService.getToolById(getToolByIdOptions).execute();
      ToolchainTool toolchainTool = response.getResult();

      System.out.println(toolchainTool);
      // end-get_tool_by_id
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateTool() result:");
      // begin-update_tool
      ToolchainToolPrototypePatch toolchainToolPrototypePatchModel = new ToolchainToolPrototypePatch.Builder()
        .build();
      Map<String, Object> toolchainToolPrototypePatchModelAsPatch = toolchainToolPrototypePatchModel.asPatch();
      UpdateToolOptions updateToolOptions = new UpdateToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .toolchainToolPrototypePatch(toolchainToolPrototypePatchModelAsPatch)
        .build();

      Response<ToolchainToolPatch> response = cdToolchainService.updateTool(updateToolOptions).execute();
      ToolchainToolPatch toolchainToolPatch = response.getResult();

      System.out.println(toolchainToolPatch);
      // end-update_tool
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_tool
      DeleteToolOptions deleteToolOptions = new DeleteToolOptions.Builder()
        .toolchainId(toolchainIdLink)
        .toolId(toolIdLink)
        .build();

      Response<Void> response = cdToolchainService.deleteTool(deleteToolOptions).execute();
      // end-delete_tool
      System.out.printf("deleteTool() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_toolchain
      DeleteToolchainOptions deleteToolchainOptions = new DeleteToolchainOptions.Builder()
        .toolchainId(toolchainIdLink)
        .build();

      Response<Void> response = cdToolchainService.deleteToolchain(deleteToolchainOptions).execute();
      // end-delete_toolchain
      System.out.printf("deleteToolchain() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
