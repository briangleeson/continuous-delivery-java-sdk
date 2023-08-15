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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTektonPipelineRun options.
 */
public class CreateTektonPipelineRunOptions extends GenericModel {

  protected String pipelineId;
  protected String triggerName;
  protected Map<String, Object> triggerProperties;
  protected Map<String, Object> secureTriggerProperties;
  protected Map<String, Object> triggerHeaders;
  protected Map<String, Object> triggerBody;
  protected PipelineRunTrigger trigger;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String triggerName;
    private Map<String, Object> triggerProperties;
    private Map<String, Object> secureTriggerProperties;
    private Map<String, Object> triggerHeaders;
    private Map<String, Object> triggerBody;
    private PipelineRunTrigger trigger;

    /**
     * Instantiates a new Builder from an existing CreateTektonPipelineRunOptions instance.
     *
     * @param createTektonPipelineRunOptions the instance to initialize the Builder with
     */
    private Builder(CreateTektonPipelineRunOptions createTektonPipelineRunOptions) {
      this.pipelineId = createTektonPipelineRunOptions.pipelineId;
      this.triggerName = createTektonPipelineRunOptions.triggerName;
      this.triggerProperties = createTektonPipelineRunOptions.triggerProperties;
      this.secureTriggerProperties = createTektonPipelineRunOptions.secureTriggerProperties;
      this.triggerHeaders = createTektonPipelineRunOptions.triggerHeaders;
      this.triggerBody = createTektonPipelineRunOptions.triggerBody;
      this.trigger = createTektonPipelineRunOptions.trigger;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param pipelineId the pipelineId
     */
    public Builder(String pipelineId) {
      this.pipelineId = pipelineId;
    }

    /**
     * Builds a CreateTektonPipelineRunOptions.
     *
     * @return the new CreateTektonPipelineRunOptions instance
     */
    public CreateTektonPipelineRunOptions build() {
      return new CreateTektonPipelineRunOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the triggerName.
     *
     * @param triggerName the triggerName
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder triggerName(String triggerName) {
      this.triggerName = triggerName;
      return this;
    }

    /**
     * Set the triggerProperties.
     *
     * @param triggerProperties the triggerProperties
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder triggerProperties(Map<String, Object> triggerProperties) {
      this.triggerProperties = triggerProperties;
      return this;
    }

    /**
     * Set the secureTriggerProperties.
     *
     * @param secureTriggerProperties the secureTriggerProperties
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder secureTriggerProperties(Map<String, Object> secureTriggerProperties) {
      this.secureTriggerProperties = secureTriggerProperties;
      return this;
    }

    /**
     * Set the triggerHeaders.
     *
     * @param triggerHeaders the triggerHeaders
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder triggerHeaders(Map<String, Object> triggerHeaders) {
      this.triggerHeaders = triggerHeaders;
      return this;
    }

    /**
     * Set the triggerBody.
     *
     * @param triggerBody the triggerBody
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder triggerBody(Map<String, Object> triggerBody) {
      this.triggerBody = triggerBody;
      return this;
    }

    /**
     * Set the trigger.
     *
     * @param trigger the trigger
     * @return the CreateTektonPipelineRunOptions builder
     */
    public Builder trigger(PipelineRunTrigger trigger) {
      this.trigger = trigger;
      return this;
    }
  }

  protected CreateTektonPipelineRunOptions() { }

  protected CreateTektonPipelineRunOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
    triggerName = builder.triggerName;
    triggerProperties = builder.triggerProperties;
    secureTriggerProperties = builder.secureTriggerProperties;
    triggerHeaders = builder.triggerHeaders;
    triggerBody = builder.triggerBody;
    trigger = builder.trigger;
  }

  /**
   * New builder.
   *
   * @return a CreateTektonPipelineRunOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the pipelineId.
   *
   * The Tekton pipeline ID.
   *
   * @return the pipelineId
   */
  public String pipelineId() {
    return pipelineId;
  }

  /**
   * Gets the triggerName.
   *
   * Trigger name.
   *
   * @return the triggerName
   */
  public String triggerName() {
    return triggerName;
  }

  /**
   * Gets the triggerProperties.
   *
   * An object containing string values only that provides additional `text` properties, or overrides existing
   * pipeline/trigger properties, to use for the created run.
   *
   * @return the triggerProperties
   */
  public Map<String, Object> triggerProperties() {
    return triggerProperties;
  }

  /**
   * Gets the secureTriggerProperties.
   *
   * An object containing string values only that provides additional `secure` properties, or overrides existing
   * `secure` pipeline/trigger properties, to use for the created run.
   *
   * @return the secureTriggerProperties
   */
  public Map<String, Object> secureTriggerProperties() {
    return secureTriggerProperties;
  }

  /**
   * Gets the triggerHeaders.
   *
   * An object containing string values only that provides the request headers. Use `$(header.header_key_name)` to
   * access it in a TriggerBinding. Most commonly used as part of a Generic Webhook to provide a verification token or
   * signature in the request headers.
   *
   * @return the triggerHeaders
   */
  public Map<String, Object> triggerHeaders() {
    return triggerHeaders;
  }

  /**
   * Gets the triggerBody.
   *
   * An object that provides the request body. Use `$(body.body_key_name)` to access it in a TriggerBinding. Most
   * commonly used to pass in additional properties or override properties for the pipeline run that is created.
   *
   * @return the triggerBody
   */
  public Map<String, Object> triggerBody() {
    return triggerBody;
  }

  /**
   * Gets the trigger.
   *
   * Trigger details passed when triggering a Tekton pipeline run.
   *
   * @return the trigger
   */
  public PipelineRunTrigger trigger() {
    return trigger;
  }
}

