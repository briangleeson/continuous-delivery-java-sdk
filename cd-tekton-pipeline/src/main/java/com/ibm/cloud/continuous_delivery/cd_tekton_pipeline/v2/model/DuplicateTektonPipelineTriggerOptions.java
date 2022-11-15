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
 * The duplicateTektonPipelineTrigger options.
 */
public class DuplicateTektonPipelineTriggerOptions extends GenericModel {

  protected String pipelineId;
  protected String sourceTriggerId;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String sourceTriggerId;
    private String name;

    /**
     * Instantiates a new Builder from an existing DuplicateTektonPipelineTriggerOptions instance.
     *
     * @param duplicateTektonPipelineTriggerOptions the instance to initialize the Builder with
     */
    private Builder(DuplicateTektonPipelineTriggerOptions duplicateTektonPipelineTriggerOptions) {
      this.pipelineId = duplicateTektonPipelineTriggerOptions.pipelineId;
      this.sourceTriggerId = duplicateTektonPipelineTriggerOptions.sourceTriggerId;
      this.name = duplicateTektonPipelineTriggerOptions.name;
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
     * @param sourceTriggerId the sourceTriggerId
     */
    public Builder(String pipelineId, String sourceTriggerId) {
      this.pipelineId = pipelineId;
      this.sourceTriggerId = sourceTriggerId;
    }

    /**
     * Builds a DuplicateTektonPipelineTriggerOptions.
     *
     * @return the new DuplicateTektonPipelineTriggerOptions instance
     */
    public DuplicateTektonPipelineTriggerOptions build() {
      return new DuplicateTektonPipelineTriggerOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the DuplicateTektonPipelineTriggerOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the sourceTriggerId.
     *
     * @param sourceTriggerId the sourceTriggerId
     * @return the DuplicateTektonPipelineTriggerOptions builder
     */
    public Builder sourceTriggerId(String sourceTriggerId) {
      this.sourceTriggerId = sourceTriggerId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the DuplicateTektonPipelineTriggerOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected DuplicateTektonPipelineTriggerOptions() { }

  protected DuplicateTektonPipelineTriggerOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.sourceTriggerId,
      "sourceTriggerId cannot be empty");
    pipelineId = builder.pipelineId;
    sourceTriggerId = builder.sourceTriggerId;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a DuplicateTektonPipelineTriggerOptions builder
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
   * Gets the sourceTriggerId.
   *
   * The ID of the trigger to duplicate.
   *
   * @return the sourceTriggerId
   */
  public String sourceTriggerId() {
    return sourceTriggerId;
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
}

