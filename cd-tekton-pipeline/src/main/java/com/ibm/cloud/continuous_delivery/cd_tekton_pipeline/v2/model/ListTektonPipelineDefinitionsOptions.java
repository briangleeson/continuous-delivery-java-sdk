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
 * The listTektonPipelineDefinitions options.
 */
public class ListTektonPipelineDefinitionsOptions extends GenericModel {

  protected String pipelineId;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;

    /**
     * Instantiates a new Builder from an existing ListTektonPipelineDefinitionsOptions instance.
     *
     * @param listTektonPipelineDefinitionsOptions the instance to initialize the Builder with
     */
    private Builder(ListTektonPipelineDefinitionsOptions listTektonPipelineDefinitionsOptions) {
      this.pipelineId = listTektonPipelineDefinitionsOptions.pipelineId;
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
     * Builds a ListTektonPipelineDefinitionsOptions.
     *
     * @return the new ListTektonPipelineDefinitionsOptions instance
     */
    public ListTektonPipelineDefinitionsOptions build() {
      return new ListTektonPipelineDefinitionsOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ListTektonPipelineDefinitionsOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }
  }

  protected ListTektonPipelineDefinitionsOptions() { }

  protected ListTektonPipelineDefinitionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
  }

  /**
   * New builder.
   *
   * @return a ListTektonPipelineDefinitionsOptions builder
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
}

