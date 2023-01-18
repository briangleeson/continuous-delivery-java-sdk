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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The rerunTektonPipelineRun options.
 */
public class RerunTektonPipelineRunOptions extends GenericModel {

  protected String pipelineId;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String id;

    /**
     * Instantiates a new Builder from an existing RerunTektonPipelineRunOptions instance.
     *
     * @param rerunTektonPipelineRunOptions the instance to initialize the Builder with
     */
    private Builder(RerunTektonPipelineRunOptions rerunTektonPipelineRunOptions) {
      this.pipelineId = rerunTektonPipelineRunOptions.pipelineId;
      this.id = rerunTektonPipelineRunOptions.id;
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
     * @param id the id
     */
    public Builder(String pipelineId, String id) {
      this.pipelineId = pipelineId;
      this.id = id;
    }

    /**
     * Builds a RerunTektonPipelineRunOptions.
     *
     * @return the new RerunTektonPipelineRunOptions instance
     */
    public RerunTektonPipelineRunOptions build() {
      return new RerunTektonPipelineRunOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the RerunTektonPipelineRunOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the RerunTektonPipelineRunOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected RerunTektonPipelineRunOptions() { }

  protected RerunTektonPipelineRunOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    pipelineId = builder.pipelineId;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a RerunTektonPipelineRunOptions builder
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
   * Gets the id.
   *
   * ID of current instance.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

