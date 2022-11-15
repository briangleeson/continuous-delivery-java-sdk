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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateTektonPipelineTrigger options.
 */
public class UpdateTektonPipelineTriggerOptions extends GenericModel {

  protected String pipelineId;
  protected String triggerId;
  protected Map<String, Object> triggerPatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String triggerId;
    private Map<String, Object> triggerPatch;

    /**
     * Instantiates a new Builder from an existing UpdateTektonPipelineTriggerOptions instance.
     *
     * @param updateTektonPipelineTriggerOptions the instance to initialize the Builder with
     */
    private Builder(UpdateTektonPipelineTriggerOptions updateTektonPipelineTriggerOptions) {
      this.pipelineId = updateTektonPipelineTriggerOptions.pipelineId;
      this.triggerId = updateTektonPipelineTriggerOptions.triggerId;
      this.triggerPatch = updateTektonPipelineTriggerOptions.triggerPatch;
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
     */
    public Builder(String pipelineId, String triggerId) {
      this.pipelineId = pipelineId;
      this.triggerId = triggerId;
    }

    /**
     * Builds a UpdateTektonPipelineTriggerOptions.
     *
     * @return the new UpdateTektonPipelineTriggerOptions instance
     */
    public UpdateTektonPipelineTriggerOptions build() {
      return new UpdateTektonPipelineTriggerOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the UpdateTektonPipelineTriggerOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the triggerId.
     *
     * @param triggerId the triggerId
     * @return the UpdateTektonPipelineTriggerOptions builder
     */
    public Builder triggerId(String triggerId) {
      this.triggerId = triggerId;
      return this;
    }

    /**
     * Set the triggerPatch.
     *
     * @param triggerPatch the triggerPatch
     * @return the UpdateTektonPipelineTriggerOptions builder
     */
    public Builder triggerPatch(Map<String, Object> triggerPatch) {
      this.triggerPatch = triggerPatch;
      return this;
    }
  }

  protected UpdateTektonPipelineTriggerOptions() { }

  protected UpdateTektonPipelineTriggerOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.triggerId,
      "triggerId cannot be empty");
    pipelineId = builder.pipelineId;
    triggerId = builder.triggerId;
    triggerPatch = builder.triggerPatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateTektonPipelineTriggerOptions builder
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
   * Gets the triggerPatch.
   *
   * JSON Merge-Patch content for update_tekton_pipeline_trigger.
   *
   * @return the triggerPatch
   */
  public Map<String, Object> triggerPatch() {
    return triggerPatch;
  }
}

