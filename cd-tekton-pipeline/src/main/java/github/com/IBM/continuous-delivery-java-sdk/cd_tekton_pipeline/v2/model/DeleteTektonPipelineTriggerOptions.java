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
package github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTektonPipelineTrigger options.
 */
public class DeleteTektonPipelineTriggerOptions extends GenericModel {

  protected String pipelineId;
  protected String triggerId;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String triggerId;

    private Builder(DeleteTektonPipelineTriggerOptions deleteTektonPipelineTriggerOptions) {
      this.pipelineId = deleteTektonPipelineTriggerOptions.pipelineId;
      this.triggerId = deleteTektonPipelineTriggerOptions.triggerId;
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
     * Builds a DeleteTektonPipelineTriggerOptions.
     *
     * @return the new DeleteTektonPipelineTriggerOptions instance
     */
    public DeleteTektonPipelineTriggerOptions build() {
      return new DeleteTektonPipelineTriggerOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the DeleteTektonPipelineTriggerOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the triggerId.
     *
     * @param triggerId the triggerId
     * @return the DeleteTektonPipelineTriggerOptions builder
     */
    public Builder triggerId(String triggerId) {
      this.triggerId = triggerId;
      return this;
    }
  }

  protected DeleteTektonPipelineTriggerOptions() { }

  protected DeleteTektonPipelineTriggerOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.triggerId,
      "triggerId cannot be empty");
    pipelineId = builder.pipelineId;
    triggerId = builder.triggerId;
  }

  /**
   * New builder.
   *
   * @return a DeleteTektonPipelineTriggerOptions builder
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
}

