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
package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Trigger details passed when triggering a Tekton pipeline run.
 */
public class PipelineRunTrigger extends GenericModel {

  protected String name;
  @SerializedName("properties")
  protected Map<String, Object> xProperties;
  @SerializedName("secure_properties")
  protected Map<String, Object> secureProperties;
  protected Map<String, Object> headers;
  protected Map<String, Object> body;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Map<String, Object> xProperties;
    private Map<String, Object> secureProperties;
    private Map<String, Object> headers;
    private Map<String, Object> body;

    /**
     * Instantiates a new Builder from an existing PipelineRunTrigger instance.
     *
     * @param pipelineRunTrigger the instance to initialize the Builder with
     */
    private Builder(PipelineRunTrigger pipelineRunTrigger) {
      this.name = pipelineRunTrigger.name;
      this.xProperties = pipelineRunTrigger.xProperties;
      this.secureProperties = pipelineRunTrigger.secureProperties;
      this.headers = pipelineRunTrigger.headers;
      this.body = pipelineRunTrigger.body;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a PipelineRunTrigger.
     *
     * @return the new PipelineRunTrigger instance
     */
    public PipelineRunTrigger build() {
      return new PipelineRunTrigger(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the PipelineRunTrigger builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the PipelineRunTrigger builder
     */
    public Builder xProperties(Map<String, Object> xProperties) {
      this.xProperties = xProperties;
      return this;
    }

    /**
     * Set the secureProperties.
     *
     * @param secureProperties the secureProperties
     * @return the PipelineRunTrigger builder
     */
    public Builder secureProperties(Map<String, Object> secureProperties) {
      this.secureProperties = secureProperties;
      return this;
    }

    /**
     * Set the headers.
     *
     * @param headers the headers
     * @return the PipelineRunTrigger builder
     */
    public Builder headers(Map<String, Object> headers) {
      this.headers = headers;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the PipelineRunTrigger builder
     */
    public Builder body(Map<String, Object> body) {
      this.body = body;
      return this;
    }
  }

  protected PipelineRunTrigger() { }

  protected PipelineRunTrigger(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    xProperties = builder.xProperties;
    secureProperties = builder.secureProperties;
    headers = builder.headers;
    body = builder.body;
  }

  /**
   * New builder.
   *
   * @return a PipelineRunTrigger builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Trigger name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the xProperties.
   *
   * An object containing string values only that provides additional `text` properties, or overrides existing
   * pipeline/trigger properties, to use for the created run.
   *
   * @return the xProperties
   */
  public Map<String, Object> xProperties() {
    return xProperties;
  }

  /**
   * Gets the secureProperties.
   *
   * An object containing string values only that provides additional `secure` properties, or overrides existing
   * `secure` pipeline/trigger properties, to use for the created run.
   *
   * @return the secureProperties
   */
  public Map<String, Object> secureProperties() {
    return secureProperties;
  }

  /**
   * Gets the headers.
   *
   * An object containing string values only that provides the request headers. Use `$(header.header_key_name)` to
   * access it in a TriggerBinding. Most commonly used as part of a Generic Webhook to provide a verification token or
   * signature in the request headers.
   *
   * @return the headers
   */
  public Map<String, Object> headers() {
    return headers;
  }

  /**
   * Gets the body.
   *
   * An object that provides the request body. Use `$(body.body_key_name)` to access it in a TriggerBinding. Most
   * commonly used to pass in additional properties or override properties for the pipeline run that is created.
   *
   * @return the body
   */
  public Map<String, Object> body() {
    return body;
  }
}

