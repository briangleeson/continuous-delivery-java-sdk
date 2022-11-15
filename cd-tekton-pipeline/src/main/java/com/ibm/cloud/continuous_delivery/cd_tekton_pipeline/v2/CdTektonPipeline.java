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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.58.0-ac124633-20221004-152309
 */

package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CancelTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineDefinitionOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelinePropertiesOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.CreateTektonPipelineTriggerPropertiesOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Definition;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DefinitionsCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelineDefinitionOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelineOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelinePropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DeleteTektonPipelineTriggerPropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.DuplicateTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineDefinitionOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelinePropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineRunLogContentOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineRunLogsOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GetTektonPipelineTriggerPropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ListTektonPipelineDefinitionsOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ListTektonPipelinePropertiesOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ListTektonPipelineRunsOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ListTektonPipelineTriggerPropertiesOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ListTektonPipelineTriggersOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.LogsCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRun;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunsCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PropertiesCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Property;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ReplaceTektonPipelineDefinitionOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ReplaceTektonPipelinePropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.ReplaceTektonPipelineTriggerPropertyOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RerunTektonPipelineRunOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.StepLog;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TektonPipeline;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Trigger;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerPropertiesCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerProperty;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggersCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.UpdateTektonPipelineOptions;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.UpdateTektonPipelineTriggerOptions;
import com.ibm.cloud.continuous_delivery.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Continuous Delivery Tekton pipeline API definition &lt;br&gt;&lt;br&gt; Maximum request payload size is 512 KB
 * &lt;br&gt;&lt;br&gt; All calls require an &lt;strong&gt;Authorization&lt;/strong&gt; HTTP header.
 * &lt;br&gt;&lt;br&gt; The following header is the accepted authentication mechanism and required credentials for each
 * &lt;ul&gt;&lt;li&gt;&lt;b&gt;Bearer:&lt;/b&gt; an IBM Cloud IAM token (authorized for all endpoints)&lt;/li&gt;.
 *
 * API Version: 2.0.0
 */
public class CdTektonPipeline extends BaseService {

  /**
   * Default service name used when configuring the `CdTektonPipeline` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "cd_tekton_pipeline";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://api.us-south.devops.cloud.ibm.com/pipeline/v2";

  private static final Map<String, String> _regionalEndpoints;
  static {
    Map<String, String> m = new HashMap<>();
    m.put("us-south", "https://api.us-south.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the us-south region.

    m.put("us-east", "https://api.us-east.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the us-east region.

    m.put("eu-de", "https://api.eu-de.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the eu-de region.

    m.put("eu-gb", "https://api.eu-gb.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the eu-gb region.

    m.put("jp-osa", "https://api.jp-osa.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the jp-osa region.

    m.put("jp-tok", "https://api.jp-tok.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the jp-tok region.

    m.put("au-syd", "https://api.au-syd.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the au-syd region.

    m.put("ca-tor", "https://api.ca-tor.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the ca-tor region.

    m.put("br-sao", "https://api.br-sao.devops.cloud.ibm.com/pipeline/v2"); // The host URL for Tekton Pipeline Service in the br-sao region.
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
   * Class method which constructs an instance of the `CdTektonPipeline` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `CdTektonPipeline` client using external configuration
   */
  public static CdTektonPipeline newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `CdTektonPipeline` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `CdTektonPipeline` client using external configuration
   */
  public static CdTektonPipeline newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    CdTektonPipeline service = new CdTektonPipeline(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `CdTektonPipeline` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CdTektonPipeline(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Create Tekton pipeline.
   *
   * This request creates a Tekton pipeline. Requires a pipeline tool already created in the toolchain using the
   * toolchain API https://cloud.ibm.com/apidocs/toolchain#create-tool, and use the tool ID to create the Tekton
   * pipeline.
   *
   * @param createTektonPipelineOptions the {@link CreateTektonPipelineOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TektonPipeline}
   */
  public ServiceCall<TektonPipeline> createTektonPipeline(CreateTektonPipelineOptions createTektonPipelineOptions) {
    boolean skipBody = false;
    if (createTektonPipelineOptions == null) {
      createTektonPipelineOptions = new CreateTektonPipelineOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipeline");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createTektonPipelineOptions.enableNotifications() != null) {
        contentJson.addProperty("enable_notifications", createTektonPipelineOptions.enableNotifications());
      }
      if (createTektonPipelineOptions.enablePartialCloning() != null) {
        contentJson.addProperty("enable_partial_cloning", createTektonPipelineOptions.enablePartialCloning());
      }
      if (createTektonPipelineOptions.id() != null) {
        contentJson.addProperty("id", createTektonPipelineOptions.id());
      }
      if (createTektonPipelineOptions.worker() != null) {
        contentJson.add("worker", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineOptions.worker()));
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<TektonPipeline> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TektonPipeline>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create Tekton pipeline.
   *
   * This request creates a Tekton pipeline. Requires a pipeline tool already created in the toolchain using the
   * toolchain API https://cloud.ibm.com/apidocs/toolchain#create-tool, and use the tool ID to create the Tekton
   * pipeline.
   *
   * @return a {@link ServiceCall} with a result of type {@link TektonPipeline}
   */
  public ServiceCall<TektonPipeline> createTektonPipeline() {
    return createTektonPipeline(null);
  }

  /**
   * Get Tekton pipeline data.
   *
   * This request retrieves the Tekton pipeline data for the pipeline identified by `{id}`.
   *
   * @param getTektonPipelineOptions the {@link GetTektonPipelineOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TektonPipeline}
   */
  public ServiceCall<TektonPipeline> getTektonPipeline(GetTektonPipelineOptions getTektonPipelineOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineOptions,
      "getTektonPipelineOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getTektonPipelineOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipeline");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<TektonPipeline> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TektonPipeline>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update Tekton pipeline data.
   *
   * This request updates Tekton pipeline data, but you can only change worker ID in this endpoint. Use other endpoints
   * such as /definitions, /triggers, and /properties for other configuration updates.
   *
   * @param updateTektonPipelineOptions the {@link UpdateTektonPipelineOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TektonPipeline}
   */
  public ServiceCall<TektonPipeline> updateTektonPipeline(UpdateTektonPipelineOptions updateTektonPipelineOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateTektonPipelineOptions,
      "updateTektonPipelineOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateTektonPipelineOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "updateTektonPipeline");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateTektonPipelineOptions.tektonPipelinePatch() != null) {
      builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateTektonPipelineOptions.tektonPipelinePatch()), "application/merge-patch+json");
    }
    ResponseConverter<TektonPipeline> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TektonPipeline>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete Tekton pipeline instance.
   *
   * This request deletes Tekton pipeline instance that is associated with the pipeline toolchain integration.
   *
   * @param deleteTektonPipelineOptions the {@link DeleteTektonPipelineOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipeline(DeleteTektonPipelineOptions deleteTektonPipelineOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelineOptions,
      "deleteTektonPipelineOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteTektonPipelineOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipeline");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List pipeline run records.
   *
   * This request lists pipeline run records, which has data about the runs, such as status, user_info, trigger and
   * other information. Default limit is 50.
   *
   * @param listTektonPipelineRunsOptions the {@link ListTektonPipelineRunsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PipelineRunsCollection}
   */
  public ServiceCall<PipelineRunsCollection> listTektonPipelineRuns(ListTektonPipelineRunsOptions listTektonPipelineRunsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTektonPipelineRunsOptions,
      "listTektonPipelineRunsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", listTektonPipelineRunsOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "listTektonPipelineRuns");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTektonPipelineRunsOptions.start() != null) {
      builder.query("start", String.valueOf(listTektonPipelineRunsOptions.start()));
    }
    if (listTektonPipelineRunsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listTektonPipelineRunsOptions.limit()));
    }
    if (listTektonPipelineRunsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listTektonPipelineRunsOptions.offset()));
    }
    if (listTektonPipelineRunsOptions.status() != null) {
      builder.query("status", String.valueOf(listTektonPipelineRunsOptions.status()));
    }
    if (listTektonPipelineRunsOptions.triggerName() != null) {
      builder.query("trigger.name", String.valueOf(listTektonPipelineRunsOptions.triggerName()));
    }
    ResponseConverter<PipelineRunsCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PipelineRunsCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Trigger a pipeline run.
   *
   * Trigger a new pipeline run using the named trigger, using the provided additional or override properties.
   *
   * @param createTektonPipelineRunOptions the {@link CreateTektonPipelineRunOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PipelineRun}
   */
  public ServiceCall<PipelineRun> createTektonPipelineRun(CreateTektonPipelineRunOptions createTektonPipelineRunOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTektonPipelineRunOptions,
      "createTektonPipelineRunOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", createTektonPipelineRunOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipelineRun");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createTektonPipelineRunOptions.triggerName() != null) {
      contentJson.addProperty("trigger_name", createTektonPipelineRunOptions.triggerName());
    }
    if (createTektonPipelineRunOptions.triggerProperties() != null) {
      contentJson.add("trigger_properties", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineRunOptions.triggerProperties()));
    }
    if (createTektonPipelineRunOptions.secureTriggerProperties() != null) {
      contentJson.add("secure_trigger_properties", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineRunOptions.secureTriggerProperties()));
    }
    if (createTektonPipelineRunOptions.triggerHeaders() != null) {
      contentJson.add("trigger_headers", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineRunOptions.triggerHeaders()));
    }
    if (createTektonPipelineRunOptions.triggerBody() != null) {
      contentJson.add("trigger_body", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineRunOptions.triggerBody()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PipelineRun> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PipelineRun>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a pipeline run record.
   *
   * This request retrieves details of the pipeline run identified by `{id}`.
   *
   * @param getTektonPipelineRunOptions the {@link GetTektonPipelineRunOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PipelineRun}
   */
  public ServiceCall<PipelineRun> getTektonPipelineRun(GetTektonPipelineRunOptions getTektonPipelineRunOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineRunOptions,
      "getTektonPipelineRunOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineRunOptions.pipelineId());
    pathParamsMap.put("id", getTektonPipelineRunOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineRun");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getTektonPipelineRunOptions.includes() != null) {
      builder.query("includes", String.valueOf(getTektonPipelineRunOptions.includes()));
    }
    ResponseConverter<PipelineRun> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PipelineRun>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a pipeline run record.
   *
   * This request deletes the pipeline run record identified by `{id}`.
   *
   * @param deleteTektonPipelineRunOptions the {@link DeleteTektonPipelineRunOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipelineRun(DeleteTektonPipelineRunOptions deleteTektonPipelineRunOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelineRunOptions,
      "deleteTektonPipelineRunOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", deleteTektonPipelineRunOptions.pipelineId());
    pathParamsMap.put("id", deleteTektonPipelineRunOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipelineRun");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Cancel a pipeline run.
   *
   * This request cancels a running pipeline run identified by `{id}`. Use `force: true` in the body if the pipeline run
   * can't be cancelled normally.
   *
   * @param cancelTektonPipelineRunOptions the {@link CancelTektonPipelineRunOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PipelineRun}
   */
  public ServiceCall<PipelineRun> cancelTektonPipelineRun(CancelTektonPipelineRunOptions cancelTektonPipelineRunOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(cancelTektonPipelineRunOptions,
      "cancelTektonPipelineRunOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", cancelTektonPipelineRunOptions.pipelineId());
    pathParamsMap.put("id", cancelTektonPipelineRunOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}/cancel", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "cancelTektonPipelineRun");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (cancelTektonPipelineRunOptions.force() != null) {
      contentJson.addProperty("force", cancelTektonPipelineRunOptions.force());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PipelineRun> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PipelineRun>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Rerun a pipeline run.
   *
   * This request reruns a past pipeline run, which is identified by `{id}`, with the same data. Request body isn't
   * allowed.
   *
   * @param rerunTektonPipelineRunOptions the {@link RerunTektonPipelineRunOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PipelineRun}
   */
  public ServiceCall<PipelineRun> rerunTektonPipelineRun(RerunTektonPipelineRunOptions rerunTektonPipelineRunOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(rerunTektonPipelineRunOptions,
      "rerunTektonPipelineRunOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", rerunTektonPipelineRunOptions.pipelineId());
    pathParamsMap.put("id", rerunTektonPipelineRunOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}/rerun", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "rerunTektonPipelineRun");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PipelineRun> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PipelineRun>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of pipeline run log objects.
   *
   * This request fetches a list of log data for a pipeline run identified by `{id}`. The `href` in each log entry can
   * be used to fetch that individual log.
   *
   * @param getTektonPipelineRunLogsOptions the {@link GetTektonPipelineRunLogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LogsCollection}
   */
  public ServiceCall<LogsCollection> getTektonPipelineRunLogs(GetTektonPipelineRunLogsOptions getTektonPipelineRunLogsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineRunLogsOptions,
      "getTektonPipelineRunLogsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineRunLogsOptions.pipelineId());
    pathParamsMap.put("id", getTektonPipelineRunLogsOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}/logs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineRunLogs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<LogsCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LogsCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the log content of a pipeline run step.
   *
   * This request retrieves the log content of a pipeline run step, where the step is identified by `{id}`. To get the
   * log ID use the endpoint `/tekton_pipelines/{pipeline_id}/pipeline_runs/{id}/logs`.
   *
   * @param getTektonPipelineRunLogContentOptions the {@link GetTektonPipelineRunLogContentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link StepLog}
   */
  public ServiceCall<StepLog> getTektonPipelineRunLogContent(GetTektonPipelineRunLogContentOptions getTektonPipelineRunLogContentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineRunLogContentOptions,
      "getTektonPipelineRunLogContentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineRunLogContentOptions.pipelineId());
    pathParamsMap.put("pipeline_run_id", getTektonPipelineRunLogContentOptions.pipelineRunId());
    pathParamsMap.put("id", getTektonPipelineRunLogContentOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/pipeline_runs/{pipeline_run_id}/logs/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineRunLogContent");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<StepLog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<StepLog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List pipeline definitions.
   *
   * This request fetches pipeline definitions, which is a collection of individual definition entries. Each entry
   * consists of a repository url, a repository path and a branch or tag. The referenced repository URL must match the
   * URL of a repository tool integration in the parent toolchain. Obtain the list of integrations from the toolchain
   * API https://cloud.ibm.com/apidocs/toolchain#list-tools. The branch or tag of the definition must match against a
   * corresponding branch or tag in the chosen repository, and the path must match a subfolder in the repository.
   *
   * @param listTektonPipelineDefinitionsOptions the {@link ListTektonPipelineDefinitionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DefinitionsCollection}
   */
  public ServiceCall<DefinitionsCollection> listTektonPipelineDefinitions(ListTektonPipelineDefinitionsOptions listTektonPipelineDefinitionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTektonPipelineDefinitionsOptions,
      "listTektonPipelineDefinitionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", listTektonPipelineDefinitionsOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/definitions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "listTektonPipelineDefinitions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<DefinitionsCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DefinitionsCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a single definition.
   *
   * This request adds a single definition. The source properties should consist of a repository url, a repository path
   * and a branch or tag. The referenced repository URL must match the URL of a repository tool integration in the
   * parent toolchain. Obtain the list of integrations from the toolchain API
   * https://cloud.ibm.com/apidocs/toolchain#list-tools. The branch or tag of the definition must match against a
   * corresponding branch or tag in the chosen repository, and the path must match a subfolder in the repository.
   *
   * @param createTektonPipelineDefinitionOptions the {@link CreateTektonPipelineDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Definition}
   */
  public ServiceCall<Definition> createTektonPipelineDefinition(CreateTektonPipelineDefinitionOptions createTektonPipelineDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTektonPipelineDefinitionOptions,
      "createTektonPipelineDefinitionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", createTektonPipelineDefinitionOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/definitions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipelineDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createTektonPipelineDefinitionOptions.source() != null) {
      contentJson.add("source", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineDefinitionOptions.source()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Definition> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Definition>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a single definition entry.
   *
   * This request fetches a single definition entry, which consists of the definition repository URL, branch/tag and
   * path.
   *
   * @param getTektonPipelineDefinitionOptions the {@link GetTektonPipelineDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Definition}
   */
  public ServiceCall<Definition> getTektonPipelineDefinition(GetTektonPipelineDefinitionOptions getTektonPipelineDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineDefinitionOptions,
      "getTektonPipelineDefinitionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineDefinitionOptions.pipelineId());
    pathParamsMap.put("definition_id", getTektonPipelineDefinitionOptions.definitionId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/definitions/{definition_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Definition> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Definition>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Edit a single definition entry.
   *
   * This request updates a definition entry identified by `{definition_id}`.
   *
   * @param replaceTektonPipelineDefinitionOptions the {@link ReplaceTektonPipelineDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Definition}
   */
  public ServiceCall<Definition> replaceTektonPipelineDefinition(ReplaceTektonPipelineDefinitionOptions replaceTektonPipelineDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceTektonPipelineDefinitionOptions,
      "replaceTektonPipelineDefinitionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", replaceTektonPipelineDefinitionOptions.pipelineId());
    pathParamsMap.put("definition_id", replaceTektonPipelineDefinitionOptions.definitionId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/definitions/{definition_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "replaceTektonPipelineDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceTektonPipelineDefinitionOptions.source() != null) {
      contentJson.add("source", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceTektonPipelineDefinitionOptions.source()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Definition> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Definition>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a single definition entry.
   *
   * This request deletes a single definition from the definition list.
   *
   * @param deleteTektonPipelineDefinitionOptions the {@link DeleteTektonPipelineDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipelineDefinition(DeleteTektonPipelineDefinitionOptions deleteTektonPipelineDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelineDefinitionOptions,
      "deleteTektonPipelineDefinitionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", deleteTektonPipelineDefinitionOptions.pipelineId());
    pathParamsMap.put("definition_id", deleteTektonPipelineDefinitionOptions.definitionId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/definitions/{definition_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipelineDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List the pipeline's environment properties.
   *
   * This request lists the environment properties the pipeline identified by `{pipeline_id}`.
   *
   * @param listTektonPipelinePropertiesOptions the {@link ListTektonPipelinePropertiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PropertiesCollection}
   */
  public ServiceCall<PropertiesCollection> listTektonPipelineProperties(ListTektonPipelinePropertiesOptions listTektonPipelinePropertiesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTektonPipelinePropertiesOptions,
      "listTektonPipelinePropertiesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", listTektonPipelinePropertiesOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/properties", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "listTektonPipelineProperties");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTektonPipelinePropertiesOptions.name() != null) {
      builder.query("name", String.valueOf(listTektonPipelinePropertiesOptions.name()));
    }
    if (listTektonPipelinePropertiesOptions.type() != null) {
      builder.query("type", RequestUtils.join(listTektonPipelinePropertiesOptions.type(), ","));
    }
    if (listTektonPipelinePropertiesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listTektonPipelinePropertiesOptions.sort()));
    }
    ResponseConverter<PropertiesCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PropertiesCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a pipeline environment property.
   *
   * This request creates an environment property.
   *
   * @param createTektonPipelinePropertiesOptions the {@link CreateTektonPipelinePropertiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Property}
   */
  public ServiceCall<Property> createTektonPipelineProperties(CreateTektonPipelinePropertiesOptions createTektonPipelinePropertiesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTektonPipelinePropertiesOptions,
      "createTektonPipelinePropertiesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", createTektonPipelinePropertiesOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/properties", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipelineProperties");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createTektonPipelinePropertiesOptions.name() != null) {
      contentJson.addProperty("name", createTektonPipelinePropertiesOptions.name());
    }
    if (createTektonPipelinePropertiesOptions.value() != null) {
      contentJson.addProperty("value", createTektonPipelinePropertiesOptions.value());
    }
    if (createTektonPipelinePropertiesOptions.xEnum() != null) {
      contentJson.add("enum", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelinePropertiesOptions.xEnum()));
    }
    if (createTektonPipelinePropertiesOptions.type() != null) {
      contentJson.addProperty("type", createTektonPipelinePropertiesOptions.type());
    }
    if (createTektonPipelinePropertiesOptions.path() != null) {
      contentJson.addProperty("path", createTektonPipelinePropertiesOptions.path());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Property> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Property>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a pipeline environment property.
   *
   * This request gets the data of an environment property identified by `{property_name}`.
   *
   * @param getTektonPipelinePropertyOptions the {@link GetTektonPipelinePropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Property}
   */
  public ServiceCall<Property> getTektonPipelineProperty(GetTektonPipelinePropertyOptions getTektonPipelinePropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelinePropertyOptions,
      "getTektonPipelinePropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelinePropertyOptions.pipelineId());
    pathParamsMap.put("property_name", getTektonPipelinePropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Property> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Property>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace the value of an environment property.
   *
   * This request updates the value of an environment property identified by `{property_name}`, its type or name are
   * immutable.
   *
   * @param replaceTektonPipelinePropertyOptions the {@link ReplaceTektonPipelinePropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Property}
   */
  public ServiceCall<Property> replaceTektonPipelineProperty(ReplaceTektonPipelinePropertyOptions replaceTektonPipelinePropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceTektonPipelinePropertyOptions,
      "replaceTektonPipelinePropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", replaceTektonPipelinePropertyOptions.pipelineId());
    pathParamsMap.put("property_name", replaceTektonPipelinePropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "replaceTektonPipelineProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceTektonPipelinePropertyOptions.name() != null) {
      contentJson.addProperty("name", replaceTektonPipelinePropertyOptions.name());
    }
    if (replaceTektonPipelinePropertyOptions.value() != null) {
      contentJson.addProperty("value", replaceTektonPipelinePropertyOptions.value());
    }
    if (replaceTektonPipelinePropertyOptions.xEnum() != null) {
      contentJson.add("enum", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceTektonPipelinePropertyOptions.xEnum()));
    }
    if (replaceTektonPipelinePropertyOptions.type() != null) {
      contentJson.addProperty("type", replaceTektonPipelinePropertyOptions.type());
    }
    if (replaceTektonPipelinePropertyOptions.path() != null) {
      contentJson.addProperty("path", replaceTektonPipelinePropertyOptions.path());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Property> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Property>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a single pipeline environment property.
   *
   * This request deletes a single pipeline environment property.
   *
   * @param deleteTektonPipelinePropertyOptions the {@link DeleteTektonPipelinePropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipelineProperty(DeleteTektonPipelinePropertyOptions deleteTektonPipelinePropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelinePropertyOptions,
      "deleteTektonPipelinePropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", deleteTektonPipelinePropertyOptions.pipelineId());
    pathParamsMap.put("property_name", deleteTektonPipelinePropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipelineProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List pipeline triggers.
   *
   * This request lists pipeline triggers for the pipeline identified by `{pipeline_id}`.
   *
   * @param listTektonPipelineTriggersOptions the {@link ListTektonPipelineTriggersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TriggersCollection}
   */
  public ServiceCall<TriggersCollection> listTektonPipelineTriggers(ListTektonPipelineTriggersOptions listTektonPipelineTriggersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTektonPipelineTriggersOptions,
      "listTektonPipelineTriggersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", listTektonPipelineTriggersOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "listTektonPipelineTriggers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTektonPipelineTriggersOptions.type() != null) {
      builder.query("type", String.valueOf(listTektonPipelineTriggersOptions.type()));
    }
    if (listTektonPipelineTriggersOptions.name() != null) {
      builder.query("name", String.valueOf(listTektonPipelineTriggersOptions.name()));
    }
    if (listTektonPipelineTriggersOptions.eventListener() != null) {
      builder.query("event_listener", String.valueOf(listTektonPipelineTriggersOptions.eventListener()));
    }
    if (listTektonPipelineTriggersOptions.workerId() != null) {
      builder.query("worker.id", String.valueOf(listTektonPipelineTriggersOptions.workerId()));
    }
    if (listTektonPipelineTriggersOptions.workerName() != null) {
      builder.query("worker.name", String.valueOf(listTektonPipelineTriggersOptions.workerName()));
    }
    if (listTektonPipelineTriggersOptions.disabled() != null) {
      builder.query("disabled", String.valueOf(listTektonPipelineTriggersOptions.disabled()));
    }
    if (listTektonPipelineTriggersOptions.tags() != null) {
      builder.query("tags", String.valueOf(listTektonPipelineTriggersOptions.tags()));
    }
    ResponseConverter<TriggersCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TriggersCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a trigger.
   *
   * This request creates a trigger.
   *
   * @param createTektonPipelineTriggerOptions the {@link CreateTektonPipelineTriggerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Trigger}
   */
  public ServiceCall<Trigger> createTektonPipelineTrigger(CreateTektonPipelineTriggerOptions createTektonPipelineTriggerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTektonPipelineTriggerOptions,
      "createTektonPipelineTriggerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", createTektonPipelineTriggerOptions.pipelineId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipelineTrigger");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createTektonPipelineTriggerOptions.type() != null) {
      contentJson.addProperty("type", createTektonPipelineTriggerOptions.type());
    }
    if (createTektonPipelineTriggerOptions.name() != null) {
      contentJson.addProperty("name", createTektonPipelineTriggerOptions.name());
    }
    if (createTektonPipelineTriggerOptions.eventListener() != null) {
      contentJson.addProperty("event_listener", createTektonPipelineTriggerOptions.eventListener());
    }
    if (createTektonPipelineTriggerOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerOptions.tags()));
    }
    if (createTektonPipelineTriggerOptions.worker() != null) {
      contentJson.add("worker", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerOptions.worker()));
    }
    if (createTektonPipelineTriggerOptions.maxConcurrentRuns() != null) {
      contentJson.addProperty("max_concurrent_runs", createTektonPipelineTriggerOptions.maxConcurrentRuns());
    }
    if (createTektonPipelineTriggerOptions.enabled() != null) {
      contentJson.addProperty("enabled", createTektonPipelineTriggerOptions.enabled());
    }
    if (createTektonPipelineTriggerOptions.secret() != null) {
      contentJson.add("secret", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerOptions.secret()));
    }
    if (createTektonPipelineTriggerOptions.cron() != null) {
      contentJson.addProperty("cron", createTektonPipelineTriggerOptions.cron());
    }
    if (createTektonPipelineTriggerOptions.timezone() != null) {
      contentJson.addProperty("timezone", createTektonPipelineTriggerOptions.timezone());
    }
    if (createTektonPipelineTriggerOptions.source() != null) {
      contentJson.add("source", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerOptions.source()));
    }
    if (createTektonPipelineTriggerOptions.events() != null) {
      contentJson.add("events", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerOptions.events()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Trigger> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Trigger>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a single trigger.
   *
   * This request retrieves a single trigger identified by `{trigger_id}`.
   *
   * @param getTektonPipelineTriggerOptions the {@link GetTektonPipelineTriggerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Trigger}
   */
  public ServiceCall<Trigger> getTektonPipelineTrigger(GetTektonPipelineTriggerOptions getTektonPipelineTriggerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineTriggerOptions,
      "getTektonPipelineTriggerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineTriggerOptions.pipelineId());
    pathParamsMap.put("trigger_id", getTektonPipelineTriggerOptions.triggerId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineTrigger");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Trigger> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Trigger>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Edit a trigger.
   *
   * This request changes a single field or many fields of the trigger identified by `{trigger_id}`. Note that some
   * fields are immutable, and use `/properties` endpoint to update trigger properties.
   *
   * @param updateTektonPipelineTriggerOptions the {@link UpdateTektonPipelineTriggerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Trigger}
   */
  public ServiceCall<Trigger> updateTektonPipelineTrigger(UpdateTektonPipelineTriggerOptions updateTektonPipelineTriggerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateTektonPipelineTriggerOptions,
      "updateTektonPipelineTriggerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", updateTektonPipelineTriggerOptions.pipelineId());
    pathParamsMap.put("trigger_id", updateTektonPipelineTriggerOptions.triggerId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "updateTektonPipelineTrigger");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateTektonPipelineTriggerOptions.triggerPatch() != null) {
      builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateTektonPipelineTriggerOptions.triggerPatch()), "application/merge-patch+json");
    }
    ResponseConverter<Trigger> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Trigger>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a single trigger.
   *
   * This request deletes the trigger identified by `{trigger_id}`.
   *
   * @param deleteTektonPipelineTriggerOptions the {@link DeleteTektonPipelineTriggerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipelineTrigger(DeleteTektonPipelineTriggerOptions deleteTektonPipelineTriggerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelineTriggerOptions,
      "deleteTektonPipelineTriggerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", deleteTektonPipelineTriggerOptions.pipelineId());
    pathParamsMap.put("trigger_id", deleteTektonPipelineTriggerOptions.triggerId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipelineTrigger");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Duplicate a trigger.
   *
   * This request duplicates a trigger from an existing trigger identified by `{source_trigger_id}`.
   *
   * @param duplicateTektonPipelineTriggerOptions the {@link DuplicateTektonPipelineTriggerOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Trigger}
   */
  public ServiceCall<Trigger> duplicateTektonPipelineTrigger(DuplicateTektonPipelineTriggerOptions duplicateTektonPipelineTriggerOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(duplicateTektonPipelineTriggerOptions,
      "duplicateTektonPipelineTriggerOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", duplicateTektonPipelineTriggerOptions.pipelineId());
    pathParamsMap.put("source_trigger_id", duplicateTektonPipelineTriggerOptions.sourceTriggerId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{source_trigger_id}/duplicate", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "duplicateTektonPipelineTrigger");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (duplicateTektonPipelineTriggerOptions.name() != null) {
      contentJson.addProperty("name", duplicateTektonPipelineTriggerOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Trigger> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Trigger>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List trigger properties.
   *
   * This request lists trigger properties for the trigger identified by `{trigger_id}`.
   *
   * @param listTektonPipelineTriggerPropertiesOptions the {@link ListTektonPipelineTriggerPropertiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TriggerPropertiesCollection}
   */
  public ServiceCall<TriggerPropertiesCollection> listTektonPipelineTriggerProperties(ListTektonPipelineTriggerPropertiesOptions listTektonPipelineTriggerPropertiesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listTektonPipelineTriggerPropertiesOptions,
      "listTektonPipelineTriggerPropertiesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", listTektonPipelineTriggerPropertiesOptions.pipelineId());
    pathParamsMap.put("trigger_id", listTektonPipelineTriggerPropertiesOptions.triggerId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}/properties", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "listTektonPipelineTriggerProperties");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTektonPipelineTriggerPropertiesOptions.name() != null) {
      builder.query("name", String.valueOf(listTektonPipelineTriggerPropertiesOptions.name()));
    }
    if (listTektonPipelineTriggerPropertiesOptions.type() != null) {
      builder.query("type", String.valueOf(listTektonPipelineTriggerPropertiesOptions.type()));
    }
    if (listTektonPipelineTriggerPropertiesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listTektonPipelineTriggerPropertiesOptions.sort()));
    }
    ResponseConverter<TriggerPropertiesCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TriggerPropertiesCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a trigger property.
   *
   * This request creates a property in the trigger identified by `{trigger_id}`.
   *
   * @param createTektonPipelineTriggerPropertiesOptions the {@link CreateTektonPipelineTriggerPropertiesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TriggerProperty}
   */
  public ServiceCall<TriggerProperty> createTektonPipelineTriggerProperties(CreateTektonPipelineTriggerPropertiesOptions createTektonPipelineTriggerPropertiesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTektonPipelineTriggerPropertiesOptions,
      "createTektonPipelineTriggerPropertiesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", createTektonPipelineTriggerPropertiesOptions.pipelineId());
    pathParamsMap.put("trigger_id", createTektonPipelineTriggerPropertiesOptions.triggerId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}/properties", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "createTektonPipelineTriggerProperties");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createTektonPipelineTriggerPropertiesOptions.name() != null) {
      contentJson.addProperty("name", createTektonPipelineTriggerPropertiesOptions.name());
    }
    if (createTektonPipelineTriggerPropertiesOptions.value() != null) {
      contentJson.addProperty("value", createTektonPipelineTriggerPropertiesOptions.value());
    }
    if (createTektonPipelineTriggerPropertiesOptions.xEnum() != null) {
      contentJson.add("enum", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTektonPipelineTriggerPropertiesOptions.xEnum()));
    }
    if (createTektonPipelineTriggerPropertiesOptions.type() != null) {
      contentJson.addProperty("type", createTektonPipelineTriggerPropertiesOptions.type());
    }
    if (createTektonPipelineTriggerPropertiesOptions.path() != null) {
      contentJson.addProperty("path", createTektonPipelineTriggerPropertiesOptions.path());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TriggerProperty> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TriggerProperty>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a trigger property.
   *
   * This request retrieves a trigger property.
   *
   * @param getTektonPipelineTriggerPropertyOptions the {@link GetTektonPipelineTriggerPropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TriggerProperty}
   */
  public ServiceCall<TriggerProperty> getTektonPipelineTriggerProperty(GetTektonPipelineTriggerPropertyOptions getTektonPipelineTriggerPropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getTektonPipelineTriggerPropertyOptions,
      "getTektonPipelineTriggerPropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", getTektonPipelineTriggerPropertyOptions.pipelineId());
    pathParamsMap.put("trigger_id", getTektonPipelineTriggerPropertyOptions.triggerId());
    pathParamsMap.put("property_name", getTektonPipelineTriggerPropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "getTektonPipelineTriggerProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<TriggerProperty> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TriggerProperty>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace a trigger property value.
   *
   * This request updates a trigger property value, type and name are immutable.
   *
   * @param replaceTektonPipelineTriggerPropertyOptions the {@link ReplaceTektonPipelineTriggerPropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TriggerProperty}
   */
  public ServiceCall<TriggerProperty> replaceTektonPipelineTriggerProperty(ReplaceTektonPipelineTriggerPropertyOptions replaceTektonPipelineTriggerPropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceTektonPipelineTriggerPropertyOptions,
      "replaceTektonPipelineTriggerPropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", replaceTektonPipelineTriggerPropertyOptions.pipelineId());
    pathParamsMap.put("trigger_id", replaceTektonPipelineTriggerPropertyOptions.triggerId());
    pathParamsMap.put("property_name", replaceTektonPipelineTriggerPropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "replaceTektonPipelineTriggerProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceTektonPipelineTriggerPropertyOptions.name() != null) {
      contentJson.addProperty("name", replaceTektonPipelineTriggerPropertyOptions.name());
    }
    if (replaceTektonPipelineTriggerPropertyOptions.value() != null) {
      contentJson.addProperty("value", replaceTektonPipelineTriggerPropertyOptions.value());
    }
    if (replaceTektonPipelineTriggerPropertyOptions.xEnum() != null) {
      contentJson.add("enum", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceTektonPipelineTriggerPropertyOptions.xEnum()));
    }
    if (replaceTektonPipelineTriggerPropertyOptions.type() != null) {
      contentJson.addProperty("type", replaceTektonPipelineTriggerPropertyOptions.type());
    }
    if (replaceTektonPipelineTriggerPropertyOptions.path() != null) {
      contentJson.addProperty("path", replaceTektonPipelineTriggerPropertyOptions.path());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TriggerProperty> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TriggerProperty>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a trigger property.
   *
   * This request deletes a trigger property.
   *
   * @param deleteTektonPipelineTriggerPropertyOptions the {@link DeleteTektonPipelineTriggerPropertyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteTektonPipelineTriggerProperty(DeleteTektonPipelineTriggerPropertyOptions deleteTektonPipelineTriggerPropertyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTektonPipelineTriggerPropertyOptions,
      "deleteTektonPipelineTriggerPropertyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("pipeline_id", deleteTektonPipelineTriggerPropertyOptions.pipelineId());
    pathParamsMap.put("trigger_id", deleteTektonPipelineTriggerPropertyOptions.triggerId());
    pathParamsMap.put("property_name", deleteTektonPipelineTriggerPropertyOptions.propertyName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/tekton_pipelines/{pipeline_id}/triggers/{trigger_id}/properties/{property_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("cd_tekton_pipeline", "v2", "deleteTektonPipelineTriggerProperty");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
