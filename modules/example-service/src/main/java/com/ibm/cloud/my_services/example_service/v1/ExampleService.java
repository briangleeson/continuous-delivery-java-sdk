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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-f17fbac6-20220127-113737
 */

package com.ibm.cloud.my_services.example_service.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.my_services.common.SdkCommon;
import com.ibm.cloud.my_services.example_service.v1.model.CreateResourceOptions;
import com.ibm.cloud.my_services.example_service.v1.model.GetResourceEncodedOptions;
import com.ibm.cloud.my_services.example_service.v1.model.GetResourceOptions;
import com.ibm.cloud.my_services.example_service.v1.model.ListResourcesOptions;
import com.ibm.cloud.my_services.example_service.v1.model.Resource;
import com.ibm.cloud.my_services.example_service.v1.model.Resources;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IBM SDK Squad Example Service. The Example service serves as an example of a service.
 *
 * API Version: 1.0.0
 * See: https://{invalid host}.cloud.ibm.com/apidocs/example-service
 */
public class ExampleService extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "example_service";

  public static final String DEFAULT_SERVICE_URL = "http://cloud.ibm.com/mysdk/v1";

 /**
   * Class method which constructs an instance of the `ExampleService` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ExampleService` client using external configuration
   */
  public static ExampleService newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ExampleService` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ExampleService` client using external configuration
   */
  public static ExampleService newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ExampleService service = new ExampleService(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ExampleService` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ExampleService(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * List all resources.
   *
   * @param listResourcesOptions the {@link ListResourcesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resources}
   */
  public ServiceCall<Resources> listResources(ListResourcesOptions listResourcesOptions) {
    if (listResourcesOptions == null) {
      listResourcesOptions = new ListResourcesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/resources"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("example_service", "v1", "listResources");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourcesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourcesOptions.limit()));
    }
    ResponseConverter<Resources> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resources>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List all resources.
   *
   * @return a {@link ServiceCall} with a result of type {@link Resources}
   */
  public ServiceCall<Resources> listResources() {
    return listResources(null);
  }

  /**
   * Create a resource.
   *
   * @param createResourceOptions the {@link CreateResourceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resource}
   */
  public ServiceCall<Resource> createResource(CreateResourceOptions createResourceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceOptions,
      "createResourceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/resources"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("example_service", "v1", "createResource");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceOptions.name());
    contentJson.addProperty("tag", createResourceOptions.tag());
    if (createResourceOptions.resourceId() != null) {
      contentJson.addProperty("resource_id", createResourceOptions.resourceId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resource> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resource>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Info for a specific resource.
   *
   * @param getResourceOptions the {@link GetResourceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resource}
   */
  public ServiceCall<Resource> getResource(GetResourceOptions getResourceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceOptions,
      "getResourceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("resource_id", getResourceOptions.resourceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/resources/{resource_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("example_service", "v1", "getResource");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Resource> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resource>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Info for a specific resource.
   *
   * @param getResourceEncodedOptions the {@link GetResourceEncodedOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resource}
   */
  public ServiceCall<Resource> getResourceEncoded(GetResourceEncodedOptions getResourceEncodedOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceEncodedOptions,
      "getResourceEncodedOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("url_encoded_resource_id", getResourceEncodedOptions.urlEncodedResourceId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/resources/encoded/{url_encoded_resource_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("example_service", "v1", "getResourceEncoded");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Resource> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resource>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
