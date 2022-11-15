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
 * The getTektonPipelineRunLogContent options.
 */
public class GetTektonPipelineRunLogContentOptions extends GenericModel {

  protected String pipelineId;
  protected String pipelineRunId;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String pipelineRunId;
    private String id;

    /**
     * Instantiates a new Builder from an existing GetTektonPipelineRunLogContentOptions instance.
     *
     * @param getTektonPipelineRunLogContentOptions the instance to initialize the Builder with
     */
    private Builder(GetTektonPipelineRunLogContentOptions getTektonPipelineRunLogContentOptions) {
      this.pipelineId = getTektonPipelineRunLogContentOptions.pipelineId;
      this.pipelineRunId = getTektonPipelineRunLogContentOptions.pipelineRunId;
      this.id = getTektonPipelineRunLogContentOptions.id;
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
     * @param pipelineRunId the pipelineRunId
     * @param id the id
     */
    public Builder(String pipelineId, String pipelineRunId, String id) {
      this.pipelineId = pipelineId;
      this.pipelineRunId = pipelineRunId;
      this.id = id;
    }

    /**
     * Builds a GetTektonPipelineRunLogContentOptions.
     *
     * @return the new GetTektonPipelineRunLogContentOptions instance
     */
    public GetTektonPipelineRunLogContentOptions build() {
      return new GetTektonPipelineRunLogContentOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the GetTektonPipelineRunLogContentOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the pipelineRunId.
     *
     * @param pipelineRunId the pipelineRunId
     * @return the GetTektonPipelineRunLogContentOptions builder
     */
    public Builder pipelineRunId(String pipelineRunId) {
      this.pipelineRunId = pipelineRunId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetTektonPipelineRunLogContentOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected GetTektonPipelineRunLogContentOptions() { }

  protected GetTektonPipelineRunLogContentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineRunId,
      "pipelineRunId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    pipelineId = builder.pipelineId;
    pipelineRunId = builder.pipelineRunId;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a GetTektonPipelineRunLogContentOptions builder
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
   * Gets the pipelineRunId.
   *
   * The Tekton pipeline run ID.
   *
   * @return the pipelineRunId
   */
  public String pipelineRunId() {
    return pipelineRunId;
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

