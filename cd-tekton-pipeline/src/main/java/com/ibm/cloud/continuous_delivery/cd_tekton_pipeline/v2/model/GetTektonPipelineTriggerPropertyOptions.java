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
package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getTektonPipelineTriggerProperty options.
 */
public class GetTektonPipelineTriggerPropertyOptions extends GenericModel {

  protected String pipelineId;
  protected String triggerId;
  protected String propertyName;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String triggerId;
    private String propertyName;

    /**
     * Instantiates a new Builder from an existing GetTektonPipelineTriggerPropertyOptions instance.
     *
     * @param getTektonPipelineTriggerPropertyOptions the instance to initialize the Builder with
     */
    private Builder(GetTektonPipelineTriggerPropertyOptions getTektonPipelineTriggerPropertyOptions) {
      this.pipelineId = getTektonPipelineTriggerPropertyOptions.pipelineId;
      this.triggerId = getTektonPipelineTriggerPropertyOptions.triggerId;
      this.propertyName = getTektonPipelineTriggerPropertyOptions.propertyName;
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
     * @param triggerId the triggerId
     * @param propertyName the propertyName
     */
    public Builder(String pipelineId, String triggerId, String propertyName) {
      this.pipelineId = pipelineId;
      this.triggerId = triggerId;
      this.propertyName = propertyName;
    }

    /**
     * Builds a GetTektonPipelineTriggerPropertyOptions.
     *
     * @return the new GetTektonPipelineTriggerPropertyOptions instance
     */
    public GetTektonPipelineTriggerPropertyOptions build() {
      return new GetTektonPipelineTriggerPropertyOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the GetTektonPipelineTriggerPropertyOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the triggerId.
     *
     * @param triggerId the triggerId
     * @return the GetTektonPipelineTriggerPropertyOptions builder
     */
    public Builder triggerId(String triggerId) {
      this.triggerId = triggerId;
      return this;
    }

    /**
     * Set the propertyName.
     *
     * @param propertyName the propertyName
     * @return the GetTektonPipelineTriggerPropertyOptions builder
     */
    public Builder propertyName(String propertyName) {
      this.propertyName = propertyName;
      return this;
    }
  }

  protected GetTektonPipelineTriggerPropertyOptions() { }

  protected GetTektonPipelineTriggerPropertyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.triggerId,
      "triggerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.propertyName,
      "propertyName cannot be empty");
    pipelineId = builder.pipelineId;
    triggerId = builder.triggerId;
    propertyName = builder.propertyName;
  }

  /**
   * New builder.
   *
   * @return a GetTektonPipelineTriggerPropertyOptions builder
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
   * Gets the triggerId.
   *
   * The trigger ID.
   *
   * @return the triggerId
   */
  public String triggerId() {
    return triggerId;
  }

  /**
   * Gets the propertyName.
   *
   * The property name.
   *
   * @return the propertyName
   */
  public String propertyName() {
    return propertyName;
  }
}

