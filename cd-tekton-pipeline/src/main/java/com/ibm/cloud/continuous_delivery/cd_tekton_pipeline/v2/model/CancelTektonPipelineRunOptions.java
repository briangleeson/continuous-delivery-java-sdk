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
 * The cancelTektonPipelineRun options.
 */
public class CancelTektonPipelineRunOptions extends GenericModel {

  protected String pipelineId;
  protected String id;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String id;
    private Boolean force;

    /**
     * Instantiates a new Builder from an existing CancelTektonPipelineRunOptions instance.
     *
     * @param cancelTektonPipelineRunOptions the instance to initialize the Builder with
     */
    private Builder(CancelTektonPipelineRunOptions cancelTektonPipelineRunOptions) {
      this.pipelineId = cancelTektonPipelineRunOptions.pipelineId;
      this.id = cancelTektonPipelineRunOptions.id;
      this.force = cancelTektonPipelineRunOptions.force;
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
     * Builds a CancelTektonPipelineRunOptions.
     *
     * @return the new CancelTektonPipelineRunOptions instance
     */
    public CancelTektonPipelineRunOptions build() {
      return new CancelTektonPipelineRunOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the CancelTektonPipelineRunOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CancelTektonPipelineRunOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the CancelTektonPipelineRunOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected CancelTektonPipelineRunOptions() { }

  protected CancelTektonPipelineRunOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    pipelineId = builder.pipelineId;
    id = builder.id;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a CancelTektonPipelineRunOptions builder
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

  /**
   * Gets the force.
   *
   * Flag whether force cancel.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

