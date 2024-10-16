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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.96.0-d6dec9d7-20241008-212902
 */

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolchainEventOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.CreateToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.DeleteToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.DeleteToolchainOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.GetToolByIdOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.GetToolchainByIdOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ListToolchainsOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ListToolsOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.Toolchain;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainEventPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainTool;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolCollection;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPatch;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.ToolchainToolPost;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolOptions;
import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model.UpdateToolchainOptions;
import com.ibm.cloud.continuous_delivery.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CdToolchain extends BaseService {

  /**
   * Default service name used when configuring the `CdToolchain` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "cd_toolchain";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://api.us-south.devops.cloud.ibm.com/toolchain/v2";

  private static final Map<String, String> _regionalEndpoints;
  static {
    Map<String, String> m = new HashMap<>();
    m.put("us-south", "https://api.us-south.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the us-south region

    m.put("us-east", "https://api.us-east.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the us-east region

    m.put("eu-de", "https://api.eu-de.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the eu-de region

    m.put("eu-gb", "https://api.eu-gb.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the eu-gb region

    m.put("jp-osa", "https://api.jp-osa.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the jp-osa region

    m.put("jp-tok", "https://api.jp-tok.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the jp-tok region

    m.put("au-syd", "https://api.au-syd.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the au-syd region

    m.put("ca-tor", "https://api.ca-tor.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the ca-tor region

    m.put("br-sao", "https://api.br-sao.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the br-sao region

    m.put("eu-es", "https://api.eu-es.devops.cloud.ibm.com/toolchain/v2"); // The toolchain API endpoint in the eu-es region
    _regionalEndpoints = Collections.unmodifiableMap(m);
  }

  /**
   * Returns the service URL associated with the specified region.
   * @param region a string representing the region
   * @return the service URL associated with the specified region or null
   * if no mapping for the region exists
   */
  public static String getServiceUrlForRegion(String region) {
    return _regionalEndpoints.get(region);
  }

 /**
   * Class method which constructs an instance of the `CdToolchain` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `CdToolchain` client using external configuration
   */
  public static CdToolchain newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `CdToolchain` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `CdToolchain` client using external configuration
   */
  public static CdToolchain newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    CdToolchain service = new CdToolchain(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `CdToolchain` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CdToolchain(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get a list of toolchains.
   *
   * Returns a list of toolchains that the caller is authorized to access and that meets the provided query parameters.
   *
   * @param listToolchainsOptions the {@link ListToolchainsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainCollection}
   */
  public ServiceCall<ToolchainCollection> listToolchains(ListToolchainsOptions listToolchainsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listToolchainsOptions,
      "listToolchainsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "listToolchains");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("resource_group_id", String.valueOf(listToolchainsOptions.resourceGroupId()));
    if (listToolchainsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listToolchainsOptions.limit()));
    }
    if (listToolchainsOptions.start() != null) {
      builder.query("start", String.valueOf(listToolchainsOptions.start()));
    }
    if (listToolchainsOptions.name() != null) {
      builder.query("name", String.valueOf(listToolchainsOptions.name()));
    }
    ResponseConverter<ToolchainCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a toolchain.
   *
   * Creates a new toolchain based off the provided parameters in the body.
   *
   * @param createToolchainOptions the {@link CreateToolchainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainPost}
   */
  public ServiceCall<ToolchainPost> createToolchain(CreateToolchainOptions createToolchainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createToolchainOptions,
      "createToolchainOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "createToolchain");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createToolchainOptions.name());
    contentJson.addProperty("resource_group_id", createToolchainOptions.resourceGroupId());
    if (createToolchainOptions.description() != null) {
      contentJson.addProperty("description", createToolchainOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ToolchainPost> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainPost>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a toolchain.
   *
   * Returns data for a single toolchain identified by its ID.
   *
   * @param getToolchainByIdOptions the {@link GetToolchainByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Toolchain}
   */
  public ServiceCall<Toolchain> getToolchainById(GetToolchainByIdOptions getToolchainByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getToolchainByIdOptions,
      "getToolchainByIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", getToolchainByIdOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "getToolchainById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Toolchain> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Toolchain>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a toolchain.
   *
   * Delete the toolchain with the specified ID.
   *
   * @param deleteToolchainOptions the {@link DeleteToolchainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteToolchain(DeleteToolchainOptions deleteToolchainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteToolchainOptions,
      "deleteToolchainOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", deleteToolchainOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "deleteToolchain");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a toolchain.
   *
   * Update the toolchain with the specified ID.
   *
   * @param updateToolchainOptions the {@link UpdateToolchainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainPatch}
   */
  public ServiceCall<ToolchainPatch> updateToolchain(UpdateToolchainOptions updateToolchainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateToolchainOptions,
      "updateToolchainOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", updateToolchainOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "updateToolchain");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls().toJson(updateToolchainOptions.toolchainPrototypePatch()), "application/merge-patch+json");
    ResponseConverter<ToolchainPatch> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainPatch>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a toolchain event.
   *
   * Creates and sends a custom event to each Event Notifications instance configured as a tool into the toolchain. This
   * operation will fail if no Event Notifications instances are configured into the toolchain.
   *
   * @param createToolchainEventOptions the {@link CreateToolchainEventOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainEventPost}
   */
  public ServiceCall<ToolchainEventPost> createToolchainEvent(CreateToolchainEventOptions createToolchainEventOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createToolchainEventOptions,
      "createToolchainEventOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", createToolchainEventOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/events", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "createToolchainEvent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("title", createToolchainEventOptions.title());
    contentJson.addProperty("description", createToolchainEventOptions.description());
    contentJson.addProperty("content_type", createToolchainEventOptions.contentType());
    if (createToolchainEventOptions.data() != null) {
      contentJson.add("data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createToolchainEventOptions.data()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ToolchainEventPost> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainEventPost>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of tools bound to a toolchain.
   *
   * Returns a list of tools bound to a toolchain that the caller is authorized to access and that meet the provided
   * query parameters.
   *
   * @param listToolsOptions the {@link ListToolsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainToolCollection}
   */
  public ServiceCall<ToolchainToolCollection> listTools(ListToolsOptions listToolsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listToolsOptions,
      "listToolsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", listToolsOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/tools", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "listTools");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listToolsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listToolsOptions.limit()));
    }
    if (listToolsOptions.start() != null) {
      builder.query("start", String.valueOf(listToolsOptions.start()));
    }
    ResponseConverter<ToolchainToolCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainToolCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a tool.
   *
   * Provisions a new tool based off the provided parameters in the body and binds it to the specified toolchain.
   *
   * @param createToolOptions the {@link CreateToolOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainToolPost}
   */
  public ServiceCall<ToolchainToolPost> createTool(CreateToolOptions createToolOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createToolOptions,
      "createToolOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", createToolOptions.toolchainId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/tools", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "createTool");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("tool_type_id", createToolOptions.toolTypeId());
    if (createToolOptions.name() != null) {
      contentJson.addProperty("name", createToolOptions.name());
    }
    if (createToolOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createToolOptions.parameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ToolchainToolPost> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainToolPost>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a tool.
   *
   * Returns a tool that is bound to the provided toolchain.
   *
   * @param getToolByIdOptions the {@link GetToolByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainTool}
   */
  public ServiceCall<ToolchainTool> getToolById(GetToolByIdOptions getToolByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getToolByIdOptions,
      "getToolByIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", getToolByIdOptions.toolchainId());
    pathParamsMap.put("tool_id", getToolByIdOptions.toolId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/tools/{tool_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "getToolById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ToolchainTool> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainTool>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a tool.
   *
   * Delete the tool with the specified ID.
   *
   * @param deleteToolOptions the {@link DeleteToolOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTool(DeleteToolOptions deleteToolOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteToolOptions,
      "deleteToolOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", deleteToolOptions.toolchainId());
    pathParamsMap.put("tool_id", deleteToolOptions.toolId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/tools/{tool_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "deleteTool");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a tool.
   *
   * Update the tool with the specified ID.
   *
   * @param updateToolOptions the {@link UpdateToolOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ToolchainToolPatch}
   */
  public ServiceCall<ToolchainToolPatch> updateTool(UpdateToolOptions updateToolOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateToolOptions,
      "updateToolOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("toolchain_id", updateToolOptions.toolchainId());
    pathParamsMap.put("tool_id", updateToolOptions.toolId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/toolchains/{toolchain_id}/tools/{tool_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_toolchain", "v2", "updateTool");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls().toJson(updateToolOptions.toolchainToolPrototypePatch()), "application/merge-patch+json");
    ResponseConverter<ToolchainToolPatch> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ToolchainToolPatch>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
